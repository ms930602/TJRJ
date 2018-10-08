package com.ms.warehouse.manage.entity;

import java.util.Date;

import com.ms.warehouse.common.entity.BaseEntity;

public class HomeWarningDetailEntity extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date days;
	private Long counts;
	private int warningType;
	public Date getDays() {
		return days;
	}
	public void setDays(Date days) {
		this.days = days;
	}
	public Long getCounts() {
		return counts;
	}
	public void setCounts(Long counts) {
		this.counts = counts;
	}
	public int getWarningType() {
		return warningType;
	}
	public void setWarningType(int warningType) {
		this.warningType = warningType;
	}
	
	
}
