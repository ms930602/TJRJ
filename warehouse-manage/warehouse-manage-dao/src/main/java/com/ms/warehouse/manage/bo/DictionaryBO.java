
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.DictionaryEntity;
import com.ms.warehouse.manage.mapper.DictionaryMapper;


/**
 * 数据字典 bo
 * @author dwx
 * @Date 2018-07-09 18:27:45
 * @since 1.0
 */
@Component
public class DictionaryBO extends AbstractBaseBO<DictionaryEntity> {
	
	@Autowired
	private DictionaryMapper dictionaryMapper;
	
	@Override
    protected IBaseMapper<DictionaryEntity> getMapper() {
	    return dictionaryMapper;
    }
}
