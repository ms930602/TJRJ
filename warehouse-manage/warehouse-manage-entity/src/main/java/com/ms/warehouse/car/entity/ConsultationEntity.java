
package com.ms.warehouse.car.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 
 * @author Ms
 * @Date 2018-11-05 17:08:19
 * @since 1.0
 */
@TableName("t_consultation")
public class ConsultationEntity extends BaseEntity {
	
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
	
	/** 0 未处理 1 已锁定 2 已处理. */
	private String status;
	
	/** . */
	private java.util.Date createtime;
	
	/** 咨询内容. */
	private String context;
	
	/** 咨询车辆标题. */
	private String carTitle;
	
	

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
	

    /** set . */
	public void setCreatetime(java.util.Date createtime) {
		this.createtime = createtime;
	}
	
	/** get . */
	public java.util.Date getCreatetime() {
		return this.createtime;
	}
	
	@JsonIgnore
	public java.util.Date getCreatetimeByLike() {
		return this.createtime;
	}
	

    /** set 咨询内容. */
	public void setContext(String context) {
		this.context = context;
	}
	
	/** get 咨询内容. */
	public String getContext() {
		return this.context;
	}
	
	@JsonIgnore
	public String getContextByLike() {
		return "%"+this.context+"%";
	}
	

    /** set 咨询车辆标题. */
	public void setCarTitle(String carTitle) {
		this.carTitle = carTitle;
	}
	
	/** get 咨询车辆标题. */
	public String getCarTitle() {
		return this.carTitle;
	}
	
	@JsonIgnore
	public String getCarTitleByLike() {
		return "%"+this.carTitle+"%";
	}
	
    /** constructor */
	public ConsultationEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param phone			手机号
	 * @param remark			描述
	 * @param carId			咨询车辆外键
	 * @param status			0 未处理 1 已锁定 2 已处理
	 * @param createtime			
	 * @param context			咨询内容
	 * @param carTitle			咨询车辆标题
	 */
	public ConsultationEntity(String phone,String remark,Long carId,String status,java.util.Date createtime,String context,String carTitle){
		this();
		this.phone = phone;
		this.remark = remark;
		this.carId = carId;
		this.status = status;
		this.createtime = createtime;
		this.context = context;
		this.carTitle = carTitle;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("ConsultationEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("Phone=").append(getPhone()).append(", ")
			.append("Remark=").append(getRemark()).append(", ")
			.append("CarId=").append(getCarId()).append(", ")
			.append("Status=").append(getStatus()).append(", ")
			.append("Createtime=").append(getCreatetime()).append(", ")
			.append("Context=").append(getContext()).append(", ")
			.append("CarTitle=").append(getCarTitle())
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
		if(obj instanceof ConsultationEntity == false)
			return false;
		if(this == obj)
			return true;
		ConsultationEntity other = (ConsultationEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
