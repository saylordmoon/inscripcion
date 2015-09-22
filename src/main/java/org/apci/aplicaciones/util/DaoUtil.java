package org.apci.aplicaciones.util;

import java.lang.reflect.Field;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apci.aplicaciones.util.sql.Query;

public class DaoUtil {
	
	private DaoUtil() {}
	
	public static <T> List<T> mapper(ResultSet pResultSet, Class<T> pClassType) throws Exception 
	{
		List<T> listResult = new ArrayList<>();
		
		Field[] classProperties = getAsAccessibleProperties(pClassType);
			
		while(pResultSet.next()){
			T classObject = pClassType.getConstructor().newInstance();
			
			for (Field property : classProperties) {
				Object objectValue = pResultSet.getObject(property.getName());
				property.set(classObject, objectValue);
			}
			listResult.add(classObject);
		}
		return listResult;
	}
	
	public static PreparedStatement setStatementParameters(PreparedStatement pStatement,Object[] pParameters) throws Exception
	{
		for (int i = 0; i < pParameters.length; i++) {
			pStatement.setObject(i+1, pParameters[i]);
		}
		return pStatement;
	}
	
	public static CallableStatement setStatementParameters(CallableStatement pStatement,Object[] pParameters) throws Exception
	{
		for (int i = 0; i < pParameters.length; i++) {
			pStatement.setObject(i+1, pParameters[i]);
		}
		return pStatement;
	}
	
	public static PreparedStatement setStatementParameters(PreparedStatement pStatement,Object pDataObject) throws Exception
	{
		return setStatementParameters(pStatement, pDataObject , false);
	}
	
	public static PreparedStatement setStatementParameters(PreparedStatement pStatement,Object pDataObject , boolean pIncludePrimaryKey) throws Exception
	{
		Class<?> classType = pDataObject.getClass();
		
		Field[] classProperties = getAsAccessibleProperties(classType);
		
		int paramIndex = 1;		
		
		for (Field property : classProperties) 
		{
			if ( !Query.getPrimaryKeyName(classType).toLowerCase().equals(property.getName().toLowerCase()) || pIncludePrimaryKey ){
				pStatement.setObject(paramIndex , property.get(pDataObject));
				paramIndex++;
			}
		}	
		return pStatement;
	}
	
	public static PreparedStatement setStatementPrimaryKeyParameter(PreparedStatement pStatement, Object pDataObject, int pParameterIndex) throws Exception
	{
		Class<?> classType = pDataObject.getClass();
		
		Field[] classProperties = getAsAccessibleProperties(classType);
		

		for (Field property : classProperties) 
		{
			if ( Query.getPrimaryKeyName(classType).toLowerCase().equals(property.getName().toLowerCase()) ){
				pStatement.setObject(pParameterIndex , property.get(pDataObject));
				break;
			}
		}	
		return pStatement;
	}
	
	public static PreparedStatement setStatementPrimaryKeyParameter(PreparedStatement pStatement, Object pDataObject) throws Exception
	{
		Class<?> classType = pDataObject.getClass();
		
		Field[] classProperties = getAsAccessibleProperties(classType);
		
		int primaryKeyIndex = classProperties.length;
		

		for (Field property : classProperties) 
		{
			if ( Query.getPrimaryKeyName(classType).toLowerCase().equals(property.getName().toLowerCase()) ){
				pStatement.setObject(primaryKeyIndex , property.get(pDataObject));
				break;
			}
		}	
		return pStatement;
	}
	
	private static <T> Field[] getAsAccessibleProperties(Class<T> pClassType)
	{
		Field[] classProperties = pClassType.getDeclaredFields();
		
		for (Field property : classProperties) {
			property.setAccessible(true);
		}
		return classProperties;
	}
	
}
