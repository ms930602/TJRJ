
package com.ms.warehouse.inventory.mapper;

import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.inventory.entity.OutorderdetailEntity;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 出库单详情 Mapper
 * @author dwx
 * @Date 2018-07-25 10:22:19
 * @since 1.0
 */
@Repository
public interface OutorderdetailMapper extends IBaseMapper<OutorderdetailEntity>{
    /**
     * 根据参数   获取出库明细
     * @param mainorderId
     * @return
     */
    List<OutorderdetailEntity> getoutorderdetaillist(Long mainorderId);

    /**
     * 根据订单ID 删除出库明细
     * @param mainorderId
     * @return
     */
    int deleteBymainorderId(Long mainorderId);

    /**
     * 根据出库单id获取 明细列表
     * @param mainorderId
     * @return
     */
    List<OutorderdetailEntity> queryBymainId(Long mainorderId);

    /**
     * 根据出库单id 获取出库明细总数
     * @param mainorderId
     * @return
     */
    BigDecimal getdetailTotal(Long mainorderId);

    /**
     * 逻辑删除明细 根据出库单Id
     * @param mainorderId
     */
    void updateisDeletebymainorderId(Long mainorderId);

    /**
     *  出库统计主要统计某一天出库的每种规格的烟的数量。
        以Echart的Pie图（饼图）展示，且要将查询结果以列表展示出来。
        查询条件：【日期，只能选择某一天，年月日】
     * @param createDate
     * @return
     */
    List<OutorderdetailEntity> outgoingStatistics(Date createDate);
}
