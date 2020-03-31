package com.example.travel.api;

import com.example.travel.entity.Travel;
import com.example.travel.entity.UT;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UTApi {

    //查询所有游客与其报名线路的信息
    @GetMapping("/ut/findAll")
    List<UT> findAll();

    //通过游客名查找其报名的所有下路
    @GetMapping("/ut/findByName/{name}")
    List<UT> findByName(@PathVariable String name);

    //通过用户名与其所选线路将其删除（游客退订）
    @DeleteMapping("/ut/del")
    void del(@RequestParam String uname, @RequestParam int tid);

    //用户报名的添加操作
    @PostMapping("/ut/add")
    Integer add(@RequestParam String uname, @RequestParam Travel t);

    //通过用户名和tid查找
    @GetMapping("/ut/findByUT")
    UT findByUT(@RequestParam String uname,@RequestParam int tid);

    //线路报名排行
    @GetMapping("/ut/selectCount")
    List selectCount();

    //线路报名排行
    @GetMapping("/ut/selectMoney")
    List selectMoney();

    //后台报表查询
    @GetMapping("/ut/selectAll")
    List selectAll();

}
