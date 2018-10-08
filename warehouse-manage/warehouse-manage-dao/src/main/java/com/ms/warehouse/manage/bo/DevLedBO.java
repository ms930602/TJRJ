
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.DevLedEntity;
import com.ms.warehouse.manage.mapper.DevLedMapper;


/**
 * LED显示器设备 bo
 * @author wangwei
 * @Date 2018-07-13 10:56:45
 * @since 1.0
 */
@Component
public class DevLedBO extends AbstractBaseBO<DevLedEntity> {
	
	@Autowired
	private DevLedMapper devLedMapper;
	
	@Override
    protected IBaseMapper<DevLedEntity> getMapper() {
	    return devLedMapper;
    }
}
