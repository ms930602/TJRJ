
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;

import com.ms.warehouse.manage.entity.TopinionMsEntity;
import com.ms.warehouse.manage.mapper.TopinionMsMapper;


/**
 *  bo
 * @author Ms
 * @Date 2018-10-12 15:19:08
 * @since 1.0
 */
@Component
public class TopinionMsBO extends AbstractBaseBO<TopinionMsEntity> {
	
	@Autowired
	private TopinionMsMapper topinionMsMapper;
	
	@Override
    protected IBaseMapper<TopinionMsEntity> getMapper() {
	    return topinionMsMapper;
    }
}
