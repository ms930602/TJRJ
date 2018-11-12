
package com.ms.warehouse.car.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 
 * @author Ms
 * @Date 2018-11-12 09:35:03
 * @since 1.0
 */
@TableName("t_car_user")
public class CarUserEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** 主键. */
	private Long id;
	
	/** 品牌. */
	private String brand;
	
	/** 车型. */
	private String type;
	
	/** 拍照归属. */
	private String bkCitiy;
	
	/** 上牌日期. */
	private java.util.Date upbkTime;
	
	/** 表显里程. */
	private java.math.BigDecimal mileage;
	
	/** 图片外键. */
	private Long imgId;
	
	/** 图片路径. */
	private String imgPath;
	
	/** 期望售价. */
	private java.math.BigDecimal price;
	
	/** 手机号码. */
	private String phone;
	
	/** 0 未处理 1已处理. */
	private String status;
	
	/** 关联车辆. */
	private Long carInfoId;
	
	/** 创建时间. */
	private java.util.Date createtime;
	
	/** . */
	private String strA;
	
	/** . */
	private String strB;
	
	/** . */
	private Long intA;
	
	/** . */
	private Long intB;
	
	

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
	

    /** set 拍照归属. */
	public void setBkCitiy(String bkCitiy) {
		this.bkCitiy = bkCitiy;
	}
	
	/** get 拍照归属. */
	public String getBkCitiy() {
		return this.bkCitiy;
	}
	
	@JsonIgnore
	public String getBkCitiyByLike() {
		return "%"+this.bkCitiy+"%";
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
	

    /** set 表显里程. */
	public void setMileage(java.math.BigDecimal mileage) {
		this.mileage = mileage;
	}
	
	/** get 表显里程. */
	public java.math.BigDecimal getMileage() {
		return this.mileage;
	}
	
	@JsonIgnore
	public java.math.BigDecimal getMileageByLike() {
		return this.mileage;
	}
	

    /** set 图片外键. */
	public void setImgId(Long imgId) {
		this.imgId = imgId;
	}
	
	/** get 图片外键. */
	public Long getImgId() {
		return this.imgId;
	}
	
	@JsonIgnore
	public Long getImgIdByLike() {
		return this.imgId;
	}
	

    /** set 图片路径. */
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
	/** get 图片路径. */
	public String getImgPath() {
		return this.imgPath;
	}
	
	@JsonIgnore
	public String getImgPathByLike() {
		return "%"+this.imgPath+"%";
	}
	

    /** set 期望售价. */
	public void setPrice(java.math.BigDecimal price) {
		this.price = price;
	}
	
	/** get 期望售价. */
	public java.math.BigDecimal getPrice() {
		return this.price;
	}
	
	@JsonIgnore
	public java.math.BigDecimal getPriceByLike() {
		return this.price;
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
	

    /** set 0 未处理 1已处理. */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/** get 0 未处理 1已处理. */
	public String getStatus() {
		return this.status;
	}
	
	@JsonIgnore
	public String getStatusByLike() {
		return this.status;
	}
	

    /** set 关联车辆. */
	public void setCarInfoId(Long carInfoId) {
		this.carInfoId = carInfoId;
	}
	
	/** get 关联车辆. */
	public Long getCarInfoId() {
		return this.carInfoId;
	}
	
	@JsonIgnore
	public Long getCarInfoIdByLike() {
		return this.carInfoId;
	}
	

    /** set 创建时间. */
	public void setCreatetime(java.util.Date createtime) {
		this.createtime = createtime;
	}
	
	/** get 创建时间. */
	public java.util.Date getCreatetime() {
		return this.createtime;
	}
	
	@JsonIgnore
	public java.util.Date getCreatetimeByLike() {
		return this.createtime;
	}
	

    /** set . */
	public void setStrA(String strA) {
		this.strA = strA;
	}
	
	/** get . */
	public String getStrA() {
		return this.strA;
	}
	
	@JsonIgnore
	public String getStrAByLike() {
		return "%"+this.strA+"%";
	}
	

    /** set . */
	public void setStrB(String strB) {
		this.strB = strB;
	}
	
	/** get . */
	public String getStrB() {
		return this.strB;
	}
	
	@JsonIgnore
	public String getStrBByLike() {
		return "%"+this.strB+"%";
	}
	

    /** set . */
	public void setIntA(Long intA) {
		this.intA = intA;
	}
	
	/** get . */
	public Long getIntA() {
		return this.intA;
	}
	
	@JsonIgnore
	public Long getIntAByLike() {
		return this.intA;
	}
	

    /** set . */
	public void setIntB(Long intB) {
		this.intB = intB;
	}
	
	/** get . */
	public Long getIntB() {
		return this.intB;
	}
	
	@JsonIgnore
	public Long getIntBByLike() {
		return this.intB;
	}
	
    /** constructor */
	public CarUserEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param brand			品牌
	 * @param type			车型
	 * @param bkCitiy			拍照归属
	 * @param upbkTime			上牌日期
	 * @param mileage			表显里程
	 * @param imgId			图片外键
	 * @param imgPath			图片路径
	 * @param price			期望售价
	 * @param phone			手机号码
	 * @param status			0 未处理 1已处理
	 * @param carInfoId			关联车辆
	 * @param createtime			创建时间
	 * @param strA			
	 * @param strB			
	 * @param intA			
	 * @param intB			
	 */
	public CarUserEntity(String brand,String type,String bkCitiy,java.util.Date upbkTime,java.math.BigDecimal mileage,Long imgId,String imgPath,java.math.BigDecimal price,String phone,String status,Long carInfoId,java.util.Date createtime,String strA,String strB,Long intA,Long intB){
		this();
		this.brand = brand;
		this.type = type;
		this.bkCitiy = bkCitiy;
		this.upbkTime = upbkTime;
		this.mileage = mileage;
		this.imgId = imgId;
		this.imgPath = imgPath;
		this.price = price;
		this.phone = phone;
		this.status = status;
		this.carInfoId = carInfoId;
		this.createtime = createtime;
		this.strA = strA;
		this.strB = strB;
		this.intA = intA;
		this.intB = intB;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("CarUserEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("Brand=").append(getBrand()).append(", ")
			.append("Type=").append(getType()).append(", ")
			.append("BkCitiy=").append(getBkCitiy()).append(", ")
			.append("UpbkTime=").append(getUpbkTime()).append(", ")
			.append("Mileage=").append(getMileage()).append(", ")
			.append("ImgId=").append(getImgId()).append(", ")
			.append("ImgPath=").append(getImgPath()).append(", ")
			.append("Price=").append(getPrice()).append(", ")
			.append("Phone=").append(getPhone()).append(", ")
			.append("Status=").append(getStatus()).append(", ")
			.append("CarInfoId=").append(getCarInfoId()).append(", ")
			.append("Createtime=").append(getCreatetime()).append(", ")
			.append("StrA=").append(getStrA()).append(", ")
			.append("StrB=").append(getStrB()).append(", ")
			.append("IntA=").append(getIntA()).append(", ")
			.append("IntB=").append(getIntB())
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
		if(obj instanceof CarUserEntity == false)
			return false;
		if(this == obj)
			return true;
		CarUserEntity other = (CarUserEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
