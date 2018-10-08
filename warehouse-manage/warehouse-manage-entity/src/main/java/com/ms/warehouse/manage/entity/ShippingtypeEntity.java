
package com.ms.warehouse.manage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 运输方式
 * @author dwf
 * @Date 2018-07-26 18:37:48
 * @since 1.0
 */
@TableName("t_base_shippingtype")
public class ShippingtypeEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** 自增id. */
	private Long id;
	
	/** 主数据id. */
	private String dataId;
	
	/** 代码. */
	private String code;
	
	/** 名称. */
	private String name;
	
	/** 运输方式英文名称. */
	private String transportModeEnname;
	
	/** 状态 2：发布
3：停用. */
	private String status;
	
	/** 创建人. */
	private String creator;
	
	/** 创建时间. */
	private java.util.Date createtime;
	
	/** 修改人. */
	private String modifier;
	
	/** 修改时间. */
	private java.util.Date modifytime;
	
	

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
	

    /** set 主数据id. */
	public void setDataId(String dataId) {
		this.dataId = dataId;
	}
	
	/** get 主数据id. */
	public String getDataId() {
		return this.dataId;
	}
	
	@JsonIgnore
	public String getDataIdByLike() {
		return "%"+this.dataId+"%";
	}
	

    /** set 代码. */
	public void setCode(String code) {
		this.code = code;
	}
	
	/** get 代码. */
	public String getCode() {
		return this.code;
	}
	
	@JsonIgnore
	public String getCodeByLike() {
		return "%"+this.code+"%";
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
	

    /** set 运输方式英文名称. */
	public void setTransportModeEnname(String transportModeEnname) {
		this.transportModeEnname = transportModeEnname;
	}
	
	/** get 运输方式英文名称. */
	public String getTransportModeEnname() {
		return this.transportModeEnname;
	}
	
	@JsonIgnore
	public String getTransportModeEnnameByLike() {
		return "%"+this.transportModeEnname+"%";
	}
	

    /** set 状态 2：发布
3：停用. */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/** get 状态 2：发布
3：停用. */
	public String getStatus() {
		return this.status;
	}
	
	@JsonIgnore
	public String getStatusByLike() {
		return "%"+this.status+"%";
	}
	

    /** set 创建人. */
	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	/** get 创建人. */
	public String getCreator() {
		return this.creator;
	}
	
	@JsonIgnore
	public String getCreatorByLike() {
		return "%"+this.creator+"%";
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
	

    /** set 修改人. */
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	
	/** get 修改人. */
	public String getModifier() {
		return this.modifier;
	}
	
	@JsonIgnore
	public String getModifierByLike() {
		return "%"+this.modifier+"%";
	}
	

    /** set 修改时间. */
	public void setModifytime(java.util.Date modifytime) {
		this.modifytime = modifytime;
	}
	
	/** get 修改时间. */
	public java.util.Date getModifytime() {
		return this.modifytime;
	}
	
	@JsonIgnore
	public java.util.Date getModifytimeByLike() {
		return this.modifytime;
	}
	
    /** constructor */
	public ShippingtypeEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param dataId			主数据id
	 * @param code			代码
	 * @param name			名称
	 * @param transportModeEnname			运输方式英文名称
	 * @param status			状态 2：发布
3：停用
	 * @param creator			创建人
	 * @param createtime			创建时间
	 * @param modifier			修改人
	 * @param modifytime			修改时间
	 */
	public ShippingtypeEntity(String dataId,String code,String name,String transportModeEnname,String status,String creator,java.util.Date createtime,String modifier,java.util.Date modifytime){
		this();
		this.dataId = dataId;
		this.code = code;
		this.name = name;
		this.transportModeEnname = transportModeEnname;
		this.status = status;
		this.creator = creator;
		this.createtime = createtime;
		this.modifier = modifier;
		this.modifytime = modifytime;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("ShippingtypeEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("DataId=").append(getDataId()).append(", ")
			.append("Code=").append(getCode()).append(", ")
			.append("Name=").append(getName()).append(", ")
			.append("TransportModeEnname=").append(getTransportModeEnname()).append(", ")
			.append("Status=").append(getStatus()).append(", ")
			.append("Creator=").append(getCreator()).append(", ")
			.append("Createtime=").append(getCreatetime()).append(", ")
			.append("Modifier=").append(getModifier()).append(", ")
			.append("Modifytime=").append(getModifytime())
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
		if(obj instanceof ShippingtypeEntity == false)
			return false;
		if(this == obj)
			return true;
		ShippingtypeEntity other = (ShippingtypeEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
