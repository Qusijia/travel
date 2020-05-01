package com.example.travel.entity;

/**
 * @author qsj
 * @create 01 - 15:38
 */
public class Travel_Guide {
    private int tgid;
    private int tid;//线路id
    private int gid;//导游id

    public Travel_Guide( int tid, int gid) {
        this.tid = tid;
        this.gid = gid;
    }

    @Override
    public String toString() {
        return "Travel_Guide{" +
                "tgid=" + tgid +
                ", tid=" + tid +
                ", gid=" + gid +
                '}';
    }

    public int getTgid() {
        return tgid;
    }

    public void setTgid(int tgid) {
        this.tgid = tgid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }
}
