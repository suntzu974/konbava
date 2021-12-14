package com.goyav.konbava.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Factory {
	private static String url;
	private static String user;
	private static String password;

	public Factory(String url) {
		super();
		this.url = url;
	}

	public Factory(String url,String user, String password) {
		super();
		Factory.url = url;
		Factory.user = user;
		Factory.password = password;
	}
	
	public static String getUrl() {
		return url;
	}

	public static void setUrl(String url) {
		Factory.url = url;
	}

	public static String getUser() {
		return user;
	}

	public static void setUser(String user) {
		Factory.user = user;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		Factory.password = password;
	}

	public static Factory getInstance() {
		try {
			Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
			
		}
/*		String host = System.getenv("JDBC_POSTGRES_URL");
		String user = System.getenv("PG_USER");
		String password = System.getenv("PG_PASSWORD");*/

//		Factory instance = new Factory (host/*,user,password*/);
		Factory instance = new Factory ("jdbc:postgresql://localhost:5432/moinlela?user=suntzu974&password=HpNKUsNN27031968&ssl=true;");
		return instance;
	}
	public static Connection getConnection() throws SQLException  {
/*		Properties props = new Properties();
		String host = System.getenv("JDBC_POSTGRES_URL");
		String user = System.getenv("PG_USER");
		String password = System.getenv("PG_PASSWORD");

		
		props.setProperty("user",user);
		props.setProperty("password",password);
		props.setProperty("ssl","true");*/

			return DriverManager.getConnection(url);
	}
	public CustomerDao getCustomerDao() {
		return new CustomerDaoImpl(this);
	}
	public UserDao getUserDao() {
		return new UserDaoImpl(this);
	}
}
