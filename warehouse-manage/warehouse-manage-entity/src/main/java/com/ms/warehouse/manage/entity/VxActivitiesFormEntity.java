package com.ms.warehouse.manage.entity;

import java.util.List;

import com.ms.warehouse.inventory.entity.BaseUploadfilerecodeEntity;

public class VxActivitiesFormEntity extends VxActivitiesEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BaseUploadfilerecodeEntity musicObj;
	
	private BaseUploadfilerecodeEntity topImgObj;
	
	private List<BaseUploadfilerecodeEntity> detailImgObj;

	public BaseUploadfilerecodeEntity getMusicObj() {
		return musicObj;
	}

	public void setMusicObj(BaseUploadfilerecodeEntity musicObj) {
		this.musicObj = musicObj;
	}

	public BaseUploadfilerecodeEntity getTopImgObj() {
		return topImgObj;
	}

	public void setTopImgObj(BaseUploadfilerecodeEntity topImgObj) {
		this.topImgObj = topImgObj;
	}

	public List<BaseUploadfilerecodeEntity> getDetailImgObj() {
		return detailImgObj;
	}

	public void setDetailImgObj(List<BaseUploadfilerecodeEntity> detailImgObj) {
		this.detailImgObj = detailImgObj;
	}
	
	public void copy(VxActivitiesEntity temp) {
		/** 主键. */
		this.setId( temp.getId() );
		/** 商户外键. */
		this.setMerchantId( temp.getMerchantId() );
		/** 标题. */
		this.setTitle( temp.getTitle() );
		/** 价格. */
		this.setPrice( temp.getPrice() );
		/** 门户图片 文件表ID. */
		this.setTopImg( temp.getTopImg() );
		/** 活动时间. */
		this.setStartTime( temp.getStartTime() );
		/** 活动音乐 文件表ID. */
		this.setMp3Id( temp.getMp3Id() );
		/** 活动人数. */
		this.setPeopleNum( temp.getPeopleNum() );
		/** 购买人数. */
		this.setPayNum( temp.getPayNum() );
		/** 浏览数. */
		this.setSelectNum( temp.getSelectNum() );
		/** 详情图片 门户图片 文件表ID 以逗号隔开. */
		this.setDetailImg( temp.getDetailImg() );
		/** 客户电话. */
		this.setPhone( temp.getPhone() );
		/** 1 作废 0 启用. */
		this.setStatus( temp.getStatus( ));
		this.setVxText( temp.getVxText() );
	}
	
}
