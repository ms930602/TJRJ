package com.ms.warehouse.car.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.warehouse.car.bo.CarBrandBO;
import com.ms.warehouse.car.bo.CarInfoBO;
import com.ms.warehouse.car.entity.CarBrandEntity;
import com.ms.warehouse.car.entity.CarInfoEntity;
import com.ms.warehouse.car.entity.CarUserEntity;
import com.ms.warehouse.car.entity.ConsultationEntity;
import com.ms.warehouse.car.entity.EstimateEntity;
import com.ms.warehouse.common.exception.CenterException;
import com.ms.warehouse.common.service.BaseService;
import com.ms.warehouse.common.vo.Param;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;

/**
 *  二手车向外接口业务处理
 * @author Ms
 * @Date 2018-11-02 14:43:19
 * @since 1.0
 */@Service
public class CarToService extends BaseService{
	 
	 @Autowired
	 private CarInfoBO carInfoBo;
	 
	 @Autowired
	 private CarBrandBO carBrandBo;
	 
	 @Autowired
	 private CarInfoService carInfoService;
	 
	 @Autowired
	 private ConsultationService consultationService;
	 @Autowired
	 private CarUserService carUserService;
	 
	 @Autowired
	 private EstimateService estimateService;
	 
	 /**
	  * 通过条件查询车辆信息
	  * @return
	  */
	 public ListRespVO queryInfo(ListReqVO<CarInfoEntity> reqVO){
		 return carInfoBo.queryPageAutomatic(reqVO);
	 }
	 
	 public Object queryById(@Param("id") Long id)throws CenterException{
		 return carInfoService.queryById(id);
	 }
	 
	 public Object saveConsu(ConsultationEntity consultation) throws CenterException{
		 return consultationService.create(consultation);
	 }
	 
	 public Object saveCarUser(CarUserEntity user) throws CenterException{
		 return carUserService.create(user);
	 }
	 
	 public Object saveEstimate(EstimateEntity user) throws CenterException{
		 return estimateService.create(user);
	 }
	 
	 /**
	  * 获取品牌  
	  * @param
	  * @return
	  */
	 public ListRespVO queryBrand(ListReqVO<CarBrandEntity> reqVO){
		 return carBrandBo.queryPageAutomatic(reqVO);
	 }
	 
	 public List<String> queryBrandType(@Param("type") String type){
		 return carInfoBo.queryBrandType(type);
	 }
}
