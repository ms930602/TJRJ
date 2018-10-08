
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.TransnationEntity;
import com.ms.warehouse.manage.mapper.TransnationMapper;


/**
 * 国内国外销售 bo
 * @author dwx
 * @Date 2018-07-09 18:27:45
 * @since 1.0
 */
@Component
public class TransnationBO extends AbstractBaseBO<TransnationEntity> {
	
	@Autowired
	private TransnationMapper transnationMapper;
	
	@Override
    protected IBaseMapper<TransnationEntity> getMapper() {
	    return transnationMapper;
    }
}
