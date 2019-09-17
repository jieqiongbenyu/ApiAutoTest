package com.course.server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class MyGetMethod {

    /**
     * 发起get请求，返回cookies信息
     * @param response
     * @return
     */
    @RequestMapping(value = "/get/cookies", method = RequestMethod.GET)
    public String getCookies(HttpServletResponse response){
        Cookie cookies = new Cookie("login", "true1");
        response.addCookie(cookies);
        return "获取cookies成功了啊";
    }

    /**
     * 携带cookies信息发起get请求
     * @param request
     * @return
     */
    @RequestMapping(value = "/get/with/cookies", method = RequestMethod.GET)
    public String getWithCookies(HttpServletRequest request){
        //获取请求中的cookies
        Cookie[] cookies = request.getCookies();
        //判断cookies是否为空，为空时返回提示请求需要携带cookies
        if (cookies == null){
            return "请求时未携带cookies";
        }
        //cookies不为空时做以下处理
        for (Cookie cookie: cookies){
            if (cookie.getName().equals("login") && cookie.getValue().equals("true1")){
                return "携带cookies请求成功";
            } else {
                return "请求携带的cookies信息不正确";
            }
        }
        return "这是一个携带cookies信息的get请求";

    }
}
