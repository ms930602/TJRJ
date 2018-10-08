
package com.ms.warehouse.inventory.mapper;

import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.inventory.entity.TwareLocallabelexceptionEntity;

import org.springframework.stereotype.Repository;

/**
 * 货位标签异常 Mapper
 * @author cjy
 * @Date 2018-08-13 11:57:41
 * @since 1.0
 */
@Repository
public interface TwareLocallabelexceptionMapper extends IBaseMapper<TwareLocallabelexceptionEntity>{
	TwareLocallabelexceptionEntity queryByStatusEntity(TwareLocallabelexceptionEntity entity);
}
