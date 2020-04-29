package com.example.travel.api;

import com.example.travel.entity.Guide;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface GuideApi {

    //添加导游
    @PostMapping("/guide/add")
    String addGuide(@RequestBody Guide guide );

    //查询全部导游信息
    @GetMapping("/guide/findall")
     Map<String, Object> findAll(@RequestParam int page, @RequestParam int limit , @RequestParam(value = "queryType", defaultValue = "") String queryType ,@RequestParam(value = "query", defaultValue = "") String query , HttpSession session);

    //查询全部导游信息下拉
   @GetMapping("/guide/findSelect")
   Map<String, Object> findAll();

//    //根据搜索内容进行查询导游信息
//    @GetMapping("/guide/findByContext")
//    List<Guide> findByContent(@RequestParam String str,@RequestParam String id);

    @GetMapping("/guide/findBySelect")
    ModelAndView findBySelect();

    //根据id删除导游信息
    @PostMapping("/guide/del/{id}")
    String del(@PathVariable int id );

    //根据id查询导游信息
    @GetMapping("/guide/findById/{id}")
    Guide findById(@PathVariable  int id);

    //修改导游信息
    @PostMapping("/guide/modify")
    String modify(@RequestBody Guide guide);
}
