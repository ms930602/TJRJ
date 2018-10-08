package com.ms.warehouse.manage.service;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.ms.warehouse.common.exception.CenterException;
import com.ms.warehouse.common.service.BaseService;
import com.ms.warehouse.common.vo.BaseRespVO;
import com.ms.warehouse.common.vo.Param;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;
import com.ms.warehouse.manage.bo.NumcoderulesBO;
import com.ms.warehouse.manage.entity.NumcoderulesEntity;

/**
 * 单号编码规则 业务处理
 * @author dwx
 * @Date 2018-07-09 18:27:44
 * @since 1.0
 */
@Service
public class NumcoderulesService extends BaseService {
	@Autowired
	private NumcoderulesBO numcoderulesBo;

	/**
	 * 分页查询列表
	 * 
	 * @param reqVO
	 * @return
	 */
	public ListRespVO list(ListReqVO<NumcoderulesEntity> reqVO) throws CenterException {
		return numcoderulesBo.queryPageAutomatic(reqVO);
	}
	
	/**
	 * 根据ID查询单条记录
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object queryById(@Param("id") Long id) throws CenterException {
		return numcoderulesBo.queryById(id);
	}

	/**
	 * 新增
	 * 
	 * @param reqVO
	 * @return
	 */
	public BaseRespVO create(NumcoderulesEntity numcoderules) throws CenterException {
		//校验输入参数是否正常
		Set<ConstraintViolation<NumcoderulesEntity>> set=Validation.buildDefaultValidatorFactory().getValidator().validate(numcoderules);
		if(set.size()>0) {
			for (ConstraintViolation<NumcoderulesEntity> constraintViolation : set) {
				return BaseRespVO.error(constraintViolation.getMessage());
			}
		}
		numcoderulesBo.createForValidate(numcoderules);
		return new BaseRespVO();
	}

	/**
	 * 修改
	 *  
	 * @param reqVO
	 * @return
	 */
	public BaseRespVO update(NumcoderulesEntity numcoderules) throws CenterException {	
		//校验输入参数是否正常
		Set<ConstraintViolation<NumcoderulesEntity>> set=Validation.buildDefaultValidatorFactory().getValidator().validate(numcoderules);
		if(set.size()>0) {
			for (ConstraintViolation<NumcoderulesEntity> constraintViolation : set) {
				return BaseRespVO.error(constraintViolation.getMessage());
			}
		}
		int updateCount = numcoderulesBo.updateForValidate(numcoderules);
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
		int deleteCount = numcoderulesBo.batchDeleteById(id);
		if (deleteCount > 0) {
			return new BaseRespVO();
		} else {
			return new BaseRespVO(2, "没有要删除的记录！");
		}
	}
}
