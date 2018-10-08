package com.ms.warehouse.manage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.warehouse.common.exception.CenterException;
import com.ms.warehouse.common.service.BaseService;
import com.ms.warehouse.common.vo.BaseRespVO;
import com.ms.warehouse.common.vo.Param;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;
import com.ms.warehouse.manage.bo.CarrierunitBO;
import com.ms.warehouse.manage.entity.CarrierunitEntity;

import java.util.List;

/**
 * 承运单位 业务处理
 * @author dwf
 * @Date 2018-07-26 18:37:48
 * @since 1.0
 */@Service
public class CarrierunitService extends BaseService {

	@Autowired
	private CarrierunitBO carrierunitBo;

	/**
	 * 分页查询列表
	 * 
	 * @param reqVO
	 * @return
	 */
	public ListRespVO list(ListReqVO<CarrierunitEntity> reqVO) throws CenterException {
		return carrierunitBo.queryPageAutomatic(reqVO);
	}
	
	/**
	 * 根据ID查询单条记录
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object queryById(@Param("id") Long id) throws CenterException {
		return carrierunitBo.queryById(id);
	}

	/**
	 * 新增
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object create(CarrierunitEntity carrierunit) throws CenterException {
		carrierunitBo.createForValidate(carrierunit);
		return carrierunit;
	}

	/**
	 * 修改
	 * 
	 * @param reqVO
	 * @return
	 */
	public BaseRespVO update(CarrierunitEntity carrierunit) throws CenterException {
		int updateCount = carrierunitBo.updateForValidate(carrierunit);
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
		int deleteCount = carrierunitBo.batchDeleteById(id);
		if (deleteCount > 0) {
			return new BaseRespVO();
		} else {
			return new BaseRespVO(2, "没有要删除的记录！");
		}
	}

	/**
	 * 获取所有承运单位
	 * @return
     */
	public List<CarrierunitEntity> getAllCarrierunitEntity(@Param("keyword") String keyword){
		return carrierunitBo.getAllCarrierunitEntity(keyword);
	}
	
	
	/**
	 * 获取入库所有承运单位
	 * @return
     */
	public ListRespVO getAllCarrierunitEntitys(@Param("keyword") String keyword){
		
		List<CarrierunitEntity> list = carrierunitBo.getAllCarrierunitEntitys(keyword);
		ListRespVO listRespVO = new ListRespVO();
		listRespVO.setAaData(list);
		return listRespVO;
	}
	
	
	
}
