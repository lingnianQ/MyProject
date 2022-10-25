package list;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author sytsnb@gmail.com
 * @date 2022 2022/10/25 11:05
 */
public class FailFastVsFailSafe {
    public static void main(String[] args) {
        failFast();
//        failSafe();
    }


    private static void failFast() {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("A"));
        list.add(new Student("B"));
        list.add(new Student("C"));
        list.add(new Student("D"));
        for (Student student : list) {
            System.out.println("student = " + student);
        }
        System.out.println("list = " + list);
    }

    private static void failSafe() {
        CopyOnWriteArrayList<Student> list = new CopyOnWriteArrayList<>();
        list.add(new Student("A"));
        list.add(new Student("B"));
        list.add(new Student("C"));
        list.add(new Student("D"));
        for (Student student : list) {
            System.out.println("student = " + student);
        }
        System.out.println("list = " + list);
    }

    static class Student {
        public Student(String name) {
            this.name = name;
        }
        String name;

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
