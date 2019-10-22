package com.course.controller;

import com.course.model.Book;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping(value = "/insertIntoBook", method = RequestMethod.POST)
    @ApiOperation(value = "像book表中插入一条数据", httpMethod = "POST")
    public int insertBook(@RequestBody Book book){
        return template.insert("insertIntoBook", book);

    }

    @RequestMapping(value = "/getInfoFromBook", method = RequestMethod.GET)
    @ApiOperation(value = "获取book表中某一条数据的信息", httpMethod = "GET")
    public Book getBookInfo(@RequestParam Integer id){
        return template.selectOne("getBookInfo", id);
    }
//    public List<String> getBookInfo(@RequestBody Book book){
//        return template.selectOne("getBookInfo", book);
//    }

    @RequestMapping(value = "/updateBook", method = RequestMethod.POST)
    @ApiOperation(value = "修改Book表的数据", httpMethod = "POST")
    public int updateBookInfo(@RequestBody Book book){
        return template.update("updateBook",book);
    }

    @RequestMapping(value = "/deleteBookInfo", method = RequestMethod.GET)
    @ApiOperation(value = "删除Book表中的数据", httpMethod = "GET")
    public int deleteBookInfo(@RequestParam Integer id){
        return template.delete("deleteFormBook", id);
    }
}
