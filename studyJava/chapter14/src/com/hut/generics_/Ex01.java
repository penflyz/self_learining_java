package com.hut.generics_;

import java.util.HashSet;

public class Ex01 {
    public static void main(String[] args) {
        HashSet<Student> students = new HashSet<Student>();

    }
}

class Student{
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}