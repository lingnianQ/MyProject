package com.syt.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * mybatis 代理实现
 *
 * @author sytsnb@gmail.com
 * @date 2022 2022/11/15 19:54
 */
public class ProxyTest {
    public static void main(String[] args) {
        Object objectProxy = getProxy(UserMapper.class);
        UserMapper userMapper = (UserMapper) objectProxy;
        userMapper.selectAll();
    }

    /**
     * 创建一个代理对象
     *
     * @param clazz
     * @return
     */
    public static Object getProxy(Class clazz) {
        ClassLoader classLoader = clazz.getClassLoader();
        Class[] interfaces = {clazz};
        MapperProxy mapperProxy = new MapperProxy();
        Object proxyObject = Proxy.newProxyInstance(classLoader, interfaces, mapperProxy);
        return proxyObject;
    }

    static class MapperProxy implements InvocationHandler {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("连接数据库,执行sql");
            return null;
        }
    }

}
