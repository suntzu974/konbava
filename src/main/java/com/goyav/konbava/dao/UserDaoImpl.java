package com.goyav.konbava.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.goyav.konbava.model.User;

public class UserDaoImpl implements UserDao {
	private Factory factory;
	UserDaoImpl(Factory factory) {
		this.factory = factory;
	}
	 @Override
	    public void insert(User user) {
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;

	        try {
	            connection = Factory.getConnection();
	            preparedStatement = connection.prepareStatement("INSERT INTO users (username,email,password) VALUES(?,?,?);");
	            preparedStatement.setString(1, user.getUsername());
	            preparedStatement.setString(2, user.getEmail());
	            preparedStatement.setString(3, user.getPassword());

	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	    }

	    @Override
	    public List<User> getUsers() {
	        List<User> users = new ArrayList<User>();
	        Connection connection = null;
	        Statement statement = null;
	        ResultSet resultat = null;

	        try {
	            connection = Factory.getConnection();
	            statement = connection.createStatement();
	            resultat = statement.executeQuery("SELECT username,email,password FROM users;");

	            while (resultat.next()) {
	                String username = resultat.getString("username");
	                String email = resultat.getString("email");
	                String password = resultat.getString("password");

	                User user = new User();
	                user.setUsername(username);
	                user.setEmail(email);
	                user.setPassword(password);
	                users.add(user);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return users;
	    }
}
