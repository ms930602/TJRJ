
package com.ms.warehouse.manage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 承运单位
 * @author dwf
 * @Date 2018-07-26 18:37:48
 * @since 1.0
 */
@TableName("t_base_carrierunit")
public class CarrierunitEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** 自增id. */
	private Long id;
	
	/** 主数据id. */
	private String dataId;
	
	/** 代码. */
	private String code;
	
	/** 名称. */
	private String name;
	
	/** 车队负责人. */
	private String principal;
	
	/** 固定电话. */
	private String telephone;
	
	/** 地址. */
	private String address;
	
	/** 录入时间. */
	private String createTime;
	
	/** 所属仓库. */
	private String whId;
	
	/** 主要联系人. */
	private String mainContactor;
	
	/** 联系人固定电话. */
	private String contactorPhone;
	
	/** 联系人手机号. */
	private String contactorMobile;
	
	/** 类型 6101:公铁快运
6102:汽车
类型  6103:飞机
6104:传输带
6106:公铁联运
6107:自提
6108:铁路集装箱
6109:火车. */
	private String carrierType;
	
	/** 支付地点 1:四川
2:重庆. */
	private String payplaceid;
	
	/** 状态 2：发布
3：停用. */
	private String status;
	
	/** 创建人. */
	private String creator;
	
	/** 创建时间. */
	private java.util.Date createtime;
	
	/** 修改者. */
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
	

    /** set 代码. */
	public void setCode(String code) {
		this.code = code;
	}
	
	/** get 代码. */
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
	

    /** set 车队负责人. */
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	
	/** get 车队负责人. */
	public String getPrincipal() {
		return this.principal;
	}
	
	@JsonIgnore
	public String getPrincipalByLike() {
		return "%"+this.principal+"%";
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
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	/** get 录入时间. */
	public String getCreateTime() {
		return this.createTime;
	}
	
	@JsonIgnore
	public String getCreateTimeByLike() {
		return "%"+this.createTime+"%";
	}
	

    /** set 所属仓库. */
	public void setWhId(String whId) {
		this.whId = whId;
	}
	
	/** get 所属仓库. */
	public String getWhId() {
		return this.whId;
	}
	
	@JsonIgnore
	public String getWhIdByLike() {
		return "%"+this.whId+"%";
	}
	

    /** set 主要联系人. */
	public void setMainContactor(String mainContactor) {
		this.mainContactor = mainContactor;
	}
	
	/** get 主要联系人. */
	public String getMainContactor() {
		return this.mainContactor;
	}
	
	@JsonIgnore
	public String getMainContactorByLike() {
		return "%"+this.mainContactor+"%";
	}
	

    /** set 联系人固定电话. */
	public void setContactorPhone(String contactorPhone) {
		this.contactorPhone = contactorPhone;
	}
	
	/** get 联系人固定电话. */
	public String getContactorPhone() {
		return this.contactorPhone;
	}
	
	@JsonIgnore
	public String getContactorPhoneByLike() {
		return "%"+this.contactorPhone+"%";
	}
	

    /** set 联系人手机号. */
	public void setContactorMobile(String contactorMobile) {
		this.contactorMobile = contactorMobile;
	}
	
	/** get 联系人手机号. */
	public String getContactorMobile() {
		return this.contactorMobile;
	}
	
	@JsonIgnore
	public String getContactorMobileByLike() {
		return "%"+this.contactorMobile+"%";
	}
	

    /** set 类型 6101:公铁快运
6102:汽车
类型  6103:飞机
6104:传输带
6106:公铁联运
6107:自提
6108:铁路集装箱
6109:火车. */
	public void setCarrierType(String carrierType) {
		this.carrierType = carrierType;
	}
	
	/** get 类型 6101:公铁快运
6102:汽车
类型  6103:飞机
6104:传输带
6106:公铁联运
6107:自提
6108:铁路集装箱
6109:火车. */
	public String getCarrierType() {
		return this.carrierType;
	}
	
	@JsonIgnore
	public String getCarrierTypeByLike() {
		return "%"+this.carrierType+"%";
	}
	

    /** set 支付地点 1:四川
2:重庆. */
	public void setPayplaceid(String payplaceid) {
		this.payplaceid = payplaceid;
	}
	
	/** get 支付地点 1:四川
2:重庆. */
	public String getPayplaceid() {
		return this.payplaceid;
	}
	
	@JsonIgnore
	public String getPayplaceidByLike() {
		return "%"+this.payplaceid+"%";
	}
	

    /** set 状态 2：发布
3：停用. */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/** get 状态 2：发布
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
	

    /** set 修改者. */
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	
	/** get 修改者. */
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
	public CarrierunitEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param dataId			主数据id
	 * @param code			代码
	 * @param name			名称
	 * @param principal			车队负责人
	 * @param telephone			固定电话
	 * @param address			地址
	 * @param createTime			录入时间
	 * @param whId			所属仓库
	 * @param mainContactor			主要联系人
	 * @param contactorPhone			联系人固定电话
	 * @param contactorMobile			联系人手机号
	 * @param carrierType			类型 6101:公铁快运
6102:汽车
类型  6103:飞机
6104:传输带
6106:公铁联运
6107:自提
6108:铁路集装箱
6109:火车
	 * @param payplaceid			支付地点 1:四川
2:重庆
	 * @param status			状态 2：发布
3：停用
	 * @param creator			创建人
	 * @param createtime			创建时间
	 * @param modifier			修改者
	 * @param modifytime			修改时间
	 */
	public CarrierunitEntity(String dataId,String code,String name,String principal,String telephone,String address,String createTime,String whId,String mainContactor,String contactorPhone,String contactorMobile,String carrierType,String payplaceid,String status,String creator,java.util.Date createtime,String modifier,java.util.Date modifytime){
		this();
		this.dataId = dataId;
		this.code = code;
		this.name = name;
		this.principal = principal;
		this.telephone = telephone;
		this.address = address;
		this.createTime = createTime;
		this.whId = whId;
		this.mainContactor = mainContactor;
		this.contactorPhone = contactorPhone;
		this.contactorMobile = contactorMobile;
		this.carrierType = carrierType;
		this.payplaceid = payplaceid;
		this.status = status;
		this.creator = creator;
		this.createtime = createtime;
		this.modifier = modifier;
		this.modifytime = modifytime;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("CarrierunitEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("DataId=").append(getDataId()).append(", ")
			.append("Code=").append(getCode()).append(", ")
			.append("Name=").append(getName()).append(", ")
			.append("Principal=").append(getPrincipal()).append(", ")
			.append("Telephone=").append(getTelephone()).append(", ")
			.append("Address=").append(getAddress()).append(", ")
			.append("CreateTime=").append(getCreateTime()).append(", ")
			.append("WhId=").append(getWhId()).append(", ")
			.append("MainContactor=").append(getMainContactor()).append(", ")
			.append("ContactorPhone=").append(getContactorPhone()).append(", ")
			.append("ContactorMobile=").append(getContactorMobile()).append(", ")
			.append("CarrierType=").append(getCarrierType()).append(", ")
			.append("Payplaceid=").append(getPayplaceid()).append(", ")
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
		if(obj instanceof CarrierunitEntity == false)
			return false;
		if(this == obj)
			return true;
		CarrierunitEntity other = (CarrierunitEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
