/**
 * 
 */
package com.ms.warehouse.inventory.entity;

import java.util.List;

import com.ms.warehouse.common.entity.BaseEntity;

/**
 * @author Administrator
 *
 */
public class InventoryAllEntity extends InventorymainEntity{
	
	private Long detailId;
	private String batchNo;
	private java.math.BigDecimal inventQuality;
	private java.math.BigDecimal outQuality;
	private java.math.BigDecimal surplusQuality;
	private java.math.BigDecimal outoquality;
	private java.util.Date produceDate;
	private String descript;
	
	
	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	private List<InventorytraylocalmapEntity> itlmEntities;
	
	
	


	public List<InventorytraylocalmapEntity> getItlmEntities() {
		return itlmEntities;
	}

	public void setItlmEntities(List<InventorytraylocalmapEntity> itlmEntities) {
		this.itlmEntities = itlmEntities;
	}

	/** 0库存明细1尾盘 */
	private Long nameType;
	
	
	public Long getNameType() {
		return nameType;
	}

	public void setNameType(Long nameType) {
		this.nameType = nameType;
	}

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	private Long localmapId;

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
    
	/** 唯一码. */
	private String soleCode;

	/** 托盘编号. */
	private String trayCode;

	/** 出库日期. */
	private java.util.Date outDate;
	
	private int countMap;

	
	public Long getDetailId() {
		return detailId;
	}

	public void setDetailId(Long detailId) {
		this.detailId = detailId;
	}

	public Long getLocalmapId() {
		return localmapId;
	}

	public void setLocalmapId(Long localmapId) {
		this.localmapId = localmapId;
	}

	public int getCountMap() {
		return countMap;
	}

	public void setCountMap(int countMap) {
		this.countMap = countMap;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public java.math.BigDecimal getInventQuality() {
		return inventQuality;
	}

	public void setInventQuality(java.math.BigDecimal inventQuality) {
		this.inventQuality = inventQuality;
	}

	public java.math.BigDecimal getOutQuality() {
		return outQuality;
	}

	public void setOutQuality(java.math.BigDecimal outQuality) {
		this.outQuality = outQuality;
	}

	public java.math.BigDecimal getSurplusQuality() {
		return surplusQuality;
	}

	public void setSurplusQuality(java.math.BigDecimal surplusQuality) {
		this.surplusQuality = surplusQuality;
	}

	public java.math.BigDecimal getOutoquality() {
		return outoquality;
	}

	public void setOutoquality(java.math.BigDecimal outoquality) {
		this.outoquality = outoquality;
	}

	public java.util.Date getProduceDate() {
		return produceDate;
	}

	public void setProduceDate(java.util.Date produceDate) {
		this.produceDate = produceDate;
	}

	public java.math.BigDecimal getQuality() {
		return quality;
	}

	public void setQuality(java.math.BigDecimal quality) {
		this.quality = quality;
	}

	public String getTrayRfid() {
		return trayRfid;
	}

	public void setTrayRfid(String trayRfid) {
		this.trayRfid = trayRfid;
	}

	public Long getLocalId() {
		return localId;
	}

	public void setLocalId(Long localId) {
		this.localId = localId;
	}

	public String getLocalCode() {
		return localCode;
	}

	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}

	public String getLocalRfid() {
		return localRfid;
	}

	public void setLocalRfid(String localRfid) {
		this.localRfid = localRfid;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
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

	public java.util.Date getOutDate() {
		return outDate;
	}

	public void setOutDate(java.util.Date outDate) {
		this.outDate = outDate;
	}

	@Override
	public String toString() {
		return "InventoryAllEntity [batchNo=" + batchNo + ", inventQuality=" + inventQuality + ", outQuality="
				+ outQuality + ", surplusQuality=" + surplusQuality + ", outoquality=" + outoquality + ", produceDate="
				+ produceDate + ", quality=" + quality + ", trayRfid=" + trayRfid + ", localId=" + localId
				+ ", localCode=" + localCode + ", localRfid=" + localRfid + ", status=" + status + ", soleCode="
				+ soleCode + ", trayCode=" + trayCode + ", outDate=" + outDate + "]";
	}
	
	
}
