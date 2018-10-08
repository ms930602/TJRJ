
package com.ms.warehouse.manage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 提升机设备
 * @author dwx
 * @Date 2018-07-11 10:28:42
 * @since 1.0
 */
@TableName("t_dev_hoist")
public class HoistEntity extends BaseEntity {
	
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
	
	/** 编号、序列号. */
	private String serialNum;
	
	/** 生产日期. */
	private java.util.Date productDate;
	
	/** 额定载荷. */
	private String ratedLoad;
	
	/** 净升行程. */
	private String netLift;
	
	/** 最低高度. */
	private String minHeight;
	
	/** 平台尺寸. */
	private String platformSize;
	
	/** 电机功率. */
	private String motorPower;
	
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
	

    /** set 额定载荷. */
	public void setRatedLoad(String ratedLoad) {
		this.ratedLoad = ratedLoad;
	}
	
	/** get 额定载荷. */
	public String getRatedLoad() {
		return this.ratedLoad;
	}
	
	@JsonIgnore
	public String getRatedLoadByLike() {
		return "%"+this.ratedLoad+"%";
	}
	

    /** set 净升行程. */
	public void setNetLift(String netLift) {
		this.netLift = netLift;
	}
	
	/** get 净升行程. */
	public String getNetLift() {
		return this.netLift;
	}
	
	@JsonIgnore
	public String getNetLiftByLike() {
		return "%"+this.netLift+"%";
	}
	

    /** set 最低高度. */
	public void setMinHeight(String minHeight) {
		this.minHeight = minHeight;
	}
	
	/** get 最低高度. */
	public String getMinHeight() {
		return this.minHeight;
	}
	
	@JsonIgnore
	public String getMinHeightByLike() {
		return "%"+this.minHeight+"%";
	}
	

    /** set 平台尺寸. */
	public void setPlatformSize(String platformSize) {
		this.platformSize = platformSize;
	}
	
	/** get 平台尺寸. */
	public String getPlatformSize() {
		return this.platformSize;
	}
	
	@JsonIgnore
	public String getPlatformSizeByLike() {
		return "%"+this.platformSize+"%";
	}
	

    /** set 电机功率. */
	public void setMotorPower(String motorPower) {
		this.motorPower = motorPower;
	}
	
	/** get 电机功率. */
	public String getMotorPower() {
		return this.motorPower;
	}
	
	@JsonIgnore
	public String getMotorPowerByLike() {
		return "%"+this.motorPower+"%";
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
	public HoistEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param factory			厂家
	 * @param brand			品牌
	 * @param spec			型号
	 * @param serialNum			编号、序列号
	 * @param productDate			生产日期
	 * @param ratedLoad			额定载荷
	 * @param netLift			净升行程
	 * @param minHeight			最低高度
	 * @param platformSize			平台尺寸
	 * @param motorPower			电机功率
	 * @param charge			责任人
	 * @param createdDate			创建时间
	 * @param createdPersonId			创建人id
	 * @param createdPerson			创建人
	 * @param updatedDate			更新时间
	 * @param updatedPersonId			更新人id
	 * @param updatedPerson			修改人
	 */
	public HoistEntity(String factory,String brand,String spec,String serialNum,java.util.Date productDate,String ratedLoad,String netLift,String minHeight,String platformSize,String motorPower,String charge,java.util.Date createdDate,Long createdPersonId,String createdPerson,java.util.Date updatedDate,Long updatedPersonId,String updatedPerson){
		this();
		this.factory = factory;
		this.brand = brand;
		this.spec = spec;
		this.serialNum = serialNum;
		this.productDate = productDate;
		this.ratedLoad = ratedLoad;
		this.netLift = netLift;
		this.minHeight = minHeight;
		this.platformSize = platformSize;
		this.motorPower = motorPower;
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
		return new StringBuilder().append("HoistEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("Factory=").append(getFactory()).append(", ")
			.append("Brand=").append(getBrand()).append(", ")
			.append("Spec=").append(getSpec()).append(", ")
			.append("SerialNum=").append(getSerialNum()).append(", ")
			.append("ProductDate=").append(getProductDate()).append(", ")
			.append("RatedLoad=").append(getRatedLoad()).append(", ")
			.append("NetLift=").append(getNetLift()).append(", ")
			.append("MinHeight=").append(getMinHeight()).append(", ")
			.append("PlatformSize=").append(getPlatformSize()).append(", ")
			.append("MotorPower=").append(getMotorPower()).append(", ")
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
		if(obj instanceof HoistEntity == false)
			return false;
		if(this == obj)
			return true;
		HoistEntity other = (HoistEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
