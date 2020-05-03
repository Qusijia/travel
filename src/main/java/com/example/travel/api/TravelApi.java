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
    @PostMapping("/travel/save/{service}")
    String save(@RequestBody Travel t ,@PathVariable int  service);

    //删除线路
    @PostMapping("/travel/del/{id}")
    String del(@PathVariable int id) ;

    //通过id查找
    @GetMapping("/travel/findById/{id}")
    Travel findById(@PathVariable int id);

    //修改路线
    @PostMapping("/travel/modify")
    String modify(@RequestBody Travel t);

    //查询用户参加的路线
    @GetMapping("/travel/findByname")
    Map<String, Object> findByname(HttpSession session);

    @GetMapping("/travel/findAllPage")
    //查询用户未参加线路信息  @RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "limit", defaultValue = "10") int limit, @RequestParam(value = "queryType", defaultValue = "") String queryType, @RequestParam(value = "query", defaultValue = "") String query
    public Map<String, Object> findAllPage(@RequestParam int page, @RequestParam int limit,  @RequestParam(value = "query", defaultValue = "") String query ,HttpSession session);

    @GetMapping("/travel/LineFrom")

    //查询导游负责线路统计信息  @RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "limit", defaultValue = "10") int limit, @RequestParam(value = "queryType", defaultValue = "") String queryType, @RequestParam(value = "query", defaultValue = "") String query
    public Map<String, Object> LinePage(@RequestParam int page, @RequestParam int limit,  @RequestParam(value = "query", defaultValue = "") String query ,HttpSession session);

    @GetMapping("/travel/guideLineFrom/{id}")
    //查询某导游负责线路统计信息  @RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "limit", defaultValue = "10") int limit, @RequestParam(value = "queryType", defaultValue = "") String queryType, @RequestParam(value = "query", defaultValue = "") String query
    public Map<String, Object> guideLinePage(@PathVariable int id,@RequestParam int page, @RequestParam int limit,  @RequestParam(value = "query", defaultValue = "") String query );
}





