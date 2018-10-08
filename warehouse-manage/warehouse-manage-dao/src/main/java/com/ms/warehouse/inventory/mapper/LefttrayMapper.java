
package com.ms.warehouse.inventory.mapper;

import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.inventory.entity.LefttrayEntity;

import org.springframework.stereotype.Repository;

/**
 * 尾盘 Mapper
 * @author dwx
 * @Date 2018-07-25 11:29:59
 * @since 1.0
 */
@Repository
public interface LefttrayMapper extends IBaseMapper<LefttrayEntity>{
    /**
     * 根据物料编号 获取暂存区域对象信息
     * @param materCode
     * @return
     */
    LefttrayEntity querybymatercode(String materCode,Long subverId);
	LefttrayEntity queryLefttrayBymatercode(String materCode);
}
