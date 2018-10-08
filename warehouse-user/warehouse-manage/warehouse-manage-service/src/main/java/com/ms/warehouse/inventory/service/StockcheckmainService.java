package com.ms.warehouse.inventory.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.warehouse.common.Constants;
import com.ms.warehouse.common.exception.CenterException;
import com.ms.warehouse.common.serial.GenerateSerial;
import com.ms.warehouse.common.service.BaseService;
import com.ms.warehouse.common.utils.JsonUtils;
import com.ms.warehouse.common.vo.BaseRespVO;
import com.ms.warehouse.common.vo.Param;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;
import com.ms.warehouse.inventory.bo.InventorytraylocalmapBO;
import com.ms.warehouse.inventory.bo.StockcheckdetailBO;
import com.ms.warehouse.inventory.bo.StockcheckmainBO;
import com.ms.warehouse.inventory.entity.InventorytraylocalmapEntity;
import com.ms.warehouse.inventory.entity.StockcheckFormEntity;
import com.ms.warehouse.inventory.entity.StockcheckdetailEntity;
import com.ms.warehouse.inventory.entity.StockcheckmainEntity;

/**
 * 库存盘点主信息 业务处理
 * @author dwx
 * @Date 2018-07-25 10:22:20
 * @since 1.0
 */@Service
public class StockcheckmainService extends BaseService {

	@Autowired
	private StockcheckmainBO stockcheckmainBo;
	@Autowired
	private StockcheckdetailBO stockcheckdetailBO;
	@Autowired
	private GenerateSerial generateSerial;
	@Autowired
	private InventorytraylocalmapBO inventorytraylocalmapBO;

	/**
	 * 分页查询列表
	 * 
	 * @param reqVO
	 * @return
	 */
	public ListRespVO list(ListReqVO<StockcheckmainEntity> reqVO) throws CenterException {
		return stockcheckmainBo.queryPageAutomatic(reqVO);
	}
	
	/**
	 * 根据ID查询单条记录
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object queryById(@Param("id") Long id) throws CenterException {
		return stockcheckmainBo.queryById(id);
	}

	/**
	 * 新增
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object create(StockcheckmainEntity stockcheckmain) throws CenterException {
		stockcheckmainBo.createForValidate(stockcheckmain);
		return stockcheckmain;
	}

	/**
	 * 修改
	 * 
	 * @param reqVO
	 * @return
	 */
	public BaseRespVO update(StockcheckmainEntity stockcheckmain) throws CenterException {
		int updateCount = stockcheckmainBo.updateForValidate(stockcheckmain);
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
	public BaseRespVO delete(@Param("id") Long id) throws CenterException {
		int deleteCount = stockcheckmainBo.deleteById(id);
		if (deleteCount > 0) {
			stockcheckdetailBO.deleteByMainId(id);
			return new BaseRespVO();
		} else {
			return new BaseRespVO(2, "没有要删除的记录！");
		}
	}
	
	/*
	 * 通过批次号查询记录
	 */
	public List<StockcheckmainEntity> queryByBatchNo(@Param("batchNo") String batchNo) {
	    return stockcheckmainBo.queryByBatchNo(batchNo);
    }
	
	public Object queryFormById(@Param("id") Long id) throws CenterException {
		StockcheckmainEntity queryById = stockcheckmainBo.queryById(id);
		StockcheckdetailEntity query = new StockcheckdetailEntity();
		query.setMainId(queryById.getId());
		List<StockcheckdetailEntity> detailList = stockcheckdetailBO.queryListByEntity(query);
		StockcheckFormEntity formEntity = new StockcheckFormEntity();
		formEntity.copyObject(queryById);
		formEntity.setDetail(detailList);
		
		return formEntity;
	}
	
	private void formSave(StockcheckFormEntity form) throws CenterException{
		form.setOrderNumber(generateSerial.GenSer(Constants.SER_INVENTORYNO));
		form.setCreatedDate(new Date());
		if(form.getStatus() == 1){//已确认 设置开始时间
			form.setInventStartDate(new Date());
		}
		stockcheckmainBo.createForValidate(form);
		List<StockcheckdetailEntity> detail = form.getDetail();
		
		for (StockcheckdetailEntity entity : detail) {
			entity.setMainId(form.getId());
		}
		stockcheckdetailBO.batchSave(detail);
	}
	
	private void formUpdate(StockcheckFormEntity form)
	{
		Long status = form.getStatus();
		StockcheckmainEntity queryEntity = stockcheckmainBo.queryById(form.getId());
		queryEntity.setUpdatedPerson(form.getUpdatedPerson());
		queryEntity.setUpdatedPersonId(form.getUpdatedPersonId());
		queryEntity.setInventor(form.getInventor());
		queryEntity.setRemark(form.getRemark());
		queryEntity.setStatus(status);
		queryEntity.setReversion(form.getReversion());
		if(status == 1){//已确认 设置开始时间
			queryEntity.setInventStartDate(new Date());
		}
		List<StockcheckdetailEntity> detailList = form.getDetail();
		List<StockcheckdetailEntity> updateList = new ArrayList<>();
		List<StockcheckdetailEntity> saveList = new ArrayList<>();
		List<InventorytraylocalmapEntity> localmapList = new ArrayList<>();
		InventorytraylocalmapEntity queryLocalMap = new InventorytraylocalmapEntity();
		InventorytraylocalmapEntity queryByEntity;
		for (StockcheckdetailEntity temp : detailList) {
			
			if(status == 3){
				temp.setStatus(1L);
				queryLocalMap.setLocalCode(temp.getLocalCode());
				queryByEntity = inventorytraylocalmapBO.queryByEntity(queryLocalMap);
				queryByEntity.setQuality(temp.getActualCountQuality());
				localmapList.add(queryByEntity);
			}
			
			if(temp.getId() == null || temp.getId() < 1)
			{
				temp.setMainId(queryEntity.getId());
				saveList.add(temp);
			}else{
				updateList.add(temp);
			}
			
		}
		
		if(status == 3){//已完成  需要修改实际库存中的数量
			inventorytraylocalmapBO.batchUpdate(localmapList);
			queryEntity.setInventEndDate(new Date());
		}
		
		Long[] deleteObj = form.getDeleteObj();
		if(deleteObj != null && deleteObj.length > 0)
		{
			stockcheckdetailBO.batchDeleteById(deleteObj);
		}
		
		stockcheckmainBo.update(queryEntity);
		stockcheckdetailBO.batchSave(saveList);
		stockcheckdetailBO.batchUpdate(updateList);
	}
	/**
	 * 新增
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object formAction(@Param("formData")String formData) throws CenterException {
		StockcheckFormEntity form = JsonUtils.parse(formData, StockcheckFormEntity.class);
		if(form.getId() == null)
		{
			formSave(form);
		}
		else
		{
			formUpdate(form);
		}
		
		return form;
	}

}
