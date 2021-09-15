package hut.io_.ex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author: Penflyz
 * @time: 2021/8/21 18:26
 */
public class Ex02 {
    public static void main(String[] args) {
        String filePath = "d:\\myTemp\\myRecord.txt";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            System.out.println(bufferedReader.readLine());
            System.out.println(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

    }
}