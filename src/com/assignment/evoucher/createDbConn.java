package com.assignment.evoucher;

import java.sql.Connection;
import java.sql.DriverManager;

public class createDbConn implements dbParams{
	static Connection con = null;
	
	public static Connection getCon() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(connUrl,username,password);
		}catch(Exception e) {
			System.out.println(e);
		}
		return con;
	}
}
