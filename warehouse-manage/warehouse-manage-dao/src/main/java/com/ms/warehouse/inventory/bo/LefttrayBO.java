
package com.ms.warehouse.inventory.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.inventory.entity.LefttrayEntity;
import com.ms.warehouse.inventory.mapper.LefttrayMapper;


/**
 * 尾盘 bo
 * @author dwx
 * @Date 2018-07-25 11:29:59
 * @since 1.0
 */
@Component
public class LefttrayBO extends AbstractBaseBO<LefttrayEntity> {
	
	@Autowired
	private LefttrayMapper lefttrayMapper;
	
	@Override
    protected IBaseMapper<LefttrayEntity> getMapper() {
	    return lefttrayMapper;
    }
	public LefttrayEntity queryLefttrayBymatercode(String materCode) {
		return lefttrayMapper.queryLefttrayBymatercode(materCode);
	}

	/**
	 * 根据物料编号 获取暂存区域对象信息
	 * @param materCode
	 * @return
     */
	public LefttrayEntity querybymatercode(String materCode,Long subverId){
		return lefttrayMapper.querybymatercode(materCode,subverId);
	}
}
