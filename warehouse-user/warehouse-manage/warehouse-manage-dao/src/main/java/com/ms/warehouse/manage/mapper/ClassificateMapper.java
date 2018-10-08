
package com.ms.warehouse.manage.mapper;

import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.ClassificateEntity;
import com.ms.warehouse.manage.entity.MerchantEntity;

import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * 数据分类 Mapper
 * @author dwx
 * @Date 2018-07-09 18:27:45
 * @since 1.0
 */
@Repository
public interface ClassificateMapper extends IBaseMapper<ClassificateEntity>{
	
	List<ClassificateEntity> queryClassificate(String keyword);
}
