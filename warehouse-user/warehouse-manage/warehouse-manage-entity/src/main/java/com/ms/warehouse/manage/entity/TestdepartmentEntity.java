
package com.ms.warehouse.manage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 试验部门
 * @author dwx
 * @Date 2018-07-09 18:27:45
 * @since 1.0
 */
@TableName("t_mater_testdepartment")
public class TestdepartmentEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** 自增id. */
	private Long id;
	
	/** 主数据ID. */
	private String dataId;
	
	/** 代码. */
	private String tdCode;
	
	/** 名称. */
	private String tdName;
	
	/** 简称. */
	private String abbreviation;
	
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
	public void setTdCode(String tdCode) {
		this.tdCode = tdCode;
	}
	
	/** get 代码. */
	public String getTdCode() {
		return this.tdCode;
	}
	
	@JsonIgnore
	public String getTdCodeByLike() {
		return "%"+this.tdCode+"%";
	}
	

    /** set 名称. */
	public void setTdName(String tdName) {
		this.tdName = tdName;
	}
	
	/** get 名称. */
	public String getTdName() {
		return this.tdName;
	}
	
	@JsonIgnore
	public String getTdNameByLike() {
		return "%"+this.tdName+"%";
	}
	

    /** set 简称. */
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	
	/** get 简称. */
	public String getAbbreviation() {
		return this.abbreviation;
	}
	
	@JsonIgnore
	public String getAbbreviationByLike() {
		return "%"+this.abbreviation+"%";
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
	public TestdepartmentEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param dataId			主数据ID
	 * @param tdCode			代码
	 * @param tdName			名称
	 * @param abbreviation			简称
	 * @param status			状态 2：发布 3：停用
	 * @param createdDate			创建时间
	 * @param createdPerson			创建人
	 * @param updatedDate			更新时间
	 * @param updatedPerson			更新人
	 */
	public TestdepartmentEntity(String dataId,String tdCode,String tdName,String abbreviation,String status,java.util.Date createdDate,String createdPerson,java.util.Date updatedDate,String updatedPerson){
		this();
		this.dataId = dataId;
		this.tdCode = tdCode;
		this.tdName = tdName;
		this.abbreviation = abbreviation;
		this.status = status;
		this.createdDate = createdDate;
		this.createdPerson = createdPerson;
		this.updatedDate = updatedDate;
		this.updatedPerson = updatedPerson;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("TestdepartmentEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("DataId=").append(getDataId()).append(", ")
			.append("TdCode=").append(getTdCode()).append(", ")
			.append("TdName=").append(getTdName()).append(", ")
			.append("Abbreviation=").append(getAbbreviation()).append(", ")
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
		if(obj instanceof TestdepartmentEntity == false)
			return false;
		if(this == obj)
			return true;
		TestdepartmentEntity other = (TestdepartmentEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
