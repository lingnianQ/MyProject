package interview;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * 1.	D盘下有一个文件，内容包含ABCDEF，用java语言实现方法，满足
 * a.	传入的字符判断是否在文件中，尽可能减少磁盘IO交互
 * b.	控制调用频次，同一参数的方法调用每分钟不超过1000次
 *
 * @author sytsnb@gmail.com
 * @date 2022 2022/11/3 2:19
 */
public class Watch01 {
    public static void main(String[] args) throws IOException {
        String filePath = "F:\\test1\\123.txt";
        char suffix = 'A';
        getParams(filePath, suffix);
    }

    public static void getParams(String filePath, char suffix) throws IOException {
        //1.判断出现的次数
        int num = 0;
        //2.定义文件
        File file = new File(filePath);
        Path path = Paths.get(file.getPath());
        //3.读取字节码
        byte[] bytes = Files.readAllBytes(path);
        for (byte aByte : bytes) {
            if (aByte == suffix) {
                num++;
            }
        }
        if (num != 0) {
            System.out.println("字符: " + suffix + " 出现了" + ": num = " + num + "次");
            return;
        }
        System.out.println("filePath = " + filePath + "--==不存在该字符: " + suffix);
    }

}
