package com.goyav.konbava.dao;

import java.util.List;

import com.goyav.konbava.model.Customer;

public interface CustomerDao {
	boolean insert(Customer customer);
	boolean update(Customer customer);
	boolean delete(int id);
	Customer getCustomer(int id); 
	List<Customer> getCustomers();
	

}
