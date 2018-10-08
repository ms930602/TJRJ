
package com.ms.warehouse.manage.entity;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 设备升级版本管理
 * @author wangwei
 * @Date 2018-08-03 09:51:01
 * @since 1.0
 */
@TableName("t_base_deviceversion")
public class BaseDeviceversionEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** 自增ID. */
	private Long id;
	
	/** 设备类型 1手持机2车载终端. */
	private Long deviceType;
	
	/** 生产厂家. */
	@Length(max=100,message="生产厂家最大长度为100个字符")
	private String manufacturer;
	
	/** 设备型号. */
	@Length(max=50,message="设备型号最大长度为50个字符")
	private String deviceModel;
	
	/** 版本号. */
	@Length(max=45,message="版本号最大长度为45个字符")
	private String version;
	
	/** 是否必须更新. */
	private Integer isNeedUpdate;
	
	/** 版本状态0未发布1已发布. */
	private Long versionStatus;
	
	/** 附件Id. */
	private Long fileId;
	
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
	
	//上传的附件信息
	private BaseUploadfilerecodeEntity uploadfile;
	

    public BaseUploadfilerecodeEntity getUploadfile() {
		return uploadfile;
	}

	public void setUploadfile(BaseUploadfilerecodeEntity uploadfile) {
		this.uploadfile = uploadfile;
	}

	/** set 自增ID. */
	public void setId(Long id) {
		this.id = id;
	}
	
	/** get 自增ID. */
	public Long getId() {
		return this.id;
	}
	
	@JsonIgnore
	public Long getIdByLike() {
		return this.id;
	}
	

    /** set 设备类型 1手持机2车载终端. */
	public void setDeviceType(Long deviceType) {
		this.deviceType = deviceType;
	}
	
	/** get 设备类型 1手持机2车载终端. */
	public Long getDeviceType() {
		return this.deviceType;
	}
	
	@JsonIgnore
	public Long getDeviceTypeByLike() {
		return this.deviceType;
	}
	

    /** set 生产厂家. */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	/** get 生产厂家. */
	public String getManufacturer() {
		return this.manufacturer;
	}
	
	@JsonIgnore
	public String getManufacturerByLike() {
		return "%"+this.manufacturer+"%";
	}
	

    /** set 设备型号. */
	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}
	
	/** get 设备型号. */
	public String getDeviceModel() {
		return this.deviceModel;
	}
	
	@JsonIgnore
	public String getDeviceModelByLike() {
		return "%"+this.deviceModel+"%";
	}
	

    /** set 版本号. */
	public void setVersion(String version) {
		this.version = version;
	}
	
	/** get 版本号. */
	public String getVersion() {
		return this.version;
	}
	
	@JsonIgnore
	public String getVersionByLike() {
		return "%"+this.version+"%";
	}
	

    /** set 是否必须更新. */
	public void setIsNeedUpdate(Integer isNeedUpdate) {
		this.isNeedUpdate = isNeedUpdate;
	}
	
	/** get 是否必须更新. */
	public Integer getIsNeedUpdate() {
		return this.isNeedUpdate;
	}
	
	@JsonIgnore
	public Integer getIsNeedUpdateByLike() {
		return this.isNeedUpdate;
	}
	

    /** set 版本状态0未发布1已发布. */
	public void setVersionStatus(Long versionStatus) {
		this.versionStatus = versionStatus;
	}
	
	/** get 版本状态0未发布1已发布. */
	public Long getVersionStatus() {
		return this.versionStatus;
	}
	
	@JsonIgnore
	public Long getVersionStatusByLike() {
		return this.versionStatus;
	}
	

    /** set 附件Id. */
	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}
	
	/** get 附件Id. */
	public Long getFileId() {
		return this.fileId;
	}
	
	@JsonIgnore
	public Long getFileIdByLike() {
		return this.fileId;
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
	
    /** constructor */
	public BaseDeviceversionEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param deviceType			设备类型 1手持机2车载终端
	 * @param manufacturer			生产厂家
	 * @param deviceModel			设备型号
	 * @param version			版本号
	 * @param isNeedUpdate			是否必须更新
	 * @param versionStatus			版本状态0未发布1已发布
	 * @param fileId			附件Id
	 * @param createdDate			创建时间
	 * @param createdPersonId			创建人id
	 * @param createdPerson			创建人
	 * @param updatedDate			更新时间
	 * @param updatedPersonId			更新人id
	 * @param updatedPerson			修改人
	 */
	public BaseDeviceversionEntity(Long deviceType,String manufacturer,String deviceModel,String version,Integer isNeedUpdate,Long versionStatus,Long fileId,java.util.Date createdDate,Long createdPersonId,String createdPerson,java.util.Date updatedDate,Long updatedPersonId,String updatedPerson){
		this();
		this.deviceType = deviceType;
		this.manufacturer = manufacturer;
		this.deviceModel = deviceModel;
		this.version = version;
		this.isNeedUpdate = isNeedUpdate;
		this.versionStatus = versionStatus;
		this.fileId = fileId;
		this.createdDate = createdDate;
		this.createdPersonId = createdPersonId;
		this.createdPerson = createdPerson;
		this.updatedDate = updatedDate;
		this.updatedPersonId = updatedPersonId;
		this.updatedPerson = updatedPerson;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("BaseDeviceversionEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("DeviceType=").append(getDeviceType()).append(", ")
			.append("Manufacturer=").append(getManufacturer()).append(", ")
			.append("DeviceModel=").append(getDeviceModel()).append(", ")
			.append("Version=").append(getVersion()).append(", ")
			.append("IsNeedUpdate=").append(getIsNeedUpdate()).append(", ")
			.append("VersionStatus=").append(getVersionStatus()).append(", ")
			.append("FileId=").append(getFileId()).append(", ")
			.append("CreatedDate=").append(getCreatedDate()).append(", ")
			.append("CreatedPersonId=").append(getCreatedPersonId()).append(", ")
			.append("CreatedPerson=").append(getCreatedPerson()).append(", ")
			.append("UpdatedDate=").append(getUpdatedDate()).append(", ")
			.append("UpdatedPersonId=").append(getUpdatedPersonId()).append(", ")
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
		if(obj instanceof BaseDeviceversionEntity == false)
			return false;
		if(this == obj)
			return true;
		BaseDeviceversionEntity other = (BaseDeviceversionEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
