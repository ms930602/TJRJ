
package com.ms.warehouse.manage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 
 * @author Ms
 * @Date 2018-10-13 15:55:19
 * @since 1.0
 */
@TableName("t_game_ms")
public class GameMsEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** 主键. */
	private Long id;
	
	/** 名称. */
	private String name;
	
	/** 类型. */
	private Long type;
	
	/** 创建时间. */
	private java.util.Date createtime;
	
	/** 扩展字段1. */
	private Long columnA;
	
	/** 扩展字段2. */
	private Long columnB;
	
	/** 扩展字段3. */
	private String columnC;
	
	/** 扩展字段4. */
	private String columnD;
	
	

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
	public void setType(Long type) {
		this.type = type;
	}
	
	/** get 类型. */
	public Long getType() {
		return this.type;
	}
	
	@JsonIgnore
	public Long getTypeByLike() {
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
	

    /** set 扩展字段1. */
	public void setColumnA(Long columnA) {
		this.columnA = columnA;
	}
	
	/** get 扩展字段1. */
	public Long getColumnA() {
		return this.columnA;
	}
	
	@JsonIgnore
	public Long getColumnAByLike() {
		return this.columnA;
	}
	

    /** set 扩展字段2. */
	public void setColumnB(Long columnB) {
		this.columnB = columnB;
	}
	
	/** get 扩展字段2. */
	public Long getColumnB() {
		return this.columnB;
	}
	
	@JsonIgnore
	public Long getColumnBByLike() {
		return this.columnB;
	}
	

    /** set 扩展字段3. */
	public void setColumnC(String columnC) {
		this.columnC = columnC;
	}
	
	/** get 扩展字段3. */
	public String getColumnC() {
		return this.columnC;
	}
	
	@JsonIgnore
	public String getColumnCByLike() {
		return "%"+this.columnC+"%";
	}
	

    /** set 扩展字段4. */
	public void setColumnD(String columnD) {
		this.columnD = columnD;
	}
	
	/** get 扩展字段4. */
	public String getColumnD() {
		return this.columnD;
	}
	
	@JsonIgnore
	public String getColumnDByLike() {
		return "%"+this.columnD+"%";
	}
	
    /** constructor */
	public GameMsEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param name			名称
	 * @param type			类型
	 * @param createtime			创建时间
	 * @param columnA			扩展字段1
	 * @param columnB			扩展字段2
	 * @param columnC			扩展字段3
	 * @param columnD			扩展字段4
	 */
	public GameMsEntity(String name,Long type,java.util.Date createtime,Long columnA,Long columnB,String columnC,String columnD){
		this();
		this.name = name;
		this.type = type;
		this.createtime = createtime;
		this.columnA = columnA;
		this.columnB = columnB;
		this.columnC = columnC;
		this.columnD = columnD;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("GameMsEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("Name=").append(getName()).append(", ")
			.append("Type=").append(getType()).append(", ")
			.append("Createtime=").append(getCreatetime()).append(", ")
			.append("ColumnA=").append(getColumnA()).append(", ")
			.append("ColumnB=").append(getColumnB()).append(", ")
			.append("ColumnC=").append(getColumnC()).append(", ")
			.append("ColumnD=").append(getColumnD())
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
		if(obj instanceof GameMsEntity == false)
			return false;
		if(this == obj)
			return true;
		GameMsEntity other = (GameMsEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
