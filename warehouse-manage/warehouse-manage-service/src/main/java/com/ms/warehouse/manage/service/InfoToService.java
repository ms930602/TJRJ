package com.ms.warehouse.manage.service;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ms.warehouse.common.exception.CenterException;
import com.ms.warehouse.common.service.BaseService;
import com.ms.warehouse.common.vo.BaseRespVO;
import com.ms.warehouse.common.vo.Param;
import com.ms.warehouse.common.vo.ValueRespVO;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;
import com.ms.warehouse.manage.bo.VxActivitiesBO;
import com.ms.warehouse.manage.bo.VxBuyInfoBO;
import com.ms.warehouse.manage.bo.VxMerchantBO;
import com.ms.warehouse.manage.bo.VxPromotersBO;
import com.ms.warehouse.manage.entity.ParseXMLUtils;
import com.ms.warehouse.manage.entity.VxActivitiesEntity;
import com.ms.warehouse.manage.entity.VxActivitiesFormEntity;
import com.ms.warehouse.manage.entity.VxBuyInfoEntity;
import com.ms.warehouse.manage.entity.VxFormEntity;
import com.ms.warehouse.manage.entity.VxPayEntity;
import com.ms.warehouse.manage.entity.VxPromotersEntity;
import com.ms.warehouse.manage.entity.WXAuthUtil;

import cn.hutool.setting.dialect.Props;
@Service
public class InfoToService  extends BaseService {
	
	@Autowired
	private VxActivitiesService activitiesService;
	
	@Autowired
	private VxActivitiesBO activitiesBo;
	
	@Autowired
	private VxPromotersBO promotersBO;
	
	@Autowired
	private VxMerchantBO merchantBO;
	
	@Autowired
	private VxBuyInfoBO buyInfoBO;
	
	public Object getVxInfo(@Param("id") Long id) throws CenterException {
		VxFormEntity vfe = null;
		VxActivitiesFormEntity formEntity = (VxActivitiesFormEntity) activitiesService.queryById(id);
		if(formEntity == null) return null;
		//活动基本信息
		vfe = new VxFormEntity(formEntity);
		
		//推广员 start
		ListReqVO<VxPromotersEntity> reqVO = new ListReqVO<VxPromotersEntity>();
		reqVO.setPageNum(1);
		reqVO.setPageSize(20);
		reqVO.setOrderField("f_ext_num");
		ListRespVO queryPageAutomatic = promotersBO.queryPageAutomatic(reqVO);
		List<VxPromotersEntity> aaData = queryPageAutomatic.getAaData();
		vfe.setMerchant(merchantBO.queryById(formEntity.getMerchantId()));;
		if(aaData != null && aaData.size() > 0){
			List<Map<String, String>> promtersList = new ArrayList<>();
			Map<String, String> info = null;
			for (VxPromotersEntity temp : aaData) {
				info = new HashMap<String, String>();
				info.put("Nickname", temp.getNickname());
				info.put("headimgurl", temp.getHeadimgurl());
				info.put("extNum", temp.getExtNum().toString());
				promtersList.add(info);
			}
			vfe.setPromtersList(promtersList);
		}
		//推广员 end
		return vfe;
	}
	
	public Object queryPaySign(VxPayEntity parseObject) throws CenterException, NoSuchAlgorithmException, UnsupportedEncodingException {
		if(parseObject == null || parseObject.getActivitId() == null)
			return new BaseRespVO(99, "参数不合法!!");
		VxActivitiesEntity queryById = activitiesBo.queryById(parseObject.getActivitId());
		String username = parseObject.getUsername();
		String userPhone = parseObject.getUserPhone();
		String openId = parseObject.getOpenId();
		String fx = parseObject.getFx();
		
		if(queryById == null){
			return new BaseRespVO(99, "活动以结束!");
		}
		
		if(username == null || "".equals(username.trim())){
			return new BaseRespVO(99, "姓名不能为空!");
		}
		if(userPhone == null || "".equals(userPhone.trim())){
			return new BaseRespVO(99, "手机号不能为空!");
		}
		//创建购买人信息
		VxBuyInfoEntity buyInfoEntity = new VxBuyInfoEntity();
		buyInfoEntity.setData(openId);
		buyInfoEntity.setName(username);
		buyInfoEntity.setPhone(userPhone);
		buyInfoEntity.setStatus("0");
		buyInfoEntity.setMoney(queryById.getPrice());
		if(fx != null && "".equals(fx.trim()))
			buyInfoEntity.setPromotersData(fx);
		
		int intValue = queryById.getPrice().intValue();
		Props PathProps = new Props("pathConf.properties");
		String urlPath =PathProps.getProperty("file.vx.pay.ok.path");
		String ip =PathProps.getProperty("file.vx.pay.red.ip");
		
		String orderNo=WXAuthUtil.APPID+System.currentTimeMillis();//随机生成了一个订单号
		
		String strReq = WXAuthUtil.CreateNoncestr();
		
		 //商户号
        String mch_id = WXAuthUtil.MCH_ID;

        //随机数 
        String nonce_str = strReq;

        //商品描述
        String body = "活动商品";

        //附加数据
        String attach = "基本商品信息";

        //商户订单号
        String out_trade_no = orderNo;

        //总金额以分为单位，不带小数点
        int total_fee = intValue;

        //订单生成的机器 IP
        String spbill_create_ip = ip;

        //支付完成后微信发给该链接信息，可以判断会员是否支付成功，改变订单状态等：http://*/weChatpay/notifyServlet
        String notify_url =urlPath;

        String trade_type = "JSAPI";

        String openid = openId;
        
        //获取sign（统一下单接口签名）
        //第一步，设所有发送或者接收到的数据为集合M，将集合M内非空参数值的参数按照参数名ASCII码从小到大排序（字典序），
        //使用URL键值对的格式（即key1=value1&key2=value2…）拼接成字符串stringA。
        //第二步，在stringA最后拼接上key得到stringSignTemp字符串，并对stringSignTemp进行MD5运算，
        //再将得到的字符串所有字符转换为大写，得到sign值signValue。
        SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
        packageParams.put("appid", WXAuthUtil.APPID);  
        packageParams.put("mch_id", mch_id);
        packageParams.put("nonce_str", nonce_str);  
        packageParams.put("body", body);  
        packageParams.put("attach", attach);  
        packageParams.put("out_trade_no", out_trade_no);  
        packageParams.put("total_fee", intValue + "");  
        packageParams.put("spbill_create_ip", spbill_create_ip);  
        packageParams.put("notify_url", notify_url);  
        packageParams.put("trade_type", trade_type);  
        packageParams.put("openid", openid);
        
		String sign = WXAuthUtil.createSign(packageParams);
		System.out.println(sign);
		packageParams.put("sign", sign);
		
		
		String reuqestXml = WXAuthUtil.getRequestXml(packageParams);

        
        
		//统一下单接口携带参数（xml格式），接口地址https://api.mch.weixin.qq.com/pay/unifiedorder
      //请求微信统一下单接口，成功后返回预支付交易会话标识prepay_id
        String createOrderURL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
        String prepay_id = "";
        try {
        	String doPostXml = WXAuthUtil.doPostXml(createOrderURL,reuqestXml);
        	SAXReader saxReader = new SAXReader();
            Document document;
            try {
                document = saxReader.read(new ByteArrayInputStream(doPostXml.getBytes()));
                Map map = ParseXMLUtils.Dom2Map(document);
                
                if("FAIL".equals(map.get("return_code"))){
                	return new BaseRespVO(99, "统一支付接口订单出错A!");
                }
                prepay_id = map.get("prepay_id") + "";
            } catch (DocumentException e) {
                e.printStackTrace();
            }
            if(prepay_id.equals("")){
            	return new BaseRespVO(99, "统一支付接口订单出错B!"); 
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        
      //生成H5调起微信支付API相关参数（前端页面js的配置参数）
        String timestamp = System.currentTimeMillis()+"";//当前时间的时间戳
        String packages = "prepay_id="+prepay_id;;//订单详情扩展字符串
        
		SortedMap<Object, Object> p = new TreeMap<Object, Object>();
		p.put("appId", WXAuthUtil.APPID);
		p.put("nonceStr", strReq);
		p.put("package", packages);
		p.put("signType", "MD5");
		p.put("timeStamp", timestamp);
		
		ValueRespVO valueRespVO = new ValueRespVO(0,"成功");
		
		VxPayEntity reqEntity = new VxPayEntity();
        reqEntity.setAppId(WXAuthUtil.APPID);
        reqEntity.setNonceStr(strReq);
        reqEntity.setPackageA(packages);
        reqEntity.setSignType("MD5");
        reqEntity.setTimeStamp(timestamp);
        reqEntity.setPaySign(WXAuthUtil.createSign(p));
        
      //查看是否已有未支付订单
  		VxBuyInfoEntity querybuyInfoEntity = new VxBuyInfoEntity();
  		querybuyInfoEntity.setData(buyInfoEntity.getData());
  		querybuyInfoEntity.setStatus("0");
  		List<VxBuyInfoEntity> queryListByEntity = buyInfoBO.queryListByEntity(querybuyInfoEntity);
  		if(queryListByEntity != null && queryListByEntity.size() > 0){
  			Long [] ids = new Long[queryListByEntity.size()];
  			for (int i = 0; i < queryListByEntity.size(); i++) {
  				ids[i] = queryListByEntity.get(i).getId();
  			}
  			buyInfoBO.batchDeleteById(ids);
  		}
  		buyInfoBO.create(buyInfoEntity);
		valueRespVO.setAaData(reqEntity);
		return valueRespVO;
	}
	
	public Object index(VxBuyInfoEntity entity){
		if(entity == null || entity.getActivitiesId() == null){
			return new BaseRespVO(99, "参数不合法！");
		}
		VxActivitiesEntity queryById = activitiesBo.queryById(entity.getActivitiesId());
		if(queryById == null){
			return new BaseRespVO(99, "参数不合法!");
		}
		
		entity.setBuyTime(new Date());
		entity.setMoney(queryById.getPrice());
		
		
		return new BaseRespVO();
	}
}
