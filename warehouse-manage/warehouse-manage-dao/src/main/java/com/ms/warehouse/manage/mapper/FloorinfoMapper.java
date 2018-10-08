
package com.ms.warehouse.manage.mapper;

import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;
import com.ms.warehouse.manage.entity.FloorinfoEntity;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 楼层信息 Mapper
 * @author dwx
 * @Date 2018-07-09 18:27:43
 * @since 1.0
 */
@Repository
public interface FloorinfoMapper extends IBaseMapper<FloorinfoEntity>{

     List<FloorinfoEntity> checkfloorCode(String floorCode);
     List<FloorinfoEntity> checkfloorName(String floorName);
     List<FloorinfoEntity> queryfloorlist();
     ListRespVO queryList();
}
