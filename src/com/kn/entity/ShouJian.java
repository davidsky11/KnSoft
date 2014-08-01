package com.kn.entity;

import java.io.Serializable;
import java.sql.Date;

public class ShouJian implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private Date shoujian_date;
	private String tiaoma;
	private String yewuyuan_id;

	public int getId() {
		return this.id;
	}

	public Date getShoujian_date() {
		return this.shoujian_date;
	}

	public String getTiaoma() {
		return this.tiaoma;
	}

	public String getYewuyuan_id() {
		return this.yewuyuan_id;
	}

	public void setId(int paramInt) {
		this.id = paramInt;
	}

	public void setShoujian_date(Date paramDate) {
		this.shoujian_date = paramDate;
	}

	public void setTiaoma(String paramString) {
		this.tiaoma = paramString;
	}

	public void setYewuyuan_id(String paramString) {
		this.yewuyuan_id = paramString;
	}

	public String toString() {
		return "ShouJian [id=" + this.id + ", yewuyuan_id=" + this.yewuyuan_id
				+ ", shoujian_date=" + this.shoujian_date + ", tiaoma="
				+ this.tiaoma + "]";
	}
}
