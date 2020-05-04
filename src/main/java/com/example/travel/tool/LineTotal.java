package com.example.travel.tool;

/**
 * @author qsj
 * @create 04 - 14:35
 */
public class LineTotal {
    private Integer tid;//线路id
    private String tname;//线路名称
    private Integer num;//报名人数
    private double money;//共计收益

    @Override
    public String toString() {
        return "LineTotal{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", num=" + num +
                ", money=" + money +
                '}';
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
