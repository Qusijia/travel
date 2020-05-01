package com.example.travel.service;

import com.example.travel.entity.Travel;
import com.example.travel.entity.Travel_Guide;
import com.example.travel.tool.GuideToTravel;

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
    List<Travel>  find(String name , String query);

    //查询导游负责线路统计信息
    List<GuideToTravel> LineFrom(int gid);

    //某路线报名人数
    int LineNum(int tid);

    //删除线路关联的导游负责
    void delTravelAndGuide(int id) ;

    //添加导游-线路数据
    int saveTravelGuid(Travel_Guide t);

    Travel findNotById(Travel t);

    //删除线路关联的指定导游负责
    void delTravelAndMGuide(int id,int gid) ;
}
