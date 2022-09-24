package com.syt.jdbc;

import com.syt.util.JdbcUtil2;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * 查询数据（ArrayListHandler()会返回所有查询到的记录）
 * @author sytsnb@gmail.com
 */

public class UtilsSelectArrayListHandler {
    public static void main(String[] args) throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from t_stu where score > ?";
        Connection conn = JdbcUtil2.getConnection();
        Object[] params = {80};
        List<Object[]> list = queryRunner.query(conn, sql, new ArrayListHandler(), params);
        for (Object[] objects : list) {
            System.out.println(Arrays.toString(objects));
        }
    }
}
