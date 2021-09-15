package hut.io_.ex;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author: Penflyz
 * @time: 2021/8/19 15:20
 */
public class Ex01 {
    public static void main(String[] args) throws IOException {
        String dirPath = "d:\\myTemp";
        String filePath = "hello.txt";
        File file = new File(dirPath);
        System.out.println(file.exists());
        if (!file.exists()) {
            if (file.mkdirs()) {
                System.out.println("创建成功");
            } else {
                System.out.println("创建失败");
            }
        }

        File file1 = new File(dirPath, filePath);
        if (!file1.exists()) {
            file1.createNewFile();
            System.out.println("txt文件创建成功");
        }else {
            System.out.println("txt已经存在");
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file1));
        bufferedWriter.write("我是猪");
        bufferedWriter.close();
    }
}