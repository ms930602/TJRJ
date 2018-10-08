package com.ms.warehouse.manage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.warehouse.common.exception.CenterException;
import com.ms.warehouse.common.service.BaseService;
import com.ms.warehouse.common.vo.BaseRespVO;
import com.ms.warehouse.common.vo.Param;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;
import com.ms.warehouse.manage.bo.MaterialinfoBO;
import com.ms.warehouse.manage.bo.TestcigaretteBO;
import com.ms.warehouse.manage.entity.MaterialinfoEntity;
import com.ms.warehouse.manage.entity.TestcigaretteEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 物料信息 业务处理
 * @author dwx
 * @Date 2018-07-09 18:27:43
 * @since 1.0
 */@Service
public class MaterialinfoService extends BaseService {

	@Autowired
	private MaterialinfoBO materialinfoBo;
	@Autowired
	private TestcigaretteBO testcigaretteBO;
	/**
	 * 分页查询列表
	 * testcigarette
	 * @param reqVO
	 * @return
	 */
	public ListRespVO list(ListReqVO<MaterialinfoEntity> reqVO) throws CenterException {
		return materialinfoBo.queryPageAutomatic(reqVO);
	}
	
	/**
	 * 根据ID查询单条记录
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object queryById(@Param("id") Long id) throws CenterException {
		return materialinfoBo.queryById(id);
	}
	
	public Object queryByName(@Param("materName") String materName,@Param("versioncode") String versioncode) {
		Map<String, Object> params =new HashMap<>();
		params.put("materName", materName);
		params.put("versioncode", versioncode);
		return materialinfoBo.queryByName(params);
	}
	
	public Object queryByMaterCode(@Param("materCode") String materCode) {
		return materialinfoBo.queryByMaterCode(materCode);
	}
	/**
	 * 新增
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object create(MaterialinfoEntity materialinfo) throws CenterException {
		materialinfoBo.createForValidate(materialinfo);
		return materialinfo;
	}

	/**
	 * 修改
	 * 
	 * @param reqVO
	 * @return
	 */
	public BaseRespVO update(MaterialinfoEntity materialinfo) throws CenterException {
		int updateCount = materialinfoBo.updateForValidate(materialinfo);
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
		int deleteCount = materialinfoBo.batchDeleteById(id);
		if (deleteCount > 0) {
			return new BaseRespVO();
		} else {
			return new BaseRespVO(2, "没有要删除的记录！");
		}
	}

	/**
	 * 获取所有物料信息
	 * @return
	 * @throws CenterException
     */
	public Object queryAlllist(@Param("cigtype") int cigtype) throws CenterException {
		if (cigtype==0){
			return materialinfoBo.queryAlllist();
		}else {
			return testcigaretteBO.queryAlllist();
		}
	}

}
