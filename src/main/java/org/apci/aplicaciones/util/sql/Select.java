package org.apci.aplicaciones.util.sql;

import java.lang.reflect.Field;

import org.apci.aplicaciones.util.StringUtil;

public class Select extends Query{

	public <T> Select(Class<T> pClassType) 
	{
		super(pClassType, Query.SELECT);
	}
	
	public Select(String pTable,String...pColumns){
		super(Query.SELECT);
		this.table = pTable;
		this.columns = String.join(",", pColumns);
	}
	
	@Override
	protected <T> void generate(Class<T> pClassType) 
	{
		StringBuilder sColumns = new StringBuilder();
				
		Field[] classProperties = pClassType.getDeclaredFields();
		
		for (Field property : classProperties) {
				sColumns.append(StringUtil.COMMA);
				sColumns.append(property.getName());
		}
		
		if ( sColumns.length() > 0 ) {
			sColumns.deleteCharAt(0);
		}
		
		this.columns = sColumns.toString();
	}

	@Override
	public String getSql() 
	{
		return String.format(this.SQL, this.columns, this.table , this.where);
	}
	
}
