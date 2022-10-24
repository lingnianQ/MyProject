package sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 及其优化
 *
 * @author sytsnb@gmail.com
 * @date 2022 2022/10/24 15:06
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 7, 4, 1, 3, 8, 9};
//        int[] arr = {1, 2, 3, 4, 5, 7, 8, 9};
//        bubble(arr);
        bubbleV2(arr);
    }

    public static void bubbleV2(int[] arr) {
        int n = arr.length - 1;
        do {
            //表示最后一次交换索引位置
            int last = 0;
            for (int j = 0; j < n; j++) {
                System.out.println("比较次数:" + j);
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    last = j;
                }
            }
            //最后一次交换位置索引
            n = last;
            System.out.println("第" + "轮冒泡:" + Arrays.toString(arr));
        } while (n != 0);
    }


    public static void bubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {

            boolean swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                System.out.println("比较次数:" + j);
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            System.out.println("第" + i + "轮冒泡:" + Arrays.toString(arr));
            if (!swapped) {
                break;
            }
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
