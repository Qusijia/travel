package com.example.travel.service.impl;

import com.example.travel.entity.Travel;
import com.example.travel.mapper.TravelMapper;
import com.example.travel.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Travel> find(String name) {
        List<Travel> travelList = travelMapper.findAll();
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


}
