
package com.ms.warehouse.common.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.entity.DictionariesEntity;
import com.ms.warehouse.common.mapper.DictionariesMapper;
import com.ms.warehouse.common.mapper.IBaseMapper;


/**
 * 数据字典 bo
 * @author lansongtao
 * @Date 2017-12-14 10:56:26
 * @since 1.0
 */
@Component
public class DictionariesBO extends AbstractBaseBO<DictionariesEntity> {
	
	@Autowired
	private DictionariesMapper dictionariesMapper;
	
	@Override
    protected IBaseMapper<DictionariesEntity> getMapper() {
	    return dictionariesMapper;
    }
}
