package com.example.travel.service;

import com.example.travel.entity.Guide;


import java.util.List;

public interface GuideService {

    //添加导游
    void addGuide(Guide guide);

    //查询全部导游信息
    List<Guide> findAll();

    //获取导游总数
    int findRows();

    //根据搜索内容进行查询导游信息
    List<Guide> findByContent(String str,String id);

    //根据id删除导游信息
    void del(int id);

    //根据id查询导游信息
    Guide findById(int id);

    //修改导游信息
    void modify(Guide guide);

}
