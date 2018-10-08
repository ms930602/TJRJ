/**
 * All rights reserved by XinGuoDu Inc.
 */
package com.ms.warehouse.permission.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.permission.entity.TsysModuleEntity;
import com.ms.warehouse.permission.mapper.TsysModuleMapper;


/**
 * 业务处理.<p>
 * @author lansongtao
 * @Date 2017-04-05 09:13:50
 * @since 1.0
 */
@Component
public class TsysModuleBO extends AbstractBaseBO<TsysModuleEntity> {
	
	@Autowired
	private TsysModuleMapper tsysModuleMapper;
	
	@Override
    protected IBaseMapper<TsysModuleEntity> getMapper() {
	    return tsysModuleMapper;
    }
	public List<TsysModuleEntity> query(String sysId){
		return tsysModuleMapper.query(sysId);
	}
	public List<TsysModuleEntity> queryMainMenuItem(String sysId){
		return tsysModuleMapper.queryMainMenuItem(sysId);
	}
	public List<TsysModuleEntity> queryNot(String sysId){
		return tsysModuleMapper.queryNot(sysId);
	}
	
}
