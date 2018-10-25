package com.ms.warehouse.manage.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.warehouse.common.exception.CenterException;
import com.ms.warehouse.common.service.BaseService;
import com.ms.warehouse.common.vo.Param;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;
import com.ms.warehouse.manage.bo.VxPromotersBO;
import com.ms.warehouse.manage.entity.VxActivitiesFormEntity;
import com.ms.warehouse.manage.entity.VxFormEntity;
import com.ms.warehouse.manage.entity.VxPromotersEntity;
@Service
public class InfoToService  extends BaseService {
	
	@Autowired
	private VxActivitiesService activitiesService;
	
	@Autowired
	private VxPromotersBO promotersBO;
	
	public Object getVxInfo(@Param("id") Long id) throws CenterException {
		VxFormEntity vfe = null;
		VxActivitiesFormEntity formEntity = (VxActivitiesFormEntity) activitiesService.queryById(id);
		if(formEntity == null) return null;
		//活动基本信息
		vfe = new VxFormEntity(formEntity);
		
		//推广员 start
		ListReqVO<VxPromotersEntity> reqVO = new ListReqVO<VxPromotersEntity>();
		reqVO.setPageNum(1);
		reqVO.setPageSize(20);
		reqVO.setOrderField("f_ext_num");
		ListRespVO queryPageAutomatic = promotersBO.queryPageAutomatic(reqVO);
		List<VxPromotersEntity> aaData = queryPageAutomatic.getAaData();
		if(aaData != null && aaData.size() > 0){
			List<Map<String, String>> promtersList = new ArrayList<>();
			Map<String, String> info = null;
			for (VxPromotersEntity temp : aaData) {
				info = new HashMap<String, String>();
				info.put("Nickname", temp.getNickname());
				info.put("extNum", temp.getExtNum().toString());
				promtersList.add(info);
			}
			vfe.setPromtersList(promtersList);
		}
		//推广员 end
		return vfe;
	}
}
