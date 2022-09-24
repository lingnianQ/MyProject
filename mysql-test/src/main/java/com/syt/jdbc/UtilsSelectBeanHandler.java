package com.syt.jdbc;

import com.syt.entity.Student;
import com.syt.util.JdbcUtil2;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 查询数据，并将查询数据转成实际对象（BeanHandler只会返回第一条记录）
 * @author sytsnb@gmail.com
 */

public class UtilsSelectBeanHandler {
    public static void main(String[] args) throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from t_stu where score > ?";
        Connection conn = JdbcUtil2.getConnection();
        Object[] params = {80};
        Student student = queryRunner.query(conn, sql, new BeanHandler<Student>(Student.class),params);
        System.out.println(student);
        assert conn != null;
        conn.close();
    }

}
