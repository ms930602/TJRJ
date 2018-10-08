
package com.ms.warehouse.manage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 版本
 * @author dwx
 * @Date 2018-07-09 18:27:44
 * @since 1.0
 */
@TableName("t_mater_cigversion")
public class CigversionEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** 自增id. */
	private Long id;
	
	/** 主数据ID. */
	private String dataId;
	
	/** 代码. */
	private String verCode;
	
	/** 名称. */
	private String verName;
	
	/** 状态 2：发布 3：停用. */
	private String status;
	
	/** 创建时间. */
	private java.util.Date createdDate;
	
	/** 创建人. */
	private String createdPerson;
	
	/** 更新时间. */
	private java.util.Date updatedDate;
	
	/** 更新人. */
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
	

    /** set 主数据ID. */
	public void setDataId(String dataId) {
		this.dataId = dataId;
	}
	
	/** get 主数据ID. */
	public String getDataId() {
		return this.dataId;
	}
	
	@JsonIgnore
	public String getDataIdByLike() {
		return "%"+this.dataId+"%";
	}
	

    /** set 代码. */
	public void setVerCode(String verCode) {
		this.verCode = verCode;
	}
	
	/** get 代码. */
	public String getVerCode() {
		return this.verCode;
	}
	
	@JsonIgnore
	public String getVerCodeByLike() {
		return "%"+this.verCode+"%";
	}
	

    /** set 名称. */
	public void setVerName(String verName) {
		this.verName = verName;
	}
	
	/** get 名称. */
	public String getVerName() {
		return this.verName;
	}
	
	@JsonIgnore
	public String getVerNameByLike() {
		return "%"+this.verName+"%";
	}
	

    /** set 状态 2：发布 3：停用. */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/** get 状态 2：发布 3：停用. */
	public String getStatus() {
		return this.status;
	}
	
	@JsonIgnore
	public String getStatusByLike() {
		return "%"+this.status+"%";
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
	

    /** set 更新人. */
	public void setUpdatedPerson(String updatedPerson) {
		this.updatedPerson = updatedPerson;
	}
	
	/** get 更新人. */
	public String getUpdatedPerson() {
		return this.updatedPerson;
	}
	
	@JsonIgnore
	public String getUpdatedPersonByLike() {
		return "%"+this.updatedPerson+"%";
	}
	
    /** constructor */
	public CigversionEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param dataId			主数据ID
	 * @param verCode			代码
	 * @param verName			名称
	 * @param status			状态 2：发布 3：停用
	 * @param createdDate			创建时间
	 * @param createdPerson			创建人
	 * @param updatedDate			更新时间
	 * @param updatedPerson			更新人
	 */
	public CigversionEntity(String dataId,String verCode,String verName,String status,java.util.Date createdDate,String createdPerson,java.util.Date updatedDate,String updatedPerson){
		this();
		this.dataId = dataId;
		this.verCode = verCode;
		this.verName = verName;
		this.status = status;
		this.createdDate = createdDate;
		this.createdPerson = createdPerson;
		this.updatedDate = updatedDate;
		this.updatedPerson = updatedPerson;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("CigversionEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("DataId=").append(getDataId()).append(", ")
			.append("VerCode=").append(getVerCode()).append(", ")
			.append("VerName=").append(getVerName()).append(", ")
			.append("Status=").append(getStatus()).append(", ")
			.append("CreatedDate=").append(getCreatedDate()).append(", ")
			.append("CreatedPerson=").append(getCreatedPerson()).append(", ")
			.append("UpdatedDate=").append(getUpdatedDate()).append(", ")
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
		if(obj instanceof CigversionEntity == false)
			return false;
		if(this == obj)
			return true;
		CigversionEntity other = (CigversionEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
