
package com.ms.warehouse.inventory.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.common.utils.SQLValid;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;
import com.ms.warehouse.inventory.entity.InventorymainEntity;
import com.ms.warehouse.inventory.entity.StockcheckdetailEntity;
import com.ms.warehouse.inventory.entity.StockcheckmainEntity;
import com.ms.warehouse.inventory.mapper.StockcheckdetailMapper;


/**
 * 盘点详情 bo
 * @author dwx
 * @Date 2018-07-25 10:22:20
 * @since 1.0
 */
@Component
public class StockcheckdetailBO extends AbstractBaseBO<StockcheckdetailEntity> {
	
	@Autowired
	private StockcheckdetailMapper stockcheckdetailMapper;
	
	@Override
    protected IBaseMapper<StockcheckdetailEntity> getMapper() {
	    return stockcheckdetailMapper;
    }
	
	public List<StockcheckdetailEntity> queryByBatchNo(String batchNo) {
	    return stockcheckdetailMapper.queryByBatchNo(batchNo);
    }

	public void deleteByMainId(Long id) {
		stockcheckdetailMapper.deleteByMainId(id);
	}
	
	public List<StockcheckdetailEntity> queryBymainId(Long mainId){
	    return stockcheckdetailMapper.queryBymainId(mainId);
    }
	
	public ListRespVO queryPhoneByPage(ListReqVO<StockcheckdetailEntity> reqVO){
		if (reqVO != null && reqVO.getOrderField() != null && !SQLValid.isValid(reqVO.getOrderField())) {
			reqVO.setOrderField(null);
		}

		Page<StockcheckdetailEntity> page = null;

		if (reqVO != null && 0 != reqVO.getPageNum()) {
			page = PageHelper.startPage(reqVO.getPageNum(), reqVO.getPageSize(), true);
		} else {
			page = PageHelper.startPage(1, 1000, true);
		}

		ListRespVO resp = new ListRespVO();
		resp.setAaData(stockcheckdetailMapper.queryPhoneByPage(reqVO));
		resp.setDataCount(stockcheckdetailMapper.queryPhoneCount(reqVO));
		return resp;
	}
}
