
package com.ms.warehouse.inventory.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 货位标签异常
 * @author cjy
 * @Date 2018-08-13 11:57:41
 * @since 1.0
 */
@TableName("t_ware_locallabelexception")
public class TwareLocallabelexceptionEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** 自增id. */
	private Long id;
	
	/** 货位id. */
	private Long localId;
	
	/** 货位编码. */
	private String localCode;
	
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
	

    /** set 货位id. */
	public void setLocalId(Long localId) {
		this.localId = localId;
	}
	
	/** get 货位id. */
	public Long getLocalId() {
		return this.localId;
	}
	
	@JsonIgnore
	public Long getLocalIdByLike() {
		return this.localId;
	}
	

    /** set 货位编码. */
	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}
	
	/** get 货位编码. */
	public String getLocalCode() {
		return this.localCode;
	}
	
	@JsonIgnore
	public String getLocalCodeByLike() {
		return "%"+this.localCode+"%";
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
	public TwareLocallabelexceptionEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param localId			货位id
	 * @param localCode			货位编码
	 * @param descript			异常描述
	 * @param status			状态0未处理1已处理
	 * @param createdDate			创建时间
	 * @param createdPersonId			创建人id
	 * @param createdPersonName			创建人
	 * @param updatedDate			更新时间
	 * @param updatedPersonId			更新人id
	 * @param updatedPerson			修改人
	 * @param createdPersonName 
	 */
	public TwareLocallabelexceptionEntity(Long localId,String localCode,String descript,Long status,java.util.Date createdDate,Long createdPersonId,String createdPerson,java.util.Date updatedDate,Long updatedPersonId,String updatedPerson, String createdPersonName){
		this();
		this.localId = localId;
		this.localCode = localCode;
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
		return new StringBuilder().append("TwareLocallabelexceptionEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("LocalId=").append(getLocalId()).append(", ")
			.append("LocalCode=").append(getLocalCode()).append(", ")
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
		if(obj instanceof TwareLocallabelexceptionEntity == false)
			return false;
		if(this == obj)
			return true;
		TwareLocallabelexceptionEntity other = (TwareLocallabelexceptionEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
