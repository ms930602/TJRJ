
package com.ms.warehouse.manage.mapper;

import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.MaterialinfoEntity;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 物料信息 Mapper
 * @author dwx
 * @Date 2018-07-09 18:27:43
 * @since 1.0
 */
@Repository
public interface MaterialinfoMapper extends IBaseMapper<MaterialinfoEntity>{
	List<MaterialinfoEntity> queryAlllist();
	MaterialinfoEntity queryByMaterCode(String materCode);
	/**
	 * 通过物料名称和版本查询数据
	 * @param params
	 * @return
	 */
	MaterialinfoEntity queryByName(Map<String, Object> params);
}
