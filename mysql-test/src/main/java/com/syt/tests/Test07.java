package com.syt.tests;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sytsnb@gmail.com
 * @date 2022 2022/10/14 19:32
 */
public class Test07 {

    public Test07() {
    }

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "T");
        map.put(1, "J");
        map.put(2, "A");
        map.put(3, "H");
        map.put(3, "N");
        System.out.println(map.size());

        //不能强制回收,java关于内存的处理,Java自己处理,不需要你来执行,
        //当创建了一个对象时,没有引用指向这个对象的时候,java自己把这个没有引用的对象回收了
        System.gc();
    }
}
