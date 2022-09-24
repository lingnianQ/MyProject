package com.syt.jdbc;

import com.syt.util.JdbcUtil2;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;

import java.sql.Array;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * 查询数据（ArrayHandler()只会返回第一条记录）
 * @author sytsnb@gmail.com
 */

public class UtilsSelectArrayHandler {
    public static void main(String[] args) throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from t_stu where score>?";
        Connection conn = JdbcUtil2.getConnection();
        Object[] params = {80};
        Object[] objects = queryRunner.query(conn, sql, new ArrayHandler(), params);
        System.out.println(Arrays.toString(objects));
        System.out.println("\n");
        assert conn != null;
        conn.close();
    }
}
