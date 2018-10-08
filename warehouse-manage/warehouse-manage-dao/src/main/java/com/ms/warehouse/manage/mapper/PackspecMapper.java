
package com.ms.warehouse.manage.mapper;

import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.PackspecEntity;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 包装规格 Mapper
 * @author dwx
 * @Date 2018-07-09 18:27:44
 * @since 1.0
 */
@Repository
public interface PackspecMapper extends IBaseMapper<PackspecEntity>{
	public List<PackspecEntity> checkPackspecCode(HashMap<String, String> query);
}
