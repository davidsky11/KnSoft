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

	public boolean equals(Object paramObject) {
		return false;
	}

	public String getBu_pai_song_fan_wei() {
		return this.bu_pai_song_fan_wei;
	}

	public String getDetail_name() {
		return this.detail_name;
	}

	public String getDetail_number() {
		return this.detail_number;
	}

	public String getFu_ze_ren() {
		return this.fu_ze_ren;
	}

	public int getGrade_3_id() {
		return this.grade_3_id;
	}

	public int getId() {
		return this.id;
	}

	public String getPai_song_fan_wei() {
		return this.pai_song_fan_wei;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public int hashCode() {
		return 0;
	}

	public void setBu_pai_song_fan_wei(String paramString) {
		this.bu_pai_song_fan_wei = paramString;
	}

	public void setDetail_name(String paramString) {
		this.detail_name = paramString;
	}

	public void setDetail_number(String paramString) {
		this.detail_number = paramString;
	}

	public void setFu_ze_ren(String paramString) {
		this.fu_ze_ren = paramString;
	}

	public void setGrade_3_id(int paramInt) {
		this.grade_3_id = paramInt;
	}

	public void setId(int paramInt) {
		this.id = paramInt;
	}

	public void setPai_song_fan_wei(String paramString) {
		this.pai_song_fan_wei = paramString;
	}

	public void setTelephone(String paramString) {
		this.telephone = paramString;
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

/*
 * Location: C:\Users\davidsky\Desktop\AUTOID7\AutoidPDA_22336439500900.jar
 * Qualified Name: com.seuic.entity.Detail JD-Core Version: 0.6.0
 */