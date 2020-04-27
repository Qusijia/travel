package com.example.travel.api.controller;

import com.example.travel.api.TravelApi;
import com.example.travel.entity.Guide;
import com.example.travel.entity.Travel;
import com.example.travel.service.GuideService;
import com.example.travel.service.TravelService;
import com.example.travel.tool.GuideToTravel;
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
    @Autowired
    private GuideService guideService;

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
    public String del(int id) {

        if(travelService.LineNum(id)==0){//线路报名人数为0
            travelService.delTravelAndGuide(id);
            travelService.del(id);

            return "1";
        }
        return "2";
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


    //查询用户未参加的路线
    @Override
    public Map<String, Object> findAllPage(int page, int limit, String query ,HttpSession session) {
        PageHelper.startPage(page,limit);
        List<Travel> travels = travelService.find(session.getAttribute("username").toString(),query);
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

    //查询导游负责线路统计信息
    @Override
    public Map<String, Object> LinePage(int page, int limit, String query, HttpSession session) {
        PageHelper.startPage(page,limit);

        Guide guide=guideService.findByName(session.getAttribute("username").toString());
        List<GuideToTravel> travels = travelService.LineFrom(guide.getId());
        int  count = travels.size();
        PageInfo<GuideToTravel> travelPageInfo = new PageInfo<GuideToTravel>(travels);
        List<GuideToTravel> travelList = travelPageInfo.getList();

        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("code",0);
        resultMap.put("msg","");
        resultMap.put("count",count);
        resultMap.put("data",travelList);

        return resultMap;
    }
}
