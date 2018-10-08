
package com.ms.warehouse.inventory.mapper;

import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.inventory.entity.UnqualifiedproductEntity;

import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * 不合格品 Mapper
 * @author dwx
 * @Date 2018-07-25 10:22:21
 * @since 1.0
 */
@Repository
public interface UnqualifiedproductMapper extends IBaseMapper<UnqualifiedproductEntity>{
	List<UnqualifiedproductEntity> queryByBatchNo(String batchNo);
}
