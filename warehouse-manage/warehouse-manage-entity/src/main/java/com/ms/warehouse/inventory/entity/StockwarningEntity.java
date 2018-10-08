
package com.ms.warehouse.inventory.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 库存预警
 * @author dwf
 * @Date 2018-07-30 12:31:16
 * @since 1.0
 */
@TableName("t_ware_stockwarning")
public class StockwarningEntity extends BaseEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 自增id. */
	private Long id;

	/** 物料编码. */
	private String materCode;

	/** 批次号. */
	private String batchNo;

	/** 预警类型0呆滞1超储2短缺. */
	private Long warningType;

	/** 预警描述. */
	private String warningDesc;

	/** 创建时间. */
	private java.util.Date createdDate;

	/** 入库时间. */
	private java.util.Date entryDate;

	/** 库存数量. */
	private java.math.BigDecimal inventQuality;



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


	/** set 预警类型0呆滞1超储2短缺. */
	public void setWarningType(Long warningType) {
		this.warningType = warningType;
	}

	/** get 预警类型0呆滞1超储2短缺. */
	public Long getWarningType() {
		return this.warningType;
	}

	@JsonIgnore
	public Long getWarningTypeByLike() {
		return this.warningType;
	}


	/** set 预警描述. */
	public void setWarningDesc(String warningDesc) {
		this.warningDesc = warningDesc;
	}

	/** get 预警描述. */
	public String getWarningDesc() {
		return this.warningDesc;
	}

	@JsonIgnore
	public String getWarningDescByLike() {
		return "%"+this.warningDesc+"%";
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


	/** set 入库时间. */
	public void setEntryDate(java.util.Date entryDate) {
		this.entryDate = entryDate;
	}

	/** get 入库时间. */
	public java.util.Date getEntryDate() {
		return this.entryDate;
	}

	@JsonIgnore
	public java.util.Date getEntryDateByLike() {
		return this.entryDate;
	}


	/** set 库存数量. */
	public void setInventQuality(java.math.BigDecimal inventQuality) {
		this.inventQuality = inventQuality;
	}

	/** get 库存数量. */
	public java.math.BigDecimal getInventQuality() {
		return this.inventQuality;
	}

	@JsonIgnore
	public java.math.BigDecimal getInventQualityByLike() {
		return this.inventQuality;
	}

	/** constructor */
	public StockwarningEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param materCode			物料编码
	 * @param batchNo			批次号
	 * @param warningType			预警类型0呆滞1超储2短缺
	 * @param warningDesc			预警描述
	 * @param createdDate			创建时间
	 * @param entryDate			入库时间
	 * @param inventQuality			库存数量
	 */
	public StockwarningEntity(String materCode,String batchNo,Long warningType,String warningDesc,java.util.Date createdDate,java.util.Date entryDate,java.math.BigDecimal inventQuality){
		this();
		this.materCode = materCode;
		this.batchNo = batchNo;
		this.warningType = warningType;
		this.warningDesc = warningDesc;
		this.createdDate = createdDate;
		this.entryDate = entryDate;
		this.inventQuality = inventQuality;
	}

	@Override
	public String toString() {
		return new StringBuilder().append("StockwarningEntity[")
				.append("Id=").append(getId()).append(", ")
				.append("MaterCode=").append(getMaterCode()).append(", ")
				.append("BatchNo=").append(getBatchNo()).append(", ")
				.append("WarningType=").append(getWarningType()).append(", ")
				.append("WarningDesc=").append(getWarningDesc()).append(", ")
				.append("CreatedDate=").append(getCreatedDate()).append(", ")
				.append("EntryDate=").append(getEntryDate()).append(", ")
				.append("InventQuality=").append(getInventQuality())
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
		if(obj instanceof StockwarningEntity == false)
			return false;
		if(this == obj)
			return true;
		StockwarningEntity other = (StockwarningEntity)obj;

		return this.toString().equals(other.toString());
	}
}
