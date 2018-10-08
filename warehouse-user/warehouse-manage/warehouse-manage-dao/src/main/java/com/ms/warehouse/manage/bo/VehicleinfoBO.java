
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.VehicleinfoEntity;
import com.ms.warehouse.manage.mapper.VehicleinfoMapper;

import java.util.List;


/**
 * 车辆信息 bo
 * @author dwf
 * @Date 2018-07-26 18:37:47
 * @since 1.0
 */
@Component
public class VehicleinfoBO extends AbstractBaseBO<VehicleinfoEntity> {
	
	@Autowired
	private VehicleinfoMapper vehicleinfoMapper;
	
	@Override
    protected IBaseMapper<VehicleinfoEntity> getMapper() {
	    return vehicleinfoMapper;
    }

    public List<VehicleinfoEntity> getAllVehicleinfoEntity(){
    	return vehicleinfoMapper.getAllVehicleinfoEntity();
	}
}
