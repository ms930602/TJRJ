package com.ms.warehouse.manage.entity;

import java.util.List;

import com.ms.warehouse.inventory.entity.PositionadjustdetailEntity;
import com.ms.warehouse.inventory.entity.PositionadjustmainEntity;

public class PositionadjustFormEntity extends PositionadjustmainEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<PositionadjustdetailEntity> detail;
	
	private Long [] deleteObj;

	public Long[] getDeleteObj() {
		return deleteObj;
	}

	public void setDeleteObj(Long[] deleteObj) {
		this.deleteObj = deleteObj;
	}

	public List<PositionadjustdetailEntity> getDetail() {
		return detail;
	}

	public void setDetail(List<PositionadjustdetailEntity> detail) {
		this.detail = detail;
	}

	public void copyObject(PositionadjustmainEntity temp) {
		/** 自增id. */
		this.setId(temp.getId());
		/** 调整单号. */
		this.setOrderNumber(temp.getOrderNumber());
		/** 状态0草稿1已确认2已完成. */
		this.setStatus(temp.getStatus());
		/** 备注. */
		this.setRemark(temp.getRemark());
		/** 完成时间. */
		this.setComplitDate(temp.getComplitDate());
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
		/** 楼层编号. */
		this.setFloorCode(temp.getFloorCode());
		/** 楼层名称. */
		this.setFloorName(temp.getFloorName());
	}
	
	
}
