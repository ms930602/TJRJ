
package com.ms.warehouse.inventory.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.inventory.entity.UnqualifiedproductEntity;
import com.ms.warehouse.inventory.mapper.UnqualifiedproductMapper;


/**
 * 不合格品 bo
 * @author dwx
 * @Date 2018-07-25 10:22:21
 * @since 1.0
 */
@Component
public class UnqualifiedproductBO extends AbstractBaseBO<UnqualifiedproductEntity> {
	
	@Autowired
	private UnqualifiedproductMapper unqualifiedproductMapper;
	
	@Override
    protected IBaseMapper<UnqualifiedproductEntity> getMapper() {
	    return unqualifiedproductMapper;
    }
	
	public List<UnqualifiedproductEntity> queryByBatchNo(String batchNo){
		 return unqualifiedproductMapper.queryByBatchNo(batchNo);
	}
}
