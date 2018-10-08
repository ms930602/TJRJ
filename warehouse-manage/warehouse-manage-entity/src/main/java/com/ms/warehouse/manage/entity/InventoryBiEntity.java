package com.ms.warehouse.manage.entity;

import com.ms.warehouse.common.entity.BaseEntity;

public class InventoryBiEntity extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int status;
	private String statusSum;
	private String materName;
    private String sum;
	public String getMaterName() {
		return materName;
	}
	public void setMaterName(String materName) {
		this.materName = materName;
	}
	public String getSum() {
		return sum;
	}
	public void setSum(String sum) {
		this.sum = sum;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getStatusSum() {
		return statusSum;
	}
	public void setStatusSum(String statusSum) {
		this.statusSum = statusSum;
	}
	
}
