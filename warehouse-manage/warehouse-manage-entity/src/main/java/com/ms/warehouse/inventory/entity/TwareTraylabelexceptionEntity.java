
package com.ms.warehouse.inventory.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 托盘标签异常
 * @author cjy
 * @Date 2018-08-13 11:57:41
 * @since 1.0
 */
@TableName("t_ware_traylabelexception")
public class TwareTraylabelexceptionEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** . */
	private Long id;
	
	/** 托盘rfid编号. */
	private String trayRfid;
	
	/** 托盘编号. */
	private String trayCode;
	
	/** 异常描述. */
	private String descript;
	
	/** 状态0未处理1已处理. */
	private Long status;
	
	/** 创建时间. */
	private java.util.Date createdDate;
	
	/** 创建人id. */
	private Long createdPersonId;
	
	/** 创建人. */
	private String createdPersonName;
	
	/** 更新时间. */
	private java.util.Date updatedDate;
	
	/** 更新人id. */
	private Long updatedPersonId;
	
	/** 修改人. */
	private String updatedPerson;
	
	

    /** set . */
	public void setId(Long id) {
		this.id = id;
	}
	
	/** get . */
	public Long getId() {
		return this.id;
	}
	
	@JsonIgnore
	public Long getIdByLike() {
		return this.id;
	}
	

    /** set 托盘rfid编号. */
	public void setTrayRfid(String trayRfid) {
		this.trayRfid = trayRfid;
	}
	
	/** get 托盘rfid编号. */
	public String getTrayRfid() {
		return this.trayRfid;
	}
	
	@JsonIgnore
	public String getTrayRfidByLike() {
		return "%"+this.trayRfid+"%";
	}
	

    /** set 托盘编号. */
	public void setTrayCode(String trayCode) {
		this.trayCode = trayCode;
	}
	
	/** get 托盘编号. */
	public String getTrayCode() {
		return this.trayCode;
	}
	
	@JsonIgnore
	public String getTrayCodeByLike() {
		return "%"+this.trayCode+"%";
	}
	

    /** set 异常描述. */
	public void setDescript(String descript) {
		this.descript = descript;
	}
	
	/** get 异常描述. */
	public String getDescript() {
		return this.descript;
	}
	
	@JsonIgnore
	public String getDescriptByLike() {
		return "%"+this.descript+"%";
	}
	

    /** set 状态0未处理1已处理. */
	public void setStatus(Long status) {
		this.status = status;
	}
	
	/** get 状态0未处理1已处理. */
	public Long getStatus() {
		return this.status;
	}
	
	@JsonIgnore
	public Long getStatusByLike() {
		return this.status;
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
	

    
	
	public String getCreatedPersonName() {
		return createdPersonName;
	}

	public void setCreatedPersonName(String createdPersonName) {
		this.createdPersonName = createdPersonName;
	}

	@JsonIgnore
	public String getCreatedPersonNameByLike() {
		return "%"+this.createdPersonName+"%";
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
	public TwareTraylabelexceptionEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param trayRfid			托盘rfid编号
	 * @param trayCode			托盘编号
	 * @param descript			异常描述
	 * @param status			状态0未处理1已处理
	 * @param createdDate			创建时间
	 * @param createdPersonId			创建人id
	 * @param createdPersonName			创建人
	 * @param updatedDate			更新时间
	 * @param updatedPersonId			更新人id
	 * @param updatedPerson			修改人
	 */
	public TwareTraylabelexceptionEntity(String trayRfid,String trayCode,String descript,Long status,java.util.Date createdDate,Long createdPersonId,String createdPersonName,java.util.Date updatedDate,Long updatedPersonId,String updatedPerson){
		this();
		this.trayRfid = trayRfid;
		this.trayCode = trayCode;
		this.descript = descript;
		this.status = status;
		this.createdDate = createdDate;
		this.createdPersonId = createdPersonId;
		this.createdPersonName = createdPersonName;
		this.updatedDate = updatedDate;
		this.updatedPersonId = updatedPersonId;
		this.updatedPerson = updatedPerson;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("TwareTraylabelexceptionEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("TrayRfid=").append(getTrayRfid()).append(", ")
			.append("TrayCode=").append(getTrayCode()).append(", ")
			.append("Descript=").append(getDescript()).append(", ")
			.append("Status=").append(getStatus()).append(", ")
			.append("CreatedDate=").append(getCreatedDate()).append(", ")
			.append("CreatedPersonId=").append(getCreatedPersonId()).append(", ")
			.append("CreatedPersonName=").append(getCreatedPersonName()).append(", ")
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
		if(obj instanceof TwareTraylabelexceptionEntity == false)
			return false;
		if(this == obj)
			return true;
		TwareTraylabelexceptionEntity other = (TwareTraylabelexceptionEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
