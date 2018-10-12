
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;

import com.ms.warehouse.manage.entity.TsellMsEntity;
import com.ms.warehouse.manage.mapper.TsellMsMapper;


/**
 *  bo
 * @author Ms
 * @Date 2018-10-12 15:19:15
 * @since 1.0
 */
@Component
public class TsellMsBO extends AbstractBaseBO<TsellMsEntity> {
	
	@Autowired
	private TsellMsMapper tsellMsMapper;
	
	@Override
    protected IBaseMapper<TsellMsEntity> getMapper() {
	    return tsellMsMapper;
    }
}
