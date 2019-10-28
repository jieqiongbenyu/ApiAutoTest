package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.InterfaceName;
import com.course.utils.ConfigFile;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
    // 涉及到跨文件执行，所以执行之前涉及到的依赖弄成组依赖
    @BeforeTest(groups = "LoginTrue", description = "测试准备工作：1、给TestConfig配置类中涉及的url赋值；2、生成httpclient对象")
    public void BeforeTest(){
        TestConfig.addUseUrl = ConfigFile.getUrl(InterfaceName.ADDUSERINFO);
        TestConfig.getUserInfoUrl = ConfigFile.getUrl(InterfaceName.GETUSERINFO);
        TestConfig.getUserListUrl = ConfigFile.getUrl(InterfaceName.GETUSERLIST);
        TestConfig.loginUrl = ConfigFile.getUrl(InterfaceName.LOGIN);
        TestConfig.updateUserInfoUrl = ConfigFile.getUrl(InterfaceName.UPDATEUSERLISTINFO);

        TestConfig.httpClient = HttpClients.createDefault();
    }
}
