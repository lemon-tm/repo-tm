package com.lemon.constant.font.enums;

import com.lemon.constant.BaseEnum;

public enum IsCpsEnum implements BaseEnum<String>{
	CPS("CPS","1"),
	NOT_CPS("非CPS","2");
	private String label;
	private String value;
    private IsCpsEnum(String label,String value){
    	this.label = label;
    	this.value = value;
    }
	@Override
	public String getLabel() {
		return label;
	}
	@Override
	public String getValue() {
		return value;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public static IsCpsEnum getIsCpsEnumByValue(String value) {
		IsCpsEnum[] enums = IsCpsEnum.values();
		for (IsCpsEnum e : enums) {
			if (e.getValue().equals(value)){
				return e;
			}
		}
		return null;
	}
}
