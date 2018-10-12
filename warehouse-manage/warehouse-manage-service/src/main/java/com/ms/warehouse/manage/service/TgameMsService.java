package com.ms.warehouse.manage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.warehouse.common.exception.CenterException;
import com.ms.warehouse.common.service.BaseService;
import com.ms.warehouse.common.vo.BaseRespVO;
import com.ms.warehouse.common.vo.Param;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;

import com.ms.warehouse.manage.bo.TgameMsBO;
import com.ms.warehouse.manage.entity.TgameMsEntity;

/**
 *  业务处理
 * @author Ms
 * @Date 2018-10-12 15:19:02
 * @since 1.0
 */@Service
public class TgameMsService extends BaseService {

	@Autowired
	private TgameMsBO tgameMsBo;

	/**
	 * 分页查询列表
	 * 
	 * @param reqVO
	 * @return
	 */
	public ListRespVO list(ListReqVO<TgameMsEntity> reqVO) throws CenterException {
		return tgameMsBo.queryPageAutomatic(reqVO);
	}
	
	/**
	 * 根据ID查询单条记录
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object queryById(@Param("id") Long id) throws CenterException {
		return tgameMsBo.queryById(id);
	}

	/**
	 * 新增
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object create(TgameMsEntity tgameMs) throws CenterException {
		tgameMsBo.createForValidate(tgameMs);
		return tgameMs;
	}

	/**
	 * 修改
	 * 
	 * @param reqVO
	 * @return
	 */
	public BaseRespVO update(TgameMsEntity tgameMs) throws CenterException {
		int updateCount = tgameMsBo.updateForValidate(tgameMs);
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
		int deleteCount = tgameMsBo.batchDeleteById(id);
		if (deleteCount > 0) {
			return new BaseRespVO();
		} else {
			return new BaseRespVO(2, "没有要删除的记录！");
		}
	}

}
