package com.jiuzhou.warehouse.manage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiuzhou.warehouse.common.exception.CenterException;
import com.jiuzhou.warehouse.common.service.BaseService;
import com.jiuzhou.warehouse.common.vo.BaseRespVO;
import com.jiuzhou.warehouse.common.vo.Param;
import com.jiuzhou.warehouse.common.vo.ListVo.ListReqVO;
import com.jiuzhou.warehouse.common.vo.ListVo.ListRespVO;

import com.jiuzhou.warehouse.manage.bo.MatersubvermapBO;
import com.jiuzhou.warehouse.manage.entity.MatersubvermapEntity;

/**
 * 物料和子版本关系对照 业务处理
 * @author Ms
 * @Date 2018-08-25 16:45:19
 * @since 1.0
 */@Service
public class MatersubvermapService extends BaseService {

	@Autowired
	private MatersubvermapBO matersubvermapBo;

	/**
	 * 分页查询列表
	 * 
	 * @param reqVO
	 * @return
	 */
	public ListRespVO list(ListReqVO<MatersubvermapEntity> reqVO) throws CenterException {
		return matersubvermapBo.queryPageAutomatic(reqVO);
	}
	
	/**
	 * 根据ID查询单条记录
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object queryById(@Param("id") Long id) throws CenterException {
		return matersubvermapBo.queryById(id);
	}

	/**
	 * 新增
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object create(MatersubvermapEntity matersubvermap) throws CenterException {
		matersubvermapBo.createForValidate(matersubvermap);
		return matersubvermap;
	}

	/**
	 * 修改
	 * 
	 * @param reqVO
	 * @return
	 */
	public BaseRespVO update(MatersubvermapEntity matersubvermap) throws CenterException {
		int updateCount = matersubvermapBo.updateForValidate(matersubvermap);
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
		int deleteCount = matersubvermapBo.batchDeleteById(id);
		if (deleteCount > 0) {
			return new BaseRespVO();
		} else {
			return new BaseRespVO(2, "没有要删除的记录！");
		}
	}

}
