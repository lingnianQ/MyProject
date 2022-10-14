package com.syt.tests;

/**
 * @author sytsnb@gmail.com
 * @date 2022 2022/10/14 19:49
 */
public class Test09 {
    public static void main(String[] args) {
        Koo koo = new Koo();
        System.out.println(koo);
    }
}

class Koo {
    static {
        System.out.print("static");
    }

    Koo() {
        System.out.print("Koo");
    }

    public String toString() {
        return "koo";
    }
}