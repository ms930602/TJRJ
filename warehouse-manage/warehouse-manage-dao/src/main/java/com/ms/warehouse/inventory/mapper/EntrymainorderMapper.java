
package com.ms.warehouse.inventory.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.inventory.entity.EntrymainorderEntity;

/**
 * 入库单主 Mapper
 * @author dwx
 * @Date 2018-07-25 10:22:18
 * @since 1.0
 */
@Repository
public interface EntrymainorderMapper extends IBaseMapper<EntrymainorderEntity>{
	List<EntrymainorderEntity> selectEntrymainor(String batchNo);

	EntrymainorderEntity selectbytrayRfid(String trayRfid);
	int queryStaById(Long mainorderId);

	int updateStatus(HashMap<String, Object> map);

	/**
	 * 根据条件查询入库单主体集合
	 * @return
	 */
	List<EntrymainorderEntity> selectEntrymainorderList(Map<String, Object> params);


	List<EntrymainorderEntity> checkshipmentNumber(String shipmentNumber);


	List<EntrymainorderEntity> checkcontractNumber(String contractNumber);

	int checkPlate(String plateNumber);

}
