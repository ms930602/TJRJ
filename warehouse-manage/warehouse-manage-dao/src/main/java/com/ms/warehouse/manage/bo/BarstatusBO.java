
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.BarstatusEntity;
import com.ms.warehouse.manage.mapper.BarstatusMapper;


/**
 * 条码状态 bo
 * @author dwx
 * @Date 2018-07-09 18:27:44
 * @since 1.0
 */
@Component
public class BarstatusBO extends AbstractBaseBO<BarstatusEntity> {
	
	@Autowired
	private BarstatusMapper barstatusMapper;
	
	@Override
    protected IBaseMapper<BarstatusEntity> getMapper() {
	    return barstatusMapper;
    }
}
