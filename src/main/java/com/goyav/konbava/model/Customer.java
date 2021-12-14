package com.goyav.konbava.model;

import java.util.Date;

public class Customer {
	private int Id;
	private String Name;
	private Double Account;
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String name, Double account) {
		super();
		Name = name;
		Account = account;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Double getAccount() {
		return Account;
	}
	public void setAccount(Double account) {
		Account = account;
	}
	
	
	

}
