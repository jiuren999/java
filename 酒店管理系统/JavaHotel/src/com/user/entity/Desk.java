package com.user.entity;

import java.io.Serializable;

public class Desk implements  Serializable {
	private String num;
	private int seating;
	public Desk() {
		super();
	}
	public Desk(String num, int seating) {
		super();
		this.num = num;
		this.seating = seating;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public int getSeating() {
		return seating;
	}
	public void setSeating(int seating) {
		this.seating = seating;
	}
	

}
