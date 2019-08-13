package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethod {

    @Test(groups = "server")
    public void server1(){
        System.out.println("server1111111111");
    }

    @Test(groups = "server")
    public void server2(){
        System.out.println("server2222222222");
    }

    @Test(groups = "client")
    public void server3(){
        System.out.println("server3333333333");
    }

    @Test(groups = "client")
    public void server4(){
        System.out.println("server4444444444");
    }

    @BeforeGroups("server")
    public void beforeGroups(){
        System.out.println("server之前运行");
    }

    @AfterGroups("server")
    public void afterGroups(){
        System.out.println("server之后运行");
    }

    @BeforeGroups("client")
    public void beforeGroupsClient(){
        System.out.println("client之前运行");
    }

    @AfterGroups("client")
    public void afterGroupsClient(){
        System.out.println("client之后运行");
    }
}
