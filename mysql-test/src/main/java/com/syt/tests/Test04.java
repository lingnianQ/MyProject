package com.syt.tests;

/**
 * @author sytsnb@gmail.com
 * @date 2022 2022/10/14 19:19
 */
public class Test04 {
    public static void main(String[] args) {
        Person person = new Student("Tom", 10);
        System.out.println(person);
    }

}

class Person {
    String name;
    public String toString() {
        return name;
    }
}

class Student extends Person {
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return name + age;
    }
}