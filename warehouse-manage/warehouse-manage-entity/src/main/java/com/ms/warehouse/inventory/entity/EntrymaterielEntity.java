package com.ms.warehouse.inventory.entity;

import com.ms.warehouse.common.entity.BaseEntity;

/**
 * 入库单主
 * @author hxh
 * @Date 2018-07-27 10:27:56
 * @since 1.0
 */
public class EntrymaterielEntity extends BaseEntity {
	 
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/** 自增id. */
	private Long id;
	
	/** 主数据id. */
	private String dataId;
	
	/** 编码. */
	private String materCode;
	
	/** 名称. */
	private String materName;
	
	/** 版本ID. */
	private String versioncode;
	
	/** 卷烟品牌ID. */
	private String cigBrand;
	
	/** 卷烟品牌. */
	private String cigBrandName;
	
	/** 卷烟类型. */
	private String cigtype;
	
	private Long mainorderId;
	
	public Long getSubId() {
		return subId;
	}

	public void setSubId(Long subId) {
		this.subId = subId;
	}

	public String getSubverName() {
		return subverName;
	}

	public void setSubverName(String subverName) {
		this.subverName = subverName;
	}

	private Long subId;
	
	private String subverName;
		
	public Long getMainorderId() {
		return mainorderId;
	}

	public void setMainorderId(Long mainorderId) {
		this.mainorderId = mainorderId;
	}

	public String getCigtype() {
		return cigtype;
	}

	public void setCigtype(String cigtype) {
		this.cigtype = cigtype;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDataId() {
		return dataId;
	}

	public void setDataId(String dataId) {
		this.dataId = dataId;
	}

	public String getMaterCode() {
		return materCode;
	}

	public void setMaterCode(String materCode) {
		this.materCode = materCode;
	}

	public String getMaterName() {
		return materName;
	}

	public void setMaterName(String materName) {
		this.materName = materName;
	}

	public String getVersioncode() {
		return versioncode;
	}

	public void setVersioncode(String versioncode) {
		this.versioncode = versioncode;
	}

	public String getCigBrand() {
		return cigBrand;
	}

	public void setCigBrand(String cigBrand) {
		this.cigBrand = cigBrand;
	}

	public String getCigBrandName() {
		return cigBrandName;
	}

	public void setCigBrandName(String cigBrandName) {
		this.cigBrandName = cigBrandName;
	}

	
}
