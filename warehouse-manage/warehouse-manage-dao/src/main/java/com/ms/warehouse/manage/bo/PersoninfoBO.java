
package com.ms.warehouse.manage.bo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.PersoninfoEntity;
import com.ms.warehouse.manage.mapper.PersoninfoMapper;


/**
 * 人员信息 bo
 * @author dwx
 * @Date 2018-07-09 18:27:44
 * @since 1.0
 */
@Component
public class PersoninfoBO extends AbstractBaseBO<PersoninfoEntity> {
	
	@Autowired
	private PersoninfoMapper personinfoMapper;
	
	@Override
    protected IBaseMapper<PersoninfoEntity> getMapper() {
	    return personinfoMapper;
    }
	/**
	 * 通过map条件查询对象信息
	 * @param params
	 * @return
	 */
	public PersoninfoEntity queryByMapParams(Map<String, Object> params) {
		return personinfoMapper.queryByMapParams(params);
	}
}
