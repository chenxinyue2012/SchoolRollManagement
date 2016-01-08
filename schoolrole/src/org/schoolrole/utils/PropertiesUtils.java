package org.schoolrole.utils;


import java.util.ResourceBundle;

public class PropertiesUtils {
	private static ResourceBundle rb 
		= ResourceBundle.getBundle("jdbc");
	
	public static String getValue(String key) {
		return rb.getString(key);
	}
}
