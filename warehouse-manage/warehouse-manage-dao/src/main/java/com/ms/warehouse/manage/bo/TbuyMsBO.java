
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;

import com.ms.warehouse.manage.entity.TbuyMsEntity;
import com.ms.warehouse.manage.mapper.TbuyMsMapper;


/**
 *  bo
 * @author Ms
 * @Date 2018-10-12 15:19:00
 * @since 1.0
 */
@Component
public class TbuyMsBO extends AbstractBaseBO<TbuyMsEntity> {
	
	@Autowired
	private TbuyMsMapper tbuyMsMapper;
	
	@Override
    protected IBaseMapper<TbuyMsEntity> getMapper() {
	    return tbuyMsMapper;
    }
}
