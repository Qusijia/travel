package com.example.travel.api.controller;


import com.example.travel.entity.Guide;
import com.example.travel.entity.User;
import com.example.travel.service.GuideService;
import com.example.travel.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @Autowired
    private GuideService guideService;
//    @RequestMapping("/admin")
//    public ModelAndView mShift(HttpSession session) {
//        ModelAndView result = new ModelAndView();
//        result.setViewName("admin_manage");//转入后台管理页面
//        result.addObject("name",session.getAttribute("name"));
//        return result;
//    }
//

//    @RequestMapping("/test")
//    @ResponseBody
//    public String test() {
//        System.out.println("visitor visitor visitor visitor");
//        return "1111111111========333333333333333-------------------55555555555555555";
//    }
    @RequestMapping("/visitor")
    public ModelAndView sShift() {
        System.out.println("visitor visitor visitor visitor");
        ModelAndView result = new ModelAndView();
        result.setViewName("test");//转入游客界面
        return result;
    }


    @RequestMapping("/mindex")
    public ModelAndView mIndex() {
        ModelAndView result = new ModelAndView();
        result.setViewName("index");
        return result;
    }


    @RequestMapping("/mlogin")
    public ModelAndView login(String username, String password, HttpSession session){
        System.out.println("11111111111111"+username);
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("name="+username);
        /**
         * 使用Shiro编写认证操作
         */
        //1.获取Subject
        Subject subject = SecurityUtils.getSubject();

        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);

        //3.执行登录方法

        try {
            subject.login(token);
            session.setAttribute("username",username);
        } catch (IncorrectCredentialsException ice) {
            modelAndView.addObject("tips","*密码不正确~");
            modelAndView.setViewName("index");
            return modelAndView;
        }catch (ExcessiveAttemptsException eae) {
            modelAndView.addObject("tips","*用户名或密码错误次数过多~");
            modelAndView.setViewName("index");
            return modelAndView;
        } catch (AuthenticationException ae) {
            modelAndView.addObject("tips","*用户名或密码不正确~");
            modelAndView.setViewName("index");
            return modelAndView;
        }
        modelAndView.setViewName("main");
        modelAndView.addObject("name",username);
        return modelAndView;


    }

    @RequestMapping("/register")
    public ModelAndView register() {
        ModelAndView result = new ModelAndView();
        result.setViewName("regist");//转入注册界面
        return result;
    }

    @RequestMapping("/yanzheng")
    @ResponseBody
    public String yanzheng(@RequestBody User u) {

        System.out.println("555555555555555=====   ");
        String username = u.getName();//获取前台界面的username数据
        u.setLim(0);
        System.out.print("11111111   " +u);
        User user = userService.findByName(username);//调用userservice进行数据库查询
        if (user != null) {//用户存在
                return "2";
            }else{
            userService.save(u);
            User dbuser = userService.findByName(username);
            userService.addRole(dbuser.getId(),dbuser.getPhone());
        }
            return "1";//注册成功

    }

    @RequestMapping("/noAuth")
    public String noAuth(){
        return "noAuth";
    }

    @RequestMapping("/toUser")
    public ModelAndView toUser(HttpSession session) {
        ModelAndView result = new ModelAndView();
        User user = userService.findByName(session.getAttribute("username").toString());
        result.setViewName("user/user");//转入注册界面
        result.addObject("user",user);
        return result;
    }
    @RequestMapping("/toTravel")
    public ModelAndView toTravel() {
        ModelAndView result = new ModelAndView();
        result.setViewName("user/user_travel");//转入注册界面
        return result;
    }

    @RequestMapping("/index")
    public ModelAndView Index() {
        ModelAndView result = new ModelAndView();
        result.setViewName("test");
        return result;
    }
    @RequestMapping("/toTravelList")
    public ModelAndView toTravelList() {
        ModelAndView result = new ModelAndView();
        result.setViewName("travel/travel");//转入线路界面
        return result;
    }

    @RequestMapping("/toAddTravel")
    public ModelAndView toAddTravel() {
        ModelAndView result = new ModelAndView();
        result.setViewName("travel/addtravel");//转入线路界面
        return result;
    }

    @RequestMapping("/toGuide")
    public ModelAndView toGuide() {
        ModelAndView result = new ModelAndView();
        result.setViewName("guide/guidelist");//转入线路界面
        return result;
    }

    @RequestMapping("/toAddGuide")
    public ModelAndView toAddGuide() {
        ModelAndView result = new ModelAndView();
        result.setViewName("guide/addguide");//转入线路界面
        return result;
    }

    @RequestMapping("/toEditGuide/{id}")
    public ModelAndView toEditGuide(@PathVariable int id) {
        ModelAndView result = new ModelAndView();
        Guide guide = guideService.findById(id);
        result.setViewName("guide/editguide");//转入线路界面
        result.addObject("guide",guide);
        return result;
    }

    @RequestMapping("/toLine")
    public ModelAndView toLine() {
        ModelAndView result = new ModelAndView();
        result.setViewName("travel/lineForm");//转入线路界面
        return result;
    }



    @RequestMapping("/toCeshi")
    public ModelAndView toCeshi() {
        ModelAndView result = new ModelAndView();
        result.setViewName("ceshi/index");//转入线路界面
        return result;
    }

    @RequestMapping("/toAbout")
    public ModelAndView toAbout() {
        ModelAndView result = new ModelAndView();
        result.setViewName("ceshi/about");//转入线路界面
        return result;
    }

    @RequestMapping("/toIcons")
    public ModelAndView toIcons() {
        ModelAndView result = new ModelAndView();
        result.setViewName("ceshi/icons");//转入线路界面
        return result;
    }

    @RequestMapping("/toTypography")
    public ModelAndView toTypography() {
        ModelAndView result = new ModelAndView();
        result.setViewName("ceshi/typography");//转入线路界面
        return result;
    }

    @RequestMapping("/toGallery")
    public ModelAndView toGallery() {
        ModelAndView result = new ModelAndView();
        result.setViewName("ceshi/gallery");//转入线路界面
        return result;
    }

    @RequestMapping("/toContact")
    public ModelAndView toContact() {
        ModelAndView result = new ModelAndView();
        result.setViewName("ceshi/contact");//转入线路界面
        return result;
    }

    //测试下拉
    @RequestMapping("/toText")
    public ModelAndView toText() {
        ModelAndView result = new ModelAndView();
        result.setViewName("text");//转入线路界面
        return result;
    }
}
