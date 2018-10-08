
package com.ms.warehouse.manage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 仓库通道管理
 * @author dwx
 * @Date 2018-07-11 10:28:41
 * @since 1.0
 */
@TableName("t_base_passway")
public class PasswayEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** 自增id. */
	private Long id;
	
	/** 通道编号. */
	private String passNo;
	
	/** 通道名称. */
	private String passName;
	
	/** 通道类型编号(来源字典表). */
	private String passTypeNo;
	
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
	

    /** set 通道编号. */
	public void setPassNo(String passNo) {
		this.passNo = passNo;
	}
	
	/** get 通道编号. */
	public String getPassNo() {
		return this.passNo;
	}
	
	@JsonIgnore
	public String getPassNoByLike() {
		return "%"+this.passNo+"%";
	}
	

    /** set 通道名称. */
	public void setPassName(String passName) {
		this.passName = passName;
	}
	
	/** get 通道名称. */
	public String getPassName() {
		return this.passName;
	}
	
	@JsonIgnore
	public String getPassNameByLike() {
		return "%"+this.passName+"%";
	}
	

    /** set 通道类型编号(来源字典表). */
	public void setPassTypeNo(String passTypeNo) {
		this.passTypeNo = passTypeNo;
	}
	
	/** get 通道类型编号(来源字典表). */
	public String getPassTypeNo() {
		return this.passTypeNo;
	}
	
	@JsonIgnore
	public String getPassTypeNoByLike() {
		return "%"+this.passTypeNo+"%";
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
	public PasswayEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param passNo			通道编号
	 * @param passName			通道名称
	 * @param passTypeNo			通道类型编号(来源字典表)
	 * @param createdDate			创建时间
	 * @param createdPersonId			创建人id
	 * @param createdPerson			创建人
	 * @param updatedDate			更新时间
	 * @param updatedPersonId			更新人id
	 * @param updatedPerson			修改人
	 */
	public PasswayEntity(String passNo,String passName,String passTypeNo,java.util.Date createdDate,Long createdPersonId,String createdPerson,java.util.Date updatedDate,Long updatedPersonId,String updatedPerson){
		this();
		this.passNo = passNo;
		this.passName = passName;
		this.passTypeNo = passTypeNo;
		this.createdDate = createdDate;
		this.createdPersonId = createdPersonId;
		this.createdPerson = createdPerson;
		this.updatedDate = updatedDate;
		this.updatedPersonId = updatedPersonId;
		this.updatedPerson = updatedPerson;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("PasswayEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("PassNo=").append(getPassNo()).append(", ")
			.append("PassName=").append(getPassName()).append(", ")
			.append("PassTypeNo=").append(getPassTypeNo()).append(", ")
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
		if(obj instanceof PasswayEntity == false)
			return false;
		if(this == obj)
			return true;
		PasswayEntity other = (PasswayEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
