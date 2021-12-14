package com.goyav.konbava.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.goyav.konbava.model.Customer;

public class CustomerDaoImpl implements CustomerDao {
	private Factory factory;
	CustomerDaoImpl(Factory factory) {
		this.factory = factory;
	}
	 @Override
	    public void insert(Customer customer) {
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;

	        try {
	            connection = Factory.getConnection();
	            preparedStatement = connection.prepareStatement("INSERT INTO products(name, account) VALUES(?, ?);");
	            preparedStatement.setString(1, customer.getName());
	            preparedStatement.setDouble(2, customer.getAccount());

	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	    }

	    @Override
	    public List<Customer> getCustomers() {
	        List<Customer> customers = new ArrayList<Customer>();
	        Connection connection = null;
	        Statement statement = null;
	        ResultSet resultat = null;

	        try {
	            connection = Factory.getConnection();
	            statement = connection.createStatement();
	            resultat = statement.executeQuery("SELECT name, account FROM products;");

	            while (resultat.next()) {
	                String name = resultat.getString("name");
	                Double account = resultat.getDouble("account");

	                Customer customer = new Customer();
	                customer.setName(name);
	                customer.setAccount(account);

	                customers.add(customer);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return customers;
	    }
}
