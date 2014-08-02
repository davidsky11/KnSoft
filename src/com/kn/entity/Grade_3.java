package com.kn.entity;

import java.io.Serializable;

public class Grade_3 implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int grade_2_id;
	private String grade_3_name;
	private int id;

	public int getGrade_2_id() {
		return this.grade_2_id;
	}

	public String getGrade_3_name() {
		return this.grade_3_name;
	}

	public int getId() {
		return this.id;
	}

	public void setGrade_2_id(int paramInt) {
		this.grade_2_id = paramInt;
	}

	public void setGrade_3_name(String paramString) {
		this.grade_3_name = paramString;
	}

	public void setId(int paramInt) {
		this.id = paramInt;
	}

	public String toString() {
		return "Grade_3 [id=" + this.id + ", grade_3_name=" + this.grade_3_name
				+ ", grade_2_id=" + this.grade_2_id + "]";
	}
}
