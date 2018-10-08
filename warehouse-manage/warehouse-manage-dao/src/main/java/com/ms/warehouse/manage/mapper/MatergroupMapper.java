
package com.ms.warehouse.manage.mapper;

import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.MatergroupEntity;

import org.springframework.stereotype.Repository;

/**
 * 物料组，多个块对应一个组，一个组对应一种 Mapper
 * @author dwx
 * @Date 2018-08-13 13:27:06
 * @since 1.0
 */
@Repository
public interface MatergroupMapper extends IBaseMapper<MatergroupEntity>{
	
}
