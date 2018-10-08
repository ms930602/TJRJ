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
import com.ms.warehouse.manage.bo.DiscreterestructrulesBO;
import com.ms.warehouse.manage.entity.DiscreterestructrulesEntity;

/**
 * 散盘重组规则 业务处理
 * @author dwx
 * @Date 2018-07-09 18:27:43
 * @since 1.0
 */@Service
public class DiscreterestructrulesService extends BaseService {

	@Autowired
	private DiscreterestructrulesBO discreterestructrulesBo;

	/**
	 * 分页查询列表
	 * 
	 * @param reqVO
	 * @return
	 */
	public ListRespVO list(ListReqVO<DiscreterestructrulesEntity> reqVO) throws CenterException {
		return discreterestructrulesBo.queryPageAutomatic(reqVO);
	}
	
	/**
	 * 根据ID查询单条记录
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object queryById(@Param("id") Long id) throws CenterException {
		return discreterestructrulesBo.queryById(id);
	}

	/**
	 * 新增
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object create(DiscreterestructrulesEntity discreterestructrules) throws CenterException {
		//校验参数
		Set<ConstraintViolation<DiscreterestructrulesEntity>> set= Validation.buildDefaultValidatorFactory().getValidator().validate(discreterestructrules);
		if(set.size()>0) {
			for (ConstraintViolation<DiscreterestructrulesEntity> constraintViolation : set) {
				return BaseRespVO.error(constraintViolation.getMessage());
			}
		}
		discreterestructrulesBo.createForValidate(discreterestructrules);
		return discreterestructrules;
	}

	/**
	 * 修改
	 * 
	 * @param reqVO
	 * @return
	 */
	public BaseRespVO update(DiscreterestructrulesEntity discreterestructrules) throws CenterException {
		//校验参数
		Set<ConstraintViolation<DiscreterestructrulesEntity>> set= Validation.buildDefaultValidatorFactory().getValidator().validate(discreterestructrules);
		if(set.size()>0) {
			for (ConstraintViolation<DiscreterestructrulesEntity> constraintViolation : set) {
				return BaseRespVO.error(constraintViolation.getMessage());
			}
		}
		int updateCount = discreterestructrulesBo.updateForValidate(discreterestructrules);
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
		int deleteCount = discreterestructrulesBo.batchDeleteById(id);
		if (deleteCount > 0) {
			return new BaseRespVO();
		} else {
			return new BaseRespVO(2, "没有要删除的记录！");
		}
	}

}
