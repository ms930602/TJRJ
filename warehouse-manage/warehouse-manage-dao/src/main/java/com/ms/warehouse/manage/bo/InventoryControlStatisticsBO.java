package com.ms.warehouse.manage.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.manage.entity.InventoryControlStatisticsEntity;
import com.ms.warehouse.manage.mapper.InventoryControlStatisticsMapper;
/**
 * 存量控制统计BO
 * @author 王 维
 * create time：2018年8月29日
 */
@Component
public class InventoryControlStatisticsBO extends AbstractBaseBO<InventoryControlStatisticsEntity>{
	@Autowired
	private InventoryControlStatisticsMapper inventoryControlStatisticsMapper;
	@Override
	protected IBaseMapper<InventoryControlStatisticsEntity> getMapper() {
		return inventoryControlStatisticsMapper;
	}
}
