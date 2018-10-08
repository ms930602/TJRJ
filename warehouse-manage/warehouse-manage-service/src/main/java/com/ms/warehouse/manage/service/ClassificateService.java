package com.ms.warehouse.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.warehouse.common.exception.CenterException;
import com.ms.warehouse.common.service.BaseService;
import com.ms.warehouse.common.vo.BaseRespVO;
import com.ms.warehouse.common.vo.Param;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;
import com.ms.warehouse.manage.bo.ClassificateBO;
import com.ms.warehouse.manage.entity.ClassificateEntity;
import com.ms.warehouse.manage.entity.MerchantEntity;

/**
 * 数据分类 业务处理
 * @author dwx
 * @Date 2018-07-09 18:27:45
 * @since 1.0
 */@Service
public class ClassificateService extends BaseService {

	@Autowired
	private ClassificateBO classificateBo;

	/**
	 * 分页查询列表
	 * 
	 * @param reqVO
	 * @return
	 */
	public ListRespVO list(ListReqVO<ClassificateEntity> reqVO) throws CenterException {
		return classificateBo.queryPageAutomatic(reqVO);
	}
	
	/**
	 * 根据ID查询单条记录
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object queryById(@Param("id") Long id) throws CenterException {
		return classificateBo.queryById(id);
	}

	/**
	 * 新增
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object create(ClassificateEntity classificate) throws CenterException {
		ClassificateEntity entity = new ClassificateEntity();
		entity.setClaCode(classificate.getClaCode());
		ClassificateEntity findOne = classificateBo.queryByEntity(entity);
		if(findOne!=null&&findOne.getId()>0) {
			findOne.setId((long)-1);
			return new BaseRespVO(1, "分类编码重复"); 
		}
		
		classificate.setCreatedDate(new java.util.Date());
		classificateBo.createForValidate(classificate);
		return classificate;
	}

	/**
	 * 修改
	 * 
	 * @param reqVO
	 * @return
	 */
	public BaseRespVO update(ClassificateEntity classificate) throws CenterException {
		classificate.setUpdatedDate(new java.util.Date());
		int updateCount = classificateBo.updateForValidate(classificate);
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
		int deleteCount = classificateBo.batchDeleteById(id);
		if (deleteCount > 0) {
			return new BaseRespVO();
		} else {
			return new BaseRespVO(2, "没有要删除的记录！");
		}
	}
	
	/**
	 * 获取客户
	 * @param keyword
     * @return
     */
	public List<ClassificateEntity> queryClassificate(@Param("keyword") String keyword){
		return classificateBo.queryClassificate(keyword);
	}

}
