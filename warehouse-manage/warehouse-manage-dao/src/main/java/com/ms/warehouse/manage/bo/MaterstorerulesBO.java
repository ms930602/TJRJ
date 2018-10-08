
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.MaterstorerulesEntity;
import com.ms.warehouse.manage.mapper.MaterstorerulesMapper;


/**
 * 物料存放规则 bo
 * @author dwx
 * @Date 2018-07-09 18:27:43
 * @since 1.0
 */
@Component
public class MaterstorerulesBO extends AbstractBaseBO<MaterstorerulesEntity> {
	
	@Autowired
	private MaterstorerulesMapper materstorerulesMapper;
	
	@Override
    protected IBaseMapper<MaterstorerulesEntity> getMapper() {
	    return materstorerulesMapper;
    }
	/**
	 * 校验物料编码是否重复
	 * @param code
	 * @return
	 */
	public MaterstorerulesEntity checkMaterCode(String code) {
		return materstorerulesMapper.checkMaterCode(code);
	}
	/**
	 * 根据物料id查询物料存放规则
	 * @param materId
	 * @return
	 */
	public MaterstorerulesEntity queryByMaterId(long materId) {
		return materstorerulesMapper.queryByMaterId(materId);
	}
	/**
	 * 查询默认规则
	 * @return
	 */
	public MaterstorerulesEntity queryDeafultRuler() {
		return materstorerulesMapper.queryDeafultRuler();
	}
	/**
	 * 通过物料编码查询数据
	 * @param materCode
	 * @return
	 */
	public MaterstorerulesEntity queryByMaterCode(String materCode) {
		return materstorerulesMapper.queryByMaterCode(materCode);
	}
}
