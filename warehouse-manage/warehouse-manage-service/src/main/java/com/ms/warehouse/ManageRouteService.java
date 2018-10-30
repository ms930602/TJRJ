package com.ms.warehouse;

import org.springframework.stereotype.Service;

import com.ms.warehouse.IManageRouteService;
import com.ms.warehouse.common.service.RouteService;

@Service("manageRouteService")
public class ManageRouteService extends RouteService implements IManageRouteService {
	
}
