
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.ShippingtypeEntity;
import com.ms.warehouse.manage.mapper.ShippingtypeMapper;

import java.util.List;


/**
 * 运输方式 bo
 * @author dwf
 * @Date 2018-07-26 18:37:48
 * @since 1.0
 */
@Component
public class ShippingtypeBO extends AbstractBaseBO<ShippingtypeEntity> {
	
	@Autowired
	private ShippingtypeMapper shippingtypeMapper;
	
	@Override
    protected IBaseMapper<ShippingtypeEntity> getMapper() {
	    return shippingtypeMapper;
    }

	public List<ShippingtypeEntity> getAllShippingtypeEntity(){
		return shippingtypeMapper.getAllShippingtypeEntity();
	}
}
