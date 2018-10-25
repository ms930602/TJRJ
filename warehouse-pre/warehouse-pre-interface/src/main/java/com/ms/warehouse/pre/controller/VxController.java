package com.ms.warehouse.pre.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.ms.warehouse.pre.utils.WXAuthUtil;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Controller
@RequestMapping("vx/info")
public class VxController{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "wxLogin")
	public String wxLogin(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		String backUrl="http://msserver.nat300.top/warehouse-pre-interface/vx/info/callBack";
		// 第一步：用户同意授权，获取code
		StringBuilder url = new StringBuilder("https://open.weixin.qq.com/connect/oauth2/authorize?appid=");
		url.append(WXAuthUtil.APPID);
		url.append("&redirect_uri=");
		url.append(URLEncoder.encode(backUrl,"GBK"));
		url.append("&response_type=code");
		url.append("&scope=snsapi_userinfo");
		url.append("&state=STATE#wechat_redirect");
		logger.info("forward重定向地址{" + url.toString() + "}");
		return "redirect:"+url.toString();
	}
	
	@RequestMapping(value = "callBack")
	public String callBack(ModelMap modelMap,HttpServletRequest req, HttpServletResponse resp) throws ClientProtocolException, IOException {
		//start 获取微信用户基本信息
		String code =req.getParameter("code");
		//第二步：通过code换取网页授权access_token
		StringBuilder url = new StringBuilder("https://api.weixin.qq.com/sns/oauth2/access_token?appid=");
		url.append(WXAuthUtil.APPID);
		url.append("&secret=");
		url.append(WXAuthUtil.APPSECRET);
		url.append("&code=");
		url.append(code);
		url.append("&grant_type=authorization_code");
		
		System.err.println("url:"+url);
		
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
		System.out.println(chickuserInfo.toString());
		if(!"0".equals(chickuserInfo.getString("errcode"))){
			// 第三步：刷新access_token（如果需要）-----暂时没有使用
			String refreshTokenUrl="https://api.weixin.qq.com/sns/oauth2/refresh_token?appid="+openid+"&grant_type=refresh_token&refresh_token="+refresh_token;
			JSONObject refreshInfo = WXAuthUtil.doGetJson(chickUrl);
			/*
			 * { "access_token":"ACCESS_TOKEN",
			 * "expires_in":7200,
			 * "refresh_token":"REFRESH_TOKEN",
			 * "openid":"OPENID",
			 * "scope":"SCOPE" 
			 * }
			 */
			System.err.println("刷新access_token:"+refreshInfo.toString());
			access_token=refreshInfo.getString("access_token");
		}
		// 第四步：拉取用户信息(需scope为 snsapi_userinfo)
		String infoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token="+access_token
				+ "&openid="+openid
				+ "&lang=zh_CN";
		JSONObject userInfo = WXAuthUtil.doGetJson(infoUrl);
		System.out.println("JSON-----"+userInfo.toString());
		System.out.println("名字-----"+userInfo.getString("nickname"));
		System.out.println("头像-----"+userInfo.getString("headimgurl"));
		//end 获取微信用户基本信息
		return "redirect:"+url.toString();
	}
	
}