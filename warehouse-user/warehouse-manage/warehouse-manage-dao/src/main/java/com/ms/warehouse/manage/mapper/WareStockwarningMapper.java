
package com.ms.warehouse.manage.mapper;

import org.springframework.stereotype.Repository;

import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;
import com.ms.warehouse.manage.entity.WareStockwarningEntity;

/**
 * 库存预警 Mapper
 * @author wangwei
 * @Date 2018-07-27 15:19:12
 * @since 1.0
 */
@Repository
public interface WareStockwarningMapper extends IBaseMapper<WareStockwarningEntity>{
	/**
	 * 查询库存预警信息
	 * @param reqVO
	 * @return
	 */
	ListRespVO queryWarningEntityList(ListReqVO<WareStockwarningEntity> reqVO);
}
