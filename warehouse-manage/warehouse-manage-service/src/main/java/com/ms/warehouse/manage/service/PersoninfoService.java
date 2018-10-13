package com.ms.warehouse.manage.service;

import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.warehouse.Persion;
import com.ms.warehouse.common.exception.CenterException;
import com.ms.warehouse.common.service.BaseService;
import com.ms.warehouse.common.vo.BaseRespVO;
import com.ms.warehouse.common.vo.Param;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;
import com.ms.warehouse.manage.bo.PersoninfoBO;
import com.ms.warehouse.manage.entity.PersoninfoEntity;

/**
 * 人员信息 业务处理
 * 
 * @author dwx
 * @Date 2018-07-09 18:27:44
 * @since 1.0
 */
@Service
@com.alibaba.dubbo.config.annotation.Service(version="1.0.0")
public class PersoninfoService extends BaseService implements Persion{

	@Autowired
	private PersoninfoBO personinfoBo;

	/**
	 * 分页查询列表
	 * 
	 * @param reqVO
	 * @return
	 */
	public ListRespVO list(ListReqVO<PersoninfoEntity> reqVO) throws CenterException {
		return personinfoBo.queryPageAutomatic(reqVO);
	}

	/**
	 * 根据ID查询单条记录
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object queryById(@Param("id") Long id) throws CenterException {
		return personinfoBo.queryById(id);
	}

	/**
	 * 新增
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object create(PersoninfoEntity personinfo) throws CenterException {
		Set<ConstraintViolation<PersoninfoEntity>> set=Validation.buildDefaultValidatorFactory().getValidator().validate(personinfo);
		PersoninfoEntity entity = new PersoninfoEntity();
		entity.setLoginName(personinfo.getLoginName());
		PersoninfoEntity findOne = personinfoBo.queryByEntity(entity);
		if (findOne != null && findOne.getId() > 0) {
			findOne.setId((long) -1);
			return new BaseRespVO(1, "该登录账号已被绑定，不能重复绑定！");
		}
		//校验登陆邮箱
		if (set !=null && set.size()>0) {
			for (ConstraintViolation<PersoninfoEntity> constraintViolation : set) {
				return BaseRespVO.error(constraintViolation.getMessageTemplate());
			}
		}
		personinfo.setCreatedDate(new java.util.Date());
		personinfoBo.createForValidate(personinfo);
		return personinfo;
	}

	/**
	 * 修改
	 * 
	 * @param reqVO
	 * @return
	 */
	public BaseRespVO update(PersoninfoEntity personinfo) throws CenterException {
		Set<ConstraintViolation<PersoninfoEntity>> set=Validation.buildDefaultValidatorFactory().getValidator().validate(personinfo);
		PersoninfoEntity entity = new PersoninfoEntity();
		entity.setLoginName(personinfo.getLoginName());
		PersoninfoEntity findOne = personinfoBo.queryByEntity(entity);
		if (findOne != null && findOne.getId() != personinfo.getId()) {
			findOne.setId((long) -1);
			return new BaseRespVO(1, "该登录账号已被绑定，不能重复绑定！");
		}
		//校验登陆邮箱
		if (set !=null && set.size()>0) {
			for (ConstraintViolation<PersoninfoEntity> constraintViolation : set) {
				return BaseRespVO.error(constraintViolation.getMessageTemplate());
			}
		}
		personinfo.setUpdatedDate(new java.util.Date());
		int updateCount = personinfoBo.updateForValidate(personinfo);
		if (updateCount > 0) {
			return new BaseRespVO();
		} else {
			return new BaseRespVO(2, "没有要修改的记录！");
		}

	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	public BaseRespVO delete(@Param("id") Long[] id) throws CenterException {
		int deleteCount = personinfoBo.batchDeleteById(id);
		if (deleteCount > 0) {
			return new BaseRespVO();
		} else {
			return new BaseRespVO(2, "没有要删除的记录！");
		}
	}
	@Override
	public PersoninfoEntity queryByMapParams(Map<String, Object> params) {
		return personinfoBo.queryByMapParams(params);
	}
}
