package com.uqam.labo11.model;

public class User {
	private int id;
	private String username;
	private String password;
	private String role;
	public User(int id2, String username2, String password2, String role2) {
		id = id2;
		username = username2;
		password = password2;
		role = role2;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

}
