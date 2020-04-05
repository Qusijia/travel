package com.example.travel.api.controller;

import com.example.travel.api.UTApi;
import com.example.travel.entity.Travel;
import com.example.travel.entity.UT;
import com.example.travel.service.UTService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qsj
 * @create 05 - 21:44
 */
public class UtController implements UTApi {

    @Autowired
    private UTService utService;
    @Override
    public List<UT> findAll() {
        return utService.findAll();
    }

    @Override
    public Map<String, Object> findByName(HttpSession session) {
        List date = utService.findByName(session.getAttribute("username").toString());
        Map<String, Object> result = new HashMap<>();
        result.put("data", date);
        result.put("code", 0);
        return result;
    }

    @Override
    public String del(String uname, int tid) {
        utService.del(uname,tid);
        return "1";
    }

    @Override
    public Integer add(String uname, Travel t) {
        return utService.add(uname,t);
    }

    @Override
    public UT findByUT(String uname, int tid) {
        return utService.findByUT(uname,tid);
    }

    @Override
    public List selectCount() {
        return utService.selectCount();
    }

    @Override
    public List selectMoney() {
        return utService.selectMoney();
    }

    @Override
    public List selectAll() {
        return utService.selectAll();
    }
}
