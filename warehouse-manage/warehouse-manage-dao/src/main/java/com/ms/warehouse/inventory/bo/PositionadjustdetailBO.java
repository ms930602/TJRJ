
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
import com.ms.warehouse.inventory.entity.PositionadjustdetailEntity;
import com.ms.warehouse.inventory.entity.PositionadjustmainEntity;
import com.ms.warehouse.inventory.mapper.PositionadjustdetailMapper;


/**
 * 货位调整表详情 bo
 * @author dwx
 * @Date 2018-07-25 10:22:20
 * @since 1.0
 */
@Component
public class PositionadjustdetailBO extends AbstractBaseBO<PositionadjustdetailEntity> {
	
	@Autowired
	private PositionadjustdetailMapper positionadjustdetailMapper;
	
	@Override
    protected IBaseMapper<PositionadjustdetailEntity> getMapper() {
	    return positionadjustdetailMapper;
    }
	
	public List<PositionadjustdetailEntity> queryByBatchNo(String batchNo){
		return positionadjustdetailMapper.queryByBatchNo(batchNo);
	}

	public void deleteByMainId(Long id) {
		positionadjustdetailMapper.deleteByMainId(id);
	}
	
	public ListRespVO listdetail(ListReqVO<PositionadjustdetailEntity> reqVO){
		if (reqVO != null && reqVO.getOrderField() != null && !SQLValid.isValid(reqVO.getOrderField())) {
			reqVO.setOrderField(null);
		}

		Page<PositionadjustdetailEntity> page = null;

		if (reqVO != null && 0 != reqVO.getPageNum()) {
			page = PageHelper.startPage(reqVO.getPageNum(), reqVO.getPageSize(), true);
		} else {
			page = PageHelper.startPage(1, 1000, true);
		}

		ListRespVO resp = new ListRespVO();
		resp.setAaData(positionadjustdetailMapper.queryByPageun(reqVO));
		resp.setDataCount(positionadjustdetailMapper.queryCountun(reqVO));
		return resp;
	}
}
