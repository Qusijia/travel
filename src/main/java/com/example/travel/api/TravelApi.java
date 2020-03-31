package com.example.travel.api;

import com.example.travel.entity.Travel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface TravelApi {

    @GetMapping("/travel/findByContent/{name}")
    List<Travel> findByContent(@PathVariable String name) ;

    //查询所有线路
    @GetMapping("/travel/findAll")
    List<Travel> findAll();

    //添加线路
    @PostMapping("/travel/save")
    void save(@RequestBody Travel t);

    //删除线路
    @DeleteMapping("/travel/del/{id}")
    void del(@PathVariable int id) ;

    //通过id查找
    @GetMapping("/travel/findById/{id}")
    Travel findById(@PathVariable int id);

    //修改路线
    @PatchMapping("/travel/modify")
    void modify(@RequestBody Travel t);
}
