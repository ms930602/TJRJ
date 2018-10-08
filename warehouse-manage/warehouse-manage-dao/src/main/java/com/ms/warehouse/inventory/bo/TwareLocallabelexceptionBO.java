
package com.ms.warehouse.inventory.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.inventory.entity.TwareLocallabelexceptionEntity;
import com.ms.warehouse.inventory.mapper.TwareLocallabelexceptionMapper;


/**
 * 货位标签异常 bo
 * @author cjy
 * @Date 2018-08-13 11:57:41
 * @since 1.0
 */
@Component
public class TwareLocallabelexceptionBO extends AbstractBaseBO<TwareLocallabelexceptionEntity> {
	
	@Autowired
	private TwareLocallabelexceptionMapper twareLocallabelexceptionMapper;
	
	@Override
    protected IBaseMapper<TwareLocallabelexceptionEntity> getMapper() {
	    return twareLocallabelexceptionMapper;
    }
	
	public TwareLocallabelexceptionEntity queryByStatusEntity(TwareLocallabelexceptionEntity entity){
		return twareLocallabelexceptionMapper.queryByStatusEntity(entity);
	}
}
