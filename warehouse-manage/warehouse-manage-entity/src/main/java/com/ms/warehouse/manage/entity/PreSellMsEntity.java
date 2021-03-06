
package com.ms.warehouse.manage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 
 * @author Ms
 * @Date 2018-10-13 15:55:29
 * @since 1.0
 */
@TableName("t_pre_sell_ms")
public class PreSellMsEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** 主键. */
	private Long id;
	
	/** 物品外键. */
	private Long itemId;
	
	/** 预卖数量. */
	private java.math.BigDecimal quantity;
	
	/** 预计价格. */
	private java.math.BigDecimal price;
	
	/** 预卖出时间. */
	private java.util.Date time;
	
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
	

    /** set 预卖数量. */
	public void setQuantity(java.math.BigDecimal quantity) {
		this.quantity = quantity;
	}
	
	/** get 预卖数量. */
	public java.math.BigDecimal getQuantity() {
		return this.quantity;
	}
	
	@JsonIgnore
	public java.math.BigDecimal getQuantityByLike() {
		return this.quantity;
	}
	

    /** set 预计价格. */
	public void setPrice(java.math.BigDecimal price) {
		this.price = price;
	}
	
	/** get 预计价格. */
	public java.math.BigDecimal getPrice() {
		return this.price;
	}
	
	@JsonIgnore
	public java.math.BigDecimal getPriceByLike() {
		return this.price;
	}
	

    /** set 预卖出时间. */
	public void setTime(java.util.Date time) {
		this.time = time;
	}
	
	/** get 预卖出时间. */
	public java.util.Date getTime() {
		return this.time;
	}
	
	@JsonIgnore
	public java.util.Date getTimeByLike() {
		return this.time;
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
	public PreSellMsEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param itemId			物品外键
	 * @param quantity			预卖数量
	 * @param price			预计价格
	 * @param time			预卖出时间
	 * @param remark			备注
	 * @param createtime			创建时间
	 */
	public PreSellMsEntity(Long itemId,java.math.BigDecimal quantity,java.math.BigDecimal price,java.util.Date time,String remark,java.util.Date createtime){
		this();
		this.itemId = itemId;
		this.quantity = quantity;
		this.price = price;
		this.time = time;
		this.remark = remark;
		this.createtime = createtime;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("PreSellMsEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("ItemId=").append(getItemId()).append(", ")
			.append("Quantity=").append(getQuantity()).append(", ")
			.append("Price=").append(getPrice()).append(", ")
			.append("Time=").append(getTime()).append(", ")
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
		if(obj instanceof PreSellMsEntity == false)
			return false;
		if(this == obj)
			return true;
		PreSellMsEntity other = (PreSellMsEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
