
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.MatergroupEntity;
import com.ms.warehouse.manage.mapper.MatergroupMapper;


/**
 * 物料组，多个块对应一个组，一个组对应一种 bo
 * @author dwx
 * @Date 2018-08-13 13:27:06
 * @since 1.0
 */
@Component
public class MatergroupBO extends AbstractBaseBO<MatergroupEntity> {
	
	@Autowired
	private MatergroupMapper matergroupMapper;
	
	@Override
    protected IBaseMapper<MatergroupEntity> getMapper() {
	    return matergroupMapper;
    }
}
