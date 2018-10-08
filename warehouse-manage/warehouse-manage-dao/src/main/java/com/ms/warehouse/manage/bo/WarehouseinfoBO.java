
package com.ms.warehouse.manage.bo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.WarehouseinfoEntity;
import com.ms.warehouse.manage.mapper.WarehouseinfoMapper;


/**
 * 仓库信息 bo
 * @author dwx
 * @Date 2018-07-09 18:27:44
 * @since 1.0
 */
@Component
public class WarehouseinfoBO extends AbstractBaseBO<WarehouseinfoEntity> {
	
	@Autowired
	private WarehouseinfoMapper warehouseinfoMapper;
	
	@Override
    protected IBaseMapper<WarehouseinfoEntity> getMapper() {
	    return warehouseinfoMapper;
    }

	public List<WarehouseinfoEntity> queryendproduct(String keyword){
		return  warehouseinfoMapper.queryendproduct(keyword);
	}
    /**
     * 通过条件查询对象
     * @param params
     * @return
     */
    public WarehouseinfoEntity queyByMapsParams(Map<String, Object> params) {
    	return warehouseinfoMapper.queyByMapsParams(params);
    }
    /**
     * 查询最大已生成的编码
     * @return
     */
    public String queryMaxWarCode() {
    	return warehouseinfoMapper.queryMaxWarCode();
    }
}
