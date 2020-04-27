package com.example.travel.service.impl;

import com.example.travel.entity.Travel;
import com.example.travel.mapper.TravelMapper;
import com.example.travel.service.TravelService;
import com.example.travel.tool.GuideToTravel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TravelServiceImpl implements TravelService {

    @Autowired
    private TravelMapper travelMapper;

    @Override
    public List<Travel> findByContent(String name) {
        return travelMapper.findByContent(name);
    }

    @Override
    public List<Travel> findAll() {
        return travelMapper.findAll();
    }

    @Override
    public void save(Travel t) {
        travelMapper.save(t);
    }

    @Override
    public void del(int id) {
        travelMapper.del(id);
    }

    @Override
    public Travel findById(int id) {
        return travelMapper.findById(id);
    }

    @Override
    public void modify(Travel t) {
        travelMapper.modify(t);
    }

    @Override
    public List<Travel> findByname(String name) {
        return travelMapper.findByname(name);
    }

    @Override
    public int findRows() {
        return travelMapper.findRows();
    }

    @Override
    public List<Travel> find(String name ,String query) {
        System.out.println("111111111---  +  "+query.equals("") +"  ------");
        List<Travel> travelList = new ArrayList<Travel>();
        if(!query.equals("")){

            System.out.println("findByContentfindByContentfindByContentfindByContent");
            travelList=travelMapper.findByContent(query);

        }else {
            System.out.println("findAllfindAllfindAll");
            travelList = travelMapper.findAll();

        }

        List<Travel> travels = travelMapper.findByname(name);
        for (Travel t:travels) {
            int id = t.getId();
           for (int i =0;i<travelList.size();i++){
               if(t.getId() == travelList.get(i).getId()){
                   travelList.remove(i);
               }
           }
        }
        return travelList;
    }

    @Override
    public List<GuideToTravel> LineFrom(int gid) {
        List<Travel> travels=travelMapper.LineFrom(gid);
        List<GuideToTravel> guideToTravels = new ArrayList<GuideToTravel>();
        if(travels !=null) {
            for (Travel travel : travels) {
                GuideToTravel guideToTravel = new GuideToTravel(travel, travelMapper.LineNum(travel.getId()));
                guideToTravels.add(guideToTravel);
            }
        }
        return guideToTravels;
    }

    @Override
    public int LineNum(int tid) {
        return travelMapper.LineNum(tid);
    }

    @Override
    public void delTravelAndGuide(int id) {
        travelMapper.delTravelAndGuide(id);
    }


}
