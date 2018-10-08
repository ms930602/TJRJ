
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.NumcoderulesEntity;
import com.ms.warehouse.manage.mapper.NumcoderulesMapper;


/**
 * 单号编码规则 bo
 * @author dwx
 * @Date 2018-07-09 18:27:43
 * @since 1.0
 */
@Component
public class NumcoderulesBO extends AbstractBaseBO<NumcoderulesEntity> {
	
	@Autowired
	private NumcoderulesMapper numcoderulesMapper;
	
	@Override
    protected IBaseMapper<NumcoderulesEntity> getMapper() {
	    return numcoderulesMapper;
    }
}
