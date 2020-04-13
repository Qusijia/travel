package com.example.travel.api;

import com.example.travel.entity.Travel;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

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

    //查询用户参加的路线
    @GetMapping("/travel/findByname")
    Map<String, Object> findByname(HttpSession session);

    @GetMapping("/travel/findAllPage")
    //查询全部线路信息  @RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "limit", defaultValue = "10") int limit, @RequestParam(value = "queryType", defaultValue = "") String queryType, @RequestParam(value = "query", defaultValue = "") String query
    public Map<String, Object> findAllPage(@RequestParam int page, @RequestParam int limit,  @RequestParam(value = "query", defaultValue = "") String query ,HttpSession session);
}
