
package com.ms.warehouse.manage.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 试验卷烟
 * @author Ms
 * @Date 2018-07-30 16:17:10
 * @since 1.0
 */
@TableName("t_base_testcigarette")
public class TestcigaretteEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
    
    private String verName;
    
    private String braName;
    
    private String cigName;
    
    private String paciName;
    
    private String pacName;
	
	/** 自增id. */
	private Long id;
	
	/** 卷烟ID. */
	private String dataId;
	
	/** 卷烟代码. */
	private String code;
	
	/** 卷烟名称. */
	private String name;
	
	/** 版本id. */
	private String versioncode;
	
	/** 品牌id. */
	private String cigbrand;
	
	/** 试验部门id. */
	private String testDarptment;
	
	/** 卷烟条条码. */
	private String barbarcode;
	
	/** 卷烟系列ID(固定值). */
	private String inventoreId;
	
	/** 卷烟类别码ID. */
	private String cigarettetype;
	
	/** 卷烟规格码. */
	private String standardscode;
	
	/** 配方识别码. */
	private String formulacode;
	
	/** 包装识别码ID. */
	private String packingcode;
	
	/** 卷烟价类ID. */
	private String pricetype;
	
	/** 烟嘴长度(mm). */
	private String filterlength;
	
	/** 烟支周长(mm). */
	private String ciggirth;
	
	/** 烟支长度(mm). */
	private String ciglength;
	
	/** 烟支总长度(mm). */
	private String cigtotallen;
	
	/** 包装形式. */
	private String packageform;
	
	/** 生产类型. */
	private String producttype;
	
	/** 卷烟类型. */
	private String cigtype;
	
	/** 关联半成品id. */
	private String linkTobaccoCut;
	
	/** 状态 2：发布 3：停用. */
	private String status;
	
	/** 创建时间. */
	private java.util.Date createdDate;
	
	/** 创建人. */
	private String createdPerson;
	
	/** 更新时间. */
	private java.util.Date updatedDate;
	
	/** 更新人. */
	private String updatedPerson;
private List<String> subVersionList = new ArrayList<String>();
	
	private Integer subId = null;
	/** 包装规格. */
	private String packagestandards;

    /** set 自增id. */
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getPackagestandards() {
		return packagestandards;
	}

	public void setPackagestandards(String packagestandards) {
		this.packagestandards = packagestandards;
	}

	/** get 自增id. */
	public Long getId() {
		return this.id;
	}
	
	@JsonIgnore
	public Long getIdByLike() {
		return this.id;
	}
	
    public List<String> getSubVersionList() {
		return subVersionList;
	}

	public void setSubVersionList(List<String> subVersionList) {
		this.subVersionList = subVersionList;
	}

	public Integer getSubId() {
		return subId;
	}

	public void setSubId(Integer subId) {
		this.subId = subId;
	}

	public String getPacName() {
		return pacName;
	}

	public void setPacName(String pacName) {
		this.pacName = pacName;
	}

	/** set 卷烟ID. */
	public void setDataId(String dataId) {
		this.dataId = dataId;
	}
	
	/** get 卷烟ID. */
	public String getDataId() {
		return this.dataId;
	}
	
	@JsonIgnore
	public String getDataIdByLike() {
		return "%"+this.dataId+"%";
	}
	

    /** set 卷烟代码. */
	public void setCode(String code) {
		this.code = code;
	}
	
	/** get 卷烟代码. */
	public String getCode() {
		return this.code;
	}
	
	@JsonIgnore
	public String getCodeByLike() {
		return "%"+this.code+"%";
	}
	

    /** set 卷烟名称. */
	public void setName(String name) {
		this.name = name;
	}
	
	/** get 卷烟名称. */
	public String getName() {
		return this.name;
	}
	
	@JsonIgnore
	public String getNameByLike() {
		return "%"+this.name+"%";
	}
	

    /** set 版本id. */
	public void setVersioncode(String versioncode) {
		this.versioncode = versioncode;
	}
	
	/** get 版本id. */
	public String getVersioncode() {
		return this.versioncode;
	}
	
	@JsonIgnore
	public String getVersioncodeByLike() {
		return "%"+this.versioncode+"%";
	}
	

    /** set 品牌id. */
	public void setCigbrand(String cigbrand) {
		this.cigbrand = cigbrand;
	}
	
	/** get 品牌id. */
	public String getCigbrand() {
		return this.cigbrand;
	}
	
	@JsonIgnore
	public String getCigbrandByLike() {
		return "%"+this.cigbrand+"%";
	}
	

    /** set 试验部门id. */
	public void setTestDarptment(String testDarptment) {
		this.testDarptment = testDarptment;
	}
	
	/** get 试验部门id. */
	public String getTestDarptment() {
		return this.testDarptment;
	}
	
	@JsonIgnore
	public String getTestDarptmentByLike() {
		return "%"+this.testDarptment+"%";
	}
	

    /** set 卷烟条条码. */
	public void setBarbarcode(String barbarcode) {
		this.barbarcode = barbarcode;
	}
	
	/** get 卷烟条条码. */
	public String getBarbarcode() {
		return this.barbarcode;
	}
	
	@JsonIgnore
	public String getBarbarcodeByLike() {
		return "%"+this.barbarcode+"%";
	}
	

    /** set 卷烟系列ID(固定值). */
	public void setInventoreId(String inventoreId) {
		this.inventoreId = inventoreId;
	}
	
	/** get 卷烟系列ID(固定值). */
	public String getInventoreId() {
		return this.inventoreId;
	}
	
	@JsonIgnore
	public String getInventoreIdByLike() {
		return "%"+this.inventoreId+"%";
	}
	

    /** set 卷烟类别码ID. */
	public void setCigarettetype(String cigarettetype) {
		this.cigarettetype = cigarettetype;
	}
	
	/** get 卷烟类别码ID. */
	public String getCigarettetype() {
		return this.cigarettetype;
	}
	
	@JsonIgnore
	public String getCigarettetypeByLike() {
		return "%"+this.cigarettetype+"%";
	}
	

    /** set 卷烟规格码. */
	public void setStandardscode(String standardscode) {
		this.standardscode = standardscode;
	}
	
	/** get 卷烟规格码. */
	public String getStandardscode() {
		return this.standardscode;
	}
	
	@JsonIgnore
	public String getStandardscodeByLike() {
		return "%"+this.standardscode+"%";
	}
	

    /** set 配方识别码. */
	public void setFormulacode(String formulacode) {
		this.formulacode = formulacode;
	}
	
	/** get 配方识别码. */
	public String getFormulacode() {
		return this.formulacode;
	}
	
	@JsonIgnore
	public String getFormulacodeByLike() {
		return "%"+this.formulacode+"%";
	}
	

    /** set 包装识别码ID. */
	public void setPackingcode(String packingcode) {
		this.packingcode = packingcode;
	}
	
	/** get 包装识别码ID. */
	public String getPackingcode() {
		return this.packingcode;
	}
	
	@JsonIgnore
	public String getPackingcodeByLike() {
		return "%"+this.packingcode+"%";
	}
	

    /** set 卷烟价类ID. */
	public void setPricetype(String pricetype) {
		this.pricetype = pricetype;
	}
	
	/** get 卷烟价类ID. */
	public String getPricetype() {
		return this.pricetype;
	}
	
	@JsonIgnore
	public String getPricetypeByLike() {
		return "%"+this.pricetype+"%";
	}
	

    /** set 烟嘴长度(mm). */
	public void setFilterlength(String filterlength) {
		this.filterlength = filterlength;
	}
	
	/** get 烟嘴长度(mm). */
	public String getFilterlength() {
		return this.filterlength;
	}
	
	@JsonIgnore
	public String getFilterlengthByLike() {
		return "%"+this.filterlength+"%";
	}
	

    /** set 烟支周长(mm). */
	public void setCiggirth(String ciggirth) {
		this.ciggirth = ciggirth;
	}
	
	/** get 烟支周长(mm). */
	public String getCiggirth() {
		return this.ciggirth;
	}
	
	@JsonIgnore
	public String getCiggirthByLike() {
		return "%"+this.ciggirth+"%";
	}
	

    /** set 烟支长度(mm). */
	public void setCiglength(String ciglength) {
		this.ciglength = ciglength;
	}
	
	/** get 烟支长度(mm). */
	public String getCiglength() {
		return this.ciglength;
	}
	
	@JsonIgnore
	public String getCiglengthByLike() {
		return "%"+this.ciglength+"%";
	}
	

    /** set 烟支总长度(mm). */
	public void setCigtotallen(String cigtotallen) {
		this.cigtotallen = cigtotallen;
	}
	
	/** get 烟支总长度(mm). */
	public String getCigtotallen() {
		return this.cigtotallen;
	}
	
	@JsonIgnore
	public String getCigtotallenByLike() {
		return "%"+this.cigtotallen+"%";
	}
	

    /** set 包装形式. */
	public void setPackageform(String packageform) {
		this.packageform = packageform;
	}
	
	/** get 包装形式. */
	public String getPackageform() {
		return this.packageform;
	}
	
	@JsonIgnore
	public String getPackageformByLike() {
		return "%"+this.packageform+"%";
	}
	

    /** set 生产类型. */
	public void setProducttype(String producttype) {
		this.producttype = producttype;
	}
	
	/** get 生产类型. */
	public String getProducttype() {
		return this.producttype;
	}
	
	@JsonIgnore
	public String getProducttypeByLike() {
		return "%"+this.producttype+"%";
	}
	

    /** set 卷烟类型. */
	public void setCigtype(String cigtype) {
		this.cigtype = cigtype;
	}
	
	/** get 卷烟类型. */
	public String getCigtype() {
		return this.cigtype;
	}
	
	@JsonIgnore
	public String getCigtypeByLike() {
		return "%"+this.cigtype+"%";
	}
	

    /** set 关联半成品id. */
	public void setLinkTobaccoCut(String linkTobaccoCut) {
		this.linkTobaccoCut = linkTobaccoCut;
	}
	
	/** get 关联半成品id. */
	public String getLinkTobaccoCut() {
		return this.linkTobaccoCut;
	}
	
	@JsonIgnore
	public String getLinkTobaccoCutByLike() {
		return "%"+this.linkTobaccoCut+"%";
	}
	

    /** set 状态 2：发布 3：停用. */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/** get 状态 2：发布 3：停用. */
	public String getStatus() {
		return this.status;
	}
	
	public String getCigName() {
		return cigName;
	}

	public void setCigName(String cigName) {
		this.cigName = cigName;
	}

	public String getPaciName() {
		return paciName;
	}

	public void setPaciName(String paciName) {
		this.paciName = paciName;
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
	
	public String getVerName() {
		return verName;
	}

	public void setVerName(String verName) {
		this.verName = verName;
	}

	public String getBraName() {
		return braName;
	}

	public void setBraName(String braName) {
		this.braName = braName;
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
	public TestcigaretteEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param dataId			卷烟ID
	 * @param code			卷烟代码
	 * @param name			卷烟名称
	 * @param versioncode			版本id
	 * @param cigbrand			品牌id
	 * @param testDarptment			试验部门id
	 * @param barbarcode			卷烟条条码
	 * @param inventoreId			卷烟系列ID(固定值)
	 * @param cigarettetype			卷烟类别码ID
	 * @param standardscode			卷烟规格码
	 * @param formulacode			配方识别码
	 * @param packingcode			包装识别码ID
	 * @param pricetype			卷烟价类ID
	 * @param filterlength			烟嘴长度(mm)
	 * @param ciggirth			烟支周长(mm)
	 * @param ciglength			烟支长度(mm)
	 * @param cigtotallen			烟支总长度(mm)
	 * @param packageform			包装形式
	 * @param producttype			生产类型
	 * @param cigtype			卷烟类型
	 * @param linkTobaccoCut			关联半成品id
	 * @param status			状态 2：发布 3：停用
	 * @param createdDate			创建时间
	 * @param createdPerson			创建人
	 * @param updatedDate			更新时间
	 * @param updatedPerson			更新人
	 */
	public TestcigaretteEntity(String dataId,String code,String name,String versioncode,String cigbrand,String testDarptment,String barbarcode,String inventoreId,String cigarettetype,String standardscode,String formulacode,String packingcode,String pricetype,String filterlength,String ciggirth,String ciglength,String cigtotallen,String packageform,String producttype,String cigtype,String linkTobaccoCut,String status,java.util.Date createdDate,String createdPerson,java.util.Date updatedDate,String updatedPerson){
		this();
		this.dataId = dataId;
		this.code = code;
		this.name = name;
		this.versioncode = versioncode;
		this.cigbrand = cigbrand;
		this.testDarptment = testDarptment;
		this.barbarcode = barbarcode;
		this.inventoreId = inventoreId;
		this.cigarettetype = cigarettetype;
		this.standardscode = standardscode;
		this.formulacode = formulacode;
		this.packingcode = packingcode;
		this.pricetype = pricetype;
		this.filterlength = filterlength;
		this.ciggirth = ciggirth;
		this.ciglength = ciglength;
		this.cigtotallen = cigtotallen;
		this.packageform = packageform;
		this.producttype = producttype;
		this.cigtype = cigtype;
		this.linkTobaccoCut = linkTobaccoCut;
		this.status = status;
		this.createdDate = createdDate;
		this.createdPerson = createdPerson;
		this.updatedDate = updatedDate;
		this.updatedPerson = updatedPerson;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("TestcigaretteEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("DataId=").append(getDataId()).append(", ")
			.append("Code=").append(getCode()).append(", ")
			.append("Name=").append(getName()).append(", ")
			.append("Versioncode=").append(getVersioncode()).append(", ")
			.append("Cigbrand=").append(getCigbrand()).append(", ")
			.append("TestDarptment=").append(getTestDarptment()).append(", ")
			.append("Barbarcode=").append(getBarbarcode()).append(", ")
			.append("InventoreId=").append(getInventoreId()).append(", ")
			.append("Cigarettetype=").append(getCigarettetype()).append(", ")
			.append("Standardscode=").append(getStandardscode()).append(", ")
			.append("Formulacode=").append(getFormulacode()).append(", ")
			.append("Packingcode=").append(getPackingcode()).append(", ")
			.append("Pricetype=").append(getPricetype()).append(", ")
			.append("Filterlength=").append(getFilterlength()).append(", ")
			.append("Ciggirth=").append(getCiggirth()).append(", ")
			.append("Ciglength=").append(getCiglength()).append(", ")
			.append("Cigtotallen=").append(getCigtotallen()).append(", ")
			.append("Packageform=").append(getPackageform()).append(", ")
			.append("Producttype=").append(getProducttype()).append(", ")
			.append("Cigtype=").append(getCigtype()).append(", ")
			.append("LinkTobaccoCut=").append(getLinkTobaccoCut()).append(", ")
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
		if(obj instanceof TestcigaretteEntity == false)
			return false;
		if(this == obj)
			return true;
		TestcigaretteEntity other = (TestcigaretteEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
