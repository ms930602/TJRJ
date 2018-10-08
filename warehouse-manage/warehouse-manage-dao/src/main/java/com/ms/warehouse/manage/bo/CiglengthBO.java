
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.CiglengthEntity;
import com.ms.warehouse.manage.mapper.CiglengthMapper;


/**
 * 烟支长度规格信息 bo
 * @author dwx
 * @Date 2018-07-09 18:27:44
 * @since 1.0
 */
@Component
public class CiglengthBO extends AbstractBaseBO<CiglengthEntity> {
	
	@Autowired
	private CiglengthMapper ciglengthMapper;
	
	@Override
    protected IBaseMapper<CiglengthEntity> getMapper() {
	    return ciglengthMapper;
    }
}
