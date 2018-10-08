
package com.ms.warehouse.inventory.mapper;

import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.inventory.entity.InventorytraylocalmapEntity;
import com.ms.warehouse.inventory.entity.OuttraylocalmapTempEntity;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 库存明细货位托盘绑定 Mapper
 * @author dwx
 * @Date 2018-07-25 10:22:19
 * @since 1.0
 */
@Repository
public interface InventorytraylocalmapMapper extends IBaseMapper<InventorytraylocalmapEntity>{
    List<InventorytraylocalmapEntity> getInventorytraylocalmapEntityByMaterId(String materCode);
    List<InventorytraylocalmapEntity> queryByBatchNo(String batchNo);
    int updatebylocalcode(String localCode);
    int updatebyoldlocalcode(String localCode);
    int batchUpdatebylocalCode(List<OuttraylocalmapTempEntity> list);
    InventorytraylocalmapEntity getInventorytraylocalmapbysoleCode(String soleCode);

    int updatebysoleCode(String soleCode);
    int updatebyoldsoleCode(String soleCode);
    int updateStatusbysoleCode(String soleCode);
    int gettotalinventorybymatercode(@Param("materCode") String materCode, @Param("subverId") Long subverId);
    
    InventorytraylocalmapEntity getTrayrfidLabel(String trayRfid);
    List<InventorytraylocalmapEntity> getlocalrfidLabel(String localRfid);
    
    InventorytraylocalmapEntity queryByMapParam(Map<String, Object> params);

    /**
     * 根据货位id 更新库存货位绑定表 中 货位FRID
     * @param localOrginrfid
     * @param localNewrfid
     */
    void updateInventorytraylocalmapBylocalrfid(String localOrginrfid,String localNewrfid);
}
