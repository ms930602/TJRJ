
package com.ms.warehouse.car.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 
 * @author Ms
 * @Date 2018-11-12 10:19:22
 * @since 1.0
 */
@TableName("t_estimate")
public class EstimateEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** 主键. */
	private Long id;
	
	/** 品牌. */
	private String brand;
	
	/** 车型. */
	private String type;
	
	/** 上牌日期. */
	private java.util.Date upbkTime;
	
	/** 里程. */
	private java.math.BigDecimal mileage;
	
	/** 拍照地点. */
	private String bkCitiy;
	
	/** 电话号码. */
	private String phone;
	
	/** 购买价格. */
	private java.math.BigDecimal price;
	
	/** 估算价格. */
	private java.math.BigDecimal mprice;
	
	

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
	

    /** set 品牌. */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	/** get 品牌. */
	public String getBrand() {
		return this.brand;
	}
	
	@JsonIgnore
	public String getBrandByLike() {
		return "%"+this.brand+"%";
	}
	

    /** set 车型. */
	public void setType(String type) {
		this.type = type;
	}
	
	/** get 车型. */
	public String getType() {
		return this.type;
	}
	
	@JsonIgnore
	public String getTypeByLike() {
		return "%"+this.type+"%";
	}
	

    /** set 上牌日期. */
	public void setUpbkTime(java.util.Date upbkTime) {
		this.upbkTime = upbkTime;
	}
	
	/** get 上牌日期. */
	public java.util.Date getUpbkTime() {
		return this.upbkTime;
	}
	
	@JsonIgnore
	public java.util.Date getUpbkTimeByLike() {
		return this.upbkTime;
	}
	

    /** set 里程. */
	public void setMileage(java.math.BigDecimal mileage) {
		this.mileage = mileage;
	}
	
	/** get 里程. */
	public java.math.BigDecimal getMileage() {
		return this.mileage;
	}
	
	@JsonIgnore
	public java.math.BigDecimal getMileageByLike() {
		return this.mileage;
	}
	

    /** set 拍照地点. */
	public void setBkCitiy(String bkCitiy) {
		this.bkCitiy = bkCitiy;
	}
	
	/** get 拍照地点. */
	public String getBkCitiy() {
		return this.bkCitiy;
	}
	
	@JsonIgnore
	public String getBkCitiyByLike() {
		return "%"+this.bkCitiy+"%";
	}
	

    /** set 电话号码. */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/** get 电话号码. */
	public String getPhone() {
		return this.phone;
	}
	
	@JsonIgnore
	public String getPhoneByLike() {
		return "%"+this.phone+"%";
	}
	

    /** set 购买价格. */
	public void setPrice(java.math.BigDecimal price) {
		this.price = price;
	}
	
	/** get 购买价格. */
	public java.math.BigDecimal getPrice() {
		return this.price;
	}
	
	@JsonIgnore
	public java.math.BigDecimal getPriceByLike() {
		return this.price;
	}
	

    /** set 估算价格. */
	public void setMprice(java.math.BigDecimal mprice) {
		this.mprice = mprice;
	}
	
	/** get 估算价格. */
	public java.math.BigDecimal getMprice() {
		return this.mprice;
	}
	
	@JsonIgnore
	public java.math.BigDecimal getMpriceByLike() {
		return this.mprice;
	}
	
    /** constructor */
	public EstimateEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param brand			品牌
	 * @param type			车型
	 * @param upbkTime			上牌日期
	 * @param mileage			里程
	 * @param bkCitiy			拍照地点
	 * @param phone			电话号码
	 * @param price			购买价格
	 * @param mprice			估算价格
	 */
	public EstimateEntity(String brand,String type,java.util.Date upbkTime,java.math.BigDecimal mileage,String bkCitiy,String phone,java.math.BigDecimal price,java.math.BigDecimal mprice){
		this();
		this.brand = brand;
		this.type = type;
		this.upbkTime = upbkTime;
		this.mileage = mileage;
		this.bkCitiy = bkCitiy;
		this.phone = phone;
		this.price = price;
		this.mprice = mprice;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("EstimateEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("Brand=").append(getBrand()).append(", ")
			.append("Type=").append(getType()).append(", ")
			.append("UpbkTime=").append(getUpbkTime()).append(", ")
			.append("Mileage=").append(getMileage()).append(", ")
			.append("BkCitiy=").append(getBkCitiy()).append(", ")
			.append("Phone=").append(getPhone()).append(", ")
			.append("Price=").append(getPrice()).append(", ")
			.append("Mprice=").append(getMprice())
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
		if(obj instanceof EstimateEntity == false)
			return false;
		if(this == obj)
			return true;
		EstimateEntity other = (EstimateEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
