package com.example.travel.mapper;

import com.example.travel.entity.Travel;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TravelMapper {

    @Select("SELECT * FROM travel WHERE name LIKE %#{name}%")
     List<Travel> findByContent(String name) ;

    //查询所有线路
    @Select("SELECT * FROM travel")
     List<Travel> findAll();

    //添加线路
    @Insert("INSERT INTO travel VALUES(#{name},#{line},#{day},#{money})")
     void save(Travel t);

    //删除线路
    @Delete("DELETE FROM travel WHERE id=#{id}")
     void del(int id) ;

    //通过id查找
    @Select("SELECT * FROM travel WHERE id=#{id}")
     Travel findById(int id);

    //修改路线
    @Update("UPDATE travel SET name=#{name},line=#{line},day=#{day},money=#{money} WHERE id=#{id}")
     void modify(Travel t);

    //查询用户参加的路线
    @Select("SELECT * FROM travel t JOIN user_travel ut ON t.id = ut.tid WHERE ut.uname= #{name}")
    List<Travel>  findByname(String name);


    //获取导游总数
    @Select("SELECT count(*) rows FROM travel")
    int findRows();


}

