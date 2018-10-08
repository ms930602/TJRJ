
package com.ms.warehouse.manage.entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 物料存放规则
 * @author dwx
 * @Date 2018-07-09 18:27:43
 * @since 1.0
 */
@TableName("t_base_materstorerules")
public class MaterstorerulesEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** 自增id. */
	private Long id;
	
	/** 物料id. */
	@Min(value=0,message="物料id不能小于0")
	@NotNull(message="物料id不能为空")
	private Long materId;
	
	/** 物料编码. */
	@NotBlank(message="物料编码不能为空")
	@Length(max=17,message="物料编码最大长度为17个字符")
	private String materCode;
	
	/** 物料名称. */
	@NotBlank(message="物料名称不能为空")
	@Length(max=50,message="物料名称最大长度为50个字符")
	private String materName;
	
	/** 存储期限. */
	@Min(value=0,message="存储期限不能小于0")
	@NotNull(message="存储期限不能为空")
	private Long deadline;
	
	/** 最低库存. */
	@Min(value=0,message="最低库存件数不能小于0")
	@NotNull(message="最低库存不能为空")
	private java.math.BigDecimal minStock;
	
	/** 最高库存. */
	@NotNull(message="最高库存件数不能为空")
	private java.math.BigDecimal maxStock;
	
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
	
	/** 是否默认：0否 1是. */
	private Integer isDefault;

	
    public Integer getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
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
	

    /** set 物料id. */
	public void setMaterId(Long materId) {
		this.materId = materId;
	}
	
	/** get 物料id. */
	public Long getMaterId() {
		return this.materId;
	}
	
	@JsonIgnore
	public Long getMaterIdByLike() {
		return this.materId;
	}
	

    /** set 物料编码. */
	public void setMaterCode(String materCode) {
		this.materCode = materCode;
	}
	
	/** get 物料编码. */
	public String getMaterCode() {
		return this.materCode;
	}
	
	@JsonIgnore
	public String getMaterCodeByLike() {
		return "%"+this.materCode+"%";
	}
	

    /** set 物料名称. */
	public void setMaterName(String materName) {
		this.materName = materName;
	}
	
	/** get 物料名称. */
	public String getMaterName() {
		return this.materName;
	}
	
	@JsonIgnore
	public String getMaterNameByLike() {
		return "%"+this.materName+"%";
	}
	

    /** set 存储期限. */
	public void setDeadline(Long deadline) {
		this.deadline = deadline;
	}
	
	/** get 存储期限. */
	public Long getDeadline() {
		return this.deadline;
	}
	
	@JsonIgnore
	public Long getDeadlineByLike() {
		return this.deadline;
	}
	

    /** set 最低库存. */
	public void setMinStock(java.math.BigDecimal minStock) {
		this.minStock = minStock;
	}
	
	/** get 最低库存. */
	public java.math.BigDecimal getMinStock() {
		return this.minStock;
	}
	
	@JsonIgnore
	public java.math.BigDecimal getMinStockByLike() {
		return this.minStock;
	}
	

    /** set 最高库存. */
	public void setMaxStock(java.math.BigDecimal maxStock) {
		this.maxStock = maxStock;
	}
	
	/** get 最高库存. */
	public java.math.BigDecimal getMaxStock() {
		return this.maxStock;
	}
	
	@JsonIgnore
	public java.math.BigDecimal getMaxStockByLike() {
		return this.maxStock;
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
	public MaterstorerulesEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param materId			物料id
	 * @param materCode			物料编码
	 * @param materName			物料名称
	 * @param deadline			存储期限
	 * @param minStock			最低库存
	 * @param maxStock			最高库存
	 * @param remark			备注
	 * @param createdDate			创建时间
	 * @param createdPersonId			创建人id
	 * @param createdPerson			创建人
	 * @param updatedDate			更新时间
	 * @param updatedPersonId			更新人id
	 * @param updatedPerson			修改人
	 */
	public MaterstorerulesEntity(Long materId,String materCode,String materName,Long deadline,java.math.BigDecimal minStock,java.math.BigDecimal maxStock,String remark,java.util.Date createdDate,Long createdPersonId,String createdPerson,java.util.Date updatedDate,Long updatedPersonId,String updatedPerson){
		this();
		this.materId = materId;
		this.materCode = materCode;
		this.materName = materName;
		this.deadline = deadline;
		this.minStock = minStock;
		this.maxStock = maxStock;
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
		return "MaterstorerulesEntity [id=" + id + ", materId=" + materId + ", materCode=" + materCode + ", materName="
				+ materName + ", deadline=" + deadline + ", minStock=" + minStock + ", maxStock=" + maxStock
				+ ", remark=" + remark + ", createdDate=" + createdDate + ", createdPersonId=" + createdPersonId
				+ ", createdPerson=" + createdPerson + ", updatedDate=" + updatedDate + ", updatedPersonId="
				+ updatedPersonId + ", updatedPerson=" + updatedPerson + ", isDefault=" + isDefault + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((createdPerson == null) ? 0 : createdPerson.hashCode());
		result = prime * result + ((createdPersonId == null) ? 0 : createdPersonId.hashCode());
		result = prime * result + ((deadline == null) ? 0 : deadline.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isDefault == null) ? 0 : isDefault.hashCode());
		result = prime * result + ((materCode == null) ? 0 : materCode.hashCode());
		result = prime * result + ((materId == null) ? 0 : materId.hashCode());
		result = prime * result + ((materName == null) ? 0 : materName.hashCode());
		result = prime * result + ((maxStock == null) ? 0 : maxStock.hashCode());
		result = prime * result + ((minStock == null) ? 0 : minStock.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((updatedDate == null) ? 0 : updatedDate.hashCode());
		result = prime * result + ((updatedPerson == null) ? 0 : updatedPerson.hashCode());
		result = prime * result + ((updatedPersonId == null) ? 0 : updatedPersonId.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MaterstorerulesEntity other = (MaterstorerulesEntity) obj;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (createdPerson == null) {
			if (other.createdPerson != null)
				return false;
		} else if (!createdPerson.equals(other.createdPerson))
			return false;
		if (createdPersonId == null) {
			if (other.createdPersonId != null)
				return false;
		} else if (!createdPersonId.equals(other.createdPersonId))
			return false;
		if (deadline == null) {
			if (other.deadline != null)
				return false;
		} else if (!deadline.equals(other.deadline))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isDefault == null) {
			if (other.isDefault != null)
				return false;
		} else if (!isDefault.equals(other.isDefault))
			return false;
		if (materCode == null) {
			if (other.materCode != null)
				return false;
		} else if (!materCode.equals(other.materCode))
			return false;
		if (materId == null) {
			if (other.materId != null)
				return false;
		} else if (!materId.equals(other.materId))
			return false;
		if (materName == null) {
			if (other.materName != null)
				return false;
		} else if (!materName.equals(other.materName))
			return false;
		if (maxStock == null) {
			if (other.maxStock != null)
				return false;
		} else if (!maxStock.equals(other.maxStock))
			return false;
		if (minStock == null) {
			if (other.minStock != null)
				return false;
		} else if (!minStock.equals(other.minStock))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (updatedDate == null) {
			if (other.updatedDate != null)
				return false;
		} else if (!updatedDate.equals(other.updatedDate))
			return false;
		if (updatedPerson == null) {
			if (other.updatedPerson != null)
				return false;
		} else if (!updatedPerson.equals(other.updatedPerson))
			return false;
		if (updatedPersonId == null) {
			if (other.updatedPersonId != null)
				return false;
		} else if (!updatedPersonId.equals(other.updatedPersonId))
			return false;
		return true;
	}
}
