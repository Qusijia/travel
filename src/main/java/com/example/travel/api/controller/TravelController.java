package com.example.travel.api.controller;

import com.example.travel.api.TravelApi;
import com.example.travel.entity.Travel;
import com.example.travel.service.TravelService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TravelController implements TravelApi {

    @Autowired
    private TravelService travelService;

    @Override
    public List<Travel> findByContent(String name) {
        return travelService.findByContent(name);
    }

    @Override
    public List<Travel> findAll() {
        return travelService.findAll();
    }

    @Override
    public void save(Travel t) {
        travelService.save(t);
    }

    @Override
    public void del(int id) {
        travelService.del(id);
    }

    @Override
    public Travel findById(int id) {
        return travelService.findById(id);
    }

    @Override
    public void modify(Travel t) {
        travelService.modify(t);
    }

    @Override
    public Map<String, Object>  findByname(HttpSession session) {
        List<Travel> date =  travelService.findByname(session.getAttribute("username").toString());
        Map<String, Object> result = new HashMap<>();
        result.put("data", date);
        result.put("code", 0);
        return result;

    }

    @Override
    public Map<String, Object> findAllPage(int page, int limit, String queryType, String query ,HttpSession session) {
        PageHelper.startPage(page,limit);
        List<Travel> travels = travelService.find(session.getAttribute("username").toString());
        int  count = travels.size();
        PageInfo<Travel> travelPageInfo = new PageInfo<Travel>(travels);
        List<Travel> travelList = travelPageInfo.getList();

        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("code",0);
        resultMap.put("msg","");
        resultMap.put("count",count);
        resultMap.put("data",travelList);

        return resultMap;
    }
}
