package com.ms.warehouse.permission.api;

import java.util.List;

import com.ms.warehouse.permission.entity.PermissonInfo;
import com.ms.warehouse.permission.entity.TsysRoleUserEntity;



public interface IPermissionSService {
	
	public PermissonInfo initMenusService(String userId,String sysId,String flag);
	public List<TsysRoleUserEntity> getUsersByRoleId(String roleId);
	public void createTsysRoleUser(Long userId,Long roleId);
}
