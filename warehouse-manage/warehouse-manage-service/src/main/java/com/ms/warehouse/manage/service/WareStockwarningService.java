package com.ms.warehouse.manage.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.warehouse.common.exception.CenterException;
import com.ms.warehouse.common.service.BaseService;
import com.ms.warehouse.common.vo.BaseRespVO;
import com.ms.warehouse.common.vo.Param;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;
import com.ms.warehouse.inventory.bo.InventorydetailBO;
import com.ms.warehouse.inventory.entity.InventorydetailEntity;
import com.ms.warehouse.manage.bo.MaterstorerulesBO;
import com.ms.warehouse.manage.bo.WareStockwarningBO;
import com.ms.warehouse.manage.entity.MaterstorerulesEntity;
import com.ms.warehouse.manage.entity.WareStockwarningEntity;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

/**
 * 库存预警 业务处理
 * @author wangwei
 * @Date 2018-07-27 15:19:12
 * @since 1.0
 */@Service
public class WareStockwarningService extends BaseService {

	@Autowired
	private WareStockwarningBO wareStockwarningBo;
	/**
	 * 物料存放规则
	 */
	@Autowired
	private MaterstorerulesBO materstorerulesBo;
	/**
	 * 库存明细BO
	 */
	@Autowired
	private InventorydetailBO inventorydetailBo;
	/**
	 * 分页查询列表
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object list(ListReqVO<WareStockwarningEntity> reqVO) throws CenterException {
		String batchNo=reqVO.getWhereCondition().getBatchNo();//查询条件批次号
		Map<String, Object> params=new HashMap<>();//查询条件封装
		params.put("batchNo", batchNo);//批次号
		//处理后的需要预警信息
		List<WareStockwarningEntity> StockwarningList=new ArrayList<>();
		//查询默认规则
		MaterstorerulesEntity defaulRule= materstorerulesBo.queryDeafultRuler();
		if (defaulRule==null) {
			return BaseRespVO.error("无默认存放规则");
		}
		//查询所有库存明细
		List<InventorydetailEntity> InventorydetailAllList=inventorydetailBo.getAllList(params);
		//通过物料编码查询规则
		for (InventorydetailEntity inventorydetailEntity : InventorydetailAllList) {
			WareStockwarningEntity StockwarningEntity=new WareStockwarningEntity();
			//预先统一设置为全部为否
			StockwarningEntity.setIsShortage("否");
			StockwarningEntity.setIsBeyond("否");
			StockwarningEntity.setIsOverstock("否");
			//设置物流编码
			StockwarningEntity.setMaterCode(inventorydetailEntity.getMaterCode());
			//设置创建时间
			StockwarningEntity.setCreatedDate(DateTime.now());
			//入时间
			StockwarningEntity.setEntryDate(inventorydetailEntity.getCreatedDate());
			//库存数量
			StockwarningEntity.setInventQuality(inventorydetailEntity.getSurplusQuality());
			//设置批次号
			StockwarningEntity.setBatchNo(inventorydetailEntity.getBatchNo());
			MaterstorerulesEntity materstorerulesEntity= materstorerulesBo.queryByMaterCode(inventorydetailEntity.getMaterCode());
			if (materstorerulesEntity ==null) {
				/**
				 * 使用默认规则计算
				 */
				//计算是否 超粗/短缺  明细剩余总量-规则(最高/最低)
				if (processDefaultRule(StockwarningEntity, inventorydetailEntity, defaulRule)) {
					//添加到预警集合
					StockwarningList.add(StockwarningEntity);
				}
			}else {
				/**
				 * 使用自定义规则计算
				 */
				if (processCustomRule(StockwarningEntity, inventorydetailEntity, materstorerulesEntity)) {
					//添加到处理结果集集合
					StockwarningList.add(StockwarningEntity);
				}
			}
		}
		//后端处理分页集合
        List<WareStockwarningEntity> MemberArticleBeanPage = new ArrayList<WareStockwarningEntity>();//分页集合
        int currIdx = (reqVO.getPageNum() > 1 ? (reqVO.getPageNum() -1) * reqVO.getPageSize() : 0);
        for (int i = 0; i < reqVO.getPageSize() && i < StockwarningList.size() - currIdx; i++) {
        	WareStockwarningEntity memberArticleBean = StockwarningList.get(currIdx + i);
            MemberArticleBeanPage.add(memberArticleBean);
        }
        ListRespVO listRespVO=new ListRespVO();
        listRespVO.setDataCount(StockwarningList.size());//设置数据大小
        listRespVO.setAaData(MemberArticleBeanPage);//设置数据
        listRespVO.setMsg("查询成功");
        listRespVO.setState(0);
        return listRespVO;
	}
	
	/**
	 * 根据ID查询单条记录
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object queryById(@Param("id") Long id) throws CenterException {
		return wareStockwarningBo.queryById(id);
	}

	/**
	 * 新增
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object create(WareStockwarningEntity wareStockwarning) throws CenterException {
		wareStockwarningBo.createForValidate(wareStockwarning);
		return wareStockwarning;
	}

	/**
	 * 修改
	 * 
	 * @param reqVO
	 * @return
	 */
	public BaseRespVO update(WareStockwarningEntity wareStockwarning) throws CenterException {
		int updateCount = wareStockwarningBo.updateForValidate(wareStockwarning);
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
		int deleteCount = wareStockwarningBo.batchDeleteById(id);
		if (deleteCount > 0) {
			return new BaseRespVO();
		} else {
			return new BaseRespVO(2, "没有要删除的记录！");
		}
	}
	/**
	 * 计算默认规则
	 * @param StockwarningEntity
	 * @param inventorydetailEntity
	 * @param defaulRule
	 * @return
	 */
	public boolean  processDefaultRule(WareStockwarningEntity StockwarningEntity,InventorydetailEntity inventorydetailEntity,MaterstorerulesEntity defaulRule) {
		boolean flag=false;
		BigDecimal numberRemaining=inventorydetailEntity.getSurplusQuality();//剩余总量
		if ((numberRemaining.subtract(defaulRule.getMinStock())).compareTo(new BigDecimal(0))==-1) {
			//剩余减去最低<0  短缺
			StockwarningEntity.setIsBeyond("是");
			flag=true;
		}
		if ((numberRemaining.subtract(defaulRule.getMaxStock())).compareTo(new BigDecimal(0))==1) {
			//剩余减去最高库存>0  超储
			StockwarningEntity.setIsOverstock("是");
			flag=true;
		}
		//库存创建时间-当前时间 =天数  若大于规则规定则呆滞
		long dateSub=DateUtil.between(inventorydetailEntity.getCreatedDate(), DateTime.now(), DateUnit.DAY);//时间差
		//判断时间是否超过规定时间
		if (dateSub>defaulRule.getDeadline()) {
			//呆滞
			StockwarningEntity.setIsBeyond("是");
			flag=true;
		}
		return flag;
	}
	/**
	 * 处理计算自定义规则预警
	 */
	public boolean processCustomRule(WareStockwarningEntity StockwarningEntity,InventorydetailEntity inventorydetailEntity,MaterstorerulesEntity materstorerulesEntity) {
		boolean flag=false;
		//计算是否 超粗/短缺  明细剩余总量-规则(最高/最低)
		BigDecimal numberRemaining=inventorydetailEntity.getSurplusQuality();//剩余总量
		if ((numberRemaining.subtract(materstorerulesEntity.getMinStock())).compareTo(new BigDecimal(0))==-1) {
			//剩余减去最低<0  短缺
			StockwarningEntity.setIsBeyond("是");
			flag=true;
		}
		if ((numberRemaining.subtract(materstorerulesEntity.getMaxStock())).compareTo(new BigDecimal(0))==1) {
			//剩余减去最高库存>0  超储
			StockwarningEntity.setIsOverstock("是");
			flag=true;
		}
		//库存创建时间-当前时间 =天数  若大于规则规定则呆滞
		long dateSub=DateUtil.between(inventorydetailEntity.getCreatedDate(), DateTime.now(), DateUnit.DAY);//时间差
		//判断时间是否超过规定时间
		if (dateSub>materstorerulesEntity.getDeadline()) {
			//呆滞
			StockwarningEntity.setIsBeyond("是");
			flag=true;
		}
		return flag;
	}
}
