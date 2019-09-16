package com.course.server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
public class MyGetMethod {

    @RequestMapping(value = "/get/cookies", method = RequestMethod.GET)
    public String getCookies(HttpServletResponse response){
        Cookie cookies = new Cookie("login", "true1");
        response.addCookie(cookies);
        return "获取cookies成功了啊";
    }
}
