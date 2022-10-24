package sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author sytsnb@gmail.com
 * @date 2022 2022/10/24 21:27
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {9, 3, 7, 2, 5, 8, 1, 4};
        insert(arr);
    }

    private static void insert(int[] arr) {
        // i 代表待插入元素的索引
        for (int i = 1; i < arr.length; i++) {
            //代表待插入的元素值
            int t = arr[i];
            //代表已排序区域的元素索引
            int j = i - 1;
            while (j >= 0) {
                if (t < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    //退出循环,减少比较的次数
                    break;
                }
                j--;
            }
            arr[j + 1] = t;
            System.out.println(Arrays.toString(arr));
        }
    }
}
