package com.ms.warehouse.inventory.entity;

import java.util.List;

/**
 * 盘点表单对象实体
 * @author MS
 *
 */
public class StockcheckFormEntity extends StockcheckmainEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<StockcheckdetailEntity> detail;
	
	private Long [] deleteObj;
	
	public Long[] getDeleteObj() {
		return deleteObj;
	}

	public void setDeleteObj(Long[] deleteObj) {
		this.deleteObj = deleteObj;
	}

	public List<StockcheckdetailEntity> getDetail() {
		return detail;
	}

	public void setDetail(List<StockcheckdetailEntity> detail) {
		this.detail = detail;
	}

	public void copyObject(StockcheckmainEntity temp) {
		/** 自增id. */
		this.setId(temp.getId());
		
		/** 盘点单号. */
		this.setOrderNumber(temp.getOrderNumber());
		
		/** 盘点方式0全面盘点1抽样盘点. */
		this.setInventMethod(temp.getInventMethod());
		
		/** 盘点人. */
		this.setInventor(temp.getInventor());
		
		/** 盘点开始时间. */
		this.setInventStartDate(temp.getInventStartDate());
		
		/** 盘点结束时间. */
		this.setInventEndDate(temp.getInventEndDate());
		
		/** 状态 0草稿1 已确认2已完成. */
		this.setStatus(temp.getStatus());
		
		/** 是否复盘 1：是 0 否. */
		this.setReversion(temp.getReversion());
		
		/** 创建时间. */
		this.setCreatedDate(temp.getCreatedDate());
		
		/** 创建人id. */
		this.setCreatedPersonId(temp.getCreatedPersonId());
		
		/** 创建人. */
		this.setCreatedPerson(temp.getCreatedPerson());
		
		/** 更新时间. */
		this.setUpdatedDate(temp.getUpdatedDate());
		
		/** 更新人id. */
		this.setUpdatedPersonId(temp.getUpdatedPersonId());
		
		/** 修改人. */
		this.setUpdatedPerson(temp.getUpdatedPerson());
		
		/** 备注. */
		this.setRemark(temp.getRemark());
	}
	
	
}
