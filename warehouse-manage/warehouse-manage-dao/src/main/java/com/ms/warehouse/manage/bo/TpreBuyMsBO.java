
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;

import com.ms.warehouse.manage.entity.TpreBuyMsEntity;
import com.ms.warehouse.manage.mapper.TpreBuyMsMapper;


/**
 *  bo
 * @author Ms
 * @Date 2018-10-12 15:19:10
 * @since 1.0
 */
@Component
public class TpreBuyMsBO extends AbstractBaseBO<TpreBuyMsEntity> {
	
	@Autowired
	private TpreBuyMsMapper tpreBuyMsMapper;
	
	@Override
    protected IBaseMapper<TpreBuyMsEntity> getMapper() {
	    return tpreBuyMsMapper;
    }
}
