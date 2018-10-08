
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.TarvalegradeEntity;
import com.ms.warehouse.manage.mapper.TarvalegradeMapper;


/**
 * 卷烟焦油量档次 bo
 * @author dwx
 * @Date 2018-07-09 18:27:44
 * @since 1.0
 */
@Component
public class TarvalegradeBO extends AbstractBaseBO<TarvalegradeEntity> {
	
	@Autowired
	private TarvalegradeMapper tarvalegradeMapper;
	
	@Override
    protected IBaseMapper<TarvalegradeEntity> getMapper() {
	    return tarvalegradeMapper;
    }
}