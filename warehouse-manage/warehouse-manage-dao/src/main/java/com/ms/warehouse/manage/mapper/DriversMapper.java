
package com.ms.warehouse.manage.mapper;

import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.DriversEntity;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 驾驶员 Mapper
 * @author dwf
 * @Date 2018-07-26 18:37:48
 * @since 1.0
 */
@Repository
public interface DriversMapper extends IBaseMapper<DriversEntity>{
	List<DriversEntity> getAllDriversEntity();
}
