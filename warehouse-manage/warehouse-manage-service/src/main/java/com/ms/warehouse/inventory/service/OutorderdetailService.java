package com.ms.warehouse.inventory.service;

import com.alibaba.fastjson.JSONArray;
import com.ms.warehouse.common.exception.CenterException;
import com.ms.warehouse.common.service.BaseService;
import com.ms.warehouse.common.vo.BaseRespVO;
import com.ms.warehouse.common.vo.Param;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;
import com.ms.warehouse.inventory.bo.OutmainorderBO;
import com.ms.warehouse.inventory.bo.OutorderdetailBO;
import com.ms.warehouse.inventory.bo.OuttraylocalmapBO;
import com.ms.warehouse.inventory.entity.OutmainorderEntity;
import com.ms.warehouse.inventory.entity.OutorderdetailEntity;
import com.ms.warehouse.inventory.entity.OuttraylocalmapEntity;
import com.ms.warehouse.manage.bo.SubversionBO;
import com.ms.warehouse.manage.entity.SubversionEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 出库单详情 业务处理
 * @author dwx
 * @Date 2018-07-25 10:22:19
 * @since 1.0
 */@Service
public class OutorderdetailService extends BaseService {

	@Autowired
	private OutorderdetailBO outorderdetailBo;
	@Autowired
	private OutmainorderBO outmainorderBo;
	@Autowired
	private OuttraylocalmapBO outtraylocalmapBo;

	@Autowired
	private SubversionBO subversionBo;
	/**
	 * 分页查询列表
	 * 
	 * @param reqVO
	 * @return
	 */
	public ListRespVO list(ListReqVO<OutorderdetailEntity> reqVO) throws CenterException {
		return outorderdetailBo.queryPageAutomatic(reqVO);
	}
	
	/**
	 * 根据ID查询单条记录
	 * 
	 * @param id
	 * @return
	 */
	public Object queryById(@Param("id") Long id) throws CenterException {
		return outorderdetailBo.queryById(id);
	}

	/**
	 * 新增
	 * 
	 * @param outorderdetail
	 * @return
	 */
	public Object create(OutorderdetailEntity outorderdetail) throws CenterException {
		outorderdetailBo.createForValidate(outorderdetail);
		return outorderdetail;
	}

	/**
	 * 修改
	 * 
	 * @param outorderdetail
	 * @return
	 */
	public BaseRespVO update(OutorderdetailEntity outorderdetail) throws CenterException {
		int updateCount = outorderdetailBo.updateForValidate(outorderdetail);
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
		int deleteCount = outorderdetailBo.batchDeleteById(id);
		if (deleteCount > 0) {
			return new BaseRespVO();
		} else {
			return new BaseRespVO(2, "没有要删除的记录！");
		}
	}
	/**
	 * 根据ID查询单条记录
	 *
	 * @param mainorderId
	 * @return
	 */
	public Object queryBymainId(@Param("mainorderId") Long mainorderId) throws CenterException {
		List<OutorderdetailEntity> list= outorderdetailBo.queryBymainId(mainorderId);
		list.forEach(item->{
			/**
			 * 根据卷烟编号查询 相应卷烟信息
             */
			List<SubversionEntity> sblist = subversionBo.querysubBymaterCode(item.getMaterCode());
			for (int i =0;i<sblist.size();i++){
				item.getSubList().add(sblist.get(i));
			}
		});
		return list;
	}

	/**
	 * 添加明细数据
	 *
	 * @param details
	 * @return
	 */
	public Object createdetails(@Param("details") String details) throws CenterException {
		/**
		 * 解析json字符串  获得出库主表对象outmainorderEntity    出库明细列表list
		 */
		List<OutorderdetailEntity> list = JSONArray.parseArray(details, OutorderdetailEntity.class);
		/**
		 * 保存明细数据
		 */
		list.forEach((item)->{
			/**
			 * 设置出库单Id
			 */
			item.setMainorderId(item.getMainorderId());
		});
		outorderdetailBo.batchSave(list);
		return new BaseRespVO();
	}

	/**
	 * 验证数据库数据 与 页面目前数据是否一致
	 * @param details
	 * @return
	 * @throws CenterException
     */
	public Object checkdetailsquickBox(@Param("details") String details) throws CenterException {

		/**
		 * 解析json字符串  获得出库主表对象outmainorderEntity    出库明细列表list
		 */
		List<OutorderdetailEntity> newlist = JSONArray.parseArray(details, OutorderdetailEntity.class);
		long mainId = newlist.get(0).getMainorderId();
		/**
		 * 根据出库单id 获取对应的出库明细数据
         */
		List<OutorderdetailEntity> oldlist = outorderdetailBo.queryBymainId(mainId);
		for (int i=0;i<newlist.size();i++){
			if(newlist.get(i).getQualityBox().compareTo(oldlist.get(i).getQualityBox())!=0){
				return new BaseRespVO(2, "明细出库量被修改！");
			}
		}
		return new BaseRespVO();
	}

	/**
	 * 根据明细id  当前数量 判断出库数量是否被修改
     */
	public int checkdetailquickBoxbyId(@Param("id") Long id,@Param("newquickBox") BigDecimal newquickBox){
		/**
		 * 根据id 查询获得 明细信息
         */
		OutorderdetailEntity outorderdetailEntity = outorderdetailBo.queryById(id);
		OutmainorderEntity outmainorderEntity = outmainorderBo.queryById(outorderdetailEntity.getMainorderId());
		Long orignMethodnum = outmainorderEntity.getOrignMethod();
		if (orignMethodnum==1){
			/**
			 * 物流单录入方式  判断
             */
			//根据明细id 查询货位分配
			List<OuttraylocalmapEntity> list = outtraylocalmapBo.querylocalmapbyorderdetailId(id);
			if (list.size()==0){
				return 1;
			}else{
				int checknum = outorderdetailEntity.getQualityBox().compareTo(newquickBox);
				return checknum;
			}
		}else {
			/**
			 * 手动录入方式的单据 判断
             */
			int checknum = outorderdetailEntity.getQualityBox().compareTo(newquickBox);
			return checknum;
		}
	}

    /**
     *  出库统计主要统计某一天出库的每种规格的烟的数量。
        以Echart的Pie图（饼图）展示，且要将查询结果以列表展示出来。
        查询条件：【日期，只能选择某一天，年月日】
     * @param createDate
     * @return
     */
    public List<OutorderdetailEntity> outgoingStatistics(@Param("createDate")Date createDate){
        return outorderdetailBo.outgoingStatistics(createDate);
    }
}
