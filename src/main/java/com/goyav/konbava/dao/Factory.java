package com.goyav.konbava.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Factory {
	private static String url;
	private static String user;
	private static String password;

	public Factory(String url,String user, String password) {
		super();
		this.url = url;
		this.user = user;
		this.password = password;
	}
	public static Factory getInstance() {
		try {
			Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
			
		}
		String host = System.getenv("JDBC_POSTGRES_URL");
		String user = System.getenv("PG_USER");
		String password = System.getenv("PG_PASSWORD");

		Factory instance = new Factory (host,user,password);
		return instance;
	}
	public static Connection getConnection() throws SQLException  {
		Properties props = new Properties();
		
		props.setProperty("user",user);
		props.setProperty("password",password);
		props.setProperty("ssl","true");

			return DriverManager.getConnection(url,props);
	}
	public CustomerDao getCustomerDao() {
		return new CustomerDaoImpl(this);
	}
	public UserDao getUserDao() {
		return new UserDaoImpl(this);
	}
}
