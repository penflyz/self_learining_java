package com.hut.exception_;

import java.util.Scanner;

public class Exception01 {
    public static void main(String[] args) {
        int num;
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入一组数字：");
            String  inputNum = scanner.next();

            try {
                num = Integer.parseInt(inputNum);
                break;
            } catch (NumberFormatException e) {
                System.out.println("你是猪吗？这输入的是个数字？");
            }

        }

        System.out.println("你输入的数字是"+num);
    }
}

