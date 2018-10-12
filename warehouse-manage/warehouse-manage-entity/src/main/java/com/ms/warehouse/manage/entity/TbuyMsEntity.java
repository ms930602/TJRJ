
package com.ms.warehouse.manage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 
 * @author Ms
 * @Date 2018-10-12 15:19:00
 * @since 1.0
 */
@TableName("t_buy_ms")
public class TbuyMsEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** 主键. */
	private Long id;
	
	/** 物品外键. */
	private Long itemId;
	
	/** 数量. */
	private java.math.BigDecimal quantity;
	
	/** 买入价格. */
	private java.math.BigDecimal price;
	
	/** 买入时间. */
	private java.util.Date buyTime;
	
	/** 到期日期. */
	private java.util.Date existTime;
	
	/** 备注. */
	private String remark;
	
	/** 创建时间. */
	private java.util.Date createtime;
	
	

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
	

    /** set 物品外键. */
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	
	/** get 物品外键. */
	public Long getItemId() {
		return this.itemId;
	}
	
	@JsonIgnore
	public Long getItemIdByLike() {
		return this.itemId;
	}
	

    /** set 数量. */
	public void setQuantity(java.math.BigDecimal quantity) {
		this.quantity = quantity;
	}
	
	/** get 数量. */
	public java.math.BigDecimal getQuantity() {
		return this.quantity;
	}
	
	@JsonIgnore
	public java.math.BigDecimal getQuantityByLike() {
		return this.quantity;
	}
	

    /** set 买入价格. */
	public void setPrice(java.math.BigDecimal price) {
		this.price = price;
	}
	
	/** get 买入价格. */
	public java.math.BigDecimal getPrice() {
		return this.price;
	}
	
	@JsonIgnore
	public java.math.BigDecimal getPriceByLike() {
		return this.price;
	}
	

    /** set 买入时间. */
	public void setBuyTime(java.util.Date buyTime) {
		this.buyTime = buyTime;
	}
	
	/** get 买入时间. */
	public java.util.Date getBuyTime() {
		return this.buyTime;
	}
	
	@JsonIgnore
	public java.util.Date getBuyTimeByLike() {
		return this.buyTime;
	}
	

    /** set 到期日期. */
	public void setExistTime(java.util.Date existTime) {
		this.existTime = existTime;
	}
	
	/** get 到期日期. */
	public java.util.Date getExistTime() {
		return this.existTime;
	}
	
	@JsonIgnore
	public java.util.Date getExistTimeByLike() {
		return this.existTime;
	}
	

    /** set 备注. */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/** get 备注. */
	public String getRemark() {
		return this.remark;
	}
	
	@JsonIgnore
	public String getRemarkByLike() {
		return "%"+this.remark+"%";
	}
	

    /** set 创建时间. */
	public void setCreatetime(java.util.Date createtime) {
		this.createtime = createtime;
	}
	
	/** get 创建时间. */
	public java.util.Date getCreatetime() {
		return this.createtime;
	}
	
	@JsonIgnore
	public java.util.Date getCreatetimeByLike() {
		return this.createtime;
	}
	
    /** constructor */
	public TbuyMsEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param itemId			物品外键
	 * @param quantity			数量
	 * @param price			买入价格
	 * @param buyTime			买入时间
	 * @param existTime			到期日期
	 * @param remark			备注
	 * @param createtime			创建时间
	 */
	public TbuyMsEntity(Long itemId,java.math.BigDecimal quantity,java.math.BigDecimal price,java.util.Date buyTime,java.util.Date existTime,String remark,java.util.Date createtime){
		this();
		this.itemId = itemId;
		this.quantity = quantity;
		this.price = price;
		this.buyTime = buyTime;
		this.existTime = existTime;
		this.remark = remark;
		this.createtime = createtime;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("TbuyMsEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("ItemId=").append(getItemId()).append(", ")
			.append("Quantity=").append(getQuantity()).append(", ")
			.append("Price=").append(getPrice()).append(", ")
			.append("BuyTime=").append(getBuyTime()).append(", ")
			.append("ExistTime=").append(getExistTime()).append(", ")
			.append("Remark=").append(getRemark()).append(", ")
			.append("Createtime=").append(getCreatetime())
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
		if(obj instanceof TbuyMsEntity == false)
			return false;
		if(this == obj)
			return true;
		TbuyMsEntity other = (TbuyMsEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
