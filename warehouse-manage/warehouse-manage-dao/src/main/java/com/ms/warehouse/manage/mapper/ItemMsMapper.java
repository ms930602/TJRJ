
package com.ms.warehouse.manage.mapper;

import com.ms.warehouse.common.mapper.IBaseMapper;

import com.ms.warehouse.manage.entity.ItemMsEntity;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 *  Mapper
 * @author Ms
 * @Date 2018-10-13 15:55:21
 * @since 1.0
 */
@Repository
public interface ItemMsMapper extends IBaseMapper<ItemMsEntity>{

	List<ItemMsEntity> checkItemName(Map<String, Object> queryMap);
	
}
