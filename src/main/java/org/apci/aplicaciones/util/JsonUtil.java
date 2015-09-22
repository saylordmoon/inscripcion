package org.apci.aplicaciones.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	
	private JsonUtil() {}
	
	public static <T> Object mapJsonToClass(String pJson,Class<T> pClassType) {
		
		ObjectMapper mapper = new ObjectMapper();
		T classObject = null;
		try 
		{
			classObject = mapper.readValue(pJson, pClassType);
		} 
		catch (JsonParseException e) 
		{
			e.printStackTrace();
		} 
		catch (JsonMappingException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

		return classObject;
	}

}
