
package com.ms.warehouse.manage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 
 * @author Ms
 * @Date 2018-10-26 09:51:49
 * @since 1.0
 */
@TableName("t_vx_promoters")
public class VxPromotersEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** 主键. */
	private Long id;
	
	/** 微信号. */
	private String vxNum;
	
	/** 手机号. */
	private String phone;
	
	/** 姓名. */
	private String name;
	
	/** 昵称. */
	private String nickname;
	
	/** 推广个数. */
	private Long extNum;
	
	/** 返现总金额. */
	private java.math.BigDecimal sumMoney;
	
	/** 活动外键. */
	private Long activites;
	
	/** 授权号. */
	private String openId;
	
	/** 创建时间. */
	private java.util.Date createtime;
	
	/** 头像. */
	private String headimgurl;
	
	/** 年龄. */
	private String sex;
	
	/** 省份. */
	private String province;
	
	/** 城市. */
	private String city;
	
	/** 国家. */
	private String country;
	
	/** . */
	private String unionid;
	
	

    /** set 主键. */
	public void setId(Long id) {
		this.id = id;
	}
	
	/** get 主键. */
	public Long getId() {
		return this.id;
	}
	
	@JsonIgnore
	public Long getIdByLike() {
		return this.id;
	}
	

    /** set 微信号. */
	public void setVxNum(String vxNum) {
		this.vxNum = vxNum;
	}
	
	/** get 微信号. */
	public String getVxNum() {
		return this.vxNum;
	}
	
	@JsonIgnore
	public String getVxNumByLike() {
		return "%"+this.vxNum+"%";
	}
	

    /** set 手机号. */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/** get 手机号. */
	public String getPhone() {
		return this.phone;
	}
	
	@JsonIgnore
	public String getPhoneByLike() {
		return "%"+this.phone+"%";
	}
	

    /** set 姓名. */
	public void setName(String name) {
		this.name = name;
	}
	
	/** get 姓名. */
	public String getName() {
		return this.name;
	}
	
	@JsonIgnore
	public String getNameByLike() {
		return "%"+this.name+"%";
	}
	

    /** set 昵称. */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	/** get 昵称. */
	public String getNickname() {
		return this.nickname;
	}
	
	@JsonIgnore
	public String getNicknameByLike() {
		return "%"+this.nickname+"%";
	}
	

    /** set 推广个数. */
	public void setExtNum(Long extNum) {
		this.extNum = extNum;
	}
	
	/** get 推广个数. */
	public Long getExtNum() {
		return this.extNum;
	}
	
	@JsonIgnore
	public Long getExtNumByLike() {
		return this.extNum;
	}
	

    /** set 返现总金额. */
	public void setSumMoney(java.math.BigDecimal sumMoney) {
		this.sumMoney = sumMoney;
	}
	
	/** get 返现总金额. */
	public java.math.BigDecimal getSumMoney() {
		return this.sumMoney;
	}
	
	@JsonIgnore
	public java.math.BigDecimal getSumMoneyByLike() {
		return this.sumMoney;
	}
	

    /** set 活动外键. */
	public void setActivites(Long activites) {
		this.activites = activites;
	}
	
	/** get 活动外键. */
	public Long getActivites() {
		return this.activites;
	}
	
	@JsonIgnore
	public Long getActivitesByLike() {
		return this.activites;
	}
	

    /** set 授权号. */
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	
	/** get 授权号. */
	public String getOpenId() {
		return this.openId;
	}
	
	@JsonIgnore
	public String getOpenIdByLike() {
		return "%"+this.openId+"%";
	}
	

    /** set 创建时间. */
	public void setCreatetime(java.util.Date createtime) {
		this.createtime = createtime;
	}
	
	/** get 创建时间. */
	public java.util.Date getCreatetime() {
		return this.createtime;
	}
	
	@JsonIgnore
	public java.util.Date getCreatetimeByLike() {
		return this.createtime;
	}
	

    /** set 头像. */
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	
	/** get 头像. */
	public String getHeadimgurl() {
		return this.headimgurl;
	}
	
	@JsonIgnore
	public String getHeadimgurlByLike() {
		return "%"+this.headimgurl+"%";
	}
	

    /** set 年龄. */
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	/** get 年龄. */
	public String getSex() {
		return this.sex;
	}
	
	@JsonIgnore
	public String getSexByLike() {
		return "%"+this.sex+"%";
	}
	

    /** set 省份. */
	public void setProvince(String province) {
		this.province = province;
	}
	
	/** get 省份. */
	public String getProvince() {
		return this.province;
	}
	
	@JsonIgnore
	public String getProvinceByLike() {
		return "%"+this.province+"%";
	}
	

    /** set 城市. */
	public void setCity(String city) {
		this.city = city;
	}
	
	/** get 城市. */
	public String getCity() {
		return this.city;
	}
	
	@JsonIgnore
	public String getCityByLike() {
		return "%"+this.city+"%";
	}
	

    /** set 国家. */
	public void setCountry(String country) {
		this.country = country;
	}
	
	/** get 国家. */
	public String getCountry() {
		return this.country;
	}
	
	@JsonIgnore
	public String getCountryByLike() {
		return "%"+this.country+"%";
	}
	

    /** set . */
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	
	/** get . */
	public String getUnionid() {
		return this.unionid;
	}
	
	@JsonIgnore
	public String getUnionidByLike() {
		return "%"+this.unionid+"%";
	}
	
    /** constructor */
	public VxPromotersEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param vxNum			微信号
	 * @param phone			手机号
	 * @param name			姓名
	 * @param nickname			昵称
	 * @param extNum			推广个数
	 * @param sumMoney			返现总金额
	 * @param activites			活动外键
	 * @param openId			授权号
	 * @param createtime			创建时间
	 * @param headimgurl			头像
	 * @param sex			年龄
	 * @param province			省份
	 * @param city			城市
	 * @param country			国家
	 * @param unionid			
	 */
	public VxPromotersEntity(String vxNum,String phone,String name,String nickname,Long extNum,java.math.BigDecimal sumMoney,Long activites,String openId,java.util.Date createtime,String headimgurl,String sex,String province,String city,String country,String unionid){
		this();
		this.vxNum = vxNum;
		this.phone = phone;
		this.name = name;
		this.nickname = nickname;
		this.extNum = extNum;
		this.sumMoney = sumMoney;
		this.activites = activites;
		this.openId = openId;
		this.createtime = createtime;
		this.headimgurl = headimgurl;
		this.sex = sex;
		this.province = province;
		this.city = city;
		this.country = country;
		this.unionid = unionid;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("VxPromotersEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("VxNum=").append(getVxNum()).append(", ")
			.append("Phone=").append(getPhone()).append(", ")
			.append("Name=").append(getName()).append(", ")
			.append("Nickname=").append(getNickname()).append(", ")
			.append("ExtNum=").append(getExtNum()).append(", ")
			.append("SumMoney=").append(getSumMoney()).append(", ")
			.append("Activites=").append(getActivites()).append(", ")
			.append("OpenId=").append(getOpenId()).append(", ")
			.append("Createtime=").append(getCreatetime()).append(", ")
			.append("Headimgurl=").append(getHeadimgurl()).append(", ")
			.append("Sex=").append(getSex()).append(", ")
			.append("Province=").append(getProvince()).append(", ")
			.append("City=").append(getCity()).append(", ")
			.append("Country=").append(getCountry()).append(", ")
			.append("Unionid=").append(getUnionid())
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
		if(obj instanceof VxPromotersEntity == false)
			return false;
		if(this == obj)
			return true;
		VxPromotersEntity other = (VxPromotersEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
