package com.example.travel.api.controller;

import com.example.travel.api.GuideApi;
import com.example.travel.entity.Guide;
import com.example.travel.service.GuideService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class GuideController implements GuideApi {

    @Autowired
    private GuideService guideService;

    @Override
    public String  addGuide(Guide guide) {
        System.out.println(guide);
        guideService.addGuide(guide);
        return "1";
    }

    @Override
    public Map<String, Object> findAll(int page, int limit, String queryType, String query , HttpSession session) {
        PageHelper.startPage(page,limit);
        List<Guide> guides = guideService.findAll();
        int  count = guides.size();
        PageInfo<Guide> guidePageInfo = new PageInfo<Guide>(guides);
        List<Guide> guideList = guidePageInfo.getList();

        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("code",0);
        resultMap.put("msg","");
        resultMap.put("count",count);
        resultMap.put("data",guideList);

        return resultMap;
    }

    @Override
    public List<Guide> findByContent(String str, String id) {
        return guideService.findByContent(str,id);
    }

    @Override
    public void del(int id) {
        guideService.del(id);
    }

    @Override
    public Guide findById(int id) {
        return guideService.findById(id);
    }

    @Override
    public String modify(Guide guide) {
        guideService.modify(guide);

        return "1";
    }
}
