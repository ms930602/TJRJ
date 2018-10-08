/**
 * All rights reserved by XinGuoDu Inc.
 */
package com.ms.warehouse.permission.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.permission.entity.TsysSysEntity;
import com.ms.warehouse.permission.mapper.TsysSysMapper;


/**
 * 业务处理.<p>
 * @author lansongtao
 * @Date 2017-04-05 09:13:51
 * @since 1.0
 */
@Component
public class TsysSysBO extends AbstractBaseBO<TsysSysEntity> {
	
	@Autowired
	private TsysSysMapper tsysSysMapper;
	
	@Override
    protected IBaseMapper<TsysSysEntity> getMapper() {
	    return tsysSysMapper;
    }
}
