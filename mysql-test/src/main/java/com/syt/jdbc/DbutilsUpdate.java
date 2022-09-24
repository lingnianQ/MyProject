package com.syt.jdbc;

import com.syt.util.JdbcUtil2;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author sytsnb@gmail.com
 */

public class DbutilsUpdate {
    public static void main(String[] args) throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "update t_stu set name=? where id=?";
        Object[] objects = {"零念", 16};
        Connection conn = JdbcUtil2.getConnection();
        int update = queryRunner.update(conn, sql, objects);
        System.out.println(update);
        conn.close();
    }
}
