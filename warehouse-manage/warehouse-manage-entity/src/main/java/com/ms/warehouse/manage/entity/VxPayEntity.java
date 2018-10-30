package com.ms.warehouse.manage.entity;

import com.ms.warehouse.common.entity.BaseEntity;

public class VxPayEntity extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String appId;
	private String timeStamp;
	private String nonceStr;
	private String packageA;
	private String signType;
	private String paySign;
	private String openId;
	
	private Long activitId;
	private String fx;
	private String username;
	private String userPhone;
	
	
	@Override
	public String toString() {
		return "VxPayEntity [appId=" + appId + ", timeStamp=" + timeStamp + ", nonceStr=" + nonceStr + ", packageA="
				+ packageA + ", signType=" + signType + ", paySign=" + paySign + ", openId=" + openId + ", activitId="
				+ activitId + "]";
	}
	
	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getUserPhone() {
		return userPhone;
	}



	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}



	public String getFx() {
		return fx;
	}

	public void setFx(String fx) {
		this.fx = fx;
	}

	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public Long getActivitId() {
		return activitId;
	}
	public void setActivitId(Long activitId) {
		this.activitId = activitId;
	}
	public String getPaySign() {
		return paySign;
	}
	public void setPaySign(String paySign) {
		this.paySign = paySign;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getNonceStr() {
		return nonceStr;
	}
	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}
	public String getPackageA() {
		return packageA;
	}
	public void setPackageA(String packageA) {
		this.packageA = packageA;
	}
	public String getSignType() {
		return signType;
	}
	public void setSignType(String signType) {
		this.signType = signType;
	}
	
	
}
