package list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sytsnb@gmail.com
 * @date 2022 2022/10/24 22:13
 */
public class ArrayListDemo1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        //.add()扩容机制,  1.5倍
        list.add(1);
        list.add(2);
        //.addAll扩容机制,  1.5倍容量与实际容量选择较大值
        List<Integer> list1 = new ArrayList<>();
        for (int i = 1; i <= 11; i++) {
            list1.add(i);
        }
        list.addAll(list1);
        System.out.println(list);

    }
}
