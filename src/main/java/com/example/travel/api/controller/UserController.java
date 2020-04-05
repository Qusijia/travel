package com.example.travel.api.controller;

import com.example.travel.api.UserApi;
import com.example.travel.entity.User;
import com.example.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements UserApi {

    @Autowired
    private UserService userService;

    @Override
    public List<User> findAll() {
        return userService.findAll();
    }

    @Override
    public void save(User u) {
        userService.save(u);
    }

    @Override
    public void del(int id) {
        userService.del(id);
    }

    @Override
    public User findById(int id) {
        return userService.findById(id);
    }

    @Override
    public String modify(User u) {
        System.out.println("22222222222");
        userService.modify(u);

        return "1";
    }

    @Override
    public User findByName(String name) {
        return userService.findByName(name);
    }
}
