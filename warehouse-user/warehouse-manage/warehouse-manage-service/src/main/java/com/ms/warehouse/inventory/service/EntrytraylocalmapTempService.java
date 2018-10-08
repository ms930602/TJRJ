package com.ms.warehouse.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.warehouse.common.exception.CenterException;
import com.ms.warehouse.common.service.BaseService;
import com.ms.warehouse.common.vo.BaseRespVO;
import com.ms.warehouse.common.vo.Param;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;
import com.ms.warehouse.inventory.bo.EntrytraylocalmapTempBO;
import com.ms.warehouse.inventory.entity.EntrytraylocalmapTempEntity;

/**
 * 托盘货位绑定信息临时 业务处理
 * @author dwf
 * @Date 2018-07-27 11:25:33
 * @since 1.0
 */@Service
public class EntrytraylocalmapTempService extends BaseService {

	@Autowired
	private EntrytraylocalmapTempBO entrytraylocalmapTempBo;

	/**
	 * 分页查询列表
	 * 
	 * @param reqVO
	 * @return
	 */
	public ListRespVO list(ListReqVO<EntrytraylocalmapTempEntity> reqVO) throws CenterException {
		return entrytraylocalmapTempBo.queryPageAutomatic(reqVO);
	}
	
	/**
	 * 根据ID查询单条记录
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object queryById(@Param("id") Long id) throws CenterException {
		return entrytraylocalmapTempBo.queryById(id);
	}

	/**
	 * 新增
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object create(EntrytraylocalmapTempEntity entrytraylocalmapTemp) throws CenterException {
		entrytraylocalmapTempBo.createForValidate(entrytraylocalmapTemp);
		return entrytraylocalmapTemp;
	}

	/**
	 * 修改
	 * 
	 * @param reqVO
	 * @return
	 */
	public BaseRespVO update(EntrytraylocalmapTempEntity entrytraylocalmapTemp) throws CenterException {
		int updateCount = entrytraylocalmapTempBo.updateForValidate(entrytraylocalmapTemp);
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
		int deleteCount = entrytraylocalmapTempBo.batchDeleteById(id);
		if (deleteCount > 0) {
			return new BaseRespVO();
		} else {
			return new BaseRespVO(2, "没有要删除的记录！");
		}
	}

}
