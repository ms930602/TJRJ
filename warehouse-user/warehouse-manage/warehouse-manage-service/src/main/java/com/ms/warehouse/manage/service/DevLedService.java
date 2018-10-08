package com.ms.warehouse.manage.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import com.ms.warehouse.common.exception.CenterException;
import com.ms.warehouse.common.service.BaseService;
import com.ms.warehouse.common.vo.BaseRespVO;
import com.ms.warehouse.common.vo.Param;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;
import com.ms.warehouse.manage.bo.DevLedBO;
import com.ms.warehouse.manage.entity.DevLedEntity;

/**
 * LED显示器设备 业务处理
 * @author wangwei
 * @Date 2018-07-13 10:56:45
 * @since 1.0
 */@Service
public class DevLedService extends BaseService {

	@Autowired
	private DevLedBO devLedBo;

	/**
	 * 分页查询列表
	 * 
	 * @param reqVO
	 * @return
	 */
	public ListRespVO list(ListReqVO<DevLedEntity> reqVO) throws CenterException {
		return devLedBo.queryPageAutomatic(reqVO);
	}
	
	/**
	 * 根据ID查询单条记录
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object queryById(@Param("id") Long id) throws CenterException {
		return devLedBo.queryById(id);
	}

	/**
	 * 新增
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object create(DevLedEntity devLed) throws CenterException {
		Set<ConstraintViolation<DevLedEntity>> set= Validation.buildDefaultValidatorFactory().getValidator().validate(devLed);
		if(set.size()>0) {
			for (ConstraintViolation<DevLedEntity> constraintViolation : set) {
				return BaseRespVO.error(constraintViolation.getMessage());
			}
		}
		//判断日期是否正确格式
		SimpleDateFormat sFormat=new SimpleDateFormat("yyyy-MM-dd");
		try {
			sFormat.format(devLed.getProductDate());
		} catch (Exception e) {
			return BaseRespVO.error("日期格式错误");
		}
		try {
			devLedBo.createForValidate(devLed);
			return new BaseRespVO();
		} catch (Exception e) {
			return BaseRespVO.error(e.getMessage());
		}

	}

	/**
	 * 修改
	 * 
	 * @param reqVO
	 * @return
	 */
	public BaseRespVO update(DevLedEntity devLed) throws CenterException {
		Set<ConstraintViolation<DevLedEntity>> set= Validation.buildDefaultValidatorFactory().getValidator().validate(devLed);
		if(set.size()>0) {
			for (ConstraintViolation<DevLedEntity> constraintViolation : set) {
				return BaseRespVO.error(constraintViolation.getMessageTemplate());
			}
		}
		//判断日期是否正确格式
		SimpleDateFormat sFormat=new SimpleDateFormat("yyyy-MM-dd");
		try {
			//格式化日期，检查日期是否正确
			sFormat.format(devLed.getProductDate());
		} catch (Exception e) {
			return BaseRespVO.error("日期格式错误");
		}
		try {
			
			int updateCount = devLedBo.updateForValidate(devLed);
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
		int deleteCount = devLedBo.batchDeleteById(id);
		if (deleteCount > 0) {
			return new BaseRespVO();
		} else {
			return new BaseRespVO(2, "没有要删除的记录！");
		}
	}

}
