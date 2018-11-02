
package com.ms.warehouse.car.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 
 * @author Ms
 * @Date 2018-11-02 14:43:14
 * @since 1.0
 */
@TableName("f_consultation")
public class FconsultationEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** 主键. */
	private Long id;
	
	/** 手机号. */
	private String phone;
	
	/** 描述. */
	private String remark;
	
	/** 咨询车辆外键. */
	private Long carId;
	
	

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
	

    /** set 手机号. */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/** get 手机号. */
	public String getPhone() {
		return this.phone;
	}
	
	@JsonIgnore
	public String getPhoneByLike() {
		return "%"+this.phone+"%";
	}
	

    /** set 描述. */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/** get 描述. */
	public String getRemark() {
		return this.remark;
	}
	
	@JsonIgnore
	public String getRemarkByLike() {
		return "%"+this.remark+"%";
	}
	

    /** set 咨询车辆外键. */
	public void setCarId(Long carId) {
		this.carId = carId;
	}
	
	/** get 咨询车辆外键. */
	public Long getCarId() {
		return this.carId;
	}
	
	@JsonIgnore
	public Long getCarIdByLike() {
		return this.carId;
	}
	
    /** constructor */
	public FconsultationEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param phone			手机号
	 * @param remark			描述
	 * @param carId			咨询车辆外键
	 */
	public FconsultationEntity(String phone,String remark,Long carId){
		this();
		this.phone = phone;
		this.remark = remark;
		this.carId = carId;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("FconsultationEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("Phone=").append(getPhone()).append(", ")
			.append("Remark=").append(getRemark()).append(", ")
			.append("CarId=").append(getCarId())
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
		if(obj instanceof FconsultationEntity == false)
			return false;
		if(this == obj)
			return true;
		FconsultationEntity other = (FconsultationEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
