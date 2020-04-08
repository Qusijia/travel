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

    //获取线路总数

    int findRows();

//    //查询全部线路信息分页
//    public Map<String, Object> findAllPage(int page, int limit, String query, String queryType);

    //查询用户未参加的路线
    List<Travel>  find(String name);
}
