
package com.ms.warehouse.inventory.mapper;

import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.inventory.entity.InventorymainEntity;
import com.ms.warehouse.inventory.entity.StockcheckdetailEntity;
import com.ms.warehouse.inventory.entity.StockcheckmainEntity;

import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * 盘点详情 Mapper
 * @author dwx
 * @Date 2018-07-25 10:22:20
 * @since 1.0
 */
@Repository
public interface StockcheckdetailMapper extends IBaseMapper<StockcheckdetailEntity>{
	List<StockcheckdetailEntity> queryByBatchNo(String batchNo);

	void deleteByMainId(Long id);
	
	List<StockcheckdetailEntity> queryBymainId(Long mainId);
	
	List<StockcheckdetailEntity> queryPhoneByPage(ListReqVO reqVO);
    int queryPhoneCount(ListReqVO reqVO);
}
