package com.hut.polyArr;

public class Student extends Person{
    private int score;

    public Student(String name, int age, int score) {
        super(name, age);
        this.score = score;
    }

    public String say(){
        return super.say()+"考了"+score+"分";
    }

    public String action(){
        return "正在被上课";
    }
}
