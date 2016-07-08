package com.lemon.entity;


import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * ForbiddenIp (table = forbidden_ip)
 * 
 * 禁用ip
 */
@Entity
@Table(name = "forbidden_ip")
public class ForbiddenIp extends BaseEntity {


	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof ForbiddenIp)) {
			return false;
		}
		ForbiddenIp rhs = (ForbiddenIp) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.toString();
	}
}
