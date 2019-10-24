package com.course.model;

import lombok.Data;

@Data
public class User {

    private int id;
    private String user;
    private String password;
    private String age;
    private int sex;
    private int permission;
    private int isDelete;

    //将数据已json格式返回
    @Override
    public String toString(){

        return (
                "{id:" + id + "," +
                "{user:" + user + "," +
                "{password:" + password + "," +
                "{age:" + age + "," +
                "{sex:" + sex + "," +
                "{permission:" + permission + "," +
                "{isDelete:" + isDelete + "}"
                );
    }
}
