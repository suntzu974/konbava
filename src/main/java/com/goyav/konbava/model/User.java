package com.goyav.konbava.model;

import java.util.Date;

public class User {
	private int Id;
	private String Name;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String name) {
		super();
		Name = name;
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

}
