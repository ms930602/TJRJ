
package com.ms.warehouse.inventory.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.inventory.entity.TwareLocallabelexceptionEntity;
import com.ms.warehouse.inventory.entity.TwareTraylabelexceptionEntity;
import com.ms.warehouse.inventory.mapper.TwareTraylabelexceptionMapper;


/**
 * 托盘标签异常 bo
 * @author cjy
 * @Date 2018-08-13 11:57:41
 * @since 1.0
 */
@Component
public class TwareTraylabelexceptionBO extends AbstractBaseBO<TwareTraylabelexceptionEntity> {
	
	@Autowired
	private TwareTraylabelexceptionMapper twareTraylabelexceptionMapper;
	
	@Override
    protected IBaseMapper<TwareTraylabelexceptionEntity> getMapper() {
	    return twareTraylabelexceptionMapper;
    }
	
	public TwareTraylabelexceptionEntity queryByStatusEntity(TwareTraylabelexceptionEntity entity){
		return twareTraylabelexceptionMapper.queryByStatusEntity(entity);
	}
}
