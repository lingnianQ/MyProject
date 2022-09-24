package com.syt.jdbc;

import com.syt.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 调用JdbcUtil类返回的数据库连接操作数据库
 * @author sytsnb@gmail.com
 */

public class LinkMysql {
    public static void main(String[] args) throws SQLException {
        //1.获取数据库连接
        Connection connection = JdbcUtil.getConnection();

        //2.需要执行的sql语句
        String sql = "insert into t_stu(name,gender,grade,score) values(?,?,?,?)";
        //3.获取预处理对象，并给参数赋值
        PreparedStatement statement = connection.prepareCall(sql);
        statement.setString(1, "小王");
        statement.setInt(2, 1);
        statement.setInt(3, 2);
        statement.setInt(4, 67);
        //4.执行sql语句
        int i = statement.executeUpdate();
        System.out.println(i);
        //5.关闭jdbc连接
        statement.close();
        connection.close();
    }
}
