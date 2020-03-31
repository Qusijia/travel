package com.example.travel.api;

import com.example.travel.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserApi {

    //查询所有游客
    @GetMapping("/user/findAll")
    List<User> findAll() ;

    //添加游客
    @PostMapping("/user/save")
    void save(@RequestBody User u) ;

    //删除游客
    @DeleteMapping("/user/del/{id}")
    void del(@PathVariable int id) ;

    //通过id查找游客
    @GetMapping("/user/findById/{id}")
    User findById(@PathVariable int id);

    //游客信息修改
    @PatchMapping("/user/modify")
    void modify(@RequestBody User u);

    //通过name查找游客
    @GetMapping("/user/findByContent/{name}")
    User findByName(@PathVariable String name);

}
