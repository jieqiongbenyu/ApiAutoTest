package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class GetCookies {

    private String dev_url;
    private String uri;
    private ResourceBundle bundle;

    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        dev_url = bundle.getString("dev.url");
        uri = bundle.getString("getCookies.uri");
    }

//    @Test
//    public void test() throws IOException {
//        String url = this.dev_url + this.uri;
//        System.out.println(url);
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        HttpGet get = new HttpGet(url);
//        HttpResponse response = httpClient.execute(get);
//
//        String result = EntityUtils.toString(response.getEntity());
//        System.out.println(result);
//        //获取cookies信息
//        CookieStore store = new BasicCookieStore();
//        List<Cookie> cookieList = store.getCookies();
//        for (Cookie cookie: cookieList){
//            String name = cookie.getName();
//            String value = cookie.getValue();
//            System.out.println("name=" + name + "/n" + "value=" + value);
//        }
//    }
    @Test
    public void getCookie(){
        String url = this.dev_url + this.uri;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet get=new HttpGet(url);
        HttpClientContext context = HttpClientContext.create();
        try {
            CloseableHttpResponse response = httpClient.execute(get, context);
            try{
                System.out.println(">>>>>>headers:");
                Arrays.stream(response.getAllHeaders()).forEach(System.out::println);
                System.out.println(">>>>>>cookies:");
                context.getCookieStore().getCookies().forEach(System.out::println);
            }
            finally {
                response.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
