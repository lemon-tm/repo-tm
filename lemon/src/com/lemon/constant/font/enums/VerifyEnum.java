package com.lemon.constant.font.enums;

import com.lemon.constant.BaseEnum;


public enum VerifyEnum implements BaseEnum<Integer> {
	WAIT("等待审核",2),
	YES("审核通过",1),
	NO("审核不通过",0);
	
	private String label;
	private Integer value;
	private VerifyEnum(String label,Integer value){
		this.label = label;
		this.value = value;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	
	public static VerifyEnum getVerifyEnum(Integer value) {
		VerifyEnum[] enums = VerifyEnum.values();
		for (VerifyEnum e : enums) {
			if (e.getValue().equals(value)) {
				return e;
			}
		}
		return null;
	}

		
}
