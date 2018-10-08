
package com.ms.warehouse.manage.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.common.vo.Param;
import com.ms.warehouse.manage.entity.PackspecEntity;
import com.ms.warehouse.manage.entity.SubversionEntity;
import com.ms.warehouse.manage.mapper.SubversionMapper;


/**
 * 子版本管理 bo
 * @author Ms
 * @Date 2018-08-24 15:46:09
 * @since 1.0
 */
@Component
public class SubversionBO extends AbstractBaseBO<SubversionEntity> {
	
	@Autowired
	private SubversionMapper subversionMapper;
	
	@Override
    protected IBaseMapper<SubversionEntity> getMapper() {
	    return subversionMapper;
    }

	public List<PackspecEntity> checkSubverName(String subverName) {
		// TODO Auto-generated method stub
		return subversionMapper.checkSubverName(subverName);
	}

	public List<SubversionEntity> queryMaterSub(@Param("materCode") String materCode) {
		// TODO Auto-generated method stub
		return subversionMapper.queryMaterSub(materCode);
	}

	public List<SubversionEntity> queryListNotMater(@Param("materCode") String materCode) {
		// TODO Auto-generated method stub
		return subversionMapper.queryListNotMater(materCode);
	}
	/**
	 * 根据卷烟编号 获取对应子版本
	 * @param materCode
	 * @return
	 */
	public List<SubversionEntity> querysubBymaterCode(String materCode){
		return subversionMapper.querysubBymaterCode(materCode);
	}
}
