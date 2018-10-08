
package com.ms.warehouse.inventory.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 库存明细货位托盘绑定
 * @author dwf
 * @Date 2018-07-30 10:14:47
 * @since 1.0
 */
@TableName("t_ware_inventorytraylocalmap")
public class InventorytraylocalmapEntity extends BaseEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 自增id. */
	private Long id;

	/** 库存明细表id. */
	private Long detailId;

	/** 物料编号. */
	private String materCode;

	/** 批次号. */
	private String batchNo;

	/** 数量. */
	private java.math.BigDecimal quality;

	/** 托盘rfid编号. */
	private String trayRfid;

	/** 货位id. */
	private Long localId;

	/** 货位编号. */
	private String localCode;

	/** 货位rfid编号. */
	private String localRfid;

	/** 状态0正常1锁定2释放. */
	private Long status;

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

	/** 唯一码. */
	private String soleCode;

	/** 托盘编号. */
	private String trayCode;

	/** 生产日期. */
	private java.util.Date produceDate;

	/** 出库日期. */
	private java.util.Date outDate;
	
	/** 卷烟类型：0正式卷烟1福样促试. */
	private Long cigtype;

	private  String materName;

	/** 子版本ID. */
	private Long subverId;
	/** 子版本名称. */
	private String subverName;
	
	
	/** 货位描述. */
	private String descript;
	
	/** 物料版本. */
	private String materVersion;
	
	
	
	/** 区域块. */
	private Long areaBlock;

	/** 区域排. */
	private Long areaRow;

	/** 区域号. */
	private Long areaNum;

	/** 上下层  1;上层 2 下层. */
	private Long upDown;

	/** 货位状态 ：0空闲中 1 使用中. */
	private Long localStatus;
	
	
	
	public Long getAreaBlock() {
		return areaBlock;
	}

	public void setAreaBlock(Long areaBlock) {
		this.areaBlock = areaBlock;
	}

	public Long getAreaRow() {
		return areaRow;
	}

	public void setAreaRow(Long areaRow) {
		this.areaRow = areaRow;
	}

	public Long getAreaNum() {
		return areaNum;
	}

	public void setAreaNum(Long areaNum) {
		this.areaNum = areaNum;
	}

	public Long getUpDown() {
		return upDown;
	}

	public void setUpDown(Long upDown) {
		this.upDown = upDown;
	}

	public Long getLocalStatus() {
		return localStatus;
	}

	public void setLocalStatus(Long localStatus) {
		this.localStatus = localStatus;
	}

	public String getMaterVersion() {
		return materVersion;
	}

	public void setMaterVersion(String materVersion) {
		this.materVersion = materVersion;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public Long getSubverId() {
		return subverId;
	}

	public void setSubverId(Long subverId) {
		this.subverId = subverId;
	}

	public String getSubverName() {
		return subverName;
	}

	public void setSubverName(String subverName) {
		this.subverName = subverName;
	}

	public Long getCigtype() {
		return cigtype;
	}

	public void setCigtype(Long cigtype) {
		this.cigtype = cigtype;
	}

	public String getMaterName() {
		return materName;
	}

	public void setMaterName(String materName) {
		this.materName = materName;
	}

	private String oldlocalCode;

	public void setOldlocalCode(String oldlocalCode) {
		this.oldlocalCode = oldlocalCode;
	}

	public String getOldlocalCode() {
		return oldlocalCode;
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


	/** set 库存明细表id. */
	public void setDetailId(Long detailId) {
		this.detailId = detailId;
	}

	/** get 库存明细表id. */
	public Long getDetailId() {
		return this.detailId;
	}

	@JsonIgnore
	public Long getDetailIdByLike() {
		return this.detailId;
	}


	/** set 物料编号. */
	public void setMaterCode(String materCode) {
		this.materCode = materCode;
	}

	/** get 物料编号. */
	public String getMaterCode() {
		return this.materCode;
	}

	@JsonIgnore
	public String getMaterCodeByLike() {
		return "%"+this.materCode+"%";
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


	/** set 数量. */
	public void setQuality(java.math.BigDecimal quality) {
		this.quality = quality;
	}

	/** get 数量. */
	public java.math.BigDecimal getQuality() {
		return this.quality;
	}

	@JsonIgnore
	public java.math.BigDecimal getQualityByLike() {
		return this.quality;
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


	/** set 货位编号. */
	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}

	/** get 货位编号. */
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


	/** set 状态0正常1锁定2释放. */
	public void setStatus(Long status) {
		this.status = status;
	}

	/** get 状态0正常1锁定2释放. */
	public Long getStatus() {
		return this.status;
	}

	@JsonIgnore
	public Long getStatusByLike() {
		return this.status;
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


	/** set 生产日期. */
	public void setProduceDate(java.util.Date produceDate) {
		this.produceDate = produceDate;
	}

	/** get 生产日期. */
	public java.util.Date getProduceDate() {
		return this.produceDate;
	}

	@JsonIgnore
	public java.util.Date getProduceDateByLike() {
		return this.produceDate;
	}


	/** set 出库日期. */
	public void setOutDate(java.util.Date outDate) {
		this.outDate = outDate;
	}

	/** get 出库日期. */
	public java.util.Date getOutDate() {
		return this.outDate;
	}

	@JsonIgnore
	public java.util.Date getOutDateByLike() {
		return this.outDate;
	}

	/** constructor */
	public InventorytraylocalmapEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param detailId			库存明细表id
	 * @param materCode			物料编号
	 * @param batchNo			批次号
	 * @param quality			数量
	 * @param trayRfid			托盘rfid编号
	 * @param localId			货位id
	 * @param localCode			货位编号
	 * @param localRfid			货位rfid编号
	 * @param status			状态0正常1锁定2释放
	 * @param createdDate			创建时间
	 * @param createdPersonId			创建人id
	 * @param createdPerson			创建人
	 * @param updatedDate			更新时间
	 * @param updatedPersonId			更新人id
	 * @param updatedPerson			修改人
	 * @param soleCode			唯一码
	 * @param trayCode			托盘编号
	 * @param produceDate			生产日期
	 * @param outDate			出库日期
	 */
	public InventorytraylocalmapEntity(Long detailId,String materCode,String batchNo,java.math.BigDecimal quality,String trayRfid,Long localId,String localCode,String localRfid,Long status,java.util.Date createdDate,Long createdPersonId,String createdPerson,java.util.Date updatedDate,Long updatedPersonId,String updatedPerson,String soleCode,String trayCode,java.util.Date produceDate,java.util.Date outDate){
		this();
		this.detailId = detailId;
		this.materCode = materCode;
		this.batchNo = batchNo;
		this.quality = quality;
		this.trayRfid = trayRfid;
		this.localId = localId;
		this.localCode = localCode;
		this.localRfid = localRfid;
		this.status = status;
		this.createdDate = createdDate;
		this.createdPersonId = createdPersonId;
		this.createdPerson = createdPerson;
		this.updatedDate = updatedDate;
		this.updatedPersonId = updatedPersonId;
		this.updatedPerson = updatedPerson;
		this.soleCode = soleCode;
		this.trayCode = trayCode;
		this.produceDate = produceDate;
		this.outDate = outDate;
	}

	@Override
	public String toString() {
		return new StringBuilder().append("InventorytraylocalmapEntity[")
				.append("Id=").append(getId()).append(", ")
				.append("DetailId=").append(getDetailId()).append(", ")
				.append("MaterCode=").append(getMaterCode()).append(", ")
				.append("BatchNo=").append(getBatchNo()).append(", ")
				.append("Quality=").append(getQuality()).append(", ")
				.append("TrayRfid=").append(getTrayRfid()).append(", ")
				.append("LocalId=").append(getLocalId()).append(", ")
				.append("LocalCode=").append(getLocalCode()).append(", ")
				.append("LocalRfid=").append(getLocalRfid()).append(", ")
				.append("Status=").append(getStatus()).append(", ")
				.append("CreatedDate=").append(getCreatedDate()).append(", ")
				.append("CreatedPersonId=").append(getCreatedPersonId()).append(", ")
				.append("CreatedPerson=").append(getCreatedPerson()).append(", ")
				.append("UpdatedDate=").append(getUpdatedDate()).append(", ")
				.append("UpdatedPersonId=").append(getUpdatedPersonId()).append(", ")
				.append("UpdatedPerson=").append(getUpdatedPerson()).append(", ")
				.append("SoleCode=").append(getSoleCode()).append(", ")
				.append("TrayCode=").append(getTrayCode()).append(", ")
				.append("ProduceDate=").append(getProduceDate()).append(", ")
				.append("OutDate=").append(getOutDate())
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
		if(obj instanceof InventorytraylocalmapEntity == false)
			return false;
		if(this == obj)
			return true;
		InventorytraylocalmapEntity other = (InventorytraylocalmapEntity)obj;

		return this.toString().equals(other.toString());
	}
}
