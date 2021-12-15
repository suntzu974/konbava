package com.goyav.konbava.model;

import java.util.Date;

public class Customer {
	private int Id;
	private String Name;
	private String Address;
	private String Postal;
	private String Town;
	

	public Customer() {
		super();
	}


	public Customer( Integer Id, String Name, String Address, String Postal, String Town) {
		super();
		this.Id = Id;
		this.Name = Name;
		this.Address = Address;
		this.Postal = Postal;
		this.Town = Town;
	}

	public Customer( String Name, String Address, String Postal, String Town) {
		super();
		this.Name = Name;
		this.Address = Address;
		this.Postal = Postal;
		this.Town = Town;
	}

	public int getId() {
		return this.Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public String getName() {
		return this.Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getAddress() {
		return this.Address;
	}

	public void setAddress(String Address) {
		this.Address = Address;
	}

	public String getPostal() {
		return this.Postal;
	}

	public void setPostal(String Postal) {
		this.Postal = Postal;
	}

	public String getTown() {
		return this.Town;
	}

	public void setTown(String Town) {
		this.Town = Town;
	}
	

}
