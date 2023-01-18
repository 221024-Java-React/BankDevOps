package com.example.models;

public class LoginObject {
	
	private String email;
	private String password;
	
	public LoginObject() {
		super();
	}

	public LoginObject(String email, String password) {
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

	@Override
	public String toString() {
		return "LoginObject [email=" + email + ", password=" + password + "]";
	}
	
}
