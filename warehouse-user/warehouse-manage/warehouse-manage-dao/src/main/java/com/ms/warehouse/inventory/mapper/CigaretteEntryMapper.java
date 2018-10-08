package com.ms.warehouse.inventory.mapper;

import java.util.HashMap;
import java.util.List;

import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.inventory.entity.EntrymainorderEntity;
import com.ms.warehouse.inventory.entity.EntrytraylocalmapEntity;

/**
 * 入库单主 Mapper
 * @author hxh
 * @Date 2018-07-27 10:22:18
 * @since 1.0
 */
public interface CigaretteEntryMapper extends IBaseMapper<EntrymainorderEntity>{
	
	List<?> queryPageLocal(ListReqVO<EntrytraylocalmapEntity> reqVO);

	List<EntrytraylocalmapEntity> queryByOrderDetailId(Long id);

	int updateLocal(HashMap<String,Object> map);

	int queryDetailedBind(int id);

	List<HashMap<String, Object>> queryVerByCode(String materCode);

	List<HashMap<String, Object>> queryDetailed(Long id);

	List<HashMap<String, Object>> queryEntryCounts(String day);

	List queryEntrysStatistics(ListReqVO<?> reqVO);
}
