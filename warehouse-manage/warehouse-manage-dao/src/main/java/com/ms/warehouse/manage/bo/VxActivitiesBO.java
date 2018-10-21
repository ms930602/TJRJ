
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;

import com.ms.warehouse.manage.entity.VxActivitiesEntity;
import com.ms.warehouse.manage.mapper.VxActivitiesMapper;


/**
 *  bo
 * @author Ms
 * @Date 2018-10-21 19:40:49
 * @since 1.0
 */
@Component
public class VxActivitiesBO extends AbstractBaseBO<VxActivitiesEntity> {
	
	@Autowired
	private VxActivitiesMapper vxActivitiesMapper;
	
	@Override
    protected IBaseMapper<VxActivitiesEntity> getMapper() {
	    return vxActivitiesMapper;
    }
}
