package com.course.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "v1", description = "这是mybatis的第一个demo")
@RequestMapping("v1")

public class Demo {
    // 获取一个执行sql语句的对象，@AutoWired注解的意思是启动及加载，即启动Demo这个类的时候就加载被这个注解注释的对象

    @Autowired
    private SqlSessionTemplate template;

    @RequestMapping(value = "/getBookCount", method = RequestMethod.GET)
    @ApiOperation(value = "获取到book表的数据数量", httpMethod = "GET")
    public int getBookCount(){
        return template.selectOne("getBookCount");
    }

}
