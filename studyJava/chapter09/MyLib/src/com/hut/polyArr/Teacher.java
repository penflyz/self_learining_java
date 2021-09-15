package com.hut.polyArr;

public class Teacher extends Person{
    private int salary;

    public Teacher(String name, int age, int salary) {
        super(name, age);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String move(){
        return "正在上课...";
    }

    @Override
    public String say() {
        return super.say()+"工资是"+salary+"元";
    }


}
