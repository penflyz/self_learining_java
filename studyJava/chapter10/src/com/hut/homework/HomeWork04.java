package com.hut.homework;

public class HomeWork04 {
    public static void main(String[] args) {
        String str = "123456789";

        try {
            str = StrReverse.reverse(str, 2, 10);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println(str);
    }

}

class StrReverse{
    public static String reverse(String str , int start ,int end){

        if (!(start < end && end<str.length() && start >= 0)){
            throw new RuntimeException("所取范围异常");
        }


        char[] chars = str.toCharArray();
        char temp = ' ';
        for (int i = start ,y = end; i < y; i++ , y--) {
            temp = chars[i];
            chars[i] = chars [y];
            chars[y] = temp;
        }
        return new String(chars);
    }

}
