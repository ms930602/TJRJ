
package com.ms.warehouse.inventory.bo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.inventory.entity.EntrytraylocalmapEntity;
import com.ms.warehouse.inventory.mapper.EntrytraylocalmapMapper;


/**
 * 托盘货位绑定信息 bo
 * @author dwx
 * @Date 2018-07-25 10:22:18
 * @since 1.0
 */
@Component
public class EntrytraylocalmapBO extends AbstractBaseBO<EntrytraylocalmapEntity> {
	
	@Autowired
	private EntrytraylocalmapMapper entrytraylocalmapMapper;
	
	@Override
    protected IBaseMapper<EntrytraylocalmapEntity> getMapper() {
	    return entrytraylocalmapMapper;
    }
	
	public List<EntrytraylocalmapEntity> queryByBatchNo(String batchNo){
		return entrytraylocalmapMapper.queryByBatchNo(batchNo);
	}

	public List<EntrytraylocalmapEntity> getEntryStatus(String rfid){
		return entrytraylocalmapMapper.getEntryStatus(rfid);
	}

	public EntrytraylocalmapEntity queryByRfid(Map<String, Object> map) {
		return entrytraylocalmapMapper.queryByRfid(map);
	}

	public int updateStatus(long id) {
		return entrytraylocalmapMapper.updateStatus(id);
	}

	public EntrytraylocalmapEntity queryStaById(long id) {
		return entrytraylocalmapMapper.queryStaById(id);
	}
	

	/**
	 * 通过条件更新对象
	 * @param params
	 * @return
	 */
	public int updateEntrytraylocalmap(Map<String, Object> params) {
		return entrytraylocalmapMapper.updateEntrytraylocalmap(params);
	}
	/**
	 * 通过map条件查询对象数据
	 * @param params
	 * @return
	 */
	public EntrytraylocalmapEntity queryByMapsParam(Map<String, Object> params) {
		return entrytraylocalmapMapper.queryByMapsParam(params);
	}
	/**
	 * 查询rfid为空的集合
	 * @return
	 */
	public List<EntrytraylocalmapEntity> queryNullTrayRfidList(Map<String, Object> params){
		return entrytraylocalmapMapper.queryNullTrayRfidList(params);
	}
}
