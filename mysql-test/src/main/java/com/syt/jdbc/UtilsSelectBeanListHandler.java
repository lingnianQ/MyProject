package com.syt.jdbc;

import com.syt.entity.Student;
import com.syt.util.JdbcUtil2;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 查询数据，并将查询数据转成实际对象（BeanListHandler会返回查询到的所有记录）
 * @author sytsnb@gmail.com
 */

public class UtilsSelectBeanListHandler {
    public static void main(String[] args) throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from t_stu where score > ?";
        Connection conn = JdbcUtil2.getConnection();
        Object[] params = {80};
        List<Student> list = queryRunner.query(conn, sql, new BeanListHandler<Student>(Student.class),params);
        for (Student student : list) {
            System.out.println(student);
        }
        conn.close();
    }
}
