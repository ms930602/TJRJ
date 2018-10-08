
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;
import com.ms.warehouse.manage.entity.FloorinfoEntity;
import com.ms.warehouse.manage.mapper.FloorinfoMapper;

import java.util.List;


/**
 * 楼层信息 bo
 * @author dwx
 * @Date 2018-07-09 18:27:43
 * @since 1.0
 */
@Component
public class FloorinfoBO extends AbstractBaseBO<FloorinfoEntity> {
	
	@Autowired
	private FloorinfoMapper floorinfoMapper;
	
	@Override
    protected IBaseMapper<FloorinfoEntity> getMapper() {
	    return floorinfoMapper;
    }

    public List<FloorinfoEntity> checkfloorCode(String floorCode){
    	return floorinfoMapper.checkfloorCode(floorCode);
	}
	public List<FloorinfoEntity> checkfloorName(String floorName){
		return floorinfoMapper.checkfloorName(floorName);
	}
	public List<FloorinfoEntity> queryfloorlist(){
	  return floorinfoMapper.queryfloorlist();
    }

	public ListRespVO queryList() {
		return floorinfoMapper.queryList();
	};
}
