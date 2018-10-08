package com.ms.warehouse.inventory.service;

import com.alibaba.fastjson.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.warehouse.common.exception.CenterException;
import com.ms.warehouse.common.service.BaseService;
import com.ms.warehouse.common.vo.BaseRespVO;
import com.ms.warehouse.common.vo.Param;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;
import com.ms.warehouse.inventory.bo.InventorytraylocalmapBO;
import com.ms.warehouse.inventory.bo.OuttraylocalmapTempBO;
import com.ms.warehouse.inventory.entity.OutorderdetailEntity;
import com.ms.warehouse.inventory.entity.OuttraylocalmapTempEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * 出库单托盘货位对照关系临时 业务处理
 * @author dwf
 * @Date 2018-07-27 11:25:34
 * @since 1.0
 */@Service
public class OuttraylocalmapTempService extends BaseService {
	          
	@Autowired
	private OuttraylocalmapTempBO outtraylocalmapTempBo;
	@Autowired
	private InventorytraylocalmapBO inventorytraylocalmapBo;
	/**
	 * 分页查询列表
	 * 
	 * @param reqVO
	 * @return
	 */
	public ListRespVO list(ListReqVO<OuttraylocalmapTempEntity> reqVO) throws CenterException {
		return outtraylocalmapTempBo.queryPageAutomatic(reqVO);
	}
	
	/**
	 * 根据ID查询单条记录
	 * 
	 * @param id
	 * @return
	 */
	public Object queryById(@Param("id") Long id) throws CenterException {
		return outtraylocalmapTempBo.queryById(id);
	}

	/**
	 * 新增
	 * 
	 * @param outtraylocalmapTemp
	 * @return
	 */
	public Object create(OuttraylocalmapTempEntity outtraylocalmapTemp) throws CenterException {
		outtraylocalmapTempBo.createForValidate(outtraylocalmapTemp);
		return outtraylocalmapTemp;
	}

	/**
	 * 修改
	 * 
	 * @param outtraylocalmapTemp
	 * @return
	 */
	public BaseRespVO update(OuttraylocalmapTempEntity outtraylocalmapTemp) throws CenterException {
		int updateCount = outtraylocalmapTempBo.updateForValidate(outtraylocalmapTemp);
		/**
		 * 还原被修改库存货位的状态
         */
		inventorytraylocalmapBo.updatebylocalcode(outtraylocalmapTemp.getLocalCode());
		/**
		 * 更新 更换库存货位的状态
         */
		inventorytraylocalmapBo.updatebyoldlocalcode(outtraylocalmapTemp.getOldlocalCode());
		if(updateCount > 0){
			return new BaseRespVO();
		}else{
			return new BaseRespVO(2,"没有要修改的记录！");
		}
		
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	public BaseRespVO delete(@Param("id") Long[] id) throws CenterException {
		int deleteCount = outtraylocalmapTempBo.batchDeleteById(id);
		if (deleteCount > 0) {
			return new BaseRespVO();
		} else {
			return new BaseRespVO(2, "没有要删除的记录！");
		}
	}
	/**
	 * 删除
	 *
	 * @param temlist
	 * @return
	 */
	public BaseRespVO deletebatchbyuuids(@Param("temlist") String temlist) throws CenterException {
		List<OutorderdetailEntity> list = JSONArray.parseArray(temlist, OutorderdetailEntity.class);
		list.forEach((item)->{
			List<OuttraylocalmapTempEntity> listlocal = outtraylocalmapTempBo.querytempLocalByuuid(item.getUuid());
			if(listlocal.size()>0){
				outtraylocalmapTempBo.deletedataByuuid(item.getUuid());
				listlocal.forEach((itemlocal)->{
					inventorytraylocalmapBo.updatebyoldlocalcode(itemlocal.getLocalCode());
				});
			}
		});
		return new BaseRespVO();
	}

	/**
	 *  删除临时数据
	 * @param uuid
	 * @return
     */
	public BaseRespVO deletedataByuuid(@Param("uuid") String uuid){
		/**
		 * 获取 临时表中对应货位
         */
		List<OuttraylocalmapTempEntity> list = outtraylocalmapTempBo.querytempLocalByuuid(uuid);
//		List<String> listlocalcode = new ArrayList<>();
//		list.forEach((item)->{
//			listlocalcode.add(item.getLocalCode());
//		});
		/**
		 * 根据货位 批量还原库存货位状态
         */
//		inventorytraylocalmapBo.batchUpdatebylocalCode(list); --->暂时使用循环修改
		list.forEach((item)->{
			inventorytraylocalmapBo.updatebyoldlocalcode(item.getLocalCode());
		});
		int deleteCount = outtraylocalmapTempBo.deletedataByuuid(uuid);
		if(deleteCount > 0){
			return new BaseRespVO();
		}else{
			return new BaseRespVO(2,"没有要修改的记录！");
		}
	}

}
