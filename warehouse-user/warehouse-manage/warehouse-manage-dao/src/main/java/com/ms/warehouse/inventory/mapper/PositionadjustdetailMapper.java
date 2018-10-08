
package com.ms.warehouse.inventory.mapper;

import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.inventory.entity.OuttraylocalmapEntity;
import com.ms.warehouse.inventory.entity.PositionadjustdetailEntity;
import com.ms.warehouse.inventory.entity.PositionadjustmainEntity;

import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * 货位调整表详情 Mapper
 * @author dwx
 * @Date 2018-07-25 10:22:20
 * @since 1.0
 */
@Repository
public interface PositionadjustdetailMapper extends IBaseMapper<PositionadjustdetailEntity>{
	List<PositionadjustdetailEntity> queryByBatchNo(String batchNo);

	void deleteByMainId(Long id);
	
	List<PositionadjustdetailEntity> queryByPageun(ListReqVO reqVO);
    int queryCountun(ListReqVO reqVO);
}
