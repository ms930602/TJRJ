
package com.ms.warehouse.car.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 
 * @author Ms
 * @Date 2018-11-05 16:19:25
 * @since 1.0
 */
@TableName("t_car_info")
public class CarInfoEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** 主键. */
	private Long id;
	
	/** 标题. */
	private String title;
	
	/** 低价. */
	private java.math.BigDecimal price;
	
	/** 参考价. */
	private String consultPrice;
	
	/** 新车价格. */
	private java.math.BigDecimal newPrice;
	
	/** 显示价格. */
	private java.math.BigDecimal showPrice;
	
	/** 关注数. */
	private Long showflag;
	
	/** 截止日期. */
	private java.util.Date endTime;
	
	/** 地点城市. */
	private String address;
	
	/** 过户次数. */
	private Long transferNum;
	
	/** 是否含过户费 0 不含 1反之. */
	private String transferPriceState;
	
	/** 表显里程万里为单位. */
	private String mileage;
	
	/** 上牌日期. */
	private java.util.Date upbkTime;
	
	/** 档位 自动挡 手动挡. */
	private String dw;
	
	/** 排量. */
	private String pl;
	
	/** 拍照归属. */
	private String bkCitiy;
	
	/** 限迁标准. */
	private String xqbz;
	
	/** 描述. */
	private String remark;
	
	/** 0 正常 1锁定. */
	private String status;
	
	/** 头图片. */
	private String topImg;
	
	/** 图片 id 以逗号隔开. */
	private String imgs;
	
	/** 1 上架 0 下架. */
	private String transactionStatu;
	
	/** 是否特价 0 不是特价 1 特价. */
	private String offerStatue;
	
	/** 品牌. */
	private String brand;
	
	/** 车型. */
	private String type;
	
	/** 外键. */
	private Long pkId;
	
	/** 扩展字段. */
	private String strA;
	
	/** 扩展字段2. */
	private String strB;
	
	/** 扩展字段3. */
	private Long intA;
	
	/** 扩展字段4. */
	private Long intB;
	
	

    /** set 主键. */
	public void setId(Long id) {
		this.id = id;
	}
	
	/** get 主键. */
	public Long getId() {
		return this.id;
	}
	
	@JsonIgnore
	public Long getIdByLike() {
		return this.id;
	}
	

    /** set 标题. */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/** get 标题. */
	public String getTitle() {
		return this.title;
	}
	
	@JsonIgnore
	public String getTitleByLike() {
		return "%"+this.title+"%";
	}
	

    /** set 低价. */
	public void setPrice(java.math.BigDecimal price) {
		this.price = price;
	}
	
	/** get 低价. */
	public java.math.BigDecimal getPrice() {
		return this.price;
	}
	
	@JsonIgnore
	public java.math.BigDecimal getPriceByLike() {
		return this.price;
	}
	

    /** set 参考价. */
	public void setConsultPrice(String consultPrice) {
		this.consultPrice = consultPrice;
	}
	
	/** get 参考价. */
	public String getConsultPrice() {
		return this.consultPrice;
	}
	
	@JsonIgnore
	public String getConsultPriceByLike() {
		return "%"+this.consultPrice+"%";
	}
	

    /** set 新车价格. */
	public void setNewPrice(java.math.BigDecimal newPrice) {
		this.newPrice = newPrice;
	}
	
	/** get 新车价格. */
	public java.math.BigDecimal getNewPrice() {
		return this.newPrice;
	}
	
	@JsonIgnore
	public java.math.BigDecimal getNewPriceByLike() {
		return this.newPrice;
	}
	

    /** set 显示价格. */
	public void setShowPrice(java.math.BigDecimal showPrice) {
		this.showPrice = showPrice;
	}
	
	/** get 显示价格. */
	public java.math.BigDecimal getShowPrice() {
		return this.showPrice;
	}
	
	@JsonIgnore
	public java.math.BigDecimal getShowPriceByLike() {
		return this.showPrice;
	}
	

    /** set 关注数. */
	public void setShowflag(Long showflag) {
		this.showflag = showflag;
	}
	
	/** get 关注数. */
	public Long getShowflag() {
		return this.showflag;
	}
	
	@JsonIgnore
	public Long getShowflagByLike() {
		return this.showflag;
	}
	

    /** set 截止日期. */
	public void setEndTime(java.util.Date endTime) {
		this.endTime = endTime;
	}
	
	/** get 截止日期. */
	public java.util.Date getEndTime() {
		return this.endTime;
	}
	
	@JsonIgnore
	public java.util.Date getEndTimeByLike() {
		return this.endTime;
	}
	

    /** set 地点城市. */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/** get 地点城市. */
	public String getAddress() {
		return this.address;
	}
	
	@JsonIgnore
	public String getAddressByLike() {
		return "%"+this.address+"%";
	}
	

    /** set 过户次数. */
	public void setTransferNum(Long transferNum) {
		this.transferNum = transferNum;
	}
	
	/** get 过户次数. */
	public Long getTransferNum() {
		return this.transferNum;
	}
	
	@JsonIgnore
	public Long getTransferNumByLike() {
		return this.transferNum;
	}
	

    /** set 是否含过户费 0 不含 1反之. */
	public void setTransferPriceState(String transferPriceState) {
		this.transferPriceState = transferPriceState;
	}
	
	/** get 是否含过户费 0 不含 1反之. */
	public String getTransferPriceState() {
		return this.transferPriceState;
	}
	
	@JsonIgnore
	public String getTransferPriceStateByLike() {
		return this.transferPriceState;
	}
	

    /** set 表显里程万里为单位. */
	public void setMileage(String mileage) {
		this.mileage = mileage;
	}
	
	/** get 表显里程万里为单位. */
	public String getMileage() {
		return this.mileage;
	}
	
	@JsonIgnore
	public String getMileageByLike() {
		return "%"+this.mileage+"%";
	}
	

    /** set 上牌日期. */
	public void setUpbkTime(java.util.Date upbkTime) {
		this.upbkTime = upbkTime;
	}
	
	/** get 上牌日期. */
	public java.util.Date getUpbkTime() {
		return this.upbkTime;
	}
	
	@JsonIgnore
	public java.util.Date getUpbkTimeByLike() {
		return this.upbkTime;
	}
	

    /** set 档位 自动挡 手动挡. */
	public void setDw(String dw) {
		this.dw = dw;
	}
	
	/** get 档位 自动挡 手动挡. */
	public String getDw() {
		return this.dw;
	}
	
	@JsonIgnore
	public String getDwByLike() {
		return "%"+this.dw+"%";
	}
	

    /** set 排量. */
	public void setPl(String pl) {
		this.pl = pl;
	}
	
	/** get 排量. */
	public String getPl() {
		return this.pl;
	}
	
	@JsonIgnore
	public String getPlByLike() {
		return "%"+this.pl+"%";
	}
	

    /** set 拍照归属. */
	public void setBkCitiy(String bkCitiy) {
		this.bkCitiy = bkCitiy;
	}
	
	/** get 拍照归属. */
	public String getBkCitiy() {
		return this.bkCitiy;
	}
	
	@JsonIgnore
	public String getBkCitiyByLike() {
		return "%"+this.bkCitiy+"%";
	}
	

    /** set 限迁标准. */
	public void setXqbz(String xqbz) {
		this.xqbz = xqbz;
	}
	
	/** get 限迁标准. */
	public String getXqbz() {
		return this.xqbz;
	}
	
	@JsonIgnore
	public String getXqbzByLike() {
		return "%"+this.xqbz+"%";
	}
	

    /** set 描述. */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/** get 描述. */
	public String getRemark() {
		return this.remark;
	}
	
	@JsonIgnore
	public String getRemarkByLike() {
		return this.remark;
	}
	

    /** set 0 正常 1锁定. */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/** get 0 正常 1锁定. */
	public String getStatus() {
		return this.status;
	}
	
	@JsonIgnore
	public String getStatusByLike() {
		return this.status;
	}
	

    /** set 头图片. */
	public void setTopImg(String topImg) {
		this.topImg = topImg;
	}
	
	/** get 头图片. */
	public String getTopImg() {
		return this.topImg;
	}
	
	@JsonIgnore
	public String getTopImgByLike() {
		return "%"+this.topImg+"%";
	}
	

    /** set 图片 id 以逗号隔开. */
	public void setImgs(String imgs) {
		this.imgs = imgs;
	}
	
	/** get 图片 id 以逗号隔开. */
	public String getImgs() {
		return this.imgs;
	}
	
	@JsonIgnore
	public String getImgsByLike() {
		return "%"+this.imgs+"%";
	}
	

    /** set 1 上架 0 下架. */
	public void setTransactionStatu(String transactionStatu) {
		this.transactionStatu = transactionStatu;
	}
	
	/** get 1 上架 0 下架. */
	public String getTransactionStatu() {
		return this.transactionStatu;
	}
	
	@JsonIgnore
	public String getTransactionStatuByLike() {
		return this.transactionStatu;
	}
	

    /** set 是否特价 0 不是特价 1 特价. */
	public void setOfferStatue(String offerStatue) {
		this.offerStatue = offerStatue;
	}
	
	/** get 是否特价 0 不是特价 1 特价. */
	public String getOfferStatue() {
		return this.offerStatue;
	}
	
	@JsonIgnore
	public String getOfferStatueByLike() {
		return this.offerStatue;
	}
	

    /** set 品牌. */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	/** get 品牌. */
	public String getBrand() {
		return this.brand;
	}
	
	@JsonIgnore
	public String getBrandByLike() {
		return "%"+this.brand+"%";
	}
	

    /** set 车型. */
	public void setType(String type) {
		this.type = type;
	}
	
	/** get 车型. */
	public String getType() {
		return this.type;
	}
	
	@JsonIgnore
	public String getTypeByLike() {
		return "%"+this.type+"%";
	}
	

    /** set 外键. */
	public void setPkId(Long pkId) {
		this.pkId = pkId;
	}
	
	/** get 外键. */
	public Long getPkId() {
		return this.pkId;
	}
	
	@JsonIgnore
	public Long getPkIdByLike() {
		return this.pkId;
	}
	

    /** set 扩展字段. */
	public void setStrA(String strA) {
		this.strA = strA;
	}
	
	/** get 扩展字段. */
	public String getStrA() {
		return this.strA;
	}
	
	@JsonIgnore
	public String getStrAByLike() {
		return "%"+this.strA+"%";
	}
	

    /** set 扩展字段2. */
	public void setStrB(String strB) {
		this.strB = strB;
	}
	
	/** get 扩展字段2. */
	public String getStrB() {
		return this.strB;
	}
	
	@JsonIgnore
	public String getStrBByLike() {
		return "%"+this.strB+"%";
	}
	

    /** set 扩展字段3. */
	public void setIntA(Long intA) {
		this.intA = intA;
	}
	
	/** get 扩展字段3. */
	public Long getIntA() {
		return this.intA;
	}
	
	@JsonIgnore
	public Long getIntAByLike() {
		return this.intA;
	}
	

    /** set 扩展字段4. */
	public void setIntB(Long intB) {
		this.intB = intB;
	}
	
	/** get 扩展字段4. */
	public Long getIntB() {
		return this.intB;
	}
	
	@JsonIgnore
	public Long getIntBByLike() {
		return this.intB;
	}
	
    /** constructor */
	public CarInfoEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param title			标题
	 * @param price			低价
	 * @param consultPrice			参考价
	 * @param newPrice			新车价格
	 * @param showPrice			显示价格
	 * @param showflag			关注数
	 * @param endTime			截止日期
	 * @param address			地点城市
	 * @param transferNum			过户次数
	 * @param transferPriceState			是否含过户费 0 不含 1反之
	 * @param mileage			表显里程万里为单位
	 * @param upbkTime			上牌日期
	 * @param dw			档位 自动挡 手动挡
	 * @param pl			排量
	 * @param bkCitiy			拍照归属
	 * @param xqbz			限迁标准
	 * @param remark			描述
	 * @param status			0 正常 1锁定
	 * @param topImg			头图片
	 * @param imgs			图片 id 以逗号隔开
	 * @param transactionStatu			1 上架 0 下架
	 * @param offerStatue			是否特价 0 不是特价 1 特价
	 * @param brand			品牌
	 * @param type			车型
	 * @param pkId			外键
	 * @param strA			扩展字段
	 * @param strB			扩展字段2
	 * @param intA			扩展字段3
	 * @param intB			扩展字段4
	 */
	public CarInfoEntity(String title,java.math.BigDecimal price,String consultPrice,java.math.BigDecimal newPrice,java.math.BigDecimal showPrice,Long showflag,java.util.Date endTime,String address,Long transferNum,String transferPriceState,String mileage,java.util.Date upbkTime,String dw,String pl,String bkCitiy,String xqbz,String remark,String status,String topImg,String imgs,String transactionStatu,String offerStatue,String brand,String type,Long pkId,String strA,String strB,Long intA,Long intB){
		this();
		this.title = title;
		this.price = price;
		this.consultPrice = consultPrice;
		this.newPrice = newPrice;
		this.showPrice = showPrice;
		this.showflag = showflag;
		this.endTime = endTime;
		this.address = address;
		this.transferNum = transferNum;
		this.transferPriceState = transferPriceState;
		this.mileage = mileage;
		this.upbkTime = upbkTime;
		this.dw = dw;
		this.pl = pl;
		this.bkCitiy = bkCitiy;
		this.xqbz = xqbz;
		this.remark = remark;
		this.status = status;
		this.topImg = topImg;
		this.imgs = imgs;
		this.transactionStatu = transactionStatu;
		this.offerStatue = offerStatue;
		this.brand = brand;
		this.type = type;
		this.pkId = pkId;
		this.strA = strA;
		this.strB = strB;
		this.intA = intA;
		this.intB = intB;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("CarInfoEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("Title=").append(getTitle()).append(", ")
			.append("Price=").append(getPrice()).append(", ")
			.append("ConsultPrice=").append(getConsultPrice()).append(", ")
			.append("NewPrice=").append(getNewPrice()).append(", ")
			.append("ShowPrice=").append(getShowPrice()).append(", ")
			.append("Showflag=").append(getShowflag()).append(", ")
			.append("EndTime=").append(getEndTime()).append(", ")
			.append("Address=").append(getAddress()).append(", ")
			.append("TransferNum=").append(getTransferNum()).append(", ")
			.append("TransferPriceState=").append(getTransferPriceState()).append(", ")
			.append("Mileage=").append(getMileage()).append(", ")
			.append("UpbkTime=").append(getUpbkTime()).append(", ")
			.append("Dw=").append(getDw()).append(", ")
			.append("Pl=").append(getPl()).append(", ")
			.append("BkCitiy=").append(getBkCitiy()).append(", ")
			.append("Xqbz=").append(getXqbz()).append(", ")
			.append("Remark=").append(getRemark()).append(", ")
			.append("Status=").append(getStatus()).append(", ")
			.append("TopImg=").append(getTopImg()).append(", ")
			.append("Imgs=").append(getImgs()).append(", ")
			.append("TransactionStatu=").append(getTransactionStatu()).append(", ")
			.append("OfferStatue=").append(getOfferStatue()).append(", ")
			.append("Brand=").append(getBrand()).append(", ")
			.append("Type=").append(getType()).append(", ")
			.append("PkId=").append(getPkId()).append(", ")
			.append("StrA=").append(getStrA()).append(", ")
			.append("StrB=").append(getStrB()).append(", ")
			.append("IntA=").append(getIntA()).append(", ")
			.append("IntB=").append(getIntB())
		.append("]").toString();
	}
	
	@Override
	public int hashCode() {
		return toString().hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if(obj instanceof CarInfoEntity == false)
			return false;
		if(this == obj)
			return true;
		CarInfoEntity other = (CarInfoEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
