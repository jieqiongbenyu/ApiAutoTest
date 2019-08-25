package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {

    private String dev_url;
    private String uri;
    private ResourceBundle bundle;

    @BeforeTest
    public void beforeTest(){
        // ResourceBundle工具类中的getBundle()方法可以读取.properties文件，文件只需要写名称即可，不用写后面的.properties后缀名
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        dev_url = bundle.getString("dev.url");
        uri = bundle.getString("getCookies.uri");
    }

    @Test
    public void test() throws IOException {
        String result;
        //拼接完整的get请求url
        String testUrl = this.dev_url + this.uri;

        //创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet get = new HttpGet(testUrl);
        HttpResponse response = httpClient.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
    }
}
