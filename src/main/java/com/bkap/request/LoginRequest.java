package com.bkap.request;

public class LoginRequest {
	private String name;
	private String password;
	private String jwt;

	public LoginRequest() {
		super();
	}

	public LoginRequest(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	

	public LoginRequest(String name, String password, String jwt) {
		super();
		this.name = name;
		this.password = password;
		this.jwt = jwt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	

}
