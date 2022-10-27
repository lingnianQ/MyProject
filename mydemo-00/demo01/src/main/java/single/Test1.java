package single;

/**
 * n的平方和递归
 *
 * @author sytsnb@gmail.com
 * @date 2022 2022/10/27 23:39
 */
public class Test1 {
    public static void main(String[] args) {

        System.out.println(f(2));
    }

    public static int f(int n) {

        if (n == 1) {
            return 1;
        }
        return n * n + f(n - 1);
    }
}
