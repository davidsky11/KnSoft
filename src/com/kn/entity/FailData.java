package com.kn.entity;

import java.io.Serializable;

public class FailData implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String danJuHao;
	private int id;
	private String saoMiaoLeiXing;

	public String getDanJuHao() {
		return this.danJuHao;
	}

	public int getId() {
		return this.id;
	}

	public String getSaoMiaoLeiXing() {
		return this.saoMiaoLeiXing;
	}

	public void setDanJuHao(String danJuHao) {
		this.danJuHao = danJuHao;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSaoMiaoLeiXing(String saoMiaoLeiXing) {
		this.saoMiaoLeiXing = saoMiaoLeiXing;
	}

	public String toString() {
		return "FailData [id=" + this.id + ", danJuHao=" + this.danJuHao
				+ ", saoMiaoLeiXing=" + this.saoMiaoLeiXing + "]";
	}
}
