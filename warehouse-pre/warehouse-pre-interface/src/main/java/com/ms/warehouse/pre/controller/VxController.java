package com.ms.warehouse.pre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.dubbo.common.utils.IOUtils;
import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.ms.warehouse.IVxService;
import com.ms.warehouse.common.vo.ValueRespVO;
import com.ms.warehouse.manage.entity.ParseXMLUtils;
import com.ms.warehouse.manage.entity.VxSDKEntity;
import com.ms.warehouse.pre.utils.Utils;
import com.ms.warehouse.pre.utils.WXAuthUtil;

import redis.clients.jedis.Jedis;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.ClientProtocolException;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Controller
@RequestMapping("vx/info")
public class VxController{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	IVxService vxService;
	

    @Autowired
    @Qualifier("jedisConnectionFactory")
    private JedisConnectionFactory jedisConnectionFactory;

	
	@RequestMapping(value = "wxJSDK")
	public void wxJSDK(HttpServletRequest request,HttpServletResponse response) throws ClientProtocolException, IOException, NoSuchAlgorithmException{
		String url = request.getParameter("url");
		
        String access_token = "";
        
        JedisConnection jedisConnection = jedisConnectionFactory.getConnection();
        Jedis jedis = jedisConnection.getNativeConnection();
      //根据token从redis中查询用户信息
        String ticket = jedis.get("jsapi_ticket");
  	   //判断是否为空
  	   if (StringUtils.isBlank(ticket)) {//需要重新获取
  		   System.err.println("重新请求access_token");
  		 String str = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&";
         str += "appid=" + WXAuthUtil.APPID + "&secret=" + WXAuthUtil.APPSECRET;
         JSONObject tokenJson = WXAuthUtil.doGetJson(str);
         access_token = tokenJson.get("access_token")+"";
         String jsapiTicket = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+access_token+"&type=jsapi";
         JSONObject doGetJson = WXAuthUtil.doGetJson(jsapiTicket);
         ticket = doGetJson.getString("ticket");
         boolean keyExist = jedis.exists("jsapi_ticket");
         if (keyExist) {
        	 jedis.del("jsapi_ticket");
         }
      
         // NX是不存在时才set， XX是存在时才set， EX是秒，PX是毫秒
         jedis.set("jsapi_ticket", ticket);
         jedis.expire("jsapi_ticket",7000); 
  	   }else{
  		   System.err.println("存在："+ticket);
  	   }
        
		String noncestr = WXAuthUtil.CreateNoncestr();
		Long timestamp = System.currentTimeMillis() / 1000;
		SortedMap<Object,Object> parameters = new TreeMap<Object, Object>();
		parameters.put("noncestr", noncestr);
		parameters.put("jsapi_ticket", ticket);
		parameters.put("timestamp", timestamp);
		parameters.put("url", url);
		String createJSDKSign = WXAuthUtil.createJSDKSign(parameters);
		VxSDKEntity sdkE = new VxSDKEntity();
		sdkE.setAppId(WXAuthUtil.APPID);
		sdkE.setDebug(true);
		sdkE.setNonceStr(noncestr);
		sdkE.setSignature(createJSDKSign);
		sdkE.setTimestamp(timestamp);
		ValueRespVO rvo = new ValueRespVO(sdkE);
		Utils.writeResponesByJsonp(request, response, rvo);
	}
	
	@RequestMapping(value = "wxLogin")
	public String wxLogin(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		String backUrl="http://msserver.nat300.top/warehouse-pre-interface/vx/info/callBack";
		// 第一步：用户同意授权，获取code
		String aid = request.getParameter("gbk");
		String fx = request.getParameter("fx");//返现人的openID
		Long createVxLog = vxService.createVxLog(aid,fx);
		if(createVxLog == null)return "信息错误!";
		StringBuilder url = new StringBuilder("https://open.weixin.qq.com/connect/oauth2/authorize?appid=");
		url.append(WXAuthUtil.APPID);
		url.append("&redirect_uri=");
		url.append(URLEncoder.encode(backUrl,"GBK"));
		url.append("&response_type=code");
		url.append("&scope=snsapi_userinfo");
		url.append("&state=");
		url.append(createVxLog);
		url.append("#wechat_redirect");
		logger.info("forward重定向地址{" + url.toString() + "}");
		return "redirect:"+url.toString();
	}
	
	@RequestMapping(value = "callBack")
	public String callBack(ModelMap modelMap,HttpServletRequest req, HttpServletResponse resp) throws ClientProtocolException, IOException {
		//start 获取微信用户基本信息
		String code =req.getParameter("code");
		String state =req.getParameter("state");
		//第二步：通过code换取网页授权access_token
		StringBuilder url = new StringBuilder("https://api.weixin.qq.com/sns/oauth2/access_token?appid=");
		url.append(WXAuthUtil.APPID);
		url.append("&secret=");
		url.append(WXAuthUtil.APPSECRET);
		url.append("&code=");
		url.append(code);
		url.append("&grant_type=authorization_code");
		
		JSONObject jsonObject = WXAuthUtil.doGetJson(url.toString());
		/*{
		 * "access_token":"ACCESS_TOKEN",
		 * "expires_in":7200,
		 * "refresh_token":"REFRESH_TOKEN",
		 * "openid":"OPENID",
		 * "scope":"SCOPE"
		 * }
		 */
		String openid = jsonObject.getString("openid");
		String access_token = jsonObject.getString("access_token");
		String refresh_token = jsonObject.getString("refresh_token");
		//第五步验证access_token是否失效；展示都不需要
		String chickUrl="https://api.weixin.qq.com/sns/auth?access_token="+access_token+"&openid="+openid;
		JSONObject chickuserInfo = WXAuthUtil.doGetJson(chickUrl);
		if(!"0".equals(chickuserInfo.getString("errcode"))){
			// 第三步：刷新access_token（如果需要）-----暂时没有使用
			String refreshTokenUrl="https://api.weixin.qq.com/sns/oauth2/refresh_token?appid="+openid+"&grant_type=refresh_token&refresh_token="+refresh_token;
			JSONObject refreshInfo = WXAuthUtil.doGetJson(refreshTokenUrl);
			/*
			 * { "access_token":"ACCESS_TOKEN",
			 * "expires_in":7200,
			 * "refresh_token":"REFRESH_TOKEN",
			 * "openid":"OPENID",
			 * "scope":"SCOPE" 
			 * }
			 */
			access_token=refreshInfo.getString("access_token");
		}
		// 第四步：拉取用户信息(需scope为 snsapi_userinfo)
		String infoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token="+access_token
				+ "&openid="+openid
				+ "&lang=zh_CN";
		JSONObject userInfo = WXAuthUtil.doGetJson(infoUrl);
		userInfo.put("logId", state);
		String promotersData = "";
		try {
			if( userInfo.get("openid") == null || userInfo.get("openid") == "" || "null".equals(userInfo.get("openid")))
				return "无法获取您的信息！";
			promotersData = vxService.savePromoters( userInfo );
		} catch (Exception e) {}
		//end 获取微信用户基本信息
		if(promotersData==null) promotersData = "";
		String myUrl = "http://mscenter.nat300.top/vxstatic/vx.html?gbk="+state+"&bbq=xd&fx="+promotersData+"&opo=9584157&cd="+userInfo.get("openid") + "";
		return "redirect:"+myUrl;
	}
	
	@RequestMapping(value = "payabcd")
	public void payStatus(HttpServletRequest request,HttpServletResponse response) throws IOException{
		System.err.println("payabcd");
		BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String body = IOUtils.read(reader);
		
		if(StringUtils.isNotBlank(body)){
			System.err.println("business receive somthing with body :"+body);
		}
    	SAXReader saxReader = new SAXReader();
        Document document;
        String openId = null;
        String return_code = null;
        try {
            document = saxReader.read(new ByteArrayInputStream(body.getBytes()));
            Map map = ParseXMLUtils.Dom2Map(document);
            
            return_code = map.get("return_code") + "";
            openId = map.get("openid") + "";
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        if("SUCCESS".equals(return_code) && openId != null){
        	System.err.println("返回数据 return_code :"+return_code + " |openId:"+openId);
        	vxService.payAction(openId);
        }else{
        	System.err.println("返回数据错误");
        }
        
        response.setContentType("text/xml;charset=UTF-8");
        PrintWriter out = response.getWriter();
		StringBuilder builder = new StringBuilder();
		builder.append("<xml>");
		builder.append("<return_code><![CDATA[SUCCESS]]></return_code>");
		builder.append("<return_msg><![CDATA[OK]]></return_msg>");
		builder.append("</xml>");
		out.println(builder.toString());
		out.flush();
	}
}