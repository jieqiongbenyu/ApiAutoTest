package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.AddUserCase;
import com.course.utils.DataBaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddUserTest {

    @Test(dependsOnGroups = "LoginTrue", description = "增加用户信息")
    public void addUser() throws IOException {
        SqlSession sqlSession = DataBaseUtil.getSqlSession();
        AddUserCase addUserCase = sqlSession.selectOne("addUserTest", 1 );
        System.out.println(addUserCase.toString());
        System.out.println(TestConfig.addUseUrl);
    }
}
