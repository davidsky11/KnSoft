package com.kn.entity;

import java.io.Serializable;

public class Grade_1 implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String grade_1_name;
	private int id;

	public String getGrade_1_name() {
		return this.grade_1_name;
	}

	public int getId() {
		return this.id;
	}

	public void setGrade_1_name(String grade_1_name) {
		this.grade_1_name = grade_1_name;
	}

	public void setId(int paramInt) {
		this.id = paramInt;
	}

	public String toString() {
		return "Grade_1 [id=" + this.id + ", grade_1_name=" + this.grade_1_name
				+ "]";
	}
}