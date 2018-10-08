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
import com.ms.warehouse.inventory.bo.UnqualifiedproductBO;
import com.ms.warehouse.inventory.entity.UnqualifiedproductEntity;

/**
 * 不合格品 业务处理
 * @author dwx
 * @Date 2018-07-25 10:22:21
 * @since 1.0
 */@Service
public class UnqualifiedproductService extends BaseService {

	@Autowired
	private UnqualifiedproductBO unqualifiedproductBo;

	/**
	 * 分页查询列表
	 * 
	 * @param reqVO
	 * @return
	 */
	public ListRespVO list(ListReqVO<UnqualifiedproductEntity> reqVO) throws CenterException {
		return unqualifiedproductBo.queryPageAutomatic(reqVO);
	}
	
	/**
	 * 根据ID查询单条记录
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object queryById(@Param("id") Long id) throws CenterException {
		return unqualifiedproductBo.queryById(id);
	}

	/**
	 * 新增
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object create(UnqualifiedproductEntity unqualifiedproduct) throws CenterException {
		unqualifiedproductBo.createForValidate(unqualifiedproduct);
		return unqualifiedproduct;
	}

	/**
	 * 修改
	 * 
	 * @param reqVO
	 * @return
	 */
	public BaseRespVO update(UnqualifiedproductEntity unqualifiedproduct) throws CenterException {
		int updateCount = unqualifiedproductBo.updateForValidate(unqualifiedproduct);
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
		int deleteCount = unqualifiedproductBo.batchDeleteById(id);
		if (deleteCount > 0) {
			return new BaseRespVO();
		} else {
			return new BaseRespVO(2, "没有要删除的记录！");
		}
	}
	
	/**
	 * 根据批次号查询记录
	 * 
	 * @param batchNo
	 * @return
	 */
	public List<UnqualifiedproductEntity> queryByBatchNo(@Param("batchNo") String batchNo){
		 return unqualifiedproductBo.queryByBatchNo(batchNo);
	}

}