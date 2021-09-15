package com.hut.homework;

import com.sun.xml.internal.ws.policy.privateutil.RuntimePolicyUtilsException;

import java.awt.*;

public class HomeWork05 {
    public static void main(String[] args) {
        try {
            useMessage("124","456122","7890@qqco.m");
            System.out.println("注册成功");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void useMessage(String name, String pwd, String email) {

        //第一步
        int nameLength = name.length();
        if (!(nameLength >= 2 && nameLength <= 4)) {
            throw new RuntimeException("用户名必须在2-4之间");
        }
        //第二步
        if (!(pwd.length() == 6 && isDigital(pwd))) {
            throw new RuntimeException("用户密码必须为6位且全部为数字");
        }
        //第三步
        if (!(haveAt(email) && atLocation(email))){
            throw new RuntimeException("一定要包含@，且@一定要在“.”前面。");
        }



    }

    public static boolean isDigital(String pwd) {
        char[] chars = pwd.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') {
                return false;
            }
        }
        return true;
    }

    public static boolean haveAt(String email){
        return email.indexOf("@") > 0?true:false;
    }

    public static boolean atLocation(String email){
        if (email.indexOf("@") - email.indexOf(".") <0){
            return true;
        }else {
            return false;
        }
    }
}


