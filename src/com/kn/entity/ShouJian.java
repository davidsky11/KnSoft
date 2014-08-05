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
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getShoujian_date() {
		return shoujian_date;
	}

	public void setShoujian_date(Date shoujian_date) {
		this.shoujian_date = shoujian_date;
	}

	public String getTiaoma() {
		return tiaoma;
	}

	public void setTiaoma(String tiaoma) {
		this.tiaoma = tiaoma;
	}

	public String getYewuyuan_id() {
		return yewuyuan_id;
	}

	public void setYewuyuan_id(String yewuyuan_id) {
		this.yewuyuan_id = yewuyuan_id;
	}

	public String toString() {
		return "ShouJian [id=" + this.id + ", yewuyuan_id=" + this.yewuyuan_id
				+ ", shoujian_date=" + this.shoujian_date + ", tiaoma="
				+ this.tiaoma + "]";
	}
}
