
package com.ms.warehouse.inventory.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.common.utils.SQLValid;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;
import com.ms.warehouse.inventory.entity.OuttraylocalmapEntity;
import com.ms.warehouse.inventory.mapper.OuttraylocalmapMapper;


/**
 * 出库单托盘货位对照关系 bo
 * @author dwx
 * @Date 2018-07-25 10:22:19
 * @since 1.0
 */
@Component
public class OuttraylocalmapBO extends AbstractBaseBO<OuttraylocalmapEntity> {
	
	@Autowired
	private OuttraylocalmapMapper outtraylocalmapMapper;
	
	
	@Override
    protected IBaseMapper<OuttraylocalmapEntity> getMapper() {
	    return outtraylocalmapMapper;
    }
	

    public List<OuttraylocalmapEntity> queryByBatchNo(String batchNo) {
	    return outtraylocalmapMapper.queryByBatchNo(batchNo);
    }
    public List<OuttraylocalmapEntity> getcalculateoutoquality(Long orderdetailId){
    	return outtraylocalmapMapper.getcalculateoutoquality(orderdetailId);
	}
	public List<OuttraylocalmapEntity> queryLocalByorderdetailId(Long orderdetailId){
		return outtraylocalmapMapper.queryLocalByorderdetailId(orderdetailId);
	}
	public int deleteByorderdetailId(Long orderdetailId){
		return outtraylocalmapMapper.deleteByorderdetailId(orderdetailId);
	}
	public List<OuttraylocalmapEntity> querylocalmapbyorderdetailId(Long orderdetailId){
		return outtraylocalmapMapper.querylocalmapbyorderdetailId(orderdetailId);
	}
	
	/**
	 * @Description:根据detail_id删除绑定信息
	 * @param orderdetailId
	 * @return
	 */ 
	public Object deleteByOrderdetailId (Long orderdetailId) {
		return outtraylocalmapMapper.deleteByOrderdetailId(orderdetailId);
	}
	/**
	 * trayRfid 获取出库货位信息
	 * @param trayRfid
	 * @return
	 */
	public OuttraylocalmapEntity getOuttraylocalmap(String trayRfid){
		return outtraylocalmapMapper.getOuttraylocalmap(trayRfid);
	}
	/**
	 * 根据soleCode修改出库货位状态
	 * @param soleCode
	 * @return
	 */
	public void updateOuttraylocalmapStatus(String soleCode){
		 outtraylocalmapMapper.updateOuttraylocalmapStatus(soleCode);
	}
	/**
	 * 根据出库单id 判断该出库单对应的出库货位是否已出库完成
	 * @param mainorderId
	 * @return
	 */
	public int querycountBymainorderId(long mainorderId){
		return outtraylocalmapMapper.querycountBymainorderId(mainorderId);
	}
	
	
	 public ListRespVO queryotd(ListReqVO<OuttraylocalmapEntity> reqVO){
			if (reqVO != null && reqVO.getOrderField() != null && !SQLValid.isValid(reqVO.getOrderField())) {
				reqVO.setOrderField(null);
			}

			Page<OuttraylocalmapEntity> page = null;

			if (reqVO != null && 0 != reqVO.getPageNum()) {
				page = PageHelper.startPage(reqVO.getPageNum(), reqVO.getPageSize(), true);
			} else {
				page = PageHelper.startPage(1, 1000, true);
			}

			ListRespVO resp = new ListRespVO();
			resp.setAaData(outtraylocalmapMapper.queryByotdPage(reqVO));
			resp.setDataCount(outtraylocalmapMapper.queryotdCount(reqVO));
			return resp;
	 }

	/**
	 * 根据明细id 逻辑删除出库货位绑定信息
	 * @param orderdetailId
	 */
	public	void updateisDeleteBydetailId(long  orderdetailId){
		outtraylocalmapMapper.updateisDeleteBydetailId(orderdetailId);
	}

	/**
	 * 根据货位id 更新出库货位绑定表 中 货位FRID
	 * @param localOrginrfid
	 * @param localNewrfid
	 */
	public void updateoutlampBylocalrfid(String localOrginrfid,String localNewrfid){
		outtraylocalmapMapper.updateoutlampBylocalrfid(localOrginrfid,localNewrfid);
	}
}
