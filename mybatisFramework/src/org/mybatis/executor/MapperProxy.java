package org.mybatis.executor;

import org.mybatis.configuration.Configuration;
import org.mybatis.configuration.SqlMapper;
import org.mybatis.configuration.XmlConfigParser;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;

public class MapperProxy implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke:" + method.getName());
        ArrayList<Object> list = new ArrayList<>();
        //1,根据method得到select的id
        String methodName = method.getName();
        String interfaceName = method.getDeclaringClass().getName();
        String id = interfaceName + "." + methodName;

        //2,得到driver,url,username,password
        Configuration configuration = XmlConfigParser.configuration;
        String driver = configuration.getDriver();
        String url = configuration.getUrl();
        String username = configuration.getUsername();
        String password = configuration.getPassword();
        //3,建立连接
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, username, password);
        //4,得到sql
        SqlMapper sqlMapper = configuration.getSqlMappers().get(id);
        String sql = sqlMapper.getSql();
        //5,执行sql
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        //6,遍历结果集
        int row = 0;
        while (resultSet.next()) {
            row++;
            System.out.println(row);
            //6.1 创建实体类
            String resultType = sqlMapper.getResultType();
            Class<?> clazz = Class.forName(resultType);//com.User
            Object entity = clazz.newInstance();
            System.out.println(entity.toString());
            //6.2 给实体类属性赋值
            //6.2.1得到所有列
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            //6.2.2 遍历列
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                String columnName = metaData.getColumnName(columnIndex);
                Object dbValue = resultSet.getObject(columnName);
                System.out.println(columnName + "=" + dbValue);

                //根据列名创建类的属性
                Field field = clazz.getDeclaredField(columnName);
                field.setAccessible(true);//变成可访问的
                //entity.field=dbValue
                field.set(entity, dbValue);
            }
            System.out.println(entity);

            //6.3把实体类放到集合中
            list.add(entity);
        }
        //7,返回list
        return list;
    }
}
