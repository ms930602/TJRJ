
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
import com.ms.warehouse.inventory.entity.OuttraylocalmapEntity;
import com.ms.warehouse.inventory.entity.StockcheckmainEntity;
import com.ms.warehouse.inventory.mapper.StockcheckmainMapper;


/**
 * 库存盘点主信息 bo
 * @author dwx
 * @Date 2018-07-25 10:22:20
 * @since 1.0
 */
@Component
public class StockcheckmainBO extends AbstractBaseBO<StockcheckmainEntity> {
	
	@Autowired
	private StockcheckmainMapper stockcheckmainMapper;
	
	@Override
    protected IBaseMapper<StockcheckmainEntity> getMapper() {
	    return stockcheckmainMapper;
    }
	
	public List<StockcheckmainEntity> queryByBatchNo(String batchNo) {
		    return stockcheckmainMapper.queryByBatchNo(batchNo);
	}
	
	
	public ListRespVO queryByUnCheckPage(ListReqVO<StockcheckmainEntity> reqVO){
		if (reqVO != null && reqVO.getOrderField() != null && !SQLValid.isValid(reqVO.getOrderField())) {
			reqVO.setOrderField(null);
		}

		Page<StockcheckmainEntity> page = null;

		if (reqVO != null && 0 != reqVO.getPageNum()) {
			page = PageHelper.startPage(reqVO.getPageNum(), reqVO.getPageSize(), true);
		} else {
			page = PageHelper.startPage(1, 1000, true);
		}

		ListRespVO resp = new ListRespVO();
		resp.setAaData(stockcheckmainMapper.queryByUnCheckPage(reqVO));
		resp.setDataCount(stockcheckmainMapper.queryUnCheckCount(reqVO));
		return resp;
	}
}
