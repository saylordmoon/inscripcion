package org.apci.aplicaciones.util;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {
	
	public static final String ID = "Id";
	public static final String EMPTY = "";
	public static final String COMMA = ",";
	public static final String EQUALS = " = ";
	public static final String WHERE = "WHERE";
	public static final String SPACE = " ";
	public static final String LIKE = "LIKE";
	public static final String AND = "AND";
	public static final String IN = "IN";
	public static final String PORCENTAJE = "%";
	public static final String STRING_PARAMETER = "?";
	public static final String OPEN_BRACKETS = "[";
	public static final String CLOSE_BRACKETS = "]";
	public static final String OPEN_PARENTHESIS = "(";
	public static final String CLOSE_PARENTHESIS = ")";
	public static final String BACK_SLASH = "/";
	public static final String QUOTE = "\"";
	
	public static String wrap(String pValue, String pWrap)
	{
		StringBuilder result = new StringBuilder();
		result.append(pWrap);
		result.append(pValue);
		result.append(pWrap);
		return result.toString();
	}
	
	public static String wrapPorcentaje(String pValue)
	{
		return wrap(pValue, StringUtil.PORCENTAJE);
	}
	
	public static List<Integer> toIntArray(String pStringArray)
	{
		List<Integer> result = null;
		
		if (pStringArray != null & !pStringArray.equals(EMPTY))
		{
			result = new ArrayList<Integer>();
			pStringArray = pStringArray.replace(BACK_SLASH,EMPTY).replace(OPEN_BRACKETS,EMPTY).replace(CLOSE_BRACKETS,EMPTY).replace(QUOTE, EMPTY);
			
			for( String item : pStringArray.split(COMMA) )
			{
				result.add(Integer.parseInt(item));
			}
		}	
		return result;
	}
}
