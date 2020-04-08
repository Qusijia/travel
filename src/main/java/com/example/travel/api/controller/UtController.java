package com.example.travel.api.controller;

import com.example.travel.api.UTApi;
import com.example.travel.entity.Travel;
import com.example.travel.entity.UT;
import com.example.travel.service.UTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qsj
 * @create 05 - 21:44
 */

@Controller
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
    public String del(int id , HttpSession session) {
        System.out.println("1111111111111111");
        utService.del(session.getAttribute("username").toString(),id);
        return "1";
    }

    @Override
    public String add( Travel travel ,  HttpSession session) {
        utService.add(session.getAttribute("username").toString(),travel);
        return "1";
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
