
package com.ms.warehouse.manage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 库存预警
 * @author wangwei
 * @Date 2018-07-27 15:19:12
 * @since 1.0
 */
@TableName("t_ware_stockwarning")
public class WareStockwarningEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** 自增id. */
	private Long id;
	
	/** . */
	private Long materId;
	
	/**
	 * 物料编码
	 */
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
	
	/**
	 * 短缺
	 */
	private java.math.BigDecimal shortage;
	/**
	 * 超储
	 */
	private java.math.BigDecimal overstock;
	/**
	 * 超期
	 */
	private Integer Beyond;
	
	/**
	 * 是否短缺
	 */
	private String isShortage;
	/**
	 * 是否超储
	 */
	private String isOverstock;
	/**
	 * 是否超期
	 */
	private String isBeyond;
	
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

	public String getMaterCode() {
		return materCode;
	}

	public void setMaterCode(String materCode) {
		this.materCode = materCode;
	}

	public String getIsShortage() {
		return isShortage;
	}

	public void setIsShortage(String isShortage) {
		this.isShortage = isShortage;
	}

	public String getIsOverstock() {
		return isOverstock;
	}

	public void setIsOverstock(String isOverstock) {
		this.isOverstock = isOverstock;
	}

	public String getIsBeyond() {
		return isBeyond;
	}

	public void setIsBeyond(String isBeyond) {
		this.isBeyond = isBeyond;
	}

	public java.math.BigDecimal getShortage() {
		return shortage;
	}

	public void setShortage(java.math.BigDecimal shortage) {
		this.shortage = shortage;
	}

	public java.math.BigDecimal getOverstock() {
		return overstock;
	}

	public void setOverstock(java.math.BigDecimal overstock) {
		this.overstock = overstock;
	}

	public Integer getBeyond() {
		return Beyond;
	}

	public void setBeyond(Integer beyond) {
		Beyond = beyond;
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
	

    /** set . */
	public void setMaterId(Long materId) {
		this.materId = materId;
	}
	
	/** get . */
	public Long getMaterId() {
		return this.materId;
	}
	
	@JsonIgnore
	public Long getMaterIdByLike() {
		return this.materId;
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
	public WareStockwarningEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param materId			
	 * @param batchNo			批次号
	 * @param warningType			预警类型0呆滞1超储2短缺
	 * @param warningDesc			预警描述
	 * @param createdDate			创建时间
	 * @param entryDate			入库时间
	 * @param inventQuality			库存数量
	 */
	public WareStockwarningEntity(Long materId,String materCode,String batchNo,Long warningType,String warningDesc,java.util.Date createdDate,java.util.Date entryDate,java.math.BigDecimal inventQuality){
		this();
		this.materCode=materCode;
		this.materId = materId;
		this.batchNo = batchNo;
		this.warningType = warningType;
		this.warningDesc = warningDesc;
		this.createdDate = createdDate;
		this.entryDate = entryDate;
		this.inventQuality = inventQuality;
	}
	
	@Override
	public String toString() {
		return "WareStockwarningEntity [id=" + id + ", materId=" + materId + ", materCode=" + materCode + ", batchNo="
				+ batchNo + ", warningType=" + warningType + ", warningDesc=" + warningDesc + ", createdDate="
				+ createdDate + ", entryDate=" + entryDate + ", inventQuality=" + inventQuality + ", shortage="
				+ shortage + ", overstock=" + overstock + ", Beyond=" + Beyond + ", isShortage=" + isShortage
				+ ", isOverstock=" + isOverstock + ", isBeyond=" + isBeyond + ", cigtype=" + cigtype + ", subverId="
				+ subverId + ", subverName=" + subverName + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Beyond == null) ? 0 : Beyond.hashCode());
		result = prime * result + ((batchNo == null) ? 0 : batchNo.hashCode());
		result = prime * result + ((cigtype == null) ? 0 : cigtype.hashCode());
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((entryDate == null) ? 0 : entryDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((inventQuality == null) ? 0 : inventQuality.hashCode());
		result = prime * result + ((isBeyond == null) ? 0 : isBeyond.hashCode());
		result = prime * result + ((isOverstock == null) ? 0 : isOverstock.hashCode());
		result = prime * result + ((isShortage == null) ? 0 : isShortage.hashCode());
		result = prime * result + ((materCode == null) ? 0 : materCode.hashCode());
		result = prime * result + ((materId == null) ? 0 : materId.hashCode());
		result = prime * result + ((overstock == null) ? 0 : overstock.hashCode());
		result = prime * result + ((shortage == null) ? 0 : shortage.hashCode());
		result = prime * result + ((subverId == null) ? 0 : subverId.hashCode());
		result = prime * result + ((subverName == null) ? 0 : subverName.hashCode());
		result = prime * result + ((warningDesc == null) ? 0 : warningDesc.hashCode());
		result = prime * result + ((warningType == null) ? 0 : warningType.hashCode());
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
		WareStockwarningEntity other = (WareStockwarningEntity) obj;
		if (Beyond == null) {
			if (other.Beyond != null)
				return false;
		} else if (!Beyond.equals(other.Beyond))
			return false;
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
		if (entryDate == null) {
			if (other.entryDate != null)
				return false;
		} else if (!entryDate.equals(other.entryDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (inventQuality == null) {
			if (other.inventQuality != null)
				return false;
		} else if (!inventQuality.equals(other.inventQuality))
			return false;
		if (isBeyond == null) {
			if (other.isBeyond != null)
				return false;
		} else if (!isBeyond.equals(other.isBeyond))
			return false;
		if (isOverstock == null) {
			if (other.isOverstock != null)
				return false;
		} else if (!isOverstock.equals(other.isOverstock))
			return false;
		if (isShortage == null) {
			if (other.isShortage != null)
				return false;
		} else if (!isShortage.equals(other.isShortage))
			return false;
		if (materCode == null) {
			if (other.materCode != null)
				return false;
		} else if (!materCode.equals(other.materCode))
			return false;
		if (materId == null) {
			if (other.materId != null)
				return false;
		} else if (!materId.equals(other.materId))
			return false;
		if (overstock == null) {
			if (other.overstock != null)
				return false;
		} else if (!overstock.equals(other.overstock))
			return false;
		if (shortage == null) {
			if (other.shortage != null)
				return false;
		} else if (!shortage.equals(other.shortage))
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
		if (warningDesc == null) {
			if (other.warningDesc != null)
				return false;
		} else if (!warningDesc.equals(other.warningDesc))
			return false;
		if (warningType == null) {
			if (other.warningType != null)
				return false;
		} else if (!warningType.equals(other.warningType))
			return false;
		return true;
	}
}
