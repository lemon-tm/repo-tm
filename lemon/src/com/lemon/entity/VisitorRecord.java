package com.lemon.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * VisitorRecord (table = visitor_record)
 * 
 * TODO: add class/table comments
 */
@Entity
@Table(name = "visitor_record")
public class VisitorRecord extends BaseEntity {

	private String userId ;
	private String referer;//访问来源
	private String ip;//来访ip
	private String browser;//访客浏览器类型
	private String requestUrl ;//请求地址
	private java.util.Date visitTime;//来访时间
	private java.util.Date leaveTime;//离开时间
	
	@Column(name = "request_url", length = 250)
	public String getRequestUrl() {
		return requestUrl;
	}

	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}

	@Column(name = "user_id", length = 32)
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

/**
	* 访问来源
	* @return String
	* @hibernate.property column="referer" type="java.lang.String" length="250" not-null="false"
	*/
	@Column(name = "referer", length = 250)
	public String getReferer() {
		return this.referer;
	}

   /**
	* Set the referer
	*/
	public void setReferer(String aValue) {
		this.referer = aValue;
	}

   /**
	* 来访ip
	* @return String
	* @hibernate.property column="ip" type="java.lang.String" length="32" not-null="false"
	*/
	@Column(name = "ip", length = 32)
	public String getIp() {
		return this.ip;
	}

   /**
	* Set the ip
	*/
	public void setIp(String aValue) {
		this.ip = aValue;
	}

   /**
	* 访客浏览器类型
	* @return String
	* @hibernate.property column="browser" type="java.lang.String" length="250" not-null="false"
	*/
	@Column(name = "browser", length = 250)
	public String getBrowser() {
		return this.browser;
	}

   /**
	* Set the browser
	*/
	public void setBrowser(String aValue) {
		this.browser = aValue;
	}

   /**
	* 来访时间
	* @return java.util.Date
	* @hibernate.property column="visit_time" type="java.util.Date" length="19" not-null="false"
	*/
	@Column(name = "visit_time", length = 19)
	public java.util.Date getVisitTime() {
		return this.visitTime;
	}

   /**
	* Set the visitTime
	*/
	public void setVisitTime(java.util.Date aValue) {
		this.visitTime = aValue;
	}

   /**
	* 离开时间
	* @return java.util.Date
	* @hibernate.property column="leave_time" type="java.util.Date" length="19" not-null="false"
	*/
	@Column(name = "leave_time", length = 19)
	public java.util.Date getLeaveTime() {
		return this.leaveTime;
	}

   /**
	* Set the leaveTime
	*/
	public void setLeaveTime(java.util.Date aValue) {
		this.leaveTime = aValue;
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof VisitorRecord)) {
			return false;
		}
		VisitorRecord rhs = (VisitorRecord) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.referer, rhs.referer)
		.append(this.ip, rhs.ip)
		.append(this.browser, rhs.browser)
		.append(this.visitTime, rhs.visitTime)
		.append(this.leaveTime, rhs.leaveTime)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.referer) 
		.append(this.ip) 
		.append(this.browser) 
		.append(this.visitTime) 
		.append(this.leaveTime) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("referer", this.referer) 
		.append("ip", this.ip) 
		.append("browser", this.browser) 
		.append("visitTime", this.visitTime) 
		.append("leaveTime", this.leaveTime) 
		.toString();
	}
}
