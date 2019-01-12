package com.ranjit;

import java.sql.Connection;

public class MainCallingConnection {

	public static void main(String[] args) {
		JDBCConnectionPool pool = new JDBCConnectionPool(
				"com.mysql.jdbc.Driver",
				"jdbc:mysql://localhost:3306/bot_platform_tele", "root", "sense1");
		
		Connection connection = pool.checkout();
		
		System.out.println("using connection");
		
		pool.checkIn(connection);
	}
}
