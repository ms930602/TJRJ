
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;

import com.ms.warehouse.manage.entity.PreSellMsEntity;
import com.ms.warehouse.manage.mapper.PreSellMsMapper;


/**
 *  bo
 * @author Ms
 * @Date 2018-10-13 15:55:29
 * @since 1.0
 */
@Component
public class PreSellMsBO extends AbstractBaseBO<PreSellMsEntity> {
	
	@Autowired
	private PreSellMsMapper preSellMsMapper;
	
	@Override
    protected IBaseMapper<PreSellMsEntity> getMapper() {
	    return preSellMsMapper;
    }
}
