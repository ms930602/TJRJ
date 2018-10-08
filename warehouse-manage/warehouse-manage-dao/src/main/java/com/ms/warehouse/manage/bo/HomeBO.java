
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.manage.entity.HomeCountEntity;
import com.ms.warehouse.manage.entity.HomeWarningDetailEntity;
import com.ms.warehouse.manage.entity.InventoryBiEntity;
import com.ms.warehouse.manage.mapper.HomeMapper;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 仓库区域管理 bo
 * @author dwx
 * @Date 2018-07-09 18:27:43
 * @since 1.0
 */
@Component
public class HomeBO{
	
	@Autowired
	private HomeMapper homeMapper;
	
	/**
	 * 入库信息统计
	 * @return
	 */
	public Map<Long,Long> countEntrymainorder(){
		return homeMapper.countEntrymainorder();
	}
	/**
	 * 出库信息统计
	 * @return
	 */
	public Map<Long,Long> countOutmainorder(){
		return homeMapper.countOutmainorder();
	}
	/**
	 * 调整单统计
	 * @return
	 */
	public Map<Long,Long> countPositionadjust(){
		return homeMapper.countPositionadjust();
	}
	/**
	 * 盘点单统计
	 * @return
	 */
	public Map<Long,Long> countStockcheck(){
		return homeMapper.countStockcheck();
	}
	/**
	 * 货位比例统计
	 * @return
	 */
	public List<InventoryBiEntity> countInventoryBi(){
		return homeMapper.countInventoryBi();
	}
	/**
	 * 当天出库量
	 * @return
	 */
	public Long countOutmainorderDay(){
		return homeMapper.countOutmainorderDay();
	}
	/**
	 * 当天入库量
	 * @return
	 */
	public Long countEntryDay(){
		return homeMapper.countEntryDay();
	}
	/**
	 * 当天总库存
	 * @return
	 */
	public Long countInventoryDay(){
		return homeMapper.countInventoryDay();
	}
	
	/**
	 * 入库排名
	 * @param day
	 * @return
	 */
	public List<InventoryBiEntity> queryEntryorderRank(int day){
		return homeMapper.queryEntryorderRank(day);
	}
	/**
	 * 出库排名
	 * @param day
	 * @return
	 */
	public List<InventoryBiEntity> queryOutorderRank(int day){
		return homeMapper.queryOutorderRank(day);
	}
	/**
	 * 库存预警
	 * @param day
	 * @return
	 */
	public List<HomeWarningDetailEntity> queryStockwarningRank(int day){
		return homeMapper.queryStockwarningRank(day);
	}
	public List<HomeCountEntity> queryStockcheckCountBy(Map<String, String> queryMap) {
		return homeMapper.queryStockcheckCountBy(queryMap);
	}
	public List<HomeCountEntity> queryLocationinfoAll() {
		return homeMapper.queryLocationinfoAll();
	}
}
