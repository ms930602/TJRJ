
package com.ms.warehouse.car.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 
 * @author Ms
 * @Date 2018-11-02 14:43:16
 * @since 1.0
 */
@TableName("f_sale_car")
public class FsaleCarEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** 主键. */
	private Long id;
	
	/** 手机号码. */
	private String phone;
	
	/** 0 未处理 1 已锁定 2 已处理. */
	private String status;
	
	/** 备注. */
	private String remark;
	
	/** 创建时间. */
	private java.util.Date createTime;
	
	

    /** set 主键. */
	public void setId(Long id) {
		this.id = id;
	}
	
	/** get 主键. */
	public Long getId() {
		return this.id;
	}
	
	@JsonIgnore
	public Long getIdByLike() {
		return this.id;
	}
	

    /** set 手机号码. */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/** get 手机号码. */
	public String getPhone() {
		return this.phone;
	}
	
	@JsonIgnore
	public String getPhoneByLike() {
		return "%"+this.phone+"%";
	}
	

    /** set 0 未处理 1 已锁定 2 已处理. */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/** get 0 未处理 1 已锁定 2 已处理. */
	public String getStatus() {
		return this.status;
	}
	
	@JsonIgnore
	public String getStatusByLike() {
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
	

    /** set 创建时间. */
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
	/** get 创建时间. */
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	
	@JsonIgnore
	public java.util.Date getCreateTimeByLike() {
		return this.createTime;
	}
	
    /** constructor */
	public FsaleCarEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param phone			手机号码
	 * @param status			0 未处理 1 已锁定 2 已处理
	 * @param remark			备注
	 * @param createTime			创建时间
	 */
	public FsaleCarEntity(String phone,String status,String remark,java.util.Date createTime){
		this();
		this.phone = phone;
		this.status = status;
		this.remark = remark;
		this.createTime = createTime;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("FsaleCarEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("Phone=").append(getPhone()).append(", ")
			.append("Status=").append(getStatus()).append(", ")
			.append("Remark=").append(getRemark()).append(", ")
			.append("CreateTime=").append(getCreateTime())
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
		if(obj instanceof FsaleCarEntity == false)
			return false;
		if(this == obj)
			return true;
		FsaleCarEntity other = (FsaleCarEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
