package com.example.travel.api.controller;

import com.example.travel.api.TravelApi;
import com.example.travel.entity.Guide;
import com.example.travel.entity.Travel;
import com.example.travel.entity.Travel_Guide;
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
    public String save( Travel t , int  service) {
        if(service != 0 ){
            Guide guide = guideService.findById(service);
            int lev = guide.getLev();//获取导游等级  最多带线 1：2条
            List<GuideToTravel> travels =travelService.LineFrom(service);

            if(lev == 1){
                if(travels.size()>=2){
                    return "0";//该导游已达到最大带团数，请选择别的导游
                }
            }

            travelService.save(t);
            Travel travel = travelService.findNotById(t);
            travelService.saveTravelGuid(new Travel_Guide(travel.getId(),service));
        }else{
            travelService.save(t);

        }

        return "1";
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
    public String modify(Travel t ) {
        System.out.println("modifymodifyTravelTravelmodify");
        System.out.println(t);
        travelService.modify(t);
        return "1";
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
        PageInfo<Travel> travelPageInfo = new PageInfo<Travel>(travels);
        List<Travel> travelList = travelPageInfo.getList();

        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("code",0);
        resultMap.put("msg","");
        resultMap.put("count",travelPageInfo.getTotal());
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

    //查询某导游负责线路统计信息
    @Override
    public Map<String, Object> guideLinePage(int id, int page, int limit, String query) {
        PageHelper.startPage(page,limit);
        List<GuideToTravel> travels = travelService.LineFrom(id);
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
