
package com.ms.warehouse.inventory.mapper;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.inventory.entity.OuttraylocalmapEntity;

/**
 * 出库单托盘货位对照关系 Mapper
 * @author dwx
 * @Date 2018-07-25 10:22:20
 * @since 1.0
 */
@Repository
public interface OuttraylocalmapMapper extends IBaseMapper<OuttraylocalmapEntity>{
	List<OuttraylocalmapEntity> queryByBatchNo(String batchNo);
	List<OuttraylocalmapEntity> getcalculateoutoquality(Long orderdetailId);
	List<OuttraylocalmapEntity> queryLocalByorderdetailId(Long orderdetailId);
	int deleteByorderdetailId(Long orderdetailId);
	List<OuttraylocalmapEntity> querylocalmapbyorderdetailId(Long orderdetailId);
	
	/**
	 * @Description:根据detail_id删除绑定信息
	 * @param orderdetailId
	 * @return 
	 */
	Object deleteByOrderdetailId (Long orderdetailId);

	/**
	 * 根据solecode 获取出库货位信息
	 * @param trayRfid
	 * @return
     */
	OuttraylocalmapEntity getOuttraylocalmap(String trayRfid);
	/**
	 * 根据soleCode修改出库货位状态
	 * @param soleCode
	 * @return
	 */
	void updateOuttraylocalmapStatus(String soleCode);

	/**
	 * 根据出库单id 判断该出库单对应的出库货位是否已出库完成
	 * @param mainorderId
	 * @return
     */
	int querycountBymainorderId(long mainorderId);
	
	
	List<OuttraylocalmapEntity> queryByotdPage(ListReqVO reqVO);
    int queryotdCount(ListReqVO reqVO);

	/**
	 * 根据明细id 逻辑删除出库货位绑定信息
	 * @param orderdetailId
     */
	void updateisDeleteBydetailId(long orderdetailId);

	/**
	 * 根据货位id 更新出库货位绑定表 中 货位FRID
	 * @param localOrginrfid
	 * @param localNewrfid
     */
	void updateoutlampBylocalrfid(String localOrginrfid,String localNewrfid);
}
