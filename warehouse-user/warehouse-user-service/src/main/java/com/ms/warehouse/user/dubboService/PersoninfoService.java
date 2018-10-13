package com.ms.warehouse.user.dubboService;

import java.util.Map;

import com.ms.warehouse.common.entity.PersoninfoEntity;


public interface PersoninfoService {
	PersoninfoEntity queryByMapParams(Map<String, Object> params);
}
