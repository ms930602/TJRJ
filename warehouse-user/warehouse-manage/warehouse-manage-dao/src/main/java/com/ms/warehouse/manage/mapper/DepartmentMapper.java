
package com.ms.warehouse.manage.mapper;

import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.DepartmentEntity;

import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * 部门信息 Mapper
 * @author dwx
 * @Date 2018-07-09 18:27:43
 * @since 1.0
 */
@Repository
public interface DepartmentMapper extends IBaseMapper<DepartmentEntity>{
	/**
	 * 分页查询
	 * 
	 * @param map
	 * @return
	 */
	public List<DepartmentEntity> queryFullByPage(java.util.Map<String,Object> map);
}
