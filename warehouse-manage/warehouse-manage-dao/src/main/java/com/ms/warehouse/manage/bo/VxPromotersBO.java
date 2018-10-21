
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;

import com.ms.warehouse.manage.entity.VxPromotersEntity;
import com.ms.warehouse.manage.mapper.VxPromotersMapper;


/**
 *  bo
 * @author Ms
 * @Date 2018-10-21 19:40:58
 * @since 1.0
 */
@Component
public class VxPromotersBO extends AbstractBaseBO<VxPromotersEntity> {
	
	@Autowired
	private VxPromotersMapper vxPromotersMapper;
	
	@Override
    protected IBaseMapper<VxPromotersEntity> getMapper() {
	    return vxPromotersMapper;
    }
}
