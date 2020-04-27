package com.example.travel.service.impl;

import com.example.travel.entity.Guide;
import com.example.travel.mapper.GuideMapper;
import com.example.travel.service.GuideService;
import com.example.travel.tool.GuideVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GuideServiceImpl implements GuideService {

    @Autowired
    private GuideMapper guideMapper;

    @Override
    public void addGuide(Guide guide) {
        guideMapper.addGuide(guide);
    }

    @Override
    public List<Guide> findAll() {
        return guideMapper.findAll();
    }

    @Override
    public int findRows() {
        return guideMapper.findRows();
    }

    @Override
    public List<Guide> findByContent(String str, String id) {
        return guideMapper.findByContent(str,id);
    }

    @Override
    public void del(int id) {
        guideMapper.del(id);
    }

    @Override
    public Guide findById(int id) {
        return guideMapper.findById(id);
    }

    @Override
    public Guide findByName(String name) {
        return guideMapper.findByName(name);
    }

    @Override
    public void modify(Guide guide) {
        guideMapper.modify(guide);
    }

    @Override
    public List<GuideVo> findSelect() {

        return  GuideToVo(guideMapper.findAll());
    }

    public List<GuideVo> GuideToVo(List<Guide> guides){
        List<GuideVo> guideVos=new ArrayList<GuideVo>();
        for(Guide guide : guides){
            guideVos.add(new GuideVo(guide.getId(),guide.getName()));
        }
        return guideVos;
    }
}
