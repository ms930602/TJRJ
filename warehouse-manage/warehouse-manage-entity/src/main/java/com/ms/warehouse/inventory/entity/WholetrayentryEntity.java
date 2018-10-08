
package com.ms.warehouse.inventory.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 整托盘入库物料信息
 * @author dwx
 * @Date 2018-07-25 10:22:21
 * @since 1.0
 */
@TableName("t_ware_wholetrayentry")
public class WholetrayentryEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** 自增id. */
	private Long id;
	
	/** 物流单号. */
	private String logisticNumber;
	
	/** 合同号. */
	private String contractNumber;
	
	/** 物料id. */
	private Long materId;
	
	/** 物料编码. */
	private String materCode;
	
	/** 物料名称. */
	private String materName;
	
	/** 物料版本名称. */
	private String materVersion;
	
	/** 物料品牌名称. */
	private String materCigbrand;
	
	/** 预入库数量. */
	private java.math.BigDecimal preEntryQuality;
	
	/** 预入库时间. */
	private java.util.Date preEntryDate;
	
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
	

    /** set 物流单号. */
	public void setLogisticNumber(String logisticNumber) {
		this.logisticNumber = logisticNumber;
	}
	
	/** get 物流单号. */
	public String getLogisticNumber() {
		return this.logisticNumber;
	}
	
	@JsonIgnore
	public String getLogisticNumberByLike() {
		return "%"+this.logisticNumber+"%";
	}
	

    /** set 合同号. */
	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}
	
	/** get 合同号. */
	public String getContractNumber() {
		return this.contractNumber;
	}
	
	@JsonIgnore
	public String getContractNumberByLike() {
		return "%"+this.contractNumber+"%";
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
	

    /** set 物料品牌名称. */
	public void setMaterCigbrand(String materCigbrand) {
		this.materCigbrand = materCigbrand;
	}
	
	/** get 物料品牌名称. */
	public String getMaterCigbrand() {
		return this.materCigbrand;
	}
	
	@JsonIgnore
	public String getMaterCigbrandByLike() {
		return "%"+this.materCigbrand+"%";
	}
	

    /** set 预入库数量. */
	public void setPreEntryQuality(java.math.BigDecimal preEntryQuality) {
		this.preEntryQuality = preEntryQuality;
	}
	
	/** get 预入库数量. */
	public java.math.BigDecimal getPreEntryQuality() {
		return this.preEntryQuality;
	}
	
	@JsonIgnore
	public java.math.BigDecimal getPreEntryQualityByLike() {
		return this.preEntryQuality;
	}
	

    /** set 预入库时间. */
	public void setPreEntryDate(java.util.Date preEntryDate) {
		this.preEntryDate = preEntryDate;
	}
	
	/** get 预入库时间. */
	public java.util.Date getPreEntryDate() {
		return this.preEntryDate;
	}
	
	@JsonIgnore
	public java.util.Date getPreEntryDateByLike() {
		return this.preEntryDate;
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
	public WholetrayentryEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param logisticNumber			物流单号
	 * @param contractNumber			合同号
	 * @param materId			物料id
	 * @param materCode			物料编码
	 * @param materName			物料名称
	 * @param materVersion			物料版本名称
	 * @param materCigbrand			物料品牌名称
	 * @param preEntryQuality			预入库数量
	 * @param preEntryDate			预入库时间
	 * @param createdDate			创建时间
	 * @param createdPersonId			创建人id
	 * @param createdPerson			创建人
	 * @param updatedDate			更新时间
	 * @param updatedPersonId			更新人id
	 * @param updatedPerson			修改人
	 */
	public WholetrayentryEntity(String logisticNumber,String contractNumber,Long materId,String materCode,String materName,String materVersion,String materCigbrand,java.math.BigDecimal preEntryQuality,java.util.Date preEntryDate,java.util.Date createdDate,Long createdPersonId,String createdPerson,java.util.Date updatedDate,Long updatedPersonId,String updatedPerson){
		this();
		this.logisticNumber = logisticNumber;
		this.contractNumber = contractNumber;
		this.materId = materId;
		this.materCode = materCode;
		this.materName = materName;
		this.materVersion = materVersion;
		this.materCigbrand = materCigbrand;
		this.preEntryQuality = preEntryQuality;
		this.preEntryDate = preEntryDate;
		this.createdDate = createdDate;
		this.createdPersonId = createdPersonId;
		this.createdPerson = createdPerson;
		this.updatedDate = updatedDate;
		this.updatedPersonId = updatedPersonId;
		this.updatedPerson = updatedPerson;
	}
	
	@Override
	public String toString() {
		return "WholetrayentryEntity [id=" + id + ", logisticNumber=" + logisticNumber + ", contractNumber="
				+ contractNumber + ", materId=" + materId + ", materCode=" + materCode + ", materName=" + materName
				+ ", materVersion=" + materVersion + ", materCigbrand=" + materCigbrand + ", preEntryQuality="
				+ preEntryQuality + ", preEntryDate=" + preEntryDate + ", createdDate=" + createdDate
				+ ", createdPersonId=" + createdPersonId + ", createdPerson=" + createdPerson + ", updatedDate="
				+ updatedDate + ", updatedPersonId=" + updatedPersonId + ", updatedPerson=" + updatedPerson
				+ ", cigtype=" + cigtype + "]";
	}
	
	@Override
	public int hashCode() {
		return toString().hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if(obj instanceof WholetrayentryEntity == false)
			return false;
		if(this == obj)
			return true;
		WholetrayentryEntity other = (WholetrayentryEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
