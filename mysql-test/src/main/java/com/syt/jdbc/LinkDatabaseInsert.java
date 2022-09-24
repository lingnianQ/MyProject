package com.syt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 直接注册驱动，向数据库插入数据（不推荐使用）
 * https://www.cnblogs.com/dadian/p/11938707.html
 * @author sytsnb@gmail.com
 */

public class LinkDatabaseInsert {
    public static void main(String[] args) throws ClassNotFoundException {
        //1.注册数据库驱动
//        Class.forName("com.mysql.jdbc.Driver");//This is deprecated.
        Class.forName("com.mysql.cj.jdbc.Driver");
        // JDBC连接的URL, 不同数据库有不同的格式:
        String JDBC_URL = "jdbc:mysql://localhost:3306/test";
        String JDBC_USER = "root";
        String JDBC_PASSWORD = "root";
        //2.获取数据库连接（里面内容依次是："jdbc:mysql://主机名:端口号/数据库名","用户名","登录密码"）
        //try()---自动关闭特性
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);) {
            //3.需要执行的sql语句（?是占位符，代表一个参数）
            String sql = "insert into t_stu(name,gender,grade,score) values(?,?,?,?)";
            //4.获取预处理对象，并依次给参数赋值
            PreparedStatement statement = conn.prepareCall(sql);
//            statement.setInt(1, 11); //auto
            statement.setString(1, "小零");
            statement.setInt(2, 0);
            statement.setInt(3, 2);
            statement.setInt(4, 88);
            // TODO: 访问数据库...5.执行sql语句（执行了几条记录，就返回几）
            int i = statement.executeUpdate();
            System.out.println(i);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 关闭连接:
//        statement.close();
//        conn.close();
    }
}
