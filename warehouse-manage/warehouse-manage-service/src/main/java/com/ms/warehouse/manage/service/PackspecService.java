package com.ms.warehouse.manage.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.warehouse.common.exception.CenterException;
import com.ms.warehouse.common.service.BaseService;
import com.ms.warehouse.common.vo.BaseRespVO;
import com.ms.warehouse.common.vo.Param;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;
import com.ms.warehouse.manage.bo.PackspecBO;
import com.ms.warehouse.manage.entity.PackspecEntity;

/**
 * 包装规格 业务处理
 * @author dwx
 * @Date 2018-07-09 18:27:44
 * @since 1.0
 */@Service
public class PackspecService extends BaseService {

	@Autowired
	private PackspecBO packspecBo;

	/**
	 * 分页查询列表
	 * 
	 * @param reqVO
	 * @return
	 */
	public ListRespVO list(ListReqVO<PackspecEntity> reqVO) throws CenterException {
		return packspecBo.queryPageAutomatic(reqVO);
	}
	
	/**
	 * 根据ID查询单条记录
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object queryById(@Param("id") Long id) throws CenterException {
		return packspecBo.queryById(id);
	}

	/**
	 * 新增
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object create(PackspecEntity packspec) throws CenterException {
		packspec.setCreatedDate(new Date());
		packspecBo.createForValidate(packspec);
		return packspec;
	}

	/**
	 * 修改
	 * 
	 * @param reqVO
	 * @return
	 */
	public BaseRespVO update(PackspecEntity packspec) throws CenterException {
		packspec.setUpdatedDate(new Date());
		int updateCount = packspecBo.updateForValidate(packspec);
		if(updateCount > 0){
			return new BaseRespVO();
		}else{
			return new BaseRespVO(2,"没有要修改的记录！");
		}
		
	}

	/**
	 * 判断主数据ID重复
	 * @param areaCode
	 * @return
	 * @throws CenterException
     */
	public List<PackspecEntity> checkPackspecDataId(@Param("dataId") String dataId) throws CenterException {
		return packspecBo.checkPackspecDataId(dataId);
	}
	
	/**
	 * 判断代码重复
	 * @param areaCode
	 * @return
	 * @throws CenterException
     */
	public List<PackspecEntity> checkPackspecPacsCode(@Param("pacsCode") String pacsCode) throws CenterException {
		return packspecBo.checkPackspecPacsCode(pacsCode);
	}
	
	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	public BaseRespVO delete(@Param("id") Long[] id) throws CenterException {
		int deleteCount = packspecBo.batchDeleteById(id);
		if (deleteCount > 0) {
			return new BaseRespVO();
		} else {
			return new BaseRespVO(2, "没有要删除的记录！");
		}
	}

}
