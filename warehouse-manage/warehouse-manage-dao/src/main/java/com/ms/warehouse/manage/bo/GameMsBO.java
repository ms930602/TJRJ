
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;

import com.ms.warehouse.manage.entity.GameMsEntity;
import com.ms.warehouse.manage.mapper.GameMsMapper;


/**
 *  bo
 * @author Ms
 * @Date 2018-10-13 15:55:18
 * @since 1.0
 */
@Component
public class GameMsBO extends AbstractBaseBO<GameMsEntity> {
	
	@Autowired
	private GameMsMapper gameMsMapper;
	
	@Override
    protected IBaseMapper<GameMsEntity> getMapper() {
	    return gameMsMapper;
    }
}
