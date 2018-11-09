
package com.ms.warehouse.car.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;

import com.ms.warehouse.car.entity.CarInfoEntity;
import com.ms.warehouse.car.mapper.CarInfoMapper;


/**
 *  bo
 * @author Ms
 * @Date 2018-11-02 14:43:19
 * @since 1.0
 */
@Component
public class CarInfoBO extends AbstractBaseBO<CarInfoEntity> {
	
	@Autowired
	private CarInfoMapper carInfoMapper;
	
	@Override
    protected IBaseMapper<CarInfoEntity> getMapper() {
	    return carInfoMapper;
    }

	public List<String> queryBrandType(String type) {
		return carInfoMapper.queryBrandType(type);
	}
}
