package com.lemon.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Lemonuser (table = lemonuser)
 * 
 * TODO: add class/table comments
 */
@Entity
@Table(name = "lemonuser")
public class LemonUser extends BaseEntity {

	private String username;//
	private String password;//
	private String weixin;//微信号
	private String cellPhone;//手机号
	private String qq;//qq
	private String email;//邮箱
	private String shenfen;//身份证号
	private String status;//用户状态，2、监禁
	private String trueName;//真实姓名
	private java.util.Date registTime;//注册时间
	private String userGroup;//用户组
	private String userLevel;//用户级别
	private String photo;//头像

   /**
	* 
	* @return String
	* @hibernate.property column="username" type="java.lang.String" length="32" not-null="false"
	*/
	@Column(name = "username", length = 32)
	public String getUsername() {
		return this.username;
	}

   /**
	* Set the username
	*/
	public void setUsername(String aValue) {
		this.username = aValue;
	}

   /**
	* 
	* @return String
	* @hibernate.property column="password" type="java.lang.String" length="32" not-null="false"
	*/
	@Column(name = "pwd", length = 32)
	public String getPassword() {
		return this.password;
	}

   /**
	* Set the password
	*/
	public void setPassword(String aValue) {
		this.password = aValue;
	}

   /**
	* 微信号
	* @return String
	* @hibernate.property column="weixin" type="java.lang.String" length="32" not-null="false"
	*/
	@Column(name = "weixin", length = 32)
	public String getWeixin() {
		return this.weixin;
	}

   /**
	* Set the weixin
	*/
	public void setWeixin(String aValue) {
		this.weixin = aValue;
	}

   /**
	* 手机号
	* @return String
	* @hibernate.property column="cell_phone" type="java.lang.String" length="11" not-null="false"
	*/
	@Column(name = "cell_phone", length = 11)
	public String getCellPhone() {
		return this.cellPhone;
	}

   /**
	* Set the cellPhone
	*/
	public void setCellPhone(String aValue) {
		this.cellPhone = aValue;
	}

   /**
	* qq
	* @return String
	* @hibernate.property column="qq" type="java.lang.String" length="32" not-null="false"
	*/
	@Column(name = "qq", length = 32)
	public String getQq() {
		return this.qq;
	}

   /**
	* Set the qq
	*/
	public void setQq(String aValue) {
		this.qq = aValue;
	}

   /**
	* 邮箱
	* @return String
	* @hibernate.property column="email" type="java.lang.String" length="32" not-null="false"
	*/
	@Column(name = "email", length = 32)
	public String getEmail() {
		return this.email;
	}

   /**
	* Set the email
	*/
	public void setEmail(String aValue) {
		this.email = aValue;
	}

   /**
	* 身份证号
	* @return String
	* @hibernate.property column="shenfen" type="java.lang.String" length="32" not-null="false"
	*/
	@Column(name = "shenfen", length = 32)
	public String getShenfen() {
		return this.shenfen;
	}

   /**
	* Set the shenfen
	*/
	public void setShenfen(String aValue) {
		this.shenfen = aValue;
	}

   /**
	* 用户状态，2、监禁
	* @return String
	* @hibernate.property column="status" type="java.lang.String" length="2" not-null="false"
	*/
	@Column(name = "statusd", length = 2)
	public String getStatus() {
		return this.status;
	}

   /**
	* Set the status
	*/
	public void setStatus(String aValue) {
		this.status = aValue;
	}

   /**
	* 真实姓名
	* @return String
	* @hibernate.property column="true_name" type="java.lang.String" length="32" not-null="false"
	*/
	@Column(name = "true_name", length = 32)
	public String getTrueName() {
		return this.trueName;
	}

   /**
	* Set the trueName
	*/
	public void setTrueName(String aValue) {
		this.trueName = aValue;
	}

   /**
	* 注册时间
	* @return java.util.Date
	* @hibernate.property column="regist_time" type="java.util.Date" length="19" not-null="false"
	*/
	@Column(name = "regist_time", length = 19)
	public java.util.Date getRegistTime() {
		return this.registTime;
	}

   /**
	* Set the registTime
	*/
	public void setRegistTime(java.util.Date aValue) {
		this.registTime = aValue;
	}

   /**
	* 用户组
	* @return String
	* @hibernate.property column="user_group" type="java.lang.String" length="2" not-null="false"
	*/
	@Column(name = "user_group", length = 2)
	public String getUserGroup() {
		return this.userGroup;
	}

   /**
	* Set the userGroup
	*/
	public void setUserGroup(String aValue) {
		this.userGroup = aValue;
	}

   /**
	* 用户级别
	* @return String
	* @hibernate.property column="user_level" type="java.lang.String" length="2" not-null="false"
	*/
	@Column(name = "user_level", length = 2)
	public String getUserLevel() {
		return this.userLevel;
	}

   /**
	* Set the userLevel
	*/
	public void setUserLevel(String aValue) {
		this.userLevel = aValue;
	}

   /**
	* 头像
	* @return String
	* @hibernate.property column="photo" type="java.lang.String" length="32" not-null="false"
	*/
	@Column(name = "photo", length = 32)
	public String getPhoto() {
		return this.photo;
	}

   /**
	* Set the photo
	*/
	public void setPhoto(String aValue) {
		this.photo = aValue;
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof LemonUser)) {
			return false;
		}
		LemonUser rhs = (LemonUser) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.username, rhs.username)
		.append(this.password, rhs.password)
		.append(this.weixin, rhs.weixin)
		.append(this.cellPhone, rhs.cellPhone)
		.append(this.qq, rhs.qq)
		.append(this.email, rhs.email)
		.append(this.shenfen, rhs.shenfen)
		.append(this.status, rhs.status)
		.append(this.trueName, rhs.trueName)
		.append(this.registTime, rhs.registTime)
		.append(this.userGroup, rhs.userGroup)
		.append(this.userLevel, rhs.userLevel)
		.append(this.photo, rhs.photo)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.username) 
		.append(this.password) 
		.append(this.weixin) 
		.append(this.cellPhone) 
		.append(this.qq) 
		.append(this.email) 
		.append(this.shenfen) 
		.append(this.status) 
		.append(this.trueName) 
		.append(this.registTime) 
		.append(this.userGroup) 
		.append(this.userLevel) 
		.append(this.photo) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("username", this.username) 
		.append("password", this.password) 
		.append("weixin", this.weixin) 
		.append("cellPhone", this.cellPhone) 
		.append("qq", this.qq) 
		.append("email", this.email) 
		.append("shenfen", this.shenfen) 
		.append("status", this.status) 
		.append("trueName", this.trueName) 
		.append("registTime", this.registTime) 
		.append("userGroup", this.userGroup) 
		.append("userLevel", this.userLevel) 
		.append("photo", this.photo) 
		.toString();
	}
}
