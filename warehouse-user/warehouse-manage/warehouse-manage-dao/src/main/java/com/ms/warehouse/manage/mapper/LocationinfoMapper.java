
package com.ms.warehouse.manage.mapper;

import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.LocationinfoEntity;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 货位信息 Mapper
 * @author dwx
 * @Date 2018-07-09 18:27:43
 * @since 1.0
 */
@Repository
public interface LocationinfoMapper extends IBaseMapper<LocationinfoEntity>{
    List<LocationinfoEntity> checklocationcode(String localCode);

    List<LocationinfoEntity> checkRFID(String localRfid);
    List<LocationinfoEntity> queryAllLocationInfo();
    List<LocationinfoEntity> queryFreeRowBygroupNoBefore(LocationinfoEntity enty);
    List<LocationinfoEntity> queryFreeRowBygroupNoAfter(LocationinfoEntity enty);
    List<LocationinfoEntity> queryListByFloor(LocationinfoEntity enty);
    List<Map<String,Object>> queryFiveFreeLocals();
    List<LocationinfoEntity> querynobindlocal();
    int updategroupno(LocationinfoEntity enty);
    List<Map<String,Object>>queryfreeblock();

    /**
     * 根据货位id 更新货位表 中 货位FRID
     * @param localOrginrfid
     * @param localNewrfid
     */
    void updatelocationinfoBylocalrfid(String localOrginrfid,String localNewrfid);
}
