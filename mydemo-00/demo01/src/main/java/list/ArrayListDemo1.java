package list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sytsnb@gmail.com
 * @date 2022 2022/10/24 22:13
 */
public class ArrayListDemo1 {
    public static void main(String[] args) {

//        private static final int DEFAULT_CAPACITY = 10;
        ArrayList<Integer> list = new ArrayList<>();
        //.add()扩容机制, 首次扩容为10, 再次扩容为上次容量的1.5倍
        list.add(1);
        list.add(2);
        //.addAll扩容机制, 集合中无元素时 扩容为Math.max(10,实际元素个数)
        // Math.max(1.5倍容量,实际元素)
        List<Integer> list1 = new ArrayList<>();
        for (int i = 1; i <= 11; i++) {
            list1.add(i);
        }
        list.addAll(list1);
        System.out.println(list);

    }
}
