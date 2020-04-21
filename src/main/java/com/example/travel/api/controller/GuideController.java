package com.example.travel.api.controller;

import com.example.travel.api.GuideApi;
import com.example.travel.entity.Guide;
import com.example.travel.entity.User;
import com.example.travel.service.GuideService;
import com.example.travel.service.UserService;
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

    @Autowired
    private UserService userService;

    @Override
    public String addGuide(Guide guide) {
        System.out.println(guide);
        guideService.addGuide(guide);
        User user = new User();
        user.setLim(0);
        user.setAge(guide.getAge());
        user.setGender(guide.getGender());
        user.setName(guide.getName());
        user.setPassword("123456");
        userService.save(user);
        User dbuser = userService.findByName(guide.getName());
        userService.addRole(dbuser.getId(),user.getPhone());
//        ModelAndView result = new ModelAndView();
//        result.setViewName("success");//转入游客界面
//        return result;
        return  "1";
    }

    @Override
    public Map<String, Object> findAll(int page, int limit, String queryType, String query , HttpSession session) {
        PageHelper.startPage(page,limit);
        List<Guide> guides = guideService.findAll();
        int  count = guides.size();
        System.out.println(count);
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
    public Map<String, Object> findAll() {
        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("data",guideService.findAll());
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
