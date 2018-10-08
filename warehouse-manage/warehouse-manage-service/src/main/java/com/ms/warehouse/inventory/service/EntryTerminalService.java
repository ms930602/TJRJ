package com.ms.warehouse.inventory.service;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ms.warehouse.common.exception.CenterException;
import com.ms.warehouse.common.service.BaseService;
import com.ms.warehouse.common.vo.BaseRespVO;
import com.ms.warehouse.common.vo.Param;
import com.ms.warehouse.inventory.bo.EntrymainorderBO;
import com.ms.warehouse.inventory.bo.EntryorderdetailBO;
import com.ms.warehouse.inventory.bo.EntrytraylocalmapBO;
import com.ms.warehouse.inventory.bo.InventorydetailBO;
import com.ms.warehouse.inventory.bo.InventoryflowBO;
import com.ms.warehouse.inventory.bo.InventorymainBO;
import com.ms.warehouse.inventory.bo.InventorytraylocalmapBO;
import com.ms.warehouse.inventory.entity.EntrymainorderEntity;
import com.ms.warehouse.inventory.entity.EntryorderdetailEntity;
import com.ms.warehouse.inventory.entity.EntrytraylocalmapEntity;
import com.ms.warehouse.inventory.entity.InventorydetailEntity;
import com.ms.warehouse.inventory.entity.InventoryflowEntity;
import com.ms.warehouse.inventory.entity.InventorymainEntity;
import com.ms.warehouse.inventory.entity.InventorytraylocalmapEntity;

/**
 * 入库终端 业务处理
 * 
 * @author hxh
 * @Date 2018-08-10 10:00:00
 * @since 1.0
 */
@Service
public class EntryTerminalService extends BaseService {

	@Autowired
	private EntrytraylocalmapBO entrytraylocalmapBo;

	@Autowired
	private EntryorderdetailBO entryorderdetailBo;

	@Autowired
	private InventorymainBO inventorymainBo;

	@Autowired
	private InventorydetailBO inventorydetailBo;

	@Autowired
	private InventorytraylocalmapBO inventorytraylocalmapBo;

	@Autowired
	private InventoryflowBO inventoryflowBo;

	@Autowired
	private EntrymainorderBO entrymainorderBo;
	


	/**
	 * 更新入库信息
	 *
	 * @param
	 * @return
	 */
	@Transactional
	public BaseRespVO updateEntryInfo(@Param("id") long id) throws CenterException {

		EntrytraylocalmapEntity entrytraylocalmapEntity = entrytraylocalmapBo.queryStaById(id);

		if (null != entrytraylocalmapEntity) {
			//BigDecimal cigsmokeQuality = entrytraylocalmapEntity.getCigsmokeQuality();
			BigDecimal realinQuality = entrytraylocalmapEntity.getRealinQuality();
			
			// 更新托盘货位绑定信息入库状态
			updateTraylocalStatus(id);
			
			EntryorderdetailEntity entryorderdetailEntity = queryEntryOrderDetail(entrytraylocalmapEntity);
			updateEntryOrderDetail(entryorderdetailEntity, realinQuality);
			
			InventorymainEntity inventorymainEntity = updateOrCreInventorymain(realinQuality, entryorderdetailEntity);
			InventorydetailEntity inventorydetailEntity = updateOrCreInventoryDetail(realinQuality,
					entryorderdetailEntity, inventorymainEntity);
			createInventorytraylocalmap(entrytraylocalmapEntity, entryorderdetailEntity, inventorydetailEntity);
			createInventoryflow(realinQuality, entryorderdetailEntity, inventorymainEntity);
			updateMainorderSta(entryorderdetailEntity);
			return new BaseRespVO(0, "该托盘入库成功！");
		}
		return new BaseRespVO(2, "该托盘入库失败！");
	}

	/**
	 * @Description:更新托盘货位绑定
	 * @param id 托盘货位绑定信息id 
	 * @return 
	 * @throws 
	 */
	
	private void updateTraylocalStatus(long id) {
		int updateStatus = entrytraylocalmapBo.updateStatus(id);
		if(updateStatus <= 0) {
			throw new RuntimeException("更新托盘货位绑定失败！");
		}
	}
	
	
	/**
	 * @Description:更新入库单入库状态
	 * @param cigsmokeQuality 托盘件烟数量  
	 * @param entryorderdetailEntity 入库详细 
	 * @param inventorymainEntity 库存主信息
	 * @return 
	 * @throws 
	 */
	
	
	private void updateMainorderSta(EntryorderdetailEntity entryorderdetailEntity) {
		Long mainorderId = entryorderdetailEntity.getMainorderId();
		int i = entrymainorderBo.queryStaById(mainorderId);
		int update = 0;
		EntrymainorderEntity entity = new EntrymainorderEntity();
		entity.setId(mainorderId);
		if (i > 0) {
			entity.setStatus(2L);
			update = entrymainorderBo.update(entity);
		} else {
			entity.setStatus(3L);
			entity.setEntryCompliteDate(new Date());
			update = entrymainorderBo.update(entity);
		}
		if(0 == update) {
			throw new RuntimeException("更新入库单入库状态失败！");
		}
	}

	/**
	 * @Description:添加库存流水表
	 * @param cigsmokeQuality 托盘件烟数量  
	 * @param entryorderdetailEntity 入库详细 
	 * @return 
	 * @throws 
	 */
	
	private void createInventoryflow(BigDecimal realinQuality, EntryorderdetailEntity entity,
			InventorymainEntity inventorymainEntity) {
		InventoryflowEntity inventoryflowEntity = new InventoryflowEntity();

		inventoryflowEntity.setMaterCode(inventorymainEntity.getMaterCode());
		inventoryflowEntity.setMaterName(inventorymainEntity.getMaterName());
		inventoryflowEntity.setMaterVersion(inventorymainEntity.getMaterVersion());
		inventoryflowEntity.setMaterCigbrand(inventorymainEntity.getMaterCigbrand());
		inventoryflowEntity.setType(0L);
		inventoryflowEntity.setBatchNo(entity.getBatchNo());
		inventoryflowEntity.setQuality(realinQuality);

		EntrymainorderEntity entrymainorderEntity = entrymainorderBo.queryById(entity.getMainorderId());

		inventoryflowEntity.setOutUnit(entrymainorderEntity.getOriginWarehouseName());
		inventoryflowEntity.setOutUnitCode(entrymainorderEntity.getOriginWarehouseCode());
		inventoryflowEntity.setEntryUnit(entrymainorderEntity.getIntoWarehouseName());
		inventoryflowEntity.setEntryUnitCode(entrymainorderEntity.getIntoWarehouseCode());
		inventoryflowEntity.setEntryOrder(entrymainorderEntity.getOrderNumber());
		inventoryflowEntity.setCigtype(inventorymainEntity.getCigtype());
		inventoryflowEntity.setSubverId(entity.getSubverId());
		inventoryflowEntity.setSubverName(entity.getSubverName());
		inventoryflowEntity.setCreatedDate(new Date());
		inventoryflowBo.create(inventoryflowEntity);
		if(null == inventoryflowEntity.getId()) {
			throw new RuntimeException("添加库存流水失败！");
		}
	}

	/**
	 * @Description:添加托盘货位绑定信息
	 * @param entrytraylocalmapEntity 托盘货位绑定信息
	 * @param entryorderdetailEntity 入库详细 
	 * @param inventorydetailEntity 库存明细
	 * @return 
	 * @throws 
	 */
	
	private void createInventorytraylocalmap(EntrytraylocalmapEntity entrytraylocalmapEntity,
			EntryorderdetailEntity entryorderdetailEntity, InventorydetailEntity inventorydetailEntity) {
		InventorytraylocalmapEntity inventorytraylocalmapEntity = new InventorytraylocalmapEntity();

		inventorytraylocalmapEntity.setBatchNo(entryorderdetailEntity.getBatchNo());
		inventorytraylocalmapEntity.setDetailId(inventorydetailEntity.getId());
		inventorytraylocalmapEntity.setMaterCode(entryorderdetailEntity.getMaterCode());
		inventorytraylocalmapEntity.setLocalCode(entrytraylocalmapEntity.getLocalCode());
		inventorytraylocalmapEntity.setLocalId(entrytraylocalmapEntity.getLocalId());
		inventorytraylocalmapEntity.setLocalRfid(entrytraylocalmapEntity.getLocalRfid());
		inventorytraylocalmapEntity.setStatus(0L);
		inventorytraylocalmapEntity.setQuality(entrytraylocalmapEntity.getRealinQuality());
		inventorytraylocalmapEntity.setTrayRfid(entrytraylocalmapEntity.getTrayRfid());
		inventorytraylocalmapEntity.setSoleCode(entrytraylocalmapEntity.getSoleCode());
		inventorytraylocalmapEntity.setCigtype(entryorderdetailEntity.getCigtype());
		inventorytraylocalmapEntity.setSubverId(entryorderdetailEntity.getSubverId());
		inventorytraylocalmapEntity.setSubverName(entryorderdetailEntity.getSubverName());
		inventorytraylocalmapEntity.setCreatedDate(new Date());
		inventorytraylocalmapBo.create(inventorytraylocalmapEntity);
		if(null == inventorytraylocalmapEntity.getId()) {
			throw new RuntimeException("添加托盘货位绑定信息失败！");
		}
	}

	/**
	 * @Description:更新 创建库存明细表
	 * @param cigsmokeQuality 托盘件烟数量  
	 * @param entryorderdetailEntity 入库详细 
	 * @param inventorymainEntity 库存主信息
	 * @return InventorydetailEntity
	 * @throws 
	 */
	
	
	private InventorydetailEntity updateOrCreInventoryDetail(BigDecimal realinQuality, EntryorderdetailEntity entryorderdetailEntity,
			InventorymainEntity inventorymainEntity) {
		InventorydetailEntity inventorydetailEntity = new InventorydetailEntity();
		inventorydetailEntity.setBatchNo(entryorderdetailEntity.getBatchNo());
		inventorydetailEntity.setMaterCode(entryorderdetailEntity.getMaterCode());
		inventorydetailEntity.setMainId(inventorymainEntity.getId());
		InventorydetailEntity inventorydetailEnt = inventorydetailBo.queryByEntity(inventorydetailEntity);
		if (null != inventorydetailEnt) {
			BigDecimal inventQuality = inventorydetailEnt.getInventQuality();
			BigDecimal surplusQuality = inventorydetailEnt.getSurplusQuality();

			inventorydetailEnt.setInventQuality(inventQuality.add(realinQuality));
			inventorydetailEnt.setSurplusQuality(surplusQuality.add(realinQuality));
			
            //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //String format = simpleDateFormat.format(new Date());
            inventorydetailEnt.setUpdatedDate(new Date());
			int update = inventorydetailBo.update(inventorydetailEnt);
			if(update <= 0) {
				throw new RuntimeException("更新库存明细失败！");
			}
			return inventorydetailEnt;
		} else {
			inventorydetailEntity.setInventQuality(realinQuality);
			inventorydetailEntity.setOutQuality(new BigDecimal(0));
			inventorydetailEntity.setSurplusQuality(realinQuality);
			inventorydetailEntity.setCigtype(entryorderdetailEntity.getCigtype());
			inventorydetailEntity.setSubverId(entryorderdetailEntity.getSubverId());
			inventorydetailEntity.setSubverName(entryorderdetailEntity.getSubverName());
			inventorydetailEntity.setCreatedDate(new Date());
			inventorydetailBo.create(inventorydetailEntity);
			
			if(null == inventorydetailEntity.getId()) {
				throw new RuntimeException("添加库存明细失败！");
			}
		}
		return inventorydetailEntity;
	}

	/**
	 * @Description:更新 创建库存
	 * @param cigsmokeQuality 托盘件烟数量  
	 * @param entryorderdetailEntity 入库详细 
	 * @return InventorymainEntity
	 * @throws 
	 */
	
	
	private InventorymainEntity updateOrCreInventorymain(BigDecimal realinQuality, EntryorderdetailEntity entryorderdetailEntity) {
		InventorymainEntity inventorymainEntity = new InventorymainEntity();

		inventorymainEntity.setMaterCode(entryorderdetailEntity.getMaterCode());
		inventorymainEntity.setSubverId(entryorderdetailEntity.getSubverId());
		
		InventorymainEntity inventorymainEnt = inventorymainBo.queryByEntity(inventorymainEntity);

		// 更新库存主表
		if (null != inventorymainEnt) {
			BigDecimal totalCount = inventorymainEnt.getTotalCount();
			inventorymainEnt.setTotalCount(totalCount.add(realinQuality));
			inventorymainEnt.setUpdatedDate(new Date());
			int update = inventorymainBo.update(inventorymainEnt);
			if(update <= 0) {
				throw new RuntimeException("更新库存主表物料失败！");
			}
			return inventorymainEnt;
		} else {				
				// 添加一条库存主表物料
				inventorymainEntity.setMaterCode(entryorderdetailEntity.getMaterCode());
				inventorymainEntity.setMaterName(entryorderdetailEntity.getMaterName());
				inventorymainEntity.setMaterVersion(entryorderdetailEntity.getMaterVersion());
				inventorymainEntity.setMaterCigbrand(entryorderdetailEntity.getMaterCigbrand());
				inventorymainEntity.setTotalCount(realinQuality);
				inventorymainEntity.setCigtype(entryorderdetailEntity.getCigtype());
				inventorymainEntity.setSubverId(entryorderdetailEntity.getSubverId());
				inventorymainEntity.setSubverName(entryorderdetailEntity.getSubverName());
				inventorymainEntity.setCreatedDate(new Date());
				inventorymainBo.create(inventorymainEntity);
				if(null == inventorymainEntity.getId()) {
					throw new RuntimeException("添加库存主表物料失败！");
				}
		}
				
		return inventorymainEntity;
	}

	/**
	 * @Description:查询入库单详情
	 * @param entrytraylocalmapEntity 托盘货位绑定信息
	 * @return EntryorderdetailEntity
	 * @throws 
	 */
	
	private EntryorderdetailEntity queryEntryOrderDetail(EntrytraylocalmapEntity entrytraylocalmapEntity) {
		EntryorderdetailEntity entryorderdetailEntity = new EntryorderdetailEntity();
		entryorderdetailEntity.setId(entrytraylocalmapEntity.getOrderdetailId());
		entryorderdetailEntity.setBatchNo(entrytraylocalmapEntity.getBatchNo());

		return entryorderdetailBo.queryByEntity(entryorderdetailEntity);
	}

	/**
	 * @Description:更新入库单详情实际入库数量
	 * @param cigsmokeQuality 托盘件烟数量  
	 * @param entryorderdetailEntity 入库详细 
	 * @return 
	 * @throws 
	 */
	
	
	private int updateEntryOrderDetail(EntryorderdetailEntity entryorderdetailEntity, BigDecimal realinQuality) {
		BigDecimal actualQuality = entryorderdetailEntity.getActualQuality();
		if (null == actualQuality) {
			actualQuality = new BigDecimal(0);
		}
		entryorderdetailEntity.setActualQuality(actualQuality.add(realinQuality));
		
		int update = entryorderdetailBo.update(entryorderdetailEntity);
		if(update <= 0) {
			throw new RuntimeException("更新托盘货位绑定失败！");
		}
		return update;
	}
}
