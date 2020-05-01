package com.example.travel.service.impl;

import com.example.travel.entity.Travel;
import com.example.travel.entity.UT;
import com.example.travel.entity.User;
import com.example.travel.mapper.UTMapper;
import com.example.travel.service.UTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UTServiceImpl implements UTService {

    @Autowired
    private UTMapper utMapper;

    @Override
    public List<UT> findAll() {
        return utMapper.findAll();
    }

    @Override
    public List<UT> findByName(String name) {
        return utMapper.findByName( name);
    }

    @Override
    public void del(String uname, int tid) {
        utMapper.del( uname,  tid);
    }

    @Override
    public Integer add(String uname, Travel t) {
        return utMapper.add( uname,  t);
    }

    @Override
    public UT findByUT(String uname, int tid) {
        return utMapper.findByUT( uname,  tid);
    }

    @Override
    public List selectCount() {
        return utMapper.selectCount();
    }

    @Override
    public List selectMoney() {
        return utMapper.selectMoney();
    }

    @Override
    public List selectAll() {
        return utMapper.selectAll();
    }

    @Override
    public List<User> findByTid(int id) {
        return utMapper.findByTid(id);
    }
}
