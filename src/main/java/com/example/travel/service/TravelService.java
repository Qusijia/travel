package com.example.travel.service;

import com.example.travel.entity.Travel;

import java.util.List;

public interface TravelService {

    List<Travel> findByContent(String name) ;

    //查询所有线路
   List<Travel> findAll();

    //添加线路

    void save(Travel t);

    //删除线路

    void del(int id) ;

    //通过id查找
   Travel findById(int id);

    //修改路线

    void modify(Travel t);

    //查询用户参加的路线

    List<Travel>  findByname(String name);

}
