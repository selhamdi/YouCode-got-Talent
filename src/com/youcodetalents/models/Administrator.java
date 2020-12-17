package com.youcodetalents.models;

public class Administrator extends User {
	public String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Administrator(String password) {
		super();
		this.password = password;
	}
	
	
	
}
