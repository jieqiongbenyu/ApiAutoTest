package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.GetUserListCase;
import com.course.utils.DataBaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetUserInfoListTest {

    @Test(dependsOnGroups = "LoginTrue", description = "获取性别为男的用户信息列表")
    public void getUserInfoList() throws IOException {
        SqlSession sqlSession = DataBaseUtil.getSqlSession();
        GetUserListCase getUserInfo = sqlSession.selectOne("getUserInfoListTest", 0);
        System.out.println(getUserInfo.toString());
        System.out.println(TestConfig.getUserListUrl);
    }
}
