
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.EvaluatypeEntity;
import com.ms.warehouse.manage.mapper.EvaluatypeMapper;


/**
 * 评价分类 bo
 * @author dwx
 * @Date 2018-07-09 18:27:44
 * @since 1.0
 */
@Component
public class EvaluatypeBO extends AbstractBaseBO<EvaluatypeEntity> {
	
	@Autowired
	private EvaluatypeMapper evaluatypeMapper;
	
	@Override
    protected IBaseMapper<EvaluatypeEntity> getMapper() {
	    return evaluatypeMapper;
    }
}
