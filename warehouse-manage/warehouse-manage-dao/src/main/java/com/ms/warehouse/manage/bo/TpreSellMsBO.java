
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;

import com.ms.warehouse.manage.entity.TpreSellMsEntity;
import com.ms.warehouse.manage.mapper.TpreSellMsMapper;


/**
 *  bo
 * @author Ms
 * @Date 2018-10-12 15:19:13
 * @since 1.0
 */
@Component
public class TpreSellMsBO extends AbstractBaseBO<TpreSellMsEntity> {
	
	@Autowired
	private TpreSellMsMapper tpreSellMsMapper;
	
	@Override
    protected IBaseMapper<TpreSellMsEntity> getMapper() {
	    return tpreSellMsMapper;
    }
}
