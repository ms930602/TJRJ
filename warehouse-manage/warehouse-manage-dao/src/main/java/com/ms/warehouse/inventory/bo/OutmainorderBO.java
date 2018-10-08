
package com.ms.warehouse.inventory.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.inventory.entity.OutmainorderEntity;
import com.ms.warehouse.inventory.mapper.OutmainorderMapper;


/**
 * 出库单主 bo
 * @author dwx
 * @Date 2018-07-25 10:22:19
 * @since 1.0
 */
@Component
public class OutmainorderBO extends AbstractBaseBO<OutmainorderEntity> {
	
	@Autowired
	private OutmainorderMapper outmainorderMapper;
	
	@Override
    protected IBaseMapper<OutmainorderEntity> getMapper() {
	    return outmainorderMapper;
    }
	public List<OutmainorderEntity> checkshipmentNumber(String shipmentNumber){
		return outmainorderMapper.checkshipmentNumber(shipmentNumber);
	}
	public List<OutmainorderEntity> checkcontractNumber(String contractNumber){
		return outmainorderMapper.checkcontractNumber(contractNumber);
	}
	public List<OutmainorderEntity> selectOutmainor(String batchNo){
		 return outmainorderMapper.selectOutmainor(batchNo);
	}

	/**
	 * 逻辑删除
	 * @param id
	 * @return
     */
	public int updateisDelete(Long id){
		return outmainorderMapper.updateisDelete(id);
	}

	/**
	 * 根据id 修改出库单状态    出库完成
	 * @param id
	 * @return
	 */
	public int updatestatustofinishById(Long id){
		return outmainorderMapper.updatestatustofinishById(id);
	}

	/**
	 * 根据id 修改出库单状态    出库中
	 * @param id
	 * @return
	 */
	public int updatestatustounderwayById(Long id){
		return outmainorderMapper.updatestatustounderwayById(id);
	}
	
	public OutmainorderEntity selectbytrayRfid(Long trayRfid){
		return outmainorderMapper.selectbytrayRfid(trayRfid);
	}

	/**
	 * 根据出库单id 查询是否存在 出库量为0的出库明细
	 * @param mainorderId
	 * @return
	 */
	public int checkquickbox(Long mainorderId){
		return outmainorderMapper.checkquickbox(mainorderId);
	}

	/**
	 * 确认出库单时判断车牌号是否跟在出库表里已确认的其他出库单重复
	 * @param plateNumber
	 * @return
	 */
	public int checkCarbystatus(String plateNumber){
		return outmainorderMapper.checkCarbystatus(plateNumber);
	}
}
