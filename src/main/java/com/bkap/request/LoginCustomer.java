package com.bkap.request;

public class LoginCustomer {
	private String email;
	private String password;
	public LoginCustomer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginCustomer(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

	
}
