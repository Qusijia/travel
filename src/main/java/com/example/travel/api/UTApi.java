package com.example.travel.api;

import com.example.travel.entity.Travel;
import com.example.travel.entity.UT;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface UTApi {

    //查询所有游客与其报名线路的信息
    @GetMapping("/ut/findAll")
    List<UT> findAll();

    //通过游客名查找其报名的所有下路
    @GetMapping("/ut/findByName")
    Map<String, Object> findByName(HttpSession session);

    //通过用户名与其所选线路将其删除（游客退订）
    @PostMapping("/ut/del/{id}")
    @ResponseBody
    String del( @PathVariable("id") int id , HttpSession session);

    //用户报名的添加操作
    @PostMapping("/ut/add")
    @ResponseBody
    String add(@RequestBody Travel travel , HttpSession session);

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
