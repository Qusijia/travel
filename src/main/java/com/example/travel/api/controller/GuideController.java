package com.example.travel.api.controller;

import com.example.travel.api.GuideApi;
import com.example.travel.entity.Guide;
import com.example.travel.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GuideController implements GuideApi {

    @Autowired
    private GuideService guideService;

    @Override
    public void addGuide(Guide guide) {
        guideService.addGuide(guide);
    }

    @Override
    public List<Guide> findAll() {
        return guideService.findAll();
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
    public void modify(Guide guide) {
        guideService.modify(guide);
    }
}
