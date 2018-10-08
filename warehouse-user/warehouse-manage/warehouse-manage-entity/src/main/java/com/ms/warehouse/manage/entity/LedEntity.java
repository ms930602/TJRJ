
package com.ms.warehouse.manage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * LED显示器设备
 * @author dwx
 * @Date 2018-07-11 10:28:42
 * @since 1.0
 */
@TableName("t_dev_led")
public class LedEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** 自增id. */
	private Long id;
	
	/** 厂家. */
	private String factory;
	
	/** 品牌. */
	private String brand;
	
	/** 型号. */
	private String spec;
	
	/** 尺寸. */
	private String size;
	
	/** 编号、序列号. */
	private String serialNum;
	
	/** 通道id. */
	private Long passwayId;
	
	/** 通道编号. */
	private String passwayNo;
	
	/** 分辨率. */
	private String resolvRate;
	
	/** 生产日期. */
	private java.util.Date productDate;
	
	/** 责任人. */
	private String charge;
	
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
	

    /** set 厂家. */
	public void setFactory(String factory) {
		this.factory = factory;
	}
	
	/** get 厂家. */
	public String getFactory() {
		return this.factory;
	}
	
	@JsonIgnore
	public String getFactoryByLike() {
		return "%"+this.factory+"%";
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
	

    /** set 型号. */
	public void setSpec(String spec) {
		this.spec = spec;
	}
	
	/** get 型号. */
	public String getSpec() {
		return this.spec;
	}
	
	@JsonIgnore
	public String getSpecByLike() {
		return "%"+this.spec+"%";
	}
	

    /** set 尺寸. */
	public void setSize(String size) {
		this.size = size;
	}
	
	/** get 尺寸. */
	public String getSize() {
		return this.size;
	}
	
	@JsonIgnore
	public String getSizeByLike() {
		return "%"+this.size+"%";
	}
	

    /** set 编号、序列号. */
	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}
	
	/** get 编号、序列号. */
	public String getSerialNum() {
		return this.serialNum;
	}
	
	@JsonIgnore
	public String getSerialNumByLike() {
		return "%"+this.serialNum+"%";
	}
	

    /** set 通道id. */
	public void setPasswayId(Long passwayId) {
		this.passwayId = passwayId;
	}
	
	/** get 通道id. */
	public Long getPasswayId() {
		return this.passwayId;
	}
	
	@JsonIgnore
	public Long getPasswayIdByLike() {
		return this.passwayId;
	}
	

    /** set 通道编号. */
	public void setPasswayNo(String passwayNo) {
		this.passwayNo = passwayNo;
	}
	
	/** get 通道编号. */
	public String getPasswayNo() {
		return this.passwayNo;
	}
	
	@JsonIgnore
	public String getPasswayNoByLike() {
		return "%"+this.passwayNo+"%";
	}
	

    /** set 分辨率. */
	public void setResolvRate(String resolvRate) {
		this.resolvRate = resolvRate;
	}
	
	/** get 分辨率. */
	public String getResolvRate() {
		return this.resolvRate;
	}
	
	@JsonIgnore
	public String getResolvRateByLike() {
		return "%"+this.resolvRate+"%";
	}
	

    /** set 生产日期. */
	public void setProductDate(java.util.Date productDate) {
		this.productDate = productDate;
	}
	
	/** get 生产日期. */
	public java.util.Date getProductDate() {
		return this.productDate;
	}
	
	@JsonIgnore
	public java.util.Date getProductDateByLike() {
		return this.productDate;
	}
	

    /** set 责任人. */
	public void setCharge(String charge) {
		this.charge = charge;
	}
	
	/** get 责任人. */
	public String getCharge() {
		return this.charge;
	}
	
	@JsonIgnore
	public String getChargeByLike() {
		return "%"+this.charge+"%";
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
	public LedEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param factory			厂家
	 * @param brand			品牌
	 * @param spec			型号
	 * @param size			尺寸
	 * @param serialNum			编号、序列号
	 * @param passwayId			通道id
	 * @param passwayNo			通道编号
	 * @param resolvRate			分辨率
	 * @param productDate			生产日期
	 * @param charge			责任人
	 * @param createdDate			创建时间
	 * @param createdPersonId			创建人id
	 * @param createdPerson			创建人
	 * @param updatedDate			更新时间
	 * @param updatedPersonId			更新人id
	 * @param updatedPerson			修改人
	 */
	public LedEntity(String factory,String brand,String spec,String size,String serialNum,Long passwayId,String passwayNo,String resolvRate,java.util.Date productDate,String charge,java.util.Date createdDate,Long createdPersonId,String createdPerson,java.util.Date updatedDate,Long updatedPersonId,String updatedPerson){
		this();
		this.factory = factory;
		this.brand = brand;
		this.spec = spec;
		this.size = size;
		this.serialNum = serialNum;
		this.passwayId = passwayId;
		this.passwayNo = passwayNo;
		this.resolvRate = resolvRate;
		this.productDate = productDate;
		this.charge = charge;
		this.createdDate = createdDate;
		this.createdPersonId = createdPersonId;
		this.createdPerson = createdPerson;
		this.updatedDate = updatedDate;
		this.updatedPersonId = updatedPersonId;
		this.updatedPerson = updatedPerson;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("LedEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("Factory=").append(getFactory()).append(", ")
			.append("Brand=").append(getBrand()).append(", ")
			.append("Spec=").append(getSpec()).append(", ")
			.append("Size=").append(getSize()).append(", ")
			.append("SerialNum=").append(getSerialNum()).append(", ")
			.append("PasswayId=").append(getPasswayId()).append(", ")
			.append("PasswayNo=").append(getPasswayNo()).append(", ")
			.append("ResolvRate=").append(getResolvRate()).append(", ")
			.append("ProductDate=").append(getProductDate()).append(", ")
			.append("Charge=").append(getCharge()).append(", ")
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
		if(obj instanceof LedEntity == false)
			return false;
		if(this == obj)
			return true;
		LedEntity other = (LedEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
