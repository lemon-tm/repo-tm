package com.lemon.constant.font.enums;

import com.lemon.constant.BaseEnum;


public enum MsgStatesEnum implements BaseEnum<Integer> {
	WAIT("未读",0),
	READ("已读",1),
	REPLY("已回复",2);
	
	private String label;
	private Integer value;
	private MsgStatesEnum(String label,Integer value){
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
	
	public static MsgStatesEnum getMsgStatesEnum(Integer value) {
		MsgStatesEnum[] enums = MsgStatesEnum.values();
		for (MsgStatesEnum e : enums) {
			if (e.getValue().equals(value)) {
				return e;
			}
		}
		return null;
	}

		
}
