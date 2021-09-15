package hut.io_;


import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author: Penflyz
 * @time: 2021/8/18 18:54
 */
public class FileInputStream_ {
    public static void main(String[] args) {

    }
    @Test
    public void run(){
        int read;
        FileInputStream fileInputStream  =  null ;

        byte[] b =new byte[9];
        String filePath = "D:\\a1.txt";
        File file = new File(filePath);
        try {
            file.createNewFile();
            System.out.println("创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            fileInputStream = new FileInputStream(filePath);
            while ((read = fileInputStream.read(b))!= -1){
                System.out.println(new String(b,0,read));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
