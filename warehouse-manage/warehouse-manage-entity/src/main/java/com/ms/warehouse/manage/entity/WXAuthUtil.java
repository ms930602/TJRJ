package com.ms.warehouse.manage.entity;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ms.warehouse.common.encrypt.MD5Util;
import org.apache.http.NameValuePair; 

public class WXAuthUtil {
	private static Logger logger = LoggerFactory.getLogger(WXAuthUtil.class);
	  public static final String APPID="wxc14367247581cf15";
	  public static final String APPSECRET ="c7dd7f638d41cdaeb869f75cb646e7c8";
	  public static final String TOKEN ="wuyang";
	  
	  //商户
	  public static final String MCH_ID = "1484402522";
	  public static final String API_KEY = "50998dfbb1c7ea142e68caedb9a3697b";//注：key为商户平台设置的密钥key
	  //public static final String CERT_PATH = "F:\\cert\\cert.p12";//证书
	  
	  
	  public static String CreateNoncestr(){
		 return UUID.randomUUID().toString().substring(0, 20);
	  }
	  
	  public static String createJSDKSign(SortedMap<Object,Object> parameters) throws NoSuchAlgorithmException, UnsupportedEncodingException{
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
			sb.delete(sb.length()-1, sb.length());
			//设置微信商户平台上的秘钥
			System.out.println(sb.toString());
			String sign =DigestUtils.sha1Hex(sb.toString().getBytes());
			System.err.println("JSSDK:"+sign);
			return sign;
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
	  
	  private static List<NameValuePair> createParam(Map<String, Object> param) {
        //建立一个NameValuePair数组，用于存储欲传送的参数
        List<NameValuePair> nvps = new ArrayList <NameValuePair>();
        if(param != null) {
            for(String k : param.keySet()) {
                nvps.add(new BasicNameValuePair(k, param.get(k).toString()));
            }
        }
        return nvps;
	  }
  
	  public static JSONObject doPostJson(String url,Map<String, Object> param) throws ClientProtocolException, IOException {
	    JSONObject jsonObject =null;
	    CloseableHttpClient httpClient = HttpClients.createDefault();
	    HttpPost httpPost = new HttpPost(url);
	    HttpEntity paramEntity=null;
	    paramEntity=new UrlEncodedFormEntity(createParam(param), Consts.UTF_8);
	    httpPost.setEntity(paramEntity);
	    HttpResponse response = httpClient.execute(httpPost);
	    System.err.println("========HttpResponseProxy：========"+response.getStatusLine());
	    HttpEntity entity =response.getEntity();
	    
	    if(entity!=null)
	    {
	      //把返回的结果转换为JSON对象
	      String result =EntityUtils.toString(entity, "UTF-8");
	      jsonObject =JSON.parseObject(result);
	      logger.info("========接口doPostJson返回=======" +result);
	    }
	    return jsonObject;
	  }
	  
	  public static String doPostXml(String url,String xml) throws ClientProtocolException, IOException {
		  CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(url);// 退款接口
			
			httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			
			System.out.println("executing request" + httpPost.getRequestLine());
			//请求的xml需转码为iso8859-1编码，否则易出现签名错误或红包上的文字显示有误
			StringEntity reqEntity = new StringEntity(new String(xml.getBytes(), "ISO8859-1"));
			// 设置类型
		
			httpPost.setEntity(reqEntity);
			CloseableHttpResponse response = httpClient.execute(httpPost);
				HttpEntity entity = response.getEntity();
 
				//把返回的结果转换为JSON对象
		     String result =EntityUtils.toString(entity, "UTF-8");
//		     jsonObject =JSON.parseObject(result);
		     logger.info("========接口doPostXml返回=======" +result);
			return result;
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
                sb.append("<"+key+">"+"<![CDATA["+value+"]]></"+key+">");  
            }  
            sb.append("</xml>");  
            return sb.toString();
		}
		
		//随机红包  分为单位
		public static String getRedFanPrice(){
			Random rd = new Random();
			int result=rd.nextInt(10);
			if(result == 9){
				int nextInt = rd.nextInt(2);
				int price = (nextInt + 4) * 100;
				return price + "";
			}else{
				int nextInt = rd.nextInt(3);
				int price = (nextInt + 1) * 100;
				return price + "";
			}
		}
}
