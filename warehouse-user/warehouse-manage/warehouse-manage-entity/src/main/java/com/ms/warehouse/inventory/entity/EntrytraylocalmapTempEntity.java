
package com.ms.warehouse.inventory.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 托盘货位绑定信息临时
 * @author dwf
 * @Date 2018-07-28 14:37:04
 * @since 1.0
 */
@TableName("t_ware_entrytraylocalmap_temp")
public class EntrytraylocalmapTempEntity extends BaseEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 自增id. */
	private Long id;

	/** 入库单详情id. */
	private Long orderdetailId;

	/** 托盘件烟数量. */
	private java.math.BigDecimal cigsmokeQuality;

	/** 托盘rfid编号. */
	private String trayRfid;

	/** 货位id. */
	private Long localId;

	/** 货位编码. */
	private String localCode;

	/** 货位rfid编号. */
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

	/** 状态0 入库中1入库完成. */
	private Long status;

	/** 批次号. */
	private String batchNo;

	/** 唯一码. */
	private String soleCode;

	/** 托盘编号. */
	private String trayCode;

	/** 入库方式0件烟1整托盘. */
	private Long wareMethod;

	/** 物料编码、条码. */
	private String materCode;

	/** uuid. */
	private String uuid;
	
	
	private String floorCode;
	
	private String descript;

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public String getFloorCode() {
		return floorCode;
	}

	public void setFloorCode(String floorCode) {
		this.floorCode = floorCode;
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


	/** set 入库单详情id. */
	public void setOrderdetailId(Long orderdetailId) {
		this.orderdetailId = orderdetailId;
	}

	/** get 入库单详情id. */
	public Long getOrderdetailId() {
		return this.orderdetailId;
	}

	@JsonIgnore
	public Long getOrderdetailIdByLike() {
		return this.orderdetailId;
	}


	/** set 托盘件烟数量. */
	public void setCigsmokeQuality(java.math.BigDecimal cigsmokeQuality) {
		this.cigsmokeQuality = cigsmokeQuality;
	}

	/** get 托盘件烟数量. */
	public java.math.BigDecimal getCigsmokeQuality() {
		return this.cigsmokeQuality;
	}

	@JsonIgnore
	public java.math.BigDecimal getCigsmokeQualityByLike() {
		return this.cigsmokeQuality;
	}


	/** set 托盘rfid编号. */
	public void setTrayRfid(String trayRfid) {
		this.trayRfid = trayRfid;
	}

	/** get 托盘rfid编号. */
	public String getTrayRfid() {
		return this.trayRfid;
	}

	@JsonIgnore
	public String getTrayRfidByLike() {
		return "%"+this.trayRfid+"%";
	}


	/** set 货位id. */
	public void setLocalId(Long localId) {
		this.localId = localId;
	}

	/** get 货位id. */
	public Long getLocalId() {
		return this.localId;
	}

	@JsonIgnore
	public Long getLocalIdByLike() {
		return this.localId;
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


	/** set 货位rfid编号. */
	public void setLocalRfid(String localRfid) {
		this.localRfid = localRfid;
	}

	/** get 货位rfid编号. */
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


	/** set 状态0 入库中1入库完成. */
	public void setStatus(Long status) {
		this.status = status;
	}

	/** get 状态0 入库中1入库完成. */
	public Long getStatus() {
		return this.status;
	}

	@JsonIgnore
	public Long getStatusByLike() {
		return this.status;
	}


	/** set 批次号. */
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	/** get 批次号. */
	public String getBatchNo() {
		return this.batchNo;
	}

	@JsonIgnore
	public String getBatchNoByLike() {
		return "%"+this.batchNo+"%";
	}


	/** set 唯一码. */
	public void setSoleCode(String soleCode) {
		this.soleCode = soleCode;
	}

	/** get 唯一码. */
	public String getSoleCode() {
		return this.soleCode;
	}

	@JsonIgnore
	public String getSoleCodeByLike() {
		return "%"+this.soleCode+"%";
	}


	/** set 托盘编号. */
	public void setTrayCode(String trayCode) {
		this.trayCode = trayCode;
	}

	/** get 托盘编号. */
	public String getTrayCode() {
		return this.trayCode;
	}

	@JsonIgnore
	public String getTrayCodeByLike() {
		return "%"+this.trayCode+"%";
	}


	/** set 入库方式0件烟1整托盘. */
	public void setWareMethod(Long wareMethod) {
		this.wareMethod = wareMethod;
	}

	/** get 入库方式0件烟1整托盘. */
	public Long getWareMethod() {
		return this.wareMethod;
	}

	@JsonIgnore
	public Long getWareMethodByLike() {
		return this.wareMethod;
	}


	/** set 物料编码、条码. */
	public void setMaterCode(String materCode) {
		this.materCode = materCode;
	}

	/** get 物料编码、条码. */
	public String getMaterCode() {
		return this.materCode;
	}

	@JsonIgnore
	public String getMaterCodeByLike() {
		return "%"+this.materCode+"%";
	}


	/** set uuid. */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/** get uuid. */
	public String getUuid() {
		return this.uuid;
	}

	@JsonIgnore
	public String getUuidByLike() {
		return "%"+this.uuid+"%";
	}

	/** constructor */
	public EntrytraylocalmapTempEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param orderdetailId			入库单详情id
	 * @param cigsmokeQuality			托盘件烟数量
	 * @param trayRfid			托盘rfid编号
	 * @param localId			货位id
	 * @param localCode			货位编码
	 * @param localRfid			货位rfid编号
	 * @param createdDate			创建时间
	 * @param createdPersonId			创建人id
	 * @param createdPerson			创建人
	 * @param updatedDate			更新时间
	 * @param updatedPersonId			更新人id
	 * @param updatedPerson			修改人
	 * @param status			状态0 入库中1入库完成
	 * @param batchNo			批次号
	 * @param soleCode			唯一码
	 * @param trayCode			托盘编号
	 * @param wareMethod			入库方式0件烟1整托盘
	 * @param materCode			物料编码、条码
	 * @param uuid			uuid
	 */
	public EntrytraylocalmapTempEntity(Long orderdetailId,java.math.BigDecimal cigsmokeQuality,String trayRfid,Long localId,String localCode,String localRfid,java.util.Date createdDate,Long createdPersonId,String createdPerson,java.util.Date updatedDate,Long updatedPersonId,String updatedPerson,Long status,String batchNo,String soleCode,String trayCode,Long wareMethod,String materCode,String uuid){
		this();
		this.orderdetailId = orderdetailId;
		this.cigsmokeQuality = cigsmokeQuality;
		this.trayRfid = trayRfid;
		this.localId = localId;
		this.localCode = localCode;
		this.localRfid = localRfid;
		this.createdDate = createdDate;
		this.createdPersonId = createdPersonId;
		this.createdPerson = createdPerson;
		this.updatedDate = updatedDate;
		this.updatedPersonId = updatedPersonId;
		this.updatedPerson = updatedPerson;
		this.status = status;
		this.batchNo = batchNo;
		this.soleCode = soleCode;
		this.trayCode = trayCode;
		this.wareMethod = wareMethod;
		this.materCode = materCode;
		this.uuid = uuid;
	}

	@Override
	public String toString() {
		return new StringBuilder().append("EntrytraylocalmapTempEntity[")
				.append("Id=").append(getId()).append(", ")
				.append("OrderdetailId=").append(getOrderdetailId()).append(", ")
				.append("CigsmokeQuality=").append(getCigsmokeQuality()).append(", ")
				.append("TrayRfid=").append(getTrayRfid()).append(", ")
				.append("LocalId=").append(getLocalId()).append(", ")
				.append("LocalCode=").append(getLocalCode()).append(", ")
				.append("LocalRfid=").append(getLocalRfid()).append(", ")
				.append("CreatedDate=").append(getCreatedDate()).append(", ")
				.append("CreatedPersonId=").append(getCreatedPersonId()).append(", ")
				.append("CreatedPerson=").append(getCreatedPerson()).append(", ")
				.append("UpdatedDate=").append(getUpdatedDate()).append(", ")
				.append("UpdatedPersonId=").append(getUpdatedPersonId()).append(", ")
				.append("UpdatedPerson=").append(getUpdatedPerson()).append(", ")
				.append("Status=").append(getStatus()).append(", ")
				.append("BatchNo=").append(getBatchNo()).append(", ")
				.append("SoleCode=").append(getSoleCode()).append(", ")
				.append("TrayCode=").append(getTrayCode()).append(", ")
				.append("WareMethod=").append(getWareMethod()).append(", ")
				.append("MaterCode=").append(getMaterCode()).append(", ")
				.append("Uuid=").append(getUuid())
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
		if(obj instanceof EntrytraylocalmapTempEntity == false)
			return false;
		if(this == obj)
			return true;
		EntrytraylocalmapTempEntity other = (EntrytraylocalmapTempEntity)obj;

		return this.toString().equals(other.toString());
	}
}
