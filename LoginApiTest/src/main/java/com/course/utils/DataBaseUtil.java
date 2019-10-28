package com.course.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class DataBaseUtil {

    /**
     * 该类主要是生成一个可以执行sql语句的对象
     */
    public static SqlSession getSqlSession() throws IOException {
        // 获取配置的资源文件
        Reader reader = Resources.getResourceAsReader("databaseConfig.xml");
        //使用类加载器加载文件
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        //返回能够执行配置文件中sql语句的对象
        SqlSession sqlSession = factory.openSession();
        return  sqlSession;
    }
}
