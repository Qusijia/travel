package com.example.travel.api.controller;


import com.example.travel.entity.User;
import com.example.travel.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping("/admin")
    public ModelAndView mShift(HttpSession session) {
        ModelAndView result = new ModelAndView();
        result.setViewName("admin_manage");//转入后台管理页面
        result.addObject("name",session.getAttribute("name"));
        return result;
    }

    @RequestMapping("/visitor")
    public ModelAndView sShift() {
        ModelAndView result = new ModelAndView();
        result.setViewName("index");//转入游客界面
        return result;
    }

//    @GetMapping("/mlogin")
//    public String mLogin(HttpSession session, HttpServletRequest request) {
//        String username = request.getParameter("username");//获取前台界面的username数据
//        String password = request.getParameter("password");//获取前台界面的password数据
//
//        User user = userService.get(username, password);//调用userservice进行数据库查询
//        if (user != null) {//用户存在
//            session.setAttribute("user", user);//将角色设置到session
//            if (user.getRole() == 0) {
//                session.setAttribute("id", user.getId());//教务：将id存入session
//                System.out.println("11111111-------"+session.getAttribute("user"));
//            } else {
//                return "2";
//            }
//            return "1";//用户存在返回1
//        } else {
//            return "0";//用户不存在返回0
//        }
//    }

    @RequestMapping("/mindex")
    public ModelAndView mIndex() {
        ModelAndView result = new ModelAndView();
        result.setViewName("login");
        return result;
    }


    @GetMapping("/mlogin")
    public String login(String username, String password, HttpSession session){
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

           session.setAttribute("name",username);
            return "1";
        } catch (UnknownAccountException e) {
            //e.printStackTrace();
            //登录失败:用户名不存在
            return "2";
        }catch (IncorrectCredentialsException e) {
            //e.printStackTrace();
            //登录失败:密码错误
            return "3";
        }
    }

    @RequestMapping("/register")
    public ModelAndView register() {
        ModelAndView result = new ModelAndView();
        result.setViewName("register");//转入注册界面
        return result;
    }

    @PostMapping("/yanzheng")
    public String yanzheng(@RequestBody User u) {
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
