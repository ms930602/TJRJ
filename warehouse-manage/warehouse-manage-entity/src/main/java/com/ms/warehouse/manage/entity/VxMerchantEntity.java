
package com.ms.warehouse.manage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 
 * @author Ms
 * @Date 2018-10-21 19:40:55
 * @since 1.0
 */
@TableName("t_vx_merchant")
public class VxMerchantEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** 主键. */
	private Long id;
	
	/** 商户名称. */
	private String name;
	
	/** 电话. */
	private String phone;
	
	/** 微信号. */
	private String vxNum;
	
	

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
	

    /** set 商户名称. */
	public void setName(String name) {
		this.name = name;
	}
	
	/** get 商户名称. */
	public String getName() {
		return this.name;
	}
	
	@JsonIgnore
	public String getNameByLike() {
		return "%"+this.name+"%";
	}
	

    /** set 电话. */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/** get 电话. */
	public String getPhone() {
		return this.phone;
	}
	
	@JsonIgnore
	public String getPhoneByLike() {
		return "%"+this.phone+"%";
	}
	

    /** set 微信号. */
	public void setVxNum(String vxNum) {
		this.vxNum = vxNum;
	}
	
	/** get 微信号. */
	public String getVxNum() {
		return this.vxNum;
	}
	
	@JsonIgnore
	public String getVxNumByLike() {
		return "%"+this.vxNum+"%";
	}
	
    /** constructor */
	public VxMerchantEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param name			商户名称
	 * @param phone			电话
	 * @param vxNum			微信号
	 */
	public VxMerchantEntity(String name,String phone,String vxNum){
		this();
		this.name = name;
		this.phone = phone;
		this.vxNum = vxNum;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("VxMerchantEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("Name=").append(getName()).append(", ")
			.append("Phone=").append(getPhone()).append(", ")
			.append("VxNum=").append(getVxNum())
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
		if(obj instanceof VxMerchantEntity == false)
			return false;
		if(this == obj)
			return true;
		VxMerchantEntity other = (VxMerchantEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
