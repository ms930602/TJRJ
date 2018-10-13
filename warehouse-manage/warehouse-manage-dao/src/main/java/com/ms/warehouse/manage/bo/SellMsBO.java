
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;

import com.ms.warehouse.manage.entity.SellMsEntity;
import com.ms.warehouse.manage.mapper.SellMsMapper;


/**
 *  bo
 * @author Ms
 * @Date 2018-10-13 15:55:32
 * @since 1.0
 */
@Component
public class SellMsBO extends AbstractBaseBO<SellMsEntity> {
	
	@Autowired
	private SellMsMapper sellMsMapper;
	
	@Override
    protected IBaseMapper<SellMsEntity> getMapper() {
	    return sellMsMapper;
    }
}
