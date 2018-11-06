package com.ms.warehouse.inventory.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ms.warehouse.IVxService;
import com.ms.warehouse.manage.bo.VxActivitiesBO;
import com.ms.warehouse.manage.bo.VxBuyInfoBO;
import com.ms.warehouse.manage.bo.VxLogBO;
import com.ms.warehouse.manage.bo.VxPromotersBO;
import com.ms.warehouse.manage.entity.VxActivitiesEntity;
import com.ms.warehouse.manage.entity.VxBuyInfoEntity;
import com.ms.warehouse.manage.entity.VxLogEntity;
import com.ms.warehouse.manage.entity.VxPromotersEntity;
import com.ms.warehouse.manage.entity.VxRedPackUtil;

import cn.hutool.setting.dialect.Props;


@Service("vxService")
public class VxService implements IVxService{
	
	
	@Autowired
	private VxPromotersBO promotersBO;
	
	@Autowired
	private VxBuyInfoBO buyInfoBO;
	
	@Autowired
	private VxActivitiesBO acticitiesBO;
	
	@Autowired
	private VxLogBO logBO;
	
	@Override
	public VxLogEntity savePromoters(JSONObject reqMap) {
		VxPromotersEntity entity = new VxPromotersEntity();
		entity.setOpenId(reqMap.get("openid") + "");
		
		Object logID = reqMap.get("logId");
		VxLogEntity loge = logBO.queryById(Long.parseLong(logID+""));
		
		VxPromotersEntity queryByEntity = promotersBO.queryByEntity(entity);
		if(queryByEntity!= null && queryByEntity.getId() > 0){
			return loge;
		}
		entity.setNickname(reqMap.get("nickname") + "");
		entity.setSex(reqMap.get("sex") + "");
		entity.setProvince(reqMap.get("province") + "");
		entity.setCity(reqMap.get("city") + "");
		entity.setCountry(reqMap.get("country") + "");
		entity.setHeadimgurl(reqMap.get("headimgurl") + "");
		entity.setUnionid(reqMap.get("unionid") + "");
		
		try {
			Long activitiId = loge.getAid();
			entity.setActivites(Long.parseLong(activitiId+""));
			VxActivitiesEntity queryById = acticitiesBO.queryById(Long.parseLong(activitiId+""));
			if(queryById != null){
				VxActivitiesEntity updateAc = new VxActivitiesEntity();
				updateAc.setId(queryById.getId());
				updateAc.setSelectNum(queryById.getSelectNum() + 1);
				acticitiesBO.update(updateAc);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		entity.setCreatetime(new Date());
		
		promotersBO.create(entity);
		return loge;
	}

	//随机红包  分为单位
	public static String getRedFanPrice(){
		Random rd = new Random();
		int result=rd.nextInt(10);
		if(result == 9){
			int nextInt = rd.nextInt(2);
			int price = (nextInt + 4) * 100;
			return price + "";
		}else{
			int nextInt = rd.nextInt(3);
			int price = (nextInt + 1) * 100;
			return price + "";
		}
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
		String promotersData = vxBuyInfoEntity.getPromotersData();//推广人代码
		String data = vxBuyInfoEntity.getData();//购买人代码
		VxActivitiesEntity queryById = acticitiesBO.queryById(vxBuyInfoEntity.getActivitiesId());
		if(promotersData != null && 
				!"".equals(promotersData.trim()) &&
				queryById != null //判断活动 推广员是否存在
				){
				if(!data.equals(promotersData)){//购买人的代码和推广人的代码不一样才返现
					//判断该推广员是否购买了该活动产品
					VxBuyInfoEntity queryPro = new VxBuyInfoEntity();
					queryPro.setData(promotersData);
					queryPro.setStatus("1");
					List<VxBuyInfoEntity> payList = buyInfoBO.queryListByEntity(queryPro);
					if(payList != null && payList.size() > 0){
						try {
							Props PathProps = new Props("pathConf.properties");
							String ip =PathProps.getProperty("file.vx.pay.red.ip");
							String filePath =PathProps.getProperty("file.mch");
							
				            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
							String strMch_billnoA = "DDWA" + sdf.format(new Date());
							String MHCname = queryById.getRedpackTitle();
							String priceA = getRedFanPrice(); //价格
							
							//购买人返现1~5块
							VxRedPackUtil.sendRedPack(strMch_billnoA,
									data,
									MHCname,priceA,"1",
									queryById.getRedpackContent(),"提成红包","谢谢您的推广!",ip,filePath);
							
							String strMch_billnoB = "DDWB" + sdf.format(new Date());
							//分享人返现5块
							VxRedPackUtil.sendRedPack(strMch_billnoB,
									promotersData,
									MHCname,"500","1",
									queryById.getRedpackContent(),"提成红包","谢谢您的推广!",ip,filePath);
							vxBuyInfoEntity.setReMoney(new BigDecimal(500));
							vxBuyInfoEntity.setShareMoney(new BigDecimal(priceA));
						} catch (Exception e) {
							e.printStackTrace();
						}
				}
			}else{
				vxBuyInfoEntity.setShareStatus("0");
			}
		}
		VxActivitiesEntity nowActi = acticitiesBO.queryById(vxBuyInfoEntity.getActivitiesId());
		if(nowActi != null){
			VxActivitiesEntity updateAc = new VxActivitiesEntity();
			updateAc.setId(nowActi.getId());
			updateAc.setPayNum(nowActi.getPayNum() + 1);
			acticitiesBO.update(updateAc);
		}
		vxBuyInfoEntity.setStatus("1");
		buyInfoBO.update(vxBuyInfoEntity);
	}

	@Override
	public Long createVxLog(String aid, String fx) {
		if(aid == null)return null;
		try {
			VxLogEntity le = new VxLogEntity();
			le.setAid(Long.parseLong(aid));
			le.setCreatetime(new Date());
			le.setPromotersData(fx);
			logBO.create(le);
			return le.getId();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return null;
	}

}
