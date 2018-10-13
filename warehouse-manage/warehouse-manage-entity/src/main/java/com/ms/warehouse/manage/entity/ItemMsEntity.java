
package com.ms.warehouse.manage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 
 * @author Ms
 * @Date 2018-10-13 15:55:21
 * @since 1.0
 */
@TableName("t_item_ms")
public class ItemMsEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** 主键. */
	private Long id;
	
	/** 游戏外键. */
	private Long gameId;
	
	/** 名称. */
	private String name;
	
	/** 类型. */
	private String type;
	
	/** 创建时间. */
	private java.util.Date createtime;
	
	/** 修改时间. */
	private java.util.Date updatetime;
	
	/** 备注. */
	private byte[] remark;
	
	

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
	

    /** set 游戏外键. */
	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}
	
	/** get 游戏外键. */
	public Long getGameId() {
		return this.gameId;
	}
	
	@JsonIgnore
	public Long getGameIdByLike() {
		return this.gameId;
	}
	

    /** set 名称. */
	public void setName(String name) {
		this.name = name;
	}
	
	/** get 名称. */
	public String getName() {
		return this.name;
	}
	
	@JsonIgnore
	public String getNameByLike() {
		return "%"+this.name+"%";
	}
	

    /** set 类型. */
	public void setType(String type) {
		this.type = type;
	}
	
	/** get 类型. */
	public String getType() {
		return this.type;
	}
	
	@JsonIgnore
	public String getTypeByLike() {
		return this.type;
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
	

    /** set 修改时间. */
	public void setUpdatetime(java.util.Date updatetime) {
		this.updatetime = updatetime;
	}
	
	/** get 修改时间. */
	public java.util.Date getUpdatetime() {
		return this.updatetime;
	}
	
	@JsonIgnore
	public java.util.Date getUpdatetimeByLike() {
		return this.updatetime;
	}
	

    /** set 备注. */
	public void setRemark(byte[] remark) {
		this.remark = remark;
	}
	
	/** get 备注. */
	public byte[] getRemark() {
		return this.remark;
	}
	
	@JsonIgnore
	public byte[] getRemarkByLike() {
		return this.remark;
	}
	
    /** constructor */
	public ItemMsEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param gameId			游戏外键
	 * @param name			名称
	 * @param type			类型
	 * @param createtime			创建时间
	 * @param updatetime			修改时间
	 * @param remark			备注
	 */
	public ItemMsEntity(Long gameId,String name,String type,java.util.Date createtime,java.util.Date updatetime,byte[] remark){
		this();
		this.gameId = gameId;
		this.name = name;
		this.type = type;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.remark = remark;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("ItemMsEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("GameId=").append(getGameId()).append(", ")
			.append("Name=").append(getName()).append(", ")
			.append("Type=").append(getType()).append(", ")
			.append("Createtime=").append(getCreatetime()).append(", ")
			.append("Updatetime=").append(getUpdatetime()).append(", ")
			.append("Remark=").append(getRemark())
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
		if(obj instanceof ItemMsEntity == false)
			return false;
		if(this == obj)
			return true;
		ItemMsEntity other = (ItemMsEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
