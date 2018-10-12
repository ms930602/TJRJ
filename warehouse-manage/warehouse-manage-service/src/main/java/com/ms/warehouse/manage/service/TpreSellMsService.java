package com.ms.warehouse.manage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.warehouse.common.exception.CenterException;
import com.ms.warehouse.common.service.BaseService;
import com.ms.warehouse.common.vo.BaseRespVO;
import com.ms.warehouse.common.vo.Param;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;

import com.ms.warehouse.manage.bo.TpreSellMsBO;
import com.ms.warehouse.manage.entity.TpreSellMsEntity;

/**
 *  业务处理
 * @author Ms
 * @Date 2018-10-12 15:19:13
 * @since 1.0
 */@Service
public class TpreSellMsService extends BaseService {

	@Autowired
	private TpreSellMsBO tpreSellMsBo;

	/**
	 * 分页查询列表
	 * 
	 * @param reqVO
	 * @return
	 */
	public ListRespVO list(ListReqVO<TpreSellMsEntity> reqVO) throws CenterException {
		return tpreSellMsBo.queryPageAutomatic(reqVO);
	}
	
	/**
	 * 根据ID查询单条记录
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object queryById(@Param("id") Long id) throws CenterException {
		return tpreSellMsBo.queryById(id);
	}

	/**
	 * 新增
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object create(TpreSellMsEntity tpreSellMs) throws CenterException {
		tpreSellMsBo.createForValidate(tpreSellMs);
		return tpreSellMs;
	}

	/**
	 * 修改
	 * 
	 * @param reqVO
	 * @return
	 */
	public BaseRespVO update(TpreSellMsEntity tpreSellMs) throws CenterException {
		int updateCount = tpreSellMsBo.updateForValidate(tpreSellMs);
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
		int deleteCount = tpreSellMsBo.batchDeleteById(id);
		if (deleteCount > 0) {
			return new BaseRespVO();
		} else {
			return new BaseRespVO(2, "没有要删除的记录！");
		}
	}

}
