
package com.ms.warehouse.manage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 驾驶员
 * @author dwf
 * @Date 2018-07-26 18:37:48
 * @since 1.0
 */
@TableName("t_base_drivers")
public class DriversEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** 自增id. */
	private Long id;
	
	/** 主数据id. */
	private String dataId;
	
	/** 编码. */
	private String code;
	
	/** 名称. */
	private String name;
	
	/** 身份证. */
	private String idCard;
	
	/** 手机. */
	private String mobile;
	
	/** 固定电话. */
	private String telephone;
	
	/** 地址. */
	private String address;
	
	/** 录入时间. */
	private java.util.Date createTime;
	
	/** 所属车队. */
	private String carteamId;
	
	/** 其他. */
	private String other;
	
	/** 是否有效. */
	private String state;
	
	/** 驾驶证. */
	private String driverCard;
	
	/** 性别. */
	private String sex;
	
	/** 年龄. */
	private String age;
	
	/** 物流部门审核. */
	private String ischeck;
	
	/** 状态2：发布
3：停用. */
	private String status;
	
	/** 创建人. */
	private String creator;
	
	/** 创建时间. */
	private java.util.Date createtime;
	
	/** 修改人. */
	private String modifier;
	
	/** 修改时间. */
	private java.util.Date modifytime;
	
	

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
	

    /** set 主数据id. */
	public void setDataId(String dataId) {
		this.dataId = dataId;
	}
	
	/** get 主数据id. */
	public String getDataId() {
		return this.dataId;
	}
	
	@JsonIgnore
	public String getDataIdByLike() {
		return "%"+this.dataId+"%";
	}
	

    /** set 编码. */
	public void setCode(String code) {
		this.code = code;
	}
	
	/** get 编码. */
	public String getCode() {
		return this.code;
	}
	
	@JsonIgnore
	public String getCodeByLike() {
		return "%"+this.code+"%";
	}
	

    /** set 名称. */
	public void setName(String name) {
		this.name = name;
	}
	
	/** get 名称. */
	public String getName() {
		return this.name;
	}
	
	@JsonIgnore
	public String getNameByLike() {
		return "%"+this.name+"%";
	}
	

    /** set 身份证. */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	
	/** get 身份证. */
	public String getIdCard() {
		return this.idCard;
	}
	
	@JsonIgnore
	public String getIdCardByLike() {
		return "%"+this.idCard+"%";
	}
	

    /** set 手机. */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	/** get 手机. */
	public String getMobile() {
		return this.mobile;
	}
	
	@JsonIgnore
	public String getMobileByLike() {
		return "%"+this.mobile+"%";
	}
	

    /** set 固定电话. */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	/** get 固定电话. */
	public String getTelephone() {
		return this.telephone;
	}
	
	@JsonIgnore
	public String getTelephoneByLike() {
		return "%"+this.telephone+"%";
	}
	

    /** set 地址. */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/** get 地址. */
	public String getAddress() {
		return this.address;
	}
	
	@JsonIgnore
	public String getAddressByLike() {
		return "%"+this.address+"%";
	}
	

    /** set 录入时间. */
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
	/** get 录入时间. */
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	
	@JsonIgnore
	public java.util.Date getCreateTimeByLike() {
		return this.createTime;
	}
	

    /** set 所属车队. */
	public void setCarteamId(String carteamId) {
		this.carteamId = carteamId;
	}
	
	/** get 所属车队. */
	public String getCarteamId() {
		return this.carteamId;
	}
	
	@JsonIgnore
	public String getCarteamIdByLike() {
		return "%"+this.carteamId+"%";
	}
	

    /** set 其他. */
	public void setOther(String other) {
		this.other = other;
	}
	
	/** get 其他. */
	public String getOther() {
		return this.other;
	}
	
	@JsonIgnore
	public String getOtherByLike() {
		return "%"+this.other+"%";
	}
	

    /** set 是否有效. */
	public void setState(String state) {
		this.state = state;
	}
	
	/** get 是否有效. */
	public String getState() {
		return this.state;
	}
	
	@JsonIgnore
	public String getStateByLike() {
		return "%"+this.state+"%";
	}
	

    /** set 驾驶证. */
	public void setDriverCard(String driverCard) {
		this.driverCard = driverCard;
	}
	
	/** get 驾驶证. */
	public String getDriverCard() {
		return this.driverCard;
	}
	
	@JsonIgnore
	public String getDriverCardByLike() {
		return "%"+this.driverCard+"%";
	}
	

    /** set 性别. */
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	/** get 性别. */
	public String getSex() {
		return this.sex;
	}
	
	@JsonIgnore
	public String getSexByLike() {
		return "%"+this.sex+"%";
	}
	

    /** set 年龄. */
	public void setAge(String age) {
		this.age = age;
	}
	
	/** get 年龄. */
	public String getAge() {
		return this.age;
	}
	
	@JsonIgnore
	public String getAgeByLike() {
		return "%"+this.age+"%";
	}
	

    /** set 物流部门审核. */
	public void setIscheck(String ischeck) {
		this.ischeck = ischeck;
	}
	
	/** get 物流部门审核. */
	public String getIscheck() {
		return this.ischeck;
	}
	
	@JsonIgnore
	public String getIscheckByLike() {
		return "%"+this.ischeck+"%";
	}
	

    /** set 状态2：发布
3：停用. */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/** get 状态2：发布
3：停用. */
	public String getStatus() {
		return this.status;
	}
	
	@JsonIgnore
	public String getStatusByLike() {
		return "%"+this.status+"%";
	}
	

    /** set 创建人. */
	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	/** get 创建人. */
	public String getCreator() {
		return this.creator;
	}
	
	@JsonIgnore
	public String getCreatorByLike() {
		return "%"+this.creator+"%";
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
	

    /** set 修改人. */
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	
	/** get 修改人. */
	public String getModifier() {
		return this.modifier;
	}
	
	@JsonIgnore
	public String getModifierByLike() {
		return "%"+this.modifier+"%";
	}
	

    /** set 修改时间. */
	public void setModifytime(java.util.Date modifytime) {
		this.modifytime = modifytime;
	}
	
	/** get 修改时间. */
	public java.util.Date getModifytime() {
		return this.modifytime;
	}
	
	@JsonIgnore
	public java.util.Date getModifytimeByLike() {
		return this.modifytime;
	}
	
    /** constructor */
	public DriversEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param dataId			主数据id
	 * @param code			编码
	 * @param name			名称
	 * @param idCard			身份证
	 * @param mobile			手机
	 * @param telephone			固定电话
	 * @param address			地址
	 * @param createTime			录入时间
	 * @param carteamId			所属车队
	 * @param other			其他
	 * @param state			是否有效
	 * @param driverCard			驾驶证
	 * @param sex			性别
	 * @param age			年龄
	 * @param ischeck			物流部门审核
	 * @param status			状态2：发布
3：停用
	 * @param creator			创建人
	 * @param createtime			创建时间
	 * @param modifier			修改人
	 * @param modifytime			修改时间
	 */
	public DriversEntity(String dataId,String code,String name,String idCard,String mobile,String telephone,String address,java.util.Date createTime,String carteamId,String other,String state,String driverCard,String sex,String age,String ischeck,String status,String creator,java.util.Date createtime,String modifier,java.util.Date modifytime){
		this();
		this.dataId = dataId;
		this.code = code;
		this.name = name;
		this.idCard = idCard;
		this.mobile = mobile;
		this.telephone = telephone;
		this.address = address;
		this.createTime = createTime;
		this.carteamId = carteamId;
		this.other = other;
		this.state = state;
		this.driverCard = driverCard;
		this.sex = sex;
		this.age = age;
		this.ischeck = ischeck;
		this.status = status;
		this.creator = creator;
		this.createtime = createtime;
		this.modifier = modifier;
		this.modifytime = modifytime;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("DriversEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("DataId=").append(getDataId()).append(", ")
			.append("Code=").append(getCode()).append(", ")
			.append("Name=").append(getName()).append(", ")
			.append("IdCard=").append(getIdCard()).append(", ")
			.append("Mobile=").append(getMobile()).append(", ")
			.append("Telephone=").append(getTelephone()).append(", ")
			.append("Address=").append(getAddress()).append(", ")
			.append("CreateTime=").append(getCreateTime()).append(", ")
			.append("CarteamId=").append(getCarteamId()).append(", ")
			.append("Other=").append(getOther()).append(", ")
			.append("State=").append(getState()).append(", ")
			.append("DriverCard=").append(getDriverCard()).append(", ")
			.append("Sex=").append(getSex()).append(", ")
			.append("Age=").append(getAge()).append(", ")
			.append("Ischeck=").append(getIscheck()).append(", ")
			.append("Status=").append(getStatus()).append(", ")
			.append("Creator=").append(getCreator()).append(", ")
			.append("Createtime=").append(getCreatetime()).append(", ")
			.append("Modifier=").append(getModifier()).append(", ")
			.append("Modifytime=").append(getModifytime())
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
		if(obj instanceof DriversEntity == false)
			return false;
		if(this == obj)
			return true;
		DriversEntity other = (DriversEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
