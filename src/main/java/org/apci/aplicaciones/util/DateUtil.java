package org.apci.aplicaciones.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	public static String today(String pFormat)
	{
		DateFormat dateFormat = new SimpleDateFormat(pFormat);
		Date today = Calendar.getInstance().getTime();        
		return dateFormat.format(today);
	}
	
	public static String today()
	{
		return today("dd/MM/yyyy");
	}
	
	public static  Date  toDate(String pDate){
		return null;
	}
	
	public static Timestamp getToday()
	{
		java.util.Date date= new java.util.Date();
		return new Timestamp(date.getTime());
	}
	
}
