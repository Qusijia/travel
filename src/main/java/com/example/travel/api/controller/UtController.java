package com.example.travel.api.controller;

import com.example.travel.api.UTApi;
import com.example.travel.entity.Travel;
import com.example.travel.entity.UT;
import com.example.travel.entity.User;
import com.example.travel.service.UTService;
import com.example.travel.tool.reportFrom;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qsj
 * @create 05 - 21:44
 */

@RestController
public class UtController implements UTApi {

    @Autowired
    private UTService utService;

    @Override
    public List<UT> findAll() {
        return utService.findAll();
    }

    @Override
    public Map<String, Object> findByName(HttpSession session) {
        List date = utService.findByName(session.getAttribute("username").toString());
        Map<String, Object> result = new HashMap<>();
        result.put("data", date);
        result.put("code", 0);
        return result;
    }

    @Override
    public String del(int id , HttpSession session) {
        System.out.println("1111111111111111");
        utService.del(session.getAttribute("username").toString(),id);
        return "1";
    }

    @Override
    public String add( Travel travel ,  HttpSession session) {
        utService.add(session.getAttribute("username").toString(),travel);
        return "1";
    }

    @Override
    public UT findByUT(String uname, int tid) {
        return utService.findByUT(uname,tid);
    }

    @Override
    public List selectCount() {
        return utService.selectCount();
    }

    @Override
    public List selectMoney() {
        return utService.selectMoney();
    }

    @Override
    public List<reportFrom> selectAll() {
        return utService.selectAll();
    }

//    // 提供数据的接口用于显示
//    @GetMapping("/list")
//    @ResponseBody
//    public List<Product> productList() {
//        return Arrays.asList(
//                new Product("酸奶", 4),
//                new Product("大食桶", 5),
//                new Product("安慕希", 8),
//                new Product("津威", 2),
//                new Product("汉堡包", 10)
//        );
//    }

    @Override
    public Map<String, Object> findByTid(int tid , int page, int limit) {

        System.out.println("findByTidfindByTidfindByTidfindByTid");
        PageHelper.startPage(page,limit);
        List<User> users =  utService.findByTid(tid);
        PageInfo<User> userPageInfo = new PageInfo<User>(users);
        List<User> userList = userPageInfo.getList();

        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("code",0);
        resultMap.put("msg","");
        resultMap.put("count",userPageInfo.getTotal());
        resultMap.put("data",userList);

        return resultMap;

    }
}
