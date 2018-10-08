package com.ms.warehouse.manage.entity;

import java.util.List;
import java.util.Set;

import com.ms.warehouse.common.entity.BaseEntity;

public class LocationinfoAllEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Long> kongXian;
	private List<Long> zhanYong;
	private Set<String> xTitle;
	private List<HomeCountEntity> dataList;
	
	public List<HomeCountEntity> getDataList() {
		return dataList;
	}
	public void setDataList(List<HomeCountEntity> dataList) {
		this.dataList = dataList;
	}
	public Set<String> getxTitle() {
		return xTitle;
	}
	public void setxTitle(Set<String> xTitle) {
		this.xTitle = xTitle;
	}
	public List<Long> getKongXian() {
		return kongXian;
	}
	public void setKongXian(List<Long> kongXian) {
		this.kongXian = kongXian;
	}
	public List<Long> getZhanYong() {
		return zhanYong;
	}
	public void setZhanYong(List<Long> zhanYong) {
		this.zhanYong = zhanYong;
	}
	
	
}
