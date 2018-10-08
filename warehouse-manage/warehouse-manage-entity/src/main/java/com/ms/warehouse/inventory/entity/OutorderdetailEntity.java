
package com.ms.warehouse.inventory.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;
import com.ms.warehouse.manage.entity.SubversionEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 出库单详情
 * @author dwf
 * @Date 2018-08-24 15:13:51
 * @since 1.0
 */
@TableName("t_ware_outorderdetail")
public class OutorderdetailEntity extends BaseEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 自增id. */
	private Long id;

	/** 出库单id. */
	private Long mainorderId;

	/** 物料编码、条码. */
	private String materCode;

	/** 物料名称. */
	private String materName;

	/** 数量（件）. */
	private java.math.BigDecimal qualityBox;

	/** 单价（不含税）. */
	private java.math.BigDecimal priceNotax;

	/** 金额（不含税）. */
	private java.math.BigDecimal amountNotax;

	/** 税率. */
	private java.math.BigDecimal taxRate;

	/** 税额. */
	private java.math.BigDecimal taxAmount;

	/** 总金额（价税合计）. */
	private java.math.BigDecimal amount;

	/** 版本. */
	private String materVersion;

	/** 品牌. */
	private String materCigbrand;

	/** 卷烟类型：0正式卷烟1福样促试. */
	private Long cigtype;

	/** 子版本ID. */
	private Long subverId;

	/** 子版本名称. */
	private String subverName;

	/** 是否删除0否1是. */
	private Integer isDelete;

	private  String uuid;

	private List<SubversionEntity> subList = new ArrayList<>();

	public List<SubversionEntity> getSubList() {
		return subList;
	}

	public void setSubList(List<SubversionEntity> subList) {
		this.subList = subList;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	private BigDecimal converCoef;

	public BigDecimal getConverCoef() {
		return converCoef;
	}

	public void setConverCoef(BigDecimal converCoef) {
		this.converCoef = converCoef;
	}

	/**
	 * 可操作数量
	 */
	private BigDecimal usableQuality;

	public void setUsableQuality(BigDecimal usableQuality) {
		this.usableQuality = usableQuality;
	}

	public BigDecimal getUsableQuality() {
		return usableQuality;
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


	/** set 出库单id. */
	public void setMainorderId(Long mainorderId) {
		this.mainorderId = mainorderId;
	}

	/** get 出库单id. */
	public Long getMainorderId() {
		return this.mainorderId;
	}

	@JsonIgnore
	public Long getMainorderIdByLike() {
		return this.mainorderId;
	}


	/** set 物料编码、条码. */
	public void setMaterCode(String materCode) {
		this.materCode = materCode;
	}

	/** get 物料编码、条码. */
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


	/** set 数量（件）. */
	public void setQualityBox(java.math.BigDecimal qualityBox) {
		this.qualityBox = qualityBox;
	}

	/** get 数量（件）. */
	public java.math.BigDecimal getQualityBox() {
		return this.qualityBox;
	}

	@JsonIgnore
	public java.math.BigDecimal getQualityBoxByLike() {
		return this.qualityBox;
	}


	/** set 单价（不含税）. */
	public void setPriceNotax(java.math.BigDecimal priceNotax) {
		this.priceNotax = priceNotax;
	}

	/** get 单价（不含税）. */
	public java.math.BigDecimal getPriceNotax() {
		return this.priceNotax;
	}

	@JsonIgnore
	public java.math.BigDecimal getPriceNotaxByLike() {
		return this.priceNotax;
	}


	/** set 金额（不含税）. */
	public void setAmountNotax(java.math.BigDecimal amountNotax) {
		this.amountNotax = amountNotax;
	}

	/** get 金额（不含税）. */
	public java.math.BigDecimal getAmountNotax() {
		return this.amountNotax;
	}

	@JsonIgnore
	public java.math.BigDecimal getAmountNotaxByLike() {
		return this.amountNotax;
	}


	/** set 税率. */
	public void setTaxRate(java.math.BigDecimal taxRate) {
		this.taxRate = taxRate;
	}

	/** get 税率. */
	public java.math.BigDecimal getTaxRate() {
		return this.taxRate;
	}

	@JsonIgnore
	public java.math.BigDecimal getTaxRateByLike() {
		return this.taxRate;
	}


	/** set 税额. */
	public void setTaxAmount(java.math.BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}

	/** get 税额. */
	public java.math.BigDecimal getTaxAmount() {
		return this.taxAmount;
	}

	@JsonIgnore
	public java.math.BigDecimal getTaxAmountByLike() {
		return this.taxAmount;
	}


	/** set 总金额（价税合计）. */
	public void setAmount(java.math.BigDecimal amount) {
		this.amount = amount;
	}

	/** get 总金额（价税合计）. */
	public java.math.BigDecimal getAmount() {
		return this.amount;
	}

	@JsonIgnore
	public java.math.BigDecimal getAmountByLike() {
		return this.amount;
	}


	/** set 版本. */
	public void setMaterVersion(String materVersion) {
		this.materVersion = materVersion;
	}

	/** get 版本. */
	public String getMaterVersion() {
		return this.materVersion;
	}

	@JsonIgnore
	public String getMaterVersionByLike() {
		return "%"+this.materVersion+"%";
	}


	/** set 品牌. */
	public void setMaterCigbrand(String materCigbrand) {
		this.materCigbrand = materCigbrand;
	}

	/** get 品牌. */
	public String getMaterCigbrand() {
		return this.materCigbrand;
	}

	@JsonIgnore
	public String getMaterCigbrandByLike() {
		return "%"+this.materCigbrand+"%";
	}


	/** set 卷烟类型：0正式卷烟1福样促试. */
	public void setCigtype(Long cigtype) {
		this.cigtype = cigtype;
	}

	/** get 卷烟类型：0正式卷烟1福样促试. */
	public Long getCigtype() {
		return this.cigtype;
	}

	@JsonIgnore
	public Long getCigtypeByLike() {
		return this.cigtype;
	}


	/** set 子版本ID. */
	public void setSubverId(Long subverId) {
		this.subverId = subverId;
	}

	/** get 子版本ID. */
	public Long getSubverId() {
		return this.subverId;
	}

	@JsonIgnore
	public Long getSubverIdByLike() {
		return this.subverId;
	}


	/** set 子版本名称. */
	public void setSubverName(String subverName) {
		this.subverName = subverName;
	}

	/** get 子版本名称. */
	public String getSubverName() {
		return this.subverName;
	}

	@JsonIgnore
	public String getSubverNameByLike() {
		return "%"+this.subverName+"%";
	}


	/** set 是否删除0否1是. */
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	/** get 是否删除0否1是. */
	public Integer getIsDelete() {
		return this.isDelete;
	}

	@JsonIgnore
	public Integer getIsDeleteByLike() {
		return this.isDelete;
	}

	/** constructor */
	public OutorderdetailEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param mainorderId			出库单id
	 * @param materCode			物料编码、条码
	 * @param materName			物料名称
	 * @param qualityBox			数量（件）
	 * @param priceNotax			单价（不含税）
	 * @param amountNotax			金额（不含税）
	 * @param taxRate			税率
	 * @param taxAmount			税额
	 * @param amount			总金额（价税合计）
	 * @param materVersion			版本
	 * @param materCigbrand			品牌
	 * @param cigtype			卷烟类型：0正式卷烟1福样促试
	 * @param subverId			子版本ID
	 * @param subverName			子版本名称
	 * @param isDelete			是否删除0否1是
	 */
	public OutorderdetailEntity(Long mainorderId,String materCode,String materName,java.math.BigDecimal qualityBox,java.math.BigDecimal priceNotax,java.math.BigDecimal amountNotax,java.math.BigDecimal taxRate,java.math.BigDecimal taxAmount,java.math.BigDecimal amount,String materVersion,String materCigbrand,Long cigtype,Long subverId,String subverName,Integer isDelete){
		this();
		this.mainorderId = mainorderId;
		this.materCode = materCode;
		this.materName = materName;
		this.qualityBox = qualityBox;
		this.priceNotax = priceNotax;
		this.amountNotax = amountNotax;
		this.taxRate = taxRate;
		this.taxAmount = taxAmount;
		this.amount = amount;
		this.materVersion = materVersion;
		this.materCigbrand = materCigbrand;
		this.cigtype = cigtype;
		this.subverId = subverId;
		this.subverName = subverName;
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return new StringBuilder().append("OutorderdetailEntity[")
				.append("Id=").append(getId()).append(", ")
				.append("MainorderId=").append(getMainorderId()).append(", ")
				.append("MaterCode=").append(getMaterCode()).append(", ")
				.append("MaterName=").append(getMaterName()).append(", ")
				.append("QualityBox=").append(getQualityBox()).append(", ")
				.append("PriceNotax=").append(getPriceNotax()).append(", ")
				.append("AmountNotax=").append(getAmountNotax()).append(", ")
				.append("TaxRate=").append(getTaxRate()).append(", ")
				.append("TaxAmount=").append(getTaxAmount()).append(", ")
				.append("Amount=").append(getAmount()).append(", ")
				.append("MaterVersion=").append(getMaterVersion()).append(", ")
				.append("MaterCigbrand=").append(getMaterCigbrand()).append(", ")
				.append("Cigtype=").append(getCigtype()).append(", ")
				.append("SubverId=").append(getSubverId()).append(", ")
				.append("SubverName=").append(getSubverName()).append(", ")
				.append("IsDelete=").append(getIsDelete())
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
		if(obj instanceof OutorderdetailEntity == false)
			return false;
		if(this == obj)
			return true;
		OutorderdetailEntity other = (OutorderdetailEntity)obj;

		return this.toString().equals(other.toString());
	}
}
