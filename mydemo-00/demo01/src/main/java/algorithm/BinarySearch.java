package algorithm;

import java.util.Arrays;

/**
 * 二分查找
 *
 * @author sytsnb@gmail.com
 * @date 2022 2022/10/24 8:22
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {12, 45, 71, 80, 90, 100, 105, 154, 164, 169, 180};
        Arrays.sort(arr);
        //    参考Arrays.binarySearch()
        BinarySearch binarySearch = new BinarySearch();
        int i = binarySearch.search(arr, 80);
        System.out.println("i = " + i);
    }


    public int search(int[] arr, int t) {
        int l = 0, r = arr.length - 1, m;
        while (l <= r) {
            //无符号右移--防止边界溢出
            m = (l + r) >>> 1;
            //或者因式分解
            //m = l - (l / 2 - r / 2);
            if (arr[m] == t) {
                return m;
            }
            if (arr[m] < t) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

}
