
package com.ms.warehouse.manage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 
 * @author Ms
 * @Date 2018-10-13 15:55:32
 * @since 1.0
 */
@TableName("t_sell_ms")
public class SellMsEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** 主键. */
	private Long id;
	
	/** 物品外键. */
	private Long itemId;
	
	/** 数量. */
	private java.math.BigDecimal quantity;
	
	/** 卖出价格. */
	private java.math.BigDecimal price;
	
	/** 卖出时间. */
	private java.util.Date sellTime;
	
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
	

    /** set 卖出价格. */
	public void setPrice(java.math.BigDecimal price) {
		this.price = price;
	}
	
	/** get 卖出价格. */
	public java.math.BigDecimal getPrice() {
		return this.price;
	}
	
	@JsonIgnore
	public java.math.BigDecimal getPriceByLike() {
		return this.price;
	}
	

    /** set 卖出时间. */
	public void setSellTime(java.util.Date sellTime) {
		this.sellTime = sellTime;
	}
	
	/** get 卖出时间. */
	public java.util.Date getSellTime() {
		return this.sellTime;
	}
	
	@JsonIgnore
	public java.util.Date getSellTimeByLike() {
		return this.sellTime;
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
	public SellMsEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param itemId			物品外键
	 * @param quantity			数量
	 * @param price			卖出价格
	 * @param sellTime			卖出时间
	 * @param remark			备注
	 * @param createtime			创建时间
	 */
	public SellMsEntity(Long itemId,java.math.BigDecimal quantity,java.math.BigDecimal price,java.util.Date sellTime,String remark,java.util.Date createtime){
		this();
		this.itemId = itemId;
		this.quantity = quantity;
		this.price = price;
		this.sellTime = sellTime;
		this.remark = remark;
		this.createtime = createtime;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("SellMsEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("ItemId=").append(getItemId()).append(", ")
			.append("Quantity=").append(getQuantity()).append(", ")
			.append("Price=").append(getPrice()).append(", ")
			.append("SellTime=").append(getSellTime()).append(", ")
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
		if(obj instanceof SellMsEntity == false)
			return false;
		if(this == obj)
			return true;
		SellMsEntity other = (SellMsEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
