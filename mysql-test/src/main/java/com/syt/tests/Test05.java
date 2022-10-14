package com.syt.tests;

/**
 * @author sytsnb@gmail.com
 * @date 2022 2022/10/14 19:24
 */
public class Test05 {
    public static void main(String[] args) {
        int num = 2018;
        int sum = 0;
        do {
            sum += num % 10;
            num /= 10;
        } while (num != 0);

        System.out.println(sum);
    }
}
