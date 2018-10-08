
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.CarrierunitEntity;
import com.ms.warehouse.manage.mapper.CarrierunitMapper;

import java.util.List;


/**
 * 承运单位 bo
 * @author dwf
 * @Date 2018-07-26 18:37:48
 * @since 1.0
 */
@Component
public class CarrierunitBO extends AbstractBaseBO<CarrierunitEntity> {
	
	@Autowired
	private CarrierunitMapper carrierunitMapper;
	
	@Override
    protected IBaseMapper<CarrierunitEntity> getMapper() {
	    return carrierunitMapper;
    }

    public List<CarrierunitEntity> getAllCarrierunitEntity(String keyword){
    	return carrierunitMapper.getAllCarrierunitEntity(keyword);
	}

	public List<CarrierunitEntity> getAllCarrierunitEntitys(String keyword) {
		return carrierunitMapper.getAllCarrierunitEntitys(keyword);
	}
}
