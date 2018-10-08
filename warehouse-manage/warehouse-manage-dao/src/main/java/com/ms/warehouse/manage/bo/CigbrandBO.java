
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.CigbrandEntity;
import com.ms.warehouse.manage.mapper.CigbrandMapper;


/**
 * 卷烟品牌信息 bo
 * @author dwx
 * @Date 2018-07-09 18:27:44
 * @since 1.0
 */
@Component
public class CigbrandBO extends AbstractBaseBO<CigbrandEntity> {
	
	@Autowired
	private CigbrandMapper cigbrandMapper;
	
	@Override
    protected IBaseMapper<CigbrandEntity> getMapper() {
	    return cigbrandMapper;
    }
}
