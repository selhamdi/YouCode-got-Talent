package com.youcodetalents.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import java.util.Scanner;

import com.youcodetalents.config.Configuration;

public class UserController {
	Configuration configuration;
	Connection connection;
	public long Id;

	
	public UserController() throws SQLException {
		configuration = new Configuration("jdbc:mysql://localhost:3306/youcodetalents", "root", "");
		connection = configuration.Connect();
	}
	
	public void addUser(String fname, String lname,String email, String phone) throws SQLException, ClassNotFoundException {
		
		  Random rd = new Random();
	      long id = (long)(rd.nextDouble()*1000000000L);
	      
	      
	      
	  	  
		  String sqlString = "INSERT into user (id ,first_name, last_name, email, phone) values(?,?,?,?,?)";
		  PreparedStatement statement = connection.prepareStatement(sqlString);
			statement.setLong(1, id);
			statement.setString(2, fname);
			statement.setString(3, lname);
			statement.setString(4, email);
			statement.setString(5, phone );
			statement.executeUpdate();
		 
		System.out.println("First name :"+ fname);
		System.out.println("Last name :"+ lname);
		System.out.println("Email :"+ email);
		System.out.println("Phone :"+ phone);
		this.Id = id;
	}
	
	public void updateUser(String fname, String lname,String email, String phone, long Id) throws SQLException, ClassNotFoundException {
		

		String sqlString = "update  user SET  first_name=?, last_name=?, email=?, phone=? WHERE id=?";
		  java.sql.PreparedStatement statement = connection.prepareStatement(sqlString);
			statement.setString(1, fname);
			statement.setString(2, lname);
			statement.setString(3, email);
			statement.setString(4, phone );
			statement.setLong(5, Id);
			statement.executeUpdate();
		 
		System.out.println("First name :"+ fname);
		System.out.println("Last name :"+ lname);
		System.out.println("Email :"+ email);
		System.out.println("Phone :"+ phone);
	}
	
	
}
