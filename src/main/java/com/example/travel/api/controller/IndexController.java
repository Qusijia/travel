package com.example.travel.api.controller;


import com.example.travel.entity.User;
import com.example.travel.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
public class IndexController {

    @Autowired
    private UserService userService;

//    @RequestMapping("/admin")
//    public ModelAndView mShift(HttpSession session) {
//        ModelAndView result = new ModelAndView();
//        result.setViewName("admin_manage");//转入后台管理页面
//        result.addObject("name",session.getAttribute("name"));
//        return result;
//    }
//

    @RequestMapping("/test")
    public String test() {
        System.out.println("visitor visitor visitor visitor");
        return "1111111111========333333333333333";
    }
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
        } catch (UnknownAccountException uae) {
            modelAndView.addObject("tips","*未知账户~");
            modelAndView.setViewName("index");
            return modelAndView;
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
            userService.addRole(dbuser.getId());
        }
            return "1";//注册成功

    }

    @RequestMapping("/noAuth")
    public String noAuth(){
        return "redirect:/noAuth";
    }
}
