
package com.ms.warehouse.inventory.bo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.inventory.entity.OutorderdetailEntity;
import com.ms.warehouse.inventory.mapper.OutorderdetailMapper;


/**
 * 出库单详情 bo
 * @author dwx
 * @Date 2018-07-25 10:22:19
 * @since 1.0
 */
@Component
public class OutorderdetailBO extends AbstractBaseBO<OutorderdetailEntity> {
	
	@Autowired
	private OutorderdetailMapper outorderdetailMapper;
	
	@Override
    protected IBaseMapper<OutorderdetailEntity> getMapper() {
	    return outorderdetailMapper;
    }
	/**
	 * 根据参数   获取出库明细
	 * @param mainorderId
	 * @return
	 */
	public List<OutorderdetailEntity> getoutorderdetaillist(Long mainorderId){
		return outorderdetailMapper.getoutorderdetaillist(mainorderId);
	}
	/**
	 * 根据订单ID 删除出库明细
	 * @param mainorderId
	 * @return
	 */
	public int deleteBymainorderId(Long mainorderId){
		return outorderdetailMapper.deleteBymainorderId(mainorderId);
	}
	/**
	 * 根据出库单id获取 明细列表
	 * @param mainorderId
	 * @return
	 */
	public List<OutorderdetailEntity> queryBymainId(Long mainorderId){
		return outorderdetailMapper.queryBymainId(mainorderId);
	}

	/**
	 *根据出库单id 获取出库明细总数
	 * @param mainorderId
	 * @return
     */
	public BigDecimal getdetailTotal(Long mainorderId){
		return outorderdetailMapper.getdetailTotal(mainorderId);
	}

	/**
	 * 逻辑删除明细 根据出库单Id
	 * @param mainorderId
	 */
	public void updateisDeletebymainorderId(Long mainorderId){
		outorderdetailMapper.updateisDeletebymainorderId(mainorderId);
	}

	/**
	 *  出库统计主要统计某一天出库的每种规格的烟的数量。
	 以Echart的Pie图（饼图）展示，且要将查询结果以列表展示出来。
	 查询条件：【日期，只能选择某一天，年月日】
	 * @param createDate
	 * @return
	 */
	public List<OutorderdetailEntity> outgoingStatistics(Date createDate){
		return outorderdetailMapper.outgoingStatistics(createDate);
	}
}
