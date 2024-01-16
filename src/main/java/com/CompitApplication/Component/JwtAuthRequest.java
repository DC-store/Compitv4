package com.CompitApplication.Component;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
public class JwtAuthRequest {

	private String usernames;
	
	private String password;

	public String getUsernames() {
		return usernames;
	}

	public void setUsernames(String usernames) {
		this.usernames = usernames;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public JwtAuthRequest(String usernames, String password) {
		super();
		this.usernames = usernames;
		this.password = password;
	}

	public JwtAuthRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
