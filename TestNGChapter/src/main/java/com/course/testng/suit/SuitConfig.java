package com.course.testng.suit;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class SuitConfig {

    @BeforeSuite
    public void beforeSuit(){
        System.out.println("before suit");
    }

    @AfterSuite
    public void afterSuit(){
        System.out.println("after suit");
    }
}
