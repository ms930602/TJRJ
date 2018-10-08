
package com.ms.warehouse.manage.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 仓库信息
 * @author dwx
 * @Date 2018-07-09 18:27:44
 * @since 1.0
 */
@TableName("t_base_warehouseinfo")
public class WarehouseinfoEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** 自增id. */
	private Long id;
	
	/** 主数据id. */
	private String dataId;
	
	/** 代码. */
	private String warCode;
	
	/** 名称. */
	@NotBlank(message="仓库名称不能为空")
	@Length(max=50,message="仓库名称最大长度为50个字符")
	private String warName;
	
	/** 仓库类别
01:成品仓库 02:原料仓库
03:辅料仓库
04:备件仓库
05:燃料仓库
06:周转材料仓库
09:车间半成品库
10:福祥促试
99:其它仓库. */
	private String warTypeId;
	
	/** 库存组织. */
	private String stockOrgId;
	
	/** 仓库属性 01:普通仓库  02:高架仓库. */
	private String warProp;
	
	/** 仓库地址. */
	@Length(max=200,message="仓库地址最大长度为200个字符")
	private String warAddress;
	
	/** 负责人. */
	@Length(max=50,message="负责人最大长度为50个字符")
	private String leaderNane;
	
	/** 电话. */
	@Length(max=20,message="点好最大长度为20个字符")
	private String phoneNum;
	
	/** 邮编. */
	@Length(max=10,message="邮编最大长度为10个字符")
	@Email(message="邮箱格式不正确")
	private String zipCode;
	
	/** 公司. */
	@Length(max=8,message="公司最大长度为8个字符")
	private String companyId;
	
	/** 是否供应商寄存 N否 Y 是. */
	private String isSupStore;
	
	/** 生产点. */
	@Length(max=8,message="生产点最大长度为8个字符")
	private String productPoint;
	
	/** 状态 2：发布 3：停用. */
	@NotBlank(message="状态不能为空")
	private String status;
	
	/** 创建时间. */
	private java.util.Date createdDate;
	
	/** 创建人. */
	private String createdPerson;
	
	/** 更新时间. */
	private java.util.Date updatedDate;
	
	/** 更新人. */
	private String updatedPerson;
	
	

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
	public void setWarCode(String warCode) {
		this.warCode = warCode;
	}
	
	/** get 代码. */
	public String getWarCode() {
		return this.warCode;
	}
	
	@JsonIgnore
	public String getWarCodeByLike() {
		return "%"+this.warCode+"%";
	}
	

    /** set 名称. */
	public void setWarName(String warName) {
		this.warName = warName;
	}
	
	/** get 名称. */
	public String getWarName() {
		return this.warName;
	}
	
	@JsonIgnore
	public String getWarNameByLike() {
		return "%"+this.warName+"%";
	}
	

    /** set 仓库类别
01:成品仓库 02:原料仓库
03:辅料仓库
04:备件仓库
05:燃料仓库
06:周转材料仓库
09:车间半成品库
10:福祥促试
99:其它仓库. */
	public void setWarTypeId(String warTypeId) {
		this.warTypeId = warTypeId;
	}
	
	/** get 仓库类别
01:成品仓库 02:原料仓库
03:辅料仓库
04:备件仓库
05:燃料仓库
06:周转材料仓库
09:车间半成品库
10:福祥促试
99:其它仓库. */
	public String getWarTypeId() {
		return this.warTypeId;
	}
	
	@JsonIgnore
	public String getWarTypeIdByLike() {
		return "%"+this.warTypeId+"%";
	}
	

    /** set 库存组织. */
	public void setStockOrgId(String stockOrgId) {
		this.stockOrgId = stockOrgId;
	}
	
	/** get 库存组织. */
	public String getStockOrgId() {
		return this.stockOrgId;
	}
	
	@JsonIgnore
	public String getStockOrgIdByLike() {
		return "%"+this.stockOrgId+"%";
	}
	

    /** set 仓库属性 01:普通仓库  02:高架仓库. */
	public void setWarProp(String warProp) {
		this.warProp = warProp;
	}
	
	/** get 仓库属性 01:普通仓库  02:高架仓库. */
	public String getWarProp() {
		return this.warProp;
	}
	
	@JsonIgnore
	public String getWarPropByLike() {
		return "%"+this.warProp+"%";
	}
	

    /** set 仓库地址. */
	public void setWarAddress(String warAddress) {
		this.warAddress = warAddress;
	}
	
	/** get 仓库地址. */
	public String getWarAddress() {
		return this.warAddress;
	}
	
	@JsonIgnore
	public String getWarAddressByLike() {
		return "%"+this.warAddress+"%";
	}
	

    /** set 负责人. */
	public void setLeaderNane(String leaderNane) {
		this.leaderNane = leaderNane;
	}
	
	/** get 负责人. */
	public String getLeaderNane() {
		return this.leaderNane;
	}
	
	@JsonIgnore
	public String getLeaderNaneByLike() {
		return "%"+this.leaderNane+"%";
	}
	

    /** set 电话. */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	/** get 电话. */
	public String getPhoneNum() {
		return this.phoneNum;
	}
	
	@JsonIgnore
	public String getPhoneNumByLike() {
		return "%"+this.phoneNum+"%";
	}
	

    /** set 邮编. */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	/** get 邮编. */
	public String getZipCode() {
		return this.zipCode;
	}
	
	@JsonIgnore
	public String getZipCodeByLike() {
		return "%"+this.zipCode+"%";
	}
	

    /** set 公司. */
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	
	/** get 公司. */
	public String getCompanyId() {
		return this.companyId;
	}
	
	@JsonIgnore
	public String getCompanyIdByLike() {
		return "%"+this.companyId+"%";
	}
	

    /** set 是否供应商寄存 N否 Y 是. */
	public void setIsSupStore(String isSupStore) {
		this.isSupStore = isSupStore;
	}
	
	/** get 是否供应商寄存 N否 Y 是. */
	public String getIsSupStore() {
		return this.isSupStore;
	}
	
	@JsonIgnore
	public String getIsSupStoreByLike() {
		return "%"+this.isSupStore+"%";
	}
	

    /** set 生产点. */
	public void setProductPoint(String productPoint) {
		this.productPoint = productPoint;
	}
	
	/** get 生产点. */
	public String getProductPoint() {
		return this.productPoint;
	}
	
	@JsonIgnore
	public String getProductPointByLike() {
		return "%"+this.productPoint+"%";
	}
	

    /** set 状态 2：发布 3：停用. */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/** get 状态 2：发布 3：停用. */
	public String getStatus() {
		return this.status;
	}
	
	@JsonIgnore
	public String getStatusByLike() {
		return "%"+this.status+"%";
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
	

    /** set 更新人. */
	public void setUpdatedPerson(String updatedPerson) {
		this.updatedPerson = updatedPerson;
	}
	
	/** get 更新人. */
	public String getUpdatedPerson() {
		return this.updatedPerson;
	}
	
	@JsonIgnore
	public String getUpdatedPersonByLike() {
		return "%"+this.updatedPerson+"%";
	}
	
    /** constructor */
	public WarehouseinfoEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param dataId			主数据id
	 * @param warCode			代码
	 * @param warName			名称
	 * @param warTypeId			仓库类别
01:成品仓库 02:原料仓库
03:辅料仓库
04:备件仓库
05:燃料仓库
06:周转材料仓库
09:车间半成品库
10:福祥促试
99:其它仓库
	 * @param stockOrgId			库存组织
	 * @param warProp			仓库属性 01:普通仓库  02:高架仓库
	 * @param warAddress			仓库地址
	 * @param leaderNane			负责人
	 * @param phoneNum			电话
	 * @param zipCode			邮编
	 * @param companyId			公司
	 * @param isSupStore			是否供应商寄存 N否 Y 是
	 * @param productPoint			生产点
	 * @param status			状态 2：发布 3：停用
	 * @param createdDate			创建时间
	 * @param createdPerson			创建人
	 * @param updatedDate			更新时间
	 * @param updatedPerson			更新人
	 */
	public WarehouseinfoEntity(String dataId,String warCode,String warName,String warTypeId,String stockOrgId,String warProp,String warAddress,String leaderNane,String phoneNum,String zipCode,String companyId,String isSupStore,String productPoint,String status,java.util.Date createdDate,String createdPerson,java.util.Date updatedDate,String updatedPerson){
		this();
		this.dataId = dataId;
		this.warCode = warCode;
		this.warName = warName;
		this.warTypeId = warTypeId;
		this.stockOrgId = stockOrgId;
		this.warProp = warProp;
		this.warAddress = warAddress;
		this.leaderNane = leaderNane;
		this.phoneNum = phoneNum;
		this.zipCode = zipCode;
		this.companyId = companyId;
		this.isSupStore = isSupStore;
		this.productPoint = productPoint;
		this.status = status;
		this.createdDate = createdDate;
		this.createdPerson = createdPerson;
		this.updatedDate = updatedDate;
		this.updatedPerson = updatedPerson;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("WarehouseinfoEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("DataId=").append(getDataId()).append(", ")
			.append("WarCode=").append(getWarCode()).append(", ")
			.append("WarName=").append(getWarName()).append(", ")
			.append("WarTypeId=").append(getWarTypeId()).append(", ")
			.append("StockOrgId=").append(getStockOrgId()).append(", ")
			.append("WarProp=").append(getWarProp()).append(", ")
			.append("WarAddress=").append(getWarAddress()).append(", ")
			.append("LeaderNane=").append(getLeaderNane()).append(", ")
			.append("PhoneNum=").append(getPhoneNum()).append(", ")
			.append("ZipCode=").append(getZipCode()).append(", ")
			.append("CompanyId=").append(getCompanyId()).append(", ")
			.append("IsSupStore=").append(getIsSupStore()).append(", ")
			.append("ProductPoint=").append(getProductPoint()).append(", ")
			.append("Status=").append(getStatus()).append(", ")
			.append("CreatedDate=").append(getCreatedDate()).append(", ")
			.append("CreatedPerson=").append(getCreatedPerson()).append(", ")
			.append("UpdatedDate=").append(getUpdatedDate()).append(", ")
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
		if(obj instanceof WarehouseinfoEntity == false)
			return false;
		if(this == obj)
			return true;
		WarehouseinfoEntity other = (WarehouseinfoEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
