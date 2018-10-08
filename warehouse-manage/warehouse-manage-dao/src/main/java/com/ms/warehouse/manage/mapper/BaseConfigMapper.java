
package com.ms.warehouse.manage.mapper;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.BaseConfigEntity;

/**
 * 配置 Mapper
 * @author wangwei
 * @Date 2018-07-31 09:58:46
 * @since 1.0
 */
@Repository
public interface BaseConfigMapper extends IBaseMapper<BaseConfigEntity>{
	BaseConfigEntity queryByTerminalTypeAndkey(Map<String, Object> params);
}
