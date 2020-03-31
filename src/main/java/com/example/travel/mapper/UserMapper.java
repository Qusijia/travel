package com.example.travel.mapper;


import com.example.travel.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    //用户登录验证
    @Select("SELECT * FROM user WHERE name = #{name} AND password = #{password}")
    User get(String name,String password);
    //查询所有游客
    @Select("SELECT * FROM user")
      List<User> findAll() ;

    //添加游客
    @Insert("INSERT INTO user (name,password,gender,age,phone,lim,role) values (#{name},#{password},#{gender},#{age},#{phone},#{lim},#{role})")
     void save(User u) ;

    //删除游客
    @Delete("DELETE FROM user  WHERE id=#{id}")
     void del(int id) ;

    //通过id查找游客
    @Select("SELECT * FROM user WHERE id=#{id}")
     User findById(int id);

    //游客信息修改
    @Update("UPDATE travel SET name=#{name},password=#{password},gender=#{gender},age=#{age},phone=#{phone},lim=#{lim},role=#{role}")
     void modify(User u);

    //通过name查找游客
    @Select("SELECT * FROM travel WHERE name=#{name}")
     User findByName(String name);


}
