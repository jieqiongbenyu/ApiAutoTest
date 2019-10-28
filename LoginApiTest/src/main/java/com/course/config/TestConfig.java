package com.course.config;

import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.CloseableHttpClient;

/**
 * 主要内容是对应接口的url
 */
public class TestConfig {
    public static String loginUrl;
    public static String updateUserInfoUrl;
    public static String getUserListUrl;
    public static String getUserInfoUrl;
    public static String addUseUrl;

    public static CloseableHttpClient httpClient;
    public static CookieStore cookieStore;
}
