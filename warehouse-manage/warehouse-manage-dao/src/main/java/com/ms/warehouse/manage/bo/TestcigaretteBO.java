
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.TestcigaretteEntity;
import com.ms.warehouse.manage.mapper.TestcigaretteMapper;

import java.util.List;


/**
 * 试验卷烟 bo
 * @author Ms
 * @Date 2018-07-30 16:17:10
 * @since 1.0
 */
@Component
public class TestcigaretteBO extends AbstractBaseBO<TestcigaretteEntity> {
	
	@Autowired
	private TestcigaretteMapper testcigaretteMapper;
	
	@Override
    protected IBaseMapper<TestcigaretteEntity> getMapper() {
	    return testcigaretteMapper;
    }

	/**
	 * 获取所有信息
	 * @return
	 */
	public List<TestcigaretteEntity> queryAlllist(){
		return testcigaretteMapper.queryAlllist();
	}
	/**
	 * 根据编码获取对象
	 * @return
	 */
	public TestcigaretteEntity queryByCode(String code){
		return testcigaretteMapper.queryByCode(code);
	}
}
