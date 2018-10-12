
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;

import com.ms.warehouse.manage.entity.TitemMsEntity;
import com.ms.warehouse.manage.mapper.TitemMsMapper;


/**
 *  bo
 * @author Ms
 * @Date 2018-10-12 15:19:05
 * @since 1.0
 */
@Component
public class TitemMsBO extends AbstractBaseBO<TitemMsEntity> {
	
	@Autowired
	private TitemMsMapper titemMsMapper;
	
	@Override
    protected IBaseMapper<TitemMsEntity> getMapper() {
	    return titemMsMapper;
    }
}
