
package com.ms.warehouse.manage.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 包装规格
 * @author dwx
 * @Date 2018-07-09 18:27:44
 * @since 1.0
 */
@TableName("t_mater_packspec")
public class PackspecEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** 自增id. */
	private Long id;
	
	/** 主数据ID. */
	private String dataId;
	
	/** 代码. */
	private String pacsCode;
	
	/** 名称. */
	private String pacsName;
	
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
	
	private BigDecimal converCoef;
	
	

    /** set 自增id. */
	public void setId(Long id) {
		this.id = id;
	}
	
	public BigDecimal getConverCoef() {
		return converCoef;
	}

	public void setConverCoef(BigDecimal converCoef) {
		this.converCoef = converCoef;
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
	public void setPacsCode(String pacsCode) {
		this.pacsCode = pacsCode;
	}
	
	/** get 代码. */
	public String getPacsCode() {
		return this.pacsCode;
	}
	
	@JsonIgnore
	public String getPacsCodeByLike() {
		return "%"+this.pacsCode+"%";
	}
	

    /** set 名称. */
	public void setPacsName(String pacsName) {
		this.pacsName = pacsName;
	}
	
	/** get 名称. */
	public String getPacsName() {
		return this.pacsName;
	}
	
	@JsonIgnore
	public String getPacsNameByLike() {
		return "%"+this.pacsName+"%";
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
	public PackspecEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param dataId			主数据ID
	 * @param pacsCode			代码
	 * @param pacsName			名称
	 * @param status			状态 2：发布 3：停用
	 * @param createdDate			创建时间
	 * @param createdPerson			创建人
	 * @param updatedDate			更新时间
	 * @param updatedPerson			更新人
	 */
	public PackspecEntity(String dataId,String pacsCode,String pacsName,String status,java.util.Date createdDate,String createdPerson,java.util.Date updatedDate,String updatedPerson){
		this();
		this.dataId = dataId;
		this.pacsCode = pacsCode;
		this.pacsName = pacsName;
		this.status = status;
		this.createdDate = createdDate;
		this.createdPerson = createdPerson;
		this.updatedDate = updatedDate;
		this.updatedPerson = updatedPerson;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("PackspecEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("DataId=").append(getDataId()).append(", ")
			.append("PacsCode=").append(getPacsCode()).append(", ")
			.append("PacsName=").append(getPacsName()).append(", ")
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
		if(obj instanceof PackspecEntity == false)
			return false;
		if(this == obj)
			return true;
		PackspecEntity other = (PackspecEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
