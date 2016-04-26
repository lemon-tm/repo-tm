package com.lemon.constant;


import java.io.Serializable;

public interface BaseEnum<T> extends Serializable{
   public String getLabel();
   public T getValue();
}
