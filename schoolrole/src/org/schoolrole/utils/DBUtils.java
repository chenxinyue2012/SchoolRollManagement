package org.schoolrole.utils;



import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {
	private static final String URL = PropertiesUtils.getValue("jdbc.url");
	private static final String DRIVER = PropertiesUtils
			.getValue("jdbc.driver");
	private static final String USERNAME = PropertiesUtils
			.getValue("jdbc.username");
	private static final String PASSWD = PropertiesUtils
			.getValue("jdbc.password");

	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USERNAME, PASSWD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
