
package com.ms.warehouse.inventory.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 出库单主
 * @author dwf
 * @Date 2018-08-14 14:47:45
 * @since 1.0
 */
@TableName("t_ware_outmainorder")
public class OutmainorderEntity extends BaseEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 自增id. */
	private Long id;

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

	/** 状态0草稿1已确认2出库中3已完成. */
	private Long status;

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


	/** 出库单详情id. */
	private Long orderdetailId;

	/** 领取人id. */
	private Long receivorId;

	/** 领取人账号. */
	private String receivorName;

	/** 领取时间. */
	private java.util.Date receiveDate;

	/** 托盘件烟数量. */
	private java.math.BigDecimal cigsmokeQuality;

	/** 实出数量. */
	private java.math.BigDecimal realoutQuality;

	/** 托盘rfid编号. */
	private String trayRfid;

	/** 货位编码. */
	private String localCode;

	/** 货位rfid编号. */
	private String localRfid;

	/** 状态0出库中1出库完成. */
	private Long localmapStatus;

	/** 批次号. */
	private String batchNo;


	/** 唯一码. */
	private String soleCode;

	/** 托盘编号. */
	private String trayCode;

	/** 出库方式0件烟1整托盘. */
	private Long wareMethod;

	/** 货位id. */
	private Long localId;


	/** 出库区域：0正常区出库1暂存区出库. */
	private Long wareArea;

	/** 卷烟类型：0正式卷烟1福样促试. */
	private Long cigtype;

	/**
	 * 被调整出库货位的唯一码
	 */
	private String oldsoleCode;
	
	


	public Long getOrderdetailId() {
		return orderdetailId;
	}

	public void setOrderdetailId(Long orderdetailId) {
		this.orderdetailId = orderdetailId;
	}

	public Long getReceivorId() {
		return receivorId;
	}

	public void setReceivorId(Long receivorId) {
		this.receivorId = receivorId;
	}

	public String getReceivorName() {
		return receivorName;
	}

	public void setReceivorName(String receivorName) {
		this.receivorName = receivorName;
	}

	public java.util.Date getReceiveDate() {
		return receiveDate;
	}

	public void setReceiveDate(java.util.Date receiveDate) {
		this.receiveDate = receiveDate;
	}

	public java.math.BigDecimal getCigsmokeQuality() {
		return cigsmokeQuality;
	}

	public void setCigsmokeQuality(java.math.BigDecimal cigsmokeQuality) {
		this.cigsmokeQuality = cigsmokeQuality;
	}

	public java.math.BigDecimal getRealoutQuality() {
		return realoutQuality;
	}

	public void setRealoutQuality(java.math.BigDecimal realoutQuality) {
		this.realoutQuality = realoutQuality;
	}

	public String getTrayRfid() {
		return trayRfid;
	}

	public void setTrayRfid(String trayRfid) {
		this.trayRfid = trayRfid;
	}

	public String getLocalCode() {
		return localCode;
	}

	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}

	public String getLocalRfid() {
		return localRfid;
	}

	public void setLocalRfid(String localRfid) {
		this.localRfid = localRfid;
	}

	public Long getLocalmapStatus() {
		return localmapStatus;
	}

	public void setLocalmapStatus(Long localmapStatus) {
		this.localmapStatus = localmapStatus;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getSoleCode() {
		return soleCode;
	}

	public void setSoleCode(String soleCode) {
		this.soleCode = soleCode;
	}

	public String getTrayCode() {
		return trayCode;
	}

	public void setTrayCode(String trayCode) {
		this.trayCode = trayCode;
	}

	public Long getWareMethod() {
		return wareMethod;
	}

	public void setWareMethod(Long wareMethod) {
		this.wareMethod = wareMethod;
	}

	public Long getLocalId() {
		return localId;
	}

	public void setLocalId(Long localId) {
		this.localId = localId;
	}

	public Long getWareArea() {
		return wareArea;
	}

	public void setWareArea(Long wareArea) {
		this.wareArea = wareArea;
	}

	public Long getCigtype() {
		return cigtype;
	}

	public void setCigtype(Long cigtype) {
		this.cigtype = cigtype;
	}

	public String getOldsoleCode() {
		return oldsoleCode;
	}

	public void setOldsoleCode(String oldsoleCode) {
		this.oldsoleCode = oldsoleCode;
	}

	public String getMaterCode() {
		return materCode;
	}

	public void setMaterCode(String materCode) {
		this.materCode = materCode;
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


	/** set 订单编号. */
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	/** get 订单编号. */
	public String getOrderNumber() {
		return this.orderNumber;
	}

	@JsonIgnore
	public String getOrderNumberByLike() {
		return "%"+this.orderNumber+"%";
	}


	/** set 物流单号，来源单号. */
	public void setShipmentNumber(String shipmentNumber) {
		this.shipmentNumber = shipmentNumber;
	}

	/** get 物流单号，来源单号. */
	public String getShipmentNumber() {
		return this.shipmentNumber;
	}

	@JsonIgnore
	public String getShipmentNumberByLike() {
		return "%"+this.shipmentNumber+"%";
	}


	/** set 制单日期. */
	public void setShipmentDate(java.util.Date shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	/** get 制单日期. */
	public java.util.Date getShipmentDate() {
		return this.shipmentDate;
	}

	@JsonIgnore
	public java.util.Date getShipmentDateByLike() {
		return this.shipmentDate;
	}


	/** set 车牌号. */
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	/** get 车牌号. */
	public String getPlateNumber() {
		return this.plateNumber;
	}

	@JsonIgnore
	public String getPlateNumberByLike() {
		return "%"+this.plateNumber+"%";
	}


	/** set 总量（件）. */
	public void setTotalQuality(java.math.BigDecimal totalQuality) {
		this.totalQuality = totalQuality;
	}

	/** get 总量（件）. */
	public java.math.BigDecimal getTotalQuality() {
		return this.totalQuality;
	}

	@JsonIgnore
	public java.math.BigDecimal getTotalQualityByLike() {
		return this.totalQuality;
	}


	/** set 发货日期. */
	public void setDeliveryDate(java.util.Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	/** get 发货日期. */
	public java.util.Date getDeliveryDate() {
		return this.deliveryDate;
	}

	@JsonIgnore
	public java.util.Date getDeliveryDateByLike() {
		return this.deliveryDate;
	}


	/** set 运输方式. */
	public void setTransportType(String transportType) {
		this.transportType = transportType;
	}

	/** get 运输方式. */
	public String getTransportType() {
		return this.transportType;
	}

	@JsonIgnore
	public String getTransportTypeByLike() {
		return "%"+this.transportType+"%";
	}


	/** set 承运人. */
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	/** get 承运人. */
	public String getCarrier() {
		return this.carrier;
	}

	@JsonIgnore
	public String getCarrierByLike() {
		return "%"+this.carrier+"%";
	}


	/** set 联系电话. */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/** get 联系电话. */
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	@JsonIgnore
	public String getPhoneNumberByLike() {
		return "%"+this.phoneNumber+"%";
	}


	/** set 承运单位. */
	public void setCarrierUnit(String carrierUnit) {
		this.carrierUnit = carrierUnit;
	}

	/** get 承运单位. */
	public String getCarrierUnit() {
		return this.carrierUnit;
	}

	@JsonIgnore
	public String getCarrierUnitByLike() {
		return "%"+this.carrierUnit+"%";
	}


	/** set 承运单位编码. */
	public void setCarrierUnitCode(String carrierUnitCode) {
		this.carrierUnitCode = carrierUnitCode;
	}

	/** get 承运单位编码. */
	public String getCarrierUnitCode() {
		return this.carrierUnitCode;
	}

	@JsonIgnore
	public String getCarrierUnitCodeByLike() {
		return "%"+this.carrierUnitCode+"%";
	}


	/** set 预约装车日期. */
	public void setReservationDate(java.util.Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	/** get 预约装车日期. */
	public java.util.Date getReservationDate() {
		return this.reservationDate;
	}

	@JsonIgnore
	public java.util.Date getReservationDateByLike() {
		return this.reservationDate;
	}


	/** set 物流单备注. */
	public void setShipmentRemark(String shipmentRemark) {
		this.shipmentRemark = shipmentRemark;
	}

	/** get 物流单备注. */
	public String getShipmentRemark() {
		return this.shipmentRemark;
	}

	@JsonIgnore
	public String getShipmentRemarkByLike() {
		return "%"+this.shipmentRemark+"%";
	}


	/** set 合同号. */
	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}

	/** get 合同号. */
	public String getContractNumber() {
		return this.contractNumber;
	}

	@JsonIgnore
	public String getContractNumberByLike() {
		return "%"+this.contractNumber+"%";
	}


	/** set 合同日期. */
	public void setContractDate(java.util.Date contractDate) {
		this.contractDate = contractDate;
	}

	/** get 合同日期. */
	public java.util.Date getContractDate() {
		return this.contractDate;
	}

	@JsonIgnore
	public java.util.Date getContractDateByLike() {
		return this.contractDate;
	}


	/** set 出库仓库编码. */
	public void setOutboundWareCode(String outboundWareCode) {
		this.outboundWareCode = outboundWareCode;
	}

	/** get 出库仓库编码. */
	public String getOutboundWareCode() {
		return this.outboundWareCode;
	}

	@JsonIgnore
	public String getOutboundWareCodeByLike() {
		return "%"+this.outboundWareCode+"%";
	}


	/** set 出库仓库名称. */
	public void setOutboundWare(String outboundWare) {
		this.outboundWare = outboundWare;
	}

	/** get 出库仓库名称. */
	public String getOutboundWare() {
		return this.outboundWare;
	}

	@JsonIgnore
	public String getOutboundWareByLike() {
		return "%"+this.outboundWare+"%";
	}


	/** set 到货仓库编码. */
	public void setArrivalWareCode(String arrivalWareCode) {
		this.arrivalWareCode = arrivalWareCode;
	}

	/** get 到货仓库编码. */
	public String getArrivalWareCode() {
		return this.arrivalWareCode;
	}

	@JsonIgnore
	public String getArrivalWareCodeByLike() {
		return "%"+this.arrivalWareCode+"%";
	}


	/** set 到货仓库名称. */
	public void setArrivalWare(String arrivalWare) {
		this.arrivalWare = arrivalWare;
	}

	/** get 到货仓库名称. */
	public String getArrivalWare() {
		return this.arrivalWare;
	}

	@JsonIgnore
	public String getArrivalWareByLike() {
		return "%"+this.arrivalWare+"%";
	}


	/** set 要求到货时间. */
	public void setArrivalRequire(String arrivalRequire) {
		this.arrivalRequire = arrivalRequire;
	}

	/** get 要求到货时间. */
	public String getArrivalRequire() {
		return this.arrivalRequire;
	}

	@JsonIgnore
	public String getArrivalRequireByLike() {
		return "%"+this.arrivalRequire+"%";
	}


	/** set 发货要求. */
	public void setDeliveryRequire(String deliveryRequire) {
		this.deliveryRequire = deliveryRequire;
	}

	/** get 发货要求. */
	public String getDeliveryRequire() {
		return this.deliveryRequire;
	}

	@JsonIgnore
	public String getDeliveryRequireByLike() {
		return "%"+this.deliveryRequire+"%";
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


	/** set 出库完成时间. */
	public void setOutCompliteDate(java.util.Date outCompliteDate) {
		this.outCompliteDate = outCompliteDate;
	}

	/** get 出库完成时间. */
	public java.util.Date getOutCompliteDate() {
		return this.outCompliteDate;
	}

	@JsonIgnore
	public java.util.Date getOutCompliteDateByLike() {
		return this.outCompliteDate;
	}


	/** set 状态0草稿1已确认2出库中3已完成. */
	public void setStatus(Long status) {
		this.status = status;
	}

	/** get 状态0草稿1已确认2出库中3已完成. */
	public Long getStatus() {
		return this.status;
	}

	@JsonIgnore
	public Long getStatusByLike() {
		return this.status;
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


	/** set 发货单位编码. */
	public void setForwardUnitCode(String forwardUnitCode) {
		this.forwardUnitCode = forwardUnitCode;
	}

	/** get 发货单位编码. */
	public String getForwardUnitCode() {
		return this.forwardUnitCode;
	}

	@JsonIgnore
	public String getForwardUnitCodeByLike() {
		return "%"+this.forwardUnitCode+"%";
	}


	/** set 发货单位名称. */
	public void setForwardUnit(String forwardUnit) {
		this.forwardUnit = forwardUnit;
	}

	/** get 发货单位名称. */
	public String getForwardUnit() {
		return this.forwardUnit;
	}

	@JsonIgnore
	public String getForwardUnitByLike() {
		return "%"+this.forwardUnit+"%";
	}


	/** set 购货单位编码. */
	public void setPurchaseUnitCode(String purchaseUnitCode) {
		this.purchaseUnitCode = purchaseUnitCode;
	}

	/** get 购货单位编码. */
	public String getPurchaseUnitCode() {
		return this.purchaseUnitCode;
	}

	@JsonIgnore
	public String getPurchaseUnitCodeByLike() {
		return "%"+this.purchaseUnitCode+"%";
	}


	/** set 购货单位名称. */
	public void setPurchaseUnit(String purchaseUnit) {
		this.purchaseUnit = purchaseUnit;
	}

	/** get 购货单位名称. */
	public String getPurchaseUnit() {
		return this.purchaseUnit;
	}

	@JsonIgnore
	public String getPurchaseUnitByLike() {
		return "%"+this.purchaseUnit+"%";
	}


	/** set nc仓库编吗. */
	public void setNcWareCode(String ncWareCode) {
		this.ncWareCode = ncWareCode;
	}

	/** get nc仓库编吗. */
	public String getNcWareCode() {
		return this.ncWareCode;
	}

	@JsonIgnore
	public String getNcWareCodeByLike() {
		return "%"+this.ncWareCode+"%";
	}


	/** set nc仓库名称. */
	public void setNcWare(String ncWare) {
		this.ncWare = ncWare;
	}

	/** get nc仓库名称. */
	public String getNcWare() {
		return this.ncWare;
	}

	@JsonIgnore
	public String getNcWareByLike() {
		return "%"+this.ncWare+"%";
	}


	/** set 出库通道编号. */
	public void setOutchanCode(String outchanCode) {
		this.outchanCode = outchanCode;
	}

	/** get 出库通道编号. */
	public String getOutchanCode() {
		return this.outchanCode;
	}

	@JsonIgnore
	public String getOutchanCodeByLike() {
		return "%"+this.outchanCode+"%";
	}


	/** set 开始装车时间. */
	public void setLoadDate(java.util.Date loadDate) {
		this.loadDate = loadDate;
	}

	/** get 开始装车时间. */
	public java.util.Date getLoadDate() {
		return this.loadDate;
	}

	@JsonIgnore
	public java.util.Date getLoadDateByLike() {
		return this.loadDate;
	}


	/** set 运输方式编码. */
	public void setTransportCode(String transportCode) {
		this.transportCode = transportCode;
	}

	/** get 运输方式编码. */
	public String getTransportCode() {
		return this.transportCode;
	}

	@JsonIgnore
	public String getTransportCodeByLike() {
		return "%"+this.transportCode+"%";
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


	/** set 是否紧急出库 0否 1是. */
	public void setIsUrgent(Integer isUrgent) {
		this.isUrgent = isUrgent;
	}

	/** get 是否紧急出库 0否 1是. */
	public Integer getIsUrgent() {
		return this.isUrgent;
	}

	@JsonIgnore
	public Integer getIsUrgentByLike() {
		return this.isUrgent;
	}


	/** set 出库优先级，1为最高优先级. */
	public void setPriorityLevel(Long priorityLevel) {
		this.priorityLevel = priorityLevel;
	}

	/** get 出库优先级，1为最高优先级. */
	public Long getPriorityLevel() {
		return this.priorityLevel;
	}

	@JsonIgnore
	public Long getPriorityLevelByLike() {
		return this.priorityLevel;
	}


	/** set 订单来源方式：1物流系统 2手动录入. */
	public void setOrignMethod(Long orignMethod) {
		this.orignMethod = orignMethod;
	}

	/** get 订单来源方式：1物流系统 2手动录入. */
	public Long getOrignMethod() {
		return this.orignMethod;
	}

	@JsonIgnore
	public Long getOrignMethodByLike() {
		return this.orignMethod;
	}

	/** constructor */
	public OutmainorderEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param orderNumber			订单编号
	 * @param shipmentNumber			物流单号，来源单号
	 * @param shipmentDate			制单日期
	 * @param plateNumber			车牌号
	 * @param totalQuality			总量（件）
	 * @param deliveryDate			发货日期
	 * @param transportType			运输方式
	 * @param carrier			承运人
	 * @param phoneNumber			联系电话
	 * @param carrierUnit			承运单位
	 * @param carrierUnitCode			承运单位编码
	 * @param reservationDate			预约装车日期
	 * @param shipmentRemark			物流单备注
	 * @param contractNumber			合同号
	 * @param contractDate			合同日期
	 * @param outboundWareCode			出库仓库编码
	 * @param outboundWare			出库仓库名称
	 * @param arrivalWareCode			到货仓库编码
	 * @param arrivalWare			到货仓库名称
	 * @param arrivalRequire			要求到货时间
	 * @param deliveryRequire			发货要求
	 * @param remark			备注
	 * @param outCompliteDate			出库完成时间
	 * @param status			状态0草稿1已确认2出库中3已完成
	 * @param createdDate			创建时间
	 * @param createdPersonId			创建人id
	 * @param createdPerson			创建人
	 * @param updatedDate			更新时间
	 * @param updatedPersonId			更新人id
	 * @param updatedPerson			修改人
	 * @param forwardUnitCode			发货单位编码
	 * @param forwardUnit			发货单位名称
	 * @param purchaseUnitCode			购货单位编码
	 * @param purchaseUnit			购货单位名称
	 * @param ncWareCode			nc仓库编吗
	 * @param ncWare			nc仓库名称
	 * @param outchanCode			出库通道编号
	 * @param loadDate			开始装车时间
	 * @param transportCode			运输方式编码
	 * @param isDelete			是否删除0否1是
	 * @param isUrgent			是否紧急出库 0否 1是
	 * @param priorityLevel			出库优先级，1为最高优先级
	 * @param orignMethod			订单来源方式：1物流系统 2手动录入
	 */
	public OutmainorderEntity(String orderNumber,String shipmentNumber,java.util.Date shipmentDate,String plateNumber,java.math.BigDecimal totalQuality,java.util.Date deliveryDate,String transportType,String carrier,String phoneNumber,String carrierUnit,String carrierUnitCode,java.util.Date reservationDate,String shipmentRemark,String contractNumber,java.util.Date contractDate,String outboundWareCode,String outboundWare,String arrivalWareCode,String arrivalWare,String arrivalRequire,String deliveryRequire,String remark,java.util.Date outCompliteDate,Long status,java.util.Date createdDate,Long createdPersonId,String createdPerson,java.util.Date updatedDate,Long updatedPersonId,String updatedPerson,String forwardUnitCode,String forwardUnit,String purchaseUnitCode,String purchaseUnit,String ncWareCode,String ncWare,String outchanCode,java.util.Date loadDate,String transportCode,Integer isDelete,Integer isUrgent,Long priorityLevel,Long orignMethod){
		this();
		this.orderNumber = orderNumber;
		this.shipmentNumber = shipmentNumber;
		this.shipmentDate = shipmentDate;
		this.plateNumber = plateNumber;
		this.totalQuality = totalQuality;
		this.deliveryDate = deliveryDate;
		this.transportType = transportType;
		this.carrier = carrier;
		this.phoneNumber = phoneNumber;
		this.carrierUnit = carrierUnit;
		this.carrierUnitCode = carrierUnitCode;
		this.reservationDate = reservationDate;
		this.shipmentRemark = shipmentRemark;
		this.contractNumber = contractNumber;
		this.contractDate = contractDate;
		this.outboundWareCode = outboundWareCode;
		this.outboundWare = outboundWare;
		this.arrivalWareCode = arrivalWareCode;
		this.arrivalWare = arrivalWare;
		this.arrivalRequire = arrivalRequire;
		this.deliveryRequire = deliveryRequire;
		this.remark = remark;
		this.outCompliteDate = outCompliteDate;
		this.status = status;
		this.createdDate = createdDate;
		this.createdPersonId = createdPersonId;
		this.createdPerson = createdPerson;
		this.updatedDate = updatedDate;
		this.updatedPersonId = updatedPersonId;
		this.updatedPerson = updatedPerson;
		this.forwardUnitCode = forwardUnitCode;
		this.forwardUnit = forwardUnit;
		this.purchaseUnitCode = purchaseUnitCode;
		this.purchaseUnit = purchaseUnit;
		this.ncWareCode = ncWareCode;
		this.ncWare = ncWare;
		this.outchanCode = outchanCode;
		this.loadDate = loadDate;
		this.transportCode = transportCode;
		this.isDelete = isDelete;
		this.isUrgent = isUrgent;
		this.priorityLevel = priorityLevel;
		this.orignMethod = orignMethod;
	}

	@Override
	public String toString() {
		return new StringBuilder().append("OutmainorderEntity[")
				.append("Id=").append(getId()).append(", ")
				.append("OrderNumber=").append(getOrderNumber()).append(", ")
				.append("ShipmentNumber=").append(getShipmentNumber()).append(", ")
				.append("ShipmentDate=").append(getShipmentDate()).append(", ")
				.append("PlateNumber=").append(getPlateNumber()).append(", ")
				.append("TotalQuality=").append(getTotalQuality()).append(", ")
				.append("DeliveryDate=").append(getDeliveryDate()).append(", ")
				.append("TransportType=").append(getTransportType()).append(", ")
				.append("Carrier=").append(getCarrier()).append(", ")
				.append("PhoneNumber=").append(getPhoneNumber()).append(", ")
				.append("CarrierUnit=").append(getCarrierUnit()).append(", ")
				.append("CarrierUnitCode=").append(getCarrierUnitCode()).append(", ")
				.append("ReservationDate=").append(getReservationDate()).append(", ")
				.append("ShipmentRemark=").append(getShipmentRemark()).append(", ")
				.append("ContractNumber=").append(getContractNumber()).append(", ")
				.append("ContractDate=").append(getContractDate()).append(", ")
				.append("OutboundWareCode=").append(getOutboundWareCode()).append(", ")
				.append("OutboundWare=").append(getOutboundWare()).append(", ")
				.append("ArrivalWareCode=").append(getArrivalWareCode()).append(", ")
				.append("ArrivalWare=").append(getArrivalWare()).append(", ")
				.append("ArrivalRequire=").append(getArrivalRequire()).append(", ")
				.append("DeliveryRequire=").append(getDeliveryRequire()).append(", ")
				.append("Remark=").append(getRemark()).append(", ")
				.append("OutCompliteDate=").append(getOutCompliteDate()).append(", ")
				.append("Status=").append(getStatus()).append(", ")
				.append("CreatedDate=").append(getCreatedDate()).append(", ")
				.append("CreatedPersonId=").append(getCreatedPersonId()).append(", ")
				.append("CreatedPerson=").append(getCreatedPerson()).append(", ")
				.append("UpdatedDate=").append(getUpdatedDate()).append(", ")
				.append("UpdatedPersonId=").append(getUpdatedPersonId()).append(", ")
				.append("UpdatedPerson=").append(getUpdatedPerson()).append(", ")
				.append("ForwardUnitCode=").append(getForwardUnitCode()).append(", ")
				.append("ForwardUnit=").append(getForwardUnit()).append(", ")
				.append("PurchaseUnitCode=").append(getPurchaseUnitCode()).append(", ")
				.append("PurchaseUnit=").append(getPurchaseUnit()).append(", ")
				.append("NcWareCode=").append(getNcWareCode()).append(", ")
				.append("NcWare=").append(getNcWare()).append(", ")
				.append("OutchanCode=").append(getOutchanCode()).append(", ")
				.append("LoadDate=").append(getLoadDate()).append(", ")
				.append("TransportCode=").append(getTransportCode()).append(", ")
				.append("IsDelete=").append(getIsDelete()).append(", ")
				.append("IsUrgent=").append(getIsUrgent()).append(", ")
				.append("PriorityLevel=").append(getPriorityLevel()).append(", ")
				.append("OrignMethod=").append(getOrignMethod())
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
		if(obj instanceof OutmainorderEntity == false)
			return false;
		if(this == obj)
			return true;
		OutmainorderEntity other = (OutmainorderEntity)obj;

		return this.toString().equals(other.toString());
	}
}
