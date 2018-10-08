
package com.ms.warehouse.manage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 客商信息
 * @author dwf
 * @Date 2018-07-26 18:37:47
 * @since 1.0
 */
@TableName("t_base_merchant")
public class MerchantEntity extends BaseEntity {
	
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
	
	/** 行业内外标识 0:行业内
1:行业外
2:行业外特殊地区. */
	private String isIndustry;
	
	/** 纳税人登记号. */
	private String tegRegNum;
	
	/** 客商属性 1:客商
2:客户
3:供应商. */
	private String comProviderProp;
	
	/** 客商类型 0:外部单位
1:内部核算单位
2:内部法人单位
3:内部渠道单位. */
	private String comProviderType;
	
	/** 所属地区id. */
	private String regionId;
	
	/** 地址. */
	private String address;
	
	/** 邮编. */
	private String zipcode;
	
	/** 法人代表. */
	private String legalbody;
	
	/** 联系人. */
	private String linkman;
	
	/** 传真. */
	private String fax;
	
	/** 联系电话. */
	private String phone;
	
	/** 复烤企业特标码. */
	private String redriedBusinessCode;
	
	/** 银行名称. */
	private String bankName;
	
	/** 银行账号. */
	private String bankAccount;
	
	/** 使用公司. */
	private String useCompany;
	
	/** 银行类别id. */
	private String pkBanktype;
	
	/** 状态2：发布
3：停用. */
	private String status;
	
	/** 创建人. */
	private String creator;
	
	/** 创建时间. */
	private java.util.Date createtime;
	
	/** 修改者. */
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
	

    /** set 行业内外标识 0:行业内
1:行业外
2:行业外特殊地区. */
	public void setIsIndustry(String isIndustry) {
		this.isIndustry = isIndustry;
	}
	
	/** get 行业内外标识 0:行业内
1:行业外
2:行业外特殊地区. */
	public String getIsIndustry() {
		return this.isIndustry;
	}
	
	@JsonIgnore
	public String getIsIndustryByLike() {
		return "%"+this.isIndustry+"%";
	}
	

    /** set 纳税人登记号. */
	public void setTegRegNum(String tegRegNum) {
		this.tegRegNum = tegRegNum;
	}
	
	/** get 纳税人登记号. */
	public String getTegRegNum() {
		return this.tegRegNum;
	}
	
	@JsonIgnore
	public String getTegRegNumByLike() {
		return "%"+this.tegRegNum+"%";
	}
	

    /** set 客商属性 1:客商
2:客户
3:供应商. */
	public void setComProviderProp(String comProviderProp) {
		this.comProviderProp = comProviderProp;
	}
	
	/** get 客商属性 1:客商
2:客户
3:供应商. */
	public String getComProviderProp() {
		return this.comProviderProp;
	}
	
	@JsonIgnore
	public String getComProviderPropByLike() {
		return "%"+this.comProviderProp+"%";
	}
	

    /** set 客商类型 0:外部单位
1:内部核算单位
2:内部法人单位
3:内部渠道单位. */
	public void setComProviderType(String comProviderType) {
		this.comProviderType = comProviderType;
	}
	
	/** get 客商类型 0:外部单位
1:内部核算单位
2:内部法人单位
3:内部渠道单位. */
	public String getComProviderType() {
		return this.comProviderType;
	}
	
	@JsonIgnore
	public String getComProviderTypeByLike() {
		return "%"+this.comProviderType+"%";
	}
	

    /** set 所属地区id. */
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
	
	/** get 所属地区id. */
	public String getRegionId() {
		return this.regionId;
	}
	
	@JsonIgnore
	public String getRegionIdByLike() {
		return "%"+this.regionId+"%";
	}
	

    /** set 地址. */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/** get 地址. */
	public String getAddress() {
		return this.address;
	}
	
	@JsonIgnore
	public String getAddressByLike() {
		return "%"+this.address+"%";
	}
	

    /** set 邮编. */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	/** get 邮编. */
	public String getZipcode() {
		return this.zipcode;
	}
	
	@JsonIgnore
	public String getZipcodeByLike() {
		return "%"+this.zipcode+"%";
	}
	

    /** set 法人代表. */
	public void setLegalbody(String legalbody) {
		this.legalbody = legalbody;
	}
	
	/** get 法人代表. */
	public String getLegalbody() {
		return this.legalbody;
	}
	
	@JsonIgnore
	public String getLegalbodyByLike() {
		return "%"+this.legalbody+"%";
	}
	

    /** set 联系人. */
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	
	/** get 联系人. */
	public String getLinkman() {
		return this.linkman;
	}
	
	@JsonIgnore
	public String getLinkmanByLike() {
		return "%"+this.linkman+"%";
	}
	

    /** set 传真. */
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	/** get 传真. */
	public String getFax() {
		return this.fax;
	}
	
	@JsonIgnore
	public String getFaxByLike() {
		return "%"+this.fax+"%";
	}
	

    /** set 联系电话. */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/** get 联系电话. */
	public String getPhone() {
		return this.phone;
	}
	
	@JsonIgnore
	public String getPhoneByLike() {
		return "%"+this.phone+"%";
	}
	

    /** set 复烤企业特标码. */
	public void setRedriedBusinessCode(String redriedBusinessCode) {
		this.redriedBusinessCode = redriedBusinessCode;
	}
	
	/** get 复烤企业特标码. */
	public String getRedriedBusinessCode() {
		return this.redriedBusinessCode;
	}
	
	@JsonIgnore
	public String getRedriedBusinessCodeByLike() {
		return "%"+this.redriedBusinessCode+"%";
	}
	

    /** set 银行名称. */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	/** get 银行名称. */
	public String getBankName() {
		return this.bankName;
	}
	
	@JsonIgnore
	public String getBankNameByLike() {
		return "%"+this.bankName+"%";
	}
	

    /** set 银行账号. */
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	/** get 银行账号. */
	public String getBankAccount() {
		return this.bankAccount;
	}
	
	@JsonIgnore
	public String getBankAccountByLike() {
		return "%"+this.bankAccount+"%";
	}
	

    /** set 使用公司. */
	public void setUseCompany(String useCompany) {
		this.useCompany = useCompany;
	}
	
	/** get 使用公司. */
	public String getUseCompany() {
		return this.useCompany;
	}
	
	@JsonIgnore
	public String getUseCompanyByLike() {
		return "%"+this.useCompany+"%";
	}
	

    /** set 银行类别id. */
	public void setPkBanktype(String pkBanktype) {
		this.pkBanktype = pkBanktype;
	}
	
	/** get 银行类别id. */
	public String getPkBanktype() {
		return this.pkBanktype;
	}
	
	@JsonIgnore
	public String getPkBanktypeByLike() {
		return "%"+this.pkBanktype+"%";
	}
	

    /** set 状态2：发布
3：停用. */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/** get 状态2：发布
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
	

    /** set 修改者. */
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	
	/** get 修改者. */
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
	public MerchantEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param dataId			主数据id
	 * @param code			代码
	 * @param name			名称
	 * @param isIndustry			行业内外标识 0:行业内
1:行业外
2:行业外特殊地区
	 * @param tegRegNum			纳税人登记号
	 * @param comProviderProp			客商属性 1:客商
2:客户
3:供应商
	 * @param comProviderType			客商类型 0:外部单位
1:内部核算单位
2:内部法人单位
3:内部渠道单位
	 * @param regionId			所属地区id
	 * @param address			地址
	 * @param zipcode			邮编
	 * @param legalbody			法人代表
	 * @param linkman			联系人
	 * @param fax			传真
	 * @param phone			联系电话
	 * @param redriedBusinessCode			复烤企业特标码
	 * @param bankName			银行名称
	 * @param bankAccount			银行账号
	 * @param useCompany			使用公司
	 * @param pkBanktype			银行类别id
	 * @param status			状态2：发布
3：停用
	 * @param creator			创建人
	 * @param createtime			创建时间
	 * @param modifier			修改者
	 * @param modifytime			修改时间
	 */
	public MerchantEntity(String dataId,String code,String name,String isIndustry,String tegRegNum,String comProviderProp,String comProviderType,String regionId,String address,String zipcode,String legalbody,String linkman,String fax,String phone,String redriedBusinessCode,String bankName,String bankAccount,String useCompany,String pkBanktype,String status,String creator,java.util.Date createtime,String modifier,java.util.Date modifytime){
		this();
		this.dataId = dataId;
		this.code = code;
		this.name = name;
		this.isIndustry = isIndustry;
		this.tegRegNum = tegRegNum;
		this.comProviderProp = comProviderProp;
		this.comProviderType = comProviderType;
		this.regionId = regionId;
		this.address = address;
		this.zipcode = zipcode;
		this.legalbody = legalbody;
		this.linkman = linkman;
		this.fax = fax;
		this.phone = phone;
		this.redriedBusinessCode = redriedBusinessCode;
		this.bankName = bankName;
		this.bankAccount = bankAccount;
		this.useCompany = useCompany;
		this.pkBanktype = pkBanktype;
		this.status = status;
		this.creator = creator;
		this.createtime = createtime;
		this.modifier = modifier;
		this.modifytime = modifytime;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("MerchantEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("DataId=").append(getDataId()).append(", ")
			.append("Code=").append(getCode()).append(", ")
			.append("Name=").append(getName()).append(", ")
			.append("IsIndustry=").append(getIsIndustry()).append(", ")
			.append("TegRegNum=").append(getTegRegNum()).append(", ")
			.append("ComProviderProp=").append(getComProviderProp()).append(", ")
			.append("ComProviderType=").append(getComProviderType()).append(", ")
			.append("RegionId=").append(getRegionId()).append(", ")
			.append("Address=").append(getAddress()).append(", ")
			.append("Zipcode=").append(getZipcode()).append(", ")
			.append("Legalbody=").append(getLegalbody()).append(", ")
			.append("Linkman=").append(getLinkman()).append(", ")
			.append("Fax=").append(getFax()).append(", ")
			.append("Phone=").append(getPhone()).append(", ")
			.append("RedriedBusinessCode=").append(getRedriedBusinessCode()).append(", ")
			.append("BankName=").append(getBankName()).append(", ")
			.append("BankAccount=").append(getBankAccount()).append(", ")
			.append("UseCompany=").append(getUseCompany()).append(", ")
			.append("PkBanktype=").append(getPkBanktype()).append(", ")
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
		if(obj instanceof MerchantEntity == false)
			return false;
		if(this == obj)
			return true;
		MerchantEntity other = (MerchantEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
