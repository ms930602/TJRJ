
package com.ms.warehouse.manage.bo;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.exception.CenterException;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.PackspecEntity;
import com.ms.warehouse.manage.mapper.PackspecMapper;


/**
 * 包装规格 bo
 * @author dwx
 * @Date 2018-07-09 18:27:44
 * @since 1.0
 */
@Component
public class PackspecBO extends AbstractBaseBO<PackspecEntity> {
	
	@Autowired
	private PackspecMapper packspecMapper;
	
	@Override
    protected IBaseMapper<PackspecEntity> getMapper() {
	    return packspecMapper;
    }
	
	/**
	 * 判断主数据ID重复
	 * @param areaCode
	 * @return
	 * @throws CenterException
     */
	public List<PackspecEntity> checkPackspecDataId(String code) throws CenterException {
		HashMap<String, String> query = new HashMap<String, String>();
		query.put("dataId", code);
		query.put("pacsCode", null);
		return packspecMapper.checkPackspecCode(query);
	}
	
	/**
	 * 判断代码重复
	 * @param areaCode
	 * @return
	 * @throws CenterException
     */
	public List<PackspecEntity> checkPackspecPacsCode(String code) throws CenterException {
		HashMap<String, String> query = new HashMap<String, String>();
		query.put("dataId", null);
		query.put("pacsCode", code);
		return packspecMapper.checkPackspecCode(query);
	}
}
