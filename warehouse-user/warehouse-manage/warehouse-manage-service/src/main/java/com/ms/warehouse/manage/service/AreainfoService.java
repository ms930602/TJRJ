package com.ms.warehouse.manage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.warehouse.common.exception.CenterException;
import com.ms.warehouse.common.service.BaseService;
import com.ms.warehouse.common.vo.BaseRespVO;
import com.ms.warehouse.common.vo.Param;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;
import com.ms.warehouse.manage.bo.AreainfoBO;
import com.ms.warehouse.manage.entity.AreainfoEntity;

import java.util.Date;
import java.util.List;

/**
 * 仓库区域管理 业务处理
 * @author dwx
 * @Date 2018-07-09 18:27:43
 * @since 1.0
 */@Service
public class AreainfoService extends BaseService {

	@Autowired
	private AreainfoBO areainfoBo;

	/**
	 * 分页查询列表
	 * 
	 * @param reqVO
	 * @return
	 */
	public ListRespVO list(ListReqVO<AreainfoEntity> reqVO) throws CenterException {
		return areainfoBo.queryPageAutomatic(reqVO);
	}
	
	/**
	 * 根据ID查询单条记录
	 * 
	 * @param id
	 * @return
	 */
	public Object queryById(@Param("id") Long id) throws CenterException {
		return areainfoBo.queryById(id);
	}

	/**
	 * 新增
	 * 
	 * @param areainfo
	 * @return
	 */
	public Object create(AreainfoEntity areainfo) throws CenterException {
		areainfo.setCreatedDate(new Date());
		if(areainfo.getAreaCode()==""||areainfo.getAreaCode()==null){
			return new BaseRespVO(2, "区域编码不能为空");
		}
		if(areainfo.getFloorId()==null){
			return new BaseRespVO(2, "楼层不能为空");
		}
		areainfoBo.createForValidate(areainfo);
		return areainfo;
	}

	/**
	 * 修改
	 * 
	 * @param areainfo
	 * @return
	 */
	public BaseRespVO update(AreainfoEntity areainfo) throws CenterException {
		areainfo.setUpdatedDate(new Date());
		if(areainfo.getAreaCode()==""||areainfo.getAreaCode()==null){
			return new BaseRespVO(2, "区域编码不能为空");
		}
		if(areainfo.getFloorId()==null){
			return new BaseRespVO(2, "楼层不能为空");
		}
		int updateCount = areainfoBo.updateForValidate(areainfo);
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
		int deleteCount = areainfoBo.batchDeleteById(id);
		if (deleteCount > 0) {
			return new BaseRespVO();
		} else {
			return new BaseRespVO(2, "没有要删除的记录！");
		}
	}

	/**
	 * 获取所有区域数据
	 * @return
	 * @throws CenterException
     */
	public Object queryarealist() throws CenterException {
		return areainfoBo.queryarealist();
	}

	/**
	 * 判断区域重复
	 * @param areaCode
	 * @return
	 * @throws CenterException
     */
	public List<AreainfoEntity> checkareaCode(@Param("areaCode") String areaCode) throws CenterException {
		return areainfoBo.checkAreaCode(areaCode);
	}

	/**
	 * 根据id 获取楼层编码
	 * @param id
	 * @return
	 * @throws CenterException
     */
	public AreainfoEntity queryfloorcodebyareaid(@Param("id") long id) throws CenterException{
		return areainfoBo.queryfloorcodebyareaid(id);
	}
}
