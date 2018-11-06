
package com.ms.warehouse.car.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;

import com.ms.warehouse.car.entity.ConsultationEntity;
import com.ms.warehouse.car.mapper.ConsultationMapper;


/**
 *  bo
 * @author Ms
 * @Date 2018-11-05 17:02:35
 * @since 1.0
 */
@Component
public class ConsultationBO extends AbstractBaseBO<ConsultationEntity> {
	
	@Autowired
	private ConsultationMapper consultationMapper;
	
	@Override
    protected IBaseMapper<ConsultationEntity> getMapper() {
	    return consultationMapper;
    }
}
