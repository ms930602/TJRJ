package com.ms.warehouse.inventory.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.warehouse.common.exception.CenterException;
import com.ms.warehouse.common.service.BaseService;
import com.ms.warehouse.common.vo.BaseRespVO;
import com.ms.warehouse.common.vo.Param;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;
import com.ms.warehouse.inventory.bo.EntrytraylocalmapBO;
import com.ms.warehouse.inventory.entity.EntrytraylocalmapEntity;
import com.ms.warehouse.manage.bo.LocationinfoBO;
import com.ms.warehouse.manage.entity.LocationinfoEntity;

/**
 * 托盘货位绑定信息 业务处理
 * @author dwx
 * @Date 2018-07-25 10:22:18
 * @since 1.0
 */@Service
public class EntrytraylocalmapService extends BaseService {

	@Autowired
	private EntrytraylocalmapBO entrytraylocalmapBo;

	
	@Autowired
	private LocationinfoBO locationinfoBo;
	/**
	 * 分页查询列表
	 * 
	 * @param reqVO
	 * @return
	 */
	public ListRespVO list(ListReqVO<EntrytraylocalmapEntity> reqVO) throws CenterException {
		return entrytraylocalmapBo.queryPageAutomatic(reqVO);
	}
	
	/**
	 * 根据ID查询单条记录
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object queryById(@Param("id") Long id) throws CenterException {
		return entrytraylocalmapBo.queryById(id);
	}

	/**
	 * 新增
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object create(EntrytraylocalmapEntity entrytraylocalmap) throws CenterException {
		entrytraylocalmapBo.createForValidate(entrytraylocalmap);
		return entrytraylocalmap;
	}

	/**
	 * 修改
	 * 
	 * @param reqVO
	 * @return
	 */
	public BaseRespVO update(EntrytraylocalmapEntity entrytraylocalmap) throws CenterException {
		int updateCount = entrytraylocalmapBo.updateForValidate(entrytraylocalmap);
		if(updateCount > 0){
			return new BaseRespVO();
		}else{
			return new BaseRespVO(2,"没有要修改的记录！");
		}
		
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	public BaseRespVO delete(@Param("id") Long[] id) throws CenterException {
		int deleteCount = entrytraylocalmapBo.batchDeleteById(id);
		if (deleteCount > 0) {
			return new BaseRespVO();
		} else {
			return new BaseRespVO(2, "没有要删除的记录！");
		}
	}

	/**
	 * 根据批次号查询单条记录
	 * 
	 * @param batchNo
	 * @return
	 */
	public List<EntrytraylocalmapEntity> queryByBatchNo(@Param("batchNo") String batchNo) throws CenterException {
		return entrytraylocalmapBo.queryByBatchNo(batchNo);
	}
	
	
	public Boolean delEntrytraylocalmap(Long orderdetailId) throws CenterException {
		// 获取该详情下所有信息列表
		EntrytraylocalmapEntity entrymode = new EntrytraylocalmapEntity();
		entrymode.setOrderdetailId(orderdetailId);
		List<EntrytraylocalmapEntity> entlist = entrytraylocalmapBo.queryListByEntity(entrymode);
		List<LocationinfoEntity> locallist = new ArrayList<LocationinfoEntity>();
		// 组装ids
		
		if (entlist.size() > 0) {
			for (int i = 0; i < entlist.size(); i++) {
				entlist.get(i).setIsDelete(1);
				LocationinfoEntity temp = new LocationinfoEntity();
				temp.setId(entlist.get(i).getLocalId());
				temp.setStatus(0L);
				locallist.add(temp);
			}
			// 批量删除ids			
			entrytraylocalmapBo.batchUpdate(entlist);
			// 更新货位状态为空闲：0
			locationinfoBo.batchUpdate(locallist);

		}
		return true;
	}
	

}
