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
}
