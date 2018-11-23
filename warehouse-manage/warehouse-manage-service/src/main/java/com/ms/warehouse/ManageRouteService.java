package com.ms.warehouse;

import java.util.Base64;
import java.util.Base64.Decoder;

import org.springframework.stereotype.Service;

import com.ms.warehouse.IManageRouteService;
import com.ms.warehouse.common.service.RouteService;
import com.ms.warehouse.common.utils.FileUtils;

import cn.hutool.core.codec.Base64Decoder;

@Service("manageRouteService")
public class ManageRouteService extends RouteService implements IManageRouteService {
	
}
