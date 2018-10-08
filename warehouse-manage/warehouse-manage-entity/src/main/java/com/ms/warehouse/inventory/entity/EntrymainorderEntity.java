
package com.ms.warehouse.inventory.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 入库单主
 * @author dwf
 * @Date 2018-07-31 13:12:09
 * @since 1.0
 */
@TableName("t_ware_entrymainorder")
public class EntrymainorderEntity extends BaseEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 自增id. */
	private Long id;

	/** 入库订单编号. */
	private String orderNumber;

	/** 物流单号. */
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

	/** 移出仓库编码. */
	private String originWarehouseCode;

	/** 移出仓库名称. */
	private String originWarehouseName;

	/** 移入仓库编码. */
	private String intoWarehouseCode;

	/** 移入仓库名称. */
	private String intoWarehouseName;

	/** 发货要求. */
	private String deliveryRequire;

	/** 备注. */
	private String remark;

	/** 入库完成时间. */
	private java.util.Date entryCompliteDate;

	/** 状态0草稿1已确认2入库中3已完成. */
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

	/** 入库通道编号. */
	private String entryChannelCode;

	/** 运输方式编码. */
	private String transportCode;

	/** 是否删除0否1是. */
	private Integer isDelete;

	/** 订单来源方式：1物流系统 2手动录入. */
	private Long orignMethod;


	/** 物料编码、条码. */
	private String materCode;

	/** 物料名称. */
	private String materName;

	/** 数量件. */
	private java.math.BigDecimal quality;

	/** 批次号. */
	private String batchNo;

	/** 版本. */
	private String materVersion;

	/** 品牌. */
	private String materCigbrand;

	/** 实际入库数量. */
	private java.math.BigDecimal actualQuality;

	/** 生产日期. */
	private java.util.Date produceDate;
	
	/** 子版本ID. */
	private Long subverId;
	
	/** 子版本名称. */
	private String subverName;
	

	/** 入库单详情id. */
	private Long orderdetailId;
	
	/** 托盘件烟数量. */
	private java.math.BigDecimal cigsmokeQuality;
	
	/** 托盘rfid编号. */
	private String trayRfid;
	
	/** 货位id. */
	private Long localId;
	
	/** 货位编码. */
	private String localCode;
	
	/** 货位rfid编号. */
	private String localRfid;
	
	/** 状态0 入库中1入库完成. */
	private Long trayStatus;
	
	/** 唯一码. */
	private String soleCode;
	
	/** 托盘编号. */
	private String trayCode;
	
	/** 入库方式0件烟1整托盘. */
	private Long wareMethod;
	
	/** 货位状态 ：0空闲中 1 使用中. */
	private Long blStatus;
	
	
    
	public Long getSubverId() {
		return subverId;
	}

	public void setSubverId(Long subverId) {
		this.subverId = subverId;
	}

	public String getSubverName() {
		return subverName;
	}

	public void setSubverName(String subverName) {
		this.subverName = subverName;
	}

	public Long getBlStatus() {
		return blStatus;
	}

	public void setBlStatus(Long blStatus) {
		this.blStatus = blStatus;
	}

	public Long getOrderdetailId() {
		return orderdetailId;
	}

	public void setOrderdetailId(Long orderdetailId) {
		this.orderdetailId = orderdetailId;
	}

	public java.math.BigDecimal getCigsmokeQuality() {
		return cigsmokeQuality;
	}

	public void setCigsmokeQuality(java.math.BigDecimal cigsmokeQuality) {
		this.cigsmokeQuality = cigsmokeQuality;
	}

	public String getTrayRfid() {
		return trayRfid;
	}

	public void setTrayRfid(String trayRfid) {
		this.trayRfid = trayRfid;
	}

	public Long getLocalId() {
		return localId;
	}

	public void setLocalId(Long localId) {
		this.localId = localId;
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

	public Long getTrayStatus() {
		return trayStatus;
	}

	public void setTrayStatus(Long trayStatus) {
		this.trayStatus = trayStatus;
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

	public java.math.BigDecimal getQuality() {
		return quality;
	}

	public void setQuality(java.math.BigDecimal quality) {
		this.quality = quality;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
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

	public java.math.BigDecimal getActualQuality() {
		return actualQuality;
	}

	public void setActualQuality(java.math.BigDecimal actualQuality) {
		this.actualQuality = actualQuality;
	}

	public java.util.Date getProduceDate() {
		return produceDate;
	}

	public void setProduceDate(java.util.Date produceDate) {
		this.produceDate = produceDate;
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


	/** set 入库订单编号. */
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	/** get 入库订单编号. */
	public String getOrderNumber() {
		return this.orderNumber;
	}

	@JsonIgnore
	public String getOrderNumberByLike() {
		return "%"+this.orderNumber+"%";
	}


	/** set 物流单号. */
	public void setShipmentNumber(String shipmentNumber) {
		this.shipmentNumber = shipmentNumber;
	}

	/** get 物流单号. */
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


	/** set 移出仓库编码. */
	public void setOriginWarehouseCode(String originWarehouseCode) {
		this.originWarehouseCode = originWarehouseCode;
	}

	/** get 移出仓库编码. */
	public String getOriginWarehouseCode() {
		return this.originWarehouseCode;
	}

	@JsonIgnore
	public String getOriginWarehouseCodeByLike() {
		return "%"+this.originWarehouseCode+"%";
	}


	/** set 移出仓库名称. */
	public void setOriginWarehouseName(String originWarehouseName) {
		this.originWarehouseName = originWarehouseName;
	}

	/** get 移出仓库名称. */
	public String getOriginWarehouseName() {
		return this.originWarehouseName;
	}

	@JsonIgnore
	public String getOriginWarehouseNameByLike() {
		return "%"+this.originWarehouseName+"%";
	}


	/** set 移入仓库编码. */
	public void setIntoWarehouseCode(String intoWarehouseCode) {
		this.intoWarehouseCode = intoWarehouseCode;
	}

	/** get 移入仓库编码. */
	public String getIntoWarehouseCode() {
		return this.intoWarehouseCode;
	}

	@JsonIgnore
	public String getIntoWarehouseCodeByLike() {
		return "%"+this.intoWarehouseCode+"%";
	}


	/** set 移入仓库名称. */
	public void setIntoWarehouseName(String intoWarehouseName) {
		this.intoWarehouseName = intoWarehouseName;
	}

	/** get 移入仓库名称. */
	public String getIntoWarehouseName() {
		return this.intoWarehouseName;
	}

	@JsonIgnore
	public String getIntoWarehouseNameByLike() {
		return "%"+this.intoWarehouseName+"%";
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


	/** set 入库完成时间. */
	public void setEntryCompliteDate(java.util.Date entryCompliteDate) {
		this.entryCompliteDate = entryCompliteDate;
	}

	/** get 入库完成时间. */
	public java.util.Date getEntryCompliteDate() {
		return this.entryCompliteDate;
	}

	@JsonIgnore
	public java.util.Date getEntryCompliteDateByLike() {
		return this.entryCompliteDate;
	}


	/** set 状态0草稿1已确认2入库中3已完成. */
	public void setStatus(Long status) {
		this.status = status;
	}

	/** get 状态0草稿1已确认2入库中3已完成. */
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


	/** set 入库通道编号. */
	public void setEntryChannelCode(String entryChannelCode) {
		this.entryChannelCode = entryChannelCode;
	}

	/** get 入库通道编号. */
	public String getEntryChannelCode() {
		return this.entryChannelCode;
	}

	@JsonIgnore
	public String getEntryChannelCodeByLike() {
		return "%"+this.entryChannelCode+"%";
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
	public EntrymainorderEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param orderNumber			入库订单编号
	 * @param shipmentNumber			物流单号
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
	 * @param originWarehouseCode			移出仓库编码
	 * @param originWarehouseName			移出仓库名称
	 * @param intoWarehouseCode			移入仓库编码
	 * @param intoWarehouseName			移入仓库名称
	 * @param deliveryRequire			发货要求
	 * @param remark			备注
	 * @param entryCompliteDate			入库完成时间
	 * @param status			状态0草稿1已确认2入库中3已完成
	 * @param createdDate			创建时间
	 * @param createdPersonId			创建人id
	 * @param createdPerson			创建人
	 * @param updatedDate			更新时间
	 * @param updatedPersonId			更新人id
	 * @param updatedPerson			修改人
	 * @param entryChannelCode			入库通道编号
	 * @param transportCode			运输方式编码
	 * @param isDelete			是否删除0否1是
	 * @param orignMethod			订单来源方式：1物流系统 2手动录入
	 */
	public EntrymainorderEntity(String orderNumber,String shipmentNumber,java.util.Date shipmentDate,String plateNumber,java.math.BigDecimal totalQuality,java.util.Date deliveryDate,String transportType,String carrier,String phoneNumber,String carrierUnit,String carrierUnitCode,java.util.Date reservationDate,String shipmentRemark,String contractNumber,java.util.Date contractDate,String originWarehouseCode,String originWarehouseName,String intoWarehouseCode,String intoWarehouseName,String deliveryRequire,String remark,java.util.Date entryCompliteDate,Long status,java.util.Date createdDate,Long createdPersonId,String createdPerson,java.util.Date updatedDate,Long updatedPersonId,String updatedPerson,String entryChannelCode,String transportCode,Integer isDelete,Long orignMethod){
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
		this.originWarehouseCode = originWarehouseCode;
		this.originWarehouseName = originWarehouseName;
		this.intoWarehouseCode = intoWarehouseCode;
		this.intoWarehouseName = intoWarehouseName;
		this.deliveryRequire = deliveryRequire;
		this.remark = remark;
		this.entryCompliteDate = entryCompliteDate;
		this.status = status;
		this.createdDate = createdDate;
		this.createdPersonId = createdPersonId;
		this.createdPerson = createdPerson;
		this.updatedDate = updatedDate;
		this.updatedPersonId = updatedPersonId;
		this.updatedPerson = updatedPerson;
		this.entryChannelCode = entryChannelCode;
		this.transportCode = transportCode;
		this.isDelete = isDelete;
		this.orignMethod = orignMethod;
	}

	@Override
	public String toString() {
		return new StringBuilder().append("EntrymainorderEntity[")
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
				.append("OriginWarehouseCode=").append(getOriginWarehouseCode()).append(", ")
				.append("OriginWarehouseName=").append(getOriginWarehouseName()).append(", ")
				.append("IntoWarehouseCode=").append(getIntoWarehouseCode()).append(", ")
				.append("IntoWarehouseName=").append(getIntoWarehouseName()).append(", ")
				.append("DeliveryRequire=").append(getDeliveryRequire()).append(", ")
				.append("Remark=").append(getRemark()).append(", ")
				.append("EntryCompliteDate=").append(getEntryCompliteDate()).append(", ")
				.append("Status=").append(getStatus()).append(", ")
				.append("CreatedDate=").append(getCreatedDate()).append(", ")
				.append("CreatedPersonId=").append(getCreatedPersonId()).append(", ")
				.append("CreatedPerson=").append(getCreatedPerson()).append(", ")
				.append("UpdatedDate=").append(getUpdatedDate()).append(", ")
				.append("UpdatedPersonId=").append(getUpdatedPersonId()).append(", ")
				.append("UpdatedPerson=").append(getUpdatedPerson()).append(", ")
				.append("EntryChannelCode=").append(getEntryChannelCode()).append(", ")
				.append("TransportCode=").append(getTransportCode()).append(", ")
				.append("IsDelete=").append(getIsDelete()).append(", ")
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
		if(obj instanceof EntrymainorderEntity == false)
			return false;
		if(this == obj)
			return true;
		EntrymainorderEntity other = (EntrymainorderEntity)obj;

		return this.toString().equals(other.toString());
	}
}
