package com.course.utils;

import com.course.model.InterfaceName;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 该工具类主要用于拼接url
 */
public class ConfigFile {
    /**
     * 加载resource中application.properties文件内容
     */
    private static ResourceBundle bundle = ResourceBundle.getBundle("application", Locale.CHINA);

    /**
     * 工具类用于拼接url，工具类一般都是static静态方法，好处是不用new了，直接可以使用
     * 该类的参数只能是model层中枚举类InterfaceName中定义的值
     */
    public static String getUrl(InterfaceName name){
        String address = bundle.getString("test.url");

        String uri;
        String testUrl;
        if (name == InterfaceName.ADDUSERINFO){
            uri = bundle.getString("addUser.uri");
        } else if (name == InterfaceName.GETUSERINFO){
            uri = bundle.getString("getUserInfo.uri");
        } else if (name == InterfaceName.GETUSERLIST ){
            uri = bundle.getString("getUserList.uri");
        } else if (name == InterfaceName.LOGIN){
            uri = bundle.getString("login.uri");
        } else {
            uri = bundle.getString("updateUserInfo.uri");
        }

         testUrl = address + uri;
        return testUrl;
    }

}
