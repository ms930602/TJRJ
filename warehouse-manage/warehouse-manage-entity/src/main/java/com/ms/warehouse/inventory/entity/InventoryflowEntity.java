
package com.ms.warehouse.inventory.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 库存流水
 * @author dwx
 * @Date 2018-07-25 10:22:18
 * @since 1.0
 */
@TableName("t_ware_inventoryflow")
public class InventoryflowEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** 自增id. */
	private Long id;
	
	/** 物料编码. */
	private String materCode;
	
	/** 物料名称. */
	private String materName;
	
	/** 物料版本. */
	private String materVersion;
	
	/** 物料品牌. */
	private String materCigbrand;
	
	/** 类型0入库1出库. */
	private Long type;
	
	/** 批次号. */
	private String batchNo;
	
	/** 数量. */
	private java.math.BigDecimal quality;
	
	/** 托盘编号. */
	private String trayCode;
	
	/** 出库单位. */
	private String outUnit;
	
	/** 出库单位编号. */
	private String outUnitCode;
	
	/** 入库单位. */
	private String entryUnit;
	
	/** 入库单位编号. */
	private String entryUnitCode;
	
	/** 入库单. */
	private String entryOrder;
	
	/** 出库单. */
	private String outOrder;
	
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
	
	/** 卷烟类型：0正式卷烟1福样促试. */
	private Long cigtype;
	
	/** 子版本ID. */
	private Long subverId;
	/** 子版本名称. */
	private String subverName;
	
	

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
	

    /** set 物料版本. */
	public void setMaterVersion(String materVersion) {
		this.materVersion = materVersion;
	}
	
	/** get 物料版本. */
	public String getMaterVersion() {
		return this.materVersion;
	}
	
	@JsonIgnore
	public String getMaterVersionByLike() {
		return "%"+this.materVersion+"%";
	}
	

    /** set 物料品牌. */
	public void setMaterCigbrand(String materCigbrand) {
		this.materCigbrand = materCigbrand;
	}
	
	/** get 物料品牌. */
	public String getMaterCigbrand() {
		return this.materCigbrand;
	}
	
	@JsonIgnore
	public String getMaterCigbrandByLike() {
		return "%"+this.materCigbrand+"%";
	}
	

    /** set 类型0入库1出库. */
	public void setType(Long type) {
		this.type = type;
	}
	
	/** get 类型0入库1出库. */
	public Long getType() {
		return this.type;
	}
	
	@JsonIgnore
	public Long getTypeByLike() {
		return this.type;
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
	

    /** set 出库单位. */
	public void setOutUnit(String outUnit) {
		this.outUnit = outUnit;
	}
	
	/** get 出库单位. */
	public String getOutUnit() {
		return this.outUnit;
	}
	
	@JsonIgnore
	public String getOutUnitByLike() {
		return "%"+this.outUnit+"%";
	}
	

    /** set 出库单位编号. */
	public void setOutUnitCode(String outUnitCode) {
		this.outUnitCode = outUnitCode;
	}
	
	/** get 出库单位编号. */
	public String getOutUnitCode() {
		return this.outUnitCode;
	}
	
	@JsonIgnore
	public String getOutUnitCodeByLike() {
		return "%"+this.outUnitCode+"%";
	}
	

    /** set 入库单位. */
	public void setEntryUnit(String entryUnit) {
		this.entryUnit = entryUnit;
	}
	
	/** get 入库单位. */
	public String getEntryUnit() {
		return this.entryUnit;
	}
	
	@JsonIgnore
	public String getEntryUnitByLike() {
		return "%"+this.entryUnit+"%";
	}
	

    /** set 入库单位编号. */
	public void setEntryUnitCode(String entryUnitCode) {
		this.entryUnitCode = entryUnitCode;
	}
	
	/** get 入库单位编号. */
	public String getEntryUnitCode() {
		return this.entryUnitCode;
	}
	
	@JsonIgnore
	public String getEntryUnitCodeByLike() {
		return "%"+this.entryUnitCode+"%";
	}
	

    /** set 入库单. */
	public void setEntryOrder(String entryOrder) {
		this.entryOrder = entryOrder;
	}
	
	/** get 入库单. */
	public String getEntryOrder() {
		return this.entryOrder;
	}
	
	@JsonIgnore
	public String getEntryOrderByLike() {
		return "%"+this.entryOrder+"%";
	}
	

    /** set 出库单. */
	public void setOutOrder(String outOrder) {
		this.outOrder = outOrder;
	}
	
	/** get 出库单. */
	public String getOutOrder() {
		return this.outOrder;
	}
	
	@JsonIgnore
	public String getOutOrderByLike() {
		return "%"+this.outOrder+"%";
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
	
    /** constructor */
	public InventoryflowEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param materCode			物料编码
	 * @param materName			物料名称
	 * @param materVersion			物料版本
	 * @param materCigbrand			物料品牌
	 * @param type			类型0入库1出库
	 * @param batchNo			批次号
	 * @param quality			数量
	 * @param trayCode			托盘编号
	 * @param outUnit			出库单位
	 * @param outUnitCode			出库单位编号
	 * @param entryUnit			入库单位
	 * @param entryUnitCode			入库单位编号
	 * @param entryOrder			入库单
	 * @param outOrder			出库单
	 * @param createdDate			创建时间
	 * @param createdPersonId			创建人id
	 * @param createdPerson			创建人
	 * @param updatedDate			更新时间
	 * @param updatedPersonId			更新人id
	 * @param updatedPerson			修改人
	 */
	public InventoryflowEntity(String materCode,String materName,String materVersion,String materCigbrand,Long type,String batchNo,java.math.BigDecimal quality,String trayCode,String outUnit,String outUnitCode,String entryUnit,String entryUnitCode,String entryOrder,String outOrder,java.util.Date createdDate,Long createdPersonId,String createdPerson,java.util.Date updatedDate,Long updatedPersonId,String updatedPerson){
		this();
		this.materCode = materCode;
		this.materName = materName;
		this.materVersion = materVersion;
		this.materCigbrand = materCigbrand;
		this.type = type;
		this.batchNo = batchNo;
		this.quality = quality;
		this.trayCode = trayCode;
		this.outUnit = outUnit;
		this.outUnitCode = outUnitCode;
		this.entryUnit = entryUnit;
		this.entryUnitCode = entryUnitCode;
		this.entryOrder = entryOrder;
		this.outOrder = outOrder;
		this.createdDate = createdDate;
		this.createdPersonId = createdPersonId;
		this.createdPerson = createdPerson;
		this.updatedDate = updatedDate;
		this.updatedPersonId = updatedPersonId;
		this.updatedPerson = updatedPerson;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("InventoryflowEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("MaterCode=").append(getMaterCode()).append(", ")
			.append("MaterName=").append(getMaterName()).append(", ")
			.append("MaterVersion=").append(getMaterVersion()).append(", ")
			.append("MaterCigbrand=").append(getMaterCigbrand()).append(", ")
			.append("Type=").append(getType()).append(", ")
			.append("BatchNo=").append(getBatchNo()).append(", ")
			.append("Quality=").append(getQuality()).append(", ")
			.append("TrayCode=").append(getTrayCode()).append(", ")
			.append("OutUnit=").append(getOutUnit()).append(", ")
			.append("OutUnitCode=").append(getOutUnitCode()).append(", ")
			.append("EntryUnit=").append(getEntryUnit()).append(", ")
			.append("EntryUnitCode=").append(getEntryUnitCode()).append(", ")
			.append("EntryOrder=").append(getEntryOrder()).append(", ")
			.append("OutOrder=").append(getOutOrder()).append(", ")
			.append("CreatedDate=").append(getCreatedDate()).append(", ")
			.append("CreatedPersonId=").append(getCreatedPersonId()).append(", ")
			.append("CreatedPerson=").append(getCreatedPerson()).append(", ")
			.append("UpdatedDate=").append(getUpdatedDate()).append(", ")
			.append("UpdatedPersonId=").append(getUpdatedPersonId()).append(", ")
			.append("UpdatedPerson=").append(getUpdatedPerson())
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
		if(obj instanceof InventoryflowEntity == false)
			return false;
		if(this == obj)
			return true;
		InventoryflowEntity other = (InventoryflowEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
