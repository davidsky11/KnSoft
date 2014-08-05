package com.kn.entity;

import java.io.Serializable;

public class Grade_2 implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int grade_1_id;
	private String grade_2_name;
	private int id;

	public int getGrade_1_id() {
		return grade_1_id;
	}

	public void setGrade_1_id(int grade_1_id) {
		this.grade_1_id = grade_1_id;
	}

	public String getGrade_2_name() {
		return grade_2_name;
	}

	public void setGrade_2_name(String grade_2_name) {
		this.grade_2_name = grade_2_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String toString() {
		return "Grade_2 [id=" + this.id + ", grade_2_name=" + this.grade_2_name
				+ ", grade_1_id=" + this.grade_1_id + "]";
	}
}
