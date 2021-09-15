package com.penfly.utils;

import com.penfly.common.Message;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author  Penflyz
 * @time  2021/8/30 22:44
 */
public class Draft {
    public static void main(String[] args) {
        ConcurrentHashMap<String, ArrayList<Dog>> offLineDB = new ConcurrentHashMap<>();
        ArrayList<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog(1));
        offLineDB.put("1",dogs);
        offLineDB.put("2",dogs);
        offLineDB.put("4",dogs);
        ConcurrentHashMap.KeySetView<String, ArrayList<Dog>> strings = offLineDB.keySet();
        System.out.println(strings);

    }
}

class Dog{
    private int age;

    public Dog(int age) {
        this.age = age;
    }
}