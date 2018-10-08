
package com.ms.warehouse.manage.mapper;

import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.PackspecEntity;
import com.ms.warehouse.manage.entity.SubversionEntity;

import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * 子版本管理 Mapper
 * @author Ms
 * @Date 2018-08-24 15:46:09
 * @since 1.0
 */
@Repository
public interface SubversionMapper extends IBaseMapper<SubversionEntity>{

	List<PackspecEntity> checkSubverName(String subverName);

	/**
	 * 根据卷烟编号 获取对应子版本
	 * @param materCode
	 * @return
     */
	List<SubversionEntity> querysubBymaterCode(String materCode);
	
	/**
	 * 根据物料编码 查询此物料拥有的版本
	 * @param materCode
	 * @return
	 */
	List<SubversionEntity> queryMaterSub(String materCode);
	
	/**
	 * 根据物料编码 查询此物料没有的版本
	 * @param materCode
	 * @return
	 */
	List<SubversionEntity> queryListNotMater(String materCode);
}
