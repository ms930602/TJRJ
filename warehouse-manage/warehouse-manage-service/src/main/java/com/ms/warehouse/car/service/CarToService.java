package com.ms.warehouse.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.warehouse.car.bo.CarInfoBO;
import com.ms.warehouse.car.entity.CarInfoEntity;
import com.ms.warehouse.common.service.BaseService;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;

/**
 *  二手车向外接口业务处理
 * @author Ms
 * @Date 2018-11-02 14:43:19
 * @since 1.0
 */@Service
public class CarToService extends BaseService{
	 
	 @Autowired
	 private CarInfoBO carInfoBo;
	 
	 /**
	  * 通过条件查询车辆信息
	  * @return
	  */
	 public ListRespVO queryInfo(ListReqVO<CarInfoEntity> reqVO){
		 return carInfoBo.queryPageAutomatic(reqVO);
	 }
	 
}
