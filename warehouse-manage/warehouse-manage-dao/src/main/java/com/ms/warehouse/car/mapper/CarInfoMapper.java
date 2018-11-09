
package com.ms.warehouse.car.mapper;

import com.ms.warehouse.common.mapper.IBaseMapper;

import com.ms.warehouse.car.entity.CarInfoEntity;

import java.util.List;

import org.springframework.stereotype.Repository;

/**
 *  Mapper
 * @author Ms
 * @Date 2018-11-02 14:43:19
 * @since 1.0
 */
@Repository
public interface CarInfoMapper extends IBaseMapper<CarInfoEntity>{

	List<String> queryBrandType(String type);
	
}
