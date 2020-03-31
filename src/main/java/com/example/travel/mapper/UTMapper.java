package com.example.travel.mapper;

import com.example.travel.entity.Travel;
import com.example.travel.entity.UT;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UTMapper {

    //查询所有游客与其报名线路的信息
    @Select("SELECT * FROM user_travel ORDER BY tid")
    List<UT> findAll();

    //通过游客名查找其报名的所有下路
    @Select("SELECT * FROM user_travel WHERE uname= #{name}")
    List<UT> findByName(String name);

    //通过用户名与其所选线路将其删除（游客退订）
    @Delete("DELETE FROM user_travel WHERE uname=  #{name} AND tid=  #{tid}")
    void del(String uname,int tid);

    //用户报名的添加操作
    @Insert("INSERT INTO user_travel(uname,tid,tname,money)VALUES(#{name},#{tid},#{tname},#{money})")
    Integer add(String uname, Travel t);

    //通过用户名和tid查找
    @Select("SELECT * FROM user_travel WHERE uname=  #{name} AND tid=  #{tid}")
    UT findByUT(String uname,int tid);

    //线路报名排行
    @Select("SELECT COUNT(*) COUNT,tid,tname,money  FROM user_travel GROUP BY tid ORDER BY COUNT(*) DESC")
    List selectCount();

    //线路报名排行
    @Select("SELECT COUNT(*) COUNT,tid,tname,money  FROM user_travel GROUP BY tid ORDER BY money")
    List selectMoney();

    //后台报表查询
    @Select("SELECT tid,tname,COUNT(*) count,SUM(money) money  FROM user_travel GROUP BY tid ORDER BY tid")
    List selectAll();

}
