
package com.ms.warehouse.inventory.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 盘点详情
 * @author Ms
 * @Date 2018-08-09 14:14:18
 * @since 1.0
 */
@TableName("t_ware_stockcheckdetail")
public class StockcheckdetailEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** 自增id. */
	private Long id;
	
	/** 盘点主表ID. */
	private Long mainId;
	
	/** 唯一码. */
	private String soleCode;
	
	/** 物料编码. */
	private String materCode;
	
	/** 物料名称. */
	private String materName;
	
	/** 物料版本名称. */
	private String materVersion;
	
	/** 货位编码. */
	private String localCode;
	
	/** 批次号. */
	private String batchNo;
	
	/** 托盘上物料库存数量. */
	private java.math.BigDecimal inventQuality;
	
	/** 实际盘点数量. */
	private java.math.BigDecimal actualCountQuality;
	
	/** 盘点人. */
	private String inventory;
	
	/** 盘点人id. */
	private Long inventoryId;
	
	/** 楼层区域编码 组合. */
	private String floorAreaCode;
	
	/** 托盘编号. */
	private String trayCode;
	
	/** 状态：0未盘点1已盘点. */
	private Long status;
	
	/**
	 * 卷烟类型：0正式卷烟1福样促试
	 */
	private Long cigtype;
	
	/** 子版本ID. */
	private Long subverId;
	
	/** 子版本名称. */
	private String subverName;
	
	/** 货位描述. */
	private String localDescript;
	
	/** 托盘rfid编号. */
	private String trayRfid;
	/** 货位rfid编号. */
	private String localRfid;
	
	
	
    public String getTrayRfid() {
		return trayRfid;
	}

	public void setTrayRfid(String trayRfid) {
		this.trayRfid = trayRfid;
	}

	public String getLocalRfid() {
		return localRfid;
	}

	public void setLocalRfid(String localRfid) {
		this.localRfid = localRfid;
	}

	public String getLocalDescript() {
		return localDescript;
	}

	public void setLocalDescript(String localDescript) {
		this.localDescript = localDescript;
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
	

    /** set 盘点主表ID. */
	public void setMainId(Long mainId) {
		this.mainId = mainId;
	}
	
	/** get 盘点主表ID. */
	public Long getMainId() {
		return this.mainId;
	}
	
	@JsonIgnore
	public Long getMainIdByLike() {
		return this.mainId;
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
	

    /** set 物料编码. */
	public void setMaterCode(String materCode) {
		this.materCode = materCode;
	}
	
	/** get 物料编码. */
	public String getMaterCode() {
		return this.materCode;
	}
	
	@JsonIgnore
	public String getMaterCodeByLike() {
		return "%"+this.materCode+"%";
	}
	

    /** set 物料名称. */
	public void setMaterName(String materName) {
		this.materName = materName;
	}
	
	/** get 物料名称. */
	public String getMaterName() {
		return this.materName;
	}
	
	@JsonIgnore
	public String getMaterNameByLike() {
		return "%"+this.materName+"%";
	}
	

    /** set 物料版本名称. */
	public void setMaterVersion(String materVersion) {
		this.materVersion = materVersion;
	}
	
	/** get 物料版本名称. */
	public String getMaterVersion() {
		return this.materVersion;
	}
	
	@JsonIgnore
	public String getMaterVersionByLike() {
		return "%"+this.materVersion+"%";
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
	

    /** set 托盘上物料库存数量. */
	public void setInventQuality(java.math.BigDecimal inventQuality) {
		this.inventQuality = inventQuality;
	}
	
	/** get 托盘上物料库存数量. */
	public java.math.BigDecimal getInventQuality() {
		return this.inventQuality;
	}
	
	@JsonIgnore
	public java.math.BigDecimal getInventQualityByLike() {
		return this.inventQuality;
	}
	

    /** set 实际盘点数量. */
	public void setActualCountQuality(java.math.BigDecimal actualCountQuality) {
		this.actualCountQuality = actualCountQuality;
	}
	
	/** get 实际盘点数量. */
	public java.math.BigDecimal getActualCountQuality() {
		return this.actualCountQuality;
	}
	
	@JsonIgnore
	public java.math.BigDecimal getActualCountQualityByLike() {
		return this.actualCountQuality;
	}
	

    /** set 盘点人. */
	public void setInventory(String inventory) {
		this.inventory = inventory;
	}
	
	/** get 盘点人. */
	public String getInventory() {
		return this.inventory;
	}
	
	@JsonIgnore
	public String getInventoryByLike() {
		return "%"+this.inventory+"%";
	}
	

    /** set 盘点人id. */
	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}
	
	/** get 盘点人id. */
	public Long getInventoryId() {
		return this.inventoryId;
	}
	
	@JsonIgnore
	public Long getInventoryIdByLike() {
		return this.inventoryId;
	}
	

    /** set 楼层区域编码 组合. */
	public void setFloorAreaCode(String floorAreaCode) {
		this.floorAreaCode = floorAreaCode;
	}
	
	/** get 楼层区域编码 组合. */
	public String getFloorAreaCode() {
		return this.floorAreaCode;
	}
	
	@JsonIgnore
	public String getFloorAreaCodeByLike() {
		return "%"+this.floorAreaCode+"%";
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
	

    /** set 状态：0未盘点1已盘点. */
	public void setStatus(Long status) {
		this.status = status;
	}
	
	/** get 状态：0未盘点1已盘点. */
	public Long getStatus() {
		return this.status;
	}
	
	@JsonIgnore
	public Long getStatusByLike() {
		return this.status;
	}
	
    /** constructor */
	public StockcheckdetailEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param mainId			盘点主表ID
	 * @param soleCode			唯一码
	 * @param materCode			物料编码
	 * @param materName			物料名称
	 * @param materVersion			物料版本名称
	 * @param localCode			货位编码
	 * @param batchNo			批次号
	 * @param inventQuality			托盘上物料库存数量
	 * @param actualCountQuality			实际盘点数量
	 * @param inventory			盘点人
	 * @param inventoryId			盘点人id
	 * @param floorAreaCode			楼层区域编码 组合
	 * @param trayCode			托盘编号
	 * @param status			状态：0未盘点1已盘点
	 */
	public StockcheckdetailEntity(Long mainId,String soleCode,String materCode,String materName,String materVersion,String localCode,String batchNo,java.math.BigDecimal inventQuality,java.math.BigDecimal actualCountQuality,String inventory,Long inventoryId,String floorAreaCode,String trayCode,Long status){
		this();
		this.mainId = mainId;
		this.soleCode = soleCode;
		this.materCode = materCode;
		this.materName = materName;
		this.materVersion = materVersion;
		this.localCode = localCode;
		this.batchNo = batchNo;
		this.inventQuality = inventQuality;
		this.actualCountQuality = actualCountQuality;
		this.inventory = inventory;
		this.inventoryId = inventoryId;
		this.floorAreaCode = floorAreaCode;
		this.trayCode = trayCode;
		this.status = status;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("StockcheckdetailEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("MainId=").append(getMainId()).append(", ")
			.append("SoleCode=").append(getSoleCode()).append(", ")
			.append("MaterCode=").append(getMaterCode()).append(", ")
			.append("MaterName=").append(getMaterName()).append(", ")
			.append("MaterVersion=").append(getMaterVersion()).append(", ")
			.append("LocalCode=").append(getLocalCode()).append(", ")
			.append("BatchNo=").append(getBatchNo()).append(", ")
			.append("InventQuality=").append(getInventQuality()).append(", ")
			.append("ActualCountQuality=").append(getActualCountQuality()).append(", ")
			.append("Inventory=").append(getInventory()).append(", ")
			.append("InventoryId=").append(getInventoryId()).append(", ")
			.append("FloorAreaCode=").append(getFloorAreaCode()).append(", ")
			.append("TrayCode=").append(getTrayCode()).append(", ")
			.append("Status=").append(getStatus())
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
		if(obj instanceof StockcheckdetailEntity == false)
			return false;
		if(this == obj)
			return true;
		StockcheckdetailEntity other = (StockcheckdetailEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
