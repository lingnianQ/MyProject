package com.syt.jdbc;

import com.syt.entity.Student;
import com.syt.util.JdbcUtil2;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 查询数据（ColumnListHandler会返回结果中指定的列）
 * @author sytsnb@gmail.com
 */

public class UtilsSelectColumnListHandler {
    public static void main(String[] args) throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from t_stu where score > ?";
        Connection conn = JdbcUtil2.getConnection();
        Object[] params = {80};
        List<Object> name = queryRunner.query(conn, sql, new ColumnListHandler<>("name"), params);
        System.out.println(name);
        for (Object o : name) {
            System.out.println(o);
        }
        //关闭数据库连接
        conn.close();
    }
}
