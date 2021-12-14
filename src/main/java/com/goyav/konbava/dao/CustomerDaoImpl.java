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
	            preparedStatement = connection.prepareStatement("INSERT INTO customers (name, address, postal, town) VALUES(?, ?, ?, ?);");
	            preparedStatement.setString(1, customer.getName());
	            preparedStatement.setString(2, customer.getAddress());
				preparedStatement.setString(3, customer.getTown());
				preparedStatement.setString(4, customer.getPostal());

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
	            resultat = statement.executeQuery("SELECT name, address, town, postal FROM customers;");

	            while (resultat.next()) {
	                String name = resultat.getString("name");
					String address =  resultat.getString("address");
					String postal = resultat.getString("postal");
					String town = resultat.getString("town");

	                Customer customer = new Customer();
	                customer.setName(name);
					customer.setAddress(address);
					customer.setTown(town);
					customer.setPostal(postal);

	                customers.add(customer);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return customers;
	    }
}
