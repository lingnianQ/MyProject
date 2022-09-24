package com.syt.jdbc;

import com.syt.util.JdbcUtil2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 调用JdbcUtil2类返回的数据库连接操作数据库
 * @author sytsnb@gmail.com
 */

public class LinkMysql2 {
    public static void main(String[] args) throws SQLException {
        Connection conn = JdbcUtil2.getConnection();

        String sql = "insert into t_stu(name,gender,grade,score) values(?,?,?,?)";

        PreparedStatement statement = conn.prepareCall(sql);
        statement.setString(1, "张三");
        statement.setInt(2, 0);
        statement.setInt(3, 2);
        statement.setInt(4, 87);

        int i = statement.executeUpdate();
        System.out.println(i);

        JdbcUtil2.closeResource(null, statement, conn);

    }
}
