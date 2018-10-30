package com.ms.warehouse.manage.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.inventory.entity.BaseUploadfilerecodeEntity;

public class VxFormEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 活动名称
	 */
	private String activitiName;
	/**
	 * 活动结束时间
	 */
	private Date endTime;
	/**
	 * 购买人数
	 */
	private Long buyPeopleNum;
	
	/**
	 * 浏览人数
	 */
	private Long showPeopleNum;
	
	/** 价格. */
	private java.math.BigDecimal price;
	/**
	 * 门户图片
	 */
	private String topImg;
	/**
	 * 活动限额
	 */
	private Long peopleBan;
	
	/** 客户名称. */
	private String khName;
	
	private String kgPhone;
	
	/** 红包标题. */
	private String redpackTitle;
	
	/** 红包描述. */
	private String redpackContent;
	
	/**
	 * 推广员排名
	 */
	private List<Map<String, String>> promtersList;
	
	/**
	 * 详情页面
	 */
	private List<String> detailImg;
	
	private String mp3Path;
	
	private String mp3Name;
	
	private String vxText;
	
	private VxMerchantEntity merchant;
	
	public String getKgPhone() {
		return kgPhone;
	}

	public void setKgPhone(String kgPhone) {
		this.kgPhone = kgPhone;
	}

	public String getKhName() {
		return khName;
	}

	public void setKhName(String khName) {
		this.khName = khName;
	}

	public String getRedpackTitle() {
		return redpackTitle;
	}

	public void setRedpackTitle(String redpackTitle) {
		this.redpackTitle = redpackTitle;
	}

	public String getRedpackContent() {
		return redpackContent;
	}

	public void setRedpackContent(String redpackContent) {
		this.redpackContent = redpackContent;
	}

	public VxMerchantEntity getMerchant() {
		return merchant;
	}

	public void setMerchant(VxMerchantEntity merchant) {
		this.merchant = merchant;
	}

	public String getVxText() {
		return vxText;
	}

	public void setVxText(String vxText) {
		this.vxText = vxText;
	}

	public VxFormEntity() {
	}
	
	public VxFormEntity(VxActivitiesFormEntity formEntity) {
		this.setActivitiName(formEntity.getTitle());
		this.setBuyPeopleNum(formEntity.getPayNum());
		this.setEndTime(formEntity.getStartTime());
		this.setPeopleBan(formEntity.getPeopleNum());
		this.setShowPeopleNum(formEntity.getSelectNum());
		this.setPrice(formEntity.getPrice());
		this.setVxText(formEntity.getVxText());
		this.setKgPhone(formEntity.getPhone());
		this.setKhName(formEntity.getKhName());
		this.setRedpackTitle(formEntity.getRedpackTitle());
		this.setRedpackContent(formEntity.getRedpackContent());
		BaseUploadfilerecodeEntity musicObj = formEntity.getMusicObj();
		if(musicObj!=null){
			this.setMp3Path(musicObj.getFilePath());
			this.setMp3Name(musicObj.getFileName());
		}
		BaseUploadfilerecodeEntity topImgObj = formEntity.getTopImgObj();
		if(topImgObj!=null)
			this.setTopImg(topImgObj.getFilePath());
		List<BaseUploadfilerecodeEntity> detailImgObj = formEntity.getDetailImgObj();
		if(detailImgObj != null && detailImgObj.size() > 0){
			List<String> list = new ArrayList<String>();
			for (BaseUploadfilerecodeEntity temp : detailImgObj) {
				list.add(temp.getFilePath());
			}
			this.setDetailImg(list);
		}
	}
	
	public String getMp3Path() {
		return mp3Path;
	}

	public void setMp3Path(String mp3Path) {
		this.mp3Path = mp3Path;
	}

	public String getMp3Name() {
		return mp3Name;
	}

	public void setMp3Name(String mp3Name) {
		this.mp3Name = mp3Name;
	}

	public java.math.BigDecimal getPrice() {
		return price;
	}

	public void setPrice(java.math.BigDecimal price) {
		this.price = price;
	}

	public String getActivitiName() {
		return activitiName;
	}

	public void setActivitiName(String activitiName) {
		this.activitiName = activitiName;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Long getBuyPeopleNum() {
		return buyPeopleNum;
	}

	public void setBuyPeopleNum(Long buyPeopleNum) {
		this.buyPeopleNum = buyPeopleNum;
	}

	public Long getShowPeopleNum() {
		return showPeopleNum;
	}

	public void setShowPeopleNum(Long showPeopleNum) {
		this.showPeopleNum = showPeopleNum;
	}

	public String getTopImg() {
		return topImg;
	}

	public void setTopImg(String topImg) {
		this.topImg = topImg;
	}

	public Long getPeopleBan() {
		return peopleBan;
	}

	public void setPeopleBan(Long peopleBan) {
		this.peopleBan = peopleBan;
	}

	public List<Map<String, String>> getPromtersList() {
		return promtersList;
	}

	public void setPromtersList(List<Map<String, String>> promtersList) {
		this.promtersList = promtersList;
	}

	public List<String> getDetailImg() {
		return detailImg;
	}

	public void setDetailImg(List<String> detailImg) {
		this.detailImg = detailImg;
	}
	
}
