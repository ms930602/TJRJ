package com.ms.warehouse.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.warehouse.common.exception.CenterException;
import com.ms.warehouse.common.service.BaseService;
import com.ms.warehouse.common.vo.BaseRespVO;
import com.ms.warehouse.common.vo.Param;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;
import com.ms.warehouse.inventory.bo.StockcheckdetailBO;
import com.ms.warehouse.inventory.entity.OuttraylocalmapEntity;
import com.ms.warehouse.inventory.entity.StockcheckdetailEntity;

/**
 * 盘点详情 业务处理
 * @author dwx
 * @Date 2018-07-25 10:22:20
 * @since 1.0
 */@Service
public class StockcheckdetailService extends BaseService {

	@Autowired
	private StockcheckdetailBO stockcheckdetailBo;

	/**
	 * 分页查询列表
	 * 
	 * @param reqVO
	 * @return
	 */
	public ListRespVO list(ListReqVO<StockcheckdetailEntity> reqVO) throws CenterException {
		return stockcheckdetailBo.queryPageAutomatic(reqVO);
	}
	
	/**
	 * 根据ID查询单条记录
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object queryById(@Param("id") Long id) throws CenterException {
		return stockcheckdetailBo.queryById(id);
	}

	/**
	 * 新增
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object create(StockcheckdetailEntity stockcheckdetail) throws CenterException {
		stockcheckdetailBo.createForValidate(stockcheckdetail);
		return stockcheckdetail;
	}

	/**
	 * 修改
	 * 
	 * @param reqVO
	 * @return
	 */
	public BaseRespVO update(StockcheckdetailEntity stockcheckdetail) throws CenterException {
		int updateCount = stockcheckdetailBo.updateForValidate(stockcheckdetail);
		if(updateCount > 0){
			return new BaseRespVO();
		}else{
			return new BaseRespVO(2,"没有要修改的记录！");
		}
		
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	public BaseRespVO delete(@Param("id") Long[] id) throws CenterException {
		int deleteCount = stockcheckdetailBo.batchDeleteById(id);
		if (deleteCount > 0) {
			return new BaseRespVO();
		} else {
			return new BaseRespVO(2, "没有要删除的记录！");
		}
	}
	
	/*
	 * 通过批次号查询记录
	 */
	public List<StockcheckdetailEntity> queryByBatchNo(@Param("batchNo") String batchNo) {
	    return stockcheckdetailBo.queryByBatchNo(batchNo);
    }

}
