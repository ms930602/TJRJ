
package com.ms.warehouse.car.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;

import com.ms.warehouse.car.entity.FsaleCarEntity;
import com.ms.warehouse.car.mapper.FsaleCarMapper;


/**
 *  bo
 * @author Ms
 * @Date 2018-11-02 14:43:16
 * @since 1.0
 */
@Component
public class FsaleCarBO extends AbstractBaseBO<FsaleCarEntity> {
	
	@Autowired
	private FsaleCarMapper fsaleCarMapper;
	
	@Override
    protected IBaseMapper<FsaleCarEntity> getMapper() {
	    return fsaleCarMapper;
    }
}
