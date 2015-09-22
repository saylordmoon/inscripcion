package org.apci.aplicaciones.util.sql;

import org.apci.aplicaciones.util.StringUtil;

public class Call {
	
	private final String SQL = "{call %s (%s)}";
	
	private String storedProcedure;
	private String values;
	
	public <T> Call(String pStoredProcedure,Object...pParameters){
		this.storedProcedure = pStoredProcedure;
		generate(pParameters);
	}
	
	protected <T> void generate(Object[] pParameters) {
		StringBuilder sValues =  new StringBuilder();
			
		for (int i=0; i < pParameters.length ; i++)	{
				sValues.append(StringUtil.COMMA);
				sValues.append(StringUtil.STRING_PARAMETER);
		}
		
		if ( sValues.length() > 0 )	{
			sValues.deleteCharAt(0);
		}
		this.values = sValues.toString();
	}

	public String getSql() 
	{
		return String.format(this.SQL, this.storedProcedure, this.values);
	}

}
