package com.course.testng;
import org.testng.annotations.*;

public class BasicAnnotation {

    @Test
    public void testCase1(){
        System.out.println("test这是测试用例1");
    }

    @Test
    public void testCase2(){
        System.out.println("test这是测试用例2");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforemethod这是在方法之前执行的");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("aftermethod这是在方法之后执行的");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeclass这是类运行执行执行的");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("afterclass这是类运行之后执行的");
    }

    @BeforeSuite
    public void beforeSuit(){
        System.out.println("beforesuit测试套件");
    }

    @AfterSuite
    public void afterSuit(){
        System.out.println("aftersuit测试套件");
    }

}
