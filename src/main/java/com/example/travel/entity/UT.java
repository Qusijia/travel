package com.example.travel.entity;
/*
	游客报名表
 */
public class UT {

	private String uname;//游客名曾
	private int tid;//线路id
	private String tname;//线路名称
	private int money;//所需费用
	
	@Override
	public String toString() {
		return "UT [uname=" + uname + ", tid=" + tid + ", tname=" + tname
				+ ", money=" + money + "]";
	}
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	
}
