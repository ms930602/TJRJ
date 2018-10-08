
package com.ms.warehouse.manage.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ms.warehouse.manage.entity.HomeCountEntity;
import com.ms.warehouse.manage.entity.HomeWarningDetailEntity;
import com.ms.warehouse.manage.entity.InventoryBiEntity;

/**
 * 首页统计Mapper
 * @author Ms
 * @Date 2018-08-18
 * @since 1.0
 */
@Repository
public interface HomeMapper{
	/**
	 * 入库信息统计
	 * @return
	 */
	public Map<Long,Long> countEntrymainorder();
	/**
	 * 出库信息统计
	 * @return
	 */
	public Map<Long,Long> countOutmainorder();
	/**
	 * 调整单统计
	 * @return
	 */
	public Map<Long,Long> countPositionadjust();
	/**
	 * 盘点单统计
	 * @return
	 */
	public Map<Long,Long> countStockcheck();
	/**
	 * 货位比例统计
	 * @return
	 */
	public List<InventoryBiEntity> countInventoryBi();
	/**
	 * 当天出库量
	 * @return
	 */
	public Long countOutmainorderDay();
	/**
	 * 当天入库量
	 * @return
	 */
	public Long countEntryDay();
	/**
	 * 当天总库存
	 * @return
	 */
	public Long countInventoryDay();
	
	/**
	 * 入库排名
	 * @param day
	 * @return
	 */
	public List<InventoryBiEntity> queryEntryorderRank(int day);
	/**
	 * 出库排名
	 * @param day
	 * @return
	 */
	public List<InventoryBiEntity> queryOutorderRank(int day);
	/**
	 * 库存预警
	 * @param day
	 * @return
	 */
	public List<HomeWarningDetailEntity> queryStockwarningRank(int type);
	/**
	 * 根据时间段查询调整单数量
	 * @param queryMap
	 * @return
	 */
	public List<HomeCountEntity> queryStockcheckCountBy(Map<String, String> queryMap);
	
	public List<HomeCountEntity> queryLocationinfoAll();
}
