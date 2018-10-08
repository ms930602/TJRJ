
package com.ms.warehouse.inventory.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 货位调整主
 * @author dwx
 * @Date 2018-07-25 10:22:20
 * @since 1.0
 */
@TableName("t_ware_positionadjustmain")
public class PositionadjustmainEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** 自增id. */
	private Long id;
	
	/** 调整单号. */
	private String orderNumber;
	
	/** 状态0草稿1已确认2已完成. */
	private Long status;
	
	/** 备注. */
	private String remark;
	
	/** 完成时间. */
	private java.util.Date complitDate;
	
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
	
	/** 楼层编号. */
	private String floorCode;
	
	/** 楼层名称. */
	private String floorName;
	
	
	/** 自增id. */
	private Long posDetailId;
	
	/** 原托盘rfid编号. */
	private String origTrayRfid;
	
	/** 原货位id. */
	private String origLocalCode;
	
	/** 目的货位id. */
	private String destLocalCode;
	
	/** 操作人. */
	private String operator;
	
	/** 操作人ID. */
	private Long operatorId;
	
	/** 物料编码. */
	private String materCode;
	
	/** 物料名称. */
	private String materName;
	
	/** 物料版本名称. */
	private String materVersion;
	
	/** 品牌. */
	private String materCigbrand;
	
	/** 唯一码. */
	private String soleCode;
	
	/** 状态0未调整1已调整. */
	private Long posDetailStatus;
	
	/** 托盘编号. */
	private String trayCode;
	
	/** 库存托盘货位绑定表ID. */
	private Long inventorytraylocalmapId;
	
	/**
	 * 卷烟类型：0正式卷烟1福样促试
	 */
	private Long cigtype;
	
	/** 原货位描述. */
	private String oldDescript;
	/** 目的货位描述. */
	private String newDescript;
	
	

    public String getOldDescript() {
		return oldDescript;
	}

	public void setOldDescript(String oldDescript) {
		this.oldDescript = oldDescript;
	}

	public String getNewDescript() {
		return newDescript;
	}

	public void setNewDescript(String newDescript) {
		this.newDescript = newDescript;
	}

	public Long getPosDetailId() {
		return posDetailId;
	}

	public void setPosDetailId(Long posDetailId) {
		this.posDetailId = posDetailId;
	}

	public String getOrigTrayRfid() {
		return origTrayRfid;
	}

	public void setOrigTrayRfid(String origTrayRfid) {
		this.origTrayRfid = origTrayRfid;
	}

	public String getOrigLocalCode() {
		return origLocalCode;
	}

	public void setOrigLocalCode(String origLocalCode) {
		this.origLocalCode = origLocalCode;
	}

	public String getDestLocalCode() {
		return destLocalCode;
	}

	public void setDestLocalCode(String destLocalCode) {
		this.destLocalCode = destLocalCode;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Long getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	public String getMaterCode() {
		return materCode;
	}

	public void setMaterCode(String materCode) {
		this.materCode = materCode;
	}

	public String getMaterName() {
		return materName;
	}

	public void setMaterName(String materName) {
		this.materName = materName;
	}

	public String getMaterVersion() {
		return materVersion;
	}

	public void setMaterVersion(String materVersion) {
		this.materVersion = materVersion;
	}

	public String getMaterCigbrand() {
		return materCigbrand;
	}

	public void setMaterCigbrand(String materCigbrand) {
		this.materCigbrand = materCigbrand;
	}

	public String getSoleCode() {
		return soleCode;
	}

	public void setSoleCode(String soleCode) {
		this.soleCode = soleCode;
	}

	public Long getPosDetailStatus() {
		return posDetailStatus;
	}

	public void setPosDetailStatus(Long posDetailStatus) {
		this.posDetailStatus = posDetailStatus;
	}

	public String getTrayCode() {
		return trayCode;
	}

	public void setTrayCode(String trayCode) {
		this.trayCode = trayCode;
	}

	public Long getInventorytraylocalmapId() {
		return inventorytraylocalmapId;
	}

	public void setInventorytraylocalmapId(Long inventorytraylocalmapId) {
		this.inventorytraylocalmapId = inventorytraylocalmapId;
	}

	public Long getCigtype() {
		return cigtype;
	}

	public void setCigtype(Long cigtype) {
		this.cigtype = cigtype;
	}

	public String getFloorCode() {
		return floorCode;
	}

	public void setFloorCode(String floorCode) {
		this.floorCode = floorCode;
	}

	public String getFloorName() {
		return floorName;
	}

	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}

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
	

    /** set 调整单号. */
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	/** get 调整单号. */
	public String getOrderNumber() {
		return this.orderNumber;
	}
	
	@JsonIgnore
	public String getOrderNumberByLike() {
		return "%"+this.orderNumber+"%";
	}
	

    /** set 状态0草稿1已确认2已完成. */
	public void setStatus(Long status) {
		this.status = status;
	}
	
	/** get 状态0草稿1已确认2已完成. */
	public Long getStatus() {
		return this.status;
	}
	
	@JsonIgnore
	public Long getStatusByLike() {
		return this.status;
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
	

    /** set 完成时间. */
	public void setComplitDate(java.util.Date complitDate) {
		this.complitDate = complitDate;
	}
	
	/** get 完成时间. */
	public java.util.Date getComplitDate() {
		return this.complitDate;
	}
	
	@JsonIgnore
	public java.util.Date getComplitDateByLike() {
		return this.complitDate;
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
	public PositionadjustmainEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param orderNumber			调整单号
	 * @param status			状态0草稿1已确认2已完成
	 * @param remark			备注
	 * @param complitDate			完成时间
	 * @param createdDate			创建时间
	 * @param createdPersonId			创建人id
	 * @param createdPerson			创建人
	 * @param updatedDate			更新时间
	 * @param updatedPersonId			更新人id
	 * @param updatedPerson			修改人
	 */
	public PositionadjustmainEntity(String orderNumber,Long status,String remark,java.util.Date complitDate,java.util.Date createdDate,Long createdPersonId,String createdPerson,java.util.Date updatedDate,Long updatedPersonId,String updatedPerson){
		this();
		this.orderNumber = orderNumber;
		this.status = status;
		this.remark = remark;
		this.complitDate = complitDate;
		this.createdDate = createdDate;
		this.createdPersonId = createdPersonId;
		this.createdPerson = createdPerson;
		this.updatedDate = updatedDate;
		this.updatedPersonId = updatedPersonId;
		this.updatedPerson = updatedPerson;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("PositionadjustmainEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("OrderNumber=").append(getOrderNumber()).append(", ")
			.append("Status=").append(getStatus()).append(", ")
			.append("Remark=").append(getRemark()).append(", ")
			.append("ComplitDate=").append(getComplitDate()).append(", ")
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
		if(obj instanceof PositionadjustmainEntity == false)
			return false;
		if(this == obj)
			return true;
		PositionadjustmainEntity other = (PositionadjustmainEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
