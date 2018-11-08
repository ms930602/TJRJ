package com.ms.warehouse.car.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.warehouse.common.exception.CenterException;
import com.ms.warehouse.common.service.BaseService;
import com.ms.warehouse.common.vo.BaseRespVO;
import com.ms.warehouse.common.vo.Param;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;
import com.ms.warehouse.inventory.bo.BaseUploadfilerecodeBO;
import com.ms.warehouse.inventory.entity.BaseUploadfilerecodeEntity;
import com.ms.warehouse.car.bo.CarInfoBO;
import com.ms.warehouse.car.entity.CarInfoEntity;
import com.ms.warehouse.car.entity.CarInfoForm;

/**
 *  业务处理
 * @author Ms
 * @Date 2018-11-02 14:43:19
 * @since 1.0
 */@Service
public class CarInfoService extends BaseService {

	@Autowired
	private CarInfoBO carInfoBo;
	
	@Autowired
	private BaseUploadfilerecodeBO baseUploadfilerecodeBO;

	/**
	 * 分页查询列表
	 * 
	 * @param reqVO
	 * @return
	 */
	public ListRespVO list(ListReqVO<CarInfoEntity> reqVO) throws CenterException {
		return carInfoBo.queryPageAutomatic(reqVO);
	}
	
	/**
	 * 根据ID查询单条记录
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object queryById(@Param("id") Long id) throws CenterException{
		CarInfoEntity entity = carInfoBo.queryById(id);
		if(entity == null) return null;
		CarInfoForm carInfoForm = new CarInfoForm(entity);
		
		String topImg = entity.getTopImg();
		BaseUploadfilerecodeEntity topImageObj = null;
		if(topImg != null)topImageObj = baseUploadfilerecodeBO.queryById(Long.parseLong(topImg));
		
		String detailImg = entity.getImgs();
		List<BaseUploadfilerecodeEntity> detailImgs = null;
		if(detailImg != null)detailImgs = baseUploadfilerecodeBO.queryByIds(detailImg);
		
		carInfoForm.setTopImgObj(topImageObj);
		carInfoForm.setDetailImgObj(detailImgs);
		
		return carInfoForm;
	}

	/**
	 * 新增
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object create(CarInfoEntity carInfo) throws CenterException {
		carInfoBo.createForValidate(carInfo);
		return carInfo;
	}

	/**
	 * 修改
	 * 
	 * @param reqVO
	 * @return
	 */
	public BaseRespVO update(CarInfoEntity carInfo) throws CenterException {
		int updateCount = carInfoBo.updateForValidate(carInfo);
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
		int deleteCount = carInfoBo.batchDeleteById(id);
		if (deleteCount > 0) {
			return new BaseRespVO();
		} else {
			return new BaseRespVO(2, "没有要删除的记录！");
		}
	}

}
