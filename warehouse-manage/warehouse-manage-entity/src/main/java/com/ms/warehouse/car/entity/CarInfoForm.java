package com.ms.warehouse.car.entity;

import java.util.List;

import com.ms.warehouse.inventory.entity.BaseUploadfilerecodeEntity;

public class CarInfoForm extends CarInfoEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private BaseUploadfilerecodeEntity topImgObj;
	
	private List<BaseUploadfilerecodeEntity> detailImgObj;
	
	public CarInfoForm() {
	}

	public CarInfoForm(CarInfoEntity temp) {
		/** 主键. */
		this.setId(temp.getId());
		/** 标题. */
		this.setTitle(temp.getTitle());
		/** 低价. */
		this.setPrice(temp.getPrice());
		/** 参考价. */
		this.setConsultPrice(temp.getConsultPrice());
		/** 新车价格. */
		this.setNewPrice(temp.getNewPrice());
		/** 显示价格. */
		this.setShowPrice(temp.getShowPrice());
		/** 关注数. */
		this.setShowflag(temp.getShowflag());
		/** 截止日期. */
		this.setEndTime(temp.getEndTime());
		/** 地点城市. */
		this.setAddress(temp.getAddress());
		/** 过户次数. */
		this.setTransferNum(temp.getTransferNum());
		/** 是否含过户费 0 不含 1反之. */
		this.setTransferPriceState(temp.getTransferPriceState());
		/** 表显里程万里为单位. */
		this.setMileage(temp.getMileage());
		/** 上牌日期. */
		this.setUpbkTime(temp.getUpbkTime());
		/** 档位 自动挡 手动挡. */
		this.setDw(temp.getDw());
		/** 排量. */
		this.setPl(temp.getPl());
		/** 拍照归属. */
		this.setBkCitiy(temp.getBkCitiy());
		/** 限迁标准. */
		this.setXqbz(temp.getXqbz());
		/** 描述. */
		this.setRemark(temp.getRemark());
		/** 0 正常 1锁定. */
		this.setStatus(temp.getStatus());
		/** 头图片. */
		this.setTopImg(temp.getTopImg());
		/** 图片 id 以逗号隔开. */
		this.setImgs(temp.getImgs());
		/** 1 上架 0 下架. */
		this.setTransactionStatu(temp.getTransactionStatu());
		/** 是否特价 0 不是特价 1 特价. */
		this.setOfferStatue(temp.getOfferStatue());
		/** 品牌. */
		this.setBrand(temp.getBrand());
		/** 车型. */
		this.setType(temp.getType());
		/** 外键. */
		this.setPkId(temp.getPkId());
		/** 扩展字段. */
		this.setStrA(temp.getStrA());
		/** 扩展字段2. */
		this.setStrB(temp.getStrB());
		/** 扩展字段3. */
		this.setIntA(temp.getIntA());
		/** 扩展字段4. */
		this.setIntB(temp.getIntB());
		this.setFirstPrice(temp.getFirstPrice());
		this.setCreatetime(temp.getCreatetime());
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
	
	
}
