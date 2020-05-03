package com.example.travel.service;

import com.example.travel.entity.User;
import com.example.travel.entity.User_Role;
import com.example.travel.tool.UserRole;

import java.util.List;

public interface UserService {

    //用户登录验证
    User get(String name,String password);

    //查询所有游客

    List<User> findAll(String query) ;

    //添加游客

    void save(User u) ;

    //删除游客

    void del(int id) ;

    //通过id查找游客

    User findById(int id);

    //游客信息修改

    void modify(User u);

    //通过name查找游客

    User findByName(String name);

    //通过uid获取role

    List<User_Role> getRole(int uid);

    //通过uid获取权限

    List<String> getPermission(int uid);

    //添加角色
    void addRole(int uid,String phone) ;

    //查询某用户报名的线路
    int findByUid(int id);

    //删除游客对应的角色
    void delRole(int id) ;

    //修改角色
    void updateRole(int uid,int rid) ;

    List<UserRole> findAllR(String query);

}
