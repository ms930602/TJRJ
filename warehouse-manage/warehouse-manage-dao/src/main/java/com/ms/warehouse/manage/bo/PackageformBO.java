
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.PackageformEntity;
import com.ms.warehouse.manage.mapper.PackageformMapper;


/**
 * 包装形式 bo
 * @author dwx
 * @Date 2018-07-09 18:27:44
 * @since 1.0
 */
@Component
public class PackageformBO extends AbstractBaseBO<PackageformEntity> {
	
	@Autowired
	private PackageformMapper packageformMapper;
	
	@Override
    protected IBaseMapper<PackageformEntity> getMapper() {
	    return packageformMapper;
    }
}
