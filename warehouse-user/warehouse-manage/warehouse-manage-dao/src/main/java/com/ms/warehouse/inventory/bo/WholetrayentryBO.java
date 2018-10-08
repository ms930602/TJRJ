
package com.ms.warehouse.inventory.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.inventory.entity.WholetrayentryEntity;
import com.ms.warehouse.inventory.mapper.WholetrayentryMapper;


/**
 * 整托盘入库物料信息 bo
 * @author dwx
 * @Date 2018-07-25 10:22:21
 * @since 1.0
 */
@Component
public class WholetrayentryBO extends AbstractBaseBO<WholetrayentryEntity> {
	
	@Autowired
	private WholetrayentryMapper wholetrayentryMapper;
	
	@Override
    protected IBaseMapper<WholetrayentryEntity> getMapper() {
	    return wholetrayentryMapper;
    }
}
