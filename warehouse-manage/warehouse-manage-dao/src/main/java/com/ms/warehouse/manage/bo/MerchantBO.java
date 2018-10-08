
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.MerchantEntity;
import com.ms.warehouse.manage.mapper.MerchantMapper;

import java.util.List;
import java.util.Map;


/**
 * 客商信息 bo
 * @author dwf
 * @Date 2018-07-26 18:37:47
 * @since 1.0
 */
@Component
public class MerchantBO extends AbstractBaseBO<MerchantEntity> {
	
	@Autowired
	private MerchantMapper merchantMapper;
	
	@Override
    protected IBaseMapper<MerchantEntity> getMapper() {
	    return merchantMapper;
    }
    public List<MerchantEntity> getAllMerchantEntitycustomer(String keyword){
    	return merchantMapper.getAllMerchantEntitycustomer(keyword);
	}
	public List<MerchantEntity> getAllMerchantEntitytravellingtrader(String keyword){
		return merchantMapper.getAllMerchantEntitytravellingtrader(keyword);
	}
	/**
	 * 通过条件查询
	 * @param params
	 * @return
	 */
	public MerchantEntity queyByMapsParams(Map<String, Object> params) {
		return merchantMapper.queyByMapsParams(params);
	}
	/**
	 * 查询最大编码信息
	 * @return
	 */
	public String queryMaxWarCode() {
		return merchantMapper.queryMaxWarCode();
	}
}
