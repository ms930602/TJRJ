package com.ms.warehouse.pre.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.security.KeyStore;
import java.util.Date;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;

import javax.net.ssl.SSLContext;

import org.apache.bcel.generic.NEW;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.ibm.icu.text.SimpleDateFormat;

public class VxRedPackUtil {
	

	public static void main(String args[]){
		try {
			int iMin = 1000;
            Random rd = new Random(8999);//构造随机数
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String strMch_billno = sdf.format(new Date()) + (rd.nextInt() + iMin);
			String MHCname = "商户名称";
			String price = "100"; //价格
			sendRedPack(strMch_billno,
					"接收者的openid",
					MHCname,price,"1",
					"返现提成,祝您愉快!","提成红包","谢谢您的推广!","127.0.0.1");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void sendRedPack(String mch_billno,String openId,
			String send_name,String total_fee,
			String total_num,String wishing,
			String act_name,String remark,String ip) throws Exception{
		String non=WXAuthUtil.CreateNoncestr();
		SortedMap<Object, Object> p = new TreeMap<Object, Object>();
		p.put("nonce_str", non);
		p.put("mch_billno", mch_billno);
		p.put("mch_id", WXAuthUtil.MCH_ID);
		p.put("wxappid", WXAuthUtil.APPID);
		p.put("re_openid", openId);
		p.put("total_amount", total_fee);
		p.put("total_num", "1");
		p.put("client_ip", ip);
		p.put("act_name",act_name);
		p.put("send_name", send_name);
		p.put("wishing", wishing);
		p.put("remark",remark);
		
		
 
		String sign = WXAuthUtil.createSign(p);
		System.out.println(sign);
		p.put("sign", sign);
		
		
		String reuqestXml = WXAuthUtil.getRequestXml(p);
		System.out.println(reuqestXml);
		KeyStore keyStore = KeyStore.getInstance("PKCS12");
		FileInputStream instream = new FileInputStream(new File(WXAuthUtil.CERT_PATH));
		try {
			keyStore.load(instream, WXAuthUtil.MCH_ID.toCharArray());
		} finally {
			instream.close();
		}
 
		SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore,
				WXAuthUtil.MCH_ID.toCharArray()).build();
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
				sslcontext, new String[] { "TLSv1" }, null,
				SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
		CloseableHttpClient httpclient = HttpClients.custom()
				.setSSLSocketFactory(sslsf).build();
		try {
 
			HttpPost httpPost = new HttpPost("https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack");// 退款接口
			
			httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			
			System.out.println("executing request" + httpPost.getRequestLine());
			//请求的xml需转码为iso8859-1编码，否则易出现签名错误或红包上的文字显示有误
			StringEntity reqEntity = new StringEntity(new String(reuqestXml.getBytes(), "ISO8859-1"));
			// 设置类型
		
			httpPost.setEntity(reqEntity);
			CloseableHttpResponse response = httpclient.execute(httpPost);
			try {
				HttpEntity entity = response.getEntity();
 
				System.out.println("----------------------------------------");
				System.out.println(response.getStatusLine());
				if (entity != null) {
					System.out.println("Response content length: "
							+ entity.getContentLength());
					BufferedReader bufferedReader = new BufferedReader(
							new InputStreamReader(entity.getContent(), "UTF-8"));
					String text;
					while ((text = bufferedReader.readLine()) != null) {
						System.out.println(text);
					}
 
				}
				EntityUtils.consume(entity);
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
	}
}
