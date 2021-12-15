package com.goyav.konbava.model;

import java.util.Date;

public class User {
	private int Id;
	private String Username;
	private String Password;
	private String Email;


	public User() {
	}

	public User( String Username, String Password, String Email) {
		this.Username = Username;
		this.Password = Password;
		this.Email = Email;
	}

	public int getId() {
		return this.Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public String getUsername() {
		return this.Username;
	}

	public void setUsername(String Username) {
		this.Username = Username;
	}

	public String getPassword() {
		return this.Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}

	public String getEmail() {
		return this.Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}
	

}
