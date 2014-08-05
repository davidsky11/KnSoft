package com.kn.entity;

import java.io.Serializable;

public class Detail implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String bu_pai_song_fan_wei;
	private String detail_name;
	private String detail_number;
	private String fu_ze_ren;
	private int grade_3_id;
	private int id;
	private String pai_song_fan_wei;
	private String telephone;

	public String getBu_pai_song_fan_wei() {
		return bu_pai_song_fan_wei;
	}

	public void setBu_pai_song_fan_wei(String bu_pai_song_fan_wei) {
		this.bu_pai_song_fan_wei = bu_pai_song_fan_wei;
	}

	public String getDetail_name() {
		return detail_name;
	}

	public void setDetail_name(String detail_name) {
		this.detail_name = detail_name;
	}

	public String getDetail_number() {
		return detail_number;
	}

	public void setDetail_number(String detail_number) {
		this.detail_number = detail_number;
	}

	public String getFu_ze_ren() {
		return fu_ze_ren;
	}

	public void setFu_ze_ren(String fu_ze_ren) {
		this.fu_ze_ren = fu_ze_ren;
	}

	public int getGrade_3_id() {
		return grade_3_id;
	}

	public void setGrade_3_id(int grade_3_id) {
		this.grade_3_id = grade_3_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPai_song_fan_wei() {
		return pai_song_fan_wei;
	}

	public void setPai_song_fan_wei(String pai_song_fan_wei) {
		this.pai_song_fan_wei = pai_song_fan_wei;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String toString() {
		return "Detail [id=" + this.id + ", grade_3_id=" + this.grade_3_id
				+ ", detail_name=" + this.detail_name + ", detail_number="
				+ this.detail_number + ", fu_ze_ren=" + this.fu_ze_ren
				+ ", telephone=" + this.telephone + ", pai_song_fan_wei="
				+ this.pai_song_fan_wei + ", bu_pai_song_fan_wei="
				+ this.bu_pai_song_fan_wei + "]";
	}
}
