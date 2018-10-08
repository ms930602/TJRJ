
package com.ms.warehouse.manage.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 单号编码规则
 * @author dwx
 * @Date 2018-07-09 18:27:43
 * @since 1.0
 */
@TableName("t_base_numcoderules")
public class NumcoderulesEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** 自增id. */
	private Long id;
	
	/** 单号类型. */
	@NotBlank(message="单号类型不能为空")
	private String type;
	
	/** 单号前缀. */
	@NotBlank(message="单号前缀不能为空")
	private String prefix;
	
	/** 分隔符. */
	@NotBlank(message="分隔符不能为空")
	private String separator;
	
	/** 日期. */
	@Max(value=10,message="日期最大长度为10")
	private String date;
	
	/** 序列号位数. */
	@NotNull(message="序列号位数不能为空")
	private Long serialDigits;
	
	/** 序列号. */
	private Long serial;
	
	

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
	

    /** set 单号类型. */
	public void setType(String type) {
		this.type = type;
	}
	
	/** get 单号类型. */
	public String getType() {
		return this.type;
	}
	
	@JsonIgnore
	public String getTypeByLike() {
		return "%"+this.type+"%";
	}
	

    /** set 单号前缀. */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	/** get 单号前缀. */
	public String getPrefix() {
		return this.prefix;
	}
	
	@JsonIgnore
	public String getPrefixByLike() {
		return "%"+this.prefix+"%";
	}
	

    /** set 分隔符. */
	public void setSeparator(String separator) {
		this.separator = separator;
	}
	
	/** get 分隔符. */
	public String getSeparator() {
		return this.separator;
	}
	
	@JsonIgnore
	public String getSeparatorByLike() {
		return this.separator;
	}
	

    /** set 日期. */
	public void setDate(String date) {
		this.date = date;
	}
	
	/** get 日期. */
	public String getDate() {
		return this.date;
	}
	
	@JsonIgnore
	public String getDateByLike() {
		return "%"+this.date+"%";
	}
	

    /** set 序列号位数. */
	public void setSerialDigits(Long serialDigits) {
		this.serialDigits = serialDigits;
	}
	
	/** get 序列号位数. */
	public Long getSerialDigits() {
		return this.serialDigits;
	}
	
	@JsonIgnore
	public Long getSerialDigitsByLike() {
		return this.serialDigits;
	}
	

    /** set 序列号. */
	public void setSerial(Long serial) {
		this.serial = serial;
	}
	
	/** get 序列号. */
	public Long getSerial() {
		return this.serial;
	}
	
	@JsonIgnore
	public Long getSerialByLike() {
		return this.serial;
	}
	
    /** constructor */
	public NumcoderulesEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param type			单号类型
	 * @param prefix			单号前缀
	 * @param separator			分隔符
	 * @param date			日期
	 * @param serialDigits			序列号位数
	 * @param serial			序列号
	 */
	public NumcoderulesEntity(String type,String prefix,String separator,String date,Long serialDigits,Long serial){
		this();
		this.type = type;
		this.prefix = prefix;
		this.separator = separator;
		this.date = date;
		this.serialDigits = serialDigits;
		this.serial = serial;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("NumcoderulesEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("Type=").append(getType()).append(", ")
			.append("Prefix=").append(getPrefix()).append(", ")
			.append("Separator=").append(getSeparator()).append(", ")
			.append("Date=").append(getDate()).append(", ")
			.append("SerialDigits=").append(getSerialDigits()).append(", ")
			.append("Serial=").append(getSerial())
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
		if(obj instanceof NumcoderulesEntity == false)
			return false;
		if(this == obj)
			return true;
		NumcoderulesEntity other = (NumcoderulesEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
