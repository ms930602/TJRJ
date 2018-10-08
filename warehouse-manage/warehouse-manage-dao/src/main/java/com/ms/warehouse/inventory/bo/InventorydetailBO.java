
package com.ms.warehouse.inventory.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.inventory.entity.InventorydetailEntity;
import com.ms.warehouse.inventory.mapper.InventorydetailMapper;

import java.security.PublicKey;
import java.util.List;
import java.util.Map;


/**
 * 库存明细 bo
 * @author dwx
 * @Date 2018-07-25 10:22:18
 * @since 1.0
 */
@Component
public class InventorydetailBO extends AbstractBaseBO<InventorydetailEntity> {
	
	@Autowired
	private InventorydetailMapper inventorydetailMapper;
	
	@Override
    protected IBaseMapper<InventorydetailEntity> getMapper() {
	    return inventorydetailMapper;
    }

    public InventorydetailEntity querydetailBybatchNo(String batchNo){
    	return inventorydetailMapper.querydetailBybatchNo(batchNo);
	}
    
    public List<InventorydetailEntity>getInventByOrderdetailId(Long orderdetailId){
    	return inventorydetailMapper.getInventByOrderdetailId(orderdetailId);
    }
	/**
	 * 获取库存明细对象
	 * @param inventorydetailEntity
	 * @return
	 */
	public InventorydetailEntity getInventBybatchandmatercode(InventorydetailEntity inventorydetailEntity){
		return inventorydetailMapper.getInventBybatchandmatercode(inventorydetailEntity);
	}
	public List<InventorydetailEntity> getAllList(Map<String, Object> params){
		return inventorydetailMapper.getAllList(params);
	}
}
