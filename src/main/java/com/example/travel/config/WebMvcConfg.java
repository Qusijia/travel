//package com.example.travel.config;
//
//import com.example.travel.interceptor.UserLoginInterceptor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
///**
// * @author qsj
// * @create 18 - 20:32
// */
//@Configuration
//public class WebMvcConfg implements WebMvcConfigurer {
//
//    public final static String SESSION_KEY = "user";
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new UserLoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/mindex","/mlogin","/register","/yanzheng");
//    }
//
//}
