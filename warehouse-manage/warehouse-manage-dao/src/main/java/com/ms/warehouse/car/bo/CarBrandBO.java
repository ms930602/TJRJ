
package com.ms.warehouse.car.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;

import com.ms.warehouse.car.entity.CarBrandEntity;
import com.ms.warehouse.car.mapper.CarBrandMapper;


/**
 *  bo
 * @author Ms
 * @Date 2018-11-09 10:05:05
 * @since 1.0
 */
@Component
public class CarBrandBO extends AbstractBaseBO<CarBrandEntity> {
	
	@Autowired
	private CarBrandMapper carBrandMapper;
	
	@Override
    protected IBaseMapper<CarBrandEntity> getMapper() {
	    return carBrandMapper;
    }
}
