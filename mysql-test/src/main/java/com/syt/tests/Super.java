package com.syt.tests;

/**
 * @author sytsnb@gmail.com
 * @date 2022 2022/10/14 19:45
 */
public class Super {
    public static void main(String[] args) {
        Super s = new Super();
        s.test();
    }

    void test() {
        System.out.println("Super.test");
    }

}

class Sub extends Super {
    void test() {
        System.out.println("Sub.test");
    }
}
