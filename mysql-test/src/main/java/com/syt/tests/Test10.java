package com.syt.tests;

/**
 * @author sytsnb@gmail.com
 * @date 2022 2022/10/14 19:54
 */
public class Test10 {
    public static void main(String[] args) {
        Foo foo = new Foo();
        foo.test(127);
    }
}

class Foo {
    void test(byte a) {
        System.out.println("byte");
    }

    void test(int... a) {
        System.out.println("int...");
    }

    void test(short a) {
        System.out.println("short");
    }

    void test(long a) {
        System.out.println("long");
    }
}
