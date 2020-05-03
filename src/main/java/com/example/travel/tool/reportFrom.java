package com.example.travel.tool;

/**
 * @author qsj
 * @create 04 - 0:33
 */
public class reportFrom {
    private String name;//线路名称
    private Integer num;//报名人数


    @Override
    public String toString() {
        return "reportFrom{" +
                "name='" + name + '\'' +
                ", num=" + num +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
