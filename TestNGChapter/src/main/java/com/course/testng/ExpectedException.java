package com.course.testng;

import org.testng.annotations.Test;

public class ExpectedException {

    @Test(expectedExceptions = ArithmeticException.class)
    public void arithmeticExceptionTest(){
        System.out.println("程序会抛出一个ArithmeticException，期望结果也是抛出ArithmeticException");
        int a = 0;
        int b = 10/a;

    }
}
