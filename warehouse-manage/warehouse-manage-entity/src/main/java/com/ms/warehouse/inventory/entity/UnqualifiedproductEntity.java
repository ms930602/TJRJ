
package com.ms.warehouse.inventory.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 不合格品
 * @author dwx
 * @Date 2018-07-25 10:22:21
 * @since 1.0
 */
@TableName("t_ware_unqualifiedproduct")
public class UnqualifiedproductEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** 自增id. */
	private Long id;
	
	/** 批次号. */
	private String batchNo;
	
	/** 入库单号. */
	private String entryOrder;
	
	/** 托盘rfid编号. */
	private String trayRfid;
	
	/** 物料编码. */
	private String materCode;
	
	/** 物料名称. */
	private String materName;
	
	/** 物料版本名称. */
	private String materVersion;
	
	/** 品牌. */
	private String materCigbrand;
	
	/** 唯一码. */
	private String soleCode;
	
	/** 货位编码. */
	private String localCode;
	
	/** 不合格品数量. */
	private java.math.BigDecimal unqualifiedQuality;
	
	/** 状态0未处理1已处理. */
	private Long status;
	
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
	
	/** 托盘编号. */
	private String trayCode;
	
	/** 不合格类型0过期1变形2质量缺陷. */
	private Long type;
	
	/** 备注. */
	private String remark;
	
	/** 附件. */
	private String enclosure;
	
	/** 卷烟类型：0正式卷烟1福样促试. */
	private Long cigtype;
	
	/** 子版本ID. */
	private Long subverId;
	
	/** 子版本名称. */
	private String subverName;
	
	/** 货位描述. */
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
	

    /** set 入库单号. */
	public void setEntryOrder(String entryOrder) {
		this.entryOrder = entryOrder;
	}
	
	/** get 入库单号. */
	public String getEntryOrder() {
		return this.entryOrder;
	}
	
	@JsonIgnore
	public String getEntryOrderByLike() {
		return "%"+this.entryOrder+"%";
	}
	

    /** set 托盘rfid编号. */
	public void setTrayRfid(String trayRfid) {
		this.trayRfid = trayRfid;
	}
	
	/** get 托盘rfid编号. */
	public String getTrayRfid() {
		return this.trayRfid;
	}
	
	@JsonIgnore
	public String getTrayRfidByLike() {
		return "%"+this.trayRfid+"%";
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
	

    /** set 不合格品数量. */
	public void setUnqualifiedQuality(java.math.BigDecimal unqualifiedQuality) {
		this.unqualifiedQuality = unqualifiedQuality;
	}
	
	/** get 不合格品数量. */
	public java.math.BigDecimal getUnqualifiedQuality() {
		return this.unqualifiedQuality;
	}
	
	@JsonIgnore
	public java.math.BigDecimal getUnqualifiedQualityByLike() {
		return this.unqualifiedQuality;
	}
	

    /** set 状态0未处理1已处理. */
	public void setStatus(Long status) {
		this.status = status;
	}
	
	/** get 状态0未处理1已处理. */
	public Long getStatus() {
		return this.status;
	}
	
	@JsonIgnore
	public Long getStatusByLike() {
		return this.status;
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
	

    /** set 不合格类型0过期1变形2质量缺陷. */
	public void setType(Long type) {
		this.type = type;
	}
	
	/** get 不合格类型0过期1变形2质量缺陷. */
	public Long getType() {
		return this.type;
	}
	
	@JsonIgnore
	public Long getTypeByLike() {
		return this.type;
	}
	

    /** set 备注. */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/** get 备注. */
	public String getRemark() {
		return this.remark;
	}
	
	@JsonIgnore
	public String getRemarkByLike() {
		return "%"+this.remark+"%";
	}
	

    /** set 附件. */
	public void setEnclosure(String enclosure) {
		this.enclosure = enclosure;
	}
	
	/** get 附件. */
	public String getEnclosure() {
		return this.enclosure;
	}
	
	@JsonIgnore
	public String getEnclosureByLike() {
		return "%"+this.enclosure+"%";
	}
	
    /** constructor */
	public UnqualifiedproductEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param batchNo			批次号
	 * @param entryOrder			入库单号
	 * @param trayRfid			托盘rfid编号
	 * @param materCode			物料编码
	 * @param materName			物料名称
	 * @param materVersion			物料版本名称
	 * @param materCigbrand			品牌
	 * @param soleCode			唯一码
	 * @param localCode			货位编码
	 * @param unqualifiedQuality			不合格品数量
	 * @param status			状态0未处理1已处理
	 * @param createdDate			创建时间
	 * @param createdPersonId			创建人id
	 * @param createdPerson			创建人
	 * @param updatedDate			更新时间
	 * @param updatedPersonId			更新人id
	 * @param updatedPerson			修改人
	 * @param trayCode			托盘编号
	 * @param type			不合格类型0过期1变形2质量缺陷
	 * @param remark			备注
	 * @param enclosure			附件
	 */
	public UnqualifiedproductEntity(String batchNo,String entryOrder,String trayRfid,String materCode,String materName,String materVersion,String materCigbrand,String soleCode,String localCode,java.math.BigDecimal unqualifiedQuality,Long status,java.util.Date createdDate,Long createdPersonId,String createdPerson,java.util.Date updatedDate,Long updatedPersonId,String updatedPerson,String trayCode,Long type,String remark,String enclosure){
		this();
		this.batchNo = batchNo;
		this.entryOrder = entryOrder;
		this.trayRfid = trayRfid;
		this.materCode = materCode;
		this.materName = materName;
		this.materVersion = materVersion;
		this.materCigbrand = materCigbrand;
		this.soleCode = soleCode;
		this.localCode = localCode;
		this.unqualifiedQuality = unqualifiedQuality;
		this.status = status;
		this.createdDate = createdDate;
		this.createdPersonId = createdPersonId;
		this.createdPerson = createdPerson;
		this.updatedDate = updatedDate;
		this.updatedPersonId = updatedPersonId;
		this.updatedPerson = updatedPerson;
		this.trayCode = trayCode;
		this.type = type;
		this.remark = remark;
		this.enclosure = enclosure;
	}
	
	@Override
	public String toString() {
		return "UnqualifiedproductEntity [id=" + id + ", batchNo=" + batchNo + ", entryOrder=" + entryOrder
				+ ", trayRfid=" + trayRfid + ", materCode=" + materCode + ", materName=" + materName + ", materVersion="
				+ materVersion + ", materCigbrand=" + materCigbrand + ", soleCode=" + soleCode + ", localCode="
				+ localCode + ", unqualifiedQuality=" + unqualifiedQuality + ", status=" + status + ", createdDate="
				+ createdDate + ", createdPersonId=" + createdPersonId + ", createdPerson=" + createdPerson
				+ ", updatedDate=" + updatedDate + ", updatedPersonId=" + updatedPersonId + ", updatedPerson="
				+ updatedPerson + ", trayCode=" + trayCode + ", type=" + type + ", remark=" + remark + ", enclosure="
				+ enclosure + ", cigtype=" + cigtype + ", subverId=" + subverId + ", subverName=" + subverName + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((batchNo == null) ? 0 : batchNo.hashCode());
		result = prime * result + ((cigtype == null) ? 0 : cigtype.hashCode());
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((createdPerson == null) ? 0 : createdPerson.hashCode());
		result = prime * result + ((createdPersonId == null) ? 0 : createdPersonId.hashCode());
		result = prime * result + ((enclosure == null) ? 0 : enclosure.hashCode());
		result = prime * result + ((entryOrder == null) ? 0 : entryOrder.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((localCode == null) ? 0 : localCode.hashCode());
		result = prime * result + ((materCigbrand == null) ? 0 : materCigbrand.hashCode());
		result = prime * result + ((materCode == null) ? 0 : materCode.hashCode());
		result = prime * result + ((materName == null) ? 0 : materName.hashCode());
		result = prime * result + ((materVersion == null) ? 0 : materVersion.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((soleCode == null) ? 0 : soleCode.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((subverId == null) ? 0 : subverId.hashCode());
		result = prime * result + ((subverName == null) ? 0 : subverName.hashCode());
		result = prime * result + ((trayCode == null) ? 0 : trayCode.hashCode());
		result = prime * result + ((trayRfid == null) ? 0 : trayRfid.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((unqualifiedQuality == null) ? 0 : unqualifiedQuality.hashCode());
		result = prime * result + ((updatedDate == null) ? 0 : updatedDate.hashCode());
		result = prime * result + ((updatedPerson == null) ? 0 : updatedPerson.hashCode());
		result = prime * result + ((updatedPersonId == null) ? 0 : updatedPersonId.hashCode());
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
		UnqualifiedproductEntity other = (UnqualifiedproductEntity) obj;
		if (batchNo == null) {
			if (other.batchNo != null)
				return false;
		} else if (!batchNo.equals(other.batchNo))
			return false;
		if (cigtype == null) {
			if (other.cigtype != null)
				return false;
		} else if (!cigtype.equals(other.cigtype))
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (createdPerson == null) {
			if (other.createdPerson != null)
				return false;
		} else if (!createdPerson.equals(other.createdPerson))
			return false;
		if (createdPersonId == null) {
			if (other.createdPersonId != null)
				return false;
		} else if (!createdPersonId.equals(other.createdPersonId))
			return false;
		if (enclosure == null) {
			if (other.enclosure != null)
				return false;
		} else if (!enclosure.equals(other.enclosure))
			return false;
		if (entryOrder == null) {
			if (other.entryOrder != null)
				return false;
		} else if (!entryOrder.equals(other.entryOrder))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (localCode == null) {
			if (other.localCode != null)
				return false;
		} else if (!localCode.equals(other.localCode))
			return false;
		if (materCigbrand == null) {
			if (other.materCigbrand != null)
				return false;
		} else if (!materCigbrand.equals(other.materCigbrand))
			return false;
		if (materCode == null) {
			if (other.materCode != null)
				return false;
		} else if (!materCode.equals(other.materCode))
			return false;
		if (materName == null) {
			if (other.materName != null)
				return false;
		} else if (!materName.equals(other.materName))
			return false;
		if (materVersion == null) {
			if (other.materVersion != null)
				return false;
		} else if (!materVersion.equals(other.materVersion))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (soleCode == null) {
			if (other.soleCode != null)
				return false;
		} else if (!soleCode.equals(other.soleCode))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (subverId == null) {
			if (other.subverId != null)
				return false;
		} else if (!subverId.equals(other.subverId))
			return false;
		if (subverName == null) {
			if (other.subverName != null)
				return false;
		} else if (!subverName.equals(other.subverName))
			return false;
		if (trayCode == null) {
			if (other.trayCode != null)
				return false;
		} else if (!trayCode.equals(other.trayCode))
			return false;
		if (trayRfid == null) {
			if (other.trayRfid != null)
				return false;
		} else if (!trayRfid.equals(other.trayRfid))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (unqualifiedQuality == null) {
			if (other.unqualifiedQuality != null)
				return false;
		} else if (!unqualifiedQuality.equals(other.unqualifiedQuality))
			return false;
		if (updatedDate == null) {
			if (other.updatedDate != null)
				return false;
		} else if (!updatedDate.equals(other.updatedDate))
			return false;
		if (updatedPerson == null) {
			if (other.updatedPerson != null)
				return false;
		} else if (!updatedPerson.equals(other.updatedPerson))
			return false;
		if (updatedPersonId == null) {
			if (other.updatedPersonId != null)
				return false;
		} else if (!updatedPersonId.equals(other.updatedPersonId))
			return false;
		return true;
	}
}
