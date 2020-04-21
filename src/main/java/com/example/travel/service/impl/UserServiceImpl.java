package com.example.travel.service.impl;

import com.example.travel.entity.User;
import com.example.travel.entity.User_Role;
import com.example.travel.mapper.UserMapper;
import com.example.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User get(String name, String password) {
        return userMapper.get( name , password );
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public void save(User u) {
        userMapper.save(u);
    }

    @Override
    public void del(int id) {
        userMapper.del(id);
    }

    @Override
    public User findById(int id) {
        return userMapper.findById(id);
    }

    @Override
    public void modify(User u) {
        userMapper.modify(u);
    }

    @Override
    public User findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public List<User_Role> getRole(int uid) {
        return userMapper.getRole(uid);
    }

    @Override
    public List<String> getPermission(int uid) {
        return userMapper.getPermission(uid);
    }

    @Override
    public void addRole(int uid , String phone) {
        if(phone==null){
            userMapper.addRole(uid,2);
        }else{
            userMapper.addRole(uid,1);
        }

    }
}
