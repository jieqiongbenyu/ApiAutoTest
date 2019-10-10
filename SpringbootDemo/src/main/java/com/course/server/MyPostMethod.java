package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@Api(value = "/", description = "这是我的全部post方法")
@RequestMapping("/getDemo")
public class MyPostMethod {

    /**
     * 携带参数发起post请求，并返回cookies
     */
    @RequestMapping(value = "/post/cookies", method = RequestMethod.POST)
    @ApiOperation(value = "携带参数发起post请求，并返回cookies",httpMethod = "POST")
    public String login(HttpServletResponse response,
                        @RequestParam(value = "userName", required = true) String name,
                        @RequestParam(value = "password", required = true) String password){
        if (name.equals("zhangsan") && password.equals("123456")){
            Cookie cookie = new Cookie("userId","0000");
            response.addCookie(cookie);
            return "登录成功";
        }
        return "用户名密码错误";
    }

    /**
     * 携带参数和cookies发起post请求
     */
    @RequestMapping(value = "/get/with/cookies", method = RequestMethod.POST)
    @ApiOperation(value = "携带参数和cookies发起post请求", httpMethod = "POST")
    public Map<String, Integer> goodsList(HttpServletRequest request,
                         @RequestParam(value = "start", required = true) Integer start,
                         @RequestParam(value = "end") Integer end){
        Cookie[] cookies = request.getCookies();
        if (cookies == null){
            System.out.println("未携带cookies信息");
        }
        for (Cookie cookie: cookies){
            if (cookie.getName().equals("userId") && cookie.getValue().equals("1111")){
                System.out.println("cookies信息正确");
            }
            System.out.println("请检查cookies信息是否正确");
        }
        Map<String, Integer> goodsList = new HashMap<>();
        goodsList.put("手机壳", 50);
        goodsList.put("钥匙坠", 10);
        goodsList.put("衣服", 300);
        return goodsList;
    }

}
