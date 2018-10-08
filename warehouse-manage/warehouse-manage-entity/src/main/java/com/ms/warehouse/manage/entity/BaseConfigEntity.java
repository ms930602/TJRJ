
package com.ms.warehouse.manage.entity;

import javax.validation.constraints.Max;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 配置
 * @author wangwei
 * @Date 2018-07-31 09:58:46
 * @since 1.0
 */
@TableName("t_base_config")
public class BaseConfigEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** 自增id. */
	private Long id;
	
	/** 终端类型：1收货终端2叉车转运显示终端3提升机控制终端4或提现时终端5车牌识别终端. */
	private Long terminalType;
	
	/** 属性名. */
	@Length(max=45,message="属性名最大长度11个字符")
	private String key;
	
	/** 属性值. */
	@Length(max=100,message="属性值最大长度100个字符")
	private String value;
	
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
	
	/** 是否已发布0否1是. */
	@Max(value=127,message="是否已发布最大值为127")
	private Integer isRelease;
	
	

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
	

    /** set 终端类型：1收货终端2叉车转运显示终端3提升机控制终端4或提现时终端5车牌识别终端. */
	public void setTerminalType(Long terminalType) {
		this.terminalType = terminalType;
	}
	
	/** get 终端类型：1收货终端2叉车转运显示终端3提升机控制终端4或提现时终端5车牌识别终端. */
	public Long getTerminalType() {
		return this.terminalType;
	}
	
	@JsonIgnore
	public Long getTerminalTypeByLike() {
		return this.terminalType;
	}
	

    /** set 属性名. */
	public void setKey(String key) {
		this.key = key;
	}
	
	/** get 属性名. */
	public String getKey() {
		return this.key;
	}
	
	@JsonIgnore
	public String getKeyByLike() {
		return "%"+this.key+"%";
	}
	

    /** set 属性值. */
	public void setValue(String value) {
		this.value = value;
	}
	
	/** get 属性值. */
	public String getValue() {
		return this.value;
	}
	
	@JsonIgnore
	public String getValueByLike() {
		return "%"+this.value+"%";
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
	

    /** set 是否已发布0否1是. */
	public void setIsRelease(Integer isRelease) {
		this.isRelease = isRelease;
	}
	
	/** get 是否已发布0否1是. */
	public Integer getIsRelease() {
		return this.isRelease;
	}
	
	@JsonIgnore
	public Integer getIsReleaseByLike() {
		return this.isRelease;
	}
	
    /** constructor */
	public BaseConfigEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param terminalType			终端类型：1收货终端2叉车转运显示终端3提升机控制终端4或提现时终端5车牌识别终端
	 * @param key			属性名
	 * @param value			属性值
	 * @param createdDate			创建时间
	 * @param createdPersonId			创建人id
	 * @param createdPerson			创建人
	 * @param updatedDate			更新时间
	 * @param updatedPersonId			更新人id
	 * @param updatedPerson			修改人
	 * @param isRelease			是否已发布0否1是
	 */
	public BaseConfigEntity(Long terminalType,String key,String value,java.util.Date createdDate,Long createdPersonId,String createdPerson,java.util.Date updatedDate,Long updatedPersonId,String updatedPerson,Integer isRelease){
		this();
		this.terminalType = terminalType;
		this.key = key;
		this.value = value;
		this.createdDate = createdDate;
		this.createdPersonId = createdPersonId;
		this.createdPerson = createdPerson;
		this.updatedDate = updatedDate;
		this.updatedPersonId = updatedPersonId;
		this.updatedPerson = updatedPerson;
		this.isRelease = isRelease;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("BaseConfigEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("TerminalType=").append(getTerminalType()).append(", ")
			.append("Key=").append(getKey()).append(", ")
			.append("Value=").append(getValue()).append(", ")
			.append("CreatedDate=").append(getCreatedDate()).append(", ")
			.append("CreatedPersonId=").append(getCreatedPersonId()).append(", ")
			.append("CreatedPerson=").append(getCreatedPerson()).append(", ")
			.append("UpdatedDate=").append(getUpdatedDate()).append(", ")
			.append("UpdatedPersonId=").append(getUpdatedPersonId()).append(", ")
			.append("UpdatedPerson=").append(getUpdatedPerson()).append(", ")
			.append("IsRelease=").append(getIsRelease())
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
		if(obj instanceof BaseConfigEntity == false)
			return false;
		if(this == obj)
			return true;
		BaseConfigEntity other = (BaseConfigEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
