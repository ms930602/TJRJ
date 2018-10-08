package com.ms.warehouse.manage.service;

import java.util.HashMap;
import java.util.Map;
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
import com.ms.warehouse.manage.bo.BaseConfigBO;
import com.ms.warehouse.manage.entity.BaseConfigEntity;

import cn.hutool.core.date.DateTime;

/**
 * 配置 业务处理
 * @author wangwei
 * @Date 2018-07-31 09:58:46
 * @since 1.0
 */@Service
public class BaseConfigService extends BaseService {

	@Autowired
	private BaseConfigBO baseConfigBo;

	/**
	 * 分页查询列表
	 * 
	 * @param reqVO
	 * @return
	 */
	public ListRespVO list(ListReqVO<BaseConfigEntity> reqVO) throws CenterException {
		return baseConfigBo.queryPageAutomatic(reqVO);
	}
	
	/**
	 * 根据ID查询单条记录
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object queryById(@Param("id") Long id) throws CenterException {
		return baseConfigBo.queryById(id);
	}

	/**
	 * 新增
	 * 
	 * @param reqVO
	 * @return
	 * @throws CenterException 
	 */
	public Object create(BaseConfigEntity baseConfig) throws CenterException  {
		baseConfig.setCreatedDate(DateTime.now());
		//判断是否唯一 终端类型+属性名  唯一
		Map<String, Object> params=new HashMap<>();
		params.put("terminalType", baseConfig.getTerminalType());
		params.put("key", baseConfig.getKey());
		BaseConfigEntity entity=baseConfigBo.queryByTerminalTypeAndkey(params);
		if (entity !=null) {
			return BaseRespVO.error("设备类型对应的属性名已经存在");
		}
		Set<ConstraintViolation<BaseConfigEntity>>  set=Validation.buildDefaultValidatorFactory().getValidator().validate(baseConfig);
		if (set !=null && set.size()>0) {
			for (ConstraintViolation<BaseConfigEntity> constraintViolation : set) {
				return BaseRespVO.error(constraintViolation.getMessageTemplate());
			}
		}
		baseConfigBo.createForValidate(baseConfig);
		return baseConfig;
	}

	/**
	 * 修改
	 * 
	 * @param reqVO
	 * @return
	 */
	public BaseRespVO update(BaseConfigEntity baseConfig) throws CenterException {
		Set<ConstraintViolation<BaseConfigEntity>>  set=Validation.buildDefaultValidatorFactory().getValidator().validate(baseConfig);
		if (set !=null && set.size()>0) {
			for (ConstraintViolation<BaseConfigEntity> constraintViolation : set) {
				return BaseRespVO.error(constraintViolation.getMessageTemplate());
			}
		}
		baseConfig.setUpdatedDate(DateTime.now());
		int updateCount = baseConfigBo.updateForValidate(baseConfig);
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
		for (Long long1 : id) {
			BaseConfigEntity entity=baseConfigBo.queryById(long1);
			if (entity.getIsRelease()==1) {
				return BaseRespVO.error("已发布，不可删除");
			}
		}
		int deleteCount = baseConfigBo.batchDeleteById(id);
		if (deleteCount > 0) {
			return new BaseRespVO();
		} else {
			return new BaseRespVO(2, "没有要删除的记录！");
		}
	}

}
