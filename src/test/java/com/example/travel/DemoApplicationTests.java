package com.example.travel;

import com.example.travel.entity.Guide;
import com.example.travel.mapper.GuideMapper;
import com.example.travel.mapper.UTMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private GuideMapper mapper;

    @Autowired
    private UTMapper utMapper;

    @Test
    void GIVEN_查询导游_WHEN_THEN() {
        List<Guide> list=mapper.findAll();
        for (int i = 0; i < list.size(); i++){
            System.out.print(list.get(i));
        }

    }

    @Test
    void GIVEN_查询ut_WHEN_THEN() {
        List list=utMapper.findAll();
        System.out.println("------------");
        for (int i = 0; i < list.size(); i++){

            System.out.print(list.get(i));
        }

    }
}
