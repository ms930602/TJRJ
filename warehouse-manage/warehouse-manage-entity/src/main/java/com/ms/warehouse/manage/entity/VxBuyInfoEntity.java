
package com.ms.warehouse.manage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 
 * @author Ms
 * @Date 2018-10-21 19:40:52
 * @since 1.0
 */
@TableName("t_vx_buy_info")
public class VxBuyInfoEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** 主键. */
	private Long id;
	
	/** 购买人姓名. */
	private String name;
	
	/** 该买人手机号. */
	private String phone;
	
	/** 支付金额. */
	private java.math.BigDecimal money;
	
	/** 支付日期. */
	private java.util.Date buyTime;
	
	/** 返现推广人外键. */
	private Long promotersId;
	
	/** 返现推广员金额. */
	private java.math.BigDecimal reMoney;
	
	/** 是否分享 1分享 0 未分享. */
	private String shareStatus;
	
	/** 分享返现金额. */
	private java.math.BigDecimal shareMoney;
	
	

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
	

    /** set 购买人姓名. */
	public void setName(String name) {
		this.name = name;
	}
	
	/** get 购买人姓名. */
	public String getName() {
		return this.name;
	}
	
	@JsonIgnore
	public String getNameByLike() {
		return "%"+this.name+"%";
	}
	

    /** set 该买人手机号. */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/** get 该买人手机号. */
	public String getPhone() {
		return this.phone;
	}
	
	@JsonIgnore
	public String getPhoneByLike() {
		return "%"+this.phone+"%";
	}
	

    /** set 支付金额. */
	public void setMoney(java.math.BigDecimal money) {
		this.money = money;
	}
	
	/** get 支付金额. */
	public java.math.BigDecimal getMoney() {
		return this.money;
	}
	
	@JsonIgnore
	public java.math.BigDecimal getMoneyByLike() {
		return this.money;
	}
	

    /** set 支付日期. */
	public void setBuyTime(java.util.Date buyTime) {
		this.buyTime = buyTime;
	}
	
	/** get 支付日期. */
	public java.util.Date getBuyTime() {
		return this.buyTime;
	}
	
	@JsonIgnore
	public java.util.Date getBuyTimeByLike() {
		return this.buyTime;
	}
	

    /** set 返现推广人外键. */
	public void setPromotersId(Long promotersId) {
		this.promotersId = promotersId;
	}
	
	/** get 返现推广人外键. */
	public Long getPromotersId() {
		return this.promotersId;
	}
	
	@JsonIgnore
	public Long getPromotersIdByLike() {
		return this.promotersId;
	}
	

    /** set 返现推广员金额. */
	public void setReMoney(java.math.BigDecimal reMoney) {
		this.reMoney = reMoney;
	}
	
	/** get 返现推广员金额. */
	public java.math.BigDecimal getReMoney() {
		return this.reMoney;
	}
	
	@JsonIgnore
	public java.math.BigDecimal getReMoneyByLike() {
		return this.reMoney;
	}
	

    /** set 是否分享 1分享 0 未分享. */
	public void setShareStatus(String shareStatus) {
		this.shareStatus = shareStatus;
	}
	
	/** get 是否分享 1分享 0 未分享. */
	public String getShareStatus() {
		return this.shareStatus;
	}
	
	@JsonIgnore
	public String getShareStatusByLike() {
		return this.shareStatus;
	}
	

    /** set 分享返现金额. */
	public void setShareMoney(java.math.BigDecimal shareMoney) {
		this.shareMoney = shareMoney;
	}
	
	/** get 分享返现金额. */
	public java.math.BigDecimal getShareMoney() {
		return this.shareMoney;
	}
	
	@JsonIgnore
	public java.math.BigDecimal getShareMoneyByLike() {
		return this.shareMoney;
	}
	
    /** constructor */
	public VxBuyInfoEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param name			购买人姓名
	 * @param phone			该买人手机号
	 * @param money			支付金额
	 * @param buyTime			支付日期
	 * @param promotersId			返现推广人外键
	 * @param reMoney			返现推广员金额
	 * @param shareStatus			是否分享 1分享 0 未分享
	 * @param shareMoney			分享返现金额
	 */
	public VxBuyInfoEntity(String name,String phone,java.math.BigDecimal money,java.util.Date buyTime,Long promotersId,java.math.BigDecimal reMoney,String shareStatus,java.math.BigDecimal shareMoney){
		this();
		this.name = name;
		this.phone = phone;
		this.money = money;
		this.buyTime = buyTime;
		this.promotersId = promotersId;
		this.reMoney = reMoney;
		this.shareStatus = shareStatus;
		this.shareMoney = shareMoney;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("VxBuyInfoEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("Name=").append(getName()).append(", ")
			.append("Phone=").append(getPhone()).append(", ")
			.append("Money=").append(getMoney()).append(", ")
			.append("BuyTime=").append(getBuyTime()).append(", ")
			.append("PromotersId=").append(getPromotersId()).append(", ")
			.append("ReMoney=").append(getReMoney()).append(", ")
			.append("ShareStatus=").append(getShareStatus()).append(", ")
			.append("ShareMoney=").append(getShareMoney())
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
		if(obj instanceof VxBuyInfoEntity == false)
			return false;
		if(this == obj)
			return true;
		VxBuyInfoEntity other = (VxBuyInfoEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
