package com.ms.warehouse.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.warehouse.common.exception.CenterException;
import com.ms.warehouse.common.service.BaseService;
import com.ms.warehouse.common.vo.BaseRespVO;
import com.ms.warehouse.common.vo.Param;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;
import com.ms.warehouse.inventory.bo.InventorydetailBO;
import com.ms.warehouse.inventory.entity.InventorydetailEntity;

/**
 * 库存明细 业务处理
 * @author dwx
 * @Date 2018-07-25 10:22:18
 * @since 1.0
 */@Service
public class InventorydetailService extends BaseService {

	@Autowired
	private InventorydetailBO inventorydetailBo;

	/**
	 * 分页查询列表
	 * 
	 * @param reqVO
	 * @return
	 */
	public ListRespVO list(ListReqVO<InventorydetailEntity> reqVO) throws CenterException {
		return inventorydetailBo.queryPageAutomatic(reqVO);
	}
	
	/**
	 * 根据ID查询单条记录
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object queryById(@Param("id") Long id) throws CenterException {
		return inventorydetailBo.queryById(id);
	}

	/**
	 * 新增
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object create(InventorydetailEntity inventorydetail) throws CenterException {
		inventorydetailBo.createForValidate(inventorydetail);
		return inventorydetail;
	}

	/**
	 * 修改
	 * 
	 * @param reqVO
	 * @return
	 */
	public BaseRespVO update(InventorydetailEntity inventorydetail) throws CenterException {
		int updateCount = inventorydetailBo.updateForValidate(inventorydetail);
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
		int deleteCount = inventorydetailBo.batchDeleteById(id);
		if (deleteCount > 0) {
			return new BaseRespVO();
		} else {
			return new BaseRespVO(2, "没有要删除的记录！");
		}
	}

}
