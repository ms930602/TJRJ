
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.AreainfoEntity;
import com.ms.warehouse.manage.mapper.AreainfoMapper;

import java.util.List;


/**
 * 仓库区域管理 bo
 * @author dwx
 * @Date 2018-07-09 18:27:43
 * @since 1.0
 */
@Component
public class AreainfoBO extends AbstractBaseBO<AreainfoEntity> {
	
	@Autowired
	private AreainfoMapper areainfoMapper;
	
	@Override
    protected IBaseMapper<AreainfoEntity> getMapper() {
	    return areainfoMapper;
    }
	public List<AreainfoEntity> queryarealist(){
		return areainfoMapper.queryarealist();
	}
	public List<AreainfoEntity> checkAreaCode(String areaCode){
		return areainfoMapper.checkareaCode(areaCode);
	}
	public AreainfoEntity queryfloorcodebyareaid(long id){
		return areainfoMapper.queryfloorcodebyareaid(id);
	}
}
