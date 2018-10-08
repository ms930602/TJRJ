
package com.ms.warehouse.manage.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.PasswayEntity;
import com.ms.warehouse.manage.mapper.PasswayMapper;


/**
 * 仓库通道管理 bo
 * @author dwx
 * @Date 2018-07-11 10:28:41
 * @since 1.0
 */
@Component
public class PasswayBO extends AbstractBaseBO<PasswayEntity> {
	
	@Autowired
	private PasswayMapper passwayMapper;
	
	@Override
    protected IBaseMapper<PasswayEntity> getMapper() {
	    return passwayMapper;
    }
 
    public List<PasswayEntity> checkpassNo(String passNo){
    	return passwayMapper.checkpassNo(passNo);
	}
	public  List<PasswayEntity> checkpassName(String passName){
		return passwayMapper.checkpassName(passName);
	};
	public  List<PasswayEntity> queryoutPassway(){
		return passwayMapper.queryoutPassway();
	};

}
