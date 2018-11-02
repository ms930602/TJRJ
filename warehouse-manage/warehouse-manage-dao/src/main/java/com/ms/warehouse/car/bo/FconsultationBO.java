
package com.ms.warehouse.car.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;

import com.ms.warehouse.car.entity.FconsultationEntity;
import com.ms.warehouse.car.mapper.FconsultationMapper;


/**
 *  bo
 * @author Ms
 * @Date 2018-11-02 14:43:14
 * @since 1.0
 */
@Component
public class FconsultationBO extends AbstractBaseBO<FconsultationEntity> {
	
	@Autowired
	private FconsultationMapper fconsultationMapper;
	
	@Override
    protected IBaseMapper<FconsultationEntity> getMapper() {
	    return fconsultationMapper;
    }
}
