package com.goyav.konbava.dao;

import java.util.List;

import com.goyav.konbava.model.User;

public interface UserDao {
	void insert(User user);
	List<User> getUsers();
	

}
