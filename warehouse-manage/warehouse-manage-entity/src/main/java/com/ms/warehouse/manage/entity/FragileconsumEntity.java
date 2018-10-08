
package com.ms.warehouse.manage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 易损易耗件
 * @author dwx
 * @Date 2018-07-11 10:28:42
 * @since 1.0
 */
@TableName("t_dev_fragileconsum")
public class FragileconsumEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** 自增id. */
	private Long id;
	
	/** 物件名称. */
	private String name;
	
	/** 物件编号、序列号. */
	private String serialNum;
	
	/** 物件用途. */
	private String purpose;
	
	/** 损坏时间. */
	private java.util.Date damageTime;
	
	/** 修复时间. */
	private java.util.Date repairTime;
	
	/** 修复人. */
	private String repairPerson;
	
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
	

    /** set 物件名称. */
	public void setName(String name) {
		this.name = name;
	}
	
	/** get 物件名称. */
	public String getName() {
		return this.name;
	}
	
	@JsonIgnore
	public String getNameByLike() {
		return "%"+this.name+"%";
	}
	

    /** set 物件编号、序列号. */
	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}
	
	/** get 物件编号、序列号. */
	public String getSerialNum() {
		return this.serialNum;
	}
	
	@JsonIgnore
	public String getSerialNumByLike() {
		return "%"+this.serialNum+"%";
	}
	

    /** set 物件用途. */
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	
	/** get 物件用途. */
	public String getPurpose() {
		return this.purpose;
	}
	
	@JsonIgnore
	public String getPurposeByLike() {
		return "%"+this.purpose+"%";
	}
	

    /** set 损坏时间. */
	public void setDamageTime(java.util.Date damageTime) {
		this.damageTime = damageTime;
	}
	
	/** get 损坏时间. */
	public java.util.Date getDamageTime() {
		return this.damageTime;
	}
	
	@JsonIgnore
	public java.util.Date getDamageTimeByLike() {
		return this.damageTime;
	}
	

    /** set 修复时间. */
	public void setRepairTime(java.util.Date repairTime) {
		this.repairTime = repairTime;
	}
	
	/** get 修复时间. */
	public java.util.Date getRepairTime() {
		return this.repairTime;
	}
	
	@JsonIgnore
	public java.util.Date getRepairTimeByLike() {
		return this.repairTime;
	}
	

    /** set 修复人. */
	public void setRepairPerson(String repairPerson) {
		this.repairPerson = repairPerson;
	}
	
	/** get 修复人. */
	public String getRepairPerson() {
		return this.repairPerson;
	}
	
	@JsonIgnore
	public String getRepairPersonByLike() {
		return "%"+this.repairPerson+"%";
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
	
    /** constructor */
	public FragileconsumEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param name			物件名称
	 * @param serialNum			物件编号、序列号
	 * @param purpose			物件用途
	 * @param damageTime			损坏时间
	 * @param repairTime			修复时间
	 * @param repairPerson			修复人
	 * @param createdDate			创建时间
	 * @param createdPersonId			创建人id
	 * @param createdPerson			创建人
	 * @param updatedDate			更新时间
	 * @param updatedPersonId			更新人id
	 * @param updatedPerson			修改人
	 */
	public FragileconsumEntity(String name,String serialNum,String purpose,java.util.Date damageTime,java.util.Date repairTime,String repairPerson,java.util.Date createdDate,Long createdPersonId,String createdPerson,java.util.Date updatedDate,Long updatedPersonId,String updatedPerson){
		this();
		this.name = name;
		this.serialNum = serialNum;
		this.purpose = purpose;
		this.damageTime = damageTime;
		this.repairTime = repairTime;
		this.repairPerson = repairPerson;
		this.createdDate = createdDate;
		this.createdPersonId = createdPersonId;
		this.createdPerson = createdPerson;
		this.updatedDate = updatedDate;
		this.updatedPersonId = updatedPersonId;
		this.updatedPerson = updatedPerson;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("FragileconsumEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("Name=").append(getName()).append(", ")
			.append("SerialNum=").append(getSerialNum()).append(", ")
			.append("Purpose=").append(getPurpose()).append(", ")
			.append("DamageTime=").append(getDamageTime()).append(", ")
			.append("RepairTime=").append(getRepairTime()).append(", ")
			.append("RepairPerson=").append(getRepairPerson()).append(", ")
			.append("CreatedDate=").append(getCreatedDate()).append(", ")
			.append("CreatedPersonId=").append(getCreatedPersonId()).append(", ")
			.append("CreatedPerson=").append(getCreatedPerson()).append(", ")
			.append("UpdatedDate=").append(getUpdatedDate()).append(", ")
			.append("UpdatedPersonId=").append(getUpdatedPersonId()).append(", ")
			.append("UpdatedPerson=").append(getUpdatedPerson())
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
		if(obj instanceof FragileconsumEntity == false)
			return false;
		if(this == obj)
			return true;
		FragileconsumEntity other = (FragileconsumEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
