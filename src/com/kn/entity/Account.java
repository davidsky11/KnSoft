package com.kn.entity;

import java.io.Serializable;
import java.util.Date;

public class Account implements Serializable {
	
	private static final long serialVersionUID = -533698031946372178L;
	
	private int id;
	private String username;
	private String password;
	private Date birthday;
	private String email;
	
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		return "Account [id=" + this.id + ", username=" + this.username
				+ ", password=" + this.password + ", birthday=" + this.birthday
				+ ", email=" + this.email + "]";
	}
}