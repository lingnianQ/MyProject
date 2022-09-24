package com.syt.util;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * ResourceBundle 类获取db.properties文件信息，最后返回数据库连接
 * @author sytsnb@gmail.com
 */

public class JdbcUtil2 {
    //私有变量
    private static String driver;
    private static String url;
    private static String user;
    private static String password;

    static {
        try {
            ResourceBundle db = ResourceBundle.getBundle("db");
            driver = db.getString("driver");
            url = db.getString("url");
            user = db.getString("user");
            password = db.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //关闭结果集
    public static void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //关闭预处理对象
    public static void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //关闭数据库连接
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //一次关闭三个
    public static void closeResource(ResultSet resultSet, Statement statement, Connection connection) {
        closeResultSet(resultSet);
        closeStatement(statement);
        closeConnection(connection);
    }

}
