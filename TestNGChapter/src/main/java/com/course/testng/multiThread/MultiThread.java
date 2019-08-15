package com.course.testng.multiThread;

import org.testng.annotations.Test;

public class MultiThread {

    @Test(invocationCount = 10, threadPoolSize = 3)
    public void multiThreadTest(){
        System.out.println("1");
        System.out.printf("ThreadId: %s%n", Thread.currentThread().getId());
    }
}
