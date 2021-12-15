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
	    public boolean insert(Customer customer) {
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
			boolean rowInserted = false;

	        try {
	            connection = Factory.getConnection();
	            preparedStatement = connection.prepareStatement("INSERT INTO customers (name, address, postal, town) VALUES(?, ?, ?, ?);");
	            preparedStatement.setString(1, customer.getName());
	            preparedStatement.setString(2, customer.getAddress());
				preparedStatement.setString(3, customer.getTown());
				preparedStatement.setString(4, customer.getPostal());

	            rowInserted = preparedStatement.executeUpdate() > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
			return rowInserted;
	    }

		@Override
	    public boolean update(Customer customer) {
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
			boolean rowUpdated = false;

	        try {
	            connection = Factory.getConnection();
	            preparedStatement = connection.prepareStatement("UPDATE customers set name = ?, address = ?, postal = ?, town = ? WHERE id = ?;");
	            preparedStatement.setString(1, customer.getName());
	            preparedStatement.setString(2, customer.getAddress());
				preparedStatement.setString(3, customer.getTown());
				preparedStatement.setString(4, customer.getPostal());
				preparedStatement.setInt(5, customer.getId());

	            rowUpdated = preparedStatement.executeUpdate() > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
			return rowUpdated;

	    }

		@Override
	    public boolean delete(Customer customer) {
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
			boolean rowDeleted = false;

	        try {
	            connection = Factory.getConnection();
	            preparedStatement = connection.prepareStatement("DELETE FROM customers WHERE id = ?;");
				preparedStatement.setInt(1, customer.getId());
				rowDeleted = preparedStatement.executeUpdate() > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
			return rowDeleted;	
	    }
		@Override
	    public Customer getCustomer(int id) {
	        PreparedStatement preparedStatement = null;
			Connection connection = null;
	        ResultSet resultat = null;
			Customer customer = new Customer();

	        try {
	            connection = Factory.getConnection();
				preparedStatement = connection.prepareStatement("DELETE FROM customers WHERE id = ?;");
				preparedStatement.setInt(1, id);
	            resultat = preparedStatement.executeQuery();

	            if (resultat.next()) {
	                String name = resultat.getString("name");
					String address =  resultat.getString("address");
					String postal = resultat.getString("postal");
					String town = resultat.getString("town");

	                customer.setName(name);
					customer.setAddress(address);
					customer.setTown(town);
					customer.setPostal(postal);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
			return customer;

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
	            resultat = statement.executeQuery("SELECT id, name, address, town, postal FROM customers;");

	            while (resultat.next()) {
					Integer id = resultat.getInt("id");
	                String name = resultat.getString("name");
					String address =  resultat.getString("address");
					String postal = resultat.getString("postal");
					String town = resultat.getString("town");

	                Customer customer = new Customer();
					customer.setId(id);
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
