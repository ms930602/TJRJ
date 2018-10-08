
package com.ms.warehouse.inventory.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.inventory.entity.OuttraylocalmapTempEntity;
import com.ms.warehouse.inventory.mapper.OuttraylocalmapTempMapper;

import java.util.List;


/**
 * 出库单托盘货位对照关系临时 bo
 * @author dwf
 * @Date 2018-07-27 11:25:34
 * @since 1.0
 */
@Component
public class OuttraylocalmapTempBO extends AbstractBaseBO<OuttraylocalmapTempEntity> {
	
	@Autowired
	private OuttraylocalmapTempMapper outtraylocalmapTempMapper;
	
	@Override
    protected IBaseMapper<OuttraylocalmapTempEntity> getMapper() {
	    return outtraylocalmapTempMapper;
    }

    public int deletedataByuuid(String uuid){
    	return outtraylocalmapTempMapper.deletedataByuuid(uuid);
	}
	public List<OuttraylocalmapTempEntity> querytempLocalByuuid(String uuid){
		return outtraylocalmapTempMapper.querytempLocalByuuid(uuid);
	}
	public List<OuttraylocalmapTempEntity> queryTempByuuid(String uuid){
		return outtraylocalmapTempMapper.queryTempByuuid(uuid);
	}
	public List<OuttraylocalmapTempEntity>tempcalculateoutoquality(String uuid){
		return outtraylocalmapTempMapper.tempcalculateoutoquality(uuid);
	}
}
