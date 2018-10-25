package com.ms.warehouse.pre.utils;

import java.io.IOException;
import java.util.Arrays;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.util.DigestUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class WXAuthUtil {
	  public static final String APPID="wxb851c9b94c481bda";
	  public static final String APPSECRET ="459f65a86d7a4d1abd5b1d673be7f593";
	  private static final String TOKEN = "mscenter20181025";
	  
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
}
