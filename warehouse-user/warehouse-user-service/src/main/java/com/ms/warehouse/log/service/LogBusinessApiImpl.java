package com.ms.warehouse.log.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.warehouse.common.api.ILogApi;
import com.ms.warehouse.common.log.LogBusinessEntity;
import com.ms.warehouse.common.service.BaseService;
import com.ms.warehouse.log.bo.LogBusinessBO;

/**
 * 系统操作日志 业务处理
 * 
 * @author lansongtao
 * @Date 2017-12-18 14:34:42
 * @since 1.0
 */
@Service
public class LogBusinessApiImpl extends BaseService implements ILogApi {

	@Autowired
	private LogBusinessBO logBusinessBo;

	@Override
	public void saveBusinessLog(LogBusinessEntity entity) {
		logBusinessBo.create(entity);
	}

}
