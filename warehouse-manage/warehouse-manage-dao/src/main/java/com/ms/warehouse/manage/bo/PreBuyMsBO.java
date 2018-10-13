
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;

import com.ms.warehouse.manage.entity.PreBuyMsEntity;
import com.ms.warehouse.manage.mapper.PreBuyMsMapper;


/**
 *  bo
 * @author Ms
 * @Date 2018-10-13 15:55:27
 * @since 1.0
 */
@Component
public class PreBuyMsBO extends AbstractBaseBO<PreBuyMsEntity> {
	
	@Autowired
	private PreBuyMsMapper preBuyMsMapper;
	
	@Override
    protected IBaseMapper<PreBuyMsEntity> getMapper() {
	    return preBuyMsMapper;
    }
}
