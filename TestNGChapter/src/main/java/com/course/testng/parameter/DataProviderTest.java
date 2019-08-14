package com.course.testng.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {

    @Test(dataProvider = "data")
    public void testDataProvider(String name, int age){
        System.out.println("name=" + name + " age=" + age);
    }

    @DataProvider(name = "data")
    public Object[][] providerData(){
        Object[][] o = new Object[][]{
                {"张三", 10},
                {"李四", 20},
                {"王五", 30}
        };
        return o;
    }

    @Test(dataProvider = "method")
    public void test1(String name, int age){
        System.out.println("test1111111111" + " " + name + " " + age);
    }

    @Test(dataProvider = "method")
    public void test2(String name, int age){
        System.out.println("test22222222222" + " " + name + " " + age);
    }

    @DataProvider(name = "method")
    public Object[][] testDataProvider1(Method method){
        Object[][] result = null;
        if (method.getName().equals("test1")){
            result = new Object[][]{
                    {"test1", 10},
                    {"test11", 20}
            };

        }else if (method.getName().equals("test2")){
            result = new Object[][]{
                    {"test2", 30},
                    {"test22", 40}
            };
        }
        return result;
    }


}
