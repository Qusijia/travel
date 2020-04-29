package com.example.travel.mapper;

import com.example.travel.entity.Guide;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface GuideMapper {

    //添加导游 (lev,name,gender,age,lan,route)
    @Insert("INSERT INTO guide  (lev,name,gender,age,lan) values (#{lev},#{name},#{gender},#{age},#{lan})")
    void addGuide(Guide guide);

    //查询全部导游信息
    @Select("SELECT * FROM guide ")
    List<Guide> findAll();

    //获取导游总数
    @Select("SELECT count(*) rows FROM guide")
    int findRows();

    //根据搜索内容进行查询导游信息  //    @Select("SELECT * FROM guide WHERE name LIKE  CONCAT('%',#{query},'%')")
    @SelectProvider(method = "findByContent", type = GuideMapper.GuideSqlBuilders.class)
    List<Guide> findByContent(String queryType,String query);

    //根据id删除导游信息
    @Delete("DELETE FROM guide WHERE id=#{id}")
    void del(int id);

    //根据id查询导游信息
    @Select("SELECT * FROM guide WHERE id=#{id}")
    Guide findById(int id);

    //根据name查询导游信息
    @Select("SELECT * FROM guide WHERE name=#{name}")
    Guide findByName(String name);

    //修改导游信息
    @Update("UPDATE guide set lev=#{lev},name=#{name},gender=#{gender},age=#{age},lan=#{lan} WHERE id=#{id}")
    void modify(Guide guide);



    class GuideSqlBuilders {

        public String findByContent(String queryType,String query) {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT * FROM guide ");
            sql.append("  WHERE "+queryType+"  "+query );
            System.out.println(sql.toString());
            return sql.toString();
        }


    }

}
