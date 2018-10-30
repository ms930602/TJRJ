package com.ms.warehouse;

import com.alibaba.fastjson.JSONObject;
import com.ms.warehouse.common.vo.BaseRespVO;

public interface IVxService {
	
	BaseRespVO savePromoters(JSONObject reqMap);

	void payAction(String openId);
	
}
