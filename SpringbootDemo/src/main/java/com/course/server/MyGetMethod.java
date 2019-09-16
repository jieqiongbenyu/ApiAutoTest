package com.course.server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyGetMethod {

    @RequestMapping(value = "/get/cookies", method = RequestMethod.GET)
    public String getCookies(){
        return "获取cookies成功了啊";
    }
}
