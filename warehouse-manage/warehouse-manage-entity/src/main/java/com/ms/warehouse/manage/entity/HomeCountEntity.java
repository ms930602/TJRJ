package com.ms.warehouse.manage.entity;

import com.ms.warehouse.common.entity.BaseEntity;

public class HomeCountEntity extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String materName;
	private String materCode;
	private String subverName;
	private String sumActualCountQuality;
	
	private String floorAreaCode;
	private String status;
	private Long countQuality;
	
	
	public String getFloorAreaCode() {
		return floorAreaCode;
	}
	public void setFloorAreaCode(String floorAreaCode) {
		this.floorAreaCode = floorAreaCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getCountQuality() {
		return countQuality;
	}
	public void setCountQuality(Long countQuality) {
		this.countQuality = countQuality;
	}
	public String getMaterName() {
		return materName;
	}
	public void setMaterName(String materName) {
		this.materName = materName;
	}
	public String getMaterCode() {
		return materCode;
	}
	public void setMaterCode(String materCode) {
		this.materCode = materCode;
	}
	public String getSubverName() {
		return subverName;
	}
	public void setSubverName(String subverName) {
		this.subverName = subverName;
	}
	public String getSumActualCountQuality() {
		return sumActualCountQuality;
	}
	public void setSumActualCountQuality(String sumActualCountQuality) {
		this.sumActualCountQuality = sumActualCountQuality;
	}
	
	
}
