package com.example.travel.entity;

public class User_Role  {
    private String id;

    private int uid;

    private String rid;

    @Override
    public String toString() {
        return "User_Role{" +
                "id='" + id + '\'' +
                ", uid=" + uid +
                ", rid='" + rid + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }
}
