
package com.ms.warehouse.inventory.bo;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.common.utils.SQLValid;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;
import com.ms.warehouse.inventory.entity.EntryorderdetailEntity;
import com.ms.warehouse.inventory.entity.InventorymainEntity;
import com.ms.warehouse.inventory.entity.OutorderdetailEntity;
import com.ms.warehouse.inventory.mapper.EntryorderdetailMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * 入库单详情信息 bo
 * @author dwx
 * @Date 2018-07-25 10:22:18
 * @since 1.0
 */
@Component
public class EntryorderdetailBO extends AbstractBaseBO<EntryorderdetailEntity> {
	
	@Autowired
	private EntryorderdetailMapper entryorderdetailMapper;
	
	@Override
    protected IBaseMapper<EntryorderdetailEntity> getMapper() {
	    return entryorderdetailMapper;
    }

	public ListRespVO queryProTrackByPage(ListReqVO<EntryorderdetailEntity> reqVO){
		if (reqVO != null && reqVO.getOrderField() != null && !SQLValid.isValid(reqVO.getOrderField())) {
			reqVO.setOrderField(null);
		}

		Page<EntryorderdetailEntity> page = null;

		if (reqVO != null && 0 != reqVO.getPageNum()) {
			page = PageHelper.startPage(reqVO.getPageNum(), reqVO.getPageSize(), true);
		} else {
			page = PageHelper.startPage(1, 1000, true);
		}

		ListRespVO resp = new ListRespVO();
		resp.setAaData(entryorderdetailMapper.queryProTrackByPage(reqVO));
		resp.setDataCount(entryorderdetailMapper.queryProTrackCount(reqVO));
		return resp;
	}
	
	public List<EntryorderdetailEntity> queryBymainId(Long mainorderId){
		return entryorderdetailMapper.queryBymainId(mainorderId);
	}

	public int deleteByMainId(Long id) {
		return entryorderdetailMapper.deleteByMainId(id);
	}
}

