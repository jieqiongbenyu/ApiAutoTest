package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.UpdateUserInfoCase;
import com.course.utils.DataBaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.testng.annotations.Test;

import java.io.IOException;

public class UpdateUserInfoTest {

    @Test(dependsOnGroups = "LoginTrue", description = "更新用户信息")
    public void updateUserInfo() throws IOException {
        SqlSession sqlSession = DataBaseUtil.getSqlSession();
        UpdateUserInfoCase updateUserInfo = sqlSession.selectOne("updateUserInfoTest", 1);
        System.out.println(updateUserInfo.toString());
        System.out.println(TestConfig.updateUserInfoUrl);
    }

    @Test(dependsOnGroups = "LoginTrue", description = "删除指定用户")
    public void deleteUser() throws IOException {
        SqlSession sqlSession = DataBaseUtil.getSqlSession();
        UpdateUserInfoCase deleteUserInfo = sqlSession.selectOne("deleteUserInfoTest", 2);
        System.out.println(deleteUserInfo.toString());
        System.out.println(TestConfig.updateUserInfoUrl);
    }
}
