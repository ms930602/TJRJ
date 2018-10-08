
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.CigprodtypeEntity;
import com.ms.warehouse.manage.mapper.CigprodtypeMapper;


/**
 * 生产类型 bo
 * @author dwx
 * @Date 2018-07-09 18:27:44
 * @since 1.0
 */
@Component
public class CigprodtypeBO extends AbstractBaseBO<CigprodtypeEntity> {
	
	@Autowired
	private CigprodtypeMapper cigprodtypeMapper;
	
	@Override
    protected IBaseMapper<CigprodtypeEntity> getMapper() {
	    return cigprodtypeMapper;
    }
}
