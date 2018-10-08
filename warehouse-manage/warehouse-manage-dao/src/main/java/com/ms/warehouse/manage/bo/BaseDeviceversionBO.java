
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.BaseDeviceversionEntity;
import com.ms.warehouse.manage.mapper.BaseDeviceversionMapper;


/**
 * 设备升级版本管理 bo
 * @author wangwei
 * @Date 2018-08-03 09:51:01
 * @since 1.0
 */
@Component
public class BaseDeviceversionBO extends AbstractBaseBO<BaseDeviceversionEntity> {
	
	@Autowired
	private BaseDeviceversionMapper baseDeviceversionMapper;
	
	@Override
    protected IBaseMapper<BaseDeviceversionEntity> getMapper() {
	    return baseDeviceversionMapper;
    }
}
