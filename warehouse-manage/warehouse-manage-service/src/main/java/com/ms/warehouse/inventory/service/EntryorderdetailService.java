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
import com.ms.warehouse.inventory.bo.EntryorderdetailBO;
import com.ms.warehouse.inventory.entity.EntryorderdetailEntity;
import com.ms.warehouse.inventory.entity.InventorymainEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 入库单详情信息 业务处理
 * @author dwx
 * @Date 2018-07-25 10:22:18
 * @since 1.0
 */@Service
public class EntryorderdetailService extends BaseService {

	@Autowired
	private EntryorderdetailBO entryorderdetailBo;

	/**
	 * 分页查询列表
	 * 
	 * @param reqVO
	 * @return
	 */
	public ListRespVO list(ListReqVO<EntryorderdetailEntity> reqVO) throws CenterException {
		return entryorderdetailBo.queryPageAutomatic(reqVO);
	}
	
	/**
	 * 根据ID查询单条记录
	 * 
	 * @return
	 */
	public Object queryById(@Param("id") Long id) throws CenterException {
		return entryorderdetailBo.queryById(id);
	}

	/**
	 * 新增
	 *
	 * @return
	 */
	public Object create(EntryorderdetailEntity entryorderdetail) throws CenterException {
		entryorderdetailBo.createForValidate(entryorderdetail);
		return entryorderdetail;
	}

	/**
	 * 修改
	 * 
	 *
	 * @return
	 */
	public BaseRespVO update(EntryorderdetailEntity entryorderdetail) throws CenterException {
		int updateCount = entryorderdetailBo.updateForValidate(entryorderdetail);
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
		int deleteCount = entryorderdetailBo.batchDeleteById(id);
		if (deleteCount > 0) {
			return new BaseRespVO();
		} else {
			return new BaseRespVO(2, "没有要删除的记录！");
		}
	}


	/**
	 * 过程追踪分页查询
	 *
	 * @param reqVO
	 * @return
	 */
	public ListRespVO proTracklist(ListReqVO<EntryorderdetailEntity> reqVO){
		return entryorderdetailBo.queryProTrackByPage(reqVO);
	}
	
	/**
	 * 批量添加
	 * 
	 * @param entitys
	 * @return
	 */
		
	public BaseRespVO batchSave(List<EntryorderdetailEntity> entitys) throws CenterException {
		entryorderdetailBo.batchSave(entitys);
		return new BaseRespVO();
	}
}
