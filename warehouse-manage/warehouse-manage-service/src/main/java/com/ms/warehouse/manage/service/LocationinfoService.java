package com.ms.warehouse.manage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.warehouse.common.exception.CenterException;
import com.ms.warehouse.common.service.BaseService;
import com.ms.warehouse.common.vo.BaseRespVO;
import com.ms.warehouse.common.vo.Param;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;
import com.ms.warehouse.manage.bo.LocationinfoBO;
import com.ms.warehouse.manage.entity.LocationinfoEntity;

import java.util.Date;
import java.util.List;

/**
 * 货位信息 业务处理
 * @author dwx
 * @Date 2018-07-09 18:27:43
 * @since 1.0
 */@Service
public class LocationinfoService extends BaseService {

	@Autowired
	private LocationinfoBO locationinfoBo;

	/**
	 * 分页查询列表
	 * 
	 * @param reqVO
	 * @return
	 */
	public ListRespVO list(ListReqVO<LocationinfoEntity> reqVO) throws CenterException {
		return locationinfoBo.queryPageAutomatic(reqVO);
	}
	
	/**
	 * 根据ID查询单条记录
	 * 
	 * @param id
	 * @return
	 */
	public Object queryById(@Param("id") Long id) throws CenterException {
		return locationinfoBo.queryById(id);
	}

	/**
	 * 新增
	 * 
	 * @param locationinfo
	 * @return
	 */
	public Object create(LocationinfoEntity locationinfo) throws CenterException {
		locationinfo.setCreatedDate(new Date());
		if(locationinfo.getAreaId()==null){
			return new BaseRespVO(2, "区域不能为空");
		}
		if(locationinfo.getAreaNum()==null){
			return new BaseRespVO(2, "区域号不能为空");
		}
		if(locationinfo.getAreaRow()==null){
			return new BaseRespVO(2, "区域排不能为空");
		}
		if(locationinfo.getLocalCode()==""||locationinfo.getLocalCode()==null){
			return new BaseRespVO(2, "区域编号不能为空");
		}
		if(locationinfo.getLocalRfid()==""||locationinfo.getLocalRfid()==null){
			return new BaseRespVO(2, "RFID编码不能为空");
		}
		if(locationinfo.getUpDown()==null){
			return new BaseRespVO(2, "上下层不能为空");
		}

		locationinfoBo.createForValidate(locationinfo);
		return locationinfo;
	}

	/**
	 * 修改
	 * 
	 * @param locationinfo
	 * @return
	 */
	public BaseRespVO update(LocationinfoEntity locationinfo) throws CenterException {
		locationinfo.setUpdatedDate(new Date());
		if(locationinfo.getAreaId()==null){
			return new BaseRespVO(2, "区域不能为空");
		}
		if(locationinfo.getAreaNum()==null){
			return new BaseRespVO(2, "区域号不能为空");
		}
		if(locationinfo.getAreaRow()==null){
			return new BaseRespVO(2, "区域排不能为空");
		}
		if(locationinfo.getLocalCode()==""||locationinfo.getLocalCode()==null){
			return new BaseRespVO(2, "区域编号不能为空");
		}
		if(locationinfo.getLocalRfid()==""||locationinfo.getLocalRfid()==null){
			return new BaseRespVO(2, "RFID编码不能为空");
		}
		if(locationinfo.getUpDown()==null){
			return new BaseRespVO(2, "上下层不能为空");
		}
		int updateCount = locationinfoBo.updateForValidate(locationinfo);
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
		int deleteCount = locationinfoBo.batchDeleteById(id);
		if (deleteCount > 0) {
			return new BaseRespVO();
		} else {
			return new BaseRespVO(2, "没有要删除的记录！");
		}
	}

	/**
	 * 根据localCode判断编码是否重复
	 * @param localCode
	 * @return
	 * @throws CenterException
     */
	public List<LocationinfoEntity> checklocationcode(@Param("localCode") String localCode) throws CenterException {
			return locationinfoBo.checklocationcode(localCode);
	}

    /**
     * 根据localRfid 判断 RFID的重复个数
     * @param localRfid
     * @return
     */
    public Object checkRFID(@Param("localRfid") String localRfid){
        List<LocationinfoEntity> list = locationinfoBo.checkRFID(localRfid);
        return list.size();
    }

	/**
	 * 查询所有货位信息
	 * @return
	 * @throws CenterException
     */
	public Object queryAllLocationInfo() throws CenterException {
		return locationinfoBo.queryAllLocationInfo();
	}
}
