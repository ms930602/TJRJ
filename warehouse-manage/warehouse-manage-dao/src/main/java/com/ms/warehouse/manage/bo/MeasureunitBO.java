
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.MeasureunitEntity;
import com.ms.warehouse.manage.mapper.MeasureunitMapper;


/**
 * 计量单位 bo
 * @author dwx
 * @Date 2018-07-09 18:27:43
 * @since 1.0
 */
@Component
public class MeasureunitBO extends AbstractBaseBO<MeasureunitEntity> {
	
	@Autowired
	private MeasureunitMapper measureunitMapper;
	
	@Override
    protected IBaseMapper<MeasureunitEntity> getMapper() {
	    return measureunitMapper;
    }
}
