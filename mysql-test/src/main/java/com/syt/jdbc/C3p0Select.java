package com.syt.jdbc;

/**
 * @author sytsnb@gmail.com
 */

import com.syt.entity.Student;
import com.syt.util.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class C3p0Select {
    public static void main(String[] args) throws SQLException {
        //创建dbUtils里面的QueryRunner对象,并获取数据库连接
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        //sql语句
        String sql = "select * from t_stu where score>?";
        //存参数值的数组
        Object[] params = {16};
        //执行查询，并以数组的形式返回查询结果（new BeanListHandler()返回查询到的所有记录，并转成对象）
        List<Student> students = queryRunner.query(sql, new BeanListHandler<Student>(Student.class), params);
        System.out.println(students);
    }
}
