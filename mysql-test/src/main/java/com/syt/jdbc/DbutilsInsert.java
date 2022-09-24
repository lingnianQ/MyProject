package com.syt.jdbc;

import com.syt.util.JdbcUtil2;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author sytsnb@gmail.com
 */

public class DbutilsInsert {
    public static void main(String[] args) throws SQLException {
        //1.创建dbUtils里面的QueryRunner对象
        QueryRunner queryRunner = new QueryRunner();
        //2.sql语句
        String sql = "insert into t_stu(name,gender,grade,score) values(?,?,?,?)";
        //3.存参数值的数组
        Object[] objects = {"小红", 0, 2, 89};
        //4.获取数据库连接
        Connection conn = JdbcUtil2.getConnection();
        //5.执行sql语句，并返回影响的行数
        int update = queryRunner.update(conn, sql, objects);
        System.out.println(update);
        //6.关闭数据库连接
        assert conn != null;
        conn.close();
    }

}
