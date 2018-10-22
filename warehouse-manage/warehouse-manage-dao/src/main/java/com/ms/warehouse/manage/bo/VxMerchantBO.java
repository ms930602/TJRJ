
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;

import com.ms.warehouse.manage.entity.VxMerchantEntity;
import com.ms.warehouse.manage.mapper.VxMerchantMapper;


/**
 *  bo
 * @author Ms
 * @Date 2018-10-21 19:40:55
 * @since 1.0
 */
@Component
public class VxMerchantBO extends AbstractBaseBO<VxMerchantEntity> {
	
	@Autowired
	private VxMerchantMapper vxMerchantMapper;
	
	@Override
    protected IBaseMapper<VxMerchantEntity> getMapper() {
	    return vxMerchantMapper;
    }
}
