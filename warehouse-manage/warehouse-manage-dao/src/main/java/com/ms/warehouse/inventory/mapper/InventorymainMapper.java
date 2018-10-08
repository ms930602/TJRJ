
package com.ms.warehouse.inventory.mapper;

import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.inventory.entity.InventoryAllEntity;
import com.ms.warehouse.inventory.entity.InventorymainEntity;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 库存主 Mapper
 * @author dwx
 * @Date 2018-07-25 10:22:19
 * @since 1.0
 */
@Repository
public interface InventorymainMapper extends IBaseMapper<InventorymainEntity>{
	List<InventorymainEntity> querymaindetail(ListReqVO<InventorymainEntity> reqVO);
	int querymaindetailcount(ListReqVO<InventorymainEntity> reqVO);
	List<InventorymainEntity> selectInventory(String batchNo);
	
	List<InventorymainEntity> queryILByPage(ListReqVO reqVO);
    int queryILCount(ListReqVO reqVO);

	/**
	 *根据编号查对象
	 * @param materCode
	 * @return
     */
	InventorymainEntity querymainBymatercode(String materCode,Long subverId);

	/**
	 * 不合格 弹窗列表数据
	 * @param reqVO
	 * @return
     */
	List<InventorymainEntity> queryAlldetails(ListReqVO<InventorymainEntity> reqVO);
	/**
	 * 不合格 弹窗列表数据个数
	 * @param reqVO
	 * @return
	 */
	int	queryAlldetailscount(ListReqVO<InventorymainEntity> reqVO);
}
