package com.ms.warehouse.manage.entity;

import java.util.List;

import com.ms.warehouse.common.entity.BaseEntity;

public class HomeWarningEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<HomeWarningDetailEntity> one;
	private List<HomeWarningDetailEntity> two;
	private List<HomeWarningDetailEntity> three;
	
	public HomeWarningEntity(List<HomeWarningDetailEntity> one, List<HomeWarningDetailEntity> two,
			List<HomeWarningDetailEntity> three) {
		super();
		this.one = one;
		this.two = two;
		this.three = three;
	}
	public HomeWarningEntity() {
		super();
	}
	public List<HomeWarningDetailEntity> getOne() {
		return one;
	}
	public void setOne(List<HomeWarningDetailEntity> one) {
		this.one = one;
	}
	public List<HomeWarningDetailEntity> getTwo() {
		return two;
	}
	public void setTwo(List<HomeWarningDetailEntity> two) {
		this.two = two;
	}
	public List<HomeWarningDetailEntity> getThree() {
		return three;
	}
	public void setThree(List<HomeWarningDetailEntity> three) {
		this.three = three;
	}
	
}
