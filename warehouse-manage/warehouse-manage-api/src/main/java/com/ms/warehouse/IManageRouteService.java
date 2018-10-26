package com.ms.warehouse;

import com.alibaba.fastjson.JSONObject;
import com.ms.warehouse.common.api.IRouteService;

public interface IManageRouteService extends IRouteService {
	
	void savePromoters(JSONObject reqMap);
	
}
