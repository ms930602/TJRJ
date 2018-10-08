/**
 * 
 */
package com.ms.warehouse.inventory.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.inventory.entity.InventoryAllEntity;

/**
 * 库存 Mapper
 * @author cjy
 * @Date 2018-07-31 10:22:19
 * @since 1.0
 */
@Repository
public interface InventoryAllMapper extends IBaseMapper<InventoryAllEntity>{
	
	List<InventoryAllEntity> queryInAllByPage(ListReqVO reqVO);
    int queryInAllCount(ListReqVO reqVO);
    
    List<InventoryAllEntity> queryInAllbyId(int id);
    
    List<InventoryAllEntity> queryInAll();

}
