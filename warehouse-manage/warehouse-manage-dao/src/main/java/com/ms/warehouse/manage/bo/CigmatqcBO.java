
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.CigmatqcEntity;
import com.ms.warehouse.manage.mapper.CigmatqcMapper;


/**
 * 卷烟原材料质量指标 bo
 * @author dwx
 * @Date 2018-07-09 18:27:44
 * @since 1.0
 */
@Component
public class CigmatqcBO extends AbstractBaseBO<CigmatqcEntity> {
	
	@Autowired
	private CigmatqcMapper cigmatqcMapper;
	
	@Override
    protected IBaseMapper<CigmatqcEntity> getMapper() {
	    return cigmatqcMapper;
    }
}
