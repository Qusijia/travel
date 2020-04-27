package com.example.travel.tool;

/**
 * @author qsj
 * @create 26 - 19:43
 */
public class GuideVo {

    private int id;
    private String name;

    public GuideVo(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "GuideVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
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
}
