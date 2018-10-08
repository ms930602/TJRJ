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
import com.ms.warehouse.manage.bo.SubversionBO;
import com.ms.warehouse.manage.entity.PackspecEntity;
import com.ms.warehouse.manage.entity.SubversionEntity;

/**
 * 子版本管理 业务处理
 * @author Ms
 * @Date 2018-08-24 15:46:09
 * @since 1.0
 */@Service
public class SubversionService extends BaseService {

	@Autowired
	private SubversionBO subversionBo;

	/**
	 * 分页查询列表
	 * 
	 * @param reqVO
	 * @return
	 */
	public ListRespVO list(ListReqVO<SubversionEntity> reqVO) throws CenterException {
		return subversionBo.queryPageAutomatic(reqVO);
	}
	
	/**
	 * 根据ID查询单条记录
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object queryById(@Param("id") Long id) throws CenterException {
		return subversionBo.queryById(id);
	}

	/**
	 * 新增
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object create(SubversionEntity subversion) throws CenterException {
		int size = 8;
		subversion.setCreatedDate(new Date());
		subversionBo.createForValidate(subversion);
		Long id = subversion.getId();
		StringBuilder currSize = new StringBuilder(""+id);
		int i = size - currSize.length();
		for (int j = 0; j < i; j++) {
			currSize.insert(0, "0");
		}
		SubversionEntity updateData = new SubversionEntity();
		updateData.setId(id);
		updateData.setSubverCode(currSize.toString());
		subversion.setSubverCode(currSize.toString());
		subversionBo.updateForValidate(updateData);
		return subversion;
	}
	
	/**
	 * 判断主数据ID重复
	 * @param areaCode
	 * @return
	 * @throws CenterException
     */
	public List<PackspecEntity> checkSubverName(@Param("subverName") String subverName) throws CenterException {
		return subversionBo.checkSubverName(subverName);
	}
	
	/**
	 * 根据物料编码 查询此物料拥有的版本
	 * @param materCode
	 * @return
	 */
	public List<SubversionEntity> queryMaterSub(@Param("materCode") String materCode){
		return subversionBo.queryMaterSub(materCode);
	}
	
	/**
	 * 根据物料编码 查询此物料没有的版本
	 * @param materCode
	 * @return
	 */
	public List<SubversionEntity> queryListNotMater(@Param("materCode") String materCode){
		return subversionBo.queryListNotMater(materCode);
	}
	
	/**
	 * 修改
	 * 
	 * @param reqVO
	 * @return
	 */
	public BaseRespVO update(SubversionEntity subversion) throws CenterException {
		subversion.setUpdatedDate(new Date());
		int updateCount = subversionBo.updateForValidate(subversion);
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
		int deleteCount = subversionBo.batchDeleteById(id);
		if (deleteCount > 0) {
			return new BaseRespVO();
		} else {
			return new BaseRespVO(2, "没有要删除的记录！");
		}
	}

}
