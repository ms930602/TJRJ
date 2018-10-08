
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.PricetypeEntity;
import com.ms.warehouse.manage.mapper.PricetypeMapper;


/**
 * 卷烟价类 bo
 * @author dwx
 * @Date 2018-07-09 18:27:44
 * @since 1.0
 */
@Component
public class PricetypeBO extends AbstractBaseBO<PricetypeEntity> {
	
	@Autowired
	private PricetypeMapper pricetypeMapper;
	
	@Override
    protected IBaseMapper<PricetypeEntity> getMapper() {
	    return pricetypeMapper;
    }
}
