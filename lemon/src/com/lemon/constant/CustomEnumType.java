package com.lemon.constant;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.lang.ClassUtils;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.type.TypeResolver;
import org.hibernate.usertype.ParameterizedType;
import org.hibernate.usertype.UserType;

public class CustomEnumType implements UserType,ParameterizedType {
	public static final String  Type = "com.lemon.constant.CustomEnumType";
    private Class<? extends BaseEnum<?>> clazz;
    private AbstractSingleColumnStandardBasicType sqlType;
    
    public CustomEnumType(){
    }
    
    public CustomEnumType(String className){
    	initSqlType(className);
    }
	@Override
	public void setParameterValues(Properties properties) {
		initSqlType(properties.getProperty("enum"));
	}
    private void initSqlType(String className){
    	try {
			clazz = (Class<? extends BaseEnum<?>>)ClassUtils.getClass(className);
		    Method getValueMethod = clazz.getMethod("getValue", new Class[]{});
		    sqlType = (AbstractSingleColumnStandardBasicType) new TypeResolver().basic(getValueMethod.getReturnType().getName());
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
	@Override
	public Object assemble(Serializable cached, Object owner)
			throws HibernateException {
		return cached;
	}

	@Override
	public Object deepCopy(Object o) throws HibernateException {
		return o;
	}

	@Override
	public Serializable disassemble(Object o) throws HibernateException {
		return (Serializable)o;
	}

	@Override
	public boolean equals(Object x, Object y) throws HibernateException {
		return x == y;
	}

	@Override
	public int hashCode(Object o) throws HibernateException {
		return o.hashCode();
	}

	@Override
	public boolean isMutable() {
		return false;
	}
	@Override
	public Object nullSafeGet(ResultSet rs, String[] names,
			SessionImplementor sessionimplementor, Object ower)
			throws HibernateException, SQLException {
		Object value = sqlType.get(rs, names[0],sessionimplementor);
		BaseEnum<?>[] enums = clazz.getEnumConstants();
		for(BaseEnum<?> e :enums){
			if(e.getValue().equals(value)){
				return e;
			}
		}
		return null;
	}
	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor sessionimplementor)
			throws HibernateException, SQLException {
		if(value==null){
			sqlType.set(st, null, index, sessionimplementor);
		}else{
			sqlType.set(st, ((BaseEnum)value).getValue(), index, sessionimplementor);
		}
		
	}

	@Override
	public Object replace(Object original, Object target, Object owner)
			throws HibernateException {
		return original;
	}

	@Override
	public Class returnedClass() {
		return clazz;
	}

	@Override
	public int[] sqlTypes() {
		return new int[] { sqlType.sqlType() };
	}

	

	

	
}
