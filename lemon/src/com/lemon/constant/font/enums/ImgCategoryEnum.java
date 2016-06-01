package com.lemon.constant.font.enums;

import com.lemon.constant.BaseEnum;


public enum ImgCategoryEnum implements BaseEnum<Integer> {
	SCENERY("风景",1),
	CHARACTER("人物",2),
	SHIWU("实物",3),
	CHUANGZUO("创作",4);
	
	private String label;
	private Integer value;
	private ImgCategoryEnum(String label,Integer value){
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
	
	public static ImgCategoryEnum getImgCategoryEnum(Integer value) {
		ImgCategoryEnum[] enums = ImgCategoryEnum.values();
		for (ImgCategoryEnum e : enums) {
			if (e.getValue().equals(value)) {
				return e;
			}
		}
		return null;
	}

		
}
