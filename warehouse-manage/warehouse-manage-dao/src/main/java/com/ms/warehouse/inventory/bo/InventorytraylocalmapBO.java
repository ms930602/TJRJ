
package com.ms.warehouse.inventory.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.inventory.entity.InventorytraylocalmapEntity;
import com.ms.warehouse.inventory.entity.OuttraylocalmapTempEntity;
import com.ms.warehouse.inventory.mapper.InventorytraylocalmapMapper;

import java.util.List;
import java.util.Map;


/**
 * 库存明细货位托盘绑定 bo
 * @author dwx
 * @Date 2018-07-25 10:22:19
 * @since 1.0
 */
@Component
public class InventorytraylocalmapBO extends AbstractBaseBO<InventorytraylocalmapEntity> {
	
	@Autowired
	private InventorytraylocalmapMapper inventorytraylocalmapMapper;
	
	@Override
    protected IBaseMapper<InventorytraylocalmapEntity> getMapper() {
	    return inventorytraylocalmapMapper;
    }

	public List<InventorytraylocalmapEntity> getInventorytraylocalmapEntityByMaterId(String materCode){
		return inventorytraylocalmapMapper.getInventorytraylocalmapEntityByMaterId(materCode);
	}
	public int updatebylocalcode(String localCode){
		return inventorytraylocalmapMapper.updatebylocalcode(localCode);
	}
	public int updatebyoldlocalcode(String localCode){
		return inventorytraylocalmapMapper.updatebyoldlocalcode(localCode);
	}
	public int batchUpdatebylocalCode(List<OuttraylocalmapTempEntity> list){
		return inventorytraylocalmapMapper.batchUpdatebylocalCode(list);
	}
	public List<InventorytraylocalmapEntity> queryByBatchNo(String batchNo){
		return inventorytraylocalmapMapper.queryByBatchNo(batchNo);
	}
	public InventorytraylocalmapEntity getInventorytraylocalmapbysoleCode(String soleCode){
		return inventorytraylocalmapMapper.getInventorytraylocalmapbysoleCode(soleCode);
	}
	public int updatebysoleCode(String soleCode){
		return inventorytraylocalmapMapper.updatebysoleCode(soleCode);
	}
	public int updatebyoldsoleCode(String soleCode){
		return inventorytraylocalmapMapper.updatebyoldsoleCode(soleCode);
	}
	public int updateStatusbysoleCode(String soleCode){
		return inventorytraylocalmapMapper.updateStatusbysoleCode(soleCode);
	}
	
	public int gettotalinventorybymatercode(String materCode,Long subverId) {
		return inventorytraylocalmapMapper.gettotalinventorybymatercode(materCode,subverId);
	}
	
	public InventorytraylocalmapEntity getTrayrfidLabel(String trayRfid){
		return inventorytraylocalmapMapper.getTrayrfidLabel(trayRfid);
	}
	
	public List<InventorytraylocalmapEntity> getlocalrfidLabel(String localRfid){
		return inventorytraylocalmapMapper.getlocalrfidLabel(localRfid);
	}
	
	public InventorytraylocalmapEntity queryByMapParam(Map<String, Object> params) {
		return inventorytraylocalmapMapper.queryByMapParam(params);
	}

	/**
	 * 根据货位id 更新库存货位绑定表 中 货位FRID
	 * @param localOrginrfid
	 * @param localNewrfid
	 */
	public void updateInventorytraylocalmapBylocalrfid(String localOrginrfid,String localNewrfid){
		inventorytraylocalmapMapper.updateInventorytraylocalmapBylocalrfid(localOrginrfid,localNewrfid);
	}
}
