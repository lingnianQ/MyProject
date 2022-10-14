package com.syt.tests;

/**
 * @author sytsnb@gmail.com
 * @date 2022 2022/10/14 19:03
 */
public class Test01 {
    public static void main(String[] args) {
        int i = 1;
        while (i++ <= 2 && f()) {
            System.out.print("inte");
        }
    }

    static boolean f() {
        System.out.print("Cod is");
        return true;
    }
}
