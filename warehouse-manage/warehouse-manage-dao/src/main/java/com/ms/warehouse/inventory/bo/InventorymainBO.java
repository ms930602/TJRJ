
package com.ms.warehouse.inventory.bo;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.common.utils.SQLValid;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;
import com.ms.warehouse.inventory.entity.EntryorderdetailEntity;
import com.ms.warehouse.inventory.entity.InventoryAllEntity;
import com.ms.warehouse.inventory.entity.InventorymainEntity;
import com.ms.warehouse.inventory.mapper.InventoryAllMapper;
import com.ms.warehouse.inventory.mapper.InventorymainMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 库存主 bo
 * @author dwx
 * @Date 2018-07-25 10:22:19
 * @since 1.0
 */
@Component
public class InventorymainBO extends AbstractBaseBO<InventorymainEntity> {
	
	@Autowired
	private InventorymainMapper inventorymainMapper;
	
	@Autowired
	private InventoryAllMapper inventoryAllMapper;
	
	@Override
    protected IBaseMapper<InventorymainEntity> getMapper() {
	    return inventorymainMapper;
    }

    public ListRespVO querymaindetail(ListReqVO<InventorymainEntity> reqVO){
		if (reqVO != null && reqVO.getOrderField() != null && !SQLValid.isValid(reqVO.getOrderField())) {
			reqVO.setOrderField(null);
		}

		Page<InventorymainEntity> page = null;

		if (reqVO != null && 0 != reqVO.getPageNum()) {
			page = PageHelper.startPage(reqVO.getPageNum(), reqVO.getPageSize(), true);
		} else {
			page = PageHelper.startPage(1, 1000, true);
		}

		ListRespVO resp = new ListRespVO();
		resp.setAaData(inventorymainMapper.querymaindetail(reqVO));
		resp.setDataCount(inventorymainMapper.querymaindetailcount(reqVO));
		return resp;
	}
    
    public List<InventorymainEntity> selectInventory(String batchNo){
    	return inventorymainMapper.selectInventory(batchNo);
    }
    
    public List<InventoryAllEntity> queryInAllByPage(ListReqVO reqVO) {
		if (reqVO.getOrderField() != null && !SQLValid.isValid(reqVO.getOrderField())) {
			reqVO.setOrderField(null);
		}

		if (0 != reqVO.getPageNum()) {
			reqVO.setPageNum((reqVO.getPageNum() - 1) * reqVO.getPageSize());
		}
		return inventoryAllMapper.queryInAllByPage(reqVO);
	}
	public int queryInAllCount(ListReqVO reqVO) {
		if (reqVO.getPageNum() != 0) {
			reqVO.setPageNum((reqVO.getPageNum() - 1) * reqVO.getPageSize());
		}
		return inventoryAllMapper.queryInAllCount(reqVO);
	}
	
	public List<InventoryAllEntity> queryInAllbyId(int id){
		
		return inventoryAllMapper.queryInAllbyId(id);
	}
	
    public List<InventoryAllEntity> queryInAll(){
		
		return inventoryAllMapper.queryInAll();
	}
    
	
	public ListRespVO queryILByPage(ListReqVO<InventorymainEntity> reqVO){
		if (reqVO != null && reqVO.getOrderField() != null && !SQLValid.isValid(reqVO.getOrderField())) {
			reqVO.setOrderField(null);
		}

		Page<InventorymainEntity> page = null;

		if (reqVO != null && 0 != reqVO.getPageNum()) {
			page = PageHelper.startPage(reqVO.getPageNum(), reqVO.getPageSize(), true);
		} else {
			page = PageHelper.startPage(1, 1000, true);
		}

		ListRespVO resp = new ListRespVO();
		resp.setAaData(inventorymainMapper.queryILByPage(reqVO));
		resp.setDataCount(inventorymainMapper.queryILCount(reqVO));
		return resp;
	}
	/**
	 *根据编号查对象
	 * @param materCode
	 * @return
	 */
	public InventorymainEntity querymainBymatercode(String materCode,Long subverId){
		return inventorymainMapper.querymainBymatercode(materCode,subverId);
	}

	public ListRespVO queryAlldetails(ListReqVO<InventorymainEntity> reqVO){
		if (reqVO != null && reqVO.getOrderField() != null && !SQLValid.isValid(reqVO.getOrderField())) {
			reqVO.setOrderField(null);
		}

		Page<InventorymainEntity> page = null;

		if (reqVO != null && 0 != reqVO.getPageNum()) {
			page = PageHelper.startPage(reqVO.getPageNum(), reqVO.getPageSize(), true);
		} else {
			page = PageHelper.startPage(1, 1000, true);
		}

		ListRespVO resp = new ListRespVO();
		resp.setAaData(inventorymainMapper.queryAlldetails(reqVO));
		resp.setDataCount(inventorymainMapper.queryAlldetailscount(reqVO));
		return resp;
	}

}
