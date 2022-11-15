package com.syt.tests;

import java.lang.reflect.Proxy;
import java.util.*;

/**
 * @author sytsnb@gmail.com
 * @date 2022 2022/11/14 19:31
 */
public class Test14 {
    public static void main(String[] args) {


        int i = 123442;

        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = new int[arr1.length];
        int[] arr3 = new int[arr1.length];
        for (int j = 0, k = 0, g = 0; j < arr1.length; j++) {
            if (arr1[j] % 2 == 0) {
                k++;
                arr2[k] = arr1[j];
            } else {
                arr3[g] = arr1[j];
                g++;
            }
        }
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));

//        Proxy.newProxyInstance()

//        final int[] arr = {2, 3, 4};
        //
//        arr[1] = 10;


//
//        List<String> list = new ArrayList<>();
//        list.add("tom");
//        list.add(0, "qwe");
//        list.add(0, "qwe");
//        list.add(0, "qwe");
//        System.out.println(list.size());

//        System.out.println(arr[1]);

//        System.out.println(~55);
//        int i = 1;
//        while (i++ <= 2 || f()) {
//            System.out.print("interesing");
//        }
    }

    static boolean f() {
        System.out.print("coding is");
        return false;
    }
}
