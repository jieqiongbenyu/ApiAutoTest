package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@Api(value = "/", description = "这是我全部的get方法")
public class MyGetMethod {

    /**
     * 发起get请求，返回cookies信息
     * @param response
     * @return
     */
    @RequestMapping(value = "/get/cookies", method = RequestMethod.GET)
    @ApiOperation(value = "通过这个get请求可以获取cookies信息", httpMethod = "GET")
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
    @ApiOperation(value = "携带cookies信息发起get请求", httpMethod = "GET")
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

    /**
     * 携带请求参数才能进行的get请求
     * 方法一：请求url为 host:port/XXXX?param=value&param=value形式
     * 以模拟一个商品列表为例
     */
    @RequestMapping(value = "/get/with/param", method = RequestMethod.GET)
    @ApiOperation(value = "携带请求参数才能进行的get请求,host:port/XXXX?param=value&param=value形式"
    , httpMethod = "GET")
    public Map<String, Integer> getList(@RequestParam Integer start, @RequestParam Integer end){
        Map<String, Integer> myList = new HashMap<>();
        myList.put("鞋", 200);
        myList.put("T恤", 100);
        myList.put("小浣熊", 2);
        return myList;
    }

    /**
     * 携带请求参数才能执行的get请求
     * 方法二：请求url为 host:port/XXX/param1/param2形式
     */
    @RequestMapping(value = "/get/with/paramter/{start}/{end}")
    @ApiOperation(value = "携带请求参数才能执行的get请求,host:port/XXX/param1/param2形式"
    , httpMethod = "GET")
    public Map<String, Integer> getGoodsList(@PathVariable Integer start, @PathVariable Integer end){
        Map<String, Integer> myGoodsList = new HashMap<>();
        myGoodsList.put("帽子", 1000);
        myGoodsList.put("袜子", 10);
        return myGoodsList;
    }
}
