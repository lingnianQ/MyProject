package interview;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 2.用java语言统计任一磁盘目录下文件夹总数、文件总数，
 * 并打印文件名存在3个以上重复字母的文件路径，考虑性能最优的处理逻辑
 *
 * @author sytsnb@gmail.com
 * @date 2022 2022/11/3 2:57
 */
public class Watch02 {
    /**
     * 文件夹目录
     */
    File root;
    /**
     * 文件列表
     */
    ArrayList<File> fileList;
    /**
     * 文件夹数量
     */
    long directoryCount = 0;


    Watch02(String filePath) {
        root = new File(filePath);
        fileList = new ArrayList<>();
    }

    public static void main(String[] args) {
//        String filePath = "F:\\";
//        String filePath = "F:\\parent-springcould";
        String filePath = "F:\\test1";

        Watch02 watch02 = new Watch02(filePath);
        watch02.searchDirectoryCount();
        watch02.test();
        System.out.println("文件总数:" + watch02.fileList.size());
        System.out.println("文件夹总数: " + watch02.directoryCount);
    }

    /**
     * 查找文件夹总数与文件总数
     */
    public void searchDirectoryCount() {

        File[] directory = root.listFiles();

//        for (File file : directory) {
//            System.out.println(file);
//        }
        for (File listFile : directory) {
            if (!listFile.isDirectory()) {
                //文件列表
                fileList.add(listFile);
            } else {
                root = listFile;
                directoryCount++;
                searchDirectoryCount();
            }
        }
    }

    public void test() {
        for (File file : fileList) {
            Set<Character> characterSet = new HashSet<>();
            String fileName = file.getName().split("\\.")[0];

            char[] charArray = fileName.toCharArray();
            for (char c : charArray) {
                characterSet.add(c);
            }
            if (fileName.length() - characterSet.size() >= 3) {
                System.out.println(file.getAbsolutePath());
            }
        }
    }

}
