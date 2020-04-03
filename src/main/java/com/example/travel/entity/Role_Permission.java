package com.example.travel.entity;

public class Role_Permission {
    private String id;
    private String pid;

    private String rid;

    @Override
    public String toString() {
        return "Role_Permission{" +
                "id='" + id + '\'' +
                ", pid='" + pid + '\'' +
                ", rid='" + rid + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }
}
