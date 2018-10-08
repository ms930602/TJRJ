package com.ms.warehouse.manage.service;

import com.ms.warehouse.common.exception.CenterException;
import com.ms.warehouse.common.service.BaseService;
import com.ms.warehouse.common.vo.BaseRespVO;
import com.ms.warehouse.common.vo.Param;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;
import com.ms.warehouse.manage.bo.ShippingtypeBO;
import com.ms.warehouse.manage.entity.ShippingtypeEntity;
import com.ms.warehouse.manage.entity.VehicleinfoEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 运输方式 业务处理
 * @author dwf
 * @Date 2018-07-26 18:37:48
 * @since 1.0
 */@Service
public class ShippingtypeService extends BaseService {

	@Autowired
	private ShippingtypeBO shippingtypeBo;

	/**
	 * 分页查询列表
	 * 
	 * @param reqVO
	 * @return
	 */
	public ListRespVO list(ListReqVO<ShippingtypeEntity> reqVO) throws CenterException {
		return shippingtypeBo.queryPageAutomatic(reqVO);
	}
	
	/**
	 * 根据ID查询单条记录
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object queryById(@Param("id") Long id) throws CenterException {
		return shippingtypeBo.queryById(id);
	}

	/**
	 * 新增
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object create(ShippingtypeEntity shippingtype) throws CenterException {
		shippingtypeBo.createForValidate(shippingtype);
		return shippingtype;
	}

	/**
	 * 修改
	 * 
	 * @param reqVO
	 * @return
	 */
	public BaseRespVO update(ShippingtypeEntity shippingtype) throws CenterException {
		int updateCount = shippingtypeBo.updateForValidate(shippingtype);
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
		int deleteCount = shippingtypeBo.batchDeleteById(id);
		if (deleteCount > 0) {
			return new BaseRespVO();
		} else {
			return new BaseRespVO(2, "没有要删除的记录！");
		}
	}
	/**
	 * 获所有运输方式
	 * @return
	 */
	public List<ShippingtypeEntity> getAllShippingtypeEntity(){
		return shippingtypeBo.getAllShippingtypeEntity();
	}
}
