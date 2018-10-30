
package com.ms.warehouse.manage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 
 * @author Ms
 * @Date 2018-10-30 14:34:47
 * @since 1.0
 */
@TableName("t_vx_log")
public class VxLogEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** . */
	private Long id;
	
	/** . */
	private Long aid;
	
	/** 返现推广员CODE. */
	private String promotersData;
	
	/** . */
	private java.util.Date createtime;
	
	

    /** set . */
	public void setId(Long id) {
		this.id = id;
	}
	
	/** get . */
	public Long getId() {
		return this.id;
	}
	
	@JsonIgnore
	public Long getIdByLike() {
		return this.id;
	}
	

    /** set . */
	public void setAid(Long aid) {
		this.aid = aid;
	}
	
	/** get . */
	public Long getAid() {
		return this.aid;
	}
	
	@JsonIgnore
	public Long getAidByLike() {
		return this.aid;
	}
	

    /** set 返现推广员CODE. */
	public void setPromotersData(String promotersData) {
		this.promotersData = promotersData;
	}
	
	/** get 返现推广员CODE. */
	public String getPromotersData() {
		return this.promotersData;
	}
	
	@JsonIgnore
	public String getPromotersDataByLike() {
		return "%"+this.promotersData+"%";
	}
	

    /** set . */
	public void setCreatetime(java.util.Date createtime) {
		this.createtime = createtime;
	}
	
	/** get . */
	public java.util.Date getCreatetime() {
		return this.createtime;
	}
	
	@JsonIgnore
	public java.util.Date getCreatetimeByLike() {
		return this.createtime;
	}
	
    /** constructor */
	public VxLogEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param aid			
	 * @param promotersData			返现推广员CODE
	 * @param createtime			
	 */
	public VxLogEntity(Long aid,String promotersData,java.util.Date createtime){
		this();
		this.aid = aid;
		this.promotersData = promotersData;
		this.createtime = createtime;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("VxLogEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("Aid=").append(getAid()).append(", ")
			.append("PromotersData=").append(getPromotersData()).append(", ")
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
		if(obj instanceof VxLogEntity == false)
			return false;
		if(this == obj)
			return true;
		VxLogEntity other = (VxLogEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
