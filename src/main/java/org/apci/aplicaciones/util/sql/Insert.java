package org.apci.aplicaciones.util.sql;

import java.lang.reflect.Field;

import org.apci.aplicaciones.util.StringUtil;

public class Insert extends Query {
	
	public <T> Insert(Class<T> pClassType)
	{
		super(pClassType, "INSERT INTO %s (%s) VALUES (%s);");
	}
	
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	public String getColumns() {
		return columns;
	}
	public void setColumns(String columns) {
		this.columns = columns;
	}
	public String getValues() {
		return values;
	}
	public void setValues(String values) {
		this.values = values;
	}
	
	@Override
	public String getSql() {
		return String.format(this.SQL, this.table, this.columns, this.values);
	}
	
	@Override
	protected <T> void generate(Class<T> pClassType)
	{
		StringBuilder sColumns = new StringBuilder();
		StringBuilder sValues = new StringBuilder();
		
		Field[] classProperties = pClassType.getDeclaredFields();
		
		for (Field property : classProperties) {
			if (!this.getPrimaryKeyName().toLowerCase().equals(property.getName().toLowerCase()))	{
				sColumns.append(StringUtil.COMMA);
				sColumns.append(property.getName());
				sValues.append(StringUtil.COMMA);
				sValues.append(StringUtil.STRING_PARAMETER);
			}
		}
		
		if ( sColumns.length() > 0 ) {
			sColumns.deleteCharAt(0);
		}
		
		if ( sValues.length() > 0 )	{
			sValues.deleteCharAt(0);
		}
		
		this.columns = sColumns.toString();
		this.values = sValues.toString();
	}

}
