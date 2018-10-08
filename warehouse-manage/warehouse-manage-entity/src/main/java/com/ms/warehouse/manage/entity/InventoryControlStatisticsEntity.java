package com.ms.warehouse.manage.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.ms.warehouse.common.entity.BaseEntity;
/**
 * 存量控制统计entity
 * @author 王 维
 * create time：2018年8月29日
 */
public class InventoryControlStatisticsEntity extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 7236843074635651187L;
	/**
	 * id
	 */
	private Integer id;
	/**
	 * 正式物料code
	 */
	private String officialMaterCode;
	/**
	 * 正式物料名称
	 */
	private String officialMaterName;
	/**
	 * 测试物料code
	 */
	private String testMaterCode;
	/**
	 * 测试物料名称
	 */
	private String testMaterName;
	/**
	 * 品牌名称
	 */
	private String brandName;
	/**
	 * 存放时间
	 */
	private Integer storageTime;
	/**
	 * 规格名称
	 */
	private String pacsName;
	/**
	 * 剩余库存数量
	 */
	private BigDecimal surplusQuality;
	
	public BigDecimal getSurplusQuality() {
		return surplusQuality;
	}
	public void setSurplusQuality(BigDecimal surplusQuality) {
		this.surplusQuality = surplusQuality;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOfficialMaterCode() {
		return officialMaterCode;
	}
	public void setOfficialMaterCode(String officialMaterCode) {
		this.officialMaterCode = officialMaterCode;
	}
	public String getOfficialMaterName() {
		return officialMaterName;
	}
	public void setOfficialMaterName(String officialMaterName) {
		this.officialMaterName = officialMaterName;
	}
	public String getTestMaterCode() {
		return testMaterCode;
	}
	public void setTestMaterCode(String testMaterCode) {
		this.testMaterCode = testMaterCode;
	}
	public String getTestMaterName() {
		return testMaterName;
	}
	public void setTestMaterName(String testMaterName) {
		this.testMaterName = testMaterName;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public Integer getStorageTime() {
		return storageTime;
	}
	public void setStorageTime(Integer storageTime) {
		this.storageTime = storageTime;
	}
	public String getPacsName() {
		return pacsName;
	}
	public void setPacsName(String pacsName) {
		this.pacsName = pacsName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brandName == null) ? 0 : brandName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((officialMaterCode == null) ? 0 : officialMaterCode.hashCode());
		result = prime * result + ((officialMaterName == null) ? 0 : officialMaterName.hashCode());
		result = prime * result + ((pacsName == null) ? 0 : pacsName.hashCode());
		result = prime * result + ((storageTime == null) ? 0 : storageTime.hashCode());
		result = prime * result + ((surplusQuality == null) ? 0 : surplusQuality.hashCode());
		result = prime * result + ((testMaterCode == null) ? 0 : testMaterCode.hashCode());
		result = prime * result + ((testMaterName == null) ? 0 : testMaterName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InventoryControlStatisticsEntity other = (InventoryControlStatisticsEntity) obj;
		if (brandName == null) {
			if (other.brandName != null)
				return false;
		} else if (!brandName.equals(other.brandName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (officialMaterCode == null) {
			if (other.officialMaterCode != null)
				return false;
		} else if (!officialMaterCode.equals(other.officialMaterCode))
			return false;
		if (officialMaterName == null) {
			if (other.officialMaterName != null)
				return false;
		} else if (!officialMaterName.equals(other.officialMaterName))
			return false;
		if (pacsName == null) {
			if (other.pacsName != null)
				return false;
		} else if (!pacsName.equals(other.pacsName))
			return false;
		if (storageTime == null) {
			if (other.storageTime != null)
				return false;
		} else if (!storageTime.equals(other.storageTime))
			return false;
		if (surplusQuality == null) {
			if (other.surplusQuality != null)
				return false;
		} else if (!surplusQuality.equals(other.surplusQuality))
			return false;
		if (testMaterCode == null) {
			if (other.testMaterCode != null)
				return false;
		} else if (!testMaterCode.equals(other.testMaterCode))
			return false;
		if (testMaterName == null) {
			if (other.testMaterName != null)
				return false;
		} else if (!testMaterName.equals(other.testMaterName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "InventoryControlStatisticsEntity [id=" + id + ", officialMaterCode=" + officialMaterCode
				+ ", officialMaterName=" + officialMaterName + ", testMaterCode=" + testMaterCode + ", testMaterName="
				+ testMaterName + ", brandName=" + brandName + ", storageTime=" + storageTime + ", pacsName=" + pacsName
				+ ", surplusQuality=" + surplusQuality + "]";
	}
	
	
}
