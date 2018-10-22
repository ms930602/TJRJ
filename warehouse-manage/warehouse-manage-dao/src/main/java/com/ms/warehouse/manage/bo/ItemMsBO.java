
package com.ms.warehouse.manage.bo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;

import com.ms.warehouse.manage.entity.ItemMsEntity;
import com.ms.warehouse.manage.mapper.ItemMsMapper;


/**
 *  bo
 * @author Ms
 * @Date 2018-10-13 15:55:21
 * @since 1.0
 */
@Component
public class ItemMsBO extends AbstractBaseBO<ItemMsEntity> {
	
	@Autowired
	private ItemMsMapper itemMsMapper;
	
	@Override
    protected IBaseMapper<ItemMsEntity> getMapper() {
	    return itemMsMapper;
    }

	public List<ItemMsEntity> checkItemName(String ItemName, Integer gameId) {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("ItemName", ItemName);
		queryMap.put("GameId", gameId);
		return itemMsMapper.checkItemName(queryMap);
	}
}
