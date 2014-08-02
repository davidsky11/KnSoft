package com.kn.entity;

import java.io.Serializable;

public class Grade_2 implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int grade_1_id;
	private String grade_2_name;
	private int id;

	public int getGrade_1_id() {
		return this.grade_1_id;
	}

	public String getGrade_2_name() {
		return this.grade_2_name;
	}

	public int getId() {
		return this.id;
	}

	public void setGrade_1_id(int paramInt) {
		this.grade_1_id = paramInt;
	}

	public void setGrade_2_name(String paramString) {
		this.grade_2_name = paramString;
	}

	public void setId(int paramInt) {
		this.id = paramInt;
	}

	public String toString() {
		return "Grade_2 [id=" + this.id + ", grade_2_name=" + this.grade_2_name
				+ ", grade_1_id=" + this.grade_1_id + "]";
	}
}
