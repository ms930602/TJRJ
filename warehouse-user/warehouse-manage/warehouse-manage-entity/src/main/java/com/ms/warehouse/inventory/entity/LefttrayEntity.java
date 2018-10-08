
package com.ms.warehouse.inventory.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 尾盘
 * @author dwf
 * @Date 2018-08-24 15:07:29
 * @since 1.0
 */
@TableName("t_ware_lefttray")
public class LefttrayEntity extends BaseEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 自增id. */
	private Long id;

	/** 物料编码. */
	private String materCode;

	/** 物料名称. */
	private String materName;

	/** 物料版本名称. */
	private String materVersion;

	/** 品牌. */
	private String materCigbrand;

	/** 库存数量. */
	private java.math.BigDecimal quality;

	/** 开出数量. */
	private java.math.BigDecimal outoquality;

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


	/** set 品牌. */
	public void setMaterCigbrand(String materCigbrand) {
		this.materCigbrand = materCigbrand;
	}

	/** get 品牌. */
	public String getMaterCigbrand() {
		return this.materCigbrand;
	}

	@JsonIgnore
	public String getMaterCigbrandByLike() {
		return "%"+this.materCigbrand+"%";
	}


	/** set 库存数量. */
	public void setQuality(java.math.BigDecimal quality) {
		this.quality = quality;
	}

	/** get 库存数量. */
	public java.math.BigDecimal getQuality() {
		return this.quality;
	}

	@JsonIgnore
	public java.math.BigDecimal getQualityByLike() {
		return this.quality;
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


	/** set 子版本ID. */
	public void setSubverId(Long subverId) {
		this.subverId = subverId;
	}

	/** get 子版本ID. */
	public Long getSubverId() {
		return this.subverId;
	}

	@JsonIgnore
	public Long getSubverIdByLike() {
		return this.subverId;
	}


	/** set 子版本名称. */
	public void setSubverName(String subverName) {
		this.subverName = subverName;
	}

	/** get 子版本名称. */
	public String getSubverName() {
		return this.subverName;
	}

	@JsonIgnore
	public String getSubverNameByLike() {
		return "%"+this.subverName+"%";
	}

	/** constructor */
	public LefttrayEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param materCode			物料编码
	 * @param materName			物料名称
	 * @param materVersion			物料版本名称
	 * @param materCigbrand			品牌
	 * @param quality			库存数量
	 * @param outoquality			开出数量
	 * @param createdDate			创建时间
	 * @param createdPersonId			创建人id
	 * @param createdPerson			创建人
	 * @param updatedDate			更新时间
	 * @param updatedPersonId			更新人id
	 * @param updatedPerson			修改人
	 * @param cigtype			卷烟类型：0正式卷烟1福样促试
	 * @param subverId			子版本ID
	 * @param subverName			子版本名称
	 */
	public LefttrayEntity(String materCode,String materName,String materVersion,String materCigbrand,java.math.BigDecimal quality,java.math.BigDecimal outoquality,java.util.Date createdDate,Long createdPersonId,String createdPerson,java.util.Date updatedDate,Long updatedPersonId,String updatedPerson,Long cigtype,Long subverId,String subverName){
		this();
		this.materCode = materCode;
		this.materName = materName;
		this.materVersion = materVersion;
		this.materCigbrand = materCigbrand;
		this.quality = quality;
		this.outoquality = outoquality;
		this.createdDate = createdDate;
		this.createdPersonId = createdPersonId;
		this.createdPerson = createdPerson;
		this.updatedDate = updatedDate;
		this.updatedPersonId = updatedPersonId;
		this.updatedPerson = updatedPerson;
		this.cigtype = cigtype;
		this.subverId = subverId;
		this.subverName = subverName;
	}

	@Override
	public String toString() {
		return new StringBuilder().append("LefttrayEntity[")
				.append("Id=").append(getId()).append(", ")
				.append("MaterCode=").append(getMaterCode()).append(", ")
				.append("MaterName=").append(getMaterName()).append(", ")
				.append("MaterVersion=").append(getMaterVersion()).append(", ")
				.append("MaterCigbrand=").append(getMaterCigbrand()).append(", ")
				.append("Quality=").append(getQuality()).append(", ")
				.append("Outoquality=").append(getOutoquality()).append(", ")
				.append("CreatedDate=").append(getCreatedDate()).append(", ")
				.append("CreatedPersonId=").append(getCreatedPersonId()).append(", ")
				.append("CreatedPerson=").append(getCreatedPerson()).append(", ")
				.append("UpdatedDate=").append(getUpdatedDate()).append(", ")
				.append("UpdatedPersonId=").append(getUpdatedPersonId()).append(", ")
				.append("UpdatedPerson=").append(getUpdatedPerson()).append(", ")
				.append("Cigtype=").append(getCigtype()).append(", ")
				.append("SubverId=").append(getSubverId()).append(", ")
				.append("SubverName=").append(getSubverName())
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
		if(obj instanceof LefttrayEntity == false)
			return false;
		if(this == obj)
			return true;
		LefttrayEntity other = (LefttrayEntity)obj;

		return this.toString().equals(other.toString());
	}
}
