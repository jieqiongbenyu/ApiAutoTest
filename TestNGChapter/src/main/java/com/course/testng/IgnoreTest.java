package com.course.testng;

import org.testng.annotations.Test;

public class IgnoreTest {

    @Test
    public void igonre1(){
        System.out.println("test 1");
    }

    @Test(enabled = false)
    public void ignore2(){
        System.out.println("test 2");
    }

    @Test(enabled = true)
    public void ignore3(){
        System.out.println("test 3");
    }
}
