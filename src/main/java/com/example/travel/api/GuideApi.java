package com.example.travel.api;

import com.example.travel.entity.Guide;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface GuideApi {

    //添加导游
    @PostMapping("/guide/add")
    void addGuide(@RequestBody Guide guide);

    //查询全部导游信息
    @GetMapping("/guide/findall")
    List<Guide> findAll();

    //根据搜索内容进行查询导游信息
    @GetMapping("/guide/findByContext")
    List<Guide> findByContent(@RequestParam String str,@RequestParam String id);

    //根据id删除导游信息
    @DeleteMapping("/guide/del/{id}")
    void del(@PathVariable int id);

    //根据id查询导游信息
    @GetMapping("/guide/findById/{id}")
    Guide findById(@PathVariable  int id);

    //修改导游信息
    @PatchMapping("/guide/modify")
    void modify(@RequestBody Guide guide);
}
