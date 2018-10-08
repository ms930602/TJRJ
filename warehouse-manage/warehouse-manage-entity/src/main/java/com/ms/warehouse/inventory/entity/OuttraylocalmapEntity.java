
package com.ms.warehouse.inventory.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

import java.math.BigDecimal;

/**
 * 出库单托盘货位对照关系
 * @author dwf
 * @Date 2018-08-24 15:13:51
 * @since 1.0
 */
@TableName("t_ware_outtraylocalmap")
public class OuttraylocalmapEntity extends BaseEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 自增id. */
	private Long id;

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

	/** 状态0出库中1出库完成2已标记. */
	private Long status;

	/** 批次号. */
	private String batchNo;

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

	/** 唯一码. */
	private String soleCode;

	/** 托盘编号. */
	private String trayCode;

	/** 出库方式0件烟1整托盘. */
	private Long wareMethod;

	/** 货位id. */
	private Long localId;

	/** 物料编号. */
	private String materCode;

	/** 出库区域：0正常区出库1暂存区出库. */
	private Long wareArea;

	/** 卷烟类型：0正式卷烟1福样促试. */
	private Long cigtype;

	/** 子版本ID. */
	private Long subverId;

	/** 子版本名称. */
	private String subverName;

	/** 是否删除0否1是. */
	private Integer isDelete;

	/**
	 * 被调整出库货位的唯一码
	 */
	private String oldsoleCode;


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

	/** 是否紧急出库 0否 1是. */
	private Integer isUrgent;

	/** 出库优先级，1为最高优先级. */
	private Long priorityLevel;

	/** 订单来源方式：1物流系统 2手动录入. */
	private Long orignMethod;
	/** 楼层编号. */
	private String floorCode;


	/** 货位标签状态. */
	private Long locallStatus;
	/** 托盘标签状态. */
	private Long trayStatus;
	/**
	 * 货位描述
     */
	private String descript;

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public Long getLocallStatus() {
		return locallStatus;
	}

	public void setLocallStatus(Long locallStatus) {
		this.locallStatus = locallStatus;
	}

	public Long getTrayStatus() {
		return trayStatus;
	}

	public void setTrayStatus(Long trayStatus) {
		this.trayStatus = trayStatus;
	}

	public String getFloorCode() {
		return floorCode;
	}

	public void setFloorCode(String floorCode) {
		this.floorCode = floorCode;
	}

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

	public void setOldsoleCode(String oldsoleCode) {
		this.oldsoleCode = oldsoleCode;
	}

	public String getOldsoleCode() {
		return oldsoleCode;
	}

	/**
	 *批次预出库量
	 */
	private BigDecimal calculateoutoquality;

	public void setCalculateoutoquality(BigDecimal calculateoutoquality) {
		this.calculateoutoquality = calculateoutoquality;
	}

	public BigDecimal getCalculateoutoquality() {
		return calculateoutoquality;
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


	/** set 出库单详情id. */
	public void setOrderdetailId(Long orderdetailId) {
		this.orderdetailId = orderdetailId;
	}

	/** get 出库单详情id. */
	public Long getOrderdetailId() {
		return this.orderdetailId;
	}

	@JsonIgnore
	public Long getOrderdetailIdByLike() {
		return this.orderdetailId;
	}


	/** set 领取人id. */
	public void setReceivorId(Long receivorId) {
		this.receivorId = receivorId;
	}

	/** get 领取人id. */
	public Long getReceivorId() {
		return this.receivorId;
	}

	@JsonIgnore
	public Long getReceivorIdByLike() {
		return this.receivorId;
	}


	/** set 领取人账号. */
	public void setReceivorName(String receivorName) {
		this.receivorName = receivorName;
	}

	/** get 领取人账号. */
	public String getReceivorName() {
		return this.receivorName;
	}

	@JsonIgnore
	public String getReceivorNameByLike() {
		return "%"+this.receivorName+"%";
	}


	/** set 领取时间. */
	public void setReceiveDate(java.util.Date receiveDate) {
		this.receiveDate = receiveDate;
	}

	/** get 领取时间. */
	public java.util.Date getReceiveDate() {
		return this.receiveDate;
	}

	@JsonIgnore
	public java.util.Date getReceiveDateByLike() {
		return this.receiveDate;
	}


	/** set 托盘件烟数量. */
	public void setCigsmokeQuality(java.math.BigDecimal cigsmokeQuality) {
		this.cigsmokeQuality = cigsmokeQuality;
	}

	/** get 托盘件烟数量. */
	public java.math.BigDecimal getCigsmokeQuality() {
		return this.cigsmokeQuality;
	}

	@JsonIgnore
	public java.math.BigDecimal getCigsmokeQualityByLike() {
		return this.cigsmokeQuality;
	}


	/** set 实出数量. */
	public void setRealoutQuality(java.math.BigDecimal realoutQuality) {
		this.realoutQuality = realoutQuality;
	}

	/** get 实出数量. */
	public java.math.BigDecimal getRealoutQuality() {
		return this.realoutQuality;
	}

	@JsonIgnore
	public java.math.BigDecimal getRealoutQualityByLike() {
		return this.realoutQuality;
	}


	/** set 托盘rfid编号. */
	public void setTrayRfid(String trayRfid) {
		this.trayRfid = trayRfid;
	}

	/** get 托盘rfid编号. */
	public String getTrayRfid() {
		return this.trayRfid;
	}

	@JsonIgnore
	public String getTrayRfidByLike() {
		return "%"+this.trayRfid+"%";
	}


	/** set 货位编码. */
	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}

	/** get 货位编码. */
	public String getLocalCode() {
		return this.localCode;
	}

	@JsonIgnore
	public String getLocalCodeByLike() {
		return "%"+this.localCode+"%";
	}


	/** set 货位rfid编号. */
	public void setLocalRfid(String localRfid) {
		this.localRfid = localRfid;
	}

	/** get 货位rfid编号. */
	public String getLocalRfid() {
		return this.localRfid;
	}

	@JsonIgnore
	public String getLocalRfidByLike() {
		return "%"+this.localRfid+"%";
	}


	/** set 状态0出库中1出库完成2已标记. */
	public void setStatus(Long status) {
		this.status = status;
	}

	/** get 状态0出库中1出库完成2已标记. */
	public Long getStatus() {
		return this.status;
	}

	@JsonIgnore
	public Long getStatusByLike() {
		return this.status;
	}


	/** set 批次号. */
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	/** get 批次号. */
	public String getBatchNo() {
		return this.batchNo;
	}

	@JsonIgnore
	public String getBatchNoByLike() {
		return "%"+this.batchNo+"%";
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


	/** set 唯一码. */
	public void setSoleCode(String soleCode) {
		this.soleCode = soleCode;
	}

	/** get 唯一码. */
	public String getSoleCode() {
		return this.soleCode;
	}

	@JsonIgnore
	public String getSoleCodeByLike() {
		return "%"+this.soleCode+"%";
	}


	/** set 托盘编号. */
	public void setTrayCode(String trayCode) {
		this.trayCode = trayCode;
	}

	/** get 托盘编号. */
	public String getTrayCode() {
		return this.trayCode;
	}

	@JsonIgnore
	public String getTrayCodeByLike() {
		return "%"+this.trayCode+"%";
	}


	/** set 出库方式0件烟1整托盘. */
	public void setWareMethod(Long wareMethod) {
		this.wareMethod = wareMethod;
	}

	/** get 出库方式0件烟1整托盘. */
	public Long getWareMethod() {
		return this.wareMethod;
	}

	@JsonIgnore
	public Long getWareMethodByLike() {
		return this.wareMethod;
	}


	/** set 货位id. */
	public void setLocalId(Long localId) {
		this.localId = localId;
	}

	/** get 货位id. */
	public Long getLocalId() {
		return this.localId;
	}

	@JsonIgnore
	public Long getLocalIdByLike() {
		return this.localId;
	}


	/** set 物料编号. */
	public void setMaterCode(String materCode) {
		this.materCode = materCode;
	}

	/** get 物料编号. */
	public String getMaterCode() {
		return this.materCode;
	}

	@JsonIgnore
	public String getMaterCodeByLike() {
		return "%"+this.materCode+"%";
	}


	/** set 出库区域：0正常区出库1暂存区出库. */
	public void setWareArea(Long wareArea) {
		this.wareArea = wareArea;
	}

	/** get 出库区域：0正常区出库1暂存区出库. */
	public Long getWareArea() {
		return this.wareArea;
	}

	@JsonIgnore
	public Long getWareAreaByLike() {
		return this.wareArea;
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
	public OuttraylocalmapEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param orderdetailId			出库单详情id
	 * @param receivorId			领取人id
	 * @param receivorName			领取人账号
	 * @param receiveDate			领取时间
	 * @param cigsmokeQuality			托盘件烟数量
	 * @param realoutQuality			实出数量
	 * @param trayRfid			托盘rfid编号
	 * @param localCode			货位编码
	 * @param localRfid			货位rfid编号
	 * @param status			状态0出库中1出库完成2已标记
	 * @param batchNo			批次号
	 * @param createdDate			创建时间
	 * @param createdPersonId			创建人id
	 * @param createdPerson			创建人
	 * @param updatedDate			更新时间
	 * @param updatedPersonId			更新人id
	 * @param updatedPerson			修改人
	 * @param soleCode			唯一码
	 * @param trayCode			托盘编号
	 * @param wareMethod			出库方式0件烟1整托盘
	 * @param localId			货位id
	 * @param materCode			物料编号
	 * @param wareArea			出库区域：0正常区出库1暂存区出库
	 * @param cigtype			卷烟类型：0正式卷烟1福样促试
	 * @param subverId			子版本ID
	 * @param subverName			子版本名称
	 * @param isDelete			是否删除0否1是
	 */
	public OuttraylocalmapEntity(Long orderdetailId,Long receivorId,String receivorName,java.util.Date receiveDate,java.math.BigDecimal cigsmokeQuality,java.math.BigDecimal realoutQuality,String trayRfid,String localCode,String localRfid,Long status,String batchNo,java.util.Date createdDate,Long createdPersonId,String createdPerson,java.util.Date updatedDate,Long updatedPersonId,String updatedPerson,String soleCode,String trayCode,Long wareMethod,Long localId,String materCode,Long wareArea,Long cigtype,Long subverId,String subverName,Integer isDelete){
		this();
		this.orderdetailId = orderdetailId;
		this.receivorId = receivorId;
		this.receivorName = receivorName;
		this.receiveDate = receiveDate;
		this.cigsmokeQuality = cigsmokeQuality;
		this.realoutQuality = realoutQuality;
		this.trayRfid = trayRfid;
		this.localCode = localCode;
		this.localRfid = localRfid;
		this.status = status;
		this.batchNo = batchNo;
		this.createdDate = createdDate;
		this.createdPersonId = createdPersonId;
		this.createdPerson = createdPerson;
		this.updatedDate = updatedDate;
		this.updatedPersonId = updatedPersonId;
		this.updatedPerson = updatedPerson;
		this.soleCode = soleCode;
		this.trayCode = trayCode;
		this.wareMethod = wareMethod;
		this.localId = localId;
		this.materCode = materCode;
		this.wareArea = wareArea;
		this.cigtype = cigtype;
		this.subverId = subverId;
		this.subverName = subverName;
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return new StringBuilder().append("OuttraylocalmapEntity[")
				.append("Id=").append(getId()).append(", ")
				.append("OrderdetailId=").append(getOrderdetailId()).append(", ")
				.append("ReceivorId=").append(getReceivorId()).append(", ")
				.append("ReceivorName=").append(getReceivorName()).append(", ")
				.append("ReceiveDate=").append(getReceiveDate()).append(", ")
				.append("CigsmokeQuality=").append(getCigsmokeQuality()).append(", ")
				.append("RealoutQuality=").append(getRealoutQuality()).append(", ")
				.append("TrayRfid=").append(getTrayRfid()).append(", ")
				.append("LocalCode=").append(getLocalCode()).append(", ")
				.append("LocalRfid=").append(getLocalRfid()).append(", ")
				.append("Status=").append(getStatus()).append(", ")
				.append("BatchNo=").append(getBatchNo()).append(", ")
				.append("CreatedDate=").append(getCreatedDate()).append(", ")
				.append("CreatedPersonId=").append(getCreatedPersonId()).append(", ")
				.append("CreatedPerson=").append(getCreatedPerson()).append(", ")
				.append("UpdatedDate=").append(getUpdatedDate()).append(", ")
				.append("UpdatedPersonId=").append(getUpdatedPersonId()).append(", ")
				.append("UpdatedPerson=").append(getUpdatedPerson()).append(", ")
				.append("SoleCode=").append(getSoleCode()).append(", ")
				.append("TrayCode=").append(getTrayCode()).append(", ")
				.append("WareMethod=").append(getWareMethod()).append(", ")
				.append("LocalId=").append(getLocalId()).append(", ")
				.append("MaterCode=").append(getMaterCode()).append(", ")
				.append("WareArea=").append(getWareArea()).append(", ")
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
		if(obj instanceof OuttraylocalmapEntity == false)
			return false;
		if(this == obj)
			return true;
		OuttraylocalmapEntity other = (OuttraylocalmapEntity)obj;

		return this.toString().equals(other.toString());
	}
}
