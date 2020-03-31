package com.example.travel.mapper;

import com.example.travel.entity.Guide;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface GuideMapper {

    //添加导游
    @Insert("INSERT INTO guide values(#{lev},#{name},#{gender},#{age},#{route})")
    void addGuide(Guide guide);

    //查询全部导游信息
    @Select("SELECT * FROM guide ")
    List<Guide> findAll();

    //获取导游总数
    @Select("SELECT count(*) rows FROM guide")
    int findRows();

    //根据搜索内容进行查询导游信息
    @SelectProvider(method = "findByContent", type = GuideMapper.GuideSqlBuilders.class)
    List<Guide> findByContent(String str,String id);

    //根据id删除导游信息
    @Delete("DELETE FROM guide WHERE id=#{id}")
    void del(int id);

    //根据id查询导游信息
    @Select("SELECT * FROM guide WHERE id=#{id}")
    Guide findById(int id);

    //修改导游信息
    @Update("UPDATE guide set lev=#{lev},name=#{name},gender=#{gender},age=#{age},lan=#{lan},route=#{route} WHERE id=#{id}")
    void modify(Guide guide);



    class GuideSqlBuilders {

        public String findByContent(String str,String id) {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT * FROM guide ");
            sql.append("  WHERE "+str+" = "+id );
            return sql.toString();
        }


    }

}
