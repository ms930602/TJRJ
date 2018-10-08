
package com.ms.warehouse.manage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 车辆信息
 * @author dwf
 * @Date 2018-07-26 18:37:47
 * @since 1.0
 */
@TableName("t_base_vehicleinfo")
public class VehicleinfoEntity extends BaseEntity {
	
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
	
	/** 所属车队. */
	private String carteamId;
	
	/** 建立时间. */
	private java.util.Date createTime;
	
	/** 运输能力. */
	private String tranAbility;
	
	/** 车辆状态. */
	private String state;
	
	/** 驾驶员编号. */
	private String driverId;
	
	/** 物流部门核查. */
	private String ischeck;
	
	/** 类型. */
	private String type;
	
	/** 备注. */
	private String remark;
	
	/** 准载量. */
	private String transbility;
	
	/** 标准文件. */
	private String file;
	
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
	

    /** set 建立时间. */
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
	/** get 建立时间. */
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	
	@JsonIgnore
	public java.util.Date getCreateTimeByLike() {
		return this.createTime;
	}
	

    /** set 运输能力. */
	public void setTranAbility(String tranAbility) {
		this.tranAbility = tranAbility;
	}
	
	/** get 运输能力. */
	public String getTranAbility() {
		return this.tranAbility;
	}
	
	@JsonIgnore
	public String getTranAbilityByLike() {
		return "%"+this.tranAbility+"%";
	}
	

    /** set 车辆状态. */
	public void setState(String state) {
		this.state = state;
	}
	
	/** get 车辆状态. */
	public String getState() {
		return this.state;
	}
	
	@JsonIgnore
	public String getStateByLike() {
		return "%"+this.state+"%";
	}
	

    /** set 驾驶员编号. */
	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}
	
	/** get 驾驶员编号. */
	public String getDriverId() {
		return this.driverId;
	}
	
	@JsonIgnore
	public String getDriverIdByLike() {
		return "%"+this.driverId+"%";
	}
	

    /** set 物流部门核查. */
	public void setIscheck(String ischeck) {
		this.ischeck = ischeck;
	}
	
	/** get 物流部门核查. */
	public String getIscheck() {
		return this.ischeck;
	}
	
	@JsonIgnore
	public String getIscheckByLike() {
		return "%"+this.ischeck+"%";
	}
	

    /** set 类型. */
	public void setType(String type) {
		this.type = type;
	}
	
	/** get 类型. */
	public String getType() {
		return this.type;
	}
	
	@JsonIgnore
	public String getTypeByLike() {
		return "%"+this.type+"%";
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
	

    /** set 准载量. */
	public void setTransbility(String transbility) {
		this.transbility = transbility;
	}
	
	/** get 准载量. */
	public String getTransbility() {
		return this.transbility;
	}
	
	@JsonIgnore
	public String getTransbilityByLike() {
		return "%"+this.transbility+"%";
	}
	

    /** set 标准文件. */
	public void setFile(String file) {
		this.file = file;
	}
	
	/** get 标准文件. */
	public String getFile() {
		return this.file;
	}
	
	@JsonIgnore
	public String getFileByLike() {
		return "%"+this.file+"%";
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
	public VehicleinfoEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param dataId			主数据id
	 * @param code			代码
	 * @param name			名称
	 * @param carteamId			所属车队
	 * @param createTime			建立时间
	 * @param tranAbility			运输能力
	 * @param state			车辆状态
	 * @param driverId			驾驶员编号
	 * @param ischeck			物流部门核查
	 * @param type			类型
	 * @param remark			备注
	 * @param transbility			准载量
	 * @param file			标准文件
	 * @param status			状态 2：发布
3：停用
	 * @param creator			创建人
	 * @param createtime			创建时间
	 * @param modifier			修改者
	 * @param modifytime			修改时间
	 */
	public VehicleinfoEntity(String dataId,String code,String name,String carteamId,java.util.Date createTime,String tranAbility,String state,String driverId,String ischeck,String type,String remark,String transbility,String file,String status,String creator,java.util.Date createtime,String modifier,java.util.Date modifytime){
		this();
		this.dataId = dataId;
		this.code = code;
		this.name = name;
		this.carteamId = carteamId;
		this.createTime = createTime;
		this.tranAbility = tranAbility;
		this.state = state;
		this.driverId = driverId;
		this.ischeck = ischeck;
		this.type = type;
		this.remark = remark;
		this.transbility = transbility;
		this.file = file;
		this.status = status;
		this.creator = creator;
		this.createtime = createtime;
		this.modifier = modifier;
		this.modifytime = modifytime;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("VehicleinfoEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("DataId=").append(getDataId()).append(", ")
			.append("Code=").append(getCode()).append(", ")
			.append("Name=").append(getName()).append(", ")
			.append("CarteamId=").append(getCarteamId()).append(", ")
			.append("CreateTime=").append(getCreateTime()).append(", ")
			.append("TranAbility=").append(getTranAbility()).append(", ")
			.append("State=").append(getState()).append(", ")
			.append("DriverId=").append(getDriverId()).append(", ")
			.append("Ischeck=").append(getIscheck()).append(", ")
			.append("Type=").append(getType()).append(", ")
			.append("Remark=").append(getRemark()).append(", ")
			.append("Transbility=").append(getTransbility()).append(", ")
			.append("File=").append(getFile()).append(", ")
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
		if(obj instanceof VehicleinfoEntity == false)
			return false;
		if(this == obj)
			return true;
		VehicleinfoEntity other = (VehicleinfoEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
