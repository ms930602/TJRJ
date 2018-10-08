
package com.ms.warehouse.manage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 仓库区域管理
 * @author dwx
 * @Date 2018-07-09 18:27:43
 * @since 1.0
 */
@TableName("t_base_areainfo")
public class AreainfoEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** 自增id. */
	private Long id;
	
	/** 区域编码. */
	private String areaCode;
	
	/** 楼层id. */
	private Long floorId;
	
	/** 楼层区域编码 组合. */
	private String floorAreaCode;
	
	/** 备注. */
	private String remark;
	
	/** 创建时间. */
	private java.util.Date createdDate;
	
	/** 创建人id. */
	private Long createdPersonId;
	
	/** 创建人. */
	private String createdPerson;
	
	/** 更新时间. */
	private java.util.Date updatedDate;
	
	/** 更新人id. */
	private Long updatedPersonId;
	
	/** 修改人. */
	private String updatedPerson;

	private  String floorName;

	public String getFloorName() {
		return floorName;
	}

	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}

	private String floorCode;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public void setFloorCode(String floorCode) {
		this.floorCode = floorCode;
	}

	/** set 自增id. */
	public void setId(Long id) {
		this.id = id;
	}
	
	/** get 自增id. */
	public Long getId() {
		return this.id;
	}
	
	@JsonIgnore
	public Long getIdByLike() {
		return this.id;
	}
	

    /** set 区域编码. */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	
	/** get 区域编码. */
	public String getAreaCode() {
		return this.areaCode;
	}
	
	@JsonIgnore
	public String getAreaCodeByLike() {
		return "%"+this.areaCode+"%";
	}
	

    /** set 楼层id. */
	public void setFloorId(Long floorId) {
		this.floorId = floorId;
	}
	
	/** get 楼层id. */
	public Long getFloorId() {
		return this.floorId;
	}
	
	@JsonIgnore
	public Long getFloorIdByLike() {
		return this.floorId;
	}
	

    /** set 楼层区域编码 组合. */
	public void setFloorAreaCode(String floorAreaCode) {
		this.floorAreaCode = floorAreaCode;
	}
	
	/** get 楼层区域编码 组合. */
	public String getFloorAreaCode() {
		return this.floorAreaCode;
	}
	
	@JsonIgnore
	public String getFloorAreaCodeByLike() {
		return "%"+this.floorAreaCode+"%";
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
	public void setCreatedDate(java.util.Date createdDate) {
		this.createdDate = createdDate;
	}
	
	/** get 创建时间. */
	public java.util.Date getCreatedDate() {
		return this.createdDate;
	}
	
	@JsonIgnore
	public java.util.Date getCreatedDateByLike() {
		return this.createdDate;
	}
	

    /** set 创建人id. */
	public void setCreatedPersonId(Long createdPersonId) {
		this.createdPersonId = createdPersonId;
	}
	
	/** get 创建人id. */
	public Long getCreatedPersonId() {
		return this.createdPersonId;
	}
	
	@JsonIgnore
	public Long getCreatedPersonIdByLike() {
		return this.createdPersonId;
	}
	

    /** set 创建人. */
	public void setCreatedPerson(String createdPerson) {
		this.createdPerson = createdPerson;
	}
	
	/** get 创建人. */
	public String getCreatedPerson() {
		return this.createdPerson;
	}
	
	@JsonIgnore
	public String getCreatedPersonByLike() {
		return "%"+this.createdPerson+"%";
	}
	

    /** set 更新时间. */
	public void setUpdatedDate(java.util.Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	/** get 更新时间. */
	public java.util.Date getUpdatedDate() {
		return this.updatedDate;
	}
	
	@JsonIgnore
	public java.util.Date getUpdatedDateByLike() {
		return this.updatedDate;
	}
	

    /** set 更新人id. */
	public void setUpdatedPersonId(Long updatedPersonId) {
		this.updatedPersonId = updatedPersonId;
	}
	
	/** get 更新人id. */
	public Long getUpdatedPersonId() {
		return this.updatedPersonId;
	}
	
	@JsonIgnore
	public Long getUpdatedPersonIdByLike() {
		return this.updatedPersonId;
	}
	

    /** set 修改人. */
	public void setUpdatedPerson(String updatedPerson) {
		this.updatedPerson = updatedPerson;
	}
	
	/** get 修改人. */
	public String getUpdatedPerson() {
		return this.updatedPerson;
	}
	
	@JsonIgnore
	public String getUpdatedPersonByLike() {
		return "%"+this.updatedPerson+"%";
	}
	
    /** constructor */
	public AreainfoEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param areaCode			区域编码
	 * @param floorId			楼层id
	 * @param floorAreaCode			楼层区域编码 组合
	 * @param remark			备注
	 * @param createdDate			创建时间
	 * @param createdPersonId			创建人id
	 * @param createdPerson			创建人
	 * @param updatedDate			更新时间
	 * @param updatedPersonId			更新人id
	 * @param updatedPerson			修改人
	 */
	public AreainfoEntity(String areaCode,Long floorId,String floorAreaCode,String remark,java.util.Date createdDate,Long createdPersonId,String createdPerson,java.util.Date updatedDate,Long updatedPersonId,String updatedPerson){
		this();
		this.areaCode = areaCode;
		this.floorId = floorId;
		this.floorAreaCode = floorAreaCode;
		this.remark = remark;
		this.createdDate = createdDate;
		this.createdPersonId = createdPersonId;
		this.createdPerson = createdPerson;
		this.updatedDate = updatedDate;
		this.updatedPersonId = updatedPersonId;
		this.updatedPerson = updatedPerson;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("AreainfoEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("AreaCode=").append(getAreaCode()).append(", ")
			.append("FloorId=").append(getFloorId()).append(", ")
			.append("FloorAreaCode=").append(getFloorAreaCode()).append(", ")
			.append("Remark=").append(getRemark()).append(", ")
			.append("CreatedDate=").append(getCreatedDate()).append(", ")
			.append("CreatedPersonId=").append(getCreatedPersonId()).append(", ")
			.append("CreatedPerson=").append(getCreatedPerson()).append(", ")
			.append("UpdatedDate=").append(getUpdatedDate()).append(", ")
			.append("UpdatedPersonId=").append(getUpdatedPersonId()).append(", ")
			.append("UpdatedPerson=").append(getUpdatedPerson())
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
		if(obj instanceof AreainfoEntity == false)
			return false;
		if(this == obj)
			return true;
		AreainfoEntity other = (AreainfoEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
