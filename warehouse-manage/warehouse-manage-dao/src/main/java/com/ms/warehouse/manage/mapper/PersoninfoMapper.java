
package com.ms.warehouse.manage.mapper;

import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.PersoninfoEntity;

import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 * 人员信息 Mapper
 * @author dwx
 * @Date 2018-07-09 18:27:44
 * @since 1.0
 */
@Repository
public interface PersoninfoMapper extends IBaseMapper<PersoninfoEntity>{
	/**
	 * 通过map条件查询对象信息
	 * @param params
	 * @return
	 */
	PersoninfoEntity queryByMapParams(Map<String, Object> params);
}
