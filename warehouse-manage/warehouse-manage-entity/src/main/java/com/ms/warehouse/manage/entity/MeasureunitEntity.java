
package com.ms.warehouse.manage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 计量单位
 * @author dwx
 * @Date 2018-07-09 18:27:43
 * @since 1.0
 */
@TableName("t_base_measureunit")
public class MeasureunitEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** 自增id. */
	private Long id;
	
	/** 主数据id. */
	private String dataId;
	
	/** 单位编码. */
	private String unitCode;
	
	/** 单位名称. */
	private String unitName;
	
	/** 所属量纲 0:件数 1:重量 2:长度 9:其他. */
	private String beloneMain;
	
	/** 是否基本单位 0：是 1：否. */
	private String isBase;
	
	/** 转换系数. */
	private String transRate;
	
	/** 状态 2：发布 3：停用. */
	private String status;
	
	/** 创建时间. */
	private java.util.Date createdDate;
	
	/** 创建人. */
	private String createdPerson;
	
	/** 更新时间. */
	private java.util.Date updatedDate;
	
	/** 更新人. */
	private String updatedPerson;
	
	

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
	

    /** set 主数据id. */
	public void setDataId(String dataId) {
		this.dataId = dataId;
	}
	
	/** get 主数据id. */
	public String getDataId() {
		return this.dataId;
	}
	
	@JsonIgnore
	public String getDataIdByLike() {
		return "%"+this.dataId+"%";
	}
	

    /** set 单位编码. */
	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}
	
	/** get 单位编码. */
	public String getUnitCode() {
		return this.unitCode;
	}
	
	@JsonIgnore
	public String getUnitCodeByLike() {
		return "%"+this.unitCode+"%";
	}
	

    /** set 单位名称. */
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	
	/** get 单位名称. */
	public String getUnitName() {
		return this.unitName;
	}
	
	@JsonIgnore
	public String getUnitNameByLike() {
		return "%"+this.unitName+"%";
	}
	

    /** set 所属量纲 0:件数 1:重量 2:长度 9:其他. */
	public void setBeloneMain(String beloneMain) {
		this.beloneMain = beloneMain;
	}
	
	/** get 所属量纲 0:件数 1:重量 2:长度 9:其他. */
	public String getBeloneMain() {
		return this.beloneMain;
	}
	
	@JsonIgnore
	public String getBeloneMainByLike() {
		return "%"+this.beloneMain+"%";
	}
	

    /** set 是否基本单位 0：是 1：否. */
	public void setIsBase(String isBase) {
		this.isBase = isBase;
	}
	
	/** get 是否基本单位 0：是 1：否. */
	public String getIsBase() {
		return this.isBase;
	}
	
	@JsonIgnore
	public String getIsBaseByLike() {
		return "%"+this.isBase+"%";
	}
	

    /** set 转换系数. */
	public void setTransRate(String transRate) {
		this.transRate = transRate;
	}
	
	/** get 转换系数. */
	public String getTransRate() {
		return this.transRate;
	}
	
	@JsonIgnore
	public String getTransRateByLike() {
		return "%"+this.transRate+"%";
	}
	

    /** set 状态 2：发布 3：停用. */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/** get 状态 2：发布 3：停用. */
	public String getStatus() {
		return this.status;
	}
	
	@JsonIgnore
	public String getStatusByLike() {
		return "%"+this.status+"%";
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
	

    /** set 更新人. */
	public void setUpdatedPerson(String updatedPerson) {
		this.updatedPerson = updatedPerson;
	}
	
	/** get 更新人. */
	public String getUpdatedPerson() {
		return this.updatedPerson;
	}
	
	@JsonIgnore
	public String getUpdatedPersonByLike() {
		return "%"+this.updatedPerson+"%";
	}
	
    /** constructor */
	public MeasureunitEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param dataId			主数据id
	 * @param unitCode			单位编码
	 * @param unitName			单位名称
	 * @param beloneMain			所属量纲 0:件数 1:重量 2:长度 9:其他
	 * @param isBase			是否基本单位 0：是 1：否
	 * @param transRate			转换系数
	 * @param status			状态 2：发布 3：停用
	 * @param createdDate			创建时间
	 * @param createdPerson			创建人
	 * @param updatedDate			更新时间
	 * @param updatedPerson			更新人
	 */
	public MeasureunitEntity(String dataId,String unitCode,String unitName,String beloneMain,String isBase,String transRate,String status,java.util.Date createdDate,String createdPerson,java.util.Date updatedDate,String updatedPerson){
		this();
		this.dataId = dataId;
		this.unitCode = unitCode;
		this.unitName = unitName;
		this.beloneMain = beloneMain;
		this.isBase = isBase;
		this.transRate = transRate;
		this.status = status;
		this.createdDate = createdDate;
		this.createdPerson = createdPerson;
		this.updatedDate = updatedDate;
		this.updatedPerson = updatedPerson;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("MeasureunitEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("DataId=").append(getDataId()).append(", ")
			.append("UnitCode=").append(getUnitCode()).append(", ")
			.append("UnitName=").append(getUnitName()).append(", ")
			.append("BeloneMain=").append(getBeloneMain()).append(", ")
			.append("IsBase=").append(getIsBase()).append(", ")
			.append("TransRate=").append(getTransRate()).append(", ")
			.append("Status=").append(getStatus()).append(", ")
			.append("CreatedDate=").append(getCreatedDate()).append(", ")
			.append("CreatedPerson=").append(getCreatedPerson()).append(", ")
			.append("UpdatedDate=").append(getUpdatedDate()).append(", ")
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
		if(obj instanceof MeasureunitEntity == false)
			return false;
		if(this == obj)
			return true;
		MeasureunitEntity other = (MeasureunitEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
