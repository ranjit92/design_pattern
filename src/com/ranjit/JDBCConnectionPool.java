package com.ranjit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionPool extends ObjectPool<Connection> {
	
	private String connectionString, user, pwd;
	
	

	public JDBCConnectionPool(String driver, String connectionString, String user, String pwd) {
		super();
		try{
			Class.forName(driver).newInstance();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		this.connectionString = connectionString;
		this.user = user;
		this.pwd = pwd;
	}

	@Override
	protected Connection create() {
		try{
			return DriverManager.getConnection(connectionString, user, pwd);
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean validate(Connection t) {
		try {
			return !(t.isClosed());
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void expire(Connection t) {
		try {
			t.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
