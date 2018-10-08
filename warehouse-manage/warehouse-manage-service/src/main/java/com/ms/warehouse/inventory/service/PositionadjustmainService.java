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
import com.ms.warehouse.inventory.bo.PositionadjustdetailBO;
import com.ms.warehouse.inventory.bo.PositionadjustmainBO;
import com.ms.warehouse.inventory.entity.InventorytraylocalPageEntity;
import com.ms.warehouse.inventory.entity.PositionadjustdetailEntity;
import com.ms.warehouse.inventory.entity.PositionadjustmainEntity;
import com.ms.warehouse.manage.bo.LocationinfoBO;
import com.ms.warehouse.manage.entity.LocationinfoEntity;
import com.ms.warehouse.manage.entity.PositionadjustFormEntity;

/**
 * 货位调整主 业务处理
 * @author dwx
 * @Date 2018-07-25 10:22:20
 * @since 1.0
 */@Service
public class PositionadjustmainService extends BaseService {

	@Autowired
	private PositionadjustmainBO positionadjustmainBo;
	@Autowired
	private PositionadjustdetailBO positionadjustdetailBO;
	@Autowired
	private GenerateSerial generateSerial;
	@Autowired
	private LocationinfoBO locationinfoBO;

	/**
	 * 分页查询列表
	 * 
	 * @param reqVO
	 * @return
	 */
	public ListRespVO list(ListReqVO<PositionadjustmainEntity> reqVO) throws CenterException {
		return positionadjustmainBo.queryPageAutomatic(reqVO);
	}
	
	public ListRespVO queryInventorytraylocalPage(ListReqVO<InventorytraylocalPageEntity> reqVO){
		return positionadjustmainBo.queryInventorytraylocalPage(reqVO);
	}
	/**
	 * 根据ID查询单条记录
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object queryById(@Param("id") Long id) throws CenterException {
		return positionadjustmainBo.queryById(id);
	}
	
	public Object queryFormById(@Param("id") Long id) throws CenterException {
		PositionadjustmainEntity queryById = positionadjustmainBo.queryById(id);
		PositionadjustdetailEntity query = new PositionadjustdetailEntity();
		query.setMainId(queryById.getId());
		List<PositionadjustdetailEntity> detailList = positionadjustdetailBO.queryListByEntity(query);
		PositionadjustFormEntity formEntity = new PositionadjustFormEntity();
		formEntity.copyObject(queryById);
		formEntity.setDetail(detailList);
		
		return formEntity;
	}
	
	private void formSave(PositionadjustFormEntity form) throws CenterException{
		form.setOrderNumber(generateSerial.GenSer(Constants.SER_ADJUSTMENTNO));
		form.setCreatedDate(new Date());
		
		positionadjustmainBo.createForValidate(form);
		List<PositionadjustdetailEntity> detail = form.getDetail();
		
		List<LocationinfoEntity> lList = new ArrayList<LocationinfoEntity>();
		
		LocationinfoEntity query = new LocationinfoEntity();
		LocationinfoEntity le = null;
		Long status = form.getStatus();
		for (PositionadjustdetailEntity entity : detail) {
			entity.setMainId(form.getId());
			if(status == 1)
			{
				entity.setStatus(2L);
				query.setLocalCode(entity.getDestLocalCode());
				le = locationinfoBO.queryByEntity(query);
				le.setStatus(1L);
				lList.add(le);
			}
		}
		positionadjustdetailBO.batchSave(detail);
		if(status == 1)
		{
			locationinfoBO.batchUpdate(lList);
		}
	}
	
	private void formUpdate(PositionadjustFormEntity form)
	{
		Long status = form.getStatus();
		PositionadjustmainEntity queryEntity = positionadjustmainBo.queryById(form.getId());
		queryEntity.setUpdatedDate(new Date());
		queryEntity.setUpdatedPerson(form.getUpdatedPerson());
		queryEntity.setUpdatedPersonId(form.getUpdatedPersonId());
		queryEntity.setFloorCode(form.getFloorCode());
		queryEntity.setFloorName(form.getFloorName());
		queryEntity.setRemark(form.getRemark());
		queryEntity.setStatus(status);
		
		List<PositionadjustdetailEntity> detailList = form.getDetail();
		List<PositionadjustdetailEntity> updateList = new ArrayList<>();
		List<PositionadjustdetailEntity> saveList = new ArrayList<>();
		List<LocationinfoEntity> lList = new ArrayList<LocationinfoEntity>();
		LocationinfoEntity query = new LocationinfoEntity();
		LocationinfoEntity le = null;
		for (PositionadjustdetailEntity temp : detailList) {
			
			if(status == 1)
			{
				temp.setStatus(2L);//确定状态   绑定货位状态
			}
			
			if(temp.getId() == null || temp.getId() < 1)
			{
				temp.setMainId(queryEntity.getId());
				saveList.add(temp);
			}else{
				updateList.add(temp);
			}
			
			query.setLocalCode(temp.getDestLocalCode());
			le = locationinfoBO.queryByEntity(query);
			le.setStatus(1L);
			lList.add(le);
		}
		Long[] deleteObj = form.getDeleteObj();
		if(deleteObj != null && deleteObj.length > 0)
		{
			positionadjustdetailBO.batchDeleteById(deleteObj);
		}
		
		positionadjustmainBo.update(queryEntity);
		positionadjustdetailBO.batchSave(saveList);
		positionadjustdetailBO.batchUpdate(updateList);
		
		if(status == 1)
		{
			locationinfoBO.batchUpdate(lList);
		}
	}
	/**
	 * 新增
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object formAction(@Param("formData")String formData) throws CenterException {
		PositionadjustFormEntity form = JsonUtils.parse(formData, PositionadjustFormEntity.class);
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

	/**
	 * 新增
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object create(PositionadjustmainEntity positionadjustmain) throws CenterException {
		positionadjustmainBo.createForValidate(positionadjustmain);
		return positionadjustmain;
	}

	/**
	 * 修改
	 * 
	 * @param reqVO
	 * @return
	 */
	public BaseRespVO update(PositionadjustmainEntity positionadjustmain) throws CenterException {
		int updateCount = positionadjustmainBo.updateForValidate(positionadjustmain);
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
		int deleteCount = positionadjustmainBo.deleteById(id);
		if (deleteCount > 0) {
			positionadjustdetailBO.deleteByMainId(id);
			return new BaseRespVO();
		} else {
			return new BaseRespVO(2, "没有要删除的记录！");
		}
	}

	/*
	 * 通过批次号查询记录
	 */
	public List<PositionadjustmainEntity> queryByBatchNo(@Param("batchNo") String batchNo) {
	    return positionadjustmainBo.queryByBatchNo(batchNo);
    }
}
