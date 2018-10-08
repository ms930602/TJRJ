package com.ms.warehouse.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.warehouse.common.exception.CenterException;
import com.ms.warehouse.common.service.BaseService;
import com.ms.warehouse.common.vo.BaseRespVO;
import com.ms.warehouse.common.vo.Param;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;
import com.ms.warehouse.inventory.bo.EntrymainorderBO;
import com.ms.warehouse.inventory.entity.EntrymainorderEntity;

/**
 * 入库单主 业务处理
 * @author dwx
 * @Date 2018-07-25 10:22:18
 * @since 1.0
 */@Service
public class EntrymainorderService extends BaseService {

	@Autowired
	private EntrymainorderBO entrymainorderBo;

	/**
	 * 分页查询列表
	 * 
	 * @param reqVO
	 * @return
	 */
	public ListRespVO list(ListReqVO<EntrymainorderEntity> reqVO) throws CenterException {
		return entrymainorderBo.queryPageAutomatic(reqVO);
	}
	
	/**
	 * 根据ID查询单条记录
	 * 
	 * @param id
	 * @return
	 */
	public Object queryById(@Param("id") Long id) throws CenterException {
		return entrymainorderBo.queryById(id);
	}

	/**
	 * 新增
	 * 
	 * @param entrymainorder
	 * @return
	 */
	public Object create(EntrymainorderEntity entrymainorder) throws CenterException {
		entrymainorderBo.createForValidate(entrymainorder);
		return entrymainorder;
	}

	/**
	 * 修改
	 * 
	 * @param entrymainorder
	 * @return
	 */
	public BaseRespVO update(EntrymainorderEntity entrymainorder) throws CenterException {
		int updateCount = entrymainorderBo.updateForValidate(entrymainorder);
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
		int deleteCount = entrymainorderBo.batchDeleteById(id);
		if (deleteCount > 0) {
			return new BaseRespVO();
		} else {
			return new BaseRespVO(2, "没有要删除的记录！");
		}
	}

	
	/**
	 * 根据批次号查询入库信息
	 * 
	 * @param batchNo
	 * @return
	 */
	public List<EntrymainorderEntity> selectEntrymainor(@Param("batchNo") String batchNo){
		return entrymainorderBo.selectEntrymainor(batchNo);
	}
	
	/**
	 * 根据托盘rfid查询入库信息
	 * 
	 * @param batchNo
	 * @return
	 */
	public EntrymainorderEntity selectbytrayRfid(@Param("trayRfid") String trayRfid){
		return entrymainorderBo.selectbytrayRfid(trayRfid);
	}
}
