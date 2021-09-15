package com.hut.enum_;

import javax.sound.midi.SoundbankResource;

public class Enum01 {
    public static void main(String[] args) {
        person pig = person.PIG;
        System.out.println(pig);
    }
}

enum person{
    PIG(1,2),DOG(3,4);
    int a;
    int b;

    person(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}