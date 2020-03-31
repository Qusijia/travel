package com.example.travel.api.controller;

import com.example.travel.api.TravelApi;
import com.example.travel.entity.Travel;
import com.example.travel.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
