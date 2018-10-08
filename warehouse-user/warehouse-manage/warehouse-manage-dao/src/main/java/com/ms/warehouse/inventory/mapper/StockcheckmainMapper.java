
package com.ms.warehouse.inventory.mapper;

import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.inventory.entity.InventorymainEntity;
import com.ms.warehouse.inventory.entity.OuttraylocalmapEntity;
import com.ms.warehouse.inventory.entity.StockcheckmainEntity;

import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * 库存盘点主信息 Mapper
 * @author dwx
 * @Date 2018-07-25 10:22:20
 * @since 1.0
 */
@Repository
public interface StockcheckmainMapper extends IBaseMapper<StockcheckmainEntity>{
	List<StockcheckmainEntity> queryByBatchNo(String batchNo);
	
	List<StockcheckmainEntity> queryByUnCheckPage(ListReqVO reqVO);
    int queryUnCheckCount(ListReqVO reqVO);
}
