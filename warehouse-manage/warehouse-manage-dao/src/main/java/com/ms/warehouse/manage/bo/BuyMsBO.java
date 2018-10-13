
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;

import com.ms.warehouse.manage.entity.BuyMsEntity;
import com.ms.warehouse.manage.mapper.BuyMsMapper;


/**
 *  bo
 * @author Ms
 * @Date 2018-10-13 15:55:16
 * @since 1.0
 */
@Component
public class BuyMsBO extends AbstractBaseBO<BuyMsEntity> {
	
	@Autowired
	private BuyMsMapper buyMsMapper;
	
	@Override
    protected IBaseMapper<BuyMsEntity> getMapper() {
	    return buyMsMapper;
    }
}
