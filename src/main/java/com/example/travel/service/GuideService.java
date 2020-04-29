package com.example.travel.service;

import com.example.travel.entity.Guide;
import com.example.travel.tool.GuideVo;


import java.util.List;

public interface GuideService {

    //添加导游
    void addGuide(Guide guide);

    //查询全部导游信息
    List<Guide> findAll(String query);

    //获取导游总数
    int findRows();

   //根据搜索内容进行查询导游信息
   List<Guide> findByContent(String queryType,String query);

    //根据id删除导游信息
    void del(int id);

    //根据id查询导游信息
    Guide findById(int id);
    //根据name查询导游信息
    Guide findByName(String name);

    //修改导游信息
    void modify(Guide guide);

    //下拉列表
    public List<GuideVo> findSelect() ;

}
