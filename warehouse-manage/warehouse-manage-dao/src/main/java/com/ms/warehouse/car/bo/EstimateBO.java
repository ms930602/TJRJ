
package com.ms.warehouse.car.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;

import com.ms.warehouse.car.entity.EstimateEntity;
import com.ms.warehouse.car.mapper.EstimateMapper;


/**
 *  bo
 * @author Ms
 * @Date 2018-11-12 10:19:22
 * @since 1.0
 */
@Component
public class EstimateBO extends AbstractBaseBO<EstimateEntity> {
	
	@Autowired
	private EstimateMapper estimateMapper;
	
	@Override
    protected IBaseMapper<EstimateEntity> getMapper() {
	    return estimateMapper;
    }
}
