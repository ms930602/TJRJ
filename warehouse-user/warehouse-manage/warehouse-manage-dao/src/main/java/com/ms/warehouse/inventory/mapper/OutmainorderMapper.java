
package com.ms.warehouse.inventory.mapper;

import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.inventory.entity.OutmainorderEntity;

import java.util.List;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 出库单主 Mapper
 * @author dwx
 * @Date 2018-07-25 10:22:19
 * @since 1.0
 */
@Repository
public interface OutmainorderMapper extends IBaseMapper<OutmainorderEntity>{
	
	OutmainorderEntity selectbytrayRfid(Long trayRfid);
	List<OutmainorderEntity> checkshipmentNumber(String shipmentNumber);

    List<OutmainorderEntity> checkcontractNumber(String contractNumber);
	List<OutmainorderEntity> selectOutmainor(String batchNo);

	/**
	 * 逻辑删除订单
	 * @param id
	 * @return
     */
	int updateisDelete(Long id);

	/**
	 * 根据id 修改出库单状态    出库完成
	 * @param id
	 * @return
     */
	int updatestatustofinishById(Long id);

	/**
	 * 根据id 修改出库单状态    出库中
	 * @param id
	 * @return
     */
	int updatestatustounderwayById(Long id);

	/**
	 * 根据出库单id 查询是否存在 出库量为0的出库明细
	 * @param mainorderId
	 * @return
     */
	int checkquickbox(Long mainorderId);

	/**
	 * 确认出库单时判断车牌号是否跟在出库表里已确认的其他出库单重复
	 * @param plateNumber
	 * @return
     */
	int checkCarbystatus(String plateNumber);
}
