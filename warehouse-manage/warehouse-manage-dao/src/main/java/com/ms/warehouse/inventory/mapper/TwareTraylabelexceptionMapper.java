
package com.ms.warehouse.inventory.mapper;

import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.inventory.entity.TwareTraylabelexceptionEntity;

import org.springframework.stereotype.Repository;

/**
 * 托盘标签异常 Mapper
 * @author cjy
 * @Date 2018-08-13 11:57:41
 * @since 1.0
 */
@Repository
public interface TwareTraylabelexceptionMapper extends IBaseMapper<TwareTraylabelexceptionEntity>{
	TwareTraylabelexceptionEntity queryByStatusEntity(TwareTraylabelexceptionEntity entity);
}
