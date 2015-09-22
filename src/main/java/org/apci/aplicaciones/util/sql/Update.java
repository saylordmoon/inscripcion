package org.apci.aplicaciones.util.sql;

import java.lang.reflect.Field;

import org.apci.aplicaciones.util.StringUtil;

public class Update extends Query{

	public <T> Update(Class<T> pClassType) {
		super(pClassType, "UPDATE %s SET %s %s;");
	}

	@Override
	protected <T> void generate(Class<T> pClassType) {
		
		StringBuilder sColumns = new StringBuilder();
		StringBuilder sWhere = new StringBuilder();
		
		Field[] classProperties = pClassType.getDeclaredFields();
		
		for (Field property : classProperties) {
			if (!this.getPrimaryKeyName().toLowerCase().equals(property.getName().toLowerCase()))	{
				sColumns.append(StringUtil.COMMA);
				sColumns.append(property.getName());
				sColumns.append(StringUtil.EQUALS);
				sColumns.append(StringUtil.STRING_PARAMETER);
			}
		}
		
		if ( sColumns.length() > 0 ) {
			sColumns.deleteCharAt(0);
		}
		
		this.columns = sColumns.toString();

		sWhere.append("WHERE");
		sWhere.append(StringUtil.SPACE);
		sWhere.append(this.getPrimaryKeyName());
		sWhere.append(StringUtil.EQUALS);
		sWhere.append(StringUtil.STRING_PARAMETER);
		
		this.where = sWhere.toString(); 
	}

	@Override
	public String getSql() 
	{
		return String.format(this.SQL, this.table, this.columns , this.where);
	}
	
	

}
