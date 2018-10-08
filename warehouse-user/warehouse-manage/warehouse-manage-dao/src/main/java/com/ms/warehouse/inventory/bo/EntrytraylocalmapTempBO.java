
package com.ms.warehouse.inventory.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.inventory.entity.EntrytraylocalmapTempEntity;
import com.ms.warehouse.inventory.mapper.EntrytraylocalmapTempMapper;


/**
 * 托盘货位绑定信息临时 bo
 * @author dwf
 * @Date 2018-07-27 11:25:33
 * @since 1.0
 */
@Component
public class EntrytraylocalmapTempBO extends AbstractBaseBO<EntrytraylocalmapTempEntity> {
	
	@Autowired
	private EntrytraylocalmapTempMapper entrytraylocalmapTempMapper;
	
	@Override
    protected IBaseMapper<EntrytraylocalmapTempEntity> getMapper() {
	    return entrytraylocalmapTempMapper;
    }
}
