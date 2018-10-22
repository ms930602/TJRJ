
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;

import com.ms.warehouse.manage.entity.VxBuyInfoEntity;
import com.ms.warehouse.manage.mapper.VxBuyInfoMapper;


/**
 *  bo
 * @author Ms
 * @Date 2018-10-21 19:40:52
 * @since 1.0
 */
@Component
public class VxBuyInfoBO extends AbstractBaseBO<VxBuyInfoEntity> {
	
	@Autowired
	private VxBuyInfoMapper vxBuyInfoMapper;
	
	@Override
    protected IBaseMapper<VxBuyInfoEntity> getMapper() {
	    return vxBuyInfoMapper;
    }
}
