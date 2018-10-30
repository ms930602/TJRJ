package com.ms.warehouse;

import com.alibaba.fastjson.JSONObject;
import com.ms.warehouse.common.vo.BaseRespVO;

public interface IVxService {
	
	String savePromoters(JSONObject reqMap);

	void payAction(String openId);

	Long createVxLog(String aid, String fx);
	
}
