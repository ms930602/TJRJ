package com.ms.warehouse.manage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.warehouse.common.exception.CenterException;
import com.ms.warehouse.common.service.BaseService;
import com.ms.warehouse.common.vo.BaseRespVO;
import com.ms.warehouse.common.vo.Param;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;
import com.ms.warehouse.manage.bo.VehicleinfoBO;
import com.ms.warehouse.manage.entity.VehicleinfoEntity;

import java.util.List;

/**
 * 车辆信息 业务处理
 * @author dwf
 * @Date 2018-07-26 18:37:47
 * @since 1.0
 */@Service
public class VehicleinfoService extends BaseService {

	@Autowired
	private VehicleinfoBO vehicleinfoBo;

	/**
	 * 分页查询列表
	 * 
	 * @param reqVO
	 * @return
	 */
	public ListRespVO list(ListReqVO<VehicleinfoEntity> reqVO) throws CenterException {
		return vehicleinfoBo.queryPageAutomatic(reqVO);
	}
	
	/**
	 * 根据ID查询单条记录
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object queryById(@Param("id") Long id) throws CenterException {
		return vehicleinfoBo.queryById(id);
	}

	/**
	 * 新增
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object create(VehicleinfoEntity vehicleinfo) throws CenterException {
		vehicleinfoBo.createForValidate(vehicleinfo);
		return vehicleinfo;
	}

	/**
	 * 修改
	 * 
	 * @param reqVO
	 * @return
	 */
	public BaseRespVO update(VehicleinfoEntity vehicleinfo) throws CenterException {
		int updateCount = vehicleinfoBo.updateForValidate(vehicleinfo);
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
		int deleteCount = vehicleinfoBo.batchDeleteById(id);
		if (deleteCount > 0) {
			return new BaseRespVO();
		} else {
			return new BaseRespVO(2, "没有要删除的记录！");
		}
	}

	/**
	 * 获取车辆信息
	 * @return
     */
	public List<VehicleinfoEntity> getAllVehicleinfoEntity(){
		return vehicleinfoBo.getAllVehicleinfoEntity();
	}

}
