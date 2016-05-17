package com.lemon.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import com.lemon.constant.font.enums.MsgStatesEnum;

/**
 * Message (table = message)
 * 
 * TODO: add class/table comments
 */
@Entity
@Table(name = "message")
public class Message extends BaseEntity {

	

	private String title;//
	private String content;//
	private MsgStatesEnum states ;
	private String userId ;
	private Date createTime ;
	private Date readTime ; 
	private Date replayTime ;
	
	@Column(name = "create_time", length = 50)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Column(name = "read_time", length = 50)
	public Date getReadTime() {
		return readTime;
	}

	public void setReadTime(Date readTime) {
		this.readTime = readTime;
	}
	@Column(name = "replay_time", length = 50)
	public Date getReplayTime() {
		return replayTime;
	}

	public void setReplayTime(Date replayTime) {
		this.replayTime = replayTime;
	}

	@Column(name = "user_id", length = 50)
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "states", length = 50)
	@Type(type = "com.lemon.constant.CustomEnumType", parameters = {@Parameter(name = "enum", value = "com.lemon.constant.font.enums.MsgStatesEnum")})
	public MsgStatesEnum getStates() {
		return states;
	}

	public void setStates(MsgStatesEnum states) {
		this.states = states;
	}
   /**
	* 
	* @return String
	* @hibernate.property column="title" type="java.lang.String" length="50" not-null="false"
	*/
	@Column(name = "title", length = 50)
	public String getTitle() {
		return this.title;
	}

   /**
	* Set the title
	*/
	public void setTitle(String aValue) {
		this.title = aValue;
	}

   /**
	* 
	* @return String
	* @hibernate.property column="content" type="java.lang.String" length="250" not-null="false"
	*/
	@Column(name = "content", length = 250)
	public String getContent() {
		return this.content;
	}

   /**
	* Set the content
	*/
	public void setContent(String aValue) {
		this.content = aValue;
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof Message)) {
			return false;
		}
		Message rhs = (Message) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.title, rhs.title)
		.append(this.content, rhs.content)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.title) 
		.append(this.content) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("title", this.title) 
		.append("content", this.content) 
		.toString();
	}
}
