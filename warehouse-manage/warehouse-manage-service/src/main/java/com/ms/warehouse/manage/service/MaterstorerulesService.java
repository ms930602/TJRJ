package com.ms.warehouse.manage.service;

import java.math.BigDecimal;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.warehouse.common.exception.CenterException;
import com.ms.warehouse.common.service.BaseService;
import com.ms.warehouse.common.vo.BaseRespVO;
import com.ms.warehouse.common.vo.Param;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;
import com.ms.warehouse.manage.bo.MaterstorerulesBO;
import com.ms.warehouse.manage.entity.MaterstorerulesEntity;

/**
 * 物料存放规则 业务处理
 * @author dwx
 * @Date 2018-07-09 18:27:43
 * @since 1.0
 */@Service
public class MaterstorerulesService extends BaseService {

	@Autowired
	private MaterstorerulesBO materstorerulesBo;

	/**
	 * 分页查询列表
	 * 
	 * @param reqVO
	 * @return
	 */
	public ListRespVO list(ListReqVO<MaterstorerulesEntity> reqVO) throws CenterException {
		return materstorerulesBo.queryPageAutomatic(reqVO);
	}
	
	/**
	 * 根据ID查询单条记录
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object queryById(@Param("id") Long id) throws CenterException {
		return materstorerulesBo.queryById(id);
	}

	/**
	 * 新增
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object create(MaterstorerulesEntity materstorerules) throws CenterException {
		//校验参数
		try {
			new BigDecimal(materstorerules.getMaterId());
			new BigDecimal(materstorerules.getDeadline());
		} catch (Exception e) {
			return BaseRespVO.error("物料id或存放天数只能为数字类型");
		}
		//校验是否为数字类型参数
		try {
			Set<ConstraintViolation<MaterstorerulesEntity>>  set=Validation.buildDefaultValidatorFactory().getValidator().validate(materstorerules);
			if(set.size()>0) {
				for (ConstraintViolation<MaterstorerulesEntity> constraintViolation : set) {
					return BaseRespVO.error(constraintViolation.getMessage());
				}
			}
			//判断最低最高库存是否填写正确
			if (materstorerules.getMaxStock().compareTo(materstorerules.getMinStock())==-1 || materstorerules.getMaxStock().compareTo(materstorerules.getMinStock())==0) {
				return BaseRespVO.error("库存数填写错误");
			}
			materstorerulesBo.createForValidate(materstorerules);
		} catch (Exception e) {
			return BaseRespVO.error(e.getMessage());
		}
		return materstorerules;
	}

	/**
	 * 修改
	 * 
	 * @param reqVO
	 * @return
	 */
	public BaseRespVO update(MaterstorerulesEntity materstorerules) throws CenterException {
		//校验参数
		try {
			//校验是否为数字类型参数
			new BigDecimal(materstorerules.getMaterId());
			new BigDecimal(materstorerules.getDeadline());
		} catch (Exception e) {
			return BaseRespVO.error("物料id或存放天数只能为数字类型");
		}
		try {
			Set<ConstraintViolation<MaterstorerulesEntity>>  set=Validation.buildDefaultValidatorFactory().getValidator().validate(materstorerules);
			if(set.size()>0) {
				for (ConstraintViolation<MaterstorerulesEntity> constraintViolation : set) {
					return BaseRespVO.error(constraintViolation.getMessage());
				}
			}
			//判断最低最高库存是否填写正确
			if (materstorerules.getMaxStock().compareTo(materstorerules.getMinStock())==-1 || materstorerules.getMaxStock().compareTo(materstorerules.getMinStock())==0) {
				return BaseRespVO.error("库存数填写错误");
			}
			int updateCount = materstorerulesBo.updateForValidate(materstorerules);
			if(updateCount > 0){
				return new BaseRespVO();
			}else{
				return new BaseRespVO(2,"没有要修改的记录！");
			}
		} catch (Exception e) {
			return BaseRespVO.error(e.getMessage());
		}
		
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	public BaseRespVO delete(@Param("id") Long[] id) throws CenterException {
		for (Long long1 : id) {
			MaterstorerulesEntity materstorerulesEntity=materstorerulesBo.queryById(long1);
			if (materstorerulesEntity.getIsDefault()==1) {
				return BaseRespVO.error("默认规则不可删除");
			}
		}
		int deleteCount = materstorerulesBo.batchDeleteById(id);
		if (deleteCount > 0) {
			return new BaseRespVO();
		} else {
			return new BaseRespVO(2, "没有要删除的记录！");
		}
	}
	/**
	 * 校验物料编码是否重复
	 * @param areaCode
	 * @return
	 */
	public MaterstorerulesEntity checkMaterCode(@Param("materCode") String materCode) {
		MaterstorerulesEntity entity= materstorerulesBo.checkMaterCode(materCode);
		return entity;
	}

}
