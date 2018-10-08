
package com.ms.warehouse.inventory.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 货位调整表详情
 * @author dwx
 * @Date 2018-07-25 10:22:20
 * @since 1.0
 */
@TableName("t_ware_positionadjustdetail")
public class PositionadjustdetailEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** 自增id. */
	private Long id;
	
	/** 主表ID. */
	private Long mainId;
	
	/** 原托盘rfid编号. */
	private String origTrayRfid;
	
	/** 原货位id. */
	private String origLocalCode;
	
	/** 目的货位id. */
	private String destLocalCode;
	
	/** 操作人. */
	private String operator;
	
	/** 操作人ID. */
	private Long operatorId;
	
	/** 物料编码. */
	private String materCode;
	
	/** 物料名称. */
	private String materName;
	
	/** 物料版本名称. */
	private String materVersion;
	
	/** 品牌. */
	private String materCigbrand;
	
	/** 唯一码. */
	private String soleCode;
	
	/** 状态0未调整1已调整. */
	private Long status;
	
	/** 托盘编号. */
	private String trayCode;
	
	/** 库存托盘货位绑定表ID. */
	private Long inventorytraylocalmapId;
	
	/**
	 * 卷烟类型：0正式卷烟1福样促试
	 */
	private Long cigtype;
	
	/** 子版本ID. */
	private Long subverId;
	
	/** 子版本名称. */
	private String subverName;
	
	/** 原货位描述. */
	private String oldDescript;
	/** 目的货位描述. */
	private String newDescript;
	
	private String descript;

	private String origLocalDescript;
	
	private String destLocalDescript;
    public String getDescript() {
		return descript;
	}

	public String getOrigLocalDescript() {
		return origLocalDescript;
	}

	public void setOrigLocalDescript(String origLocalDescript) {
		this.origLocalDescript = origLocalDescript;
	}

	public String getDestLocalDescript() {
		return destLocalDescript;
	}

	public void setDestLocalDescript(String destLocalDescript) {
		this.destLocalDescript = destLocalDescript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	/** 原货位rfid编码. */
	private String oldLocalRfid;
	/** 目的货位rfid编码. */
	private String newLocalRfid;
	
	
	
    public String getOldLocalRfid() {
		return oldLocalRfid;
	}

	public void setOldLocalRfid(String oldLocalRfid) {
		this.oldLocalRfid = oldLocalRfid;
	}

	public String getNewLocalRfid() {
		return newLocalRfid;
	}

	public void setNewLocalRfid(String newLocalRfid) {
		this.newLocalRfid = newLocalRfid;
	}

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

    public String getOldDescript() {
		return oldDescript;
	}

	public void setOldDescript(String oldDescript) {
		this.oldDescript = oldDescript;
	}

	public String getNewDescript() {
		return newDescript;
	}

	public void setNewDescript(String newDescript) {
		this.newDescript = newDescript;
	}

	public Long getCigtype() {
		return cigtype;
	}

	public void setCigtype(Long cigtype) {
		this.cigtype = cigtype;
	}

    public Long getInventorytraylocalmapId() {
		return inventorytraylocalmapId;
	}

	public void setInventorytraylocalmapId(Long inventorytraylocalmapId) {
		this.inventorytraylocalmapId = inventorytraylocalmapId;
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
	

    /** set 主表ID. */
	public void setMainId(Long mainId) {
		this.mainId = mainId;
	}
	
	/** get 主表ID. */
	public Long getMainId() {
		return this.mainId;
	}
	
	@JsonIgnore
	public Long getMainIdByLike() {
		return this.mainId;
	}
	

    /** set 原托盘rfid编号. */
	public void setOrigTrayRfid(String origTrayRfid) {
		this.origTrayRfid = origTrayRfid;
	}
	
	/** get 原托盘rfid编号. */
	public String getOrigTrayRfid() {
		return this.origTrayRfid;
	}
	
	@JsonIgnore
	public String getOrigTrayRfidByLike() {
		return "%"+this.origTrayRfid+"%";
	}
	

    /** set 原货位id. */
	public void setOrigLocalCode(String origLocalCode) {
		this.origLocalCode = origLocalCode;
	}
	
	/** get 原货位id. */
	public String getOrigLocalCode() {
		return this.origLocalCode;
	}
	
	@JsonIgnore
	public String getOrigLocalCodeByLike() {
		return "%"+this.origLocalCode+"%";
	}
	

    /** set 目的货位id. */
	public void setDestLocalCode(String destLocalCode) {
		this.destLocalCode = destLocalCode;
	}
	
	/** get 目的货位id. */
	public String getDestLocalCode() {
		return this.destLocalCode;
	}
	
	@JsonIgnore
	public String getDestLocalCodeByLike() {
		return "%"+this.destLocalCode+"%";
	}
	

    /** set 操作人. */
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	/** get 操作人. */
	public String getOperator() {
		return this.operator;
	}
	
	@JsonIgnore
	public String getOperatorByLike() {
		return "%"+this.operator+"%";
	}
	

    /** set 操作人ID. */
	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}
	
	/** get 操作人ID. */
	public Long getOperatorId() {
		return this.operatorId;
	}
	
	@JsonIgnore
	public Long getOperatorIdByLike() {
		return this.operatorId;
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
	

    /** set 物料版本名称. */
	public void setMaterVersion(String materVersion) {
		this.materVersion = materVersion;
	}
	
	/** get 物料版本名称. */
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
	

    /** set 状态0未调整1已调整. */
	public void setStatus(Long status) {
		this.status = status;
	}
	
	/** get 状态0未调整1已调整. */
	public Long getStatus() {
		return this.status;
	}
	
	@JsonIgnore
	public Long getStatusByLike() {
		return this.status;
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
	
    /** constructor */
	public PositionadjustdetailEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param mainId			主表ID
	 * @param origTrayRfid			原托盘rfid编号
	 * @param origLocalCode			原货位id
	 * @param destLocalCode			目的货位id
	 * @param operator			操作人
	 * @param operatorId			操作人ID
	 * @param materCode			物料编码
	 * @param materName			物料名称
	 * @param materVersion			物料版本名称
	 * @param materCigbrand			品牌
	 * @param soleCode			唯一码
	 * @param status			状态0未调整1已调整
	 * @param trayCode			托盘编号
	 */
	public PositionadjustdetailEntity(Long mainId,String origTrayRfid,String origLocalCode,String destLocalCode,String operator,Long operatorId,String materCode,String materName,String materVersion,String materCigbrand,String soleCode,Long status,String trayCode){
		this();
		this.mainId = mainId;
		this.origTrayRfid = origTrayRfid;
		this.origLocalCode = origLocalCode;
		this.destLocalCode = destLocalCode;
		this.operator = operator;
		this.operatorId = operatorId;
		this.materCode = materCode;
		this.materName = materName;
		this.materVersion = materVersion;
		this.materCigbrand = materCigbrand;
		this.soleCode = soleCode;
		this.status = status;
		this.trayCode = trayCode;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("PositionadjustdetailEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("MainId=").append(getMainId()).append(", ")
			.append("OrigTrayRfid=").append(getOrigTrayRfid()).append(", ")
			.append("OrigLocalCode=").append(getOrigLocalCode()).append(", ")
			.append("DestLocalCode=").append(getDestLocalCode()).append(", ")
			.append("Operator=").append(getOperator()).append(", ")
			.append("OperatorId=").append(getOperatorId()).append(", ")
			.append("MaterCode=").append(getMaterCode()).append(", ")
			.append("MaterName=").append(getMaterName()).append(", ")
			.append("MaterVersion=").append(getMaterVersion()).append(", ")
			.append("MaterCigbrand=").append(getMaterCigbrand()).append(", ")
			.append("SoleCode=").append(getSoleCode()).append(", ")
			.append("Status=").append(getStatus()).append(", ")
			.append("TrayCode=").append(getTrayCode())
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
		if(obj instanceof PositionadjustdetailEntity == false)
			return false;
		if(this == obj)
			return true;
		PositionadjustdetailEntity other = (PositionadjustdetailEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
