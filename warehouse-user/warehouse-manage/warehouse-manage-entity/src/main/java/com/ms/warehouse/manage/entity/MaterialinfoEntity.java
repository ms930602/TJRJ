
package com.ms.warehouse.manage.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 物料信息
 * @author dwx
 * @Date 2018-07-09 18:27:43
 * @since 1.0
 */
@TableName("t_base_materialinfo")
public class MaterialinfoEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;

	/**	条码状态 */
    private String barName;
	/**	卷烟品牌ID */
	private String braName;
	/**	卷烟长度 */
	private String lenName;
	/**	生产类型 */
	private String prodName;
	/**	卷烟类型 */
	private String cigName;
	/**	版本 */
	private String verName;
	/**	滤嘴类型 */
	private String filterName;
	/**	包装形式 */
	private String pacName;
	/**	包装识别码 */
	private String paciName;
	/**	包装规格 */
	private String pacsName;
	/**	卷烟价类 */
	private String priName;
	/**	生产点 */
	private String proName;
	/**	焦油量 */
	private String tarName;
	/**	国内国外销售 */
	private String tranName;
	
	private List<String> subVersionList = new ArrayList<String>();
	
	private Integer subId = null;
    /** 自增id. */
	private Long id;
	
	/** 主数据id. */
	private String dataId;
	
	/** 编码. */
	private String materCode;
	
	/** 名称. */
	private String materName;
	
	/** 版本ID. */
	private String versioncode;
	
	/** 卷烟品牌ID. */
	private String cigbrand;
	
	/** 进口国产标识 0:国产 1:进口. */
	private String abroadflag;
	
	/** 卷烟盒条码. */
	private String casebarcode;
	
	/** 卷烟条条码. */
	private String barbarcode;
	
	/** 卷烟箱条码. */
	private String boxbarcode;
	
	/** 条码状态. */
	private String barstatus;
	
	/** 是否主条码卷烟 0:否 1:是. */
	private String ismajorbar;
	
	/** 生产企业. */
	private String productent;
	
	/** 生产点. */
	private String productpoint;
	
	/** 商标所有者. */
	private String trademarkowner;
	
	/** 子公司标志 0:四川 1:重庆. */
	private String subcomp;
	
	/** 调拨价(不含税). */
	private String allotprice0;
	
	/** 调拨价(含税). */
	private String allotprice1;
	
	/** 批发价. */
	private String bulkprice;
	
	/** 市场零售价. */
	private String saleprice;
	
	/** 卷烟价类. */
	private String pricetype;
	
	/** 卷烟类型. */
	private String cigtype;
	
	/** 滤嘴类型. */
	private String filtertype;
	
	/** 生产类型. */
	private String producttype;
	
	/** 包装主颜色. */
	private String cigmaincolor;
	
	/** 包装辅颜色. */
	private String cigasscolor;
	
	/** 卷烟名称(外文). */
	private String cigenname;
	
	/** 卷烟牌号名称(外文). */
	private String cigbrandenname;
	
	/** 包装形式. */
	private String packageform;
	
	/** 包装规格. */
	private String packagestandards;
	
	/** 烟支总长度(mm). */
	private String cigtotallen;
	
	/** 烟支长度(mm). */
	private String ciglength;
	
	/** 烟嘴长度(mm). */
	private String filterlength;
	
	/** 烟支周长(mm). */
	private String ciggirth;
	
	/** 焦油量(mg). */
	private String cigtarcontent;
	
	/** 烟气烟碱量(mg). */
	private String cignicotinic;
	
	/** 烟气一氧化碳(mg). */
	private String cigco;
	
	/** 是否非卖品 0:可卖1：非卖. */
	private String notsaleflag;
	
	/** 是否低档烟 0:非低档 1:是低档. */
	private String cigislow;
	
	/** 是否名优烟0:非名优烟 1:是名优烟. */
	private String cigisgreat;
	
	/** 是否福祥促试烟0:非福祥促试1:是福祥促试. */
	private String cigistrial;
	
	/** 联营烟单位. */
	private String jointunit;
	
	/** 内部结算价. */
	private String innerbalance;
	
	/** 销售范围. */
	private String salescope;
	
	/** 是否在用  0:停用 1:在用. */
	private String isusing;
	
	/** 准生成日期. */
	private String cigapprvdate;
	
	/** 产品停产日期. */
	private String cigltstupdate;
	
	/** 税则号. */
	private String cigtax;
	
	/** 助记符. */
	private String remcode;
	
	/** 备注. */
	private String cigmemo;
	
	/** 卷烟系列 共取6位编码前两位为01的存货分类ID. */
	private String inventoreId;
	
	/** 卷烟类别符. */
	private String cigarettetype;
	
	/** 卷烟规格码. */
	private String standardscode;
	
	/** 配方识别码. */
	private String formulacode;
	
	/** 包装识别码. */
	private String packingcode;
	
	/** 调拨价(不含税)[元/支]. */
	private String allotprice2;
	
	/** 调拨价(不含税)[元/万支]. */
	private String allotprice3;
	
	/** 调拨价(含税)[元/支]. */
	private String allotprice4;
	
	/** 调拨价(含税)[元/万支]. */
	private String allotprice5;
	
	/** 关联半成品. */
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


	public String getBarName() {
		return barName;
	}

	public void setBarName(String barName) {
		this.barName = barName;
	}

	public String getBraName() {
		return braName;
	}

	public void setBraName(String braName) {
		this.braName = braName;
	}

	public String getLenName() {
		return lenName;
	}

	public void setLenName(String lenName) {
		this.lenName = lenName;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getCigName() {
		return cigName;
	}

	public void setCigName(String cigName) {
		this.cigName = cigName;
	}

	public String getVerName() {
		return verName;
	}

	public void setVerName(String verName) {
		this.verName = verName;
	}

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

	public String getPacName() {
		return pacName;
	}

	public void setPacName(String pacName) {
		this.pacName = pacName;
	}

	public String getPaciName() {
		return paciName;
	}

	public void setPaciName(String paciName) {
		this.paciName = paciName;
	}

	public String getPacsName() {
		return pacsName;
	}

	public void setPacsName(String pacsName) {
		this.pacsName = pacsName;
	}

	public String getPriName() {
		return priName;
	}

	public void setPriName(String priName) {
		this.priName = priName;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getTarName() {
		return tarName;
	}

	public void setTarName(String tarName) {
		this.tarName = tarName;
	}

	public String getTranName() {
		return tranName;
	}

	public void setTranName(String tranName) {
		this.tranName = tranName;
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
	

    /** set 编码. */
	public void setMaterCode(String materCode) {
		this.materCode = materCode;
	}
	
	/** get 编码. */
	public String getMaterCode() {
		return this.materCode;
	}
	
	@JsonIgnore
	public String getMaterCodeByLike() {
		return "%"+this.materCode+"%";
	}
	

    /** set 名称. */
	public void setMaterName(String materName) {
		this.materName = materName;
	}
	
	/** get 名称. */
	public String getMaterName() {
		return this.materName;
	}
	
	@JsonIgnore
	public String getMaterNameByLike() {
		return "%"+this.materName+"%";
	}
	

    /** set 版本ID. */
	public void setVersioncode(String versioncode) {
		this.versioncode = versioncode;
	}
	
	/** get 版本ID. */
	public String getVersioncode() {
		return this.versioncode;
	}
	
	@JsonIgnore
	public String getVersioncodeByLike() {
		return "%"+this.versioncode+"%";
	}
	

    /** set 卷烟品牌ID. */
	public void setCigbrand(String cigbrand) {
		this.cigbrand = cigbrand;
	}
	
	/** get 卷烟品牌ID. */
	public String getCigbrand() {
		return this.cigbrand;
	}
	
	@JsonIgnore
	public String getCigbrandByLike() {
		return "%"+this.cigbrand+"%";
	}
	

    /** set 进口国产标识 0:国产 1:进口. */
	public void setAbroadflag(String abroadflag) {
		this.abroadflag = abroadflag;
	}
	
	/** get 进口国产标识 0:国产 1:进口. */
	public String getAbroadflag() {
		return this.abroadflag;
	}
	
	@JsonIgnore
	public String getAbroadflagByLike() {
		return "%"+this.abroadflag+"%";
	}
	

    /** set 卷烟盒条码. */
	public void setCasebarcode(String casebarcode) {
		this.casebarcode = casebarcode;
	}
	
	/** get 卷烟盒条码. */
	public String getCasebarcode() {
		return this.casebarcode;
	}
	
	@JsonIgnore
	public String getCasebarcodeByLike() {
		return "%"+this.casebarcode+"%";
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
	

    /** set 卷烟箱条码. */
	public void setBoxbarcode(String boxbarcode) {
		this.boxbarcode = boxbarcode;
	}
	
	/** get 卷烟箱条码. */
	public String getBoxbarcode() {
		return this.boxbarcode;
	}
	
	@JsonIgnore
	public String getBoxbarcodeByLike() {
		return "%"+this.boxbarcode+"%";
	}
	

    /** set 条码状态. */
	public void setBarstatus(String barstatus) {
		this.barstatus = barstatus;
	}
	
	/** get 条码状态. */
	public String getBarstatus() {
		return this.barstatus;
	}
	
	@JsonIgnore
	public String getBarstatusByLike() {
		return "%"+this.barstatus+"%";
	}
	

    /** set 是否主条码卷烟 0:否 1:是. */
	public void setIsmajorbar(String ismajorbar) {
		this.ismajorbar = ismajorbar;
	}
	
	/** get 是否主条码卷烟 0:否 1:是. */
	public String getIsmajorbar() {
		return this.ismajorbar;
	}
	
	@JsonIgnore
	public String getIsmajorbarByLike() {
		return "%"+this.ismajorbar+"%";
	}
	

    /** set 生产企业. */
	public void setProductent(String productent) {
		this.productent = productent;
	}
	
	/** get 生产企业. */
	public String getProductent() {
		return this.productent;
	}
	
	@JsonIgnore
	public String getProductentByLike() {
		return "%"+this.productent+"%";
	}
	

    /** set 生产点. */
	public void setProductpoint(String productpoint) {
		this.productpoint = productpoint;
	}
	
	/** get 生产点. */
	public String getProductpoint() {
		return this.productpoint;
	}
	
	@JsonIgnore
	public String getProductpointByLike() {
		return "%"+this.productpoint+"%";
	}
	

    /** set 商标所有者. */
	public void setTrademarkowner(String trademarkowner) {
		this.trademarkowner = trademarkowner;
	}
	
	/** get 商标所有者. */
	public String getTrademarkowner() {
		return this.trademarkowner;
	}
	
	@JsonIgnore
	public String getTrademarkownerByLike() {
		return "%"+this.trademarkowner+"%";
	}
	

    /** set 子公司标志 0:四川 1:重庆. */
	public void setSubcomp(String subcomp) {
		this.subcomp = subcomp;
	}
	
	/** get 子公司标志 0:四川 1:重庆. */
	public String getSubcomp() {
		return this.subcomp;
	}
	
	@JsonIgnore
	public String getSubcompByLike() {
		return "%"+this.subcomp+"%";
	}
	

    /** set 调拨价(不含税). */
	public void setAllotprice0(String allotprice0) {
		this.allotprice0 = allotprice0;
	}
	
	/** get 调拨价(不含税). */
	public String getAllotprice0() {
		return this.allotprice0;
	}
	
	@JsonIgnore
	public String getAllotprice0ByLike() {
		return "%"+this.allotprice0+"%";
	}
	

    /** set 调拨价(含税). */
	public void setAllotprice1(String allotprice1) {
		this.allotprice1 = allotprice1;
	}
	
	/** get 调拨价(含税). */
	public String getAllotprice1() {
		return this.allotprice1;
	}
	
	@JsonIgnore
	public String getAllotprice1ByLike() {
		return "%"+this.allotprice1+"%";
	}
	

    /** set 批发价. */
	public void setBulkprice(String bulkprice) {
		this.bulkprice = bulkprice;
	}
	
	/** get 批发价. */
	public String getBulkprice() {
		return this.bulkprice;
	}
	
	@JsonIgnore
	public String getBulkpriceByLike() {
		return "%"+this.bulkprice+"%";
	}
	

    /** set 市场零售价. */
	public void setSaleprice(String saleprice) {
		this.saleprice = saleprice;
	}
	
	/** get 市场零售价. */
	public String getSaleprice() {
		return this.saleprice;
	}
	
	@JsonIgnore
	public String getSalepriceByLike() {
		return "%"+this.saleprice+"%";
	}
	

    /** set 卷烟价类. */
	public void setPricetype(String pricetype) {
		this.pricetype = pricetype;
	}
	
	/** get 卷烟价类. */
	public String getPricetype() {
		return this.pricetype;
	}
	
	@JsonIgnore
	public String getPricetypeByLike() {
		return "%"+this.pricetype+"%";
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
	

    /** set 滤嘴类型. */
	public void setFiltertype(String filtertype) {
		this.filtertype = filtertype;
	}
	
	/** get 滤嘴类型. */
	public String getFiltertype() {
		return this.filtertype;
	}
	
	@JsonIgnore
	public String getFiltertypeByLike() {
		return "%"+this.filtertype+"%";
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
	

    /** set 包装主颜色. */
	public void setCigmaincolor(String cigmaincolor) {
		this.cigmaincolor = cigmaincolor;
	}
	
	/** get 包装主颜色. */
	public String getCigmaincolor() {
		return this.cigmaincolor;
	}
	
	@JsonIgnore
	public String getCigmaincolorByLike() {
		return "%"+this.cigmaincolor+"%";
	}
	

    /** set 包装辅颜色. */
	public void setCigasscolor(String cigasscolor) {
		this.cigasscolor = cigasscolor;
	}
	
	/** get 包装辅颜色. */
	public String getCigasscolor() {
		return this.cigasscolor;
	}
	
	@JsonIgnore
	public String getCigasscolorByLike() {
		return "%"+this.cigasscolor+"%";
	}
	

    /** set 卷烟名称(外文). */
	public void setCigenname(String cigenname) {
		this.cigenname = cigenname;
	}
	
	/** get 卷烟名称(外文). */
	public String getCigenname() {
		return this.cigenname;
	}
	
	@JsonIgnore
	public String getCigennameByLike() {
		return "%"+this.cigenname+"%";
	}
	

    /** set 卷烟牌号名称(外文). */
	public void setCigbrandenname(String cigbrandenname) {
		this.cigbrandenname = cigbrandenname;
	}
	
	/** get 卷烟牌号名称(外文). */
	public String getCigbrandenname() {
		return this.cigbrandenname;
	}
	
	@JsonIgnore
	public String getCigbrandennameByLike() {
		return "%"+this.cigbrandenname+"%";
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
	

    /** set 包装规格. */
	public void setPackagestandards(String packagestandards) {
		this.packagestandards = packagestandards;
	}
	
	/** get 包装规格. */
	public String getPackagestandards() {
		return this.packagestandards;
	}
	
	@JsonIgnore
	public String getPackagestandardsByLike() {
		return "%"+this.packagestandards+"%";
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
	

    /** set 焦油量(mg). */
	public void setCigtarcontent(String cigtarcontent) {
		this.cigtarcontent = cigtarcontent;
	}
	
	/** get 焦油量(mg). */
	public String getCigtarcontent() {
		return this.cigtarcontent;
	}
	
	@JsonIgnore
	public String getCigtarcontentByLike() {
		return "%"+this.cigtarcontent+"%";
	}
	

    /** set 烟气烟碱量(mg). */
	public void setCignicotinic(String cignicotinic) {
		this.cignicotinic = cignicotinic;
	}
	
	/** get 烟气烟碱量(mg). */
	public String getCignicotinic() {
		return this.cignicotinic;
	}
	
	@JsonIgnore
	public String getCignicotinicByLike() {
		return "%"+this.cignicotinic+"%";
	}
	

    /** set 烟气一氧化碳(mg). */
	public void setCigco(String cigco) {
		this.cigco = cigco;
	}
	
	/** get 烟气一氧化碳(mg). */
	public String getCigco() {
		return this.cigco;
	}
	
	@JsonIgnore
	public String getCigcoByLike() {
		return "%"+this.cigco+"%";
	}
	

    /** set 是否非卖品 0:可卖1：非卖. */
	public void setNotsaleflag(String notsaleflag) {
		this.notsaleflag = notsaleflag;
	}
	
	/** get 是否非卖品 0:可卖1：非卖. */
	public String getNotsaleflag() {
		return this.notsaleflag;
	}
	
	@JsonIgnore
	public String getNotsaleflagByLike() {
		return "%"+this.notsaleflag+"%";
	}
	

    /** set 是否低档烟 0:非低档 1:是低档. */
	public void setCigislow(String cigislow) {
		this.cigislow = cigislow;
	}
	
	/** get 是否低档烟 0:非低档 1:是低档. */
	public String getCigislow() {
		return this.cigislow;
	}
	
	@JsonIgnore
	public String getCigislowByLike() {
		return "%"+this.cigislow+"%";
	}
	

    /** set 是否名优烟0:非名优烟 1:是名优烟. */
	public void setCigisgreat(String cigisgreat) {
		this.cigisgreat = cigisgreat;
	}
	
	/** get 是否名优烟0:非名优烟 1:是名优烟. */
	public String getCigisgreat() {
		return this.cigisgreat;
	}
	
	@JsonIgnore
	public String getCigisgreatByLike() {
		return "%"+this.cigisgreat+"%";
	}
	

    /** set 是否福祥促试烟0:非福祥促试1:是福祥促试. */
	public void setCigistrial(String cigistrial) {
		this.cigistrial = cigistrial;
	}
	
	/** get 是否福祥促试烟0:非福祥促试1:是福祥促试. */
	public String getCigistrial() {
		return this.cigistrial;
	}
	
	@JsonIgnore
	public String getCigistrialByLike() {
		return "%"+this.cigistrial+"%";
	}
	

    /** set 联营烟单位. */
	public void setJointunit(String jointunit) {
		this.jointunit = jointunit;
	}
	
	/** get 联营烟单位. */
	public String getJointunit() {
		return this.jointunit;
	}
	
	@JsonIgnore
	public String getJointunitByLike() {
		return "%"+this.jointunit+"%";
	}
	

    /** set 内部结算价. */
	public void setInnerbalance(String innerbalance) {
		this.innerbalance = innerbalance;
	}
	
	/** get 内部结算价. */
	public String getInnerbalance() {
		return this.innerbalance;
	}
	
	@JsonIgnore
	public String getInnerbalanceByLike() {
		return "%"+this.innerbalance+"%";
	}
	

    /** set 销售范围. */
	public void setSalescope(String salescope) {
		this.salescope = salescope;
	}
	
	/** get 销售范围. */
	public String getSalescope() {
		return this.salescope;
	}
	
	@JsonIgnore
	public String getSalescopeByLike() {
		return "%"+this.salescope+"%";
	}
	

    /** set 是否在用  0:停用 1:在用. */
	public void setIsusing(String isusing) {
		this.isusing = isusing;
	}
	
	/** get 是否在用  0:停用 1:在用. */
	public String getIsusing() {
		return this.isusing;
	}
	
	@JsonIgnore
	public String getIsusingByLike() {
		return "%"+this.isusing+"%";
	}
	

    /** set 准生成日期. */
	public void setCigapprvdate(String cigapprvdate) {
		this.cigapprvdate = cigapprvdate;
	}
	
	/** get 准生成日期. */
	public String getCigapprvdate() {
		return this.cigapprvdate;
	}
	
	@JsonIgnore
	public String getCigapprvdateByLike() {
		return "%"+this.cigapprvdate+"%";
	}
	

    /** set 产品停产日期. */
	public void setCigltstupdate(String cigltstupdate) {
		this.cigltstupdate = cigltstupdate;
	}
	
	/** get 产品停产日期. */
	public String getCigltstupdate() {
		return this.cigltstupdate;
	}
	
	@JsonIgnore
	public String getCigltstupdateByLike() {
		return "%"+this.cigltstupdate+"%";
	}
	

    /** set 税则号. */
	public void setCigtax(String cigtax) {
		this.cigtax = cigtax;
	}
	
	/** get 税则号. */
	public String getCigtax() {
		return this.cigtax;
	}
	
	@JsonIgnore
	public String getCigtaxByLike() {
		return "%"+this.cigtax+"%";
	}
	

    /** set 助记符. */
	public void setRemcode(String remcode) {
		this.remcode = remcode;
	}
	
	/** get 助记符. */
	public String getRemcode() {
		return this.remcode;
	}
	
	@JsonIgnore
	public String getRemcodeByLike() {
		return "%"+this.remcode+"%";
	}
	

    /** set 备注. */
	public void setCigmemo(String cigmemo) {
		this.cigmemo = cigmemo;
	}
	
	/** get 备注. */
	public String getCigmemo() {
		return this.cigmemo;
	}
	
	@JsonIgnore
	public String getCigmemoByLike() {
		return "%"+this.cigmemo+"%";
	}
	

    /** set 卷烟系列 共取6位编码前两位为01的存货分类ID. */
	public void setInventoreId(String inventoreId) {
		this.inventoreId = inventoreId;
	}
	
	/** get 卷烟系列 共取6位编码前两位为01的存货分类ID. */
	public String getInventoreId() {
		return this.inventoreId;
	}
	
	@JsonIgnore
	public String getInventoreIdByLike() {
		return "%"+this.inventoreId+"%";
	}
	

    /** set 卷烟类别符. */
	public void setCigarettetype(String cigarettetype) {
		this.cigarettetype = cigarettetype;
	}
	
	/** get 卷烟类别符. */
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
	

    /** set 包装识别码. */
	public void setPackingcode(String packingcode) {
		this.packingcode = packingcode;
	}
	
	/** get 包装识别码. */
	public String getPackingcode() {
		return this.packingcode;
	}
	
	@JsonIgnore
	public String getPackingcodeByLike() {
		return "%"+this.packingcode+"%";
	}
	

    /** set 调拨价(不含税)[元/支]. */
	public void setAllotprice2(String allotprice2) {
		this.allotprice2 = allotprice2;
	}
	
	/** get 调拨价(不含税)[元/支]. */
	public String getAllotprice2() {
		return this.allotprice2;
	}
	
	@JsonIgnore
	public String getAllotprice2ByLike() {
		return "%"+this.allotprice2+"%";
	}
	

    /** set 调拨价(不含税)[元/万支]. */
	public void setAllotprice3(String allotprice3) {
		this.allotprice3 = allotprice3;
	}
	
	/** get 调拨价(不含税)[元/万支]. */
	public String getAllotprice3() {
		return this.allotprice3;
	}
	
	@JsonIgnore
	public String getAllotprice3ByLike() {
		return "%"+this.allotprice3+"%";
	}
	

    /** set 调拨价(含税)[元/支]. */
	public void setAllotprice4(String allotprice4) {
		this.allotprice4 = allotprice4;
	}
	
	/** get 调拨价(含税)[元/支]. */
	public String getAllotprice4() {
		return this.allotprice4;
	}
	
	@JsonIgnore
	public String getAllotprice4ByLike() {
		return "%"+this.allotprice4+"%";
	}
	

    /** set 调拨价(含税)[元/万支]. */
	public void setAllotprice5(String allotprice5) {
		this.allotprice5 = allotprice5;
	}
	
	/** get 调拨价(含税)[元/万支]. */
	public String getAllotprice5() {
		return this.allotprice5;
	}
	
	@JsonIgnore
	public String getAllotprice5ByLike() {
		return "%"+this.allotprice5+"%";
	}
	

    /** set 关联半成品. */
	public void setLinkTobaccoCut(String linkTobaccoCut) {
		this.linkTobaccoCut = linkTobaccoCut;
	}
	
	/** get 关联半成品. */
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
	public MaterialinfoEntity() {
		super();
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

	/**
	 * constructor.<p>
	 * @param dataId			主数据id
	 * @param materCode			编码
	 * @param materName			名称
	 * @param versioncode			版本ID
	 * @param cigbrand			卷烟品牌ID
	 * @param abroadflag			进口国产标识 0:国产 1:进口
	 * @param casebarcode			卷烟盒条码
	 * @param barbarcode			卷烟条条码
	 * @param boxbarcode			卷烟箱条码
	 * @param barstatus			条码状态
	 * @param ismajorbar			是否主条码卷烟 0:否 1:是
	 * @param productent			生产企业
	 * @param productpoint			生产点
	 * @param trademarkowner			商标所有者
	 * @param subcomp			子公司标志 0:四川 1:重庆
	 * @param allotprice0			调拨价(不含税)
	 * @param allotprice1			调拨价(含税)
	 * @param bulkprice			批发价
	 * @param saleprice			市场零售价
	 * @param pricetype			卷烟价类
	 * @param cigtype			卷烟类型
	 * @param filtertype			滤嘴类型
	 * @param producttype			生产类型
	 * @param cigmaincolor			包装主颜色
	 * @param cigasscolor			包装辅颜色
	 * @param cigenname			卷烟名称(外文)
	 * @param cigbrandenname			卷烟牌号名称(外文)
	 * @param packageform			包装形式
	 * @param packagestandards			包装规格
	 * @param cigtotallen			烟支总长度(mm)
	 * @param ciglength			烟支长度(mm)
	 * @param filterlength			烟嘴长度(mm)
	 * @param ciggirth			烟支周长(mm)
	 * @param cigtarcontent			焦油量(mg)
	 * @param cignicotinic			烟气烟碱量(mg)
	 * @param cigco			烟气一氧化碳(mg)
	 * @param notsaleflag			是否非卖品 0:可卖1：非卖
	 * @param cigislow			是否低档烟 0:非低档 1:是低档
	 * @param cigisgreat			是否名优烟0:非名优烟 1:是名优烟
	 * @param cigistrial			是否福祥促试烟0:非福祥促试1:是福祥促试
	 * @param jointunit			联营烟单位
	 * @param innerbalance			内部结算价
	 * @param salescope			销售范围
	 * @param isusing			是否在用  0:停用 1:在用
	 * @param cigapprvdate			准生成日期
	 * @param cigltstupdate			产品停产日期
	 * @param cigtax			税则号
	 * @param remcode			助记符
	 * @param cigmemo			备注
	 * @param inventoreId			卷烟系列 共取6位编码前两位为01的存货分类ID
	 * @param cigarettetype			卷烟类别符
	 * @param standardscode			卷烟规格码
	 * @param formulacode			配方识别码
	 * @param packingcode			包装识别码
	 * @param allotprice2			调拨价(不含税)[元/支]
	 * @param allotprice3			调拨价(不含税)[元/万支]
	 * @param allotprice4			调拨价(含税)[元/支]
	 * @param allotprice5			调拨价(含税)[元/万支]
	 * @param linkTobaccoCut			关联半成品
	 * @param status			状态 2：发布 3：停用
	 * @param createdDate			创建时间
	 * @param createdPerson			创建人
	 * @param updatedDate			更新时间
	 * @param updatedPerson			更新人
	 */
	public MaterialinfoEntity(String dataId,String materCode,String materName,String versioncode,String cigbrand,String abroadflag,String casebarcode,String barbarcode,String boxbarcode,String barstatus,String ismajorbar,String productent,String productpoint,String trademarkowner,String subcomp,String allotprice0,String allotprice1,String bulkprice,String saleprice,String pricetype,String cigtype,String filtertype,String producttype,String cigmaincolor,String cigasscolor,String cigenname,String cigbrandenname,String packageform,String packagestandards,String cigtotallen,String ciglength,String filterlength,String ciggirth,String cigtarcontent,String cignicotinic,String cigco,String notsaleflag,String cigislow,String cigisgreat,String cigistrial,String jointunit,String innerbalance,String salescope,String isusing,String cigapprvdate,String cigltstupdate,String cigtax,String remcode,String cigmemo,String inventoreId,String cigarettetype,String standardscode,String formulacode,String packingcode,String allotprice2,String allotprice3,String allotprice4,String allotprice5,String linkTobaccoCut,String status,java.util.Date createdDate,String createdPerson,java.util.Date updatedDate,String updatedPerson){
		this();
		this.dataId = dataId;
		this.materCode = materCode;
		this.materName = materName;
		this.versioncode = versioncode;
		this.cigbrand = cigbrand;
		this.abroadflag = abroadflag;
		this.casebarcode = casebarcode;
		this.barbarcode = barbarcode;
		this.boxbarcode = boxbarcode;
		this.barstatus = barstatus;
		this.ismajorbar = ismajorbar;
		this.productent = productent;
		this.productpoint = productpoint;
		this.trademarkowner = trademarkowner;
		this.subcomp = subcomp;
		this.allotprice0 = allotprice0;
		this.allotprice1 = allotprice1;
		this.bulkprice = bulkprice;
		this.saleprice = saleprice;
		this.pricetype = pricetype;
		this.cigtype = cigtype;
		this.filtertype = filtertype;
		this.producttype = producttype;
		this.cigmaincolor = cigmaincolor;
		this.cigasscolor = cigasscolor;
		this.cigenname = cigenname;
		this.cigbrandenname = cigbrandenname;
		this.packageform = packageform;
		this.packagestandards = packagestandards;
		this.cigtotallen = cigtotallen;
		this.ciglength = ciglength;
		this.filterlength = filterlength;
		this.ciggirth = ciggirth;
		this.cigtarcontent = cigtarcontent;
		this.cignicotinic = cignicotinic;
		this.cigco = cigco;
		this.notsaleflag = notsaleflag;
		this.cigislow = cigislow;
		this.cigisgreat = cigisgreat;
		this.cigistrial = cigistrial;
		this.jointunit = jointunit;
		this.innerbalance = innerbalance;
		this.salescope = salescope;
		this.isusing = isusing;
		this.cigapprvdate = cigapprvdate;
		this.cigltstupdate = cigltstupdate;
		this.cigtax = cigtax;
		this.remcode = remcode;
		this.cigmemo = cigmemo;
		this.inventoreId = inventoreId;
		this.cigarettetype = cigarettetype;
		this.standardscode = standardscode;
		this.formulacode = formulacode;
		this.packingcode = packingcode;
		this.allotprice2 = allotprice2;
		this.allotprice3 = allotprice3;
		this.allotprice4 = allotprice4;
		this.allotprice5 = allotprice5;
		this.linkTobaccoCut = linkTobaccoCut;
		this.status = status;
		this.createdDate = createdDate;
		this.createdPerson = createdPerson;
		this.updatedDate = updatedDate;
		this.updatedPerson = updatedPerson;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("MaterialinfoEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("DataId=").append(getDataId()).append(", ")
			.append("MaterCode=").append(getMaterCode()).append(", ")
			.append("MaterName=").append(getMaterName()).append(", ")
			.append("Versioncode=").append(getVersioncode()).append(", ")
			.append("Cigbrand=").append(getCigbrand()).append(", ")
			.append("Abroadflag=").append(getAbroadflag()).append(", ")
			.append("Casebarcode=").append(getCasebarcode()).append(", ")
			.append("Barbarcode=").append(getBarbarcode()).append(", ")
			.append("Boxbarcode=").append(getBoxbarcode()).append(", ")
			.append("Barstatus=").append(getBarstatus()).append(", ")
			.append("Ismajorbar=").append(getIsmajorbar()).append(", ")
			.append("Productent=").append(getProductent()).append(", ")
			.append("Productpoint=").append(getProductpoint()).append(", ")
			.append("Trademarkowner=").append(getTrademarkowner()).append(", ")
			.append("Subcomp=").append(getSubcomp()).append(", ")
			.append("Allotprice0=").append(getAllotprice0()).append(", ")
			.append("Allotprice1=").append(getAllotprice1()).append(", ")
			.append("Bulkprice=").append(getBulkprice()).append(", ")
			.append("Saleprice=").append(getSaleprice()).append(", ")
			.append("Pricetype=").append(getPricetype()).append(", ")
			.append("Cigtype=").append(getCigtype()).append(", ")
			.append("Filtertype=").append(getFiltertype()).append(", ")
			.append("Producttype=").append(getProducttype()).append(", ")
			.append("Cigmaincolor=").append(getCigmaincolor()).append(", ")
			.append("Cigasscolor=").append(getCigasscolor()).append(", ")
			.append("Cigenname=").append(getCigenname()).append(", ")
			.append("Cigbrandenname=").append(getCigbrandenname()).append(", ")
			.append("Packageform=").append(getPackageform()).append(", ")
			.append("Packagestandards=").append(getPackagestandards()).append(", ")
			.append("Cigtotallen=").append(getCigtotallen()).append(", ")
			.append("Ciglength=").append(getCiglength()).append(", ")
			.append("Filterlength=").append(getFilterlength()).append(", ")
			.append("Ciggirth=").append(getCiggirth()).append(", ")
			.append("Cigtarcontent=").append(getCigtarcontent()).append(", ")
			.append("Cignicotinic=").append(getCignicotinic()).append(", ")
			.append("Cigco=").append(getCigco()).append(", ")
			.append("Notsaleflag=").append(getNotsaleflag()).append(", ")
			.append("Cigislow=").append(getCigislow()).append(", ")
			.append("Cigisgreat=").append(getCigisgreat()).append(", ")
			.append("Cigistrial=").append(getCigistrial()).append(", ")
			.append("Jointunit=").append(getJointunit()).append(", ")
			.append("Innerbalance=").append(getInnerbalance()).append(", ")
			.append("Salescope=").append(getSalescope()).append(", ")
			.append("Isusing=").append(getIsusing()).append(", ")
			.append("Cigapprvdate=").append(getCigapprvdate()).append(", ")
			.append("Cigltstupdate=").append(getCigltstupdate()).append(", ")
			.append("Cigtax=").append(getCigtax()).append(", ")
			.append("Remcode=").append(getRemcode()).append(", ")
			.append("Cigmemo=").append(getCigmemo()).append(", ")
			.append("InventoreId=").append(getInventoreId()).append(", ")
			.append("Cigarettetype=").append(getCigarettetype()).append(", ")
			.append("Standardscode=").append(getStandardscode()).append(", ")
			.append("Formulacode=").append(getFormulacode()).append(", ")
			.append("Packingcode=").append(getPackingcode()).append(", ")
			.append("Allotprice2=").append(getAllotprice2()).append(", ")
			.append("Allotprice3=").append(getAllotprice3()).append(", ")
			.append("Allotprice4=").append(getAllotprice4()).append(", ")
			.append("Allotprice5=").append(getAllotprice5()).append(", ")
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
		if(obj instanceof MaterialinfoEntity == false)
			return false;
		if(this == obj)
			return true;
		MaterialinfoEntity other = (MaterialinfoEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
