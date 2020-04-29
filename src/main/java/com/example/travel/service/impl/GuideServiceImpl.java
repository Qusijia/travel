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
    public List<Guide> findAll(String query) {
        List<Guide> guides = new ArrayList<Guide>();
//        if(!query.equals("")){
//
//            System.out.println("findByContentfindByContentfindByContentfindByContent");
//            guides =guideMapper.findByContent(query);
//
//        }else{
            guides =guideMapper.findAll();
//        }
            return guides;

    }

    @Override
    public int findRows() {
        return guideMapper.findRows();
    }

    @Override
    public List<Guide> findByContent(String queryType,String query) {
        System.out.println("findByContentfindByContent11");
        List<Guide> guides = new ArrayList<Guide>();
        if(!query.equals("")) {
            System.out.println("111111111");
            if("name".equals(queryType)){
                System.out.println("  name  ");
                guides =guideMapper.findByContent("name"," LIKE  '%"+query+"%'");
            }else if("gender".equals(queryType)){
                System.out.println("  gender  ");
                guides =guideMapper.findByContent("gender","= "+"'"+query+"'");
            }else {
                System.out.println("  lanlanlan  ");
                guides =guideMapper.findByContent("lan","= "+"'"+query+"'");
            }
        }else{
            System.out.println("findAll  ");
            guides =guideMapper.findAll();
        }
        return guides;
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
