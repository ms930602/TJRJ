
package com.ms.warehouse.manage.mapper;

import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.VehicleinfoEntity;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 车辆信息 Mapper
 * @author dwf
 * @Date 2018-07-26 18:37:47
 * @since 1.0
 */
@Repository
public interface VehicleinfoMapper extends IBaseMapper<VehicleinfoEntity>{
    List<VehicleinfoEntity> getAllVehicleinfoEntity();
}
