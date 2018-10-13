package com.ms.warehouse;

import java.util.Map;

import com.ms.warehouse.manage.entity.PersoninfoEntity;

public interface Persion {
	PersoninfoEntity queryByMapParams(Map<String, Object> params);
}
