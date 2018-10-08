package com.ms.warehouse.manage.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.warehouse.common.exception.CenterException;
import com.ms.warehouse.common.service.BaseService;
import com.ms.warehouse.common.vo.BaseRespVO;
import com.ms.warehouse.common.vo.Param;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;
import com.ms.warehouse.manage.bo.FloorinfoBO;
import com.ms.warehouse.manage.entity.FloorinfoEntity;

/**
 * 楼层信息 业务处理
 * @author dwx
 * @Date 2018-07-09 18:27:43
 * @since 1.0
 */@Service
public class FloorinfoService extends BaseService {

	@Autowired
	private FloorinfoBO floorinfoBo;

	/**
	 * 分页查询列表
	 * 
	 * @param reqVO
	 * @return
	 */
	public ListRespVO list(ListReqVO<FloorinfoEntity> reqVO) throws CenterException {
		return floorinfoBo.queryPageAutomatic(reqVO);
	}
	
	/**
	 * 根据ID查询单条记录
	 * 
	 * @param id
	 * @return
	 */
	public Object queryById(@Param("id") Long id) throws CenterException {
		return floorinfoBo.queryById(id);
	}

	/**
	 * 新增
	 * 
	 * @param floorinfo
	 * @return
	 */
	public Object create(FloorinfoEntity floorinfo) throws CenterException {
        floorinfo.setCreatedDate(new Date());
		if(floorinfo.getFloorCode()==""||floorinfo.getFloorCode()==null){
			return new BaseRespVO(2, "楼层编码不能为空");
		}
		if(floorinfo.getFloorName()==""||floorinfo.getFloorName()==null){
			return new BaseRespVO(2, "楼层名称不能为空");
		}
		floorinfoBo.createForValidate(floorinfo);
		return floorinfo;
	}

	/**
	 * 修改
	 * 
	 * @param floorinfo
	 * @return
	 */
	public BaseRespVO update(FloorinfoEntity floorinfo) throws CenterException {
        floorinfo.setUpdatedDate(new Date());
		if(floorinfo.getFloorCode()==""||floorinfo.getFloorCode()==null){
			return new BaseRespVO(2, "楼层编码不能为空");
		}
		if(floorinfo.getFloorName()==""||floorinfo.getFloorName()==null){
			return new BaseRespVO(2, "楼层名称不能为空");
		}
		int updateCount = floorinfoBo.updateForValidate(floorinfo);
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
		int deleteCount = floorinfoBo.batchDeleteById(id);
		if (deleteCount > 0) {
			return new BaseRespVO();
		} else {
			return new BaseRespVO(2, "没有要删除的记录！");
		}
	}
	/**
	 * 根据编号判断是否存在
     */
	public Object checkfloorCode(@Param("floorCode") String floorCode) throws CenterException {
		return floorinfoBo.checkfloorCode(floorCode);
	}
	/**
	 * 根据名称判断是否存在
	 */
	public Object checkfloorName(@Param("floorName") String floorName) throws CenterException {
		return floorinfoBo.checkfloorName(floorName);
	}

	/**
	 *  查询所有楼层数据
	 * @param floorinfo
	 * @return
	 * @throws CenterException
     */
	public Object queryfloorlist(FloorinfoEntity floorinfo) throws CenterException {
		return floorinfoBo.queryfloorlist();
	}
	
	public ListRespVO queryList() throws CenterException {
		return floorinfoBo.queryList();
	}
}
