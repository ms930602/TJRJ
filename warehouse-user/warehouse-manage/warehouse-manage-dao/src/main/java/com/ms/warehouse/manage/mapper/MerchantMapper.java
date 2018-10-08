
package com.ms.warehouse.manage.mapper;

import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.MerchantEntity;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 客商信息 Mapper
 * @author dwf
 * @Date 2018-07-26 18:37:47
 * @since 1.0
 */
@Repository
public interface MerchantMapper extends IBaseMapper<MerchantEntity>{
	List<MerchantEntity> getAllMerchantEntitycustomer(String keyword);
	List<MerchantEntity> getAllMerchantEntitytravellingtrader(String keyword);
	/**
	 * 通过条件查询
	 * @param params
	 * @return
	 */
	MerchantEntity queyByMapsParams(Map<String, Object> params);
	/**
	 * 查询最大编码信息
	 * @return
	 */
	String queryMaxWarCode();
}
