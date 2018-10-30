package com.ms.warehouse.manage.entity;

import java.util.List;

import com.ms.warehouse.common.entity.BaseEntity;

public class VxSDKEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean debug = true ; // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
	private String appId; // 必填，公众号的唯一标识
	private Long   timestamp; // 必填，生成签名的时间戳
	private String nonceStr; // 必填，生成签名的随机串
	private String signature;// 必填，签名
	private List<String> jsApiList; // 必填，需要使用的JS接口列表
	
	
	@Override
	public String toString() {
		return "VxSDKEntity [debug=" + debug + ", appId=" + appId + ", timestamp=" + timestamp + ", nonceStr="
				+ nonceStr + ", signature=" + signature + ", jsApiList=" + jsApiList + "]";
	}
	public boolean isDebug() {
		return debug;
	}
	public void setDebug(boolean debug) {
		this.debug = debug;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	public String getNonceStr() {
		return nonceStr;
	}
	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public List<String> getJsApiList() {
		return jsApiList;
	}
	public void setJsApiList(List<String> jsApiList) {
		this.jsApiList = jsApiList;
	}
	
	
}
