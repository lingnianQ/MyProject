package com.syt.tests;

/**
 * @author sytsnb@gmail.com
 * @date 2022 2022/10/14 19:57
 */
public class Test11 {

    public static void main(String[] args) {
        int sum = 1;
        for (int i = 0; i < 10; i += 2) {
            sum += i;
        }
        System.out.println("sum = " + sum);
    }
}
