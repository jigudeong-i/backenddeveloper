package com.mvc.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static final String JDBC_URL = "jdbc:oracle:thin:@127.0.0.1:1521/xepdb1";
	private static final String USER = "javauser";
	private static final String PASSWD = "java1234";
	
	static {     // 정적static 쓸때 : 공유란 의미 포함. jdbc드라이버를 한번만 실행하고 계속 활용하겠다.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");     
		}catch(ClassNotFoundException e) {
			throw new RuntimeException("Oracle 드라이버 로딩 실패", e);
		}
	}
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(JDBC_URL, USER, PASSWD);
	}
}
