package com.hut.encap;

import java.util.Scanner;

public class encap01 {
    public static void main(String[] args) {
        //不用构造器
//        Person person = new Person();
//        person.setName("tomSon");
//        person.setAge(180);
//        person.setSalary(5000);

        Person person = new Person("tomSon",180,5000);
        person.readMessage();
//        System.out.println(person.getAge());

    }
}

class Person {
    public String name;
    private int age;
    private int salary;

    public Person(String name, int age, int salary) {
        setSalary(salary);
        setAge(age);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0 && age <= 100) {
            this.age = age;
        } else {
            System.out.println("你输入的年龄超出范围，请重新输入");
            do {
                Scanner scanner = new Scanner(System.in);
                age = scanner.nextInt();
                if (age >= 0 && age <= 100) {
                    this.age = age;
                    break;
                }
                System.out.println("你输入的年龄超出范围，请重新输入");
            } while (true);
        }
    }

    public String getSalary() {
//        return salary;
        return "salary无权限查看";
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void readMessage() {
        System.out.println(getName() + "\t" + getAge() + "\t" + getSalary());
    }
}
