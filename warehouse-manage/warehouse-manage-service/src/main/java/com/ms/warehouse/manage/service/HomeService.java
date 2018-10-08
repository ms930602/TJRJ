package com.ms.warehouse.manage.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.warehouse.common.exception.CenterException;
import com.ms.warehouse.common.service.BaseService;
import com.ms.warehouse.common.vo.Param;
import com.ms.warehouse.manage.bo.HomeBO;
import com.ms.warehouse.manage.entity.HomeCountEntity;
import com.ms.warehouse.manage.entity.HomeEntity;
import com.ms.warehouse.manage.entity.HomeWarningDetailEntity;
import com.ms.warehouse.manage.entity.HomeWarningEntity;
import com.ms.warehouse.manage.entity.InventoryBiEntity;
import com.ms.warehouse.manage.entity.LocationinfoAllEntity;

/**
 * 仓库区域管理 业务处理
 * @author ms
 * @Date 2018-08-18
 * @since 1.0
 */@Service
public class HomeService extends BaseService {

	@Autowired
	private HomeBO homeBO;
	
	public Object queryHome() throws CenterException {
		Map<Long, Long> countEntrymainorder = homeBO.countEntrymainorder();//入
		Map<Long, Long> countOutmainorder = homeBO.countOutmainorder();//出
		Map<Long, Long> countStockcheck = homeBO.countStockcheck();//盘
		Map<Long, Long> countPositionadjust = homeBO.countPositionadjust();//调
		
		Long countInventoryDay = homeBO.countInventoryDay();//当天总
		Long countEntryDay = homeBO.countEntryDay();//当天入
		Long countOutmainorderDay = homeBO.countOutmainorderDay();//当天出
		
		List<InventoryBiEntity> countInventoryBi = homeBO.countInventoryBi();//货位占比
		
		HomeEntity he = new HomeEntity(
				countEntrymainorder,countOutmainorder,
				countPositionadjust,countStockcheck,countInventoryBi,
				countOutmainorderDay,countEntryDay,countInventoryDay
				);
		
		return he;
	}
	
	public Object entryorderRank(@Param("day")Integer day)throws CenterException {
		if(day == null){
			day = 0;
		}
		return homeBO.queryEntryorderRank(day);
	}
	public Object OutorderRank(@Param("day")Integer day)throws CenterException {
		if(day == null){
			day = 0;
		}
		return homeBO.queryOutorderRank(day);
	}
	public Object StockwarningRank(@Param("day")Integer day)throws CenterException, ParseException {
		if(day == null){
			day = 0;
		}
		List<HomeWarningDetailEntity> one = homeBO.queryStockwarningRank(0);
		List<HomeWarningDetailEntity> two = homeBO.queryStockwarningRank(1);
		List<HomeWarningDetailEntity> three = homeBO.queryStockwarningRank(2);
		
		HomeWarningEntity hwe = new HomeWarningEntity(one,two,three);
		return hwe;
	}
	
	public Object queryStockcheckCountBy(@Param("startTime")String startTime,@Param("endTime")String endTime){
		Map<String, String> queryMap = new HashMap<String, String>();
		queryMap.put("startTime", startTime);
		queryMap.put("endTime", endTime);
		List<HomeCountEntity> list = homeBO.queryStockcheckCountBy(queryMap);
		return list;
	}
	
	public Object queryLocationinfoAll(){
		List<HomeCountEntity> list = homeBO.queryLocationinfoAll();
		LocationinfoAllEntity lae = new LocationinfoAllEntity();
		List<Long> kongX = new ArrayList<>();
		List<Long> zhanY = new ArrayList<>();
		Set<String> xName = new HashSet<>();
		for (HomeCountEntity entity : list) {
			xName.add(entity.getFloorAreaCode());
			if(entity.getStatus().equals("0")){
				kongX.add(entity.getCountQuality());
			}else{
				zhanY.add(entity.getCountQuality());
			}
		}
		lae.setKongXian(kongX);
		lae.setZhanYong(zhanY);
		lae.setxTitle(xName);
		lae.setDataList(list);
		return lae;
	}
}
