
package com.ms.warehouse.inventory.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.inventory.entity.InventoryflowEntity;
import com.ms.warehouse.inventory.mapper.InventoryflowMapper;


/**
 * 库存流水 bo
 * @author dwx
 * @Date 2018-07-25 10:22:18
 * @since 1.0
 */
@Component
public class InventoryflowBO extends AbstractBaseBO<InventoryflowEntity> {
	
	@Autowired
	private InventoryflowMapper inventoryflowMapper;
	
	@Override
    protected IBaseMapper<InventoryflowEntity> getMapper() {
	    return inventoryflowMapper;
    }
}
