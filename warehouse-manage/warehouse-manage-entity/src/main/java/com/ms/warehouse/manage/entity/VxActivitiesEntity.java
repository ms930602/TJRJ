
package com.ms.warehouse.manage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ms.warehouse.common.entity.BaseEntity;
import com.ms.warehouse.common.vo.TableName;

/**
 * 
 * @author Ms
 * @Date 2018-10-28 18:03:18
 * @since 1.0
 */
@TableName("t_vx_activities")
public class VxActivitiesEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
	/** 主键. */
	private Long id;
	
	/** 商户外键. */
	private Long merchantId;
	
	/** 标题. */
	private String title;
	
	/** 价格. */
	private java.math.BigDecimal price;
	
	/** 门户图片 文件表ID. */
	private Long topImg;
	
	/** 活动时间. */
	private java.util.Date startTime;
	
	/** 活动音乐 文件表ID. */
	private Long mp3Id;
	
	/** 活动人数. */
	private Long peopleNum;
	
	/** 购买人数. */
	private Long payNum;
	
	/** 浏览数. */
	private Long selectNum;
	
	/** 详情图片 门户图片 文件表ID 以逗号隔开. */
	private String detailImg;
	
	/** 客户电话. */
	private String phone;
	
	/** 1 作废 0 启用. */
	private String status;
	
	/** . */
	private String url;
	
	/** 微信页脚信息. */
	private String vxText;
	
	/** 客户名称. */
	private String khName;
	
	/** 红包标题. */
	private String redpackTitle;
	
	/** 红包描述. */
	private String redpackContent;
	
	

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
	

    /** set 商户外键. */
	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}
	
	/** get 商户外键. */
	public Long getMerchantId() {
		return this.merchantId;
	}
	
	@JsonIgnore
	public Long getMerchantIdByLike() {
		return this.merchantId;
	}
	

    /** set 标题. */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/** get 标题. */
	public String getTitle() {
		return this.title;
	}
	
	@JsonIgnore
	public String getTitleByLike() {
		return "%"+this.title+"%";
	}
	

    /** set 价格. */
	public void setPrice(java.math.BigDecimal price) {
		this.price = price;
	}
	
	/** get 价格. */
	public java.math.BigDecimal getPrice() {
		return this.price;
	}
	
	@JsonIgnore
	public java.math.BigDecimal getPriceByLike() {
		return this.price;
	}
	

    /** set 门户图片 文件表ID. */
	public void setTopImg(Long topImg) {
		this.topImg = topImg;
	}
	
	/** get 门户图片 文件表ID. */
	public Long getTopImg() {
		return this.topImg;
	}
	
	@JsonIgnore
	public Long getTopImgByLike() {
		return this.topImg;
	}
	

    /** set 活动时间. */
	public void setStartTime(java.util.Date startTime) {
		this.startTime = startTime;
	}
	
	/** get 活动时间. */
	public java.util.Date getStartTime() {
		return this.startTime;
	}
	
	@JsonIgnore
	public java.util.Date getStartTimeByLike() {
		return this.startTime;
	}
	

    /** set 活动音乐 文件表ID. */
	public void setMp3Id(Long mp3Id) {
		this.mp3Id = mp3Id;
	}
	
	/** get 活动音乐 文件表ID. */
	public Long getMp3Id() {
		return this.mp3Id;
	}
	
	@JsonIgnore
	public Long getMp3IdByLike() {
		return this.mp3Id;
	}
	

    /** set 活动人数. */
	public void setPeopleNum(Long peopleNum) {
		this.peopleNum = peopleNum;
	}
	
	/** get 活动人数. */
	public Long getPeopleNum() {
		return this.peopleNum;
	}
	
	@JsonIgnore
	public Long getPeopleNumByLike() {
		return this.peopleNum;
	}
	

    /** set 购买人数. */
	public void setPayNum(Long payNum) {
		this.payNum = payNum;
	}
	
	/** get 购买人数. */
	public Long getPayNum() {
		return this.payNum;
	}
	
	@JsonIgnore
	public Long getPayNumByLike() {
		return this.payNum;
	}
	

    /** set 浏览数. */
	public void setSelectNum(Long selectNum) {
		this.selectNum = selectNum;
	}
	
	/** get 浏览数. */
	public Long getSelectNum() {
		return this.selectNum;
	}
	
	@JsonIgnore
	public Long getSelectNumByLike() {
		return this.selectNum;
	}
	

    /** set 详情图片 门户图片 文件表ID 以逗号隔开. */
	public void setDetailImg(String detailImg) {
		this.detailImg = detailImg;
	}
	
	/** get 详情图片 门户图片 文件表ID 以逗号隔开. */
	public String getDetailImg() {
		return this.detailImg;
	}
	
	@JsonIgnore
	public String getDetailImgByLike() {
		return "%"+this.detailImg+"%";
	}
	

    /** set 客户电话. */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/** get 客户电话. */
	public String getPhone() {
		return this.phone;
	}
	
	@JsonIgnore
	public String getPhoneByLike() {
		return "%"+this.phone+"%";
	}
	

    /** set 1 作废 0 启用. */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/** get 1 作废 0 启用. */
	public String getStatus() {
		return this.status;
	}
	
	@JsonIgnore
	public String getStatusByLike() {
		return this.status;
	}
	

    /** set . */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/** get . */
	public String getUrl() {
		return this.url;
	}
	
	@JsonIgnore
	public String getUrlByLike() {
		return "%"+this.url+"%";
	}
	

    /** set 微信页脚信息. */
	public void setVxText(String vxText) {
		this.vxText = vxText;
	}
	
	/** get 微信页脚信息. */
	public String getVxText() {
		return this.vxText;
	}
	
	@JsonIgnore
	public String getVxTextByLike() {
		return "%"+this.vxText+"%";
	}
	

    /** set 客户名称. */
	public void setKhName(String khName) {
		this.khName = khName;
	}
	
	/** get 客户名称. */
	public String getKhName() {
		return this.khName;
	}
	
	@JsonIgnore
	public String getKhNameByLike() {
		return "%"+this.khName+"%";
	}
	

    /** set 红包标题. */
	public void setRedpackTitle(String redpackTitle) {
		this.redpackTitle = redpackTitle;
	}
	
	/** get 红包标题. */
	public String getRedpackTitle() {
		return this.redpackTitle;
	}
	
	@JsonIgnore
	public String getRedpackTitleByLike() {
		return "%"+this.redpackTitle+"%";
	}
	

    /** set 红包描述. */
	public void setRedpackContent(String redpackContent) {
		this.redpackContent = redpackContent;
	}
	
	/** get 红包描述. */
	public String getRedpackContent() {
		return this.redpackContent;
	}
	
	@JsonIgnore
	public String getRedpackContentByLike() {
		return "%"+this.redpackContent+"%";
	}
	
    /** constructor */
	public VxActivitiesEntity() {
		super();
	}

	/**
	 * constructor.<p>
	 * @param merchantId			商户外键
	 * @param title			标题
	 * @param price			价格
	 * @param topImg			门户图片 文件表ID
	 * @param startTime			活动时间
	 * @param mp3Id			活动音乐 文件表ID
	 * @param peopleNum			活动人数
	 * @param payNum			购买人数
	 * @param selectNum			浏览数
	 * @param detailImg			详情图片 门户图片 文件表ID 以逗号隔开
	 * @param phone			客户电话
	 * @param status			1 作废 0 启用
	 * @param url			
	 * @param vxText			微信页脚信息
	 * @param khName			客户名称
	 * @param redpackTitle			红包标题
	 * @param redpackContent			红包描述
	 */
	public VxActivitiesEntity(Long merchantId,String title,java.math.BigDecimal price,Long topImg,java.util.Date startTime,Long mp3Id,Long peopleNum,Long payNum,Long selectNum,String detailImg,String phone,String status,String url,String vxText,String khName,String redpackTitle,String redpackContent){
		this();
		this.merchantId = merchantId;
		this.title = title;
		this.price = price;
		this.topImg = topImg;
		this.startTime = startTime;
		this.mp3Id = mp3Id;
		this.peopleNum = peopleNum;
		this.payNum = payNum;
		this.selectNum = selectNum;
		this.detailImg = detailImg;
		this.phone = phone;
		this.status = status;
		this.url = url;
		this.vxText = vxText;
		this.khName = khName;
		this.redpackTitle = redpackTitle;
		this.redpackContent = redpackContent;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("VxActivitiesEntity[")
			.append("Id=").append(getId()).append(", ")
			.append("MerchantId=").append(getMerchantId()).append(", ")
			.append("Title=").append(getTitle()).append(", ")
			.append("Price=").append(getPrice()).append(", ")
			.append("TopImg=").append(getTopImg()).append(", ")
			.append("StartTime=").append(getStartTime()).append(", ")
			.append("Mp3Id=").append(getMp3Id()).append(", ")
			.append("PeopleNum=").append(getPeopleNum()).append(", ")
			.append("PayNum=").append(getPayNum()).append(", ")
			.append("SelectNum=").append(getSelectNum()).append(", ")
			.append("DetailImg=").append(getDetailImg()).append(", ")
			.append("Phone=").append(getPhone()).append(", ")
			.append("Status=").append(getStatus()).append(", ")
			.append("Url=").append(getUrl()).append(", ")
			.append("VxText=").append(getVxText()).append(", ")
			.append("KhName=").append(getKhName()).append(", ")
			.append("RedpackTitle=").append(getRedpackTitle()).append(", ")
			.append("RedpackContent=").append(getRedpackContent())
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
		if(obj instanceof VxActivitiesEntity == false)
			return false;
		if(this == obj)
			return true;
		VxActivitiesEntity other = (VxActivitiesEntity)obj;
		
		return this.toString().equals(other.toString());
	}
}
