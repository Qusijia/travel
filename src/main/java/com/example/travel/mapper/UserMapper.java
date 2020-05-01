package com.example.travel.mapper;


import com.example.travel.entity.User;
import com.example.travel.entity.User_Role;
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
    @Select("SELECT *   FROM user  WHERE  name  NOT IN ( SELECT  u.name  FROM   user  u  JOIN guide g ON u.name = g.name ) ")
      List<User> findAll() ;

    @Select("SELECT * FROM user  WHERE name LIKE  CONCAT('%',#{query},'%') AND name  NOT IN ( SELECT  u.name  FROM   user  u  JOIN guide g ON u.name = g.name ) ")
    List<User> findByContent(String query) ;

    //添加游客
    @Insert("INSERT INTO user (name,password,gender,age,phone,lim) values (#{name},#{password},#{gender},#{age},#{phone},#{lim})")
     void save(User u) ;

    //删除游客
    @Delete("DELETE FROM user  WHERE id=#{id}")
     void del(int id) ;
    //删除游客对应的角色
    @Delete("DELETE FROM user_role  WHERE uid=#{id}")
    void delRole(int id) ;

    //通过id查找游客
    @Select("SELECT * FROM user WHERE id=#{id}")
     User findById(int id);

    //游客信息修改
    @Update("UPDATE user SET name=#{name},password=#{password},gender=#{gender},age=#{age},phone=#{phone},lim=#{lim} WHERE id= #{id}")
     void modify(User u);

    //通过name查找用户
    @Select("SELECT * FROM user WHERE name=#{name}")
     User findByName(String name);
    //通过uid获取role
    @Select("SELECT * FROM user_role WHERE uid=#{uid}")
    List<User_Role> getRole(int uid);

    //通过uid获取权限
    @Select("SELECT permission FROM user_role ur JOIN role_permission rp ON ur.rid = rp.rid JOIN permission p ON rp.pid = p.id WHERE uid=#{uid}")
    List<String> getPermission(int uid);

    //添加客户
    @Insert("INSERT INTO user_role (uid,rid) values (#{uid},#{rid})")
    void addRole(int uid , int rid) ;
    //查询某用户报名的线路
    @Select("SELECT count(*) rows  FROM travel t JOIN user_travel ut ON t.id = ut.tid JOIN user u ON ut.uname = u.name WHERE u.id = #{id}")
    int  findByUid(int id);


}
