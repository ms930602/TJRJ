
package com.jiuzhou.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jiuzhou.warehouse.common.bo.AbstractBaseBO;
import com.jiuzhou.warehouse.common.mapper.IBaseMapper;

import com.jiuzhou.warehouse.manage.entity.MatersubvermapEntity;
import com.jiuzhou.warehouse.manage.mapper.MatersubvermapMapper;


/**
 * 物料和子版本关系对照 bo
 * @author Ms
 * @Date 2018-08-25 16:45:19
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
