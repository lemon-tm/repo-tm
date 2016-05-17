package com.lemon.constant.font.enums;

import com.lemon.constant.BaseEnum;


public enum ImgStatusEnum implements BaseEnum<Integer> {
	op("公开",1),
	de("删除",2);
	
	private String label;
	private Integer value;
	private ImgStatusEnum(String label,Integer value){
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
	
	public static ImgStatusEnum getImgStatusEnum(Integer value) {
		ImgStatusEnum[] enums = ImgStatusEnum.values();
		for (ImgStatusEnum e : enums) {
			if (e.getValue().equals(value)) {
				return e;
			}
		}
		return null;
	}

		
}
