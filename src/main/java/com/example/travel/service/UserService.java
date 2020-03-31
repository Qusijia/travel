package com.example.travel.service;

import com.example.travel.entity.User;

import java.util.List;

public interface UserService {

    //用户登录验证
    User get(String name,String password);

    //查询所有游客

    List<User> findAll() ;

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

}
