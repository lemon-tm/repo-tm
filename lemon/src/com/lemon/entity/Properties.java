package com.lemon.entity;


import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/**
 * Properties (table = properties)
 * 
 * TODO: add class/table comments
 */
@Entity
@Table(name = "properties")
public class Properties extends BaseEntity {

	private String webTitle;//
	private String webKeywords;//
	private String webDescription;//

   /**
	* 
	* @return String
	* @hibernate.property column="web_title" type="java.lang.String" length="65535" not-null="false"
	*/
	@Column(name = "web_title", length = 65535)
	public String getWebTitle() {
		return this.webTitle;
	}

   /**
	* Set the webTitle
	*/
	public void setWebTitle(String aValue) {
		this.webTitle = aValue;
	}

   /**
	* 
	* @return String
	* @hibernate.property column="web_keywords" type="java.lang.String" length="65535" not-null="false"
	*/
	@Column(name = "web_keywords", length = 65535)
	public String getWebKeywords() {
		return this.webKeywords;
	}

   /**
	* Set the webKeywords
	*/
	public void setWebKeywords(String aValue) {
		this.webKeywords = aValue;
	}

   /**
	* 
	* @return String
	* @hibernate.property column="web_description" type="java.lang.String" length="65535" not-null="false"
	*/
	@Column(name = "web_description", length = 65535)
	public String getWebDescription() {
		return this.webDescription;
	}

   /**
	* Set the webDescription
	*/
	public void setWebDescription(String aValue) {
		this.webDescription = aValue;
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof Properties)) {
			return false;
		}
		Properties rhs = (Properties) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.webTitle, rhs.webTitle)
		.append(this.webKeywords, rhs.webKeywords)
		.append(this.webDescription, rhs.webDescription)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.webTitle) 
		.append(this.webKeywords) 
		.append(this.webDescription) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("webTitle", this.webTitle) 
		.append("webKeywords", this.webKeywords) 
		.append("webDescription", this.webDescription) 
		.toString();
	}
}
