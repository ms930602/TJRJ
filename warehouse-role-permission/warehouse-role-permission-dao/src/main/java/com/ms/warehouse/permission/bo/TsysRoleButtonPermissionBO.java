/**
 * All rights reserved by XinGuoDu Inc.
 */
package com.ms.warehouse.permission.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.permission.entity.TsysRoleButtonPermissionEntity;
import com.ms.warehouse.permission.mapper.TsysRoleButtonPermissionMapper;


/**
 * 业务处理.<p>
 * @author lansongtao
 * @Date 2017-04-05 09:13:51
 * @since 1.0
 */
@Component
public class TsysRoleButtonPermissionBO extends AbstractBaseBO<TsysRoleButtonPermissionEntity> {
	
	@Autowired
	private TsysRoleButtonPermissionMapper tsysRoleButtonPermissionMapper;
	
	@Override
    protected IBaseMapper<TsysRoleButtonPermissionEntity> getMapper() {
	    return tsysRoleButtonPermissionMapper;
    }
	public List<TsysRoleButtonPermissionEntity> queryByRoleId(String roleId,String sysId){
		return tsysRoleButtonPermissionMapper.queryByRoleId(roleId, sysId);
	}
	public void deleteByRoleIdAndSysId(String roleId,String sysId){
		tsysRoleButtonPermissionMapper.deleteByRoleIdAndSysId(roleId, sysId);
	}
	public void insertList(List<TsysRoleButtonPermissionEntity> list){
		tsysRoleButtonPermissionMapper.insertList(list);
	}
}
