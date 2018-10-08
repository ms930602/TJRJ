
package com.ms.warehouse.inventory.bo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.inventory.entity.EntrymainorderEntity;
import com.ms.warehouse.inventory.mapper.EntrymainorderMapper;


/**
 * 入库单主 bo
 * @author dwx
 * @Date 2018-07-25 10:22:17
 * @since 1.0
 */
@Component
public class EntrymainorderBO extends AbstractBaseBO<EntrymainorderEntity> {
	
	@Autowired
	private EntrymainorderMapper entrymainorderMapper;
	
	@Override
    protected IBaseMapper<EntrymainorderEntity> getMapper() {
	    return entrymainorderMapper;
    }
	
	public List<EntrymainorderEntity> selectEntrymainor(String batchNo) {
	    return entrymainorderMapper.selectEntrymainor(batchNo);
    }
	
	public EntrymainorderEntity selectbytrayRfid(String trayRfid) {
	    return entrymainorderMapper.selectbytrayRfid(trayRfid);
    }

	public int queryStaById(Long mainorderId) {
		return entrymainorderMapper.queryStaById(mainorderId);
	}

	public int updateStatus(HashMap<String, Object> map) {
		return entrymainorderMapper.updateStatus(map);
	}

	/**
	 * 根据map查询入库单主体集合
	 * @return
	 */
	public List<EntrymainorderEntity> selectEntrymainorderList(Map<String, Object> params){
		return entrymainorderMapper.selectEntrymainorderList(params);
	}

	public List<EntrymainorderEntity> checkshipmentNumber(String shipmentNumber) {
		return entrymainorderMapper.checkshipmentNumber(shipmentNumber);
	}

	public List<EntrymainorderEntity> checkcontractNumber(String contractNumber) {
		return entrymainorderMapper.checkcontractNumber(contractNumber);
	}

	public int checkPlate(String plateNumber) {
		return entrymainorderMapper.checkPlate(plateNumber);
	}

}
