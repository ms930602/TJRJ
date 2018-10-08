
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.MatersubvermapEntity;
import com.ms.warehouse.manage.mapper.MatersubvermapMapper;


/**
 * 物料和子版本关系对照 bo
 * @author Ms
 * @Date 2018-08-24 15:46:08
 * @since 1.0
 */
@Component
public class MatersubvermapBO extends AbstractBaseBO<MatersubvermapEntity> {
	
	@Autowired
	private MatersubvermapMapper matersubvermapMapper;
	
	@Override
    protected IBaseMapper<MatersubvermapEntity> getMapper() {
	    return matersubvermapMapper;
    }
}
