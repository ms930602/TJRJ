
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.BaseUploadfilerecodeEntity;
import com.ms.warehouse.manage.mapper.BaseUploadfilerecodeMapper;


/**
 * 上传文件 bo
 * @author wangwei
 * @Date 2018-08-03 09:55:30
 * @since 1.0
 */
@Component
public class BaseUploadfilerecodeBO extends AbstractBaseBO<BaseUploadfilerecodeEntity> {
	
	@Autowired
	private BaseUploadfilerecodeMapper baseUploadfilerecodeMapper;
	
	@Override
    protected IBaseMapper<BaseUploadfilerecodeEntity> getMapper() {
	    return baseUploadfilerecodeMapper;
    }
}
