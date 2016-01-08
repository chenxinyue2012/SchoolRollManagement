package org.schoolrole.utils;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	private static SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
	
	public static Date parseDate(String dateStr) {
		try {
			return sd.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String formatDate(Date date) {
		return sd.format(date);
	}
	
	
	
	
	
}
