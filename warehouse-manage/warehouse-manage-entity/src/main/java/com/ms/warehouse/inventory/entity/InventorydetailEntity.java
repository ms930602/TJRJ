
package com.ms.warehouse.inventory.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 库存明细
 * @author dwf
 * @Date 2018-07-30 12:31:13
 * @since 1.0
 */
@TableName("t_ware_inventorydetail")
public class InventorydetailEntity extends BaseEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 自增id. */
	private Long id;

	/** 库存主表id. */
	private Long mainId;

	/** 物料编码. */
	private String materCode;

	/** 批次号. */
	private String batchNo;

	/** 入库总量（件）. */
	private java.math.BigDecimal inventQuality;

	/** 出库总量（件）. */
	private java.math.BigDecimal outQuality;

	/** 剩余总量（件）. */
	private java.math.BigDecimal surplusQuality;

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

	/** 开出数量. */
	private java.math.BigDecimal outoquality;

	/** 生产日期. */
	private java.util.Date produceDate;

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


	/** set 库存主表id. */
	public void setMainId(Long mainId) {
		this.mainId = mainId;
	}

	/** get 库存主表id. */
	public Long getMainId() {
		return this.mainId;
	}

	@JsonIgnore
	public Long getMainIdByLike() {
		return this.mainId;
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


	/** set 入库总量（件）. */
	public void setInventQuality(java.math.BigDecimal inventQuality) {
		this.inventQuality = inventQuality;
	}

	/** get 入库总量（件）. */
	public java.math.BigDecimal getInventQuality() {
		return this.inventQuality;
	}

	@JsonIgnore
	public java.math.BigDecimal getInventQualityByLike() {
		return this.inventQuality;
	}


	/** set 出库总量（件）. */
	public void setOutQuality(java.math.BigDecimal outQuality) {
		this.outQuality = outQuality;
	}

	/** get 出库总量（件）. */
	public java.math.BigDecimal getOutQuality() {
		return this.outQuality;
	}

	@JsonIgnore
	public java.math.BigDecimal getOutQualityByLike() {
		return this.outQuality;
	}


	/** set 剩余总量（件）. */
	public void setSurplusQuality(java.math.BigDecimal surplusQuality) {
		this.surplusQuality = surplusQuality;
	}

	/** get 剩余总量（件）. */
	public java.math.BigDecimal getSurplusQuality() {
		return this.surplusQuality;
	}

	@JsonIgnore
	public java.math.BigDecimal getSurplusQualityByLike() {
		return this.surplusQuality;
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


	/** set 开出数量. */
	public void setOutoquality(java.math.BigDecimal outoquality) {
		this.outoquality = outoquality;
	}

	/** get 开出数量. */
	public java.math.BigDecimal getOutoquality() {
		return this.outoquality;
	}

	@JsonIgnore
	public java.math.BigDecimal getOutoqualityByLike() {
		return this.outoquality;
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

	/** constructor */
	public InventorydetailEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param mainId			库存主表id
	 * @param materCode			物料编码
	 * @param batchNo			批次号
	 * @param inventQuality			入库总量（件）
	 * @param outQuality			出库总量（件）
	 * @param surplusQuality			剩余总量（件）
	 * @param createdDate			创建时间
	 * @param createdPersonId			创建人id
	 * @param createdPerson			创建人
	 * @param updatedDate			更新时间
	 * @param updatedPersonId			更新人id
	 * @param updatedPerson			修改人
	 * @param outoquality			开出数量
	 * @param produceDate			生产日期
	 */
	public InventorydetailEntity(Long mainId,String materCode,String batchNo,java.math.BigDecimal inventQuality,java.math.BigDecimal outQuality,java.math.BigDecimal surplusQuality,java.util.Date createdDate,Long createdPersonId,String createdPerson,java.util.Date updatedDate,Long updatedPersonId,String updatedPerson,java.math.BigDecimal outoquality,java.util.Date produceDate){
		this();
		this.mainId = mainId;
		this.materCode = materCode;
		this.batchNo = batchNo;
		this.inventQuality = inventQuality;
		this.outQuality = outQuality;
		this.surplusQuality = surplusQuality;
		this.createdDate = createdDate;
		this.createdPersonId = createdPersonId;
		this.createdPerson = createdPerson;
		this.updatedDate = updatedDate;
		this.updatedPersonId = updatedPersonId;
		this.updatedPerson = updatedPerson;
		this.outoquality = outoquality;
		this.produceDate = produceDate;
	}

	@Override
	public String toString() {
		return new StringBuilder().append("InventorydetailEntity[")
				.append("Id=").append(getId()).append(", ")
				.append("MainId=").append(getMainId()).append(", ")
				.append("MaterCode=").append(getMaterCode()).append(", ")
				.append("BatchNo=").append(getBatchNo()).append(", ")
				.append("InventQuality=").append(getInventQuality()).append(", ")
				.append("OutQuality=").append(getOutQuality()).append(", ")
				.append("SurplusQuality=").append(getSurplusQuality()).append(", ")
				.append("CreatedDate=").append(getCreatedDate()).append(", ")
				.append("CreatedPersonId=").append(getCreatedPersonId()).append(", ")
				.append("CreatedPerson=").append(getCreatedPerson()).append(", ")
				.append("UpdatedDate=").append(getUpdatedDate()).append(", ")
				.append("UpdatedPersonId=").append(getUpdatedPersonId()).append(", ")
				.append("UpdatedPerson=").append(getUpdatedPerson()).append(", ")
				.append("Outoquality=").append(getOutoquality()).append(", ")
				.append("ProduceDate=").append(getProduceDate())
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
		if(obj instanceof InventorydetailEntity == false)
			return false;
		if(this == obj)
			return true;
		InventorydetailEntity other = (InventorydetailEntity)obj;

		return this.toString().equals(other.toString());
	}
}
