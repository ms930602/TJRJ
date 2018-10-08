package com.ms.warehouse.manage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.warehouse.common.exception.CenterException;
import com.ms.warehouse.common.service.BaseService;
import com.ms.warehouse.common.vo.BaseRespVO;
import com.ms.warehouse.common.vo.Param;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;
import com.ms.warehouse.manage.bo.MatergroupBO;
import com.ms.warehouse.manage.entity.MatergroupEntity;

/**
 * 物料组，多个块对应一个组，一个组对应一种 业务处理
 * @author dwx
 * @Date 2018-08-13 13:27:06
 * @since 1.0
 */@Service
public class MatergroupService extends BaseService {

	@Autowired
	private MatergroupBO matergroupBo;

	/**
	 * 分页查询列表
	 * 
	 * @param reqVO
	 * @return
	 */
	public ListRespVO list(ListReqVO<MatergroupEntity> reqVO) throws CenterException {
		return matergroupBo.queryPageAutomatic(reqVO);
	}
	
	/**
	 * 根据ID查询单条记录
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object queryById(@Param("id") Long id) throws CenterException {
		return matergroupBo.queryById(id);
	}

	/**
	 * 新增
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object create(MatergroupEntity matergroup) throws CenterException {
		matergroupBo.createForValidate(matergroup);
		return matergroup;
	}

	/**
	 * 修改
	 * 
	 * @param reqVO
	 * @return
	 */
	public BaseRespVO update(MatergroupEntity matergroup) throws CenterException {
		int updateCount = matergroupBo.updateForValidate(matergroup);
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
		int deleteCount = matergroupBo.batchDeleteById(id);
		if (deleteCount > 0) {
			return new BaseRespVO();
		} else {
			return new BaseRespVO(2, "没有要删除的记录！");
		}
	}

}
