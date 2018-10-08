
package com.ms.warehouse.inventory.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.common.utils.SQLValid;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;
import com.ms.warehouse.inventory.entity.InventorymainEntity;
import com.ms.warehouse.inventory.entity.InventorytraylocalPageEntity;
import com.ms.warehouse.inventory.entity.PositionadjustmainEntity;
import com.ms.warehouse.inventory.mapper.PositionadjustmainMapper;


/**
 * 货位调整主 bo
 * @author dwx
 * @Date 2018-07-25 10:22:20
 * @since 1.0
 */
@Component
public class PositionadjustmainBO extends AbstractBaseBO<PositionadjustmainEntity> {
	
	@Autowired
	private PositionadjustmainMapper positionadjustmainMapper;
	
	@Override
    protected IBaseMapper<PositionadjustmainEntity> getMapper() {
	    return positionadjustmainMapper;
    }
	
	public List<PositionadjustmainEntity> queryByBatchNo(String batchNo){
		return positionadjustmainMapper.queryByBatchNo(batchNo);
	}
	/**
	 * 通过条件获取信息
	 * @param reqVO
	 * @return
	 */
	public ListRespVO queryInventorytraylocalPage(ListReqVO<InventorytraylocalPageEntity> reqVO){
		if (reqVO != null && reqVO.getOrderField() != null && !SQLValid.isValid(reqVO.getOrderField())) {
			reqVO.setOrderField(null);
		}

		Page<InventorytraylocalPageEntity> page = null;

		if (reqVO != null && 0 != reqVO.getPageNum()) {
			page = PageHelper.startPage(reqVO.getPageNum(), reqVO.getPageSize(), true);
		} else {
			page = PageHelper.startPage(1, 1000, true);
		}

		ListRespVO resp = new ListRespVO();
		resp.setAaData(positionadjustmainMapper.queryInventorytraylocalPage(reqVO));
		resp.setDataCount(page.getTotal());
		return resp;
	}
	
	public ListRespVO queryPPdByPage(ListReqVO<PositionadjustmainEntity> reqVO){
		if (reqVO != null && reqVO.getOrderField() != null && !SQLValid.isValid(reqVO.getOrderField())) {
			reqVO.setOrderField(null);
		}

		Page<PositionadjustmainEntity> page = null;

		if (reqVO != null && 0 != reqVO.getPageNum()) {
			page = PageHelper.startPage(reqVO.getPageNum(), reqVO.getPageSize(), true);
		} else {
			page = PageHelper.startPage(1, 1000, true);
		}

		ListRespVO resp = new ListRespVO();
		resp.setAaData(positionadjustmainMapper.queryPPdByPage(reqVO));
		resp.setDataCount(positionadjustmainMapper.queryPPdCount(reqVO));
		return resp;
	}
}
