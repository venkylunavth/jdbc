package com.ecom.model;

public class User {
	private int id;
	private String name;
	private String email;
	private String password;
	private int mobile;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", mobile="
				+ mobile + "]";
	}

	public User( String name, String email, String password, int mobile) {
		super();
		
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
	}

	public User() {
		super();
	}
}
