package com.lemon.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import com.lemon.constant.font.enums.ImgCategoryEnum;
import com.lemon.constant.font.enums.ImgStatusEnum;
import com.lemon.service.ImgService;

/**
 * ImgMsg (table = img_msg)
 * 
 * 图片库\r\n
 */

@Entity
@Table(name = "img_msg")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ImgMsg extends BaseEntity {

	private String userId;//上传用户
	private java.util.Date createTime;//诞生时间
	private java.util.Date uploadTime;//上传时间
	private ImgStatusEnum states;//状态1、公开2、删除
	private String name;//名称
	private String describes;//描述
	private ImgCategoryEnum category ;//分类
	private List<Img> imglist ;
	private LemonUser user ;
	
	@Column(name = "category")
	@Type(type = "com.lemon.constant.CustomEnumType", parameters = {@Parameter(name = "enum", value = "com.lemon.constant.font.enums.ImgCategoryEnum")})
	public ImgCategoryEnum getCategory() {
		return category;
	}

	public void setCategory(ImgCategoryEnum category) {
		this.category = category;
	}
	@Transient
	public LemonUser getUser() {
		return user;
	}

	public void setUser(LemonUser user) {
		this.user = user;
	}
	
	@Transient
	public List<Img> getImglist() {
		return imglist;
	}

	public void setImglist(List<Img> imglist) {
		this.imglist = imglist;
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
	* @hibernate.property column="states" type="java.lang.Integer" length="10" not-null="false"
	*/
	@Column(name = "states")
	@Type(type = "com.lemon.constant.CustomEnumType", parameters = {@Parameter(name = "enum", value = "com.lemon.constant.font.enums.ImgStatusEnum")})
	public ImgStatusEnum getStates() {
		return states;
	}

	public void setStates(ImgStatusEnum states) {
		this.states = states;
	}

   /**
	* 名称
	* @return String
	* @hibernate.property column="name" type="java.lang.String" length="32" not-null="false"
	*/
	@Column(name = "name", length = 32)
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
	* @hibernate.property column="describes" type="java.lang.String" length="65535" not-null="false"
	*/
	@Column(name = "describes", length = 65535)
	public String getDescribes() {
		return this.describes;
	}

   /**
	* Set the describes
	*/
	public void setDescribes(String aValue) {
		this.describes = aValue;
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof ImgMsg)) {
			return false;
		}
		ImgMsg rhs = (ImgMsg) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.userId, rhs.userId)
		.append(this.createTime, rhs.createTime)
		.append(this.uploadTime, rhs.uploadTime)
		.append(this.states, rhs.states)
		.append(this.name, rhs.name)
		.append(this.describes, rhs.describes)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.userId) 
		.append(this.createTime) 
		.append(this.uploadTime) 
		.append(this.states) 
		.append(this.name) 
		.append(this.describes) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("userId", this.userId) 
		.append("createTime", this.createTime) 
		.append("uploadTime", this.uploadTime) 
		.append("states", this.states) 
		.append("name", this.name) 
		.append("describes", this.describes) 
		.toString();
	}
}
