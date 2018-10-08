
package com.ms.warehouse.manage.mapper;

import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.ShippingtypeEntity;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 运输方式 Mapper
 * @author dwf
 * @Date 2018-07-26 18:37:48
 * @since 1.0
 */
@Repository
public interface ShippingtypeMapper extends IBaseMapper<ShippingtypeEntity>{
    List<ShippingtypeEntity> getAllShippingtypeEntity();
}
