package com.ms.warehouse.manage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.warehouse.common.exception.CenterException;
import com.ms.warehouse.common.service.BaseService;
import com.ms.warehouse.common.vo.BaseRespVO;
import com.ms.warehouse.common.vo.Param;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;

import com.ms.warehouse.manage.bo.VxBuyInfoBO;
import com.ms.warehouse.manage.entity.VxBuyInfoEntity;

/**
 *  业务处理
 * @author Ms
 * @Date 2018-10-21 19:40:52
 * @since 1.0
 */@Service
public class VxBuyInfoService extends BaseService {

	@Autowired
	private VxBuyInfoBO vxBuyInfoBo;
	
	/**
	 * 分页查询列表
	 * 
	 * @param reqVO
	 * @return
	 */
	public ListRespVO list(ListReqVO<VxBuyInfoEntity> reqVO) throws CenterException {
		return vxBuyInfoBo.queryPageAutomatic(reqVO);
	}
	
	/**
	 * 根据ID查询单条记录
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object queryById(@Param("id") Long id) throws CenterException {
		return vxBuyInfoBo.queryById(id);
	}

	/**
	 * 新增
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object create(VxBuyInfoEntity vxBuyInfo) throws CenterException {
		vxBuyInfoBo.createForValidate(vxBuyInfo);
		return vxBuyInfo;
	}

	/**
	 * 修改
	 * 
	 * @param reqVO
	 * @return
	 */
	public BaseRespVO update(VxBuyInfoEntity vxBuyInfo) throws CenterException {
		int updateCount = vxBuyInfoBo.updateForValidate(vxBuyInfo);
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
		int deleteCount = vxBuyInfoBo.batchDeleteById(id);
		if (deleteCount > 0) {
			return new BaseRespVO();
		} else {
			return new BaseRespVO(2, "没有要删除的记录！");
		}
	}

}
