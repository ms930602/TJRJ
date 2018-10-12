
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;

import com.ms.warehouse.manage.entity.TgameMsEntity;
import com.ms.warehouse.manage.mapper.TgameMsMapper;


/**
 *  bo
 * @author Ms
 * @Date 2018-10-12 15:19:02
 * @since 1.0
 */
@Component
public class TgameMsBO extends AbstractBaseBO<TgameMsEntity> {
	
	@Autowired
	private TgameMsMapper tgameMsMapper;
	
	@Override
    protected IBaseMapper<TgameMsEntity> getMapper() {
	    return tgameMsMapper;
    }
}
