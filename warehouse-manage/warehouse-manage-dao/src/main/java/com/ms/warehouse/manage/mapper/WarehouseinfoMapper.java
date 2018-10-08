
package com.ms.warehouse.manage.mapper;

import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.WarehouseinfoEntity;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 仓库信息 Mapper
 * @author dwx
 * @Date 2018-07-09 18:27:44
 * @since 1.0
 */
@Repository
public interface WarehouseinfoMapper extends IBaseMapper<WarehouseinfoEntity>{
    List<WarehouseinfoEntity> queryendproduct(String keyword);
    /**
     * 通过条件查询对象
     * @param params
     * @return
     */
    WarehouseinfoEntity queyByMapsParams(Map<String, Object> params);
    /**
     * 查询最大已生成的编码
     * @return
     */
    String queryMaxWarCode();
}
