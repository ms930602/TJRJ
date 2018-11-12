
package com.ms.warehouse.car.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;

import com.ms.warehouse.car.entity.CarUserEntity;
import com.ms.warehouse.car.mapper.CarUserMapper;


/**
 *  bo
 * @author Ms
 * @Date 2018-11-12 09:35:03
 * @since 1.0
 */
@Component
public class CarUserBO extends AbstractBaseBO<CarUserEntity> {
	
	@Autowired
	private CarUserMapper carUserMapper;
	
	@Override
    protected IBaseMapper<CarUserEntity> getMapper() {
	    return carUserMapper;
    }
}
