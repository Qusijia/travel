package com.example.travel.service;

import com.example.travel.entity.Travel;
import com.example.travel.entity.UT;
import com.example.travel.entity.User;
import com.example.travel.tool.reportFrom;

import java.util.List;

public interface UTService {

    //查询所有游客与其报名线路的信息
    List<UT> findAll();

    //通过游客名查找其报名的所有下路
    List<UT> findByName(String name);

    //通过用户名与其所选线路将其删除（游客退订）
    void del(String uname,int tid);

    //用户报名的添加操作
    Integer add(String uname, Travel t);

    //通过用户名和tid查找
    UT findByUT(String uname,int tid);

    //线路报名排行
    List selectCount();

    //线路报名排行
    List selectMoney();

    //后台报表查询
    List<reportFrom> selectAll();


    //查询某线路的报名用户
    List<User> findByTid(int id) ;
}
