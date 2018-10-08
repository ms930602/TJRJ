
package com.ms.warehouse.inventory.mapper;

import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.inventory.entity.EntrytraylocalmapEntity;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 * 托盘货位绑定信息 Mapper
 * @author dwx
 * @Date 2018-07-25 10:22:18
 * @since 1.0
 */
@Repository
public interface EntrytraylocalmapMapper extends IBaseMapper<EntrytraylocalmapEntity>{
	List<EntrytraylocalmapEntity> queryByBatchNo(String batchNo);


	List<EntrytraylocalmapEntity> getEntryStatus(String rfid);

	EntrytraylocalmapEntity queryByRfid(Map<String, Object> map);

	int updateStatus(long id);

	EntrytraylocalmapEntity queryStaById(long id);

	/**
	 * 通过条件更新对象
	 * @param params
	 * @return
	 */
	int updateEntrytraylocalmap(Map<String, Object> params);
	/**
	 * 通过条件查询对象
	 * @param params
	 * @return
	 */
	EntrytraylocalmapEntity queryByMapsParam(Map<String, Object> params);
		
	List<EntrytraylocalmapEntity> queryByPages(ListReqVO<?> reqVO);
	/**
	 * 查询rfid为空的集合
	 * @return
	 */
	List<EntrytraylocalmapEntity> queryNullTrayRfidList(Map<String, Object> params);
}
