
package com.ms.warehouse.inventory.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 库存盘点主信息
 * @author dwx
 * @Date 2018-07-25 10:22:20
 * @since 1.0
 */
@TableName("t_ware_stockcheckmain")
public class StockcheckmainEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** 自增id. */
	private Long id;
	
	/** 盘点单号. */
	private String orderNumber;
	
	/** 盘点方式0全面盘点1抽样盘点. */
	private Long inventMethod;
	
	/** 盘点人. */
	private String inventor;
	
	/** 盘点开始时间. */
	private java.util.Date inventStartDate;
	
	/** 盘点结束时间. */
	private java.util.Date inventEndDate;
	
	/** 状态 0草稿1 已确认2已完成. */
	private Long status;
	
	/** 是否复盘 1：是 0 否. */
	private Long reversion;
	
	/** 创建时间. */
	private java.util.Date createdDate;
	
	/** 创建人id. */
	private Long createdPersonId;
	
	/** 创建人. */
	private String createdPerson;
	
	/** 更新时间. */
	private java.util.Date updatedDate;
	
	/** 更新人id. */
	private Long updatedPersonId;
	
	/** 修改人. */
	private String updatedPerson;
	
	/** 备注. */
	private String remark;
	
	

    /** set 自增id. */
	public void setId(Long id) {
		this.id = id;
	}
	
	/** get 自增id. */
	public Long getId() {
		return this.id;
	}
	
	@JsonIgnore
	public Long getIdByLike() {
		return this.id;
	}
	

    /** set 盘点单号. */
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	/** get 盘点单号. */
	public String getOrderNumber() {
		return this.orderNumber;
	}
	
	@JsonIgnore
	public String getOrderNumberByLike() {
		return "%"+this.orderNumber+"%";
	}
	

    /** set 盘点方式0全面盘点1抽样盘点. */
	public void setInventMethod(Long inventMethod) {
		this.inventMethod = inventMethod;
	}
	
	/** get 盘点方式0全面盘点1抽样盘点. */
	public Long getInventMethod() {
		return this.inventMethod;
	}
	
	@JsonIgnore
	public Long getInventMethodByLike() {
		return this.inventMethod;
	}
	

    /** set 盘点人. */
	public void setInventor(String inventor) {
		this.inventor = inventor;
	}
	
	/** get 盘点人. */
	public String getInventor() {
		return this.inventor;
	}
	
	@JsonIgnore
	public String getInventorByLike() {
		return "%"+this.inventor+"%";
	}
	

    /** set 盘点开始时间. */
	public void setInventStartDate(java.util.Date inventStartDate) {
		this.inventStartDate = inventStartDate;
	}
	
	/** get 盘点开始时间. */
	public java.util.Date getInventStartDate() {
		return this.inventStartDate;
	}
	
	@JsonIgnore
	public java.util.Date getInventStartDateByLike() {
		return this.inventStartDate;
	}
	

    /** set 盘点结束时间. */
	public void setInventEndDate(java.util.Date inventEndDate) {
		this.inventEndDate = inventEndDate;
	}
	
	/** get 盘点结束时间. */
	public java.util.Date getInventEndDate() {
		return this.inventEndDate;
	}
	
	@JsonIgnore
	public java.util.Date getInventEndDateByLike() {
		return this.inventEndDate;
	}
	

    /** set 状态 0草稿1 已确认2已完成. */
	public void setStatus(Long status) {
		this.status = status;
	}
	
	/** get 状态 0草稿1 已确认2已完成. */
	public Long getStatus() {
		return this.status;
	}
	
	@JsonIgnore
	public Long getStatusByLike() {
		return this.status;
	}
	

    /** set 是否复盘 1：是 0 否. */
	public void setReversion(Long reversion) {
		this.reversion = reversion;
	}
	
	/** get 是否复盘 1：是 0 否. */
	public Long getReversion() {
		return this.reversion;
	}
	
	@JsonIgnore
	public Long getReversionByLike() {
		return this.reversion;
	}
	

    /** set 创建时间. */
	public void setCreatedDate(java.util.Date createdDate) {
		this.createdDate = createdDate;
	}
	
	/** get 创建时间. */
	public java.util.Date getCreatedDate() {
		return this.createdDate;
	}
	
	@JsonIgnore
	public java.util.Date getCreatedDateByLike() {
		return this.createdDate;
	}
	

    /** set 创建人id. */
	public void setCreatedPersonId(Long createdPersonId) {
		this.createdPersonId = createdPersonId;
	}
	
	/** get 创建人id. */
	public Long getCreatedPersonId() {
		return this.createdPersonId;
	}
	
	@JsonIgnore
	public Long getCreatedPersonIdByLike() {
		return this.createdPersonId;
	}
	

    /** set 创建人. */
	public void setCreatedPerson(String createdPerson) {
		this.createdPerson = createdPerson;
	}
	
	/** get 创建人. */
	public String getCreatedPerson() {
		return this.createdPerson;
	}
	
	@JsonIgnore
	public String getCreatedPersonByLike() {
		return "%"+this.createdPerson+"%";
	}
	

    /** set 更新时间. */
	public void setUpdatedDate(java.util.Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	/** get 更新时间. */
	public java.util.Date getUpdatedDate() {
		return this.updatedDate;
	}
	
	@JsonIgnore
	public java.util.Date getUpdatedDateByLike() {
		return this.updatedDate;
	}
	

    /** set 更新人id. */
	public void setUpdatedPersonId(Long updatedPersonId) {
		this.updatedPersonId = updatedPersonId;
	}
	
	/** get 更新人id. */
	public Long getUpdatedPersonId() {
		return this.updatedPersonId;
	}
	
	@JsonIgnore
	public Long getUpdatedPersonIdByLike() {
		return this.updatedPersonId;
	}
	

    /** set 修改人. */
	public void setUpdatedPerson(String updatedPerson) {
		this.updatedPerson = updatedPerson;
	}
	
	/** get 修改人. */
	public String getUpdatedPerson() {
		return this.updatedPerson;
	}
	
	@JsonIgnore
	public String getUpdatedPersonByLike() {
		return "%"+this.updatedPerson+"%";
	}
	

    /** set 备注. */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/** get 备注. */
	public String getRemark() {
		return this.remark;
	}
	
	@JsonIgnore
	public String getRemarkByLike() {
		return "%"+this.remark+"%";
	}
	
    /** constructor */
	public StockcheckmainEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param orderNumber			盘点单号
	 * @param inventMethod			盘点方式0全面盘点1抽样盘点
	 * @param inventor			盘点人
	 * @param inventStartDate			盘点开始时间
	 * @param inventEndDate			盘点结束时间
	 * @param status			状态 0草稿1 已确认2已完成
	 * @param reversion			是否复盘 1：是 0 否
	 * @param createdDate			创建时间
	 * @param createdPersonId			创建人id
	 * @param createdPerson			创建人
	 * @param updatedDate			更新时间
	 * @param updatedPersonId			更新人id
	 * @param updatedPerson			修改人
	 * @param remark			备注
	 */
	public StockcheckmainEntity(String orderNumber,Long inventMethod,String inventor,java.util.Date inventStartDate,java.util.Date inventEndDate,Long status,Long reversion,java.util.Date createdDate,Long createdPersonId,String createdPerson,java.util.Date updatedDate,Long updatedPersonId,String updatedPerson,String remark){
		this();
		this.orderNumber = orderNumber;
		this.inventMethod = inventMethod;
		this.inventor = inventor;
		this.inventStartDate = inventStartDate;
		this.inventEndDate = inventEndDate;
		this.status = status;
		this.reversion = reversion;
		this.createdDate = createdDate;
		this.createdPersonId = createdPersonId;
		this.createdPerson = createdPerson;
		this.updatedDate = updatedDate;
		this.updatedPersonId = updatedPersonId;
		this.updatedPerson = updatedPerson;
		this.remark = remark;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("StockcheckmainEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("OrderNumber=").append(getOrderNumber()).append(", ")
			.append("InventMethod=").append(getInventMethod()).append(", ")
			.append("Inventor=").append(getInventor()).append(", ")
			.append("InventStartDate=").append(getInventStartDate()).append(", ")
			.append("InventEndDate=").append(getInventEndDate()).append(", ")
			.append("Status=").append(getStatus()).append(", ")
			.append("Reversion=").append(getReversion()).append(", ")
			.append("CreatedDate=").append(getCreatedDate()).append(", ")
			.append("CreatedPersonId=").append(getCreatedPersonId()).append(", ")
			.append("CreatedPerson=").append(getCreatedPerson()).append(", ")
			.append("UpdatedDate=").append(getUpdatedDate()).append(", ")
			.append("UpdatedPersonId=").append(getUpdatedPersonId()).append(", ")
			.append("UpdatedPerson=").append(getUpdatedPerson()).append(", ")
			.append("Remark=").append(getRemark())
		.append("]").toString();
	}
	
	@Override
	public int hashCode() {
		return toString().hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if(obj instanceof StockcheckmainEntity == false)
			return false;
		if(this == obj)
			return true;
		StockcheckmainEntity other = (StockcheckmainEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
