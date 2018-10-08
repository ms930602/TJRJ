
package com.ms.warehouse.inventory.mapper;

import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.inventory.entity.InventorymainEntity;
import com.ms.warehouse.inventory.entity.InventorytraylocalPageEntity;
import com.ms.warehouse.inventory.entity.PositionadjustmainEntity;

import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * 货位调整主 Mapper
 * @author dwx
 * @Date 2018-07-25 10:22:20
 * @since 1.0
 */
@Repository
public interface PositionadjustmainMapper extends IBaseMapper<PositionadjustmainEntity>{
	List<PositionadjustmainEntity> queryByBatchNo(String batchNo);
	List<InventorytraylocalPageEntity> queryInventorytraylocalPage(ListReqVO<InventorytraylocalPageEntity> reqVO);
	
	List<PositionadjustmainEntity> queryPPdByPage(ListReqVO reqVO);
    int queryPPdCount(ListReqVO reqVO);
}
