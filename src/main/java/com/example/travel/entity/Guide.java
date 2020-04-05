package com.example.travel.entity;

/*
   导游表
 */
public class Guide {
	private int id;
	private int lev;//导游级别
	private String name;
	private String gender;
	private int age;
	private String lan;//擅长语言
	private String route;//熟悉线路
	
	@Override
	public String toString() {
		return "guide [id=" + id + ", lev=" + lev + ", name=" + name
				+ ", gender=" + gender + ", age=" + age + ", lan=" + lan
				+ ", route=" + route + "]";
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLev() {
		return lev;
	}
	public void setLev(int lev) {
		this.lev = lev;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getLan() {
		return lan;
	}
	public void setLan(String lan) {
		this.lan = lan;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	
}
