
package com.ms.warehouse.inventory.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.inventory.entity.BaseUploadfilerecodeEntity;

/**
 * 上传文件 Mapper
 * @author wangwei
 * @Date 2018-08-03 09:55:30
 * @since 1.0
 */
@Repository
public interface BaseUploadfilerecodeMapper extends IBaseMapper<BaseUploadfilerecodeEntity>{

	List<BaseUploadfilerecodeEntity> queryByIds(Long[] ids);
	
}
