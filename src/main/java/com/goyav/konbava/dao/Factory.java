package com.goyav.konbava.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Factory {
	private static String url;

	public Factory(String url) {
		super();
		this.url = url;
	}
	public static Factory getInstance() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			
		}
		Factory instance = new Factory ("jdbc:postgresql://localhost:5432/moinlela?user=suntzu974&password=HpNKUsNN27031968&ssl=true;");
		return instance;
	}
	public static Connection getConnection() throws SQLException  {
			return DriverManager.getConnection(url);
	}
	public CustomerDao getCustomerDao() {
		return new CustomerDaoImpl(this);
	}
}
