
package com.ms.warehouse.car.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 
 * @author Ms
 * @Date 2018-11-09 10:05:05
 * @since 1.0
 */
@TableName("t_car_brand")
public class CarBrandEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** . */
	private Long id;
	
	/** . */
	private String name;
	
	/** . */
	private Long imgId;
	
	private String imgStr;
	
	/** . */
	private java.util.Date createtime;
	
    public String getImgStr() {
		return imgStr;
	}

	public void setImgStr(String imgStr) {
		this.imgStr = imgStr;
	}

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
	public void setName(String name) {
		this.name = name;
	}
	
	/** get . */
	public String getName() {
		return this.name;
	}
	
	@JsonIgnore
	public String getNameByLike() {
		return "%"+this.name+"%";
	}
	

    /** set . */
	public void setImgId(Long imgId) {
		this.imgId = imgId;
	}
	
	/** get . */
	public Long getImgId() {
		return this.imgId;
	}
	
	@JsonIgnore
	public Long getImgIdByLike() {
		return this.imgId;
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
	public CarBrandEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param name			
	 * @param imgId			
	 * @param createtime			
	 */
	public CarBrandEntity(String name,Long imgId,java.util.Date createtime){
		this();
		this.name = name;
		this.imgId = imgId;
		this.createtime = createtime;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("CarBrandEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("Name=").append(getName()).append(", ")
			.append("ImgId=").append(getImgId()).append(", ")
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
		if(obj instanceof CarBrandEntity == false)
			return false;
		if(this == obj)
			return true;
		CarBrandEntity other = (CarBrandEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
