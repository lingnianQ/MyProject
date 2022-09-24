package com.syt.jdbc;

import com.syt.util.JdbcUtil2;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author sytsnb@gmail.com
 */

public class DbutilsDelete {
    public static void main(String[] args) throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "delete from t_stu where id = ?";
        Object[] objects = {14};
        Connection conn = JdbcUtil2.getConnection();
        int update = queryRunner.update(conn, sql, objects);
        System.out.println(update);
        assert conn != null;
        conn.close();
    }
}
