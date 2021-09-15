package com.penfly;

import java.lang.reflect.Field;

/**
 * @author  Penflyz
 * @time  2021/9/1 15:39
 */
public class Ex01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class<?> aClass = Class.forName("com.penfly.PrivateTest");
        Object o = aClass.newInstance();
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(o, "zhu");
        System.out.println(name.get(o));
    }

}

class PrivateTest{
    private String name = "hellokitty";

    public String getName() {
        return name;
    }
}