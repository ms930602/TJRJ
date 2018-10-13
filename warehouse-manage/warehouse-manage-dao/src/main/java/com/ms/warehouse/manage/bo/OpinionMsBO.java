
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;

import com.ms.warehouse.manage.entity.OpinionMsEntity;
import com.ms.warehouse.manage.mapper.OpinionMsMapper;


/**
 *  bo
 * @author Ms
 * @Date 2018-10-13 15:55:24
 * @since 1.0
 */
@Component
public class OpinionMsBO extends AbstractBaseBO<OpinionMsEntity> {
	
	@Autowired
	private OpinionMsMapper opinionMsMapper;
	
	@Override
    protected IBaseMapper<OpinionMsEntity> getMapper() {
	    return opinionMsMapper;
    }
}
