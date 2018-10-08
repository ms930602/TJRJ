
package com.ms.warehouse.manage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 货位信息
 * @author dwf
 * @Date 2018-07-12 08:46:22
 * @since 1.0
 */
@TableName("t_base_locationinfo")
public class LocationinfoEntity extends BaseEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 自增id. */
	private Long id;

	/** 区域id. */
	private Long areaId;
	
	/** 区域块. */
	private Long areaBlock;

	/** 区域排. */
	private Long areaRow;

	/** 区域号. */
	private Long areaNum;

	/** 上下层  1;上层 2 下层. */
	private Long upDown;

	/** 货位状态 ：0空闲中 1 使用中. */
	private Long status;

	/** 货位编码. */
	private String localCode;

	/** 货位对应rfid 编号. */
	private String localRfid;

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

	/** 货位描述. */
	private String descript;
	
	/** 物料组-组号. */
	private Long groupNo;
	
	/** 是否靠墙 0否 1 是. */
	private Long isonthewall;

	private String areaCode;

	private String floorName;
	
	private String floorCode;

	private String floorAreaCode;

	public String getFloorCode() {
		return floorCode;
	}

	public void setFloorCode(String floorCode) {
		this.floorCode = floorCode;
	}

	public void setFloorAreaCode(String floorAreaCode) {
		this.floorAreaCode = floorAreaCode;
	}

	public String getFloorAreaCode() {
		return floorAreaCode;
	}

	public String getFloorName() {
		return floorName;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

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


	/** set 区域id. */
	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	/** get 区域id. */
	public Long getAreaId() {
		return this.areaId;
	}

	@JsonIgnore
	public Long getAreaIdByLike() {
		return this.areaId;
	}
	/** set 区域块. */
	public void setAreaBlock(Long areaBlock) {
		this.areaBlock = areaBlock;
	}
	
	/** get 区域块. */
	public Long getAreaBlock() {
		return this.areaBlock;
	}

	@JsonIgnore
	public Long getAreaBlockByLike() {
		return this.areaBlock;
	}
	
	/** set 区域排. */
	public void setAreaRow(Long areaRow) {
		this.areaRow = areaRow;
	}

	/** get 区域排. */
	public Long getAreaRow() {
		return this.areaRow;
	}

	@JsonIgnore
	public Long getAreaRowByLike() {
		return this.areaRow;
	}


	/** set 区域号. */
	public void setAreaNum(Long areaNum) {
		this.areaNum = areaNum;
	}

	/** get 区域号. */
	public Long getAreaNum() {
		return this.areaNum;
	}

	@JsonIgnore
	public Long getAreaNumByLike() {
		return this.areaNum;
	}


	/** set 上下层  1;上层 2 下层. */
	public void setUpDown(Long upDown) {
		this.upDown = upDown;
	}

	/** get 上下层  1;上层 2 下层. */
	public Long getUpDown() {
		return this.upDown;
	}

	@JsonIgnore
	public Long getUpDownByLike() {
		return this.upDown;
	}


	/** set 货位状态 ：0空闲中 1 使用中. */
	public void setStatus(Long status) {
		this.status = status;
	}

	/** get 货位状态 ：0空闲中 1 使用中. */
	public Long getStatus() {
		return this.status;
	}

	@JsonIgnore
	public Long getStatusByLike() {
		return this.status;
	}


	/** set 货位编码. */
	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}

	/** get 货位编码. */
	public String getLocalCode() {
		return this.localCode;
	}

	@JsonIgnore
	public String getLocalCodeByLike() {
		return "%"+this.localCode+"%";
	}


	/** set 货位对应rfid 编号. */
	public void setLocalRfid(String localRfid) {
		this.localRfid = localRfid;
	}

	/** get 货位对应rfid 编号. */
	public String getLocalRfid() {
		return this.localRfid;
	}

	@JsonIgnore
	public String getLocalRfidByLike() {
		return "%"+this.localRfid+"%";
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


	/** set 货位描述. */
	public void setDescript(String descript) {
		this.descript = descript;
	}

	/** get 货位描述. */
	public String getDescript() {
		return this.descript;
	}

	@JsonIgnore
	public String getDescriptByLike() {
		return "%"+this.descript+"%";
	}

    /** set 物料组-组号. */
	public void setGroupNo(Long groupNo) {
		this.groupNo = groupNo;
	}
	
	/** get 物料组-组号. */
	public Long getGroupNo() {
		return this.groupNo;
	}
	
	@JsonIgnore
	public Long getGroupNoByLike() {
		return this.groupNo;
	}
	
    /** set 是否靠墙 0否 1 是. */
	public void setIsonthewall(Long isonthewall) {
		this.isonthewall = isonthewall;
	}
	
	/** get 是否靠墙 0否 1 是. */
	public Long getIsonthewall() {
		return this.isonthewall;
	}
	
	@JsonIgnore
	public Long getIsonthewallByLike() {
		return this.isonthewall;
	}
	
	/** constructor */
	public LocationinfoEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param areaId			区域id
	 * @param areaBlock			区域块
	 * @param areaRow			区域排
	 * @param areaNum			区域号
	 * @param upDown			上下层  1;上层 2 下层
	 * @param status			货位状态 ：0空闲中 1 使用中
	 * @param localCode			货位编码
	 * @param localRfid			货位对应rfid 编号
	 * @param createdDate			创建时间
	 * @param createdPersonId			创建人id
	 * @param createdPerson			创建人
	 * @param updatedDate			更新时间
	 * @param updatedPersonId			更新人id
	 * @param updatedPerson			修改人
	 * @param descript			货位描述
	 * @param groupNo			物料组-组号
	 * @param isonthewall			是否靠墙 0否 1 是
	 */
	public LocationinfoEntity(Long areaId,Long areaBlock,Long areaRow,Long areaNum,Long upDown,Long status,String localCode,String localRfid,java.util.Date createdDate,Long createdPersonId,String createdPerson,java.util.Date updatedDate,Long updatedPersonId,String updatedPerson,String descript,Long groupNo,Long isonthewall){
		this();
		this.areaId = areaId;
		this.areaBlock = areaBlock;
		this.areaRow = areaRow;
		this.areaNum = areaNum;
		this.upDown = upDown;
		this.status = status;
		this.localCode = localCode;
		this.localRfid = localRfid;
		this.createdDate = createdDate;
		this.createdPersonId = createdPersonId;
		this.createdPerson = createdPerson;
		this.updatedDate = updatedDate;
		this.updatedPersonId = updatedPersonId;
		this.updatedPerson = updatedPerson;
		this.descript = descript;
		this.groupNo = groupNo;
		this.isonthewall = isonthewall;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("LocationinfoEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("AreaId=").append(getAreaId()).append(", ")
			.append("AreaBlock=").append(getAreaBlock()).append(", ")
			.append("AreaRow=").append(getAreaRow()).append(", ")
			.append("AreaNum=").append(getAreaNum()).append(", ")
			.append("UpDown=").append(getUpDown()).append(", ")
			.append("Status=").append(getStatus()).append(", ")
			.append("LocalCode=").append(getLocalCode()).append(", ")
			.append("LocalRfid=").append(getLocalRfid()).append(", ")
			.append("CreatedDate=").append(getCreatedDate()).append(", ")
			.append("CreatedPersonId=").append(getCreatedPersonId()).append(", ")
			.append("CreatedPerson=").append(getCreatedPerson()).append(", ")
			.append("UpdatedDate=").append(getUpdatedDate()).append(", ")
			.append("UpdatedPersonId=").append(getUpdatedPersonId()).append(", ")
			.append("UpdatedPerson=").append(getUpdatedPerson()).append(", ")
			.append("Descript=").append(getDescript()).append(", ")
			.append("GroupNo=").append(getGroupNo()).append(", ")
			.append("Isonthewall=").append(getIsonthewall())
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
		if(obj instanceof LocationinfoEntity == false)
			return false;
		if(this == obj)
			return true;
		LocationinfoEntity other = (LocationinfoEntity)obj;

		return this.toString().equals(other.toString());
	}
}
