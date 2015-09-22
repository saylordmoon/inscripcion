package org.apci.aplicaciones.util.sql;

import org.apci.aplicaciones.util.StringUtil;

public abstract class Query {
	
	public static final String SELECT = "SELECT %s FROM %s %s;";
	
	protected final String SQL;
	
	protected String table;
	protected String columns;
	protected String values;
	protected String where;
	protected String primaryKey;
	
	public Query(String pSQL)
	{
		this.table = "";
		this.columns = "";
		this.values = "";
		this.where = "";
		this.SQL = pSQL;
	}
	
	public <T> Query(Class<T> pClassType, String pSQL)
	{
		this(pSQL);
		this.table = pClassType.getSimpleName();
		this.generate(pClassType);
		this.primaryKey = Query.getPrimaryKeyName(pClassType);
	}
	
	public static <T> String getPrimaryKeyName(Class<T> pClassType) {
		return pClassType.getSimpleName().concat(StringUtil.ID);
	}
	
	public String getPrimaryKeyName(){
		return table.concat(StringUtil.ID);
	}
	
	protected abstract <T> void generate(Class<T> pClassType);
	
	public abstract String getSql();
	
	public void wherePrimaryKey()
	{
		this.where(this.primaryKey);
	}
	
	public void where(String pColumn)
	{
		StringBuilder sWhere = new StringBuilder();
		sWhere.append(StringUtil.WHERE);
		sWhere.append(StringUtil.SPACE);
		sWhere.append(pColumn);
		sWhere.append(StringUtil.EQUALS);
		sWhere.append(StringUtil.STRING_PARAMETER);
		this.where =sWhere.toString();
	}
	
	public void whereLike(String pColumn)
	{
		StringBuilder sWhere = new StringBuilder();
		sWhere.append(StringUtil.WHERE);
		sWhere.append(StringUtil.SPACE);
		sWhere.append(pColumn);
		sWhere.append(StringUtil.SPACE);
		sWhere.append(StringUtil.LIKE);
		sWhere.append(StringUtil.SPACE);
		sWhere.append(StringUtil.STRING_PARAMETER);
		this.where =sWhere.toString();
	}
	
	public void whereIn(String pColumn,Select pSelect)
	{
		StringBuilder sWhere = new StringBuilder();
		sWhere.append(StringUtil.WHERE);
		sWhere.append(StringUtil.SPACE);
		sWhere.append(pColumn);
		sWhere.append(StringUtil.SPACE);
		sWhere.append(StringUtil.IN);
		sWhere.append(StringUtil.SPACE);
		sWhere.append(StringUtil.OPEN_PARENTHESIS);
		sWhere.append(pSelect.getSql());
		sWhere.append(StringUtil.CLOSE_PARENTHESIS);
		this.where = sWhere.toString();
	}
	
	public void and(String pColumn)
	{
		StringBuilder sWhere = new StringBuilder();
		sWhere.append(this.where);
		sWhere.append(StringUtil.SPACE);
		sWhere.append(StringUtil.AND);
		sWhere.append(StringUtil.SPACE);
		sWhere.append(pColumn);
		sWhere.append(StringUtil.EQUALS);
		sWhere.append(StringUtil.STRING_PARAMETER);
		this.where = sWhere.toString();
	}
	

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}
	
}