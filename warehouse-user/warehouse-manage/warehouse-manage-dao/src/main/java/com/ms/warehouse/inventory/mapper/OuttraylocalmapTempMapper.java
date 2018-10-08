
package com.ms.warehouse.inventory.mapper;

import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.inventory.entity.OuttraylocalmapTempEntity;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 出库单托盘货位对照关系临时 Mapper
 * @author dwf
 * @Date 2018-07-27 11:25:34
 * @since 1.0
 */
@Repository
public interface OuttraylocalmapTempMapper extends IBaseMapper<OuttraylocalmapTempEntity>{
	int deletedataByuuid(String uuid);
	List<OuttraylocalmapTempEntity> querytempLocalByuuid(String uuid);
	List<OuttraylocalmapTempEntity> queryTempByuuid(String uuid);
	List<OuttraylocalmapTempEntity>tempcalculateoutoquality(String uuid);
}
