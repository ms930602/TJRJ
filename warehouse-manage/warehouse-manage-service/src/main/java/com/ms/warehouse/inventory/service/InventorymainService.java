package com.ms.warehouse.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.warehouse.common.exception.CenterException;
import com.ms.warehouse.common.service.BaseService;
import com.ms.warehouse.common.vo.BaseRespVO;
import com.ms.warehouse.common.vo.Param;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;
import com.ms.warehouse.inventory.bo.InventorymainBO;
import com.ms.warehouse.inventory.entity.InventoryAllEntity;
import com.ms.warehouse.inventory.entity.InventorymainEntity;

/**
 * 库存主 业务处理
 * @author dwx
 * @Date 2018-07-25 10:22:19
 * @since 1.0
 */@Service
public class InventorymainService extends BaseService {

	@Autowired
	private InventorymainBO inventorymainBo;

	/**
	 * 分页查询列表
	 * 
	 * @param reqVO
	 * @return
	 */
	public ListRespVO list(ListReqVO<InventorymainEntity> reqVO) throws CenterException {
		return inventorymainBo.queryPageAutomatic(reqVO);
	}
	
	/**
	 * 根据ID查询单条记录
	 * 
	 * @param id
	 * @return
	 */
	public Object queryById(@Param("id") Long id) throws CenterException {
		return inventorymainBo.queryById(id);
	}

	/**
	 * 新增
	 * 
	 * @param inventorymain
	 * @return
	 */
	public Object create(InventorymainEntity inventorymain) throws CenterException {
		inventorymainBo.createForValidate(inventorymain);
		return inventorymain;
	}

	/**
	 * 修改
	 * 
	 * @param inventorymain
	 * @return
	 */
	public BaseRespVO update(InventorymainEntity inventorymain) throws CenterException {
		int updateCount = inventorymainBo.updateForValidate(inventorymain);
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
		int deleteCount = inventorymainBo.batchDeleteById(id);
		if (deleteCount > 0) {
			return new BaseRespVO();
		} else {
			return new BaseRespVO(2, "没有要删除的记录！");
		}
	}
	public ListRespVO querymaindetail(ListReqVO<InventorymainEntity> reqVO){
		return inventorymainBo.querymaindetail(reqVO);
	}

	public ListRespVO queryAlldetails(ListReqVO<InventorymainEntity> reqVO){
		return inventorymainBo.queryAlldetails(reqVO);
	}

	
	/**
	 * 根据批次号查询库存
	 * 
	 * @param batchNo
	 * @return
	 */
	public List<InventorymainEntity> selectInventory(@Param("batchNo") String batchNo) throws CenterException {
		
		return inventorymainBo.selectInventory(batchNo);
	}
	
	/**
	 * 库存,库存明细,货位托盘分页查询
	 *
	 * @param reqVO
	 * @return
	 */
	public ListRespVO inventorylist(ListReqVO<InventoryAllEntity> reqVO) throws CenterException {
		List<InventoryAllEntity> orderList = inventorymainBo.queryInAllByPage(reqVO);
		int dataCount = inventorymainBo.queryInAllCount(reqVO);

		ListRespVO respVO = new ListRespVO();
		respVO.setAaData(orderList);
		respVO.setDataCount(dataCount);
		return  respVO;
	}
	
	/**
	 * 根据库存主表ID查询库存明细和货位托盘详情
	 *
	 * @param id
	 * @return
	 */
	public List<InventoryAllEntity> queryInAllbyId(@Param("id") int id){
		List<InventoryAllEntity> entities=inventorymainBo.queryInAllbyId(id);
		return entities;
	}
	
//	public static List<InventoryAllEntity> mergeList(List<InventoryAllEntity> list) {  
//	    HashMap<Object, InventoryAllEntity> map = new HashMap<Object, InventoryAllEntity>();  
//	    for (InventoryAllEntity bean : list) {  
//	        if (map.containsKey(bean.getDetailId())) {  
//	        	InventorytraylocalmapEntity entity=new InventorytraylocalmapEntity();
//	        	entity.setQuality(bean.getQuality());
//	        	map.get(bean.getDetailId()).getItlmEntities().add(entity); 
//	        }  
//	        map.put(bean.getDetailId(), bean);  
//	    }  
//	    list.clear();  
//	    list.addAll(map.values());  
//	    return list;
//	}

	
	/**
	 * 查询库存明细和货位托盘详情
	 *
	 * @return
	 */
	public List<InventoryAllEntity> queryInAll(){
		return inventorymainBo.queryInAll();
	}
	
	/**
	 * 分页查询库存主表和尾盘表
	 * 
	 * @param reqVO
	 * @return
	 */
	public ListRespVO listIL(ListReqVO<InventorymainEntity> reqVO){
		return inventorymainBo.queryILByPage(reqVO);
	}
	
}
