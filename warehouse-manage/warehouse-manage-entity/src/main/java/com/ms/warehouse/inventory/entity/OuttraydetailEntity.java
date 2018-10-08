/**
 * 
 */
package com.ms.warehouse.inventory.entity;

/**
 * @author Administrator
 *
 */
public class OuttraydetailEntity extends OuttraylocalmapEntity{
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 出库单id. */
	private Long mainorderId;
	
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
	
	/** 订单编号. */
	private String orderNumber;

	/** 物流单号，来源单号. */
	private String shipmentNumber;

	/** 制单日期. */
	private java.util.Date shipmentDate;

	/** 车牌号. */
	private String plateNumber;

	/** 总量（件）. */
	private java.math.BigDecimal totalQuality;

	/** 发货日期. */
	private java.util.Date deliveryDate;

	/** 运输方式. */
	private String transportType;

	/** 承运人. */
	private String carrier;

	/** 联系电话. */
	private String phoneNumber;

	/** 承运单位. */
	private String carrierUnit;

	/** 承运单位编码. */
	private String carrierUnitCode;

	/** 预约装车日期. */
	private java.util.Date reservationDate;

	/** 物流单备注. */
	private String shipmentRemark;

	/** 合同号. */
	private String contractNumber;

	/** 合同日期. */
	private java.util.Date contractDate;

	/** 出库仓库编码. */
	private String outboundWareCode;

	/** 出库仓库名称. */
	private String outboundWare;

	/** 到货仓库编码. */
	private String arrivalWareCode;

	/** 到货仓库名称. */
	private String arrivalWare;

	/** 要求到货时间. */
	private String arrivalRequire;

	/** 发货要求. */
	private String deliveryRequire;

	/** 备注. */
	private String remark;

	/** 出库完成时间. */
	private java.util.Date outCompliteDate;


	/** 发货单位编码. */
	private String forwardUnitCode;

	/** 发货单位名称. */
	private String forwardUnit;

	/** 购货单位编码. */
	private String purchaseUnitCode;

	/** 购货单位名称. */
	private String purchaseUnit;

	/** nc仓库编吗. */
	private String ncWareCode;

	/** nc仓库名称. */
	private String ncWare;

	/** 出库通道编号. */
	private String outchanCode;

	/** 开始装车时间. */
	private java.util.Date loadDate;

	/** 运输方式编码. */
	private String transportCode;

	/** 是否删除0否1是. */
	private Integer isDelete;

	/** 是否紧急出库 0否 1是. */
	private Integer isUrgent;

	/** 出库优先级，1为最高优先级. */
	private Long priorityLevel;

	/** 订单来源方式：1物流系统 2手动录入. */
	private Long orignMethod;

	/** 状态0出库中1出库完成. */
	private Long localmapStatus;

	public Long getMainorderId() {
		return mainorderId;
	}

	public void setMainorderId(Long mainorderId) {
		this.mainorderId = mainorderId;
	}

	public String getMaterName() {
		return materName;
	}

	public void setMaterName(String materName) {
		this.materName = materName;
	}

	public java.math.BigDecimal getQualityBox() {
		return qualityBox;
	}

	public void setQualityBox(java.math.BigDecimal qualityBox) {
		this.qualityBox = qualityBox;
	}

	public java.math.BigDecimal getPriceNotax() {
		return priceNotax;
	}

	public void setPriceNotax(java.math.BigDecimal priceNotax) {
		this.priceNotax = priceNotax;
	}

	public java.math.BigDecimal getAmountNotax() {
		return amountNotax;
	}

	public void setAmountNotax(java.math.BigDecimal amountNotax) {
		this.amountNotax = amountNotax;
	}

	public java.math.BigDecimal getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(java.math.BigDecimal taxRate) {
		this.taxRate = taxRate;
	}

	public java.math.BigDecimal getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(java.math.BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}

	public java.math.BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(java.math.BigDecimal amount) {
		this.amount = amount;
	}

	public String getMaterVersion() {
		return materVersion;
	}

	public void setMaterVersion(String materVersion) {
		this.materVersion = materVersion;
	}

	public String getMaterCigbrand() {
		return materCigbrand;
	}

	public void setMaterCigbrand(String materCigbrand) {
		this.materCigbrand = materCigbrand;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getShipmentNumber() {
		return shipmentNumber;
	}

	public void setShipmentNumber(String shipmentNumber) {
		this.shipmentNumber = shipmentNumber;
	}

	public java.util.Date getShipmentDate() {
		return shipmentDate;
	}

	public void setShipmentDate(java.util.Date shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public java.math.BigDecimal getTotalQuality() {
		return totalQuality;
	}

	public void setTotalQuality(java.math.BigDecimal totalQuality) {
		this.totalQuality = totalQuality;
	}

	public java.util.Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(java.util.Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getTransportType() {
		return transportType;
	}

	public void setTransportType(String transportType) {
		this.transportType = transportType;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCarrierUnit() {
		return carrierUnit;
	}

	public void setCarrierUnit(String carrierUnit) {
		this.carrierUnit = carrierUnit;
	}

	public String getCarrierUnitCode() {
		return carrierUnitCode;
	}

	public void setCarrierUnitCode(String carrierUnitCode) {
		this.carrierUnitCode = carrierUnitCode;
	}

	public java.util.Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(java.util.Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public String getShipmentRemark() {
		return shipmentRemark;
	}

	public void setShipmentRemark(String shipmentRemark) {
		this.shipmentRemark = shipmentRemark;
	}

	public String getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}

	public java.util.Date getContractDate() {
		return contractDate;
	}

	public void setContractDate(java.util.Date contractDate) {
		this.contractDate = contractDate;
	}

	public String getOutboundWareCode() {
		return outboundWareCode;
	}

	public void setOutboundWareCode(String outboundWareCode) {
		this.outboundWareCode = outboundWareCode;
	}

	public String getOutboundWare() {
		return outboundWare;
	}

	public void setOutboundWare(String outboundWare) {
		this.outboundWare = outboundWare;
	}

	public String getArrivalWareCode() {
		return arrivalWareCode;
	}

	public void setArrivalWareCode(String arrivalWareCode) {
		this.arrivalWareCode = arrivalWareCode;
	}

	public String getArrivalWare() {
		return arrivalWare;
	}

	public void setArrivalWare(String arrivalWare) {
		this.arrivalWare = arrivalWare;
	}

	public String getArrivalRequire() {
		return arrivalRequire;
	}

	public void setArrivalRequire(String arrivalRequire) {
		this.arrivalRequire = arrivalRequire;
	}

	public String getDeliveryRequire() {
		return deliveryRequire;
	}

	public void setDeliveryRequire(String deliveryRequire) {
		this.deliveryRequire = deliveryRequire;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public java.util.Date getOutCompliteDate() {
		return outCompliteDate;
	}

	public void setOutCompliteDate(java.util.Date outCompliteDate) {
		this.outCompliteDate = outCompliteDate;
	}

	public String getForwardUnitCode() {
		return forwardUnitCode;
	}

	public void setForwardUnitCode(String forwardUnitCode) {
		this.forwardUnitCode = forwardUnitCode;
	}

	public String getForwardUnit() {
		return forwardUnit;
	}

	public void setForwardUnit(String forwardUnit) {
		this.forwardUnit = forwardUnit;
	}

	public String getPurchaseUnitCode() {
		return purchaseUnitCode;
	}

	public void setPurchaseUnitCode(String purchaseUnitCode) {
		this.purchaseUnitCode = purchaseUnitCode;
	}

	public String getPurchaseUnit() {
		return purchaseUnit;
	}

	public void setPurchaseUnit(String purchaseUnit) {
		this.purchaseUnit = purchaseUnit;
	}

	public String getNcWareCode() {
		return ncWareCode;
	}

	public void setNcWareCode(String ncWareCode) {
		this.ncWareCode = ncWareCode;
	}

	public String getNcWare() {
		return ncWare;
	}

	public void setNcWare(String ncWare) {
		this.ncWare = ncWare;
	}

	public String getOutchanCode() {
		return outchanCode;
	}

	public void setOutchanCode(String outchanCode) {
		this.outchanCode = outchanCode;
	}

	public java.util.Date getLoadDate() {
		return loadDate;
	}

	public void setLoadDate(java.util.Date loadDate) {
		this.loadDate = loadDate;
	}

	public String getTransportCode() {
		return transportCode;
	}

	public void setTransportCode(String transportCode) {
		this.transportCode = transportCode;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getIsUrgent() {
		return isUrgent;
	}

	public void setIsUrgent(Integer isUrgent) {
		this.isUrgent = isUrgent;
	}

	public Long getPriorityLevel() {
		return priorityLevel;
	}

	public void setPriorityLevel(Long priorityLevel) {
		this.priorityLevel = priorityLevel;
	}

	public Long getOrignMethod() {
		return orignMethod;
	}

	public void setOrignMethod(Long orignMethod) {
		this.orignMethod = orignMethod;
	}

	public Long getLocalmapStatus() {
		return localmapStatus;
	}

	public void setLocalmapStatus(Long localmapStatus) {
		this.localmapStatus = localmapStatus;
	}

	@Override
	public String toString() {
		return "OuttraydetailEntity [mainorderId=" + mainorderId + ", materName=" + materName + ", qualityBox="
				+ qualityBox + ", priceNotax=" + priceNotax + ", amountNotax=" + amountNotax + ", taxRate=" + taxRate
				+ ", taxAmount=" + taxAmount + ", amount=" + amount + ", materVersion=" + materVersion
				+ ", materCigbrand=" + materCigbrand + ", orderNumber=" + orderNumber + ", shipmentNumber="
				+ shipmentNumber + ", shipmentDate=" + shipmentDate + ", plateNumber=" + plateNumber + ", totalQuality="
				+ totalQuality + ", deliveryDate=" + deliveryDate + ", transportType=" + transportType + ", carrier="
				+ carrier + ", phoneNumber=" + phoneNumber + ", carrierUnit=" + carrierUnit + ", carrierUnitCode="
				+ carrierUnitCode + ", reservationDate=" + reservationDate + ", shipmentRemark=" + shipmentRemark
				+ ", contractNumber=" + contractNumber + ", contractDate=" + contractDate + ", outboundWareCode="
				+ outboundWareCode + ", outboundWare=" + outboundWare + ", arrivalWareCode=" + arrivalWareCode
				+ ", arrivalWare=" + arrivalWare + ", arrivalRequire=" + arrivalRequire + ", deliveryRequire="
				+ deliveryRequire + ", remark=" + remark + ", outCompliteDate=" + outCompliteDate + ", forwardUnitCode="
				+ forwardUnitCode + ", forwardUnit=" + forwardUnit + ", purchaseUnitCode=" + purchaseUnitCode
				+ ", purchaseUnit=" + purchaseUnit + ", ncWareCode=" + ncWareCode + ", ncWare=" + ncWare
				+ ", outchanCode=" + outchanCode + ", loadDate=" + loadDate + ", transportCode=" + transportCode
				+ ", isDelete=" + isDelete + ", isUrgent=" + isUrgent + ", priorityLevel=" + priorityLevel
				+ ", orignMethod=" + orignMethod + ", localmapStatus=" + localmapStatus + "]";
	}
	
	
	

}
