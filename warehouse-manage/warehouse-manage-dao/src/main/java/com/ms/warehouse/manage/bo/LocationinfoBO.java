
package com.ms.warehouse.manage.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.manage.entity.LocationinfoEntity;
import com.ms.warehouse.manage.mapper.LocationinfoMapper;

import java.util.List;
import java.util.Map;


/**
 * 货位信息 bo
 * @author dwx
 * @Date 2018-07-09 18:27:43
 * @since 1.0
 */
@Component
public class LocationinfoBO extends AbstractBaseBO<LocationinfoEntity> {
	
	@Autowired
	private LocationinfoMapper locationinfoMapper;
	
	@Override
    protected IBaseMapper<LocationinfoEntity> getMapper() {
	    return locationinfoMapper;
    }

    public List<LocationinfoEntity> checklocationcode(String localCode){
    	return locationinfoMapper.checklocationcode(localCode);
	}
	public List<LocationinfoEntity> checkRFID(String localRfid){
	    return locationinfoMapper.checkRFID(localRfid);
    }
    public  List<LocationinfoEntity> queryAllLocationInfo(){
		return locationinfoMapper.queryAllLocationInfo();
	}
    
    /**
     * @Description:查询占用货位之前的处于空闲中的排
     * @param enty
     * @return
     */
    public List<LocationinfoEntity> queryFreeRowBygroupNoBefore(LocationinfoEntity enty){
    	return locationinfoMapper.queryFreeRowBygroupNoBefore(enty);
    }
    
    /**
     * @Description:查询占用货位之后的处于空闲中的货位
     * @param enty
     * @return
     */
    public List<LocationinfoEntity> queryFreeRowBygroupNoAfter(LocationinfoEntity enty){
    	return locationinfoMapper.queryFreeRowBygroupNoAfter(enty);
    }
    
    /**
     * @Description:根据楼层获取货位
     * @param enty
     * @return
     */
    public List<LocationinfoEntity> queryListByFloor(LocationinfoEntity enty){
    	return locationinfoMapper.queryListByFloor(enty);
    }
    
    /**
     * @Description:查询五楼空闲排
     * @return
     */
    public List<Map<String,Object>> queryFiveFreeLocals(){
    	return locationinfoMapper.queryFiveFreeLocals();
    }
    
    /**
     * @Description:获取五楼未绑定的货位
     * @return
     */
    public List<LocationinfoEntity> querynobindlocal(){
    	return locationinfoMapper.querynobindlocal();
    }
    
    /**
     * @Description:更新物料组号
     * @param enty
     * @return
     */
    public int updategroupno(LocationinfoEntity enty) {
    	return locationinfoMapper.updategroupno(enty);
    }
    
    /**
     * @Description:查询未被绑定物料组的空闲块
     * @return
     */
    public List<Map<String,Object>>queryfreeblock(){
    	return locationinfoMapper.queryfreeblock();
    }

    /**
     * 根据货位id 更新货位表 中 货位FRID
     * @param localOrginrfid
     * @param localNewrfid
     */
    public void updatelocationinfoBylocalrfid(String localOrginrfid,String localNewrfid){
        locationinfoMapper.updatelocationinfoBylocalrfid(localOrginrfid,localNewrfid);
    }
}
