
package com.ms.warehouse.inventory.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.inventory.entity.StockwarningEntity;
import com.ms.warehouse.inventory.mapper.StockwarningMapper;


/**
 * 库存预警 bo
 * @author dwx
 * @Date 2018-07-25 10:22:20
 * @since 1.0
 */
@Component
public class StockwarningBO extends AbstractBaseBO<StockwarningEntity> {
	
	@Autowired
	private StockwarningMapper stockwarningMapper;
	
	@Override
    protected IBaseMapper<StockwarningEntity> getMapper() {
	    return stockwarningMapper;
    }
}
