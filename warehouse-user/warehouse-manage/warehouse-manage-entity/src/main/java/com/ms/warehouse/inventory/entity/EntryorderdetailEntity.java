
package com.ms.warehouse.inventory.entity;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 入库单详情信息
 * @author dwx
 * @Date 2018-07-25 10:22:18
 * @since 1.0
 */
@TableName("t_ware_entryorderdetail")
public class EntryorderdetailEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** 自增id. */
	private Long id;
	
	/** 入库单id. */
	private Long mainorderId;
	
	/** 物料编码、条码. */
	private String materCode;
	
	/** 物料名称. */
	private String materName;
	
	/** 数量件. */
	private java.math.BigDecimal quality;
	
	/** 批次号. */
	private String batchNo;
	
	/** 版本. */
	private String materVersion;
	
	/** 版本. */
	private List<HashMap<String, Object>> subList;
	
	private String name;

	private Long value;
	
	private String statisticaltime;
	
	public String getStatisticaltime() {
		return statisticaltime;
	}

	public void setStatisticaltime(String statisticaltime) {
		this.statisticaltime = statisticaltime;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	public List<HashMap<String, Object>> getSubList() {
		return subList;
	}

	public void setSubList(List<HashMap<String, Object>> subList) {
		this.subList = subList;
	}

	/** 品牌. */
	private String materCigbrand;
	
	/** 实际入库数量. */
	private java.math.BigDecimal actualQuality;
	
	/** 生产日期. */
	private java.util.Date produceDate;

	/** 入库完成时间. */
	private java.util.Date entryCompliteDate;

	/** 卷烟类型 */
	
	private Long cigtype;
	 	
	/** 子版本ID. */
	private Long subverId;
	
	/** 子版本名称. */
	private String subverName;
	
	/** 是否删除0否1是. */
	private Integer isDelete;

	
	private java.math.BigDecimal converCoef;
	
	//private Decimal converCoef;
	
	
	public java.math.BigDecimal getConverCoef() {
		return converCoef;
	}

	public void setConverCoef(java.math.BigDecimal converCoef) {
		this.converCoef = converCoef;
	}

	public Long getCigtype() {
		return cigtype;
	}

	public void setCigtype(Long cigtype) {
		this.cigtype = cigtype;
	}

	public Date getEntryCompliteDate() {
		return entryCompliteDate;
	}

	public void setEntryCompliteDate(Date entryCompliteDate) {
		this.entryCompliteDate = entryCompliteDate;
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
	

    /** set 入库单id. */
	public void setMainorderId(Long mainorderId) {
		this.mainorderId = mainorderId;
	}
	
	/** get 入库单id. */
	public Long getMainorderId() {
		return this.mainorderId;
	}
	
	@JsonIgnore
	public Long getMainorderIdByLike() {
		return this.mainorderId;
	}
	

    /** set 物料编码、条码. */
	public void setMaterCode(String materCode) {
		this.materCode = materCode;
	}
	
	/** get 物料编码、条码. */
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
	

    /** set 数量件. */
	public void setQuality(java.math.BigDecimal quality) {
		this.quality = quality;
	}
	
	/** get 数量件. */
	public java.math.BigDecimal getQuality() {
		return this.quality;
	}
	
	@JsonIgnore
	public java.math.BigDecimal getQualityByLike() {
		return this.quality;
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
	

    /** set 版本. */
	public void setMaterVersion(String materVersion) {
		this.materVersion = materVersion;
	}
	
	/** get 版本. */
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
	

    /** set 实际入库数量. */
	public void setActualQuality(java.math.BigDecimal actualQuality) {
		this.actualQuality = actualQuality;
	}
	
	/** get 实际入库数量. */
	public java.math.BigDecimal getActualQuality() {
		return this.actualQuality;
	}
	
	@JsonIgnore
	public java.math.BigDecimal getActualQualityByLike() {
		return this.actualQuality;
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
	

    /** set 是否删除0否1是. */
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	
	/** get 是否删除0否1是. */
	public Integer getIsDelete() {
		return this.isDelete;
	}
	
	@JsonIgnore
	public Integer getIsDeleteByLike() {
		return this.isDelete;
	}
    /** constructor */
	public EntryorderdetailEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param mainorderId			入库单id
	 * @param materCode			物料编码、条码
	 * @param materName			物料名称
	 * @param quality			数量件
	 * @param batchNo			批次号
	 * @param materVersion			版本
	 * @param materCigbrand			品牌
	 * @param actualQuality			实际入库数量
	 * @param produceDate			生产日期
	 * @param cigtype			卷烟类型：0正式卷烟1福样促试
	 * @param subverId			子版本ID
	 * @param subverName			子版本名称
	 * @param isDelete			是否删除0否1是
	 */
	public EntryorderdetailEntity(Long mainorderId,String materCode,String materName,java.math.BigDecimal quality,String batchNo,String materVersion,String materCigbrand,java.math.BigDecimal actualQuality,java.util.Date produceDate,Long cigtype,Long subverId,String subverName,Integer isDelete){
		this();
		this.mainorderId = mainorderId;
		this.materCode = materCode;
		this.materName = materName;
		this.quality = quality;
		this.batchNo = batchNo;
		this.materVersion = materVersion;
		this.materCigbrand = materCigbrand;
		this.actualQuality = actualQuality;
		this.produceDate = produceDate;
		this.cigtype = cigtype;
		this.subverId = subverId;
		this.subverName = subverName;
		this.isDelete = isDelete;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("EntryorderdetailEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("MainorderId=").append(getMainorderId()).append(", ")
			.append("MaterCode=").append(getMaterCode()).append(", ")
			.append("MaterName=").append(getMaterName()).append(", ")
			.append("Quality=").append(getQuality()).append(", ")
			.append("BatchNo=").append(getBatchNo()).append(", ")
			.append("MaterVersion=").append(getMaterVersion()).append(", ")
			.append("MaterCigbrand=").append(getMaterCigbrand()).append(", ")
			.append("ActualQuality=").append(getActualQuality()).append(", ")
			.append("ProduceDate=").append(getProduceDate()).append(", ")
			.append("Cigtype=").append(getCigtype()).append(", ")
			.append("SubverId=").append(getSubverId()).append(", ")
			.append("SubverName=").append(getSubverName()).append(", ")
			.append("IsDelete=").append(getIsDelete())
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
		if(obj instanceof EntryorderdetailEntity == false)
			return false;
		if(this == obj)
			return true;
		EntryorderdetailEntity other = (EntryorderdetailEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
