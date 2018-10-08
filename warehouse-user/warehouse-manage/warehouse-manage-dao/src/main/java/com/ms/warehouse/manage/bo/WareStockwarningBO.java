
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;
import com.ms.warehouse.manage.entity.WareStockwarningEntity;
import com.ms.warehouse.manage.mapper.WareStockwarningMapper;


/**
 * 库存预警 bo
 * @author wangwei
 * @Date 2018-07-27 15:19:12
 * @since 1.0
 */
@Component
public class WareStockwarningBO extends AbstractBaseBO<WareStockwarningEntity> {
	
	@Autowired
	private WareStockwarningMapper wareStockwarningMapper;
	
	@Override
    protected IBaseMapper<WareStockwarningEntity> getMapper() {
	    return wareStockwarningMapper;
    }
	/**
	 * 查询库存预警信息
	 * @param reqVO
	 * @return
	 */
	public ListRespVO queryWarningEntityList(ListReqVO<WareStockwarningEntity> reqVO){
		return wareStockwarningMapper.queryWarningEntityList(reqVO);
	}
}
