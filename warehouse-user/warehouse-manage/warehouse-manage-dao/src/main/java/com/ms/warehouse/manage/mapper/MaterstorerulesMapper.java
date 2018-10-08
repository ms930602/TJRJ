
package com.ms.warehouse.manage.mapper;

import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.MaterstorerulesEntity;

import org.springframework.stereotype.Repository;

/**
 * 物料存放规则 Mapper
 * @author dwx
 * @Date 2018-07-09 18:27:43
 * @since 1.0
 */
@Repository
public interface MaterstorerulesMapper extends IBaseMapper<MaterstorerulesEntity>{
	MaterstorerulesEntity checkMaterCode(String code);
	/**
	 * 根据物料id查询物料存放规则
	 * @param materId
	 * @return
	 */
	MaterstorerulesEntity queryByMaterId(long materId);
	
	MaterstorerulesEntity queryDeafultRuler();
	/**
	 * 通过物料编码查询
	 * @param materId
	 * @return
	 */
	MaterstorerulesEntity queryByMaterCode(String materCode);
}
