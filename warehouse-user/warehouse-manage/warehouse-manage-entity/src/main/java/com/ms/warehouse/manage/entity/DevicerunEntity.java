
package com.ms.warehouse.manage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 设备运行管理
 * @author dwx
 * @Date 2018-07-11 10:28:42
 * @since 1.0
 */
@TableName("t_dev_devicerun")
public class DevicerunEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** 自增id. */
	private Long id;
	
	/** 设备字典编码. */
	private String dicCode;
	
	/** 设备名称（字典名称）. */
	private String dicName;
	
	/** 设备编号、序列号. */
	private String serialNum;
	
	/** 故障发生时间. */
	private java.util.Date failerTime;
	
	/** 故障修复时间. */
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
	

    /** set 设备字典编码. */
	public void setDicCode(String dicCode) {
		this.dicCode = dicCode;
	}
	
	/** get 设备字典编码. */
	public String getDicCode() {
		return this.dicCode;
	}
	
	@JsonIgnore
	public String getDicCodeByLike() {
		return "%"+this.dicCode+"%";
	}
	

    /** set 设备名称（字典名称）. */
	public void setDicName(String dicName) {
		this.dicName = dicName;
	}
	
	/** get 设备名称（字典名称）. */
	public String getDicName() {
		return this.dicName;
	}
	
	@JsonIgnore
	public String getDicNameByLike() {
		return "%"+this.dicName+"%";
	}
	

    /** set 设备编号、序列号. */
	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}
	
	/** get 设备编号、序列号. */
	public String getSerialNum() {
		return this.serialNum;
	}
	
	@JsonIgnore
	public String getSerialNumByLike() {
		return "%"+this.serialNum+"%";
	}
	

    /** set 故障发生时间. */
	public void setFailerTime(java.util.Date failerTime) {
		this.failerTime = failerTime;
	}
	
	/** get 故障发生时间. */
	public java.util.Date getFailerTime() {
		return this.failerTime;
	}
	
	@JsonIgnore
	public java.util.Date getFailerTimeByLike() {
		return this.failerTime;
	}
	

    /** set 故障修复时间. */
	public void setRepairTime(java.util.Date repairTime) {
		this.repairTime = repairTime;
	}
	
	/** get 故障修复时间. */
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
	public DevicerunEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param dicCode			设备字典编码
	 * @param dicName			设备名称（字典名称）
	 * @param serialNum			设备编号、序列号
	 * @param failerTime			故障发生时间
	 * @param repairTime			故障修复时间
	 * @param repairPerson			修复人
	 * @param createdDate			创建时间
	 * @param createdPersonId			创建人id
	 * @param createdPerson			创建人
	 * @param updatedDate			更新时间
	 * @param updatedPersonId			更新人id
	 * @param updatedPerson			修改人
	 */
	public DevicerunEntity(String dicCode,String dicName,String serialNum,java.util.Date failerTime,java.util.Date repairTime,String repairPerson,java.util.Date createdDate,Long createdPersonId,String createdPerson,java.util.Date updatedDate,Long updatedPersonId,String updatedPerson){
		this();
		this.dicCode = dicCode;
		this.dicName = dicName;
		this.serialNum = serialNum;
		this.failerTime = failerTime;
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
		return new StringBuilder().append("DevicerunEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("DicCode=").append(getDicCode()).append(", ")
			.append("DicName=").append(getDicName()).append(", ")
			.append("SerialNum=").append(getSerialNum()).append(", ")
			.append("FailerTime=").append(getFailerTime()).append(", ")
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
		if(obj instanceof DevicerunEntity == false)
			return false;
		if(this == obj)
			return true;
		DevicerunEntity other = (DevicerunEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
