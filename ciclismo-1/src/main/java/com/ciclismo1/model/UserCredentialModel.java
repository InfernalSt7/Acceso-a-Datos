package com.ciclismo1.model;

public class UserCredentialModel {
	private String username;
	private String password;
	
	public UserCredentialModel(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public UserCredentialModel() {}

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
	
	
}
