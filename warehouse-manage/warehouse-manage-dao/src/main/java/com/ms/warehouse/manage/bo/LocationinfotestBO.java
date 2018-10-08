
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.LocationinfotestEntity;
import com.ms.warehouse.manage.mapper.LocationinfotestMapper;


/**
 * 货位信息 bo
 * @author dwx
 * @Date 2018-08-16 10:31:37
 * @since 1.0
 */
@Component
public class LocationinfotestBO extends AbstractBaseBO<LocationinfotestEntity> {
	
	@Autowired
	private LocationinfotestMapper locationinfotestMapper;
	
	@Override
    protected IBaseMapper<LocationinfotestEntity> getMapper() {
	    return locationinfotestMapper;
    }
}
