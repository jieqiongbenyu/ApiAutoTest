package com.course.model;

import lombok.Data;

@Data
public class AddUserCase {
    private int id;
    private String user;
    private String password;
    private String age;
    private int sex;
    private int permission;
    private int isDelete;
    private String expected;

}
