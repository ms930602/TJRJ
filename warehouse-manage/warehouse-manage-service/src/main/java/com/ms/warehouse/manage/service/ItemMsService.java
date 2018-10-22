package com.ms.warehouse.manage.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.warehouse.common.exception.CenterException;
import com.ms.warehouse.common.service.BaseService;
import com.ms.warehouse.common.vo.BaseRespVO;
import com.ms.warehouse.common.vo.Param;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;

import com.ms.warehouse.manage.bo.ItemMsBO;
import com.ms.warehouse.manage.entity.ItemMsEntity;

/**
 *  业务处理
 * @author Ms
 * @Date 2018-10-13 15:55:21
 * @since 1.0
 */@Service
public class ItemMsService extends BaseService {

	@Autowired
	private ItemMsBO itemMsBo;

	/**
	 * 分页查询列表
	 * 
	 * @param reqVO
	 * @return
	 */
	public ListRespVO list(ListReqVO<ItemMsEntity> reqVO) throws CenterException {
		return itemMsBo.queryPageAutomatic(reqVO);
	}
	
	/**
	 * 根据ID查询单条记录
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object queryById(@Param("id") Long id) throws CenterException {
		return itemMsBo.queryById(id);
	}

	/**
	 * 新增
	 * 
	 * @param reqVO
	 * @return
	 */
	public Object create(ItemMsEntity itemMs) throws CenterException {
		itemMs.setCreatetime(new Date());
		itemMsBo.createForValidate(itemMs);
		return itemMs;
	}

	/**
	 * 修改
	 * 
	 * @param reqVO
	 * @return
	 */
	public BaseRespVO update(ItemMsEntity itemMs) throws CenterException {
		itemMs.setUpdatetime(new Date());
		int updateCount = itemMsBo.updateForValidate(itemMs);
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
		int deleteCount = itemMsBo.batchDeleteById(id);
		if (deleteCount > 0) {
			return new BaseRespVO();
		} else {
			return new BaseRespVO(2, "没有要删除的记录！");
		}
	}
	
	/**
	 * 判断是否名字重复
	 * @param areaCode
	 * @return
	 * @throws CenterException
     */
	public List<ItemMsEntity> checkItemName(@Param("name") String ItemName,@Param("gameId") Integer gameId) throws CenterException {
		return itemMsBo.checkItemName(ItemName,gameId);
	}

}
