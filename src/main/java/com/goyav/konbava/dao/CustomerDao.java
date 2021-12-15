package com.goyav.konbava.dao;

import java.util.List;

import com.goyav.konbava.model.Customer;

public interface CustomerDao {
	void insert(Customer customer);
	void update(Customer customer);
	void delete(Customer customer);
	List<Customer> getCustomers();
	

}
