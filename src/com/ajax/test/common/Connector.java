package com.ajax.test.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String ID = "test";
	private static final String PWD = "test";
	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	
	
	static {
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection con() {
		try {
			Connection con = DriverManager.getConnection(URL,ID,PWD);
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
public static void main(String[] args) {
	Connection con = Connector.con();
	System.out.println("완료");
	
}
}
