
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;

import com.ms.warehouse.manage.entity.VxLogEntity;
import com.ms.warehouse.manage.mapper.VxLogMapper;


/**
 *  bo
 * @author Ms
 * @Date 2018-10-30 14:34:47
 * @since 1.0
 */
@Component
public class VxLogBO extends AbstractBaseBO<VxLogEntity> {
	
	@Autowired
	private VxLogMapper vxLogMapper;
	
	@Override
    protected IBaseMapper<VxLogEntity> getMapper() {
	    return vxLogMapper;
    }
}
