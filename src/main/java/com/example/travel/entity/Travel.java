package com.example.travel.entity;

public class Travel {
	private int id;
	private String name;
	private String line;
	private int day;
	private double money;
	
	@Override
	public String toString() {
		return "Travel [id=" + id + ", name=" + name + ", line=" + line
				+ ", day=" + day + ", money=" + money + "]";
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
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(double i) {
		this.money = i;
	}
	
	
}
