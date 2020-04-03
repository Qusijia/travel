package com.example.travel.entity;

/**
 * @author qsj
 * @create 02 - 21:10
 */
public class permission {
    private int  id;//主键
    private String permission;//权限
    private String permissiondesc;//权限描述

    @Override
    public String toString() {
        return "permission{" +
                "id=" + id +
                ", permission='" + permission + '\'' +
                ", permissiondesc='" + permissiondesc + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getPermissiondesc() {
        return permissiondesc;
    }

    public void setPermissiondesc(String permissiondesc) {
        this.permissiondesc = permissiondesc;
    }
}
