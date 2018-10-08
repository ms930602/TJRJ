
package com.ms.warehouse.manage.mapper;

import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.PasswayEntity;

import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * 仓库通道管理 Mapper
 * @author dwx
 * @Date 2018-07-11 10:28:41
 * @since 1.0
 */ 
@Repository
public interface PasswayMapper extends IBaseMapper<PasswayEntity>{
    List<PasswayEntity> checkpassNo(String passNo);
    List<PasswayEntity> checkpassName(String passName);
    List<PasswayEntity> queryoutPassway();
}
