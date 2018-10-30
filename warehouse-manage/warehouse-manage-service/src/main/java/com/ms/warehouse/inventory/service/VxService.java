package com.ms.warehouse.inventory.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ms.warehouse.IVxService;
import com.ms.warehouse.common.vo.BaseRespVO;
import com.ms.warehouse.manage.bo.VxActivitiesBO;
import com.ms.warehouse.manage.bo.VxBuyInfoBO;
import com.ms.warehouse.manage.bo.VxPromotersBO;
import com.ms.warehouse.manage.entity.VxActivitiesEntity;
import com.ms.warehouse.manage.entity.VxBuyInfoEntity;
import com.ms.warehouse.manage.entity.VxPromotersEntity;
import com.ms.warehouse.manage.entity.VxRedPackUtil;
import com.ms.warehouse.manage.entity.WXAuthUtil;

import cn.hutool.setting.dialect.Props;


@Service("vxService")
public class VxService implements IVxService{
	
	@Autowired
	private VxPromotersBO promotersBO;
	
	@Autowired
	private VxBuyInfoBO buyInfoBO;
	
	@Autowired
	private VxActivitiesBO acticitiesBO;
	
	@Override
	public BaseRespVO savePromoters(JSONObject reqMap) {
		VxPromotersEntity entity = new VxPromotersEntity();
		entity.setOpenId(reqMap.get("openid") + "");
		VxPromotersEntity queryByEntity = promotersBO.queryByEntity(entity);
		if(queryByEntity!= null && queryByEntity.getId() > 0){
			return new BaseRespVO(99,"已存在用户");
		}
		entity.setNickname(reqMap.get("nickname") + "");
		entity.setSex(reqMap.get("sex") + "");
		entity.setProvince(reqMap.get("province") + "");
		entity.setCity(reqMap.get("city") + "");
		entity.setCountry(reqMap.get("country") + "");
		entity.setHeadimgurl(reqMap.get("headimgurl") + "");
		entity.setUnionid(reqMap.get("unionid") + "");
		
		Object object = reqMap.get("activitiId");
		if(object != null){
			try {
				entity.setActivites(Long.parseLong(object+""));
				VxActivitiesEntity queryById = acticitiesBO.queryById(Long.parseLong(object+""));
				if(queryById != null){
					VxActivitiesEntity updateAc = new VxActivitiesEntity();
					updateAc.setId(queryById.getId());
					updateAc.setSelectNum(queryById.getSelectNum() + 1);
					acticitiesBO.update(updateAc);
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		entity.setCreatetime(new Date());
		
		promotersBO.create(entity);
		return new BaseRespVO(0,"完成");
	}

	@Override
	public void payAction(String openId) {
		VxBuyInfoEntity query = new VxBuyInfoEntity();
		query.setData(openId);
		query.setStatus("0");
		List<VxBuyInfoEntity> queryListByEntity = buyInfoBO.queryListByEntity(query);
		if(queryListByEntity == null || queryListByEntity.size() == 0)
			return;
		VxBuyInfoEntity vxBuyInfoEntity = queryListByEntity.get(0);
		
		vxBuyInfoEntity.setBuyTime(new Date());
		String promotersData = vxBuyInfoEntity.getPromotersData();
		VxActivitiesEntity queryById = acticitiesBO.queryById(vxBuyInfoEntity.getActivitiesId());
		if(promotersData != null && 
				!"".equals(promotersData.trim()) &&
				queryById != null
				){
			try {
				Props PathProps = new Props("pathConf.properties");
				String ip =PathProps.getProperty("file.vx.pay.red.ip");
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				String strMch_billnoA = "DDWA" + sdf.format(new Date());
				String MHCname = queryById.getRedpackTitle();
				String priceA = WXAuthUtil.getRedFanPrice(); //价格
				
				//购买人返现1~5块
				VxRedPackUtil.sendRedPack(strMch_billnoA,
						promotersData,
						MHCname,priceA,"1",
						queryById.getRedpackContent(),"提成红包","谢谢您的推广!",ip);
				
				String strMch_billnoB = "DDWB" + sdf.format(new Date());
				//分享人返现5块
				VxRedPackUtil.sendRedPack(strMch_billnoB,
						promotersData,
						MHCname,"500","1",
						queryById.getRedpackContent(),"提成红包","谢谢您的推广!",ip);
				vxBuyInfoEntity.setReMoney(new BigDecimal(5));
				vxBuyInfoEntity.setShareMoney(new BigDecimal(priceA));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		VxActivitiesEntity nowActi = acticitiesBO.queryById(vxBuyInfoEntity.getActivitiesId());
		if(nowActi != null){
			VxActivitiesEntity updateAc = new VxActivitiesEntity();
			updateAc.setId(nowActi.getId());
			updateAc.setSelectNum(nowActi.getPayNum() + 1);
			acticitiesBO.update(updateAc);
		}
		vxBuyInfoEntity.setStatus("1");
		buyInfoBO.update(vxBuyInfoEntity);
	}

}
