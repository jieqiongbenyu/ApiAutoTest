package com.test.report;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestReportDemo {

    @Test
    public void test1(){
        Assert.assertEquals(1,2);
    }

    @Test
    public void test2(){
        Assert.assertEquals(1,1);
    }

    @Test
    public void test3(){
        Assert.assertEquals("aaa", "aaa");
    }

    @Test
    public void logTest(){
        Reporter.log("这是我们自己的日志内容");
        throw new RuntimeException("这是我们自己抛出的异常");
    }
}
