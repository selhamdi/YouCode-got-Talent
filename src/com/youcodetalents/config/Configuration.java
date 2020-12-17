package com.youcodetalents.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Configuration {

	private String url;
	private String username;
	private String password;
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public Configuration(String url, String username, String password) {
		super();
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	public Configuration() {
		
	}
	
	public Connection Connect() throws SQLException {
		Connection connection = DriverManager.getConnection(this.url, this.username, this.password);
		return connection;
	}
	
}
