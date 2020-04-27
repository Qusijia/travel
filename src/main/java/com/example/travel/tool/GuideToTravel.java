package com.example.travel.tool;

import com.example.travel.entity.Travel;

/**
 * @author qsj
 * @create 27 - 22:43
 * 导游负责线路
 */
public class GuideToTravel {
    private int id;
    private String name;//线路名称
    private String line;//具体线路
    private int day;//所用天数
    private double money;//所需费用
    private int num;//该线路报名人数


    public GuideToTravel(Travel travel, int num) {
        this.id =travel.getId();
        this.name = travel.getName();
        this.line = travel.getLine();
        this.day = travel.getDay();
        this.money = travel.getMoney();
        this.num = num;
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

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
