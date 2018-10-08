
package com.ms.warehouse.manage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 物料组，多个块对应一个组，一个组对应一种
 * @author dwx
 * @Date 2018-08-25 15:18:32
 * @since 1.0
 */
@TableName("t_base_matergroup")
public class MatergroupEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** 自增id. */
	private Long id;
	
	/** 组号，从1开始. */
	private Long groupNo;
	
	/** 物料编码. */
	private String materCode;
	
	/** 子版本ID. */
	private Long subverId;
	
	

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
	

    /** set 组号，从1开始. */
	public void setGroupNo(Long groupNo) {
		this.groupNo = groupNo;
	}
	
	/** get 组号，从1开始. */
	public Long getGroupNo() {
		return this.groupNo;
	}
	
	@JsonIgnore
	public Long getGroupNoByLike() {
		return this.groupNo;
	}
	

    /** set 物料编码. */
	public void setMaterCode(String materCode) {
		this.materCode = materCode;
	}
	
	/** get 物料编码. */
	public String getMaterCode() {
		return this.materCode;
	}
	
	@JsonIgnore
	public String getMaterCodeByLike() {
		return "%"+this.materCode+"%";
	}
	

    /** set 子版本ID. */
	public void setSubverId(Long subverId) {
		this.subverId = subverId;
	}
	
	/** get 子版本ID. */
	public Long getSubverId() {
		return this.subverId;
	}
	
	@JsonIgnore
	public Long getSubverIdByLike() {
		return this.subverId;
	}
	
    /** constructor */
	public MatergroupEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param groupNo			组号，从1开始
	 * @param materCode			物料编码
	 * @param subverId			子版本ID
	 */
	public MatergroupEntity(Long groupNo,String materCode,Long subverId){
		this();
		this.groupNo = groupNo;
		this.materCode = materCode;
		this.subverId = subverId;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("MatergroupEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("GroupNo=").append(getGroupNo()).append(", ")
			.append("MaterCode=").append(getMaterCode()).append(", ")
			.append("SubverId=").append(getSubverId())
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
		if(obj instanceof MatergroupEntity == false)
			return false;
		if(this == obj)
			return true;
		MatergroupEntity other = (MatergroupEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
