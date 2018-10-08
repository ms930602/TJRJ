
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.DriversEntity;
import com.ms.warehouse.manage.mapper.DriversMapper;

import java.util.List;


/**
 * 驾驶员 bo
 * @author dwf
 * @Date 2018-07-26 18:37:48
 * @since 1.0
 */
@Component
public class DriversBO extends AbstractBaseBO<DriversEntity> {
	
	@Autowired
	private DriversMapper driversMapper;
	
	@Override
    protected IBaseMapper<DriversEntity> getMapper() {
	    return driversMapper;
    }

    public List<DriversEntity> getAllDriversEntity(){
    	return driversMapper.getAllDriversEntity();
	}
}
