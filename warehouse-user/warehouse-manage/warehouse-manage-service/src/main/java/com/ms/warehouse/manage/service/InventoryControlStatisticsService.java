package com.ms.warehouse.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.warehouse.common.exception.CenterException;
import com.ms.warehouse.common.service.BaseService;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;
import com.ms.warehouse.manage.bo.InventoryControlStatisticsBO;
import com.ms.warehouse.manage.entity.InventoryControlStatisticsEntity;
/**
 * 存量控制统计服务层
 * @author 王 维
 * create time：2018年8月29日
 */
@Service
public class InventoryControlStatisticsService extends BaseService{
	/**
	 * 存量控制统计BO
	 */
	@Autowired
	private  InventoryControlStatisticsBO inventoryControlStatisticsBO;
	/**
	 * 分页查询列表
	 * 
	 * @param reqVO
	 * @return
	 */
	public ListRespVO list(ListReqVO<InventoryControlStatisticsEntity> reqVO) throws CenterException {
		return inventoryControlStatisticsBO.queryPageAutomatic(reqVO);
	}
	/**
	 * 查询全
	 * @return
	 */
	public List<InventoryControlStatisticsEntity> queryInAll(ListReqVO<InventoryControlStatisticsEntity> reqVO){
		return inventoryControlStatisticsBO.queryPageAutomatic(reqVO).getAaData();
	}
}
