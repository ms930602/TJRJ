package com.ms.warehouse.inventory.bo;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ms.warehouse.common.bo.AbstractBaseBO;
import com.ms.warehouse.common.db.FieldValidate;
import com.ms.warehouse.common.mapper.IBaseMapper;
import com.ms.warehouse.common.utils.SQLValid;
import com.ms.warehouse.common.vo.ListVo.ListReqVO;
import com.ms.warehouse.common.vo.ListVo.ListRespVO;
import com.ms.warehouse.inventory.entity.EntrymainorderEntity;
import com.ms.warehouse.inventory.entity.EntrytraylocalmapEntity;
import com.ms.warehouse.inventory.mapper.CigaretteEntryMapper;
import com.ms.warehouse.inventory.mapper.EntrytraylocalmapMapper;
/**
 * 入库 bo
 * @author hxh
 * @Date 2018-07-27 10:22:17
 * @since 1.0
 */
@Component
public class CigaretteEntryBo extends AbstractBaseBO<EntrymainorderEntity> {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CigaretteEntryMapper CigaretteEntryMapper;
	
	@Autowired
	private EntrytraylocalmapMapper EntrytraylocalmapMapper;
	
	@Autowired
	FieldValidate fieldValidate;
	
	@Override
	protected IBaseMapper<EntrymainorderEntity> getMapper() {
		return CigaretteEntryMapper;
	}

	public ListRespVO queryPageLocal(ListReqVO<EntrytraylocalmapEntity> reqVO) {
		if (reqVO != null && reqVO.getOrderField() != null && !SQLValid.isValid(reqVO.getOrderField())) {
			logger.error("传入参数有SQL注入风险！{}", reqVO.getOrderField());
			reqVO.setOrderField(null);
		}

		Page<?> page = null;

		if (reqVO != null && 0 != reqVO.getPageNum()) {
			page = PageHelper.startPage(reqVO.getPageNum(), reqVO.getPageSize(), true);
		} else {
			page = PageHelper.startPage(1, 1000, true);
		}

		ListRespVO resp = new ListRespVO();
		resp.setAaData(CigaretteEntryMapper.queryPageLocal(reqVO));
		resp.setDataCount(page.getTotal());
		return resp;
	}
	
	public ListRespVO localBindList(ListReqVO<?> reqVO) {
		if (reqVO != null && reqVO.getOrderField() != null && !SQLValid.isValid(reqVO.getOrderField())) {
			logger.error("传入参数有SQL注入风险！{}", reqVO.getOrderField());
			reqVO.setOrderField(null);
		}

		Page<?> page = null;

		if (reqVO != null && 0 != reqVO.getPageNum()) {
			page = PageHelper.startPage(reqVO.getPageNum(), reqVO.getPageSize(), true);
		} else {
			page = PageHelper.startPage(1, 1000, true);
		}

		ListRespVO resp = new ListRespVO();
		resp.setAaData(EntrytraylocalmapMapper.queryByPages(reqVO));
		resp.setDataCount(page.getTotal());
		return resp;
	}
		
	public ListRespVO queryPageAutomatic(ListReqVO<?> reqVO) {
		if (reqVO != null && reqVO.getOrderField() != null && !SQLValid.isValid(reqVO.getOrderField())) {
			logger.error("传入参数有SQL注入风险！{}", reqVO.getOrderField());
			reqVO.setOrderField(null);
		}

		Page<?> page = null;

		if (reqVO != null && 0 != reqVO.getPageNum()) {
			page = PageHelper.startPage(reqVO.getPageNum(), reqVO.getPageSize(), true);
		} else {
			page = PageHelper.startPage(1, 1000, true);
		}

		ListRespVO resp = new ListRespVO();
		resp.setAaData(getMapper().queryByPage(reqVO));
		resp.setDataCount(page.getTotal());
		return resp;
	}
	
	

	public List<EntrytraylocalmapEntity> queryByOrderDetailId(Long id) {
		return CigaretteEntryMapper.queryByOrderDetailId(id);
	}

	public int updateLocal(HashMap<String,Object> map) {
		return CigaretteEntryMapper.updateLocal(map);
	}

	public int queryDetailedBind(int id) {
		return CigaretteEntryMapper.queryDetailedBind(id);
	}

	public List<HashMap<String ,Object>> queryVerByCode(String materCode) {
		return CigaretteEntryMapper.queryVerByCode(materCode);
	}

	public List<HashMap<String ,Object>> queryDetailed(Long id) {
		return CigaretteEntryMapper.queryDetailed(id);
	}

	public List<HashMap<String, Object>> queryEntryCounts(String day) {
		return CigaretteEntryMapper.queryEntryCounts(day);
	}
	
	public ListRespVO queryEntrysStatistics(ListReqVO<?> reqVO) {
		if (reqVO != null && reqVO.getOrderField() != null && !SQLValid.isValid(reqVO.getOrderField())) {
			logger.error("传入参数有SQL注入风险！{}", reqVO.getOrderField());
			reqVO.setOrderField(null);
		}

		Page<?> page = null;

		if (reqVO != null && 0 != reqVO.getPageNum()) {
			page = PageHelper.startPage(reqVO.getPageNum(), reqVO.getPageSize(), true);
		} else {
			page = PageHelper.startPage(1, 1000, true);
		}

		ListRespVO resp = new ListRespVO();
		resp.setAaData(CigaretteEntryMapper.queryEntrysStatistics(reqVO));
		resp.setDataCount(page.getTotal());
		return resp;
	}
	
	
	
}
