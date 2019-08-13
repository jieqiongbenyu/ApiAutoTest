package com.course.testng.suit;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class SuitConfig {

    @BeforeSuite
    public void beforeSuit(){
        System.out.println("before suit");
    }

    @AfterSuite
    public void afterSuit(){
        System.out.println("after suit");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("before test");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("after test");
    }
}
