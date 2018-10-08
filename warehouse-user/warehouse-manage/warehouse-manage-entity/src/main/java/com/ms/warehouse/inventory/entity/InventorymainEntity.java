
package com.ms.warehouse.inventory.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

import java.math.BigDecimal;

/**
 * 库存主
 * @author dwf
 * @Date 2018-08-23 17:22:22
 * @since 1.0
 */
@TableName("t_ware_inventorymain")
public class InventorymainEntity extends BaseEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 自增id. */
	private Long id;

	/** 物料id. */
	private Long materId;

	/** 物料编号. */
	private String materCode;

	/** 物料名称. */
	private String materName;

	/** 物料版本id. */
	private Long materVersionId;

	/** 物料版本. */
	private String materVersion;

	/** 物料品牌id. */
	private Long materCigbrandId;

	/** 物料品牌. */
	private String materCigbrand;

	/** 总库存数量. */
	private java.math.BigDecimal totalCount;

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

	/** 锁定库存. */
	private java.math.BigDecimal lockStock;
	
	/** 可用库存. */
	private java.math.BigDecimal availableStocks;

	/**
	 * 扩展字段
	 */
	private BigDecimal trayusableQuality;
	private BigDecimal regularQuality;
	private BigDecimal usableQuality;
	
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

	public java.math.BigDecimal getAvailableStocks() {
		return availableStocks;
	}

	public void setAvailableStocks(java.math.BigDecimal availableStocks) {
		this.availableStocks = availableStocks;
	}

	public BigDecimal getTrayusableQuality() {
		return trayusableQuality;
	}

	public void setTrayusableQuality(BigDecimal trayusableQuality) {
		this.trayusableQuality = trayusableQuality;
	}

	public BigDecimal getRegularQuality() {
		return regularQuality;
	}

	public void setRegularQuality(BigDecimal regularQuality) {
		this.regularQuality = regularQuality;
	}

	public BigDecimal getUsableQuality() {
		return usableQuality;
	}

	public void setUsableQuality(BigDecimal usableQuality) {
		this.usableQuality = usableQuality;
	}



	private String batchNo;
	private java.math.BigDecimal inventQuality;
	private java.math.BigDecimal outQuality;
	private java.math.BigDecimal surplusQuality;
	private java.math.BigDecimal outoquality;
	private java.util.Date produceDate;

	private long outmainorderId;//出库单id

	public long getOutmainorderId() {
		return outmainorderId;
	}

	public void setOutmainorderId(long outmainorderId) {
		this.outmainorderId = outmainorderId;
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


	/** set 物料id. */
	public void setMaterId(Long materId) {
		this.materId = materId;
	}

	/** get 物料id. */
	public Long getMaterId() {
		return this.materId;
	}

	@JsonIgnore
	public Long getMaterIdByLike() {
		return this.materId;
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


	/** set 物料版本id. */
	public void setMaterVersionId(Long materVersionId) {
		this.materVersionId = materVersionId;
	}

	/** get 物料版本id. */
	public Long getMaterVersionId() {
		return this.materVersionId;
	}

	@JsonIgnore
	public Long getMaterVersionIdByLike() {
		return this.materVersionId;
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


	/** set 物料品牌id. */
	public void setMaterCigbrandId(Long materCigbrandId) {
		this.materCigbrandId = materCigbrandId;
	}

	/** get 物料品牌id. */
	public Long getMaterCigbrandId() {
		return this.materCigbrandId;
	}

	@JsonIgnore
	public Long getMaterCigbrandIdByLike() {
		return this.materCigbrandId;
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


	/** set 总库存数量. */
	public void setTotalCount(java.math.BigDecimal totalCount) {
		this.totalCount = totalCount;
	}

	/** get 总库存数量. */
	public java.math.BigDecimal getTotalCount() {
		return this.totalCount;
	}

	@JsonIgnore
	public java.math.BigDecimal getTotalCountByLike() {
		return this.totalCount;
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


	/** set 卷烟类型：0正式卷烟1福样促试. */
	public void setCigtype(Long cigtype) {
		this.cigtype = cigtype;
	}

	/** get 卷烟类型：0正式卷烟1福样促试. */
	public Long getCigtype() {
		return this.cigtype;
	}

	@JsonIgnore
	public Long getCigtypeByLike() {
		return this.cigtype;
	}


	/** set 锁定库存. */
	public void setLockStock(java.math.BigDecimal lockStock) {
		this.lockStock = lockStock;
	}

	/** get 锁定库存. */
	public java.math.BigDecimal getLockStock() {
		return this.lockStock;
	}

	@JsonIgnore
	public java.math.BigDecimal getLockStockByLike() {
		return this.lockStock;
	}

	/** constructor */
	public InventorymainEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param materId			物料id
	 * @param materCode			物料编号
	 * @param materName			物料名称
	 * @param materVersionId			物料版本id
	 * @param materVersion			物料版本
	 * @param materCigbrandId			物料品牌id
	 * @param materCigbrand			物料品牌
	 * @param totalCount			总库存数量
	 * @param createdDate			创建时间
	 * @param createdPersonId			创建人id
	 * @param createdPerson			创建人
	 * @param updatedDate			更新时间
	 * @param updatedPersonId			更新人id
	 * @param updatedPerson			修改人
	 * @param cigtype			卷烟类型：0正式卷烟1福样促试
	 * @param lockStock			锁定库存
	 */
	public InventorymainEntity(Long materId,String materCode,String materName,Long materVersionId,String materVersion,Long materCigbrandId,String materCigbrand,java.math.BigDecimal totalCount,java.util.Date createdDate,Long createdPersonId,String createdPerson,java.util.Date updatedDate,Long updatedPersonId,String updatedPerson,Long cigtype,java.math.BigDecimal lockStock){
		this();
		this.materId = materId;
		this.materCode = materCode;
		this.materName = materName;
		this.materVersionId = materVersionId;
		this.materVersion = materVersion;
		this.materCigbrandId = materCigbrandId;
		this.materCigbrand = materCigbrand;
		this.totalCount = totalCount;
		this.createdDate = createdDate;
		this.createdPersonId = createdPersonId;
		this.createdPerson = createdPerson;
		this.updatedDate = updatedDate;
		this.updatedPersonId = updatedPersonId;
		this.updatedPerson = updatedPerson;
		this.cigtype = cigtype;
		this.lockStock = lockStock;
	}

	@Override
	public String toString() {
		return new StringBuilder().append("InventorymainEntity[")
				.append("Id=").append(getId()).append(", ")
				.append("MaterId=").append(getMaterId()).append(", ")
				.append("MaterCode=").append(getMaterCode()).append(", ")
				.append("MaterName=").append(getMaterName()).append(", ")
				.append("MaterVersionId=").append(getMaterVersionId()).append(", ")
				.append("MaterVersion=").append(getMaterVersion()).append(", ")
				.append("MaterCigbrandId=").append(getMaterCigbrandId()).append(", ")
				.append("MaterCigbrand=").append(getMaterCigbrand()).append(", ")
				.append("TotalCount=").append(getTotalCount()).append(", ")
				.append("CreatedDate=").append(getCreatedDate()).append(", ")
				.append("CreatedPersonId=").append(getCreatedPersonId()).append(", ")
				.append("CreatedPerson=").append(getCreatedPerson()).append(", ")
				.append("UpdatedDate=").append(getUpdatedDate()).append(", ")
				.append("UpdatedPersonId=").append(getUpdatedPersonId()).append(", ")
				.append("UpdatedPerson=").append(getUpdatedPerson()).append(", ")
				.append("Cigtype=").append(getCigtype()).append(", ")
				.append("LockStock=").append(getLockStock())
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
		if(obj instanceof InventorymainEntity == false)
			return false;
		if(this == obj)
			return true;
		InventorymainEntity other = (InventorymainEntity)obj;

		return this.toString().equals(other.toString());
	}
}
