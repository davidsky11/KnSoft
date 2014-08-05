package com.kn.entity;

import java.io.Serializable;

public class Grade_3 implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int grade_2_id;
	private String grade_3_name;
	private int id;

	public int getGrade_2_id() {
		return grade_2_id;
	}

	public void setGrade_2_id(int grade_2_id) {
		this.grade_2_id = grade_2_id;
	}

	public String getGrade_3_name() {
		return grade_3_name;
	}

	public void setGrade_3_name(String grade_3_name) {
		this.grade_3_name = grade_3_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String toString() {
		return "Grade_3 [id=" + this.id + ", grade_3_name=" + this.grade_3_name
				+ ", grade_2_id=" + this.grade_2_id + "]";
	}
}
