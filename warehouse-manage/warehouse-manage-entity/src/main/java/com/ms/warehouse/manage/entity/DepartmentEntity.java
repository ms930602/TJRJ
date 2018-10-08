
package com.ms.warehouse.manage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 部门信息
 * @author dwx
 * @Date 2018-07-09 18:27:43
 * @since 1.0
 */
@TableName("t_base_department")
public class DepartmentEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** 自增id. */
	private Long id;
	
	/** 部门名称. */
	private String depName;
	
	/** 部门负责人. */
	private String depPrincipal;
	
	/** 父类id. */
	private Long parentId;
	
	/** 描述. */
	private String descript;
	
	/** 是否可用 ：1可用 0不可用. */
	private Integer enabled;
	
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
	

    /** set 部门名称. */
	public void setDepName(String depName) {
		this.depName = depName;
	}
	
	/** get 部门名称. */
	public String getDepName() {
		return this.depName;
	}
	
	@JsonIgnore
	public String getDepNameByLike() {
		return "%"+this.depName+"%";
	}
	

    /** set 部门负责人. */
	public void setDepPrincipal(String depPrincipal) {
		this.depPrincipal = depPrincipal;
	}
	
	/** get 部门负责人. */
	public String getDepPrincipal() {
		return this.depPrincipal;
	}
	
	@JsonIgnore
	public String getDepPrincipalByLike() {
		return "%"+this.depPrincipal+"%";
	}
	

    /** set 父类id. */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	
	/** get 父类id. */
	public Long getParentId() {
		return this.parentId;
	}
	
	@JsonIgnore
	public Long getParentIdByLike() {
		return this.parentId;
	}
	

    /** set 描述. */
	public void setDescript(String descript) {
		this.descript = descript;
	}
	
	/** get 描述. */
	public String getDescript() {
		return this.descript;
	}
	
	@JsonIgnore
	public String getDescriptByLike() {
		return "%"+this.descript+"%";
	}
	

    /** set 是否可用 ：1可用 0不可用. */
	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}
	
	/** get 是否可用 ：1可用 0不可用. */
	public Integer getEnabled() {
		return this.enabled;
	}
	
	@JsonIgnore
	public Integer getEnabledByLike() {
		return this.enabled;
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
	public DepartmentEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param depName			部门名称
	 * @param depPrincipal			部门负责人
	 * @param parentId			父类id
	 * @param descript			描述
	 * @param enabled			是否可用 ：1可用 0不可用
	 * @param createdDate			创建时间
	 * @param createdPersonId			创建人id
	 * @param createdPerson			创建人
	 * @param updatedDate			更新时间
	 * @param updatedPersonId			更新人id
	 * @param updatedPerson			修改人
	 */
	public DepartmentEntity(String depName,String depPrincipal,Long parentId,String descript,Integer enabled,java.util.Date createdDate,Long createdPersonId,String createdPerson,java.util.Date updatedDate,Long updatedPersonId,String updatedPerson){
		this();
		this.depName = depName;
		this.depPrincipal = depPrincipal;
		this.parentId = parentId;
		this.descript = descript;
		this.enabled = enabled;
		this.createdDate = createdDate;
		this.createdPersonId = createdPersonId;
		this.createdPerson = createdPerson;
		this.updatedDate = updatedDate;
		this.updatedPersonId = updatedPersonId;
		this.updatedPerson = updatedPerson;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("DepartmentEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("DepName=").append(getDepName()).append(", ")
			.append("DepPrincipal=").append(getDepPrincipal()).append(", ")
			.append("ParentId=").append(getParentId()).append(", ")
			.append("Descript=").append(getDescript()).append(", ")
			.append("Enabled=").append(getEnabled()).append(", ")
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
		if(obj instanceof DepartmentEntity == false)
			return false;
		if(this == obj)
			return true;
		DepartmentEntity other = (DepartmentEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
