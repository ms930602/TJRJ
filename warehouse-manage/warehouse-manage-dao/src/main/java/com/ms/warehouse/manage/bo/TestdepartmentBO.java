
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.TestdepartmentEntity;
import com.ms.warehouse.manage.mapper.TestdepartmentMapper;


/**
 * 试验部门 bo
 * @author dwx
 * @Date 2018-07-09 18:27:45
 * @since 1.0
 */
@Component
public class TestdepartmentBO extends AbstractBaseBO<TestdepartmentEntity> {
	
	@Autowired
	private TestdepartmentMapper testdepartmentMapper;
	
	@Override
    protected IBaseMapper<TestdepartmentEntity> getMapper() {
	    return testdepartmentMapper;
    }
}
