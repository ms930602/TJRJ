package com.ms.warehouse.user.api;

import java.util.Map;

import com.ms.warehouse.common.entity.PersoninfoEntity;

public interface Persion {
	PersoninfoEntity queryByMapParams(Map<String, Object> params);
}
