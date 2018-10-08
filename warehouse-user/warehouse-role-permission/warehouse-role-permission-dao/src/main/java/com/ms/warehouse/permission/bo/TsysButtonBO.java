/**
 * All rights reserved by XinGuoDu Inc.
 */
package com.ms.warehouse.permission.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.permission.entity.TsysButtonEntity;
import com.ms.warehouse.permission.mapper.TsysButtonMapper;


/**
 * 业务处理.<p>
 * @author lansongtao
 * @Date 2017-04-05 09:13:50
 * @since 1.0
 */
@Component
public class TsysButtonBO extends AbstractBaseBO<TsysButtonEntity> {
	
	@Autowired
	private TsysButtonMapper tsysButtonMapper;
	
	@Override
    protected IBaseMapper<TsysButtonEntity> getMapper() {
	    return tsysButtonMapper;
    }
	public List<TsysButtonEntity> queryBymoduleId(String moduleId){
		return tsysButtonMapper.queryBymoduleId(moduleId);
	}
}
