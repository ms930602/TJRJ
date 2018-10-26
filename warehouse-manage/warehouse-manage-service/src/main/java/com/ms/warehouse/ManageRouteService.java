package com.ms.warehouse;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ms.warehouse.IManageRouteService;
import com.ms.warehouse.common.service.RouteService;
import com.ms.warehouse.manage.bo.VxPromotersBO;
import com.ms.warehouse.manage.entity.VxPromotersEntity;

@Service("manageRouteService")
public class ManageRouteService extends RouteService implements IManageRouteService {
	
	@Autowired
	private VxPromotersBO promotersBO;
	
	@Override
	public void savePromoters(JSONObject reqMap) {
		VxPromotersEntity entity = new VxPromotersEntity();
		entity.setOpenId(reqMap.get("openid") + "");
		entity.setNickname(reqMap.get("nickname") + "");
		entity.setSex(reqMap.get("sex") + "");
		entity.setProvince(reqMap.get("province") + "");
		entity.setCity(reqMap.get("city") + "");
		entity.setCountry(reqMap.get("country") + "");
		entity.setHeadimgurl(reqMap.get("headimgurl") + "");
		entity.setUnionid(reqMap.get("unionid") + "");
		
		Object object = reqMap.get("activitiId");
		if(object != null){
			try {
				entity.setActivites(Long.parseLong(object+""));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		entity.setCreatetime(new Date());
		
		promotersBO.create(entity);
	}

}
