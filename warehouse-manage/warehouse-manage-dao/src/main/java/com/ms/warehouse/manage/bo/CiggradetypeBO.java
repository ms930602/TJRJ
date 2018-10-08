
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.CiggradetypeEntity;
import com.ms.warehouse.manage.mapper.CiggradetypeMapper;


/**
 * 卷烟档次分类 bo
 * @author dwx
 * @Date 2018-07-09 18:27:44
 * @since 1.0
 */
@Component
public class CiggradetypeBO extends AbstractBaseBO<CiggradetypeEntity> {
	
	@Autowired
	private CiggradetypeMapper ciggradetypeMapper;
	
	@Override
    protected IBaseMapper<CiggradetypeEntity> getMapper() {
	    return ciggradetypeMapper;
    }
}
