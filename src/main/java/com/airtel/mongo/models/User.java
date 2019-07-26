package com.airtel.mongo.models;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

public class User {

	@NotBlank(message = "Password Can't be Empty")
	@Size(min=5, max=20, message = "Password length should be between 5 to 20")
	private String password;
	
	@NotBlank(message = "Username Can't be Empty")
	@Size(min=5, max=20, message = "Username characters length should be between 5 to 20")
	private String username;
	
	public User() {
		super();
	}
	
	public User(String password, String username) {
		super();
		this.password = password;
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [password=" + password + ", username=" + username + "]";
	}

	
}
