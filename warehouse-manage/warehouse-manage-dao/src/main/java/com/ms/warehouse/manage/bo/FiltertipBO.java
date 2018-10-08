
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.FiltertipEntity;
import com.ms.warehouse.manage.mapper.FiltertipMapper;


/**
 * 滤嘴类型 bo
 * @author dwx
 * @Date 2018-07-09 18:27:44
 * @since 1.0
 */
@Component
public class FiltertipBO extends AbstractBaseBO<FiltertipEntity> {
	
	@Autowired
	private FiltertipMapper filtertipMapper;
	
	@Override
    protected IBaseMapper<FiltertipEntity> getMapper() {
	    return filtertipMapper;
    }
}
