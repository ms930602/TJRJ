
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.CigtypeEntity;
import com.ms.warehouse.manage.mapper.CigtypeMapper;


/**
 * 卷烟类型 bo
 * @author dwx
 * @Date 2018-07-09 18:27:44
 * @since 1.0
 */
@Component
public class CigtypeBO extends AbstractBaseBO<CigtypeEntity> {
	
	@Autowired
	private CigtypeMapper cigtypeMapper;
	
	@Override
    protected IBaseMapper<CigtypeEntity> getMapper() {
	    return cigtypeMapper;
    }
}
