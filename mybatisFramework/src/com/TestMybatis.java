package com;

import org.mybatis.configuration.XmlConfigParser;
import org.mybatis.executor.SqlSession;

import java.io.InputStream;

public class TestMybatis {
    public static void main(String[] args) throws Throwable{
        ClassLoader classLoader = TestMybatis.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("mybatis-config.xml");
        XmlConfigParser.parser(inputStream);

        SqlSession sqlSession = new SqlSession();
        Object proxyObject = sqlSession.getMapper(UserMapper.class);
        UserMapper userMapper= (UserMapper) proxyObject;
        userMapper.selectAll();

    }
}
