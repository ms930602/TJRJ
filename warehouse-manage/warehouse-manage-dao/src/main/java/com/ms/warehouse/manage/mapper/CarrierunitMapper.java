
package com.ms.warehouse.manage.mapper;

import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.CarrierunitEntity;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 承运单位 Mapper
 * @author dwf
 * @Date 2018-07-26 18:37:48
 * @since 1.0
 */
@Repository
public interface CarrierunitMapper extends IBaseMapper<CarrierunitEntity>{
	List<CarrierunitEntity> getAllCarrierunitEntity(String keyword);

	List<CarrierunitEntity> getAllCarrierunitEntitys(String keyword);
}
