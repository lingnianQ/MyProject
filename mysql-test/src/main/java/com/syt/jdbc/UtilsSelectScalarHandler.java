package com.syt.jdbc;

import com.syt.util.JdbcUtil2;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 查询单数据（ScalarHandler返回分组函数的值）
 * @author sytsnb@gmail.com
 */

public class UtilsSelectScalarHandler {
    public static void main(String[] args) throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select max(score) from t_stu";
        Connection conn = JdbcUtil2.getConnection();
        Object[] params = {};
        int score = queryRunner.query(conn, sql, new ScalarHandler<>(), params);
        System.out.println(score);
        conn.close();
    }
}
