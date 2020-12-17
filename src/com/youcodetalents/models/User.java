package com.youcodetalents.models;

public class User {
	private long id;
	private String fName;
	private String lName;
	private String email;
	private String phone;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public User(long id, String fName, String lName, String email, String phone) {
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.phone = phone;
	}
	public User() {

	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", fName=" + fName + ", lName=" + lName + ", email=" + email + ", phone=" + phone
				+ "]";
	}
	
	
	
}
