package com.ms.warehouse.manage.service;

import java.util.HashMap;
import java.util.List;
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
import com.ms.warehouse.manage.bo.WarehouseinfoBO;
import com.ms.warehouse.manage.entity.WarehouseinfoEntity;

/**
 * 仓库信息 业务处理
 * @author dwx
 * @Date 2018-07-09 18:27:44
 * @since 1.0
 */@Service
public class WarehouseinfoService extends BaseService {

	@Autowired
	private WarehouseinfoBO warehouseinfoBo;

	/**
	 * 分页查询列表
	 * 
	 * @param reqVO
	 * @return
	 */
	public ListRespVO list(ListReqVO<WarehouseinfoEntity> reqVO) throws CenterException {
		return warehouseinfoBo.queryPageAutomatic(reqVO);
	}
	
	/**
	 * 根据ID查询单条记录
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object queryById(@Param("id") Long id) throws CenterException {
		return warehouseinfoBo.queryById(id);
	}

	/**
	 * 新增
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object create(WarehouseinfoEntity warehouseinfo) throws CenterException {
		Set<ConstraintViolation<WarehouseinfoEntity>> set=Validation.buildDefaultValidatorFactory().getValidator().validate(warehouseinfo);
		//校验参数
		if (set !=null && set.size()>0) {
			for (ConstraintViolation<WarehouseinfoEntity> constraintViolation : set) {
				//返回随机参数错误
				return BaseRespVO.error(constraintViolation.getMessageTemplate());
			}
		}
		//自动生成仓库编码   ：C+9位补齐数字
		Map<String, Object> params=new HashMap<>();//查询条件map
		params.put("warCode", "C000000001");//初始化查询条件
		WarehouseinfoEntity entity=warehouseinfoBo.queyByMapsParams(params);
		if (entity==null) {
			//若不存在，表示第一次手动添加
			warehouseinfo.setWarCode("C000000001");//设置初始化编码
		}else {
			//自动生成编码,查询已生成最大编码
			String maxWarCode=warehouseinfoBo.queryMaxWarCode();
			//对最大code进行自增1
			int number=(Integer.parseInt(maxWarCode.substring(1)))+1;
			String newCode="C"+String.format("%09d", number);//新code
			warehouseinfo.setWarCode(newCode);
		}
		
		warehouseinfoBo.createForValidate(warehouseinfo);
		return warehouseinfo;
	}

	/**
	 * 修改
	 * 
	 * @param reqVO
	 * @return
	 */
	public BaseRespVO update(WarehouseinfoEntity warehouseinfo) throws CenterException {
		Set<ConstraintViolation<WarehouseinfoEntity>> set=Validation.buildDefaultValidatorFactory().getValidator().validate(warehouseinfo);
		//校验参数
		if (set !=null && set.size()>0) {
			for (ConstraintViolation<WarehouseinfoEntity> constraintViolation : set) {
				//返回随机参数错误
				return BaseRespVO.error(constraintViolation.getMessageTemplate());
			}
		}
		int updateCount = warehouseinfoBo.updateForValidate(warehouseinfo);
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
			WarehouseinfoEntity entity=warehouseinfoBo.queryById(long1);
			if (entity.getStatus().equals("2")) {
				return BaseRespVO.error("已发布仓库，不能删除");
			}
		}
		int deleteCount = warehouseinfoBo.batchDeleteById(id);
		if (deleteCount > 0) {
			return new BaseRespVO();
		} else {
			return new BaseRespVO(2, "没有要删除的记录！");
		}
	}
	/**
	 *  获取成品仓库
	 * @return
	 * @throws CenterException
	 */
	public List<WarehouseinfoEntity> queryendproduct(@Param("keyword") String keyword) throws CenterException {
		return  warehouseinfoBo.queryendproduct(keyword);
	}
}
