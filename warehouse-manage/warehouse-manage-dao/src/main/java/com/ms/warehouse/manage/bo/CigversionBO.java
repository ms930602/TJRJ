
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.CigversionEntity;
import com.ms.warehouse.manage.mapper.CigversionMapper;


/**
 * 版本 bo
 * @author dwx
 * @Date 2018-07-09 18:27:44
 * @since 1.0
 */
@Component
public class CigversionBO extends AbstractBaseBO<CigversionEntity> {
	
	@Autowired
	private CigversionMapper cigversionMapper;
	
	@Override
    protected IBaseMapper<CigversionEntity> getMapper() {
	    return cigversionMapper;
    }
}
