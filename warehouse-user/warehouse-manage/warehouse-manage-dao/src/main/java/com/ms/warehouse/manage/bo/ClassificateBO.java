
package com.ms.warehouse.manage.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.ClassificateEntity;
import com.ms.warehouse.manage.mapper.ClassificateMapper;


/**
 * 数据分类 bo
 * @author dwx
 * @Date 2018-07-09 18:27:45
 * @since 1.0
 */
@Component
public class ClassificateBO extends AbstractBaseBO<ClassificateEntity> {
	
	@Autowired
	private ClassificateMapper classificateMapper;
	
	@Override
    protected IBaseMapper<ClassificateEntity> getMapper() {
	    return classificateMapper;
    }
	
	/**
	 * 查询字典分类信息
	 * @param params
	 * @return
	 */
	public List<ClassificateEntity> queryClassificate(String keyword){
		return classificateMapper.queryClassificate(keyword);
	}
}

