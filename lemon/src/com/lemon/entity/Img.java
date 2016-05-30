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
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import com.lemon.common.bean.ImageBean;
import com.lemon.constant.font.enums.VerifyEnum;

/**
 * Img (table = img)
 * 
 * TODO: add class/table comments
 */
@Entity
@Table(name = "img")
public class Img extends BaseEntity {

	private String relationId;//
	private String imgUrl;//
	private VerifyEnum isverify;//
	private java.util.Date verifyTime;//
	
	private List<ImageBean> imgurlb ;
	
	@Transient
	public List<ImageBean> getImgurlb() {
		if (StringUtils.isEmpty(imgUrl)) {
			return null;
		}
		try {
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.setRootClass(ImageBean.class);
			JSONArray jsonArray = JSONArray.fromObject(imgUrl);
			return (List<ImageBean>) JSONSerializer.toJava(jsonArray, jsonConfig);
		} catch (Exception e) {
			return null;
		}
	}

	public void setImgurlb(List<ImageBean> imgurlb) {
		if (imgurlb == null || imgurlb.size() == 0) {
			imgUrl = null;
			return;
		}
		Collections.sort(imgurlb);
		JSONArray jsonArray = JSONArray.fromObject(imgurlb);
		imgUrl = jsonArray.toString() ;
		this.imgurlb = imgurlb;
	}
   /**
	* 
	* @return String
	* @hibernate.property column="relation_id" type="java.lang.String" length="32" not-null="true"
	*/
	@Column(name = "relation_id", length = 32)
	public String getRelationId() {
		return this.relationId;
	}

   /**
	* Set the relationId
	*/
	public void setRelationId(String aValue) {
		this.relationId = aValue;
	}

   /**
	* 
	* @return String
	* @hibernate.property column="img_url" type="java.lang.String" length="300" not-null="false"
	*/
	@Column(name = "img_url", length = 300)
	public String getImgUrl() {
		return this.imgUrl;
	}

   /**
	* Set the imgUrl
	*/
	public void setImgUrl(String aValue) {
		this.imgUrl = aValue;
	}

   /**
	* 
	* @return Integer
	* @hibernate.property column="isverify" type="java.lang.Integer" length="10" not-null="false"
	*/
	@Column(name = "isverify")
	@Type(type = "com.lemon.constant.CustomEnumType", parameters = {@Parameter(name = "enum", value = "com.lemon.constant.font.enums.VerifyEnum")})
	public VerifyEnum getIsverify() {
		return isverify;
	}

	public void setIsverify(VerifyEnum isverify) {
		this.isverify = isverify;
	}

   /**
	* 
	* @return java.util.Date
	* @hibernate.property column="verify_time" type="java.util.Date" length="19" not-null="false"
	*/
	@Column(name = "verify_time", length = 19)
	public java.util.Date getVerifyTime() {
		return this.verifyTime;
	}

   /**
	* Set the verifyTime
	*/
	public void setVerifyTime(java.util.Date aValue) {
		this.verifyTime = aValue;
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof Img)) {
			return false;
		}
		Img rhs = (Img) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.relationId, rhs.relationId)
		.append(this.imgUrl, rhs.imgUrl)
		.append(this.isverify, rhs.isverify)
		.append(this.verifyTime, rhs.verifyTime)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.relationId) 
		.append(this.imgUrl) 
		.append(this.isverify) 
		.append(this.verifyTime) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("relationId", this.relationId) 
		.append("imgUrl", this.imgUrl) 
		.append("isverify", this.isverify) 
		.append("verifyTime", this.verifyTime) 
		.toString();
	}
}
