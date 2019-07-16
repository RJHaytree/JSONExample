package com.gmail.rjhaytree.JSONExample;

public class User {
	private String username;
	private String password;
	private String gender;
	private String email;
	
	public User() {
		setUsername(null);
		setPassword(null);
		setGender(null);
		setEmail(null);
	}
	
	public User(String name, String pass, String gend, String mail) {
		setUsername(name);
		setPassword(pass);
		setGender(gend);
		setEmail(mail);
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
