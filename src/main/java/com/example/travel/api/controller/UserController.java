package com.example.travel.api.controller;

import com.example.travel.api.UserApi;
import com.example.travel.entity.User;
import com.example.travel.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController implements UserApi {

    @Autowired
    private UserService userService;


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

    @Override
    public Map<String, Object> findAllPage(int page, int limit, String query) {
        PageHelper.startPage(page,limit);
        List<User> users = userService.findAll(query);
        PageInfo<User> userPageInfo = new PageInfo<User>(users);
        List<User> userList = userPageInfo.getList();

        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("code",0);
        resultMap.put("msg","");
        resultMap.put("count",userPageInfo.getTotal());
        resultMap.put("data",userList);

        return resultMap;
    }

    @Override
    public String delById(int id) {
        System.out.println(userService.findByUid(id));
        System.out.println(1);
        if(userService.findByUid(id)>0){
            System.out.println("555555");
            return "0";//该用户正在参团
        }else{
            userService.del(id);
            return "1";

        }


    }
}
