package com.hut.stringbuffer;

import java.util.Scanner;

public class Exercise01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数字");
        String str = scanner.next();
        StringBuffer stringBuffer = new StringBuffer(str);

        StrProcess2.way(stringBuffer);
        System.out.println(stringBuffer);

        System.out.println(8/3);
    }
}
//  8    01,234,567


class StrProcess{
    public static void way(StringBuffer sb){
        int first_index = sb.length()%3;
        sb.insert(first_index,",");
        for (int i = 1 ; i < sb.length()/3; i++ ){

            sb.insert(first_index+(4*i),",");
            }

        }
    }

class StrProcess2{
    public static void way(StringBuffer sb){
        for (int i = sb.length(); i >0; i -= 3) {
            if (i != sb.length()) {
                sb.insert(i, ",");
            }
        }
    }
}