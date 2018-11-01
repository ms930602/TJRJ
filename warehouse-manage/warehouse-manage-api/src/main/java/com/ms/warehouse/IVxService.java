package com.ms.warehouse;

import com.alibaba.fastjson.JSONObject;
import com.ms.warehouse.manage.entity.VxLogEntity;

public interface IVxService {
	
	VxLogEntity savePromoters(JSONObject reqMap);

	void payAction(String openId);

	Long createVxLog(String aid, String fx);
	
}
