
package com.ms.warehouse.inventory.mapper;

import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.inventory.entity.InventorydetailEntity;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 库存明细 Mapper
 * @author dwx
 * @Date 2018-07-25 10:22:18
 * @since 1.0
 */
@Repository
public interface InventorydetailMapper extends IBaseMapper<InventorydetailEntity>{
	InventorydetailEntity querydetailBybatchNo(String batchNo);
	
	List<InventorydetailEntity>getInventByOrderdetailId(Long orderdetailId);

	/**
	 * 获取库存明细对象
	 * @param inventorydetailEntity
	 * @return
     */
	InventorydetailEntity getInventBybatchandmatercode(InventorydetailEntity inventorydetailEntity);
	
	List<InventorydetailEntity> getAllList(Map<String, Object> params);
}
