
package com.ms.warehouse.inventory.mapper;

import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.inventory.entity.EntryorderdetailEntity;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 入库单详情信息 Mapper
 * @author dwx
 * @Date 2018-07-25 10:22:18
 * @since 1.0
 */
@Repository
public interface EntryorderdetailMapper extends IBaseMapper<EntryorderdetailEntity>{

    List<EntryorderdetailEntity> queryProTrackByPage(ListReqVO reqVO);
    int queryProTrackCount(ListReqVO reqVO);
    List<EntryorderdetailEntity> queryBymainId(Long mainorderId);
	int deleteByMainId(Long id);	

}
