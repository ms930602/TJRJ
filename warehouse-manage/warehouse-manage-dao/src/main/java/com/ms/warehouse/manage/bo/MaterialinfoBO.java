
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.MaterialinfoEntity;
import com.ms.warehouse.manage.mapper.MaterialinfoMapper;

import java.util.List;
import java.util.Map;


/**
 * 物料信息 bo
 * @author dwx
 * @Date 2018-07-09 18:27:43
 * @since 1.0
 */
@Component
public class MaterialinfoBO extends AbstractBaseBO<MaterialinfoEntity> {
	
	@Autowired
	private MaterialinfoMapper materialinfoMapper;
	
	@Override
    protected IBaseMapper<MaterialinfoEntity> getMapper() {
	    return materialinfoMapper;
    }

	public List<MaterialinfoEntity> queryAlllist(){
		return materialinfoMapper.queryAlllist();
	}
	public MaterialinfoEntity queryByMaterCode(String materCode){
		return materialinfoMapper.queryByMaterCode(materCode);
	}
	/**
	 * 通过名称和版本查询
	 * @param materName
	 * @return
	 */
	public MaterialinfoEntity queryByName(Map<String, Object> params) {
		return materialinfoMapper.queryByName(params);
	}
}
