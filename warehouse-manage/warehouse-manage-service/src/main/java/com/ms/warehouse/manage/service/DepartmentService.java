package com.ms.warehouse.manage.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ms.warehouse.common.exception.CenterException;
import com.ms.warehouse.common.service.BaseService;
import com.ms.warehouse.common.vo.BaseRespVO;
import com.ms.warehouse.common.vo.Param;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;
import com.ms.warehouse.manage.bo.DepartmentBO;
import com.ms.warehouse.manage.bo.PersoninfoBO;
import com.ms.warehouse.manage.entity.DepartmentEntity;
import com.ms.warehouse.manage.entity.PersoninfoEntity;

/**
 * 部门信息 业务处理
 * 
 * @author dwx
 * @Date 2018-07-09 18:27:43
 * @since 1.0
 */
@Service
public class DepartmentService extends BaseService {

	@Autowired
	private DepartmentBO departmentBo;
	/**
	 * 人员信息BO
	 */
	@Autowired
	private PersoninfoBO personinfoBo;

	/**
	 * 分页查询列表
	 * 
	 * @param reqVO
	 * @return
	 */
	public ListRespVO list(ListReqVO<DepartmentEntity> reqVO) throws CenterException {
		return departmentBo.queryPageAutomatic(reqVO);
	}

	/**
	 * 根据ID查询单条记录
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object queryById(@Param("id") Long id) throws CenterException {
		return departmentBo.queryById(id);
	}

	/**
	 * 新增
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object create(DepartmentEntity department) throws CenterException {
		DepartmentEntity entity = new DepartmentEntity();
		entity.setDepName(department.getDepName());
		DepartmentEntity findOne = departmentBo.queryByEntity(entity);
		if (findOne != null && findOne.getId() > 0) {
			return new BaseRespVO(1, "部门名称已存在！");
		}

		department.setCreatedDate(new java.util.Date());
		departmentBo.createForValidate(department);
		return department;
	}

	/**
	 * 修改
	 * 
	 * @param reqVO
	 * @return
	 */
	public BaseRespVO update(DepartmentEntity department) throws CenterException {
		DepartmentEntity entity = new DepartmentEntity();
		entity.setDepName(department.getDepName());
		DepartmentEntity findOne = departmentBo.queryByEntity(entity);
		if (findOne != null && findOne.getId() != department.getId()) {
			return new BaseRespVO(1, "部门名称已存在！");
		}

		if (department.getParentId() == null) {
			department.setParentId((long) 0);
		}

		if (department.getParentId() == department.getId()) {
			return new BaseRespVO(1, "不能设置自己为父级部门！");
		}

		department.setUpdatedDate(new java.util.Date());
		int updateCount = departmentBo.updateForValidate(department);
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
		//查询部门是否存在人员信息
		for (Long long1 : id) {
			DepartmentEntity departmentEntity=departmentBo.queryById(long1);
			if (departmentEntity!=null) {
				//取出部门名称-查询人员信息是否存在该部门
				Map<String, Object> params=new HashMap<>();
				params.put("department", departmentEntity.getDepName());//部门名称
				PersoninfoEntity personinfoEntity=personinfoBo.queryByMapParams(params);
				if (personinfoEntity!=null) {
					return BaseRespVO.error("部门信息存在其它模块被占用不能删除");
				}
			}
		}
		int deleteCount = departmentBo.batchDeleteById(id);
		if (deleteCount > 0) {
			return new BaseRespVO();
		} else {
			return new BaseRespVO(2, "没有要删除的记录！");
		}
	}

	/**
	 * 获取包含父部门名称的完整信息列表
	 * 
	 * @param reqMap
	 * @return
	 * @throws CenterException
	 */
	public ListRespVO findFullList(Map reqMap) throws CenterException {
		ListRespVO resp = new ListRespVO();
		String enabled = reqMap.get("enabled") + "";
		String depName = reqMap.get("depName").toString();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("enabled", enabled);
		map.put("depName", depName);

		Integer pageNum = Integer.parseInt(reqMap.get("pageNum") + "");
		Integer pageSize = Integer.parseInt(reqMap.get("pageSize") + "");
		Page<?> page = PageHelper.startPage(pageNum, pageSize, true, false);
		resp.setAaData(departmentBo.queryFullList(map));
		resp.setDataCount(page.getTotal());
		return resp;
	}
}
