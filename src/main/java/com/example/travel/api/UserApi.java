package com.example.travel.api;

import com.example.travel.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

public interface UserApi {


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
    @PostMapping("/user/modify")
    String modify(@RequestBody User u);

    //通过name查找游客
    @GetMapping("/user/findByContent/{name}")
    User findByName(@PathVariable String name);

    @GetMapping("/user/findAllPage")
    //查询用户未参加线路信息  @RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "limit", defaultValue = "10") int limit, @RequestParam(value = "queryType", defaultValue = "") String queryType, @RequestParam(value = "query", defaultValue = "") String query
    public Map<String, Object> findAllPage(@RequestParam int page, @RequestParam int limit, @RequestParam(value = "query", defaultValue = "") String query);

    //通过id查找游客
    @PostMapping("/user/delById/{id}")
    String delById(@PathVariable int id);

    //角色修改
    @PostMapping("/user/role/{id}")
    String updateRole(@PathVariable int id, String  role);

}
