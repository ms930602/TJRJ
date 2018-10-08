package com.ms.warehouse.manage.entity;

import com.ms.warehouse.common.entity.BaseEntity;

/** 
 * @author: dwx 
 * @Description: 批量生成货位参数实体
 * @date 创建时间：2018年8月16日 上午11:26:27 
 */
public class LocationinfoParamsEntity extends BaseEntity{
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	
	/** 楼层区域编码 组合. */
	private String floorAreaCode;
	
	/** 块号. */
	private Long areaBlock;
	
	/** 块排数（行数）. */
	private Long areaRow;
	
	/** 块列数. */
	private Long areaClo;
	
	/** 开始排（开始行）默认1. */
	private Long StartRow;


	public Long getAreaBlock() {
		return areaBlock;
	}

	public void setAreaBlock(Long areaBlock) {
		this.areaBlock = areaBlock;
	}

	public Long getAreaRow() {
		return areaRow;
	}

	public void setAreaRow(Long areaRow) {
		this.areaRow = areaRow;
	}

	public Long getAreaClo() {
		return areaClo;
	}

	public void setAreaClo(Long areaClo) {
		this.areaClo = areaClo;
	}

	public Long getStartRow() {
		return StartRow;
	}

	public void setStartRow(Long startRow) {
		StartRow = startRow;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getFloorAreaCode() {
		return floorAreaCode;
	}

	public void setFloorAreaCode(String floorAreaCode) {
		this.floorAreaCode = floorAreaCode;
	}
	
}
