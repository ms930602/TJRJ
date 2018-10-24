package com.ms.warehouse.manage.service;

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
import com.ms.warehouse.manage.bo.VxActivitiesBO;
import com.ms.warehouse.manage.entity.VxActivitiesEntity;
import com.ms.warehouse.manage.entity.VxActivitiesFormEntity;

/**
 *  业务处理
 * @author Ms
 * @Date 2018-10-21 19:40:49
 * @since 1.0
 */@Service
public class VxActivitiesService extends BaseService {

	@Autowired
	private VxActivitiesBO vxActivitiesBo;
	
	@Autowired
	private BaseUploadfilerecodeBO baseUploadfilerecodeBO;

	/**
	 * 分页查询列表
	 * 
	 * @param reqVO
	 * @return
	 */
	public ListRespVO list(ListReqVO<VxActivitiesEntity> reqVO) throws CenterException {
		return vxActivitiesBo.queryPageAutomatic(reqVO);
	}
	
	/**
	 * 根据ID查询单条记录
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object queryById(@Param("id") Long id) throws CenterException {
		VxActivitiesEntity entity = vxActivitiesBo.queryById(id);
		VxActivitiesFormEntity formEntity = new VxActivitiesFormEntity();
		
		Long mp3Id = entity.getMp3Id();
		BaseUploadfilerecodeEntity mp3Obj = null;
		if(mp3Id != null)mp3Obj = baseUploadfilerecodeBO.queryById(mp3Id);
		
		Long topImg = entity.getTopImg();
		BaseUploadfilerecodeEntity topImageObj = null;
		if(topImg != null)topImageObj = baseUploadfilerecodeBO.queryById(topImg);
		
		String detailImg = entity.getDetailImg();
		List<BaseUploadfilerecodeEntity> detailImgs = null;
		if(detailImg != null)detailImgs = baseUploadfilerecodeBO.queryByIds(detailImg);
		
		formEntity.copy(entity);
		formEntity.setMusicObj(mp3Obj);
		formEntity.setTopImgObj(topImageObj);
		formEntity.setDetailImgObj(detailImgs);
		
		return formEntity;
	}

	/**
	 * 新增
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object create(VxActivitiesEntity vxActivities) throws CenterException {
		vxActivitiesBo.createForValidate(vxActivities);
		return vxActivities;
	}

	/**
	 * 修改
	 * 
	 * @param reqVO
	 * @return
	 */
	public BaseRespVO update(VxActivitiesEntity vxActivities) throws CenterException {
		int updateCount = vxActivitiesBo.updateForValidate(vxActivities);
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
		int deleteCount = vxActivitiesBo.batchDeleteById(id);
		if (deleteCount > 0) {
			return new BaseRespVO();
		} else {
			return new BaseRespVO(2, "没有要删除的记录！");
		}
	}
	
	

}
