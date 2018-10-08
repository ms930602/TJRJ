
package com.ms.warehouse.manage.mapper;

import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.AreainfoEntity;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 仓库区域管理 Mapper
 * @author dwx
 * @Date 2018-07-09 18:27:43
 * @since 1.0
 */
@Repository
public interface AreainfoMapper extends IBaseMapper<AreainfoEntity>{
	List<AreainfoEntity> queryarealist();
    List<AreainfoEntity> checkareaCode(String areaCode);
    AreainfoEntity queryfloorcodebyareaid(long id);
}
