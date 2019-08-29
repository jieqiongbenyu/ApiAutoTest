package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class RequestWithCookiesForPost {

    /**
     * 从startupWithCookiesPost.json中获取cookies信息，携带该cookies信息去post请求最后校验
     */

    private String dev_url;
    private String get_cookies_uri;
    private String post_with_cookies_uri;
    private ResourceBundle bundle;
    private CookieStore store;

    @BeforeTest
    public void getProperties(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        dev_url = bundle.getString("dev.url");
        get_cookies_uri = bundle.getString("post.with.cookiesForGet.uri");
        post_with_cookies_uri = bundle.getString("post.with.cookies.uri");
    }

    @Test
    public void getCookies(){
        String url = this.dev_url + this.get_cookies_uri;
        // 声明一个httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 声明一个请求，此处是get请求
        HttpGet get = new HttpGet(url);
        // 声明一个httpclientcontext对象，用来传递请求的上下文
        HttpClientContext context = HttpClientContext.create();
        // 执行get请求并将执行结果返回到一个httpresponse对象
        try {
            HttpResponse response = httpClient.execute(get,context);
            //获取cookies并返回给store
            this.store = context.getCookieStore();
            List<Cookie> cookies = this.store.getCookies();
            for(Cookie cookie: cookies){
                String cookieName = cookie.getName();
                String cookieValue = cookie.getValue();
                System.out.println("=======cookies信息========");
                System.out.println("name:" + cookieName + "\n" + "value:" + cookieValue);
            }
            String result = EntityUtils.toString(response.getEntity());
            System.out.println("==========response=========");
            System.out.println(result);
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e){
                e.printStackTrace();
            }

        }

    }

    @Test(dependsOnMethods = {"getCookies"})
    public void requestWithCookies(){
        String url = this.dev_url + this.post_with_cookies_uri;
        //声明一个httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //声明post请求
        HttpPost post = new HttpPost(url);
        // 声明一个httpclientcontext对象，用来传递请求的上下文
        HttpClientContext context = HttpClientContext.create();
        //设置参数
        JSONObject param = new JSONObject();
        param.put("name","zhangsan");
        param.put("age","18");
        //设置头信息
        post.setHeader("Content-type","application/json");
        //将参数添加到方法中
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        //设置cookies信息
        context.setCookieStore(this.store);
        //执行post请求
        try {
            HttpResponse response = httpClient.execute(post,context);
            //获取响应结果
            String result = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result);
            //将String类型的响应结果转换成json格式
            JSONObject resultJson = new JSONObject(result);
            //获取json类型的响应结果，通过key拿到对应点value
            String name = (String) resultJson.get("张三");
            String status = (String) resultJson.get("status");
            Assert.assertEquals("是个男的", name);
            Assert.assertEquals("今年18岁", status);
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e){
                e.printStackTrace();
            }

        }



        //处理响应结果并进行校验

    }

}
