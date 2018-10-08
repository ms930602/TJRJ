
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.DiscreterestructrulesEntity;
import com.ms.warehouse.manage.mapper.DiscreterestructrulesMapper;


/**
 * 散盘重组规则 bo
 * @author dwx
 * @Date 2018-07-09 18:27:43
 * @since 1.0
 */
@Component
public class DiscreterestructrulesBO extends AbstractBaseBO<DiscreterestructrulesEntity> {
	
	@Autowired
	private DiscreterestructrulesMapper discreterestructrulesMapper;
	
	@Override
    protected IBaseMapper<DiscreterestructrulesEntity> getMapper() {
	    return discreterestructrulesMapper;
    }
}
