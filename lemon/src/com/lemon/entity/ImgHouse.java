package com.lemon.entity;


import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import net.sf.json.JSONArray;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.lemon.common.bean.ImageBean;

/**
 * ImgHouse (table = img_house)
 * 
 * 图片库\r\n
 */
@Entity
@Table(name = "img_house")
public class ImgHouse extends BaseEntity {

	private String imgurl;//保存路径
	private String userId;//上传用户
	private java.util.Date createTime;//诞生时间
	private java.util.Date uploadTime;//上传时间
	private Integer status;//状态1、出售2、拍卖3、已出售
	private String name;//名称
	private String describe;//描述
	private Integer isverify ;//审核状态0审核中1审核通过2审核失败
	private List<ImageBean> imgurlb ;
	
	@Transient
	public List<ImageBean> getImgurlb() {
		if (StringUtils.isEmpty(imgurl)) {
			return null;
		}
		try {
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.setRootClass(ImageBean.class);
			JSONArray jsonArray = JSONArray.fromObject(imgurl);
			return (List<ImageBean>) JSONSerializer.toJava(jsonArray, jsonConfig);
		} catch (Exception e) {
			return null;
		}
	}

	public void setImgurlb(List<ImageBean> imgurlb) {
		if (imgurlb == null || imgurlb.size() == 0) {
			imgurl = null;
			return;
		}
		Collections.sort(imgurlb);
		JSONArray jsonArray = JSONArray.fromObject(imgurlb);
		imgurl = jsonArray.toString() ;
		this.imgurlb = imgurlb;
	}
	
	@Column(name = "isverify", length = 1)
	public Integer getIsverify() {
		return isverify;
	}

	public void setIsverify(Integer isverify) {
		this.isverify = isverify;
	}
   /**
	* 保存路径
	* @return String
	* @hibernate.property column="imgurl" type="java.lang.String" length="300" not-null="false"
	*/
	@Column(name = "imgurl", length = 300)
	public String getImgurl() {
		return this.imgurl;
	}

   

/**
	* Set the imgurl
	*/
	public void setImgurl(String aValue) {
		this.imgurl = aValue;
	}

   /**
	* 上传用户
	* @return String
	* @hibernate.property column="user_id" type="java.lang.String" length="32" not-null="false"
	*/
	@Column(name = "user_id", length = 32)
	public String getUserId() {
		return this.userId;
	}

   /**
	* Set the userId
	*/
	public void setUserId(String aValue) {
		this.userId = aValue;
	}

   /**
	* 诞生时间
	* @return java.util.Date
	* @hibernate.property column="create_time" type="java.util.Date" length="19" not-null="false"
	*/
	@Column(name = "create_time", length = 19)
	public java.util.Date getCreateTime() {
		return this.createTime;
	}

   /**
	* Set the createTime
	*/
	public void setCreateTime(java.util.Date aValue) {
		this.createTime = aValue;
	}

   /**
	* 上传时间
	* @return java.util.Date
	* @hibernate.property column="upload_time" type="java.util.Date" length="19" not-null="false"
	*/
	@Column(name = "upload_time", length = 19)
	public java.util.Date getUploadTime() {
		return this.uploadTime;
	}

   /**
	* Set the uploadTime
	*/
	public void setUploadTime(java.util.Date aValue) {
		this.uploadTime = aValue;
	}

   /**
	* 状态1、出售2、拍卖3、已出售
	* @return Integer
	* @hibernate.property column="status" type="java.lang.Integer" length="10" not-null="false"
	*/
	@Column(name = "`status`", length = 10)
	public Integer getStatus() {
		return this.status;
	}

   /**
	* Set the status
	*/
	public void setStatus(Integer aValue) {
		this.status = aValue;
	}

   /**
	* 名称
	* @return String
	* @hibernate.property column="name" type="java.lang.String" length="32" not-null="false"
	*/
	@Column(name = "`name`", length = 32)
	public String getName() {
		return this.name;
	}

   /**
	* Set the name
	*/
	public void setName(String aValue) {
		this.name = aValue;
	}

   /**
	* 描述
	* @return String
	* @hibernate.property column="describe" type="java.lang.String" length="65535" not-null="false"
	*/
	@Column(name = "`describe`", length = 65535)
	public String getDescribe() {
		return this.describe;
	}

   /**
	* Set the describe
	*/
	public void setDescribe(String aValue) {
		this.describe = aValue;
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof ImgHouse)) {
			return false;
		}
		ImgHouse rhs = (ImgHouse) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.imgurl, rhs.imgurl)
		.append(this.userId, rhs.userId)
		.append(this.createTime, rhs.createTime)
		.append(this.uploadTime, rhs.uploadTime)
		.append(this.status, rhs.status)
		.append(this.name, rhs.name)
		.append(this.describe, rhs.describe)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.imgurl) 
		.append(this.userId) 
		.append(this.createTime) 
		.append(this.uploadTime) 
		.append(this.status) 
		.append(this.name) 
		.append(this.describe) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("imgurl", this.imgurl) 
		.append("userId", this.userId) 
		.append("createTime", this.createTime) 
		.append("uploadTime", this.uploadTime) 
		.append("status", this.status) 
		.append("name", this.name) 
		.append("describe", this.describe) 
		.toString();
	}

	
}
