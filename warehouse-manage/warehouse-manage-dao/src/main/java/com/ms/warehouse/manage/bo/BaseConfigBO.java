
package com.ms.warehouse.manage.bo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.BaseConfigEntity;
import com.ms.warehouse.manage.mapper.BaseConfigMapper;


/**
 * 配置 bo
 * @author wangwei
 * @Date 2018-07-31 09:58:46
 * @since 1.0
 */
@Component
public class BaseConfigBO extends AbstractBaseBO<BaseConfigEntity> {
	
	@Autowired
	private BaseConfigMapper baseConfigMapper;
	
	@Override
    protected IBaseMapper<BaseConfigEntity> getMapper() {
	    return baseConfigMapper;
    }
	/**
	 * 根据终端类型+属性名查询记录
	 * @param params
	 * @return
	 */
	public BaseConfigEntity queryByTerminalTypeAndkey(Map<String, Object> params) {
		return baseConfigMapper.queryByTerminalTypeAndkey(params);
	}
}
