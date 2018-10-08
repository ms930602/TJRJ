
package com.ms.warehouse.manage.bo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.DepartmentEntity;
import com.ms.warehouse.manage.mapper.DepartmentMapper;


/**
 * 部门信息 bo
 * @author dwx
 * @Date 2018-07-09 18:27:43
 * @since 1.0
 */
@Component
public class DepartmentBO extends AbstractBaseBO<DepartmentEntity> {
	
	@Autowired
	private DepartmentMapper departmentMapper;
	
	@Override
    protected IBaseMapper<DepartmentEntity> getMapper() {
	    return departmentMapper;
    }
	
	/**
	 * 获取包括父级部门名称的完整列表信息
	 * @param map
	 * @return
	 */
	public List<DepartmentEntity> queryFullList(java.util.Map<String,Object> map) {
		return departmentMapper.queryFullByPage(map);
	}
}
