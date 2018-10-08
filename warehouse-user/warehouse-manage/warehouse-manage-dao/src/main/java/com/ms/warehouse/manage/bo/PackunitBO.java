
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.PackunitEntity;
import com.ms.warehouse.manage.mapper.PackunitMapper;


/**
 * 包装单位 bo
 * @author dwx
 * @Date 2018-07-09 18:27:44
 * @since 1.0
 */
@Component
public class PackunitBO extends AbstractBaseBO<PackunitEntity> {
	
	@Autowired
	private PackunitMapper packunitMapper;
	
	@Override
    protected IBaseMapper<PackunitEntity> getMapper() {
	    return packunitMapper;
    }
}
