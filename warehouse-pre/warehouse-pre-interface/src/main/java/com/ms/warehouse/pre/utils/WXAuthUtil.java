package com.ms.warehouse.pre.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.UUID;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ms.warehouse.common.encrypt.MD5Util;

public class WXAuthUtil {
	  public static final String APPID="wxb851c9b94c481bda";
	  public static final String APPSECRET ="459f65a86d7a4d1abd5b1d673be7f593";
	  private static final String TOKEN = "mscenter20181025";
	  
	  //商户
	  public static final String MCH_ID = "";
	  public static final String API_KEY = "";//注：key为商户平台设置的密钥key
	  public static final String CERT_PATH = "D:\\log.txt";//证书
	  
	  
	  public static String CreateNoncestr(){
		 return UUID.randomUUID().toString().substring(0, 20);
	  }
	  
	  public static JSONObject doGetJson(String url) throws ClientProtocolException, IOException {
	    JSONObject jsonObject =null;
	    CloseableHttpClient httpClient = HttpClients.createDefault();
	    HttpGet httpGet =new HttpGet(url);
	    HttpResponse response = httpClient.execute(httpGet);
	    System.err.println("========HttpResponseProxy：========"+response.getStatusLine());
	    HttpEntity entity =response.getEntity();
	    if(entity!=null)
	    {
	      //把返回的结果转换为JSON对象
	      String result =EntityUtils.toString(entity, "UTF-8");
	      jsonObject =JSON.parseObject(result);
	      System.out.println("========接口返回=======" +result);
	    }
	    return jsonObject;
	  }

	  /**
		 * @Description：sign签名
		 * @param characterEncoding 编码格式
		 * @param parameters 请求参数
		 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
		 */
		public static String createSign(SortedMap<Object,Object> parameters) throws NoSuchAlgorithmException, UnsupportedEncodingException{
			StringBuffer sb = new StringBuffer();
			Set es = parameters.entrySet();//所有参与传参的参数按照accsii排序（升序）
			Iterator it = es.iterator();
			while(it.hasNext()) {
				Map.Entry entry = (Map.Entry)it.next();
				String k = (String)entry.getKey();
				Object v = entry.getValue();
				if(null != v && !"".equals(v) 
						&& !"sign".equals(k) && !"key".equals(k)) {
					sb.append(k + "=" + v + "&");
				}
			}
			//设置微信商户平台上的秘钥
			sb.append("key=" + WXAuthUtil.API_KEY);
			System.out.println(sb.toString());
			String sign = MD5Util.MD5Encode(sb.toString(),"UTF-8").toUpperCase();
			return sign;
		}
		
		public static String getRequestXml(SortedMap<Object,Object> parameters){
			StringBuffer sb = new StringBuffer();  
            sb.append("<xml>");  
            Set es = parameters.entrySet();  
            Iterator it = es.iterator();  
            while(it.hasNext()) {  
                Map.Entry entry = (Map.Entry)it.next();  
                String key = (String)entry.getKey();  
                String value = (String)entry.getValue();  
                if ("attach".equalsIgnoreCase(key)||"body".equalsIgnoreCase(key)||"sign".equalsIgnoreCase(key)) {  
                    sb.append("<"+key+">"+"<![CDATA["+value+"]]></"+key+">");  
                }else {  
                    sb.append("<"+key+">"+value+"</"+key+">");  
                }  
            }  
            sb.append("</xml>");  
            return sb.toString();
		}
}
