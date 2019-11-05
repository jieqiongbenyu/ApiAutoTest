package com.course.controller;

import com.course.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
@RestController
@Api(value = "v1", description = "用户管理系统")
@RequestMapping(value = "v1")
public class UserManager {

    @Autowired
    private SqlSessionTemplate template;

    private boolean verifyCookes(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if (cookies == null){
            log.info("cookies为空");
            return false;
        }
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("login") & cookie.getValue().equals("true")){
                log.info("cookies校验成功");
                return true;
            }
        }
        return false;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "登录", httpMethod = "POST")
    public int login(HttpServletResponse response, @RequestBody User user){
        int i = template.selectOne("login", user);
        Cookie cookie = new Cookie("login", "true");
        response.addCookie(cookie);
        if (i == 1){ System.out.println("查询到的登录用户为" + user.getUser());
            log.info("查询到的登录用户为" + user.getUser());
        }
        return i;
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ApiOperation(value = "增加用户", httpMethod = "POST")
    public boolean addUser(HttpServletRequest request, @RequestBody User user){
        boolean x = verifyCookes(request);
        int result = 0;
        if (x == true){
            result = template.insert("addUser", user);
            log.info("添加用户成功");
            return true;
        }
        if (result > 0){
            log.info("增加的用户为" + user.getUser());
        }
        return false;
    }

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    @ApiOperation(value = "获取用户信息", httpMethod = "POST")
    public List<User> getUserInfo(HttpServletRequest request, @RequestBody User user){
        boolean x = verifyCookes(request);
        if (x == true){
            List<User> users = template.selectList("getUserInfo", user);
            log.info("获取用户的数量为" + users.size());
            return users;
        } else {
            log.info("未获取到用户信息");
            return null;
        }
    }

    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
    @ApiOperation(value = "更新/删除用户信息", httpMethod = "POST")
    public int updateUserInfo(HttpServletRequest request, @RequestBody User user){
        boolean x = verifyCookes(request);
        int result = 0;
        if (x == true){
            result = template.update("updateUserInfo", user);
        }
        log.info("更新用户数量为：" + result);
        //如果返回0说明更新失败，返回1说明更新成功
        return result;
    }


}
