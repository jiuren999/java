package com.user.entity;

import java.io.Serializable;

public class User implements Serializable {
	private int id;
	private String name;
	private String sex;
	private int age;
	private String id_card;
	private String password;
	private String freeze;
	public User() {
		super();
	}
	public User(int id, String name, String sex, int age, String id_card,
			String password, String freeze) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.id_card = id_card;
		this.password = password;
		this.freeze = freeze;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getId_card() {
		return id_card;
	}
	public void setId_card(String id_card) {
		this.id_card = id_card;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFreeze() {
		return freeze;
	}
	public void setFreeze(String freeze) {
		this.freeze = freeze;
	}

}
