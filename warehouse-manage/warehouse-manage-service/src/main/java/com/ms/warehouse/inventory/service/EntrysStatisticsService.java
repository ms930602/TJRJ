package com.ms.warehouse.inventory.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.warehouse.common.exception.CenterException;
import com.ms.warehouse.common.service.BaseService;
import com.ms.warehouse.common.vo.Param;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;
import com.ms.warehouse.inventory.bo.CigaretteEntryBo;
import com.ms.warehouse.inventory.entity.EntryorderdetailEntity;
/**
 * 入库统计业务处理
 * @author hxh
 * @Date 2018-08-29 16:22:18
 * @since 1.0
 */@Service
public class EntrysStatisticsService extends BaseService{
	 		 
		@Autowired
		private CigaretteEntryBo cigaretteEntryBo;
								
		public ListRespVO queryEntryCounts(@Param("statisticaltime") String day) throws CenterException {
    			
			List<HashMap<String, Object>> list =  cigaretteEntryBo.queryEntryCounts(day);					
			ListRespVO listRespVO = new ListRespVO();
			listRespVO.setAaData(list);
			return listRespVO;
		}
		
		public ListRespVO list(ListReqVO<EntryorderdetailEntity> reqVO) throws CenterException {
			return cigaretteEntryBo.queryEntrysStatistics(reqVO);
		}
						
}

 
 
 
 