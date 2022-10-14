package com.syt.tests;

/**
 * @author sytsnb@gmail.com
 * @date 2022 2022/10/14 19:39
 */
public class Test08 {
    public static void main(String[] args) {
        String str = "abc 123";
        boolean matches = str.matches("[a-z]+\\s\\d+");
        System.out.println("matches = " + matches);
    }
}
