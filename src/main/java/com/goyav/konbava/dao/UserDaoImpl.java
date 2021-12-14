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
	            preparedStatement = connection.prepareStatement("INSERT INTO users (name) VALUES(?);");
	            preparedStatement.setString(1, user.getName());

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
	            resultat = statement.executeQuery("SELECT name FROM users;");

	            while (resultat.next()) {
	                String name = resultat.getString("name");

	                User user = new User();
	                user.setName(name);
	                users.add(user);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return users;
	    }
}
