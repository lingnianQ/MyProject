package algorithm;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author sytsnb@gmail.com
 * @date 2022 2022/10/24 18:35
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 7, 2, 1, 9, 8, 4};
        selection(arr);
    }

    private static void selection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // i 代表每轮最小元素,交换到目标索引
            int s = i;
            for (int j = s + 1; j < arr.length; j++) {
                if (arr[s] > arr[j]) {
                    s = j;
                }
            }
            //在每轮结束时进行交换
            if (s != i) {
                swap(arr, s, i);
            }
            System.out.println(Arrays.toString(arr));
        }
    }


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
