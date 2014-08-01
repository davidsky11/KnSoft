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
	
	public Date getBirthday() {
		return this.birthday;
	}

	public String getEmail() {
		return this.email;
	}

	public int getId() {
		return this.id;
	}

	public String getPassword() {
		return this.password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setBirthday(Date paramDate) {
		this.birthday = paramDate;
	}

	public void setEmail(String paramString) {
		this.email = paramString;
	}

	public void setId(int paramInt) {
		this.id = paramInt;
	}

	public void setPassword(String paramString) {
		this.password = paramString;
	}

	public void setUsername(String paramString) {
		this.username = paramString;
	}

	public String toString() {
		return "Account [id=" + this.id + ", username=" + this.username
				+ ", password=" + this.password + ", birthday=" + this.birthday
				+ ", email=" + this.email + "]";
	}
}