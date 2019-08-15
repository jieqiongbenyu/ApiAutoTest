package com.course.testng;

import org.testng.annotations.Test;

public class TimeOutTest {

    @Test(timeOut = 2000)
    public void test1() throws InterruptedException {
        Thread.sleep(1000);
    }

    @Test(timeOut = 1000)
    public void test2() throws InterruptedException {
        Thread.sleep(2000);
    }
}
