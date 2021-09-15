package com.hut.Test.Test05;

public class Student extends Person {

    private int stu_id;

    public Student(String name, String sex, int age, int stu_id) {
        super(name, sex, age);
        this.stu_id = stu_id;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public void study() {
        System.out.println("我好好学习");
    }

    public String play() {
        return this.getName() + "爱玩足球";
    }
}
