package array;

/**
 * 二维数组
 *
 * @author sytsnb@gmail.com
 * @date 2022 2022/10/27 13:00
 */
public class ArrayDemo1 {
    public static void main(String[] args) {
        //静态初始化
        int[][] arr = {{2, 3}, {5, 3, 1, 6}, {1, 2, 4}};
        System.out.println(arr[1][2]);

        //动态初始化
        int[][] arr2 = new int[3][];

        arr2[0] = new int[2];
        System.out.println(arr2[0][1]);

        arr2[0] = new int[2];
        arr2[0][1] = 2;
        System.out.println(arr2[0][1]);

        System.out.println("----------");
        //遍历
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }
        System.out.println("----------");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }
}
