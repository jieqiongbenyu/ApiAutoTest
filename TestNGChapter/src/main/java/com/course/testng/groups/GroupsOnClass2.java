package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "teacher")
public class GroupsOnClass2 {

    public void teacher1(){
        System.out.println("GroupsOnClass2~~~~~~teacher1");
    }
}
