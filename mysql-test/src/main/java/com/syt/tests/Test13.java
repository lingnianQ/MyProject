package com.syt.tests;

import java.util.*;
import java.util.stream.Stream;

/**
 * 遍历Map集合方式
 *
 * @author sytsnb@gmail.com
 * @date 2022 2022/10/14 20:20
 */
public class Test13 {
    public static void main(String[] args) {

        Map<Object, Object> map = new HashMap<>();
        map.put(1, "123");
        map.put(2, "456");
        map.put(3, "789");
        System.out.println("map.size() =" + map.size());

        System.out.println("====通过Map.keySet遍历key和value===========================");
        //1.通过Map.keySet遍历key和value
        for (Object key : map.keySet()) {
            Object value = map.get(key);
            System.out.println(key + " = " + value);
        }

        System.out.println("==通过Map.entrySet,,,forEach===========================");
        Set<Map.Entry<Object, Object>> entries = map.entrySet();
        //2.Set通过Map.entrySet,,,forEach
        entries.forEach(System.out::println);

        System.out.println("==通过Map.entrySet使用iterator遍历key和value=========================");
        //3.通过Map.entrySet使用iterator遍历key和value
        Iterator<Map.Entry<Object, Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Object, Object> entry = iterator.next();
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

        System.out.println("==Map.entrySet使用iterator遍历key和value..===推荐,尤其是容量大时========================");
        //4.Map.entrySet使用iterator遍历key和value..===推荐,尤其是容量大时
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

        for (Object value : map.values()) {
            System.out.println("value = " + value);
        }

    }
}
