package com.ms.warehouse.inventory.entity;

import com.ms.warehouse.common.entity.BaseEntity;

public class InventorytraylocalPageEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** 物料编号. */
	private String materCode;
	
	/** 物料名称. */
	private String materName;
	
	/** 物料版本. */
	private String materVersion;
	
	/** 物料品牌. */
	private String materCigbrand;
	
	/** 库存唯一码. */
	private String soleCode;
	
	/** 托盘编码. */
	private String trayCode;
	
	/** 托盘RFID编号. */
	private String trayRfid;
	
	/** 货位编号. */
	private String localCode;
	
	private String floorAreaCode;
	
	private String batchNo;
	
	private String quality;
	
	private Long cigtype;
	
	private Long subverId;
	
	private String subverName;
	
	private String descript;
	
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

	public String getFloorAreaCode() {
		return floorAreaCode;
	}

	public void setFloorAreaCode(String floorAreaCode) {
		this.floorAreaCode = floorAreaCode;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public InventorytraylocalPageEntity() {
		super();
	}

	public String getMaterCode() {
		return materCode;
	}

	public void setMaterCode(String materCode) {
		this.materCode = materCode;
	}

	public String getMaterName() {
		return materName;
	}

	public void setMaterName(String materName) {
		this.materName = materName;
	}

	public String getMaterVersion() {
		return materVersion;
	}

	public void setMaterVersion(String materVersion) {
		this.materVersion = materVersion;
	}

	public String getMaterCigbrand() {
		return materCigbrand;
	}

	public void setMaterCigbrand(String materCigbrand) {
		this.materCigbrand = materCigbrand;
	}

	public String getSoleCode() {
		return soleCode;
	}

	public void setSoleCode(String soleCode) {
		this.soleCode = soleCode;
	}

	public String getTrayCode() {
		return trayCode;
	}

	public void setTrayCode(String trayCode) {
		this.trayCode = trayCode;
	}

	public String getTrayRfid() {
		return trayRfid;
	}

	public void setTrayRfid(String trayRfid) {
		this.trayRfid = trayRfid;
	}

	public String getLocalCode() {
		return localCode;
	}

	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}
	
}
